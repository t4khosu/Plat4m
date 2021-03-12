package com.weidni96.Platformer.entities.item.mainItems.potions;

import com.weidni96.Platformer.entities.item.Item;

public class HealthPotion extends Potion{
	
	/**
	 * constructor
	 */
	public HealthPotion(){
		super();
		this.description = "Heilt wenig";
		this.name = "Heiltrank";
		this.strength = 1;
		this.color = 0xffDB4846;
		this.value	= 16;
		
		ID = Item.healthPotion_ID;
	}
}
