/**
 * Rain as weather. if wanted with thunder
 */

package com.weidni96.Platformer.entities.weather;

import java.util.ArrayList;
import java.util.List;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.particles.particleTypes.Particle;
import com.weidni96.Platformer.entities.particles.particleTypes.RainParticle;
import com.weidni96.Platformer.graphics.Background;
import com.weidni96.Platformer.graphics.Screen;

public class Rain extends Weather{

	protected boolean lightning;
	protected Timer lightningTimer;
	
	protected final float LOWEST_LIGHT_LEVEL = 0.25f;
	protected final float HIGHEST_SATURATION_LEVEL = 0.50f;
	
	protected List<Particle> particles = new ArrayList<Particle>();
	
	/**
	 * constructor
	 * @param time
	 * @param level
	 * @param lightning
	 */
	public Rain(int time, Level level, boolean lightning){
		super(time, level);
		this.lightning = lightning;
	}
	
	public void render(Screen screen){
		for(Particle  p: particles) p.render(screen);
	}
	
	/**
	 * Split weather into BEGINNING, MIDDLE and END.
	 * Only update actual phase
	 */
	public void update(){
		updateParticleList(particles);
		
		switch(phase){
			case 0: begin();
					break;
			case 1: updateMiddle();
					break;
			case 2: end();
					break;
			default: break;
		}
	}
	
	/**
	 * create a new weather particle at a random position
	 */
	public void createParticle(){
		int x0 = random.nextInt(level.getWidth());
		particles.add(new RainParticle(x0, -2, level));
	}
	
	/**
	 * check time on timer in percent
	 * @param percent
	 * @return true, if reached percentage already
	 */
	public boolean timerCompletion(double percent){
		double d = timer.getTime() / (double)timer.getMaxTime();
		if(d >= percent) return true;
		else return false;
	}
	
	
	/**
	 * render introduction for upcoming weather
	 */
	protected void begin(){
		if(phase != 0) return; // make sure only update when in correct phase
		if(lightLevel > LOWEST_LIGHT_LEVEL){
			lightLevel -= 0.001;
			Background b = null;
			if((b = world.getActualArea().getBackground()) != null){
				b.darker(lightLevel, saturationLevel);
			}
			
			return;
		}
		
		//start when lightlevel is 0.25
		timer.start();
		phase++;
	}
	
	/**
	 * render second part of wheather.
	 * here is the real action
	 */
	private void updateMiddle(){
		if(phase != 1) return; // make sure only update when in correct phase
		
		if(timer.isActive()){
			timer.update();
			
			if(lightning){
				if(lightningTimer == null || !lightningTimer.isActive()){
					lightningTimer = new Timer(random.nextInt(800)+300);
					lightningTimer.start();
				}
				lightningTimer.update();
				
				if(!lightningTimer.isActive()){
					lightLevel 		= 1.0f;
					saturationLevel = 0.0f;
					world.getActualArea().getBackground().darker(lightLevel, saturationLevel);
				}
				
				if(lightLevel > LOWEST_LIGHT_LEVEL){
					lightLevel -= 0.012;
					
					if(lightLevel < LOWEST_LIGHT_LEVEL) lightLevel = LOWEST_LIGHT_LEVEL;
				}
				if(saturationLevel < HIGHEST_SATURATION_LEVEL){
					saturationLevel += 0.012f;
					if(saturationLevel > HIGHEST_SATURATION_LEVEL) saturationLevel = HIGHEST_SATURATION_LEVEL;
				}
				
				if(lightLevel > LOWEST_LIGHT_LEVEL || saturationLevel < HIGHEST_SATURATION_LEVEL){
					world.getActualArea().getBackground().darker(lightLevel, saturationLevel);
				}
			}
			
			switch(action){
				//to 10%
				case 0: for(int i = 0; i < 1; i++) createParticle();
						if(timerCompletion(0.1)) action++;
						break;
				//to 20%
				case 1: for(int i = 0; i < 2; i++) createParticle();
						if(timerCompletion(0.2)) action++;
						break;
				//to 40%
				case 2: for(int i = 0; i < 5; i++) createParticle();
						if(timerCompletion(0.4)) action++;
						break;
				//to 80%
				case 3: for(int i = 0; i < 10; i++) createParticle();
						if(timerCompletion(0.8)) action++;
						break;
				//to 90%
				case 4: for(int i = 0; i < 3; i++) createParticle();
						if(timerCompletion(0.9)) action++;
						break;
				case 5: for(int i = 0; i < 1; i++) createParticle();
						break;
			}
		}else{
			phase++;
		}
	}
	
	/**
	 * end of weather, slowly fading away
	 */
	protected void end(){
		if(phase != 2) return;
		
		//set light back to 1
		if(lightLevel < 1.0){
			lightLevel += 0.001;
			Background b = null;
			if((b = world.getActualArea().getBackground()) != null){
				b.darker(lightLevel, saturationLevel);
			}
			return;
		}
		
		phase++; //make sure nothing else happens until deletion
		remove();
	}
}
