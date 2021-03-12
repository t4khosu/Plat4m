package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Tiles that damage the player (spikes)
 * @author Christian
 *
 */
public class DamageTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public DamageTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public int damage(){
		return 3;
	}
}
