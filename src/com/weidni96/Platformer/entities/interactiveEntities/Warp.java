package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class Warp extends InteractiveEntity{
	
	private AnimatedSprite a_warp  = new AnimatedSprite(8, SpriteSheet.warp_sheet, 3, 10, true);
	private Level destination;
	private int posX;
	private int posY;
	
	public Warp(int x, int y, Level destination, int posX, int posY) {
		super(x, y);
		
		this.sprite = a_warp.getSprite();
		this.posX = posX;
		this.posY = posY;
		this.destination = destination;
	}
	
	@Override
	public void update(){
		a_warp.update();
		this.sprite = a_warp.getSprite();
	}
	
	public void warp(){
		destination.getArea().getWorld().levelChange(destination, posX, posY);
	}
	
	public Level getDestination(){
		return destination;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){ 
		return posY;
	}
}
