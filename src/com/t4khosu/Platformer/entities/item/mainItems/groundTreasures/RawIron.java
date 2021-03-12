package com.t4khosu.Platformer.entities.item.mainItems.groundTreasures;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class RawIron extends Item {
	
	/**
	 * constructor
	 */
	public RawIron() {
		
		this.sprite 		= Sprite.rawIron_sprite;
		this.type 			= ItemType.RAWMATERIAL;
		this.description 	= "Muss geschmolzen werden.";
		this.name			= "Roheisen";
		this.value			= 19;
		this.collectSprite	= Sprite.get_rawIron_sprite;
		
		stackable = true;
		
		ID = Item.rawIron_ID;
	}
}