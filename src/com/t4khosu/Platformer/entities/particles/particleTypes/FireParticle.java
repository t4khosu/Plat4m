/**
 * Particle for fire, a bunch of red/orange particles
 */

package com.t4khosu.Platformer.entities.particles.particleTypes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class FireParticle extends Particle{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public FireParticle(int x, int y, Level level) {
		super(x, y, level);
		
		vFall = 0.5;
		this.life = 30 + random.nextInt(5);
		
		switch(random.nextInt(4)){ /* choose random color for fire, yellow - red */
			case 0:
				sprite = Sprite.fire_particle_sprite_0;
				break;
			case 1:
				sprite = Sprite.fire_particle_sprite_1;
				break;
			case 2:
				sprite = Sprite.fire_particle_sprite_2;
				break;
			default:
				sprite = Sprite.fire_particle_sprite_0;
		}
	}
}