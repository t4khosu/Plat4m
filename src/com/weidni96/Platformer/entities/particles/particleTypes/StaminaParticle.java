package com.weidni96.Platformer.entities.particles.particleTypes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Sprite;

public class StaminaParticle extends HealthParticle{

	public StaminaParticle(int x, int y, Level level) {
		super(x, y, level);
		sprite = Sprite.stamina_particle_sprite;
	}

}
