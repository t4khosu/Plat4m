package com.t4khosu.Platformer.entities.item.mainItems.tools;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;

public class IronPickaxe extends Item {
	
	/**
	 * constructor
	 */
	public IronPickaxe() {
		
		this.sprite 		= Sprite.item_ironPickaxe;
		this.type 			= ItemType.PICKAXE;
		this.description 	= "Zerhaut jeden, alten Stein.";
		this.name			= "Spitzhacke";
		this.value			= 50;
		this.staminaUse 	= 40;
		
		ID = Item.ironPickaxe_ID;
	}
}