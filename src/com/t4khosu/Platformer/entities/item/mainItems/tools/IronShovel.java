package com.t4khosu.Platformer.entities.item.mainItems.tools;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class IronShovel extends Item {
	
	/**
	 * constructor
	 */
	public IronShovel() {
		
		this.sprite 		= Sprite.item_ironShovel;
		this.type 			= ItemType.SHOVEL;
		this.description 	= "Alt und oft genutzt.";
		this.name			= "Schaufel";
		this.value			= 50;
		
		ID = Item.ironShovel_ID;
	}
}