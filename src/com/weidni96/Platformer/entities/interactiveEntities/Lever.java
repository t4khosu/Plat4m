package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Lever extends InteractiveEntity{
	
	private boolean on;
	private int id;
	private boolean switchable;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param id
	 * @param switchable
	 */
	public Lever(int x, int y, int id, boolean switchable){
		super(x, y);
		
		on = false;
		this.id = id;
		this.switchable = switchable;
		sprite = Sprite.lever_OFF_sprite;
	}
	
	/**
	 * check if switchable -> switch + change sprite
	 */
	public void switchLever(){
		if(on && switchable){
			on = false;
			sprite = Sprite.lever_OFF_sprite;
		}
		else{
			on = true;
			sprite = Sprite.lever_ON_sprite;
		}
	}
	
	/**
	 * switch lever even when for player not switchable
	 */
	public void superSwitchLever(){
		if(on){
			on = false;
			sprite = Sprite.lever_OFF_sprite;
		}
		else{
			on = true;
			sprite = Sprite.lever_ON_sprite;
		}
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean isOn(){
	    return on;
	}
}