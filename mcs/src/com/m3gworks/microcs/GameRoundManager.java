package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import java.util.Timer;

public abstract class GameRoundManager implements Runnable {
   private static GameRoundManager instance;
   public int gameState = 5;
   public GameTimer roundTimer;
   public int earlyTerminationFlag = 0;

   public static GameRoundManager getInstance() {
      if (instance == null) {
         try {
            instance = (GameRoundManager) GameConfig.getInstance().sub_14f().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return instance;
   }

   public final void startRound() {
      if (this.gameState == 4 || this.gameState == 5) {
         Thread var1 = new Thread(this);
         this.earlyTerminationFlag = 0;
         var1.start();
      }
   }

   public void run() {
      GameCanvas3D var1 = GameCanvas3D.createInstance();
      GameMIDlet.sub_f().var_3a.setCurrent(var1);
      this.initializeRound();
      this.gameState = 1;
      Timer var2 = new Timer();
      this.roundTimer = new GameTimer(GameConfig.getInstance().sub_3bd());
      var2.schedule(this.roundTimer, 0L, 1000L);

      while(this.gameState != 4 && this.gameState != 5) {
         try {
            var1.renderFrame();
            if (this.gameState == 1 && this.roundTimer.TimerValue == 0) {
               this.gameState = 2;
               this.roundTimer = null;
               if (MapLoader.getInstance().getCurrentMap().isEnabled) {
                  this.roundTimer = new GameTimer(180);
                  var2.schedule(this.roundTimer, 0L, 1000L);
               }
            }

            if (this.gameState == 2) {
               if (MapLoader.getInstance().getCurrentMap().isEnabled && this.roundTimer.TimerValue == 0 || this.earlyTerminationFlag != 0) {
                  this.gameState = 3;
                  this.startGamePlay();
                  if (MapLoader.getInstance().getCurrentMap().isEnabled) {
                     this.roundTimer.cancel();
                  }

                  this.roundTimer = new GameTimer(GameConfig.getInstance().sub_3d3());
                  var2.schedule(this.roundTimer, 0L, 1000L);
               }
            } else if (this.gameState == 3 && this.roundTimer.TimerValue == 0) {
               this.gameState = 4;
            }

            Thread.yield();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      if (this.gameState == 5) {
         this.completeRound();
      }

      if (this.gameState == 4) {
         this.sub_ee();
      }

   }

   public abstract void initializeRound();

   public abstract void startGamePlay();

   public abstract void sub_ee();

   public abstract void completeRound();
}
