package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class UruFishingPole extends Item{
	
	/**
	 * constructor
	 */
	public UruFishingPole() {
		
		this.sprite 		= Sprite.item_uruFishingPole;
		this.type 			= ItemType.POLE;
		this.description 	= "Ein simpler Stock mit einer Schnur.";
		this.name			= "Einfache Angelrute";
		this.value			= 50;
		
		ID = Item.uruFishingPole_ID;
	}
}