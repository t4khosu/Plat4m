/**
 * when entering a door, the background gets darker 
 * and movements stop. after some time player changes the rooms
 */

package com.weidni96.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.Door;
import com.weidni96.Platformer.graphics.Screen;

public class Enter_Door_Cutscene extends Cutscene{
	
	private float factor = 1.0f;
	private Door door;
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 * @param door
	 */
	public Enter_Door_Cutscene(World world, Door door) {
		super(world, 0, 2);
		this.door = door;
	}
	
	@Override
	public void update(){
		
		/*
    	 * 0. Wait until timer = 20, then start doing stuff
    	 * 1. calculate actual factor how dark the screen has to be until factor = 0, render it
    	 * 2. Wait until timer = 40, render a black screen in this time
    	 * 3. remove cutscene
    	 * 
    	 */
		
		switch(action){
			case 0: timer++;
					if(timer >= 20){
						timer = 0;
						action++;
					}
					break;
					
			case 1: factor = (100-timer) * 0.01f;
					if(timer >= 100){
						timer = 0;
						action++;
					}
					timer++;
					break;
					
			case 2: timer++;
					if(timer >= 40){
						timer = 0;
						action++;
					}
					break;
					
			case 3: world.moveTo(door);
					world.getPlayer().getPSM().setEnteringDoor(false);
					remove();
					break;
		}
	}
	
	@Override
	public void render(Screen screen){
		switch(action){
			case 1: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
					break;
			case 2: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
			case 3: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
	}
}