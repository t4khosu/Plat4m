package com.t4khosu.Platformer.entities.bullet;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.particles.Spawner;
import com.t4khosu.Platformer.graphics.Sprite;

public class FireBullet extends Bullet{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dir
	 * @param level
	 */
	public FireBullet(int x, int y, int dir, Level level) {
		super(x, y, dir, level);
		
		sprite = Sprite.red_bullet_sprite;
		fireRate = 40;
		life = 20;
		speed = 3;
	}
	
	/**
	 * update bullet, create sparks
	 */
	public void update(){
		if(Game.timer%2 == 0){
			new Spawner(x+4, y+4, 3, level, Spawner.ParticleType.FIRE);
		}
		if(life > 0) life--;
		else remove();
		
		move();
	}

}
