package com.weidni96.Platformer.entities.item.mainItems.cds;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Sprite;

public class CD_1 extends Item {
	
	public CD_1(){
		this.sprite 		= Sprite.item_cd_1;
		this.collectSprite	= Sprite.get_money_sprite;
		this.type 			= ItemType.CD;
		this.value 			= 0;
		
		this.name			= "CD 1";
		this.description 	= "Wozu die wohl gut ist??";
		
		ID = Item.cd1_ID;
	}
}