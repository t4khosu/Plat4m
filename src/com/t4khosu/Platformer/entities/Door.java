/**
 * Door to move to another place 
 * (works as a teleporter)
 * So far there are only invisible doors that are put on another object to be seen
 */

package com.t4khosu.Platformer.entities;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

public class Door extends Entity{
	
	private Door destiny;
	private final int ID;
	
	/**
	 * constructor to test where door is (for invisible doors)
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param level
	 * @param destiny
	 * @param color
	 * @param ID
	 */
	public Door(int x, int y, int width, int height, Level level, Door destiny, int color, int ID){
		super(x, y, width, height);
		this.level = level;
		this.sprite = new Sprite(width, height, color);
		this.ID = ID;
	}
	
	/**
	 * constructor for invisible door
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param level
	 * @param destiny
	 * @param ID
	 */
	public Door(int x, int y, int width, int height, Level level, Door destiny, int ID){
		super(x, y, width, height);
		this.level = level;
		this.ID = ID;
	}
	
	/**
	 * once entered the door, change location
	 */
	public void use(){
		level.getArea().getWorld().moveTo(destiny);
	}
	
	/**
	 * connect with a door that already exists
	 * @param d2
	 */
	public void connectDoors(Door d2){
		this.initDestiny(d2);
		d2.initDestiny(this);
	}
	
	/**
	 * connect door by finding its partner
	 */
	public void connectDoors(){
		Door d2 = findPartner();
		if(d2 != null){
			this.initDestiny(d2);
			d2.initDestiny(this);
		}else{
			System.err.println("No matching door was found");
		}
	}
	
	/**
	 * find partner door
	 * @return partner door if found, else null
	 */
	private Door findPartner(){
		//return null if no matching door is found
		for(Area a : level.getArea().getWorld().getAreas()){
			if(a != null){
				for(Level l : a.getLevels()){
					if(l != null){
						for(Door d : l.getDoors()){
							if(d != null && d != this && d.getID() == this.getID()){
								return d;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		if(sprite != null){
			screen.renderSprite(x, y, sprite, true);
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  	/* Get and set methods */
	public void initDestiny(Door destiny){
		this.destiny = destiny;
	}
	
	public Door getDestiny(){
		return destiny;
	}
	public int getID(){
		return ID;
	}
}