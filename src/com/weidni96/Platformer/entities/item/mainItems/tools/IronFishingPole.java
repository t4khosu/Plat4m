package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class IronFishingPole extends Item{
	
	/**
	 * constructor
	 */
	public IronFishingPole() {
		
		this.sprite 		= Sprite.item_ironFishingPole;
		this.type 			= ItemType.POLE;
		this.description 	= "Ein simpler Stock mit einer Schnur.";
		this.name			= "Einfache Angelrute";
		this.value			= 50;
		
		ID = Item.ironFishingPole_ID;
	}
}