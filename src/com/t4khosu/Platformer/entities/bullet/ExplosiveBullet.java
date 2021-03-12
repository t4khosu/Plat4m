package com.t4khosu.Platformer.entities.bullet;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.particles.Spawner;
import com.t4khosu.Platformer.graphics.Sprite;

public class ExplosiveBullet extends GravitationBullet{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dir
	 * @param level
	 */
	public ExplosiveBullet(int x, int y, int dir, Level level) {
		super(x, y, dir, level);
		
		sprite = Sprite.orange_bullet_sprite;
		fireRate = 110;
		life     = 100;
		speed    = 2;
	}
	
	/**
	 * update bullet
	 */
	public void update(){
		if(life > 0) life--;
		else{
			new Spawner(x+4, y+4, 30, level, Spawner.ParticleType.EXPLOSION);
			remove();
		}
		move();
	}
	
	/**
	 * collision with wall
	 */
	protected boolean collision(int nx, int ny){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 4) + c%2) / 8;
			yy = ((ny + 3) + c/2) / 8;
			
			if(TileGetterList.getTile(xx, yy, level).isSolid()){
				if(!isBottomResistant()) life = 0;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * can't fall through floor
	 */
	protected boolean isBottomResistant(){
		return true;
	}
}
