package com.weidni96.Platformer.Level.areas;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.Level.areas.singleLevels.neuleben.Neuleben_0_1;
import com.weidni96.Platformer.Level.areas.singleLevels.neuleben.Neuleben_1_1;
import com.weidni96.Platformer.Level.areas.singleLevels.neuleben.Neuleben_2_1;
import com.weidni96.Platformer.Level.areas.singleLevels.neuleben.Neuleben_2_2;
import com.weidni96.Platformer.graphics.Background;
import com.weidni96.Platformer.graphics.Sprite;

/**
 * First little town called "Neuleben", the game starts here.
 * Player can do some minor quests for training.
 * Also underneath the town is the setting for the first dungeon
 * @author Christian
 *
 */
public class Neuleben extends Area{
	
	public Neuleben(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.width 		= 3;
		this.height 	= 3;
		this.name 		= "Neuleben";
		
		this.canRain 	= true;
		this.background = Background.background_01;
		this.areaSprite = Sprite.areaSign_neuleben;
		
		this.levels = new Level[width * height];
		initLevels();
	}
	
	@Override
	public void initLevels(){
		/*	
		 *   0.0  |  1.0  |  2.0
		 *  ---------------------
		 *  [0.1] | [1.1] | [2.1]
		 *  ---------------------
		 *   0.2  |  1.2  | [2.2]
		 */ 
		
		levels[0 + width * 1] = new Neuleben_0_1(this, 0, 1);
		levels[1 + width * 1] = new Neuleben_1_1(this, 1, 1);
		levels[2 + width * 1] = new Neuleben_2_1(this, 2, 1);
		levels[2 + width * 2] = new Neuleben_2_2(this, 2, 2);
	}
	
	@Override
	protected  void individualUpdate(){
	}
}