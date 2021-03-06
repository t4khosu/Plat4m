package com.t4khosu.Platformer.Level.areas.singleLevels.villageForest;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.interactiveEntities.ChestManager;
import com.t4khosu.Platformer.entities.interactiveEntities.Sign;
import com.t4khosu.Platformer.graphics.Middleground;
import com.t4khosu.Platformer.entities.enemies.slimes.GrassSlime;

public class VillageForest_3_1 extends LoadLevel {

	public VillageForest_3_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				Middleground.forest1,
				"/level/standard/village_forest_1.png", 
				"/level/standard/village_forest_1_back.png", 
				levelType.NATURE, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new GrassSlime(82*8, 43*8, this));
		mobs.add(new GrassSlime(60*8, 40*8, this));
		mobs.add(new GrassSlime(49*8, 46*8, this));
		mobs.add(new GrassSlime(13*8, 42*8, this));
		mobs.add(new GrassSlime(23*8, 37*8, this));
	}

	@Override
	protected void initNPCs() {
		npcs.add(NPCManager.wachposten_villageForest.initLevelAndReturn(this));
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(new Sign(74*8, 44*8, "Dr\u00FCcke L f\u00FCr Log", Sign.SignType.WOODEN));
		interactiveEntities.add(ChestManager.coal_villageForest.initChestAndReturn(this));
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
