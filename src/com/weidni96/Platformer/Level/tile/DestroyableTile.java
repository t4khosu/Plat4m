package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * Tiles that can be destroyed with one hit (grass using a sword)
 * @author Christian
 *
 */
public class DestroyableTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public DestroyableTile(Sprite sprite){
		super(sprite);
	}
	
	@Override
	public boolean isDestroyable(){ return true;}
}
