package com.weidni96.Platformer.entities.bullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class StandardBullet extends Bullet{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dir
	 * @param level
	 */
	public StandardBullet(int x, int y, int dir, Level level) {
		super(x, y, dir, level);
		
		sprite = Sprite.standard_bullet_sprite;
		fireRate = 10;
		life = 20;
	}
}
