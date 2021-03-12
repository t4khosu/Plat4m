package com.weidni96.Platformer.Level.areas;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.Level.areas.singleLevels.villageForest.VillageForest_1_1;
import com.weidni96.Platformer.Level.areas.singleLevels.villageForest.VillageForest_2_1;
import com.weidni96.Platformer.Level.areas.singleLevels.villageForest.VillageForest_2_2;
import com.weidni96.Platformer.Level.areas.singleLevels.villageForest.VillageForest_3_1;
import com.weidni96.Platformer.graphics.Background;
import com.weidni96.Platformer.graphics.Sprite;

public class VillageForest extends Area{

	public VillageForest(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.width 		= 4;
		this.height 	= 3;
		this.name 		= "Village Forest";
		
		this.canRain 	= true;
		this.background = Background.background_04;
		this.areaSprite = Sprite.areaSign_villageForest;
		
		this.levels = new Level[width * height];
		initLevels();
	}

	@Override
	protected void initLevels() {
		/*	
		 *  0.0	|  1.0  |  2.0  |  3.0
		 *  -------------------------
		 *  0.1 | [1.1] | [2.1] | [3.1]
		 *  -------------------------
		 *  0.2 |  1.2  | [2.2] |  3.2
		 */ 
		
		levels[1 + width * 1] = new VillageForest_1_1(this, 1, 1);
		levels[2 + width * 1] = new VillageForest_2_1(this, 2, 1);
		levels[2 + width * 2] = new VillageForest_2_2(this, 2, 2);
		levels[3 + width * 1] = new VillageForest_3_1(this, 3, 1);
	}
	
	@Override
	protected void individualUpdate() {
	}

}
