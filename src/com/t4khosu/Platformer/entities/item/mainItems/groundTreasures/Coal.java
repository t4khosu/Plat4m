package com.t4khosu.Platformer.entities.item.mainItems.groundTreasures;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class Coal extends Item {
	
	/**
	 * constructor
	 */
	public Coal(){
		
		this.sprite = Sprite.item_coal;
		this.type = ItemType.RAWMATERIAL;
		this.description 	= "Heizt im Winter";
		this.name			= "Kohle";
		this.value			= 15;
		
		this.collectSprite	= Sprite.get_coal_sprite;
		stackable = true;
		
		ID = Item.coal_ID;
	}
}