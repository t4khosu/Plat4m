package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

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
