package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

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
