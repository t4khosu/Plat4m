package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Tiles that can be climbed (ladders)
 * @author Christian
 *
 */
public class ClimbTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public ClimbTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isClimbable(){ return true;}
}
