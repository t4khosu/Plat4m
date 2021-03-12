package com.t4khosu.Platformer.entities.item.mainItems.meat;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Snappon extends Item {
	
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