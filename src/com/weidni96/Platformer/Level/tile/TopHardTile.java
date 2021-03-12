package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Sprite;

/**
 * Special hard tile for certain area
 * @author Christian
 *
 */
public class TopHardTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public TopHardTile(Sprite sprite){
		super(sprite);
		
		//choose points for collision
		solidFrame[0][0] = 0; solidFrame[0][1] = 0;
		solidFrame[1][0] = 8; solidFrame[1][1] = 0;
		solidFrame[2][0] = 8; solidFrame[2][1] = 4;
		solidFrame[3][0] = 0; solidFrame[3][1] = 4;
	}
	
	@Override
	public boolean isPartlySolid(){ return true; }
}
