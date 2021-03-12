package com.weidni96.Platformer.entities.bullet.mobBullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

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
