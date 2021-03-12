package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class AgroilberrySeed extends Item {
	
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