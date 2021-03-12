package com.weidni96.Platformer.Level.tile.AnimatedTile;

import com.weidni96.Platformer.graphics.AnimatedSprite;

/**
 * moving liquid tiles, that slow player (water) or even poison him (acid)
 * @author Christian
 *
 */
public class A_LiquidTile extends AnimatedTile{

	/**
	 * Constructor
	 * @param as
	 */
	public A_LiquidTile(AnimatedSprite as) {
		super(as);
	}
	
	@Override
	public void update(){
		as.update();
		sprite = as.getSprite();
	}

	@Override
	public boolean slows(){ return true; }
	@Override
	public boolean isFishable(){ return true; }
}
