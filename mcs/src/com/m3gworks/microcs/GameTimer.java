package com.m3gworks.microcs; 
import java.util.TimerTask;

public final class GameTimer extends TimerTask {
   public int TimerValue;

   public GameTimer(int var1) {
      this.TimerValue = var1 + 1;
   }

   public final void run() {
      --this.TimerValue;
      if (this.TimerValue == 0) {
         this.cancel();
      }

   }
}
