package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class RolberrySeed extends Item {
	
	/**
	 * constructor
	 */
	public RolberrySeed() {
		
		this.sprite 		= Sprite.item_rolberrySeed;
		this.type 			= ItemType.SEEDS;
		this.description 	= "Zum Pflanzen von Rol Beeren.";
		this.name			= "Rol Beeren Samen";
		this.value			= 2;
		stackable = true;
		
		ID = Item.rolberrySeed_ID;
	}
}