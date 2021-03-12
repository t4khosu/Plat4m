package com.t4khosu.Platformer.entities;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class PoisonMachineBoss extends Entity{
	
	private AnimatedSprite machine = new AnimatedSprite(64, SpriteSheet.poisonMachine1_sheet, 6, 10, false);
	private boolean on = true;
	
	
	public PoisonMachineBoss(int x, int y, Level level){
		super(x, y);
		initLevel(level);
		this.sprite = machine.getSprite();
	}
	
	public void update(){
		if(on){
			this.sprite = machine.getSprite();
			machine.update();
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}
	
	public void setOff(){
		this.on = false;
		this.sprite = Sprite.poisonMachineOff;
		
	}
}
