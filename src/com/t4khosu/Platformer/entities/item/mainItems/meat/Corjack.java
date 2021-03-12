package com.t4khosu.Platformer.entities.item.mainItems.meat;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Corjack extends Item {
	
	/**
	 * constructor
	 */
	public Corjack() {
		
		this.sprite = Sprite.item_corjack;
		this.type = ItemType.FOOD;
		this.description 	= "Gebraten \u00E4u\u00dferst schmackhaft!";
		this.name			= "Corjack";
		this.value			= 12;
		stackable = true;
		
		ID = Item.corjack_ID;
	}
}