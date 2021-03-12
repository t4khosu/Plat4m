package com.weidni96.Platformer.entities.item.mainItems.plants;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Agroilberry extends Item{
	
	/**
	 * constructor
	 */
	public Agroilberry() {
		
		this.sprite 		= Sprite.item_agroilberry;
		this.type 			= ItemType.BERRY;
		this.description 	= "Heilt 5SP";
		this.name			= "Agroil Beere";
		this.value			= 5;
		stackable = true;
		
		ID = Item.agroilberry_ID;
	}
}
