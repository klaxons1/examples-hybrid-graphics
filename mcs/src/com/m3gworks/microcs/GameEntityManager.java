package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.World;

public final class GameEntityManager {
   private static GameEntityManager instance;
   public GameEntity localPlayer;
   public Hashtable entityTable;

   private GameEntityManager() {
   }

   public static GameEntityManager getInstance() {
      if (instance == null) {
         instance = new GameEntityManager();
      }

      return instance;
   }

   public final void registerEntity(GameEntity var1) {
      if (this.entityTable == null) {
         this.entityTable = new Hashtable();
      }

      this.entityTable.put(new Integer(var1.entityId), var1);
      if (var1.entityId == 1) {
         this.localPlayer = var1;
      }

   }

   public final void initializeAllEntities(World var1) {
      Enumeration var2 = this.entityTable.keys();

      while(var2.hasMoreElements()) {
         Integer var3 = (Integer)var2.nextElement();
         ((GameEntity)this.entityTable.get(var3)).initialize(var1);
      }

   }

   public final void respawnAllEntities() {
      Enumeration var1 = this.entityTable.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         ((GameEntity)this.entityTable.get(var2)).respawn();
      }

   }

   public final void cleanupAllEntities() {
      Enumeration var1 = this.entityTable.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         ((GameEntity)this.entityTable.get(var2)).reset();
      }

      this.entityTable = null;
   }

   public final void updateAllEntities() {
      Enumeration var1 = this.entityTable.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         GameEntity var3;
         if ((var3 = (GameEntity)this.entityTable.get(var2)).isActive) {
            var3.model3D.setVisible(true);
            var3.updateBot();
         } else {
            var3.model3D.setVisible(false);
         }
      }

   }
}
