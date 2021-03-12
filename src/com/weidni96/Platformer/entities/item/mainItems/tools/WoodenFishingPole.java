package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class WoodenFishingPole extends Item{
	
	/**
	 * constructor
	 */
	public WoodenFishingPole() {
		
		this.sprite 		= Sprite.item_woodenFishingPole;
		this.type 			= ItemType.POLE;
		this.description 	= "Ein simpler Stock mit einer Schnur.";
		this.name			= "Einfache Angelrute";
		this.value			= 0;
		
		ID = Item.woodenFishingPole_ID;
	}
}