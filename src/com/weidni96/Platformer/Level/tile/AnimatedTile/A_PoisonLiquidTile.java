package com.weidni96.Platformer.Level.tile.AnimatedTile;

import com.weidni96.Platformer.graphics.AnimatedSprite;

/**
 * moving liquid tiles, that slow player (water) or even poison him (acid)
 * @author Christian
 *
 */
public class A_PoisonLiquidTile extends A_LiquidTile{

	/**
	 * Constructor
	 * @param as
	 */
	public A_PoisonLiquidTile(AnimatedSprite as) {
		super(as);
	}

	@Override
	public int damage(){
		return 5;
	}
}
