package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

/**
 * Tile that is partly transparent like glass
 * @author Christian
 *
 */
public class TransparentTile extends Tile{
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public TransparentTile(Sprite sprite){
		this.sprite = sprite;
	}
	
	@Override
	public void render(int x, int y, Screen screen){
		screen.renderTransparentSprite(x, y, sprite);
	}
}
