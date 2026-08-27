package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;

public class CounterStrikeRoundManager extends GameRoundManager {
   private int terroristWins = 0;
   private int counterTerroristWins = 0;

   public final void initializeRound() {
      GameEntityManager.getInstance().respawnAllEntities();
      if (GameConfig.getInstance().isMultiplayer()) {
         DecalManager.sub_42().sub_106(MapLoader.getInstance().currentWorld);
      }

   }

   public final void startGamePlay() {
      InputHandler.sub_5f().handlePlayerAction(-1, false);
   }

   public final void sub_ee() {
      this.startRound();
   }

   public final void completeRound() {
      this.terroristWins = 0;
      this.counterTerroristWins = 0;
      GameInitializer.getInstance();
      GameInitializer.cleanupGameSession();
   }

   public final void onPlayerEliminated(GameEntity var1) {
      ChooseTeam var2;
      int var3 = (var2 = (ChooseTeam)var1).getTeamId();
      boolean var4 = true;
      Hashtable var5;
      Enumeration var6 = (var5 = GameEntityManager.getInstance().entityTable).keys();

      while(var6.hasMoreElements()) {
         Integer var7 = (Integer)var6.nextElement();
         ChooseTeam var8;
         if ((var8 = (ChooseTeam)var5.get(var7)).getTeamId() == var3 && var8.getHealth() > 0) {
            var4 = false;
            break;
         }
      }

      GameEntityManager.getInstance();
      if (var4) {
         if (var2.getTeamId() == 0) {
            super.earlyTerminationFlag = 2;
            ++this.counterTerroristWins;
            return;
         }

         super.earlyTerminationFlag = 1;
         ++this.terroristWins;
      }

   }
}
