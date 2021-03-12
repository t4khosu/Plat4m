/**
 * a timer keep track of stuff, like time, you know?
 */

package com.weidni96.Platformer.entities;

public class Timer extends Entity{
	
	private int timer;
	private int max_timer;
	private boolean active;
	
	/**
	 * constructor
	 * @param timer
	 */
	public Timer(int timer){
		this.max_timer 	= this.timer = timer;
		this.active 	= false;
	}
	
	/**
	 * update timer
	 */
	public void update(){
		if(timer < max_timer){
			timer++;
		}else{
			active = false;
		}
	}
	
	/**
	 * start timer
	 */
	public void start(){
		timer 	= 0;
		active 	= true;
	}
	
	/**
	 * stop timer and reset it
	 */
	public void stop(){
		timer 	= max_timer;
		active 	= false;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  	/* Get and set methods */
	public void setMaxTime(int time){
		max_timer = time;
	}
	
	public int getMaxTime(){
		return max_timer;
	}
	public int getTime(){
		return timer;
	}
	public boolean isActive(){
		return active;
	}
}
