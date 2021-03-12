package com.weidni96.Platformer.entities.bullet.mobBullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class UndergroundBullet extends MobBullet{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dirX
	 * @param dirY
	 * @param level
	 */
	public UndergroundBullet(int x, int y, int dirX, int dirY, Level level) {
		super(x, y, dirX, dirY, level);
		sprite = Sprite.violet_bullet_sprite;
		poisonous = true;
		
		life = 60;
		speed = 3;
		damage = 5;
	}
}
