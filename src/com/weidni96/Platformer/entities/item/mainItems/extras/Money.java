package com.weidni96.Platformer.entities.item.mainItems.extras;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class Money extends Item{
	
	/**
	 * constructor
	 */
	public Money() {
		
		this.sprite 		= Sprite.big_money;
		this.type 			= ItemType.MONEY;
		stackable 			= true;
		this.name			= "Rul";
		this.description 	= "Kann benutzt werden um neue Items zu kaufen";
		
		this.collectSprite	= Sprite.get_money_sprite;
		
		ID = Item.money_ID;
	}
}