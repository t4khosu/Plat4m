/**
 * Particles for rain, in different colors (a lighter and a darker one)
 */

package com.t4khosu.Platformer.entities.particles.particleTypes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class SnowParticle extends Particle{
	
	private double yMove = 0;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public SnowParticle(int x, int y, Level level) {
		super(x, y, level);
		
		vFall = 1;
		this.life = 1000;
		
		dirX = 0;
		dirY = random.nextDouble() + 0.2;
		
		if(dirY <= 0.6){
			sprite = Sprite.snow_particle1_sprite;
		}else{
			sprite = Sprite.snow_particle2_sprite;
		}
		
	}
	
	/**
	 * move to next position
	 */
	protected void move(){
		if(y > level.getHeight()) removed = true;
		
		yMove += dirY;
		if(yMove >= 1){
			y += 1;
			yMove -= 1;
		}
	}
}