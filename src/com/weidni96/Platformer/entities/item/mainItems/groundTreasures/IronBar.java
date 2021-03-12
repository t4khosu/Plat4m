package com.weidni96.Platformer.entities.item.mainItems.groundTreasures;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class IronBar extends Item{

	/**
	 * constructor
	 */
	public IronBar() {
		
		this.sprite 		= Sprite.ironBar_sprite;
		this.type 			= ItemType.RAWMATERIAL;
		this.description 	= "Fertiger Eisenbarren";
		this.name			= "Eisenbarren";
		this.value			= 42;
		this.collectSprite	= Sprite.get_rawIron_sprite;
		
		stackable = true;
		
		ID = Item.ironBar_ID;
	}
}
