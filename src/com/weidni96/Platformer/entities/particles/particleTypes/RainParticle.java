/**
 * Particles for rain, in different colors (a lighter and a darker one)
 */

package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class RainParticle extends GravityParticle{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public RainParticle(int x, int y, Level level) {
		super(x, y, level);
		
		vFall = 1;
		this.life = 1000;
		
		switch(random.nextInt(2)){ /* decide randomly which sprite will be used */
		case 0: sprite = Sprite.rain_particle1_sprite; break;
		case 1: sprite = Sprite.rain_particle2_sprite; break; 
		}
	}
}