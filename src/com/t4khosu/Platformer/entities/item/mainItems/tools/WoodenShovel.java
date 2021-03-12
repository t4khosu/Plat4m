package com.t4khosu.Platformer.entities.item.mainItems.tools;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class WoodenShovel extends Item {
	
	/**
	 * constructor
	 */
	public WoodenShovel() {
		
		this.sprite 		= Sprite.item_woodenShovel;
		this.type 			= ItemType.SHOVEL;
		this.description 	= "Ziemlich alt und schon oft genutzt.";
		this.name			= "Schaufel";
		this.value			= 0;
		
		ID = Item.woodenShovel_ID;
	}
}