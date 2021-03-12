package com.weidni96.Platformer.entities.bullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.graphics.Sprite;

public class SniperBullet extends Bullet{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dir
	 * @param level
	 */
	public SniperBullet(int x, int y, int dir, Level level) {
		super(x, y, dir, level);
		
		sprite = Sprite.green_bullet_sprite;
		fireRate = 100;
		life = 200;
		speed = 8;
		damage = 5;
	}
	
	/**
	 * collision with mob or wall
	 */
	protected boolean collision(int nx){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 3) + c%2 * 4) / 8;
			yy = ((y  + 3) + c/2 * 4) / 8; 
			
			Mob m = null;	
			if((m = level.getEnemyAt(xx, yy)) != null){
				m.hit(damage);
				life = 0;
				return true;
			}
			
		}
		return false;
	}
}
