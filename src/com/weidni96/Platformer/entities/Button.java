package com.weidni96.Platformer.entities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Button extends Entity{
	
	private Sprite pressedSprite;
	private Sprite notPressedSprite;
	private Dir dir;
	private float color;
	private boolean pressed = false;
	
	
	public enum Dir{
		TOP, RIGHT, LEFT, BOTTOM;
	}
	
	public Button(int x, int y, Level level, Dir dir, float color, int ID){
		super(x,y, Sprite.button_OFF_sprite);
		initLevel(level);
		
		this.pressedSprite = Sprite.button_ON_sprite;
		this.notPressedSprite = Sprite.button_OFF_sprite;
		this.sprite = notPressedSprite;
		
		this.dir = dir;
		this.color = color;
	}
	
	public Dir getDir(){
		return dir;
	}
	
	public void press(){
		pressed = true;
		this.sprite = pressedSprite;
	}
	
	public void reset(){
		pressed = false;
		this.sprite = notPressedSprite;
	}
	
	public void render(Screen screen){
		screen.renderNewHSB(x, y, sprite, true, color, 1.0f);
	}
	
	public boolean isPressed(){
		return pressed;
	}
}
