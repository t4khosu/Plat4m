package com.t4khosu.Platformer.entities.bullet.mobBullet;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class PoisonousBullet extends MobBullet{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dirX
	 * @param dirY
	 * @param level
	 */
	public PoisonousBullet(int x, int y, int dirX, int dirY, Level level) {
		super(x, y, dirX, dirY, level);
		sprite = Sprite.green_bullet_sprite;
		poisonous = true;
	}
}
