package com.weidni96.Platformer.entities.item.mainItems.extras;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class SlimeBall extends Item{

public SlimeBall() {
		
		this.sprite 		= Sprite.item_slimeBall;
		this.type 			= ItemType.FOOD;
		stackable 			= true;
		this.name			= "Schleimball";
		this.description 	= "Seltsam, klebrige Substanz...";
		this.value 			= 10;
		
		ID = Item.slimeBall_ID;
	}
}
