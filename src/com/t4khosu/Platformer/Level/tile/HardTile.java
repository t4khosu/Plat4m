package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Solid tile plaer caan move on (ground)
 * @author Christian
 *
 */
public class HardTile extends Tile{

	/**
	 * Constructor
	 * @param sprite
	 */
	public HardTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid(){ return true; }
}
