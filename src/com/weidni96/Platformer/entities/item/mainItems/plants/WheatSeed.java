package com.weidni96.Platformer.entities.item.mainItems.plants;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class WheatSeed extends Item{
	
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