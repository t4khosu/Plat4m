package com.weidni96.Platformer.Level.tile;

import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

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
