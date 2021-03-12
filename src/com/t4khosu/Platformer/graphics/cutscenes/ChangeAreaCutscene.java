/**
 * once the player changes the area, everything becomes black
 * until some time passes. then player is in new area.
 * So areas are better split to the player
 */

package com.t4khosu.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.World;

public class ChangeAreaCutscene extends Cutscene{
	
	private float factor = 1.0f;
	private int dirX;
	private int dirY;
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 * @param dirX
	 * @param dirY
	 */
	public ChangeAreaCutscene(World world, int dirX, int dirY) {
		super(world, 0, 2);
		this.dirX = dirX;
		this.dirY = dirY;
	}

	@Override
	public void update() {
		/*
    	 * 0. wait 10ms until area changes
    	 * 1. calculate actual factor how dark the screen has to be until factor = 0, render it
    	 * 2. Wait until timer = 40, render a black screen in this time
    	 * 3. remove cutscene and change area
    	 * 
    	 */
		
		switch(action){
			case 0: if(timer >= 10){
						timer = 0;
						action++;
						break;
					}
					timer++;
					break;
		
			case 1: factor = (100-timer) * 0.01f;
					timer += 3;
					if(timer >= 100){
						timer = 0;
						action++;
					}
					break;
					
			case 2: timer++;
					if(timer >= 40){
						timer = 0;
						action++;
					}
					break;
					
			case 3: world.areaChange(dirX, dirY);
					remove();
					break;
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void render(Screen screen) {
		switch(action){
		case 1: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
				break;
		case 2: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
				break;
		case 3: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
				break;
		}
	}
}