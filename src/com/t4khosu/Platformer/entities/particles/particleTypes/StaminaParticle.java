package com.t4khosu.Platformer.entities.particles.particleTypes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Sprite;

public class StaminaParticle extends HealthParticle{

	public StaminaParticle(int x, int y, Level level) {
		super(x, y, level);
		sprite = Sprite.stamina_particle_sprite;
	}

}
