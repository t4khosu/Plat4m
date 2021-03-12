package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Simple field tile player can plant on
 * @author Christian
 *
 */
public class FieldTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public FieldTile(Sprite sprite){
		super(sprite);
	}
	
	@Override
	public boolean isSolid(){ return true; }
	@Override
	public boolean isPlantable(){ return true; }
}
