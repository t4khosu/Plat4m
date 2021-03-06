package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Tiles that can be plowed (dirt)
 * @author Christian
 *
 */
public class PlowTile extends Tile{

	/**
	 * Constructor
	 * @param sprite
	 */
	public PlowTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid()		 { return true; }
	@Override
	public boolean isPlowable()		 { return true; }
}
