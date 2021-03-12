/**
 * when entering a door, the background gets darker 
 * and movements stop. after some time player changes the rooms
 */

package com.weidni96.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.graphics.Screen;

public class ButtonPress_Cutscene extends Cutscene{
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
	public ButtonPress_Cutscene(World world, int removeText, int removeScreen) {
		super(world, removeText, removeScreen);
	}
	
	@Override
	public void update(){
		switch(action){
			case 0: timer++;
					if(timer >= 80){
						timer = 0;
						action++;
					}
					break;
					
			case 1: remove();
					break;
		}
	}
	
	@Override
	public void render(Screen screen){	
	}
	
	@Override
	public void render(Graphics g) {
	}
}