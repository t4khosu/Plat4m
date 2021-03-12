package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * UnderWater Tile for letting player drown (muhaha)
 * @author Christian
 *
 */
public class UnderWaterPoison extends UnderWater{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public UnderWaterPoison(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public int damage(){
		return 5;
	}
}
