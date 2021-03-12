package com.t4khosu.Platformer.Level.tile.AnimatedTile;

import com.t4khosu.Platformer.graphics.AnimatedSprite;

/**
 * for backgrounds, like a waterfall
 * @author Christian
 *
 */
public class A_BackgroundTile extends AnimatedTile{

	/**
	 * Constructor
	 * @param as
	 */
	public A_BackgroundTile(AnimatedSprite as) {
		super(as);
	}
	
	@Override
	public void update(){
		as.update();
		sprite = as.getSprite();
	}

}
