package com.t4khosu.Platformer.entities.enemies.slimes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class PoisonSlime extends Slime{
	
	
	public PoisonSlime(int x, int y, Level level) {
		super(x, y, Sprite.slime2_0, level);
		
		actTime 	= 75;
		jumpForce = -6.0;
		
		sprites[0] = Sprite.slime2_0;
		sprites[1] = Sprite.slime2_1;
		sprites[2] = Sprite.slime2_2;
		
		this.sprite = sprites[0];
		this.name 		= "Giftschleim";
		collisionDamage = 4;
		experience 		= 260;
		money 			= 4;
		lvl 			= 6;
		initLife(42);
	}
}
