package com.weidni96.Platformer.entities.enemies.slimes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.graphics.Sprite;

public class UndergroundSlime extends Slime{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 */
	public UndergroundSlime(int x, int y, Level level) {
		super(x, y, Sprite.slime1_0, level);
		
		actTime 	= 70;
		jumpForce = -3.5;
		
		sprites[0] = Sprite.slime1_0;
		sprites[1] = Sprite.slime1_1;
		sprites[2] = Sprite.slime1_2;
		
		this.name = "H\u00F6hlenschleim";
		collisionDamage = 4;
		experience = 140;
		initLife(23);
		shield = 1;
		money = 3;
		lvl = 3;
	}
}