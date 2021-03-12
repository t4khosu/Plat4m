package com.t4khosu.Platformer.entities.particles.particleTypes;

import com.t4khosu.Platformer.Level.Level;

public abstract class GravityParticle extends Particle{
	
	public GravityParticle(int x, int y, Level level) {
		super(x, y, level);
	}

	/**
	 * move to next position
	 */
	protected void move(){
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
