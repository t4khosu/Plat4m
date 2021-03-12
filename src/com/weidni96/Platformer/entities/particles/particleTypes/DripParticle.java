package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class DripParticle extends GravityParticle{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public DripParticle(int color, double vFall, int x, int y, Level level) {
		super(x, y, level);

		this.vFall = vFall;
		this.life = 1000;
		
		this.sprite = new Sprite(1, 2, color);
	}
	
	/**
	 * move to next position
	 */
	protected void move(){
		if(collision()){
			remove();
		};
		if(y > level.getHeight()) removed = true;
		if(vFall < 0) dirY = -1;
		else dirY = 1;
		
		for(int i = 0; i < Math.abs(vFall); i++){
			if(life > 0){
				y += dirY;
			}
		}
		if(vFall < 3){
			vFall += (level.gravity)/5.0;
		}		
	}
}
