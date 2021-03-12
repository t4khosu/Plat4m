package com.weidni96.Platformer.entities.item.mainItems.meat;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Pompbass extends Item{
	
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