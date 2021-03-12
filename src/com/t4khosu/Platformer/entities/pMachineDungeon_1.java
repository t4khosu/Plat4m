package com.t4khosu.Platformer.entities;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class pMachineDungeon_1 extends Entity{
	
	private boolean red = false;
	private boolean blue = false;
	private boolean green = false;
	private boolean yellow = false;
	
	private boolean active = false;
	
	
	private AnimatedSprite machine 		= new AnimatedSprite(48*3, SpriteSheet.pMachine1_sheet, 6, 11, false);
	private AnimatedSprite blue_A 		= new AnimatedSprite(10*3, SpriteSheet.pMachineBlue_sheet, 6, 11, false);
	private AnimatedSprite red_A 		= new AnimatedSprite(10*3, SpriteSheet.pMachineRed_sheet, 6, 11, false);
	private AnimatedSprite yellow_A 	= new AnimatedSprite(10*3, SpriteSheet.pMachineYellow_sheet, 6, 11, false);
	private AnimatedSprite green_A 		= new AnimatedSprite(10*3, SpriteSheet.pMachineGreen_sheet, 6, 11, false);
	
	public pMachineDungeon_1(int x, int y, Level level){
		super(x, y);
		initLevel(level);
		this.sprite = machine.getSprite();
	}
	
	public void update(){
		this.sprite = machine.getSprite();
		machine.update();
		
		blue_A.update();
		red_A.update();
		yellow_A.update();
		green_A.update();
		
		if(red && blue && yellow && green &&
				!active){
			active = true;
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
		
		if(red){
			screen.renderSprite(x + 3 * 13, y + 3 * 14, red_A.getSprite(), true);
		}
		if(blue){
			screen.renderSprite(x + 3 * 14, y + 3 * 3, blue_A.getSprite(), true);	
		}
		if(green){
			screen.renderSprite(x + 3 * 24, y + 3 * 14, green_A.getSprite(), true);
		}
		if(yellow){
			screen.renderSprite(x + 3 * 25, y + 3 * 3, yellow_A.getSprite(), true);
		}
	}
	
	public void activateRed(){
		red = true;
	}
	public void activateBlue(){
		blue = true;
	}
	public void activateYellow(){
		yellow = true;
	}
	public void activateGreen(){
		green = true;
	}
}