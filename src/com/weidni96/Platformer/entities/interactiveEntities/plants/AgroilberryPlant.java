package com.weidni96.Platformer.entities.interactiveEntities.plants;

import com.weidni96.Platformer.graphics.Screen;

public class AgroilberryPlant extends Plant{
	
	private int fruitColor = 0xffA30013;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public AgroilberryPlant(int x, int y) {
		super(x, y, 20000);
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