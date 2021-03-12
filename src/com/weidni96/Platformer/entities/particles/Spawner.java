/**
 * A Spawner to create every kind of particle and a certain 
 * amount at a specific position inside a level
 */

package com.weidni96.Platformer.entities.particles;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.particles.particleTypes.AirParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.BloodParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.ExplosionParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.FireParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.HealthParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.Particle;
import com.weidni96.Platformer.entities.particles.particleTypes.StaminaParticle;

public class Spawner extends Entity{
	
	int amount;
	ParticleType type = ParticleType.FIRE;
	
	/**
	 * all kinds of particles
	 * @author Christian
	 *
	 */
	public enum ParticleType{
		FIRE, EXPLOSION, AIR, BLOOD, RAIN, HEALTH, STAMINA;
	}
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param amount
	 * @param level
	 * @param type
	 */
	public Spawner(int x, int y, int amount, Level level, ParticleType type) {
		super(x, y);
		this.amount = amount;
		this.level = level;
		this.type = type;
		
		generate();
	}
	
	/**
	 * create specific particle+amount
	 */
	public void generate(){
		switch(type){
			case FIRE: 
				for(int i = 0; i < amount; i++){
					Particle.particles.add(new FireParticle(x, y, level));
				}
				break;
			case EXPLOSION:
				for(int i = 0; i < amount; i++){
					Particle.particles.add(new ExplosionParticle(x, y-2, level));
				}
				break;
			case AIR:
				for(int i = 0; i < amount; i++){
					Particle.particles.add(new AirParticle(x, y, level));
				}
				break;
			case BLOOD:
				for(int i = 0; i < amount; i++){
					Particle.particles.add(new BloodParticle(x, y, level));
				}
				break;
			case HEALTH:
				for(int i = 0; i < 3; i++){
					Particle.particles.add(new HealthParticle(x, y, level));
					Particle.particles.add(new HealthParticle(x+4, y-3, level));
					Particle.particles.add(new HealthParticle(x-3, y-7, level));
				}
				break;
			case STAMINA:
				for(int i = 0; i < 3; i++){
					Particle.particles.add(new StaminaParticle(x, y, level));
					Particle.particles.add(new StaminaParticle(x+4, y-3, level));
					Particle.particles.add(new StaminaParticle(x-3, y-7, level));
				}
				break;
			default:
				break;		
		}
	}
}
