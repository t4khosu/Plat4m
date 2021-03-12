package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Sprite;

/**
 * special solid tile that is only partly solid
 * @author Christian
 *
 */
public class BottomHardTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public BottomHardTile(Sprite sprite){
		super(sprite);
		
		//points needed for collision
		solidFrame[0][0] = 0; solidFrame[0][1] = 4;
		solidFrame[1][0] = 8; solidFrame[1][1] = 4;
		solidFrame[2][0] = 8; solidFrame[2][1] = 8;
		solidFrame[3][0] = 0; solidFrame[3][1] = 8;
	}
	
	@Override
	public boolean isPartlySolid(){ return true; }
	
}
