package com.t4khosu.Platformer.Level.areas;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.graphics.Background;
import com.t4khosu.Platformer.graphics.Sprite;

/**
 * A big town in the east. Here can be found many characters and quests
 * but also some easter eggs
 * @author Christian
 *
 */
public class Cimbria extends Area {

	/**
	 * Constructor
	 * @param player
	 * @param world
	 */
	public Cimbria(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.width 		= 4;
		this.height 	= 3;
		this.name 		= "Cimbria";
		this.canRain 	= true;
		
		this.background = Background.background_03;
		this.areaSprite = Sprite.areaSign_neuleben;
		
		this.levels = new Level[width * height];
		initLevels();
	}
	
	@Override
	protected  void individualUpdate(){
	}
	
	@Override
	public void initLevels(){
		/*	
		 *  0 1 2
		 *  3 4 5
		 *  6 7 8
		 */ 
	}
}