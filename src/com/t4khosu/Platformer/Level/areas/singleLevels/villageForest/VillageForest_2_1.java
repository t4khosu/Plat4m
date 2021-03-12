package com.t4khosu.Platformer.Level.areas.singleLevels.villageForest;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.entities.interactiveEntities.SavePointManager;
import com.t4khosu.Platformer.entities.enemies.insects.BrownSpider;

public class VillageForest_2_1 extends LoadLevel {

	public VillageForest_2_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null,  
				"/level/standard/village_forest_6.png", 
				"/level/standard/village_forest_6_back.png", 
				levelType.NATURE, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new BrownSpider(86*8, 32*8, this));
	}

	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(SavePointManager.p3_villageForest.initLevelAndReturn(this));
	}

	@Override
	protected void individualUpdate() {
	}

	@Override
	public void individualSaveFileLoad(String input) {
	}
	
	@Override
	public String individualSave() {
		return "";
	}

}
