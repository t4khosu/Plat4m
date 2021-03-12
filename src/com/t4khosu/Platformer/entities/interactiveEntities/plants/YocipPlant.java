package com.t4khosu.Platformer.entities.interactiveEntities.plants;

import com.t4khosu.Platformer.graphics.Screen;

public class YocipPlant extends Plant{

	private int fruitColor = 0xff36B500;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public YocipPlant(int x, int y) {
		super(x, y, 30000);
		sprite 		= as[growState].getSprite();
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderPlant(x, y, sprite, fruitColor, true);
	}
}