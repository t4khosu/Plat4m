package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * UnderWater Tile for letting player drown (muhaha)
 * @author Christian
 *
 */
public class UnderWater extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public UnderWater(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isUnderWater() { return true; }
	@Override
	public boolean isFishable() { return true; }
	@Override
	public boolean slows() { return true; }
}
