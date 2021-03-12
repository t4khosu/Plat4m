/**
 * Manage all stati of a mob, what it is actually doing right in this moment
 */

package com.weidni96.Platformer.entities.mob;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.Level.tile.TileGetterList;

public class MobStatusManager {
	protected boolean jumping		= false;
	protected boolean dead 			= false;
	protected boolean slowed		= false;
	protected boolean underWater 	= false;
	protected boolean canClimb 		= false;
	protected boolean blinkON		= false; /* got hit -> blinks certain time */
	
	protected boolean pushingBack	= false;
	protected boolean pushable		= false;
	protected boolean gotPushed 	= false;
	
	protected Mob mob;
	
	/**
	 * constructor
	 * @param mob
	 */
	public MobStatusManager(Mob mob){
		this.mob = mob;
	}
	
	/**
	 * test if mob is in liquid at position x/y
	 * @param x
	 * @param y
	 */
	public void underWaterAt(int x, int y){
		Tile t =  TileGetterList.getTile(x/8, y/8, mob.getLevel());
		
		if(t.isUnderWater()) underWater = true;
		else underWater = false;
	}
	
	/**
	 * test if mob is in slowed at position x/y
	 * @param x
	 * @param y
	 */
	public void isSlowedAt(int x, int y){
		Tile t = TileGetterList.getTile(x/8, y/8, mob.getLevel());
		
		if(t.slows()) slowed = true;
		else slowed = false;
	}
	
	/**
	 * test if mob can climb at position x/y
	 * @param x
	 * @param y
	 */
	public void canClimbAt(int x, int y){
		
		Tile t1 = TileGetterList.getTile((x-3)/8, y/8, mob.getLevel());
		Tile t2 = TileGetterList.getTile((x+3)/8, y/8, mob.getLevel());
		
		if(t1.isClimbable() || t2.isClimbable()) canClimb = true;
		else canClimb = false;
	}
	
	/**
	 * blink when mob gets hit
	 */
	public void blink(){
		if(Game.timer%14 <= 7){
			blinkON = true;
		}else{
			blinkON = false;
		}
	}
	
	/**
	 * stop blinking
	 */
	public void stopBlinking(){
		blinkON = false;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setJumping(boolean jumping){
		this.jumping = jumping;
	}
	public void setGotPushed(boolean gotPushed){
		this.gotPushed = gotPushed;
	}
	public void setDead(boolean dead){
		this.dead = dead;
	}
	public void setPushable(boolean pushable){
		this.pushable = pushable;
	}

	public boolean isJumping(){
		return jumping;
	}
	public boolean isUnderWater(){
		return underWater;
	}
	public boolean isSlowed(){
		return slowed;
	}
	public boolean isDead(){
		return dead;
	}
	public boolean isPushable(){
		return pushable;
	}
	public boolean getCanClimb(){
		return canClimb;
	}
	public boolean getBlinkON(){
		return blinkON;
	}
	public boolean getGotPushed(){
		return gotPushed;
	}
}