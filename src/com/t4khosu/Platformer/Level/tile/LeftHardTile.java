package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * solid tile with special size
 * @author Christian
 *
 */
public class LeftHardTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public LeftHardTile(Sprite sprite) {
		super(sprite);
		
		//choose points where tile is hard (collision)
		solidFrame[0][0] = 0; solidFrame[0][1] = 0;
		solidFrame[1][0] = 4; solidFrame[1][1] = 0;
		solidFrame[2][0] = 4; solidFrame[2][1] = 8;
		solidFrame[3][0] = 0; solidFrame[3][1] = 8;
	}
	
	@Override
	public boolean isPartlySolid(){ return true; }
}