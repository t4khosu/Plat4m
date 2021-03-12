package com.t4khosu.Platformer.entities.item.mainItems.tools.Sword;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class WoodenSword extends Sword{
	
	/**
	 * constructor
	 */
	public WoodenSword() {
		this.sprite 		= Sprite.item_woodenSword;
		this.description 	= "Aus einer alten Eiche gefertigt.";
		this.name			= "Holzschwert";
		this.damage			= 2;
		
		ID = Item.woodenSword_ID;
	}
}