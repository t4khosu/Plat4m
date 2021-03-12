package com.t4khosu.Platformer.entities.item.mainItems.meat;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Pompbass extends Item {
	
	/**
	 * constructor
	 */
	public Pompbass() {
		
		this.sprite = Sprite.item_pompbass;
		this.type = ItemType.FOOD;
		this.description 	= "Gebraten \u00E4u\u00dferst schmackhaft!";
		this.name			= "Pompbass";
		this.value			= 50;
		stackable = true;
		
		ID = Item.pompbass_ID;
	}
}