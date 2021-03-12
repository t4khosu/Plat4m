package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * Player can only move to the right once he is inside this force tile
 * @author Christian
 *
 */
public class ForceLeftTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public ForceLeftTile(Sprite sprite){
		super(sprite);
	}
	
	@Override
	public boolean isSideSolid(int dirX){
		if(dirX < 0) return false;
		return true;
	}
}
