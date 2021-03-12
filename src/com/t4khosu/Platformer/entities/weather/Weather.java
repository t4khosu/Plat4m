/**
 * Weather class,
 * to crate weather like snow, rain, thunderstorm etc.
 */

package com.t4khosu.Platformer.entities.weather;

import java.util.List;
import java.util.Random;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.particles.particleTypes.Particle;

public abstract class Weather extends Entity {
	protected Level level;
	protected World world;
	
	protected Timer timer;
	protected Random 	random;
	protected int 		action = 0;
	protected int 		phase = 0;
	
	protected float 	lightLevel = 1.0f; /* 0.0 - 1.0 */
	protected float 	saturationLevel = 0.5f;
	protected boolean 	light = false;
	
	/**
	 * constructor
	 * @param time
	 */
	public Weather(int time, Level level){
		this.timer = new Timer(time);
		this.random = new Random();
		this.level = level;
		this.world = level.getArea().getWorld();
	}
	
	/**
	 * update all particles in list, so they can move (if intended)
	 * @param particles
	 */
	protected void updateParticleList(List<Particle> particles){
		for(int i = 0; i < particles.size(); i++){
			Particle p = particles.get(i);
			p.update();
			if(p.isRemoved()){
				particles.remove(p);
			}
		}
	}
	
	/**
	 * update weather
	 */
	public void update(){
		
	}
	
	/**
	 * thingsdone before timer starts
	 */
	protected abstract void begin();
	
	/**
	 * things done when timer stops/is finished
	 */
	protected abstract void end();
}