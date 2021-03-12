/**
 * a bar to represent values like life
 */

package com.weidni96.Platformer.entities;

import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.graphics.Screen;

public class Bar extends Entity{
	
	private int maxValue;
	private int value;
	private int size;
	private boolean offSet;
	private BarType type;
	private Mob mob;
	
	public enum BarType{
		HEALTH, NORMAL;
	}
	
	/**
	 * constructor
	 * @param size
	 * @param maxValue
	 * @param type
	 * @param offSet
	 * @param mob
	 */
	public Bar(int size, int maxValue, BarType type, boolean offSet, Mob mob){
		this.maxValue = maxValue;
		this.value = maxValue;
		this.size = size;
		this.offSet = offSet;
		
		this.mob = mob;
		this.type = type;
	}
	
	/**
	 * draw bar
	 * @param screen 
	 */
	public void render(Screen screen){
		switch(type){
			case HEALTH: 	screen.renderLifeBar(mob.getX(), mob.getY()-2, value, maxValue, size, 1, offSet);
							break;
			case NORMAL:	screen.renderBar(mob.getX(), mob.getY()-3, value, maxValue, size, 0xffaaaaff, offSet);
							break;
			default:		return;
		}
	}
	
	/**
	 * check if bar's value is max
	 * @return
	 */
	public boolean notFull(){
		return value < maxValue;
	}
	
	/**
	 * subtract a value from the bar value. Not the max value!
	 * @param val
	 */
	public void sub(int val){
		if(this.value - val < 0){
			this.value = 0;
		}else{
			this.value -= val;
		}
	}
	
	/**
	 * fill bar with max value
	 */
	public void reset(){
		value = maxValue;
	}
	
	public int getValue(){
		return value;
	}
}
