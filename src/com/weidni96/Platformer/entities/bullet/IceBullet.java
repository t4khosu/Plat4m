package com.weidni96.Platformer.entities.bullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class IceBullet extends GravitationBullet{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dir
	 * @param level
	 */
	public IceBullet(int x, int y, int dir, Level level) {
		super(x, y, dir, level);
		
		sprite = Sprite.blue_bullet_sprite;
		fireRate = 30;
		life = 60;
		speed = 3;
		vFall = -2.5;
		damage = 4;
	}
}
