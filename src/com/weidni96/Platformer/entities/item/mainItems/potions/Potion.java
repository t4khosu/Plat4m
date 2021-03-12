package com.weidni96.Platformer.entities.item.mainItems.potions;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public abstract class Potion extends Item{
	
	protected int strength;
	protected int color;
	
	/**
	 * constructor
	 */
	public Potion() {
		this.type 			= ItemType.POTION;
		this.sprite 		= Sprite.potion_sprite;
		this.description 	= "empty";
		this.name			= "empty";
		this.value			= 0;
		stackable = true;
		
		this.color			= 0;
		this.strength		= 0;
		
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen, int xx, int yy){
		screen.renderPotion(xx, yy, color, false);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getColor(){
		return color;
	}
}