package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Special solid tile, that is only hard at one site
 * @author Christian
 *
 */
public class RightHardTile extends Tile{
	/**
	 * Constructor     
	 * @param sprite
	 */
	public RightHardTile(Sprite sprite) {
		super(sprite);
		
		//points for collision
		solidFrame[0][0] = 5; solidFrame[0][1] = 0;
		solidFrame[1][0] = 8; solidFrame[1][1] = 0;
		solidFrame[2][0] = 8; solidFrame[2][1] = 8;
		solidFrame[3][0] = 5; solidFrame[3][1] = 8;
	}
	
	@Override
	public boolean isPartlySolid(){ return true; }
}
