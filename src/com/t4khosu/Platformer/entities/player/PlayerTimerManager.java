/**
 * manage all timers that player needs (in addition to mob timers)
 */

package com.t4khosu.Platformer.entities.player;

import com.t4khosu.Platformer.entities.Timer;

public class PlayerTimerManager {
	
	//timers:
	//when created it must be initialized in constructor and function updateTimers
	private Timer damageTimer;
	private Timer getTimer; /* player received something */
	private Timer levelTimer;
	private Timer punshTimer;
	private Timer logTimer;
	private Timer potionTimer;
	
	/**
	 * constructor to initialize all timers
	 */
	public PlayerTimerManager(){
		this.getTimer 		= new Timer(5);
		this.damageTimer 	= new Timer(40);
		this.levelTimer 	= new Timer(100);
		this.punshTimer 	= new Timer(30);
		this.logTimer 		= new Timer(180);
		this.potionTimer 	= new Timer(60);
	}
	
	/**
	 * update all timers
	 */
	public void updateTimers(){
		getTimer.update();
		damageTimer.update();
		levelTimer.update();
		logTimer.update();
		potionTimer.update();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Timer getDamageTimer(){
		return damageTimer;
	}
	public Timer getGetTimer() {
		return getTimer;
	}
	public Timer getLevelTimer() {
		return levelTimer;
	}
	public Timer getPunshTimer() {
		return punshTimer;
	}
	public Timer getLogTimer() {
		return logTimer;
	}
	public Timer getPotionTimer() {
		return potionTimer;
	}
}
