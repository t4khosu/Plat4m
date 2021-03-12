package com.t4khosu.Platformer.Level.areas;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.graphics.Background;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest.HauntedForest_0_1;
import com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest.HauntedForest_0_2;
import com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest.HauntedForest_1_1;
import com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest.HauntedForest_2_1;

/**
 * Area right next to Neuleben, a tiny forest  with some mobs
 * the player can farm and some secrets
 * @author Christian
 *
 */
public class HauntedForest extends Area {
	
	/**
	 * Constructor
	 * @param player
	 * @param world
	 */
	public HauntedForest(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.width 		= 3;
		this.height 	= 3;
		this.name 		= "Haunted Forest";
		
		this.canRain 	= true;
		this.background = Background.background_05;
		this.areaSprite = Sprite.areaSign_hauntedForest;
		
		this.levels  	= new Level[width * height];
		initLevels();
	}
	
	@Override
	public void initLevels(){
		/*	
		 *   0.0  |  1.0  |  2.0 
		 *  ---------------------
		 *  [0.1] | [1.1] | [2.1]
		 *  ---------------------
		 *  [0.2] |  1.2  |  2.2
		 */ 
		
		levels[0 + width * 1] = new HauntedForest_0_1(this, 0, 1);
		levels[1 + width * 1] = new HauntedForest_1_1(this, 1, 1);
		levels[2 + width * 1] = new HauntedForest_2_1(this, 2, 1);
		levels[0 + width * 2] = new HauntedForest_0_2(this, 0, 2);
	}
	
	@Override
	protected  void individualUpdate(){
	}
}
