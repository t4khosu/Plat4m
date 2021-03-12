package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

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
