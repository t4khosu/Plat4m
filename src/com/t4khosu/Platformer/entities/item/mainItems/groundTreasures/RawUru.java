package com.t4khosu.Platformer.entities.item.mainItems.groundTreasures;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class RawUru extends Item {
	
	/**
	 * constructor
	 */
	public RawUru() {
		
		this.sprite = Sprite.item_rawUru;
		this.type = ItemType.RAWMATERIAL;
		this.description 	= "Rohstoff f\u00FCr das h\u00E4rteste Metall";
		this.name			= "Rohuru";
		this.value			= 50;
		
		this.collectSprite	= Sprite.get_uru_sprite;
		stackable = true;
		
		ID = Item.rawUru_ID;
	}
}