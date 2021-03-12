package com.t4khosu.Platformer.entities.enemies.slimes;

import java.util.Random;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.mob.Mob;
import com.t4khosu.Platformer.graphics.Sprite;

public abstract class Slime extends Mob {
	protected int actTime 	= 150;
	protected int nextActionTime = 0;
	
	protected boolean sliding = false;
	protected double slideForce = -3.3;
	protected double vSlide		= 0;
	
	protected int full_dead_time = 150;
	protected int dead_time	= full_dead_time;
	
	protected int nx = 0;
	protected Random random;
	
	protected Sprite[] sprites = new Sprite[3];
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 */
	public Slime(int x, int y, Sprite s, Level level) {
		super(x, y, s, level);
		random 			= new Random();
		nextActionTime	= nextActionTime();
		
		this.lootID = Item.slimeBall_ID;
		
		sprites[0] = Sprite.slime0_0;
		sprites[1] = Sprite.slime0_1;
		sprites[2] = Sprite.slime0_2;
		
		this.sprite = sprites[0];
		this.name 		= "Blauer Schleim";
		collisionDamage = 3;
		experience 		= 200;
		money 			= 2;
		shield 			= 0;
	}
	
	/**
	 * calculate time for next action
	 * @return result time
	 */
	public int nextActionTime(){
		return random.nextInt(actTime) + actTime/2;
	}
	
	
	/**
	 * do stuff while alive
	 */
	public void aliveUpdate(){
		jump();

		if(!bottomCollision()){
			sprite = sprites[2];
			falling();
			msm.setJumping(false);
			
		}else{
			sprite = sprites[1];
			nx = 0;
			jumpCount = 0;
		}
		
		if(nx != 0) move(nx);
		slide();
		
		if(msm.getGotPushed()){ //hit by player
			moveAlgorithm();
			timer = 0;
		}
		
		if(timer >= nextActionTime){
			timer = 0;
			nextActionTime = nextActionTime();
			moveAlgorithm(); /* do one specific thing */
		}
	}
	
	/**
	 * do stuff when dead
	 */
	public void deadUpdate(){
		if(dead_time == 0){
			remove();
		}else{
			falling();
			dead_time--;
			sprite = sprites[0];
		}
	}
	
	/**
	 * always do after action timer
	 */
	protected void moveAlgorithm() {
		if(blocked()){
			sliding = true;
			dirX = random.nextInt(2) * 2 - 1; /* -1 or 1 */
		}else if(bottomCollision()){
			
			msm.setJumping(true);
			if(msm.getGotPushed()){
				msm.setGotPushed(false);
				nx = level.getPlayer().getDirX();
			}else{
				nx = random.nextInt(2) * 2 - 1;
			}
		}	
	}
	
	
	
	/**
	 * move certain amount of steps, look for collision
	 * @param steps
	 */
	protected void move(int steps){ //nx steps
		if(steps < 0) dirX = -1;
		else dirX = 1;
		
		for(int i = 0; i < Math.abs(steps); i++){
			if(!sideCollision(dirX) && x + dirX >= 0 && x + width + dirX < level.getWidth()){
				x += dirX;
			}
		}
	}
	
	/**
	 * can't jump -> slide around
	 */
	protected void slide(){
		if(sliding){
			sliding = false;
			vSlide = slideForce;
		}
		if(Math.abs(vSlide) >= level.fraction){
			move(dirX * Math.abs((int)vSlide));
			vSlide += level.fraction;
		}else{
			vSlide = 0;
		}
	}
	
	/**
	 * check if there is no space to jump, if true -> slime is blocked
	 * @return result
	 */
	protected boolean blocked(){
		return TileGetterList.getTile(x/8, (y-1)/8, level).isSolid() && TileGetterList.getTile(x/8, (y+8)/8, level).isSolid() ||
				TileGetterList.getTile((x+width-1)/8, (y-1)/8, level).isSolid() && TileGetterList.getTile((x+width-1)/8, (y+8)/8, level).isSolid();
	}
}
