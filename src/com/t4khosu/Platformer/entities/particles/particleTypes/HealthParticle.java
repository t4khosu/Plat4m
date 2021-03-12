/**
 * red cross Particle, created when player gets new health
 */

package com.t4khosu.Platformer.entities.particles.particleTypes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class HealthParticle extends Particle{
	
	private double yMove = 0;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public HealthParticle(int x, int y, Level level) {
		super(x, y, level);
		sprite = Sprite.health_particle_sprite;
		life = 40;
		dirX = 0;
		dirY = -0.14;
	}
	
	/**
	 * move to next position
	 */
	public void move(){
		yMove += dirY;
		if(yMove <= -1){
			y += -1;
			yMove += 1;
		}
	}
}
