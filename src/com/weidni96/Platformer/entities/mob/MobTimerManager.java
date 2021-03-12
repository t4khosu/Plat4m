/**
 * manage all timers that every mob needs
 */

package com.weidni96.Platformer.entities.mob;

import com.weidni96.Platformer.entities.Timer;

public class MobTimerManager {
	
	private Timer invincibleTimer;
	private Timer poisonedTimer;
	private Mob mob;
	
	/**
	 * constructor to initialize all timers
	 */
	public MobTimerManager(Mob mob){
		this.mob = mob;
		this.invincibleTimer = new Timer(60);
		this.poisonedTimer 	 = new Timer(60*4);
	}
	
	/**
	 * update all timers
	 */
	public void updateTimers(){
		if(mob.getMobTimer() >= 20000){
			mob.setMobTimer(0);
		}else{
			mob.setMobTimer(mob.getMobTimer()+1);
		}
		
		invincibleTimer.update();
		poisonedTimer.update();
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Timer getPoisonedTimer() {
		return poisonedTimer;
	}
	public Timer getInvincibleTimer(){
		return invincibleTimer;
	}
}
