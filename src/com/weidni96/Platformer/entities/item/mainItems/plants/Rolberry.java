package com.weidni96.Platformer.entities.item.mainItems.plants;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Rolberry extends Item{
	
	/**
	 * constructor
	 */
	public Rolberry() {
		
		this.sprite 		= Sprite.item_rolberry;
		this.type 			= ItemType.BERRY;
		this.description 	= "Grundlage f\u00FCr Heiltr\u00E4nke, heilt 4HP";
		this.name			= "Rolberry";
		this.value			= 4;
		stackable = true;
		
		ID = Item.rolberry_ID;
	}
}