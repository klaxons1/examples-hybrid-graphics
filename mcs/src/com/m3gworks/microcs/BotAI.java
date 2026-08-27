package com.m3gworks.microcs;

public class BotAI extends EnemyAI {

    // Константы для состояний игры
    private static final int GAME_STATE_ACTIVE = 2;

    // Константы для действий бота
    private static final int ACTION_ATTACK = 0;
    private static final int ACTION_MOVE = 1;
    private static final int ACTION_LOOK_AROUND = 2;
    private static final int ACTION_MOVE_RANDOM = 3;

    // Константы для типов оружия
    private static final int WEAPON_TYPE_RIFLE = 10;
    private static final int WEAPON_TYPE_SNIPER = 11;
    private static final int WEAPON_TYPE_PISTOL = 20;

    public final void updateBotAI(GameEntity botEntity) {
        PlayerCharacter bot = (PlayerCharacter)botEntity;

        // Проверяем, жив ли бот
        if (bot.isAnimationFinished()) {
            handleLivingBot(bot);
        } else {
            handleDeadBot(bot);
        }
    }

    private void handleLivingBot(PlayerCharacter bot) {
        // Если бот мертв, выходим
        if (bot.health <= 0) {
            return;
        }

        // Выбираем случайное действие (0-3)
        int action = Randomizer.random.nextInt(4);

        // Обрабатываем движение
        if (bot.canMove) {
            bot.canMove = false;
            if (action != ACTION_ATTACK && isGameActive()) {
                executeAttackAction(bot, action);
                return;
            }
        }
        // Обрабатываем стрельбу
        else if (bot.canShoot) {
            bot.canShoot = false;
            if (isGameActive() && (action == ACTION_ATTACK || action == ACTION_LOOK_AROUND)) {
                bot.fireWeapon();
                return;
            }
        }
        // Обрабатываем другие действия
        else {
            if (action <= ACTION_MOVE) {
                if (!isPlayerSeeingBot(bot) && isGameActive()) {
                    executeAttackAction(bot, action);
                    return;
                }
            } else if (action == ACTION_LOOK_AROUND) {
                randomLookAround((BotCharacter)bot);
                return;
            } else {
                moveOrTurn((BotCharacter)bot);
                return;
            }
        }

        // Действие по умолчанию
        moveOrTurn((BotCharacter)bot);
    }

    private void handleDeadBot(PlayerCharacter bot) {
        int botState = bot.botState;

        // Если бот в одном из активных состояний, меняем состояние
        if (botState == 1 || botState == 2 || botState == 3 || botState == 4) {
            bot.changeState();
        }

        bot.updateAnimation();
    }

    private boolean executeAttackAction(GameEntity bot, int actionType) {
        ChooseTeam botWithWeapon = (ChooseTeam)bot;

        // Прицеливаемся в игрока
        aimAtPlayer(bot);

        // Выполняем движение в зависимости от типа действия
        if (actionType == ACTION_MOVE) {
            bot.moveForward(0.1F);
        } else {
            bot.strafe(0.3F);
        }

        // Воспроизводим звук выстрела
        playWeaponSound(botWithWeapon);

        // Стреляем
        botWithWeapon.fireWeapon();
        return true;
    }

    private void playWeaponSound(ChooseTeam bot) {
        if (!GameCanvas.getInstance().soundEnabled) {
            return;
        }

        int weaponType = bot.getWeaponShop().getCurrentWeapon().weaponType;
        SoundManager soundManager = SoundManager.getInstance();

        if (weaponType == WEAPON_TYPE_RIFLE) {
            soundManager.sub_5e(1);
        } else if (weaponType == WEAPON_TYPE_SNIPER) {
            soundManager.sub_5e(2);
        } else if (weaponType == WEAPON_TYPE_PISTOL) {
            soundManager.sub_5e(3);
        }
    }

    private static void aimAtPlayer(GameEntity bot) {
        GameEntity player = GameEntityManager.getInstance().localPlayer;

        // Получаем позиции бота и игрока
        float[] botPosition = bot.getPosition();
        float[] playerPosition = player.getPosition();

        // Вычисляем вектор направления к игроку
        float[] directionToPlayer = new float[]{
                playerPosition[0] - botPosition[0],
                0.0F,
                playerPosition[2] - botPosition[2]
        };

        // Получаем текущее направление взгляда бота
        float[] botForward = bot.getForwardVector(1, 3.0F);

        // Вычисляем угол между текущим направлением и направлением к игроку
        float dotProduct = MathUtils.dotProduct(botForward, directionToPlayer);
        float botForwardLength = (float)Math.sqrt(
                (double)(botForward[0] * botForward[0] +
                        botForward[1] * botForward[1] +
                        botForward[2] * botForward[2])
        );
        float directionLength = (float)Math.sqrt(
                (double)(directionToPlayer[0] * directionToPlayer[0] +
                        directionToPlayer[1] * directionToPlayer[1] +
                        directionToPlayer[2] * directionToPlayer[2])
        );

        float angle = (float)Math.toDegrees(
                (double)MathUtilsArcSin.asin(
                        (double)(dotProduct / (botForwardLength * directionLength))
                )
        );

        // Определяем направление поворота
        float[] crossProduct = MathUtils.crossProduct(botForward, directionToPlayer);
        if (crossProduct[1] < 0.0F) {
            bot.turnLeft(angle);
        } else {
            bot.turnRight(angle);
        }
    }

    private static void randomLookAround(BotCharacter bot) {
        int randomAngle = Randomizer.random.nextInt(25);

        // Случайно выбираем направление поворота
        if (randomAngle % 2 == 0) {
            bot.turnRight((float)randomAngle);
        } else {
            bot.turnLeft((float)randomAngle);
        }
    }

    private static void moveOrTurn(BotCharacter bot) {
        // Получаем вектор движения вперед
        float[] moveDirection = bot.getForwardVector(1, 3.0F);

        // Проверяем коллизии по направлению движения
        BoundingSphere futurePosition = bot.getFutureBoundingSphere(moveDirection);
        float[] movementResult = bot.checkMovement(moveDirection);

        // Если нет игроков на пути и движение возможно, двигаемся
        boolean noPlayersInWay = bot.findEntityInRadius(futurePosition) == null;
        boolean movementPossible =
                movementResult[0] == moveDirection[0] &&
                        movementResult[1] == moveDirection[1] &&
                        movementResult[2] == moveDirection[2];

        if (noPlayersInWay && movementPossible) {
            bot.applyMovement(1, movementResult);
        } else {
            // Иначе поворачиваем в случайном направлении
            if (Randomizer.random.nextInt(2) == 0) {
                bot.turnRight(70.0F);
            } else {
                bot.turnLeft(70.0F);
            }
        }
    }

    // Вспомогательные методы
    private boolean isGameActive() {
        return GameRoundManager.getInstance().gameState == GAME_STATE_ACTIVE;
    }

    private boolean isPlayerSeeingBot(GameEntity bot) {
        return GameEntityManager.getInstance().localPlayer.hasLineOfSight(bot);
    }
}