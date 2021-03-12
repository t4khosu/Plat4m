package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class WheatSeed extends Item {
	
	/**
	 * constructor
	 */
	public WheatSeed() {
		
		this.sprite 		= Sprite.item_wheatSeed;
		this.type 			= ItemType.SEEDS;
		this.description 	= "Zum Pflanzen von Weizen.";
		this.name			= "Weizen Samen";
		this.value			= 8;
		stackable = true;
		
		ID = Item.wheatSeed_ID;
	}
}