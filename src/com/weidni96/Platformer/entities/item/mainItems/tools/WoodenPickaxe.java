package com.weidni96.Platformer.entities.item.mainItems.tools;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class WoodenPickaxe extends Item{
	
	/**
	 * constructor
	 */
	public WoodenPickaxe() {
		
		this.sprite 		= Sprite.item_woodenPickaxe;
		this.type 			= ItemType.PICKAXE;
		this.description 	= "Zerhaut jeden, alten Stein.";
		this.name			= "Spitzhacke";
		this.value			= 0;
		this.staminaUse 	= 40;
		
		ID = Item.woodenPickaxe_ID;
	}
}