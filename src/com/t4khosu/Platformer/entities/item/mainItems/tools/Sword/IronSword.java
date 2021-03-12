package com.t4khosu.Platformer.entities.item.mainItems.tools.Sword;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class IronSword extends Sword{
	
	/**
	 * constructor
	 */
	public IronSword() {
		this.sprite 		= Sprite.item_ironSword;
		this.description 	= "Aus geschmiedeten Eisen gefertigt.";
		this.name			= "Eisernes Schwert";
		this.damage			= 2;
		
		ID = Item.ironSword_ID;
	}
}