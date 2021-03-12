/**
 * Manage all stati of a player
 */

package com.t4khosu.Platformer.entities.player.activities;

import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.Screen;


public class PlayerStatusManager{
	
	private Player player;
	
	public Fishing 		fishing;
	public Planting 	planting;
	public Plowing		plowing;
	public Harvesting 	harvesting;
	public SwingSword 	swingSword;
	public BreakStone 	breakStone;
	public Mine			mine;
	
	private boolean walking = false;
	private boolean climbing = false;
	private boolean crawling = false;
	private boolean punshing = false;
	private boolean gotItem	= false;
	private boolean onSpikes = false;
	private boolean enteringDoor = false;
	
	private boolean standing = false;
	private boolean trading  = false;
	private boolean melting = false;
	
	/**
	 * constructor
	 * @param player
	 */
	public PlayerStatusManager(Player player){	
		fishing 	= new Fishing(player);
		planting 	= new Planting(player);
		plowing 	= new Plowing(player);
		harvesting 	= new Harvesting(player);
		swingSword  = new SwingSword(player);
		breakStone  = new BreakStone(player);
		mine		= new Mine(player);
		
		this.player = player;
	}
	
	/**
	 * render things in addition, like "fishing pole" or "sword"
	 * @param screen
	 */
	public void render(Screen screen){
		swingSword.render(screen);
		fishing.render(screen);
		mine.render(screen);
	}
	
	/**
	 * reset every activity
	 */
	public void reset(){
		fishing.reset();
		planting.reset();
		plowing.reset();
		breakStone.reset();
		mine.reset();
	}
	
	/**
	 * check if there is an actual animation for player
	 * @return
	 */
	public boolean isAnimated(){
		return  walking || 
				climbing || 
				plowing.getPlowing() || 
				fishing.isCatching() || 
				breakStone.hasStarted() || 
				mine.getTimer().isActive();
	}
	
	/**
	 * working -> stamina doesn't regenerate
	 * @return
	 */
	public boolean isWorking(){
		return mine.getTimer().isActive();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setWalking(boolean walking){
		this.walking = walking;
	}
	public void setOnSpikes(boolean onSpikes){
		this.onSpikes = onSpikes;
	}
	public void setClimbing(boolean climbing){
		this.climbing = climbing;
	}
	public void setCrawling(boolean crawling){
		this.crawling = crawling;
	}
	public void setTrading(boolean trading){
		this.trading = trading;
	}
	public void setEnteringDoor(boolean enteringDoor){
		this.enteringDoor = enteringDoor;
	}
	public void setMelting(boolean melting){
		this.melting = melting;
	}
	
	public boolean isClimbing(){
		return climbing;
	}
	public boolean isWalking(){
		return walking;
	}
	public boolean isOnSpikes(){
		return onSpikes;
	}
	public boolean isCrawling(){
		return crawling;
	}
	public boolean isPunshing(){
		return punshing;
	}
	public boolean isStanding(){
		return standing;
	}
	public boolean isTrading(){
		return trading;
	}
	public boolean isMelting(){
		return melting;
	}
	public boolean gotItem(){
		return gotItem;
	}
	public boolean isMoving(){
		return walking || crawling || !player.bottomCollision();
	}
	public boolean isEnteringDoor(){
		return enteringDoor;
	}
}
