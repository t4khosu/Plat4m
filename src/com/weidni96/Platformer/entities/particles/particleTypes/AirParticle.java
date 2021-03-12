/**
 * white, 1 pixel particle, created when player is under water
 */

package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class AirParticle extends Particle{

	private double yMove = 0;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public AirParticle(int x, int y, Level level) {
		super(x, y, level);
		sprite = Sprite.air_particle_sprite;
		life = 20;
		dirX = 0;
		dirY = -0.2;
	}
	
	/**
	 * move to next position, upwards
	 */
	public void move(){
		yMove += dirY;
		if(yMove <= -1){
			y += -1;
			yMove += 1;
		}
	}

}
