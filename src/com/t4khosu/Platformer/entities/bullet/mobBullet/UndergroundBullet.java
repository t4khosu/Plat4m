package com.t4khosu.Platformer.entities.bullet.mobBullet;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

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
