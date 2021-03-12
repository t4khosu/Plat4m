/**
 * standard things like images. They only contain a position and maybe a sprite.
 * so they can do absolutely nothing but look good.
 */

package com.weidni96.Platformer.entities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Entity {
	
	protected Sprite sprite;
	protected AnimatedSprite aSprite;
	protected int x, y;
	protected int width, height;
	
	protected boolean playerInteraction = false;
	protected String name = "";
	protected String description = "";
	
	protected boolean removed = false;
	public Level level;
	
	/**
	 * empty constructor, every attributed will be defined later on
	 */
	public Entity(){
	}
	
	/**
	 * construcor with position
	 * @param x
	 * @param y
	 */
	public Entity(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * constructor with position and size
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Entity(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * constructor with position and sprite, i.e. image entities are used by this constructor
	 * @param x
	 * @param y
	 * @param sprite
	 */
	public Entity(int x, int y, Sprite sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	/**
	 * constructor with position and animated sprite, i.e. image entities are used by this constructor
	 * @param x
	 * @param y
	 * @param sprite
	 */
	public Entity(int x, int y, AnimatedSprite aSprite){
		this.x = x;
		this.y = y;
		
		this.aSprite = aSprite;
		this.sprite = aSprite.getSprite();
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	

	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}
	
	/**
	 * update entity
	 */
	public void update(){
		if(aSprite != null){
			aSprite.update();
			sprite = aSprite.getSprite();
		}
	}
	
	/**
	 * initialize a level the entity is connected to
	 * @param level
	 */
	public void initLevel(Level level){
		this.level = level;
	}
	
	/**
	 * remove this entity. So it won't be updated and rendered any longer
	 */
	public void remove(){
		removed = true;
	}
	
	/**
	 * Check if a point is hovering this Entity
	 * @param xx
	 * @param yy
	 * @return
	 */
	public boolean inRange(int xx, int yy){
		if(xx >= x && xx < x + width){
			if(yy >= y && yy < y + height){
				return true;
			}
		}
		return false;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean isRemoved(){
		return removed;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public Sprite getSprite(){
		return sprite;
	}
	public int getHeight(){
		return height;
	}
	public Level getLevel(){
		return level;
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}