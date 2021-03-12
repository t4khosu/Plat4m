package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class IronShovel extends Item{
	
	/**
	 * constructor
	 */
	public IronShovel() {
		
		this.sprite 		= Sprite.item_ironShovel;
		this.type 			= ItemType.SHOVEL;
		this.description 	= "Ziemlich alt und schon oft genutzt.";
		this.name			= "Schaufel";
		this.value			= 50;
		
		ID = Item.ironShovel_ID;
	}
}