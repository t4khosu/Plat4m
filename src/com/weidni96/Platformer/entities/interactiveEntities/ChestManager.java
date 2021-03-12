package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.entities.interactiveEntities.Chest.ChestType;
import com.weidni96.Platformer.entities.item.Item;

public class ChestManager {
	
	//Neuleben:
	public static Chest woodenFishingPole_neuleben 	= new Chest(4*8, 40*8, Item.woodenFishingPole_ID, 1, false, null, ChestType.WOODEN);
	public static Chest rolBerrySeed_neuleben 		= new Chest(21*8, 45*8, Item.rolberrySeed_ID, 16, false, null, ChestType.WOODEN);
	public static Chest agroilBerrySeed_neuleben 	= new Chest(31*8, 33*8, Item.agroilberrySeed_ID, 8, true, null, ChestType.WOODEN);
	public static Chest ironBar_neuleben 			= new Chest(13*8, 36*8, Item.ironBar_ID, 2, true, null, ChestType.UNDERGROUND);
	
	//Village Forest
	public static Chest woodenPickaxe_villageForest = new Chest(34*8, 47*8, Item.woodenPickaxe_ID, 1, true, null, ChestType.GOLD);
	public static Chest money_villageForest 		= new Chest(1*8, 28*8, Item.money_ID, 20, true, null, ChestType.WOODEN);
	public static Chest coal_villageForest 			= new Chest(83*8, 17*8, Item.coal_ID, 21, false, null, ChestType.WOODEN);
	
	//Haunted Forest
	public static Chest money_hauntedForest 		= new Chest(48*8, 48*8, Item.money_ID, 100, 	  true, null, ChestType.WOODEN);
	public static Chest agroilBerry_hauntedForest 	= new Chest(72*8, 43*8, Item.agroilberry_ID, 4, true, null, ChestType.UNDERGROUND);
	public static Chest healthPotion_hauntedForest 	= new Chest(1*8, 10*8, Item.healthPotion_ID, 3, true, null, ChestType.UNDERGROUND);
	public static Chest rolBerrySeed_hauntedForest 	= new Chest(57*8, 4*8, Item.rolberrySeed_ID, 4, true, null, ChestType.UNDERGROUND);
	
	//Dungeon 01
	public static Chest money_dungeon01 			= new Chest(22*8, 14*8, Item.money_ID, 40, true, null, ChestType.UNDERGROUND);
	public static Chest cd1_dungeon01 				= new Chest(66*8, 63*8, Item.cd1_ID, 1, true, null, ChestType.UNDERGROUND);
	public static Chest boots_dungeon01 			= new Chest(60*8, 18*8, Item.boots_ID, 1, true, null, ChestType.GOLD);
	public static Chest rawIron_dungeon01 			= new Chest(26*8, 3*8, Item.rawIron_ID, 6, true, null, ChestType.WOODEN);
	
	
	public static Chest[] chestList = {
			woodenFishingPole_neuleben,
			rolBerrySeed_neuleben,
			agroilBerrySeed_neuleben,
			ironBar_neuleben,
			woodenPickaxe_villageForest,
			money_villageForest,
			coal_villageForest,
			money_hauntedForest,
			agroilBerry_hauntedForest,
			healthPotion_hauntedForest,
			rolBerrySeed_hauntedForest,
			money_dungeon01,
			cd1_dungeon01,
			boots_dungeon01,
			rawIron_dungeon01
	};
}
