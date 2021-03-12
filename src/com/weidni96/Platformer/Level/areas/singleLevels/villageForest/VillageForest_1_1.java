package com.weidni96.Platformer.Level.areas.singleLevels.villageForest;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.entities.interactiveEntities.Anvil;
import com.weidni96.Platformer.entities.interactiveEntities.Fire;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.entities.interactiveEntities.bookshelfes.Blacksmith_Bookshelf;

public class VillageForest_1_1 extends LoadLevel{

	public VillageForest_1_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 
				"/level/standard/village_forest_1_1.png", 
				"/level/standard/village_forest_1_1_back.png",  
				levelType.NATURE, 
				area, 
				areaPosX, 
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initNPCs() {
		npcs.add(NPCManager.talonBlacksmith_villageForest.initLevelAndReturn(this));
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(new Sign(57*8, 18*8, "Kluft der Schmiede", SignType.OLDWOODEN)); 
		interactiveEntities.add(new Blacksmith_Bookshelf(30*8, 31*8, this)); 
		interactiveEntities.add(new Anvil(39*8,22*8));
		interactiveEntities.add(Fire.blacksmithFire.initFireAndReturn(this));
	}

	@Override
	protected void individualUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void individualSaveFileLoad(String input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String individualSave() {
		// TODO Auto-generated method stub
		return "";
	}

}
