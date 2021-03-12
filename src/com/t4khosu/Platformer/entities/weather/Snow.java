/**
 * Kind of rain with slower, lighter particles
 */

package com.t4khosu.Platformer.entities.weather;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.particles.particleTypes.SnowParticle;

public class Snow extends Rain{

	/**
	 * constructor
	 * @param time
	 * @param level
	 */
	public Snow(int time, Level level) {
		super(time, level, false);
	}
	
	/**
	 * create snow particle
	 */
	public void createParticle(){
		int x0 = random.nextInt(level.getWidth());
		particles.add(new SnowParticle(x0, -2, level));
	}

	/**
	 * render introduction for upcoming weather
	 */
	protected void begin(){
		if(phase != 0) return; // make sure only update when in correct phase
		
		timer.start();
		phase++;
	}
	
	/**
	 * things done when timer stops, like cleaning, resetting level/area
	 */
	protected void end(){
		if(phase != 2) return;
		
		if(particles.size() == 0){
			phase++; //make sure nothing else happens until deletion
			remove();
		}
		
	}
}