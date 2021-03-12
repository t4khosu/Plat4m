package com.weidni96.Platformer.entities.item.mainItems.tools.Sword;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

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