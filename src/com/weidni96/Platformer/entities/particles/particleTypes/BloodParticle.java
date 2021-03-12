/**
 * red particle (from fire) created when a mob gets hit
 */

package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class BloodParticle extends Particle{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public BloodParticle(int x, int y, Level level) {
		super(x, y, level);
		
		vFall 		= 0.3;
		this.life 	= 30 + random.nextInt(5);
		sprite 		= Sprite.fire_particle_sprite_0;
	}
}