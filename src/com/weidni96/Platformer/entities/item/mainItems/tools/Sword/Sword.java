package com.weidni96.Platformer.entities.item.mainItems.tools.Sword;

import com.weidni96.Platformer.entities.item.Item;

public class Sword extends Item{
	
	protected int level = 0;
	public Sword(){
		this.type 			= ItemType.SWORD;
		this.value			= 0;
		this.level 			= 0;
	}
	
	@Override
	public int getDamage(){
		return (int)(damage * Math.pow(1.4, level));
	}
}
