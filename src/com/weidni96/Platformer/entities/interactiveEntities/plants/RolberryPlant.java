package com.weidni96.Platformer.entities.interactiveEntities.plants;

import com.weidni96.Platformer.graphics.Screen;

public class RolberryPlant extends Plant{
	
	private int fruitColor = 0xffD82DB0;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public RolberryPlant(int x, int y) {
		super(x, y, 20000);
		sprite 		= as[growState].getSprite();
	}
	
	/**
	 * redner sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderPlant(x, y, sprite, fruitColor, true);
	}
}