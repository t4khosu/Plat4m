package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class UruShovel extends Item{
	
	/**
	 * constructor
	 */
	public UruShovel() {
		
		this.sprite 		= Sprite.item_uruShovel;
		this.type 			= ItemType.SHOVEL;
		this.description 	= "Ziemlich alt und schon oft genutzt.";
		this.name			= "Schaufel";
		this.value			= 50;
		
		ID = Item.uruShovel_ID;
	}
}