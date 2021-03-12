package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.graphics.Sprite;

public class InteractiveEntity extends Entity{
	
	/**
	 * constructor only with position
	 * @param x
	 * @param y
	 */
	public InteractiveEntity(int x, int y){
		super(x, y);
	}
	
	/**
	 * constructor also with a sprite
	 * @param x
	 * @param y
	 * @param sprite
	 */
	public InteractiveEntity(int x, int y, Sprite sprite){
		super(x, y, sprite);
	}
	
	/**
	 * constructor without sprite but sive (invisible)
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public InteractiveEntity(int x, int y, int width, int height){
		super(x, y, width, height);
	}
}