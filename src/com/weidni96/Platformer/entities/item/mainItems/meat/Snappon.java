package com.weidni96.Platformer.entities.item.mainItems.meat;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Snappon extends Item{
	
	/**
	 * constructor
	 */
	public Snappon() {
		
		this.sprite = Sprite.item_snappon;
		this.type = ItemType.FOOD;
		this.description 	= "Gebraten \u00E4u\u00dferst schmackhaft!";
		this.name			= "Snappon";
		this.value			= 50;
		stackable = true;
		
		ID = Item.snappon_ID;
	}
}