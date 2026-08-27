package com.m3gworks.microcs; 
public class Game3DCleanUpper extends GameCanvas3D {
   public final void updateGameEffects() {
      EffectManager.getInstance().updateAllEffects();
      BotMuzzleFlashManager.getInstance().updateMuzzleFlashes();
      MapLoader.getInstance().cleanupEnvironment();
   }
}
