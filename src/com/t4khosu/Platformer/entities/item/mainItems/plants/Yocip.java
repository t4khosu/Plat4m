package com.t4khosu.Platformer.entities.item.mainItems.plants;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Yocip extends Item {
	
	/**
	 * constructor
	 */
	public Yocip() {
		
		this.sprite 		= Sprite.item_yocip;
		this.type 			= ItemType.BERRY;
		this.description 	= "Zum Verfeinern von Tr\u00E4nken";
		this.name			= "Yocip";
		this.value			= 23;
		stackable = true;
		
		ID = Item.yocip_ID;
	}
}