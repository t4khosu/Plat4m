package com.weidni96.Platformer.entities.particles;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.particles.particleTypes.DripParticle;
import com.weidni96.Platformer.entities.particles.particleTypes.Particle;

public class Dripper extends Entity{
	
	private Timer timer;
	private int color;
	
	private int rand;
	private boolean start = false;
	
	public Dripper(int time, int color, int x, int y, Level level){
		super(x+4, y+8);
		initLevel(level);
		this.timer = new Timer(time + (int)(Math.random()*time / 10));
		this.color = color;
		this.rand = (int)(Math.random()*400);
	}
	
	public void update(){
		if(!start){
			rand--;
			if(rand <= 0) start = true;
			return;
		}
		
		if(!timer.isActive()){
			Particle.particles.add(new DripParticle(color, 0.5, x, y, level));
			timer.start();
		}
		timer.update();
	}
}