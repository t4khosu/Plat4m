package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * Some tile that contains nothing
 * @author Christian
 *
 */
public class VoidTile extends Tile{

	/**
	 * Constructor
	 * @param sprite
	 */
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isVoid() { return true; }
}
