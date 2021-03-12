package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * Tiles that can be mined (coal, iron, ...)
 * @author Christian
 *
 */
public class MineTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public MineTile(Sprite sprite){
		super(sprite);
	}
	
	@Override
	public boolean isSolid(){ return true; }
	@Override
	public boolean isMinable() { return true; }
}
