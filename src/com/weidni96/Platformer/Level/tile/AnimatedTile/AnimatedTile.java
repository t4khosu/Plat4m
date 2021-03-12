package com.weidni96.Platformer.Level.tile.AnimatedTile;

import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.graphics.AnimatedSprite;

/**
 * Animated tile for moving stuff inside a tile, like a flower, water ....
 * @author Christian
 *
 */
public abstract class AnimatedTile extends Tile{

	protected AnimatedSprite as;
	
	/**
	 * Constructor
	 * @param as
	 */
	public AnimatedTile(AnimatedSprite as) {
		this.as = as;
		sprite = as.getSprite();
	}
	
	/**
	 * animate tile here
	 */
	@Override
	public void update(){
	}
}
