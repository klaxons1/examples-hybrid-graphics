package com.m3gworks.microcs; 
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.World;

public interface ChooseTeam {
   int getTeamId();

   int fireWeapon();

   int takeDamage(GameEntity var1, int var2, RayIntersection var3, World var4);

   int getHealth();

   WeaponShop getWeaponShop();

   Grenade getGranade();
}
