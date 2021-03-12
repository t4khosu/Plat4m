package com.weidni96.Platformer.entities.item.mainItems.tools.Sword;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class UruSword extends Item{
	
	/**
	 * constructor
	 */
	public UruSword() {
		
		this.sprite 		= Sprite.item_uruSword;
		this.description 	= "TODO";
		this.name			= "TODO";
		this.damage			= 2;
		
		ID = Item.uruSword_ID;
	}
}