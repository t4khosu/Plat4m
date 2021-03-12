package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * tile that can be destroyed with a tool (pickaxe)
 * @author Christian
 *
 */
public class BreakableTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public BreakableTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isBreakable(){return true;}
	@Override
	public boolean isSolid(){return true;}
}
