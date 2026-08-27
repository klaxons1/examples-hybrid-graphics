package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import javax.microedition.m3g.World;

public final class GameInitializer implements Runnable {
   private static GameInitializer instance;
   private static boolean isInitialized = false;
   public int progressPercentage = 0;
   public int currentStep = 0;

   private GameInitializer() {
   }

   public static GameInitializer getInstance() {
      if (instance == null) {
         instance = new GameInitializer();
      }

      return instance;
   }

   public static void setupGameSession() {
      FirstPersonCameraModel var0 = new FirstPersonCameraModel();
      LocalPlayer var1 = new LocalPlayer(1, "Me", 0, 1, var0);
      GameEntityManager.getInstance().registerEntity(var1);
      GameCanvas.getInstance();
      float[] var3 = MapLoader.getInstance().getCurrentMap().spawnPoints;

      for(int var4 = 1; var4 < var3.length / 3; ++var4) {
         PlayerCharacter var5 = new PlayerCharacter(var4 + 1, "Bot", 1, 2);
         GameEntityManager.getInstance().registerEntity(var5);
      }

   }

   public static void startGame() {
      GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
      GameCanvas.getInstance().onSizeChanged();
      (new Thread(instance)).start();
   }

   public final void run() {
      try {
         GameCanvas.getInstance().screenState = 9;
         ++this.currentStep;
         this.progressPercentage = 1;
         GameCanvas.getInstance().onSizeChanged();
         CameraManager.getInstance().initialize();
         ++this.currentStep;
         World var1 = MapLoader.getInstance().loadCurrentMap();
         ++this.currentStep;
         this.progressPercentage = 20;
         GameCanvas.getInstance().onSizeChanged();
         ++this.currentStep;
         if (!isInitialized && GameConfig.getInstance().isMultiplayer()) {
            DecalManager.sub_76(var1);
         }

         ++this.currentStep;
         this.progressPercentage = 25;
         GameCanvas.getInstance().onSizeChanged();
         if (!isInitialized) {
            Grenade.loadResources();
         }

         ++this.currentStep;
         this.progressPercentage = 28;
         GameCanvas.getInstance().onSizeChanged();
         if (!isInitialized) {
            EffectManager.loadEffectResources();
         }

         ++this.currentStep;
         this.progressPercentage = 35;
         GameCanvas.getInstance().onSizeChanged();
         this.progressPercentage = 50;
         GameCanvas.getInstance().onSizeChanged();
         ++this.currentStep;
         if (!isInitialized) {
            BotMuzzleFlashManager.loadMuzzleFlashResources();
         }

         ++this.currentStep;
         this.progressPercentage = 60;
         GameCanvas.getInstance().onSizeChanged();
         GameEntityManager.getInstance().initializeAllEntities(var1);
         this.progressPercentage = 80;
         GameCanvas.getInstance().onSizeChanged();
         ++this.currentStep;
         this.progressPercentage = 85;
         GameCanvas.getInstance().onSizeChanged();
         if (!isInitialized) {
            HUDManager.loadHUDResources();
         }

         ++this.currentStep;
         this.progressPercentage = 90;
         GameCanvas.getInstance().onSizeChanged();
         if (!isInitialized) {
            MenuSystem.initializeMenuSystem();
         }

         ++this.currentStep;
         this.progressPercentage = 95;
         GameCanvas.getInstance().onSizeChanged();
         System.gc();
         this.progressPercentage = 100;
         GameCanvas.getInstance().onSizeChanged();
         ++this.currentStep;
         isInitialized = true;
      } catch (Exception var2) {
         GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
         GameCanvas.getInstance().showErrorMessage(this.currentStep + var2.toString());
         return;
      }

      this.progressPercentage = 0;
      startGameLoop();
   }

   private static void startGameLoop() {
      GameRoundManager.getInstance().startRound();
   }

   public static void cleanupGameSession() {
      CameraManager.getInstance().cleanup();
      MapLoader.getInstance().cleanupMap();
      if (GameConfig.getInstance().isMultiplayer()) {
         DecalManager.sub_42().sub_112();
      }

      EffectManager.getInstance().cleanupEffectPools();
      BotMuzzleFlashManager.getInstance().cleanupMuzzleFlashes();
      HUDManager.getInstance().clearCustomText();
      MenuSystem.getInstance();
      GameEntityManager.getInstance().cleanupAllEntities();
      GameCanvas3D.cleanup();
      Runtime.getRuntime().gc();
   }

   public static void cleanupAllResources() {
      if (GameConfig.getInstance().isMultiplayer()) {
         DecalManager.sub_173();
      }

      EffectManager.releaseEffectResources();
      Grenade.releaseResources();
      WeaponShop.staticCleanup();
      if (GameCanvas.getInstance().soundEnabled) {
         SoundManager.getInstance().sub_102();
      }

      BotMuzzleFlashManager.releaseMuzzleFlashResources();
      HUDManager.cleanupHUDResources();
      MenuSystem.cleanupMenuSystem();
      Runtime.getRuntime().gc();
   }
}
