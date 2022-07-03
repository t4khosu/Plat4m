package com.t4khosu.Platformer.entities.item.mainItems.potions;

import com.t4khosu.Platformer.entities.item.Item;

public class HealthPotion extends Potion{
	
	/**
	 * constructor
	 */
	public HealthPotion(){
		super();
		this.description = "Heilt einige HP";
		this.name = "Heiltrank";
		this.strength = 1;
		this.color = 0xffDB4846;
		this.value	= 16;
		
		ID = Item.healthPotion_ID;
	}
}
