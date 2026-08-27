package com.m3gworks.microcs;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class HUDRenderer extends HUDManager {
    public int weaponFireFrame = -1;
    public int knifeAttackFrame = -1;
    private static String[] messageTexts = new String[]{
            "Preparing...", "Time Out!", "Counter-Terrorists Win!",
            "Terrorists Win!", "Out of ammunition.", "You already own that weapon.",
            "Buy successfully!"
    };
    private String customText = null;
    private int currentMessageId = -1;
    private int messageTimer = 0;
    private static Image weaponHandImage = null;
    private static Image crosshairImage = null;
    private static Image[] primaryWeaponFrames = null;
    private static Image[] secondaryWeaponFrames = null;
    private static Image bloodSprayImage = null;
    private static Image backgroundMask = null;
    private static Image hudIcons = null;
    private static Image hudNumbers = null;

    // Sprite coordinates in sprite sheets [normal_size, small_size]
    private static final int[] var_4da = new int[2];        // Health icon offset
    private static final int[] var_53c = new int[]{0, 10};  // Health text Y
    private static final int[] var_552 = new int[]{10, 8};  // Health icon size
    private static final int[] var_5ac = new int[]{10, 8};  // Armor text Y
    private static final int[] var_5f5 = new int[]{10, 8};  // Armor icon size
    private static final int[] var_651 = new int[]{0, 10};  // Armor icon Y
    private static final int[] var_65b = new int[]{9, 7};   // Armor icon dimensions
    private static final int[] var_6a1 = new int[]{10, 8};  // Armor text dimensions
    private static final int[] var_6f1 = new int[]{19, 15}; // Ammo icon coordinates
    private static final int[] var_73b = new int[]{0, 10};  // Ammo icon Y
    private static final int[] var_74d = new int[]{2, 1};   // Ammo separator size
    private static final int[] var_79a = new int[]{10, 5};  // Ammo separator Y
    private static final int[] var_7bb = new int[]{21, 16}; // Ammo counter icon
    private static final int[] var_7f2 = new int[]{0, 10};  // Ammo counter Y
    private static final int[] var_824 = new int[]{10, 8};  // Ammo icon size
    private static final int[] var_882 = new int[]{10, 8};  // Ammo text dimensions
    private static final int[] var_88c = new int[]{31, 24}; // Money icon coordinates
    private static final int[] var_8bc = new int[]{0, 10};  // Money icon Y
    private static final int[] var_8f3 = new int[]{5, 4};   // Money icon size
    private static final int[] var_942 = new int[]{10, 7};  // Money text Y
    private static final int[] var_964 = new int[]{8, 14};  // Numbers sprite Y
    private static final int[] var_9c6 = new int[]{6, 5};   // Digit width
    private static final int[] var_9d2 = new int[]{6, 5};   // Digit height
    private static final int[] var_a04 = new int[2];        // Timer numbers offset
    private static final int[] var_a41 = new int[]{0, 14};  // Timer numbers Y
    private static final int[] var_a6e = new int[]{8, 5};   // Timer digit width
    private static final int[] var_a89 = new int[]{8, 5};   // Timer digit height
    private static final int[] var_aa7 = new int[]{80, 50}; // Timer separator coordinates
    private static final int[] var_b08 = new int[]{0, 14};  // Timer separator Y
    private static final int[] var_b50 = new int[]{2, 1};   // Timer separator width
    private static final int[] var_b62 = new int[]{8, 5};   // Timer separator height

    private int crosshairPulse = 0;

    public final void renderHUD(Graphics var1, GameCanvas3D var2) {
        int var3 = var2.getWidth();
        int var4 = var2.getHeight();
        int var5 = GameConfig.getInstance().lowRes; // Screen size type (0=normal, 1=small)
        ChooseTeam var6 = (ChooseTeam) GameEntityManager.getInstance().localPlayer;
        GameRoundManager var7 = GameRoundManager.getInstance();

        // Draw crosshair for non-sniper weapons
        if (var6.getWeaponShop().getCurrentWeapon().weaponType != 11) {
            var1.setColor(6553418);
            int var10 = var3 / 2;
            int var11 = var4 / 2;

            // Animate crosshair when firing
            if (InputHandler.sub_5f().var_7e[0]) {
                ++this.crosshairPulse;
            } else {
                --this.crosshairPulse;
            }

            // Clamp crosshair pulse
            if (this.crosshairPulse > 5) {
                this.crosshairPulse = 5;
            } else if (this.crosshairPulse < 0) {
                this.crosshairPulse = 0;
            }

            // Draw crosshair lines with pulse effect
            var1.drawLine(var10 - 6 + 1 - this.crosshairPulse, var11, var10 - 3 - this.crosshairPulse, var11);
            var1.drawLine(var10 + 3 + this.crosshairPulse, var11, var10 + 6 - 1 + this.crosshairPulse, var11);
            var1.drawLine(var10, var11 - 6 + 1 - this.crosshairPulse, var10, var11 - 3 - this.crosshairPulse);
            var1.drawLine(var10, var11 + 3 + this.crosshairPulse, var10, var11 + 6 - 1 + this.crosshairPulse);
        }

        // Draw weapon fire animation
        if (this.weaponFireFrame >= 0) {
            Image[] var30 = null;
            int var31 = var6.getWeaponShop().currentWeaponSlot; // Current weapon slot
            float var35 = 0.8F;

            if (var31 == 1) {
                var30 = primaryWeaponFrames;
            } else if (var31 == 2) {
                var30 = secondaryWeaponFrames;
                var35 = 1.0F;
            }

            WeaponParameters var37 = var6.getWeaponShop().getCurrentWeapon();
            var1.drawImage(var30[this.weaponFireFrame],
                    var3 - (int)(var37.fireAnimation[var5][0][2] * var35),
                    var4 - var37.fireAnimation[var5][0][3], 3);
            ++this.weaponFireFrame;
            if (this.weaponFireFrame >= var30.length) {
                this.weaponFireFrame = -1;
            }
        }

        // Draw weapon in hand or sniper scope
        if (var6.getHealth() > 0) {
            if (var6.getWeaponShop().getCurrentWeapon().weaponType == 11 && var2.isSniperMode) {
                drawSniperScope(var1, var3, var4, var5);
            } else {
                drawWeaponInHand(var1, var3, var4, var5, var6);
            }
        }

        // Draw system messages
        var1.setColor(55, 195, 30);
        Font var36 = Font.getFont(64, 1, 8);
        var1.setFont(var36);
        if (this.currentMessageId != -1 && this.messageTimer < 30) {
            ++this.messageTimer;
            this.sub_52(this.currentMessageId, var1, var3, var4);
        }

        // Draw HUD background
        drawHUDBackground(var1, var3, var4, var5);

        // Draw HUD elements
        drawHealth(var1, var3, var4, var5, var6);
        drawArmor(var1, var3, var4, var5, var6);

        // Draw ammo for non-knife weapons
        if (var6.getWeaponShop().getCurrentWeapon().weaponType != 30) {
            drawAmmo(var1, var3, var4, var5, var6);
        }

        // Draw game timer
        drawTimer(var1, var3, var4, var5, var7);

        // Draw money
        drawMoney(var1, var3, var4, var5, var6);

        // Draw blood spray overlay if injured
        if (((LocalPlayer)var6).isBleeding()) {
            drawBloodSpray(var1, var3, var4);
        }
    }

    private void drawSniperScope(Graphics var1, int var3, int var4, int var5) {
        var1.setColor(0, 0, 0);

        // Draw scope overlay in four directions
        var1.drawRegion(crosshairImage, 0, 0, crosshairImage.getWidth(), crosshairImage.getHeight(), 0, var3 / 2, var4 / 2, 40);
        var1.drawRegion(crosshairImage, 0, 0, crosshairImage.getWidth(), crosshairImage.getHeight(), 2, var3 / 2, var4 / 2, 36);
        var1.drawRegion(crosshairImage, 0, 0, crosshairImage.getWidth(), crosshairImage.getHeight(), 1, var3 / 2, var4 / 2, 24);
        var1.drawRegion(crosshairImage, 0, 0, crosshairImage.getWidth(), crosshairImage.getHeight(), 3, var3 / 2, var4 / 2, 20);

        int var34 = var4 / 2 - crosshairImage.getHeight();
        int var31 = var3 / 2 - crosshairImage.getWidth();

        // Fill black borders around scope
        var1.fillRect(0, 0, var3, var34 + 2);
        var1.fillRect(0, var34 + crosshairImage.getHeight() * 2, var3, var34 + 1);
        var1.fillRect(0, var34 + 2, var31 + 1, crosshairImage.getHeight() * 2);
        var1.fillRect(var31 + crosshairImage.getWidth() * 2, var34 + 2, var31 + 1, crosshairImage.getHeight() * 2);

        int var10 = var3 / 2;
        int var11 = var4 / 2;

        // Draw crosshair reticle
        var1.setColor(255, 0, 0);
        var1.drawLine(var10 - 1, var11, var10 + 1, var11);
        var1.drawLine(var10, var11 - 1, var10, var11 + 1);

        var1.setColor(0);
        // Draw rangefinder marks
        drawRangefinderMarks(var1, var10, var11, var5);
    }

    private void drawRangefinderMarks(Graphics var1, int centerX, int centerY, int screenSize) {
        // Close range marks
        var1.drawLine(centerX - 6, centerY, centerX - 6, centerY);
        var1.drawLine(centerX + 6, centerY, centerX + 6, centerY);
        var1.drawLine(centerX, centerY - 6, centerX, centerY - 6);
        var1.drawLine(centerX, centerY + 6, centerX, centerY + 6);

        // Medium range marks
        var1.drawLine(centerX - 8, centerY, centerX - 8, centerY);
        var1.drawLine(centerX + 8, centerY, centerX + 8, centerY);
        var1.drawLine(centerX, centerY - 8, centerX, centerY - 8);
        var1.drawLine(centerX, centerY + 8, centerX, centerY + 8);

        // Long range marks
        var1.drawLine(centerX - 11, centerY, centerX - 11, centerY);
        var1.drawLine(centerX + 11, centerY, centerX + 11, centerY);
        var1.drawLine(centerX, centerY - 11, centerX, centerY - 11);
        var1.drawLine(centerX, centerY + 11, centerX, centerY + 11);

        // Range lines
        int var12 = screenSize == 0 ? 56 : 35;
        var1.drawLine(centerX - 15 - var12, centerY, centerX - 15, centerY);
        var1.drawLine(centerX + 15, centerY, centerX + 15 + var12, centerY);
        var1.drawLine(centerX, centerY - 15 - var12, centerX, centerY - 15);
        var1.drawLine(centerX, centerY + 15, centerX, centerY + 15 + var12);
    }

    private void drawWeaponInHand(Graphics var1, int var3, int var4, int var5, ChooseTeam var6) {
        GameController var32 = (GameController) InputHandler.sub_5f();
        WeaponParameters var33 = var6.getWeaponShop().getCurrentWeapon();

        if (var33.weaponType == 30) { // Knife
            int var10 = (this.knifeAttackFrame == -1) ? 0 : this.knifeAttackFrame;

            var1.drawRegion(weaponHandImage,
                    var33.fireAnimation[var5][var10][0],
                    var33.fireAnimation[var5][var10][1],
                    var33.fireAnimation[var5][var10][2],
                    var33.fireAnimation[var5][var10][3],
                    0, var3, var4 + 3 * var32.var_8e, 40);

            if (this.knifeAttackFrame >= 0) {
                ++this.knifeAttackFrame;
                if (this.knifeAttackFrame >= var33.fireAnimation[var5].length) {
                    this.knifeAttackFrame = -1;
                }
            }
        } else {
            int var10 = var32.var_151; // Weapon recoil
            if (var10 != 0) {
                var1.drawRegion(weaponHandImage,
                        var33.fireAnimation[var5][0][0],
                        var33.fireAnimation[var5][0][1],
                        var33.fireAnimation[var5][0][2],
                        var33.fireAnimation[var5][0][3],
                        0, var3 + 3 * var10, var4 + 3 * var10, 40);
            } else {
                var1.drawRegion(weaponHandImage,
                        var33.fireAnimation[var5][0][0],
                        var33.fireAnimation[var5][0][1],
                        var33.fireAnimation[var5][0][2],
                        var33.fireAnimation[var5][0][3],
                        0, var3, var4 + 3 * var32.var_8e, 40);
            }
        }
    }

    private void drawHUDBackground(Graphics var1, int var3, int var4, int var5) {
        int var31 = (var5 == 0) ? 16 : 12;
        int var10 = var31 / backgroundMask.getHeight();

        for(int var11 = 0; var11 < var10; ++var11) {
            var1.drawRegion(backgroundMask, 0, 0, var3, backgroundMask.getHeight(), 0, 0,
                    var4 - var11 * backgroundMask.getHeight(), 36);
        }
    }

    private void drawHealth(Graphics var1, int var3, int var4, int var5, ChooseTeam var6) {
        int var31 = (var5 == 0) ? 16 : 12;
        int var11 = (var31 - var_552[var5]) / 2;
        int var12 = var11;
        int var13 = var4 - var31 / 2;

        // Draw health icon
        var1.drawRegion(hudIcons, var_4da[var5], var_53c[var5], var_552[var5], var_5ac[var5],
                0, var12, var13, 6);

        int var14 = var6.getHealth(); // Health value
        var12 += var_552[var5] + 2 + var_9c6[var5] * 3;

        drawNumber(var1, var12, var13, var5, var14);
    }

    private void drawArmor(Graphics var1, int var3, int var4, int var5, ChooseTeam var6) {
        int var13 = var4 - ((var5 == 0) ? 16 : 12) / 2;
        int var12 = (var5 == 0) ? 40 : 29;

        // Draw armor icon
        var1.drawRegion(hudIcons, var_5f5[var5], var_651[var5], var_65b[var5], var_6a1[var5],
                0, var12, var13, 6);

        int var15 = var6.getWeaponShop().armorLevel; // Armor value
        var12 += var_65b[var5] + 1 + var_9c6[var5] * 3;

        drawNumber(var1, var12, var13, var5, var15);
    }

    private void drawAmmo(Graphics var1, int var3, int var4, int var5, ChooseTeam var6) {
        int var31 = (var5 == 0) ? 16 : 12;
        int var11 = (var31 - var_552[var5]) / 2;
        int var13 = var4 - var31 / 2;

        int var12 = var3 - var11;

        // Draw ammo icon
        var1.drawRegion(hudIcons, var_7bb[var5], var_7f2[var5], var_824[var5], var_882[var5],
                0, var12, var13, 10);

        int var17 = var6.getWeaponShop().getCurrentAmmo(); // Total ammo
        int var18 = var6.getWeaponShop().getCurrentWeapon().clipCapacity; // Clip size

        // Calculate current clip and reserve ammo
        int var19 = (var17 % var18 == 0 && var17 != 0) ? var18 : var17 % var18;
        int var20 = var17 - var19; // Reserve ammo

        var12 -= var_824[var5] + 2;

        // Draw reserve ammo
        drawNumber(var1, var12, var13, var5, var20);

        // Draw ammo separator
        var1.drawRegion(hudIcons, var_6f1[var5], var_73b[var5], var_74d[var5], var_79a[var5],
                0, var12 - 3 * (var_9c6[var5] + 1) - 1, var13, 10);

        // Draw current clip ammo
        drawNumberLeft(var1, var12 - 3 * (var_9c6[var5] + 1) - 1 - var_74d[var5] - 2,
                var13, var5, var19);
    }

    private void drawTimer(Graphics var1, int var3, int var4, int var5, GameRoundManager var7) {
        int var13 = var4 - ((var5 == 0) ? 16 : 12) / 2;
        int minutes = 0, tensSeconds = 0, unitsSeconds = 0;

        // Calculate timer based on game state
        if (var7.gameState == 1) { // Preparing
            this.sub_52(0, var1, var3, var4);
            unitsSeconds = var7.roundTimer.TimerValue;
        } else if (var7.gameState == 2) { // Playing
            int totalSeconds = var7.roundTimer.TimerValue;
            minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            tensSeconds = seconds / 10;
            unitsSeconds = seconds % 10;
        } else if (var7.gameState == 3) { // Ended
            byte messageId;
            if (var7.earlyTerminationFlag == 0) {
                messageId = 1; // Time Out
            } else if (var7.earlyTerminationFlag == 1) {
                messageId = 2; // CT Win
            } else {
                messageId = 3; // T Win
            }
            this.sub_52(messageId, var1, var3, var4);
        }

        // Draw timer digits
        int var20 = var3 / 2;
        var1.drawRegion(hudNumbers, var_aa7[var5], var_b08[var5], var_b50[var5], var_b62[var5],
                0, var20, var13, 6);

        int var21 = var20 - 2;
        var1.drawRegion(hudNumbers, var_a04[var5] + minutes * var_a6e[var5], var_a41[var5],
                var_a6e[var5], var_a89[var5], 0, var21, var13, 10);

        int var22 = var20 + var_b50[var5] + 2;
        var1.drawRegion(hudNumbers, var_a04[var5] + tensSeconds * var_a6e[var5], var_a41[var5],
                var_a6e[var5], var_a89[var5], 0, var22, var13, 6);

        int var23 = var22 + var_a6e[var5] + 2;
        var1.drawRegion(hudNumbers, var_a04[var5] + unitsSeconds * var_a6e[var5], var_a41[var5],
                var_a6e[var5], var_a89[var5], 0, var23, var13, 6);
    }

    private void drawMoney(Graphics var1, int var3, int var4, int var5, ChooseTeam var6) {
        int var31 = (var5 == 0) ? 16 : 12;
        int var11 = (var31 - var_552[var5]) / 2;
        int var13 = var11 + var_942[var5] / 2;

        // Draw money icon
        var1.drawRegion(hudIcons, var_88c[var5], var_8bc[var5], var_8f3[var5], var_942[var5],
                0, var3 - var11 - 5 * (var_9c6[var5] + 1) - 2, var13, 10);

        int var25 = ((LocalPlayer)var6).money; // Money amount
        drawNumberRight(var1, var3 - var11, var13, var5, var25);
    }

    private void drawBloodSpray(Graphics var1, int var3, int var4) {
        int var26 = var4 / bloodSprayImage.getHeight();
        if (var4 % bloodSprayImage.getHeight() != 0) {
            ++var26;
        }

        for(int var27 = 0; var27 < var26; ++var27) {
            var1.drawRegion(bloodSprayImage, 0, 0, var3, bloodSprayImage.getHeight(),
                    0, 0, var27 * bloodSprayImage.getHeight(), 20);
        }
    }

    private void drawNumber(Graphics var1, int x, int y, int screenSize, int number) {
        int divisor = 1;
        int digitCount = 0;

        while (true) {
            int currentNumber = number / divisor;
            if (currentNumber == 0 && number != 0) break;

            int digit = currentNumber % 10;
            var1.drawRegion(hudNumbers, var_9c6[screenSize] * digit, var_964[screenSize],
                    var_9c6[screenSize], var_9d2[screenSize], 0,
                    x - digitCount * (var_9c6[screenSize] + 1), y, 10);

            if (number == 0) break;
            divisor *= 10;
            digitCount++;
        }
    }

    private void drawNumberLeft(Graphics var1, int x, int y, int screenSize, int number) {
        int divisor = 1;
        int digitCount = 0;

        while (true) {
            int currentNumber = number / divisor;
            if (currentNumber == 0 && number != 0) break;

            int digit = currentNumber % 10;
            var1.drawRegion(hudNumbers, var_9c6[screenSize] * digit, var_964[screenSize],
                    var_9c6[screenSize], var_9d2[screenSize], 0,
                    x - digitCount * (var_9c6[screenSize] + 1), y, 10);

            if (number == 0) break;
            divisor *= 10;
            digitCount++;
        }
    }

    private void drawNumberRight(Graphics var1, int rightX, int y, int screenSize, int number) {
        int divisor = 1;
        int digitCount = 0;

        while (true) {
            int currentNumber = number / divisor;
            if (currentNumber == 0 && number != 0) break;

            int digit = currentNumber % 10;
            var1.drawRegion(hudNumbers, var_9c6[screenSize] * digit, var_964[screenSize],
                    var_9c6[screenSize], var_9d2[screenSize], 0,
                    rightX - digitCount * (var_9c6[screenSize] + 1), y, 10);

            if (number == 0) break;
            divisor *= 10;
            digitCount++;
        }
    }

    public final void sub_52(int var1, Graphics var2, int var3, int var4) {
        String var5 = null;
        if (this.customText != null) {
            StringBuffer var6 = new StringBuffer();
            var6.append(messageTexts[var1]);
            var6.append(this.customText);
            var5 = var6.toString().toLowerCase();
        } else {
            var5 = messageTexts[var1].toLowerCase();
        }

        int var11 = var4 / 4;
        int var7 = 3;
        int[] var8 = new int[4];

        for(int var9 = 0; var9 < var5.length(); ++var9) {
            MainMenu.getCharRegion(var5.charAt(var9), var8);
            if (var8[0] != -1) {
                var2.drawRegion(MainMenu.normalTextFont, var8[0], var8[1], var8[2], var8[3], 0, var7, var11, 20);
                var7 += var8[2] + 1;
            } else if (var7 > var3 - 25) {
                var7 = 3;
                var11 = var11 + 6 + 3;
            } else {
                var7 += 6;
            }
        }
    }

    public final void showMessage(int var1, String var2) {
        this.messageTimer = 0;
        this.currentMessageId = var1;
        this.customText = var2;
    }

    public final void sub_b0() {
        if (((ChooseTeam) GameEntityManager.getInstance().localPlayer).getWeaponShop().getCurrentWeapon().weaponType != 11 || !GameCanvas3D.getInstance().isSniperMode) {
            if (this.weaponFireFrame == -1) {
                this.weaponFireFrame = 0;
            }
        }
    }

    public final void sub_f0() {
        if (this.knifeAttackFrame == -1) {
            this.knifeAttackFrame = 0;
        }
    }

    public final void clearCustomText() {
        this.customText = null;
    }

    public static void sub_131() {
        int var0 = GameConfig.getInstance().lowRes;

        try {
            if (var0 == 0) {
                crosshairImage = Image.createImage("/res/image2d/collimator.png");
            } else {
                crosshairImage = Image.createImage("/res/image2d/collimator_s.png");
            }

            primaryWeaponFrames = BotMuzzleFlashManager.rifleMuzzleFlashImages;
            secondaryWeaponFrames = BotMuzzleFlashManager.pistolMuzzleFlashImages;
            if (var0 == 0) {
                weaponHandImage = Image.createImage("/res/image2d/weapon_handin.png");
            } else {
                weaponHandImage = Image.createImage("/res/image2d/weapon_handin_s.png");
            }

            bloodSprayImage = Image.createImage("/res/image2d/fp_bloodspray.png");
            backgroundMask = Image.createImage("/res/image2d/bg_mask.png");
            hudIcons = Image.createImage("/res/image2d/screen_symbol.png");
            hudNumbers = Image.createImage("/res/image2d/screen_num.png");
        } catch (Exception var1) {
            System.out.println("Failed to load 2D images");
        }
    }

    public static void sub_181() {
        messageTexts = null;
        crosshairImage = null;
        primaryWeaponFrames = null;
        secondaryWeaponFrames = null;
        weaponHandImage = null;
        backgroundMask = null;
        hudIcons = null;
        hudNumbers = null;
    }
}