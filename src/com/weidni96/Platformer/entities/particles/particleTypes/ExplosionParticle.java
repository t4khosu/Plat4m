/**
 * glowing particles, created randomly when explosions occur
 */

package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class ExplosionParticle extends Particle{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public ExplosionParticle(int x, int y, Level level) {
		super(x, y, level);
		
		damage = 5;
		vFall = (random.nextDouble()+0.5)*(-2.0);
		this.life = 150;
		
		switch(random.nextInt(4)){ /* choose random sprite for particle */
		case 0:
			sprite = Sprite.explosion_particle_sprite_0;
			break;
		case 1:
			sprite = Sprite.explosion_particle_sprite_1;
			break;
		case 2:
			sprite = Sprite.explosion_particle_sprite_2;
			break;
		default:
			sprite = Sprite.explosion_particle_sprite_0;
		}
	}	
}