package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.saveGame.SaveManager;

public class SavePoint extends InteractiveEntity{
	
	private boolean active;
	private SaveManager saveManager;
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public SavePoint(int x, int y, Level level){
		super(x, y);
		initLevel(level);
	}
	
	public SavePoint(int x, int y, Level level, boolean active){
		super(x, y);
		initLevel(level);
		this.active = active;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void activate(){
		for(SavePoint sp : SavePointManager.savePoints){
			if(sp == this){
				sp.active = true;
			}else{
				sp.active = false;
			}
		}
	}
	public void deactivate(){
		active = false;
	}
	
	public void initLevel(Level level){
		this.level = level;
	}
	
	public void render(Screen screen){
		if(active){
			screen.renderSprite(x, y, Sprite.save_on_sprite, true);
		}else{
			screen.renderSprite(x, y, Sprite.save_off_sprite, true);
		}
		
	}
	
	public SavePoint initLevelAndReturn(Level level){
		initLevel(level);
		this.saveManager = level.getArea().getWorld().getSaveManager();
		return this;
	}
	
	
	public SaveManager getSaveManager(){
		return saveManager;
	}
}
