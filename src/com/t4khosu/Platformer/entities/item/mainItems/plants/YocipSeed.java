package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class YocipSeed extends Item {
	
	/**
	 * constructor
	 */
	public YocipSeed() {
		
		this.sprite 		= Sprite.item_yocipSeed;
		this.type 			= ItemType.SEEDS;
		this.description 	= "Zum Pflanzen von Yocip.";
		this.name			= "Yocip Samen";
		this.value			= 18;
		stackable = true;
		
		ID = Item.yocipSeed_ID;
	}
}