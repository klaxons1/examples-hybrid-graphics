package com.m3gworks.microcs;

public class GameHandlerInput extends InputManager {
    // Константы для кодов клавиш
    private static final int KEY_NUM0 = 48;
    private static final int KEY_NUM1 = 49;
    private static final int KEY_NUM2 = 50;
    private static final int KEY_NUM3 = 51;
    private static final int KEY_NUM4 = 52;
    private static final int KEY_NUM5 = 53;
    private static final int KEY_NUM6 = 54;
    private static final int KEY_NUM7 = 55;
    private static final int KEY_NUM8 = 56;
    private static final int KEY_NUM9 = 57;
    private static final int KEY_POUND = 35;
    private static final int KEY_STAR = 42;
    private static final int SOFT_KEY_MENU = -11;

    // Константы для действий игрока
    private static final int ACTION_FIRE = 0;
    private static final int ACTION_MOVE_FORWARD = 1;
    private static final int ACTION_MOVE_BACKWARD = 2;
    private static final int ACTION_STRAFE_LEFT = 7;
    private static final int ACTION_STRAFE_RIGHT = 8;
    private static final int ACTION_MENU = -1;

    // Константы для состояний игры
    private static final int GAME_STATE_READY = 2;

    public final void keyPressed(int var1, GameCanvas3D var2) {
        GameEntity var3 = GameEntityManager.getInstance().localPlayer;
        int var4 = GameRoundManager.getInstance().gameState;

        // Обработка ввода когда активно меню
        if (MenuSystem.getInstance().isMenuVisible) {
            handleMenuInput(var1, var2);
            return;
        }

        // Обработка игрового ввода
        handleGameInput(var1, var2, var3, var4);
    }

    private void handleMenuInput(int var1, GameCanvas3D var2) {
        if (var1 == KEY_POUND || var1 == SOFT_KEY_MENU) {
            MenuSystem.getInstance().hideMenu();
            return;
        }

        if (var1 == KEY_NUM0 && MenuSystem.getInstance().isMenuVisible && MenuSystem.getInstance().currentMenuState == 1) {
            MenuSystem.getInstance().hideMenu();
            return;
        }

        int var16 = var2.getGameAction(var1);
        MenuSystem.getInstance().handleInput(var1, var16);
    }

    private void handleGameInput(int var1, GameCanvas3D var2, GameEntity var3, int var4) {
        InputHandler var5 = InputHandler.sub_5f();

        // Обработка движения только в состоянии готовности
        if (var4 == GAME_STATE_READY) {
            handleMovementInput(var1, var2, var5);
        }

        // Специальные действия
        handleSpecialActions(var1, var2, var3, var5);
    }

    private void handleMovementInput(int var1, GameCanvas3D var2, InputHandler var5) {
        // Цифровые клавиши
        if (var1 == KEY_NUM2) {
            var5.handlePlayerAction(ACTION_MOVE_FORWARD, true);
        } else if (var1 == KEY_NUM8) {
            var5.handlePlayerAction(ACTION_MOVE_BACKWARD, true);
        } else if (var1 == KEY_NUM4) {
            var5.handlePlayerAction(ACTION_STRAFE_LEFT, true);
        } else if (var1 == KEY_NUM6) {
            var5.handlePlayerAction(ACTION_STRAFE_RIGHT, true);
        }
        // Клавиша огня
        else if (var1 == KEY_NUM5 || var2.getGameAction(var1) == 8) {
            var5.handlePlayerAction(ACTION_FIRE, true);
        }
        // GameAction клавиши (для разных устройств)
        else {
            handleGameActionInput(var1, var2, var5);
        }
    }

    private void handleGameActionInput(int var1, GameCanvas3D var2, InputHandler var5) {
        int gameAction = var2.getGameAction(var1);
        switch (gameAction) {
            case 1: // UP
                var5.handlePlayerAction(ACTION_MOVE_FORWARD, true);
                break;
            case 6: // DOWN
                var5.handlePlayerAction(ACTION_MOVE_BACKWARD, true);
                break;
            case 2: // LEFT
                var5.handlePlayerAction(ACTION_STRAFE_LEFT, true);
                break;
            case 5: // RIGHT
                var5.handlePlayerAction(ACTION_STRAFE_RIGHT, true);
                break;
            default:
                handleAdditionalActions(var1, var2);
                break;
        }
    }

    private void handleAdditionalActions(int var1, GameCanvas3D var2) {
        GameEntity var3 = GameEntityManager.getInstance().localPlayer;

        if (var1 == KEY_NUM9) {
            // Включение/выключение прицела для снайперской винтовки
            ChooseTeam var6 = (ChooseTeam)var3;
            if (var6.getWeaponShop().getCurrentWeapon().weaponType == 11) {
                var2.setZoom(!var2.isSniperMode);
            }
        } else if (var1 == KEY_NUM7) {
            // Отладочный вывод позиции
            float[] position = var3.getPosition();
            System.out.println("Position: " + position[0] + " " + position[1] + " " + position[2]);
        }
    }

    private void handleSpecialActions(int var1, GameCanvas3D var2, GameEntity var3, InputHandler var5) {
        switch (var1) {
            case KEY_NUM0:
                handleMenuAction(var5);
                break;
            case KEY_NUM1:
                handleWeaponSwitch(var3);
                break;
            case KEY_NUM3:
                handleBuyAmmo(var3);
                break;
            case KEY_POUND:
            case SOFT_KEY_MENU:
                handleExitAction(var5);
                break;
        }
    }

    private void handleMenuAction(InputHandler var5) {
        var5.handlePlayerAction(ACTION_MENU, false);
        MenuSystem.getInstance().currentMenuState = 1;
        MenuSystem.getInstance().showMenu();
    }

    private void handleWeaponSwitch(GameEntity var3) {
        GameCanvas3D.getInstance().setZoom(false);
        WeaponShop weaponShop = ((ChooseTeam)var3).getWeaponShop();
        int currentSlot = weaponShop.currentWeaponSlot;

        // Циклическое переключение оружия (макс 4 слота)
        for (int i = 0; i < 4; i++) {
            currentSlot = (currentSlot == 4) ? 1 : currentSlot + 1;
            if (weaponShop.switchToWeaponSlot(currentSlot)) {
                break;
            }
        }
    }

    private void handleBuyAmmo(GameEntity var3) {
        LocalPlayer player = (LocalPlayer)var3;
        WeaponShop weaponShop = player.getWeaponShop();
        int currentSlot = weaponShop.currentWeaponSlot;
        int currentAmmo = weaponShop.getCurrentAmmo();
        int clipCapacity = weaponShop.getCurrentWeapon().clipCapacity;

        // Вычисление текущего количества обойм
        int magazines = currentAmmo / clipCapacity;
        if (currentAmmo % clipCapacity != 0) {
            magazines++;
        }

        // Проверка лимита боеприпасов
        boolean ammoLimitReached = false;
        WeaponParameters defaultWeapon = null;

        if (currentSlot == 1) { // Автомат
            ammoLimitReached = (magazines >= 4);
            defaultWeapon = (WeaponParameters) WeaponShop.allWeapons.elementAt(WeaponShop.defaultRifleId);
        } else if (currentSlot == 2) { // Пистолет
            ammoLimitReached = (magazines >= 8);
            defaultWeapon = (WeaponParameters) WeaponShop.allWeapons.elementAt(WeaponShop.defaultPistolId);
        }

        // Покупка оружия если есть деньги и не превышен лимит
        if (defaultWeapon != null && defaultWeapon.price <= player.money && !ammoLimitReached) {
            weaponShop.equipWeapon(defaultWeapon);
            player.spendMoney(defaultWeapon.price);
            HUDManager.getInstance().showMessage(6, (String)null);
        }
    }

    private void handleExitAction(InputHandler var5) {
        var5.handlePlayerAction(ACTION_MENU, false);
        MenuSystem.getInstance().currentMenuState = 0;
        MenuSystem.getInstance().showMenu();
    }

    public final void keyReleased(int var1, GameCanvas3D var2) {
        if (!MenuSystem.getInstance().isMenuVisible) {
            handleGameKeyRelease(var1, var2);
        } else if (var1 == KEY_STAR) {
            MenuSystem.getInstance().hideMenu();
        }
    }

    private void handleGameKeyRelease(int var1, GameCanvas3D var2) {
        InputHandler var3 = InputHandler.sub_5f();

        // Прямое сопоставление цифровых клавиш
        if (var1 == KEY_NUM2) {
            var3.handlePlayerAction(ACTION_MOVE_FORWARD, false);
        } else if (var1 == KEY_NUM8) {
            var3.handlePlayerAction(ACTION_MOVE_BACKWARD, false);
        } else if (var1 == KEY_NUM4) {
            var3.handlePlayerAction(ACTION_STRAFE_LEFT, false);
        } else if (var1 == KEY_NUM6) {
            var3.handlePlayerAction(ACTION_STRAFE_RIGHT, false);
        }
        // Клавиша огня
        else if (var1 == KEY_NUM5 || var2.getGameAction(var1) == 8) {
            var3.handlePlayerAction(ACTION_FIRE, false);
        }
        // GameAction клавиши
        else {
            handleGameActionRelease(var1, var2, var3);
        }
    }

    private void handleGameActionRelease(int var1, GameCanvas3D var2, InputHandler var3) {
        int gameAction = var2.getGameAction(var1);
        switch (gameAction) {
            case 1: // UP
                var3.handlePlayerAction(ACTION_MOVE_FORWARD, false);
                break;
            case 6: // DOWN
                var3.handlePlayerAction(ACTION_MOVE_BACKWARD, false);
                break;
            case 2: // LEFT
                var3.handlePlayerAction(ACTION_STRAFE_LEFT, false);
                break;
            case 5: // RIGHT
                var3.handlePlayerAction(ACTION_STRAFE_RIGHT, false);
                break;
        }
    }
}