package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Wheat extends Item {
	
	/**
	 * constructor
	 */
	public Wheat() {
		
		this.sprite 		= Sprite.item_wheat;
		this.type 			= ItemType.FOOD;
		this.description 	= "frischer Weizen";
		this.name			= "Weizen";
		this.value			= 12;
		stackable = true;
		
		ID = Item.wheat_ID;
	}
}