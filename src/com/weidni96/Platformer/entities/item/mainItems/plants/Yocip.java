package com.weidni96.Platformer.entities.item.mainItems.plants;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Yocip extends Item{
	
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