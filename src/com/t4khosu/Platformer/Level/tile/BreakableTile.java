package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

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
