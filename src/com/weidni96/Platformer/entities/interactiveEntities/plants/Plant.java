package com.weidni96.Platformer.entities.interactiveEntities.plants;


import com.weidni96.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;

public class Plant extends InteractiveEntity{
	
	protected AnimatedSprite[] as 		= {AnimatedSprite.plant11, 
											AnimatedSprite.plant12,
											AnimatedSprite.plant13, 
											AnimatedSprite.plant14};
	
	protected int growStates			= as.length;
	protected int growState				= 0;
	
	protected int timer 				= 0;
	protected final int RIPETIME;
	protected boolean ripe 					= false;
	protected boolean diesAfterHarvesting 	= false;
	
	/**
	 * init plant with first growstate
	 * @param x
	 * @param y
	 */
	public Plant(int x, int y, int RIPETIME){
		super(x, y);
		this.RIPETIME = RIPETIME;
		sprite = as[growState].getSprite();
	}
	
	/**
	 * automatically change grow state by using time and RIPETIME
	 */
	public void update(){
		if(!ripe){
			if(timer < RIPETIME) timer++;
			if(timer % (RIPETIME/(growStates-1)) == 0){
				growState++;
				if(growState == (growStates-1)){
					ripe = true;
				}
			}
		}
		sprite = as[growState].getSprite();
	}
	
	/**
	 * harvest plant, destroy if doesAfterHarvesting, else growState - 1
	 */
	public void harvest(){
		ripe = false;
		
		if(diesAfterHarvesting){
			remove();
		}else{
			growState--;
			timer -= RIPETIME/(growStates-1);
		}
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public AnimatedSprite getAs(){
		return as[growState];
	}
	public boolean isRipe(){
		return ripe;
	}
	public int getGrowState(){
		return growState;
	}
	public int getTimer(){
		return timer;
	}
}