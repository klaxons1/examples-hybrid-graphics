package com.m3gworks.microcs;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class EnemyAI {
    private static EnemyAI instance;

    public static EnemyAI getInstance() {
        if (instance == null) {
            try {
                instance = (EnemyAI) GameConfig.getInstance().sub_2b8().newInstance();
            } catch (InstantiationException var1) {
                var1.printStackTrace();
            } catch (IllegalAccessException var2) {
                var2.printStackTrace();
            }
        }

        return instance;
    }

    public final void updateAllBots() {
        if (GameRoundManager.getInstance().gameState != 1) {
            Hashtable var1;
            Enumeration var2 = (var1 = GameEntityManager.getInstance().entityTable).keys();

            while(var2.hasMoreElements()) {
                Integer var3 = (Integer)var2.nextElement();
                GameEntity var4;
                if ((var4 = (GameEntity)var1.get(var3)).entityType == 2) {
                    this.updateBotAI(var4);
                    updateBotVisibility(var4);
                }
            }

        }
    }

    public abstract void updateBotAI(GameEntity var1);

    public static void updateBotVisibility(GameEntity var0) {
        boolean var2 = GameEntityManager.getInstance().localPlayer.isEntityInView(var0);
        var0.isActive = var2;
    }
}