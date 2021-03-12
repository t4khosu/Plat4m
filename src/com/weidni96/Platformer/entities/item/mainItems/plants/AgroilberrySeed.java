package com.weidni96.Platformer.entities.item.mainItems.plants;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class AgroilberrySeed extends Item{
	
	/**
	 * constructor
	 */
	public AgroilberrySeed() {
		
		this.sprite 		= Sprite.item_agroilberrySeed;
		this.type 			= ItemType.SEEDS;
		this.description 	= "Zum Pflanzen von Agroil Beeren.";
		this.name			= "Agroil Beeren Samen";
		this.value			= 4;
		stackable = true;
		
		ID = Item.agroilberrySeed_ID;
	}
}