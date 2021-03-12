package com.t4khosu.Platformer.entities.interactiveEntities.plants;

import com.t4khosu.Platformer.graphics.AnimatedSprite;

public class WheatPlant extends Plant{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public WheatPlant(int x, int y) {
		super(x, y, 40000);
		
		as[0] = AnimatedSprite.plant21;
		as[1] = AnimatedSprite.plant22;
		as[2] = AnimatedSprite.plant23;
		as[3] = AnimatedSprite.plant24;
		sprite = as[growState].getSprite();
		
		growStates = as.length;
	}
}
