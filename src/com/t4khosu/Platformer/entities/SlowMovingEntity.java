/**
 * entities that are slower than 1 pixel/update 
 */

package com.t4khosu.Platformer.entities;

import com.t4khosu.Platformer.graphics.Sprite;

public class SlowMovingEntity extends Entity{
	
	private int dirX;
	private int dirY;
	private int speed; /* the higher, the slower entity moves */
	private Timer existence;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param dirX
	 * @param dirY
	 * @param speed
	 * @param life
	 */
	public SlowMovingEntity(int x, int y, Sprite sprite, int dirX, int dirY, int speed, int life){
		super(x, y, sprite);
		
		this.dirX = dirX;
		this.dirY = dirY;
		this.speed = speed;
		
		this.existence = new Timer(life);
		this.existence.start();
	}
	
	/**
	 * move in direction 
	 */
	private void move(){
		if(existence.getTime() % speed == 0){
			x += dirX;
			y += dirY;
		}
	}
	
	/**
	 * if alive, move, else remove itself
	 */
	public void update(){
		existence.update();
		if(existence.isActive()){
			move();
		}else{
			remove();
		}
	}
}