package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Player can only move to the right once he is inside this force tile
 * @author Christian
 *
 */
public class ForceDownTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public ForceDownTile(Sprite sprite){
		super(sprite);
	}
	
	@Override
	public boolean forcesDown(){
		return true;
	}
}
