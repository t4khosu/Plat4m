package com.t4khosu.Platformer.entities.item.mainItems.tools;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class IronFishingPole extends Item {
	
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