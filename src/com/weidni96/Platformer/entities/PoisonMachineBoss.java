package com.weidni96.Platformer.entities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

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
