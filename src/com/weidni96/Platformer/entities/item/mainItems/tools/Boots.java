package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Boots extends Item{
	
	/**
	 * constructor
	 */
	public Boots() {
		
		this.sprite 		= Sprite.item_boots;
		this.type 			= ItemType.TOOLS;
		this.description 	= "Nun kannst du einen Doppelsprung ausf\u00FChren";
		this.name			= "Sprungschuhe";
		this.value			= 0;
		this.damage			= 0;
		
		ID = Item.boots_ID;
	}
}