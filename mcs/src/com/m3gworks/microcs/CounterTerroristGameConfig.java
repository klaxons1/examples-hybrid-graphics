package com.m3gworks.microcs;
import javax.microedition.m3g.Camera;

public class CounterTerroristGameConfig extends GameConfig {
    // Константы для классов игры
    public static Class GameScreenClass;
    public static Class PlayerClass;
    public static Class MainMenuClass;
    public static Class HUDRendererClass;  // HUDRenderer
    public static Class BuyMenuClass;   // BuyMenu
    public static Class GameControllerClass;   // GameController
    public static Class BotAIClass;   // Class_723 (неизвестный компонент)
    public static Class GameHandlerInput;   // GameHandlerInput

    // Константы для настроек игры
    private static final int ROUND_START_DELAY = 2;
    private static final int ROUND_DURATION = 3;
    private static final boolean BLOOD_ENABLED = false;
    private static final boolean FULLSCREEN_ENABLED = true;

    public final boolean isMultiplayer() {
        return false;
    }

    public final boolean hasSound() {
        return true;
    }

    public final boolean sub_a5() {
        return false;
    }

    public final Class sub_106() {
        return getOrLoadClass("GameScreenClass", "com.m3gworks.microcs.Game3DCleanUpper");
    }

    public final Class sub_14f() {
        return getOrLoadClass("PlayerClass", "com.m3gworks.microcs.CounterStrikeRoundManager");
    }

    public final Class sub_199() {
        return getOrLoadClass("MainMenuClass", "com.m3gworks.microcs.MainMenu");
    }

    public final Class sub_1fb() {
        return getOrLoadClass("var_110", "com.m3gworks.microcs.HUDRenderer");
    }

    public final Class sub_23a() {
        return getOrLoadClass("var_11f", "com.m3gworks.microcs.BuyMenu");
    }

    public final Class sub_274() {
        return getOrLoadClass("var_162", "com.m3gworks.microcs.GameController");
    }

    public final Class sub_2b8() {
        return getOrLoadClass("var_1b4", "com.m3gworks.microcs.BotAI");
    }

    public final Class sub_2cf() {
        return getOrLoadClass("var_1d2", "com.m3gworks.microcs.GameHandlerInput");
    }

    public final boolean isBloodEnabled() {
        return BLOOD_ENABLED;
    }

    public final boolean isFullScreenEnabled() {
        return FULLSCREEN_ENABLED;
    }

    public final int sub_3bd() {
        return ROUND_START_DELAY;
    }

    public final int sub_3d3() {
        return ROUND_DURATION;
    }

    public final void sub_40a() {
        MainMenu.loadResources();
    }

    public final void sub_45a() {
        HUDRenderer.sub_131();
    }

    public final void sub_490() {
        BuyMenu.loadResources();
    }

    public final void sub_49f() {
        MainMenu.cleanUp();
    }

    public final void sub_4a9() {
        HUDRenderer.sub_181();
    }

    public final void sub_4dd() {
        BuyMenu.cleanupResources();
    }

    public final void initializeAllMaps() {
        // Military Base
        registerMap("Military base", "/res/map/military/military.m3g",
                new float[]{-84.0F, 3.2F, -63.0F, -34.0F, 0.05F, 81.0F, 35.0F, 0.05F, 106.0F, 108.0F, 0.05F, -94.0F},
                new int[]{239, 240, 241, 243, 244, 246, 247, 248, 249, 250, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266});

        // Command
        registerMap("Command", "/res/map/command/command.m3g",
                new float[]{25.3F, 3.2F, 74.66F, -87.7F, 0.05F, 47.9F, -81.3F, 0.05F, -18.6F, 63.1F, 0.05F, -87.8F},
                new int[]{296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 331, 332, 333, 334});

        // Street
        registerMap("Street", "/res/map/street/street.m3g",
                new float[]{26.1F, 3.2F, -12.1F, 74.8F, 0.05F, -120.0F, -75.6F, 0.05F, -124.0F, 90.3F, 0.05F, 111.0F},
                new int[]{264, 265, 266, 267, 269, 270, 272, 273, 274, 275, 276, 278, 279, 280, 281, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298});

        // Depository
        registerMap("Depository", "/res/map/depository/depository.m3g",
                new float[]{-116.7F, 3.2F, -112.4F, -42.7F, 0.05F, 69.0F, 98.0F, 0.05F, 128.9F, -18.1F, 0.05F, 26.7F},
                new int[]{213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241});

        // Fortress
        registerMap("Fortress", "/res/map/fortress/fortress.m3g",
                new float[]{-2.3F, 3.2F, -8.3F, 1.5F, 0.05F, -96.0F, -5.4F, 0.05F, 102.3F, 90.0F, 0.05F, 50.20508F},
                new int[]{314, 315, 316, 317, 318, 319, 320, 321, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359});

        // Construction
        registerMap("Construction", "/res/map/construction/construction.m3g",
                new float[]{-51.9F, 3.2F, 123.8F, -13.59F, 0.05F, -101.9F, -104.8F, 0.05F, -127.3F, 101.2F, 0.05F, 119.4F},
                new int[]{274, 275, 277, 278, 279, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 295, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 309, 310, 312});
    }

    public final void initializeAllWeapons() {
        // Автоматы
        initializeRifleWeapons();

        // Пистолеты
        initializePistolWeapons();

        // Ближний бой и спец оружие
        initializeSpecialWeapons();

        // Броня и боеприпасы
        initializeEquipment();
    }

    public final void sub_52b() {
        Camera var1 = new Camera();
        CameraManager.getInstance().registerCamera("MAIN", var1);
    }

    // Вспомогательные методы

    private Class getOrLoadClass(String fieldName, String className) {
        try {
            if (fieldName.equals("GameScreenClass")) {
                if (GameScreenClass == null) GameScreenClass = Class.forName(className);
                return GameScreenClass;
            } else if (fieldName.equals("PlayerClass")) {
                if (PlayerClass == null) PlayerClass = Class.forName(className);
                return PlayerClass;
            } else if (fieldName.equals("MainMenuClass")) {
                if (MainMenuClass == null) MainMenuClass = Class.forName(className);
                return MainMenuClass;
            } else if (fieldName.equals("var_110")) {
                if (HUDRendererClass == null) HUDRendererClass = Class.forName(className);
                return HUDRendererClass;
            } else if (fieldName.equals("var_11f")) {
                if (BuyMenuClass == null) BuyMenuClass = Class.forName(className);
                return BuyMenuClass;
            } else if (fieldName.equals("var_162")) {
                if (GameControllerClass == null) GameControllerClass = Class.forName(className);
                return GameControllerClass;
            } else if (fieldName.equals("var_1b4")) {
                if (BotAIClass == null) BotAIClass = Class.forName(className);
                return BotAIClass;
            } else if (fieldName.equals("var_1d2")) {
                if (GameHandlerInput == null) GameHandlerInput = Class.forName(className);
                return GameHandlerInput;
            }
            return Class.forName(className);
        } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
        }
    }

    private void registerMap(String name, String path, float[] spawnPoints, int[] objectIds) {
        MapParameters map = new MapParameters();
        map.mapName = name;
        map.mapFilePath = path;
        map.isEnabled = true;
        map.spawnPoints = spawnPoints;
        map.objectIds = objectIds;
        MapLoader.getInstance().registerMap(map);
    }

    private void initializeRifleWeapons() {
        // MP5
        registerWeapon("MP5", 10, 30, 1500, "3.42KG",
                new int[][][]{{{0, 0, 87, 68}, {0, 0, 64, 50}}},
                new int[][]{{0, 0, 71, 24}, {0, 0, 53, 18}});

        // M4A1
        registerWeapon("M4A1", 10, 30, 3000, "2.22KG",
                new int[][][]{{{0, 68, 87, 68}, {0, 50, 64, 51}}},
                new int[][]{{0, 24, 80, 24}, {0, 18, 58, 18}});

        // AK47
        registerWeapon("AK47", 10, 30, 3000, "4.79KG",
                new int[][][]{{{0, 136, 87, 68}, {0, 101, 64, 50}}},
                new int[][]{{0, 48, 95, 24}, {0, 36, 69, 19}});

        // AWP (снайперская)
        registerWeapon("AWP", 11, 10, 5000, "6KG",
                new int[][][]{{{0, 204, 87, 68}, {0, 151, 64, 51}}},
                new int[][]{{0, 72, 119, 24}, {0, 55, 75, 18}});
    }

    private void initializePistolWeapons() {
        // USP
        registerWeapon("USP", 20, 12, 500, "1KG",
                new int[][][]{{{114, 0, 52, 68}, {83, 0, 38, 50}}},
                new int[][]{{81, 24, 39, 24}, {58, 18, 29, 19}});

        // DE (Desert Eagle)
        registerWeapon("DE", 20, 7, 650, "1.8KG",
                new int[][][]{{{116, 68, 50, 68}, {84, 50, 37, 51}}},
                new int[][]{{73, 0, 47, 24}, {52, 0, 35, 18}});

        // Five-Seven
        registerWeapon("57", 20, 20, 750, "0.618KG",
                new int[][][]{{{120, 136, 46, 68}, {87, 101, 34, 50}}},
                new int[][]{{0, 145, 40, 24}, {0, 111, 29, 18}});
    }

    private void initializeSpecialWeapons() {
        // Нож
        registerWeapon("Knife", 30, 1, 0, "",
                new int[][][]{
                        {{0, 272, 70, 100}, {0, 392, 166, 46}, {0, 438, 166, 57}, {70, 310, 28, 62}, {100, 272, 66, 120}},
                        {{0, 202, 52, 74}, {0, 290, 107, 35}, {0, 325, 90, 42}, {50, 230, 22, 46}, {72, 202, 49, 88}}
                },
                new int[][]{{40, 148, 80, 14}, {29, 113, 58, 11}});

        // Граната
        registerWeapon("Grenade", 40, 1, 300, "",
                new int[][][]{{{88, 204, 78, 68}, {64, 151, 57, 51}}},
                new int[][]{{0, 96, 46, 40}, {0, 73, 34, 29}});
    }

    private void initializeEquipment() {
        // Броня
        registerWeapon("Kevlar", 60, 1, 650, "",
                null,
                new int[][]{{78, 96, 42, 52}, {58, 73, 29, 40}});

        // Патроны для автоматов
        registerWeapon("1 ammo", 50, 0, 60, "",
                null,
                new int[][]{{0, 136, 49, 9}, {0, 102, 36, 8}});

        // Патроны для пистолетов
        registerWeapon("2 ammo", 51, 0, 25, "",
                null,
                new int[][]{{49, 136, 29, 11}, {36, 102, 22, 9}});
    }

    private void registerWeapon(String name, int weaponType, int clipCapacity, int price, String weight,
                                int[][][] fireAnimation, int[][] spriteData) {
        WeaponParameters weapon = new WeaponParameters();
        weapon.name = name;
        weapon.weaponType = weaponType;
        weapon.clipCapacity = clipCapacity;
        weapon.initialAmmo = clipCapacity * (weaponType == 20 ? 5 : 3); // Пистолеты имеют больше патронов
        weapon.price = price;
        weapon.weight = weight;

        if (fireAnimation != null) {
            weapon.fireAnimation = fireAnimation;
        }

        if (spriteData != null) {
            weapon.spriteData = spriteData;
        }

        WeaponShop.registerWeapon(weapon);
    }
}