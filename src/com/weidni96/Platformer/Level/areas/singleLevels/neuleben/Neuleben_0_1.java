package com.weidni96.Platformer.Level.areas.singleLevels.neuleben;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;
import com.weidni96.Platformer.entities.interactiveEntities.SavePointManager;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.entities.interactiveEntities.bookshelfes.Dregens_Bookshelf;
import com.weidni96.Platformer.graphics.Middleground;

public class Neuleben_0_1 extends LoadLevel{

	/**
	 * Constructor
	 * @param player
	 * @param middleground
	 * @param background
	 * @param frontTiles
	 * @param backTiles
	 * @param type
	 * @param area
	 */
	public Neuleben_0_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				Middleground.forest1,  
				"/level/standard/forest_village_1.png", 
				"/level/standard/forest_village_1_back.png", 
				levelType.VILLAGE, 
				area,
				areaPosX,
				areaPosY
		);
	}
	
	@Override
	protected void initNPCs(){
		npcs.add(NPCManager.ahb_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.ans_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.barus_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.dregen_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.gorn_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.honja_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.levindra_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.locus_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.tobi_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.giza_neuleben.initLevelAndReturn(this));
		npcs.add(NPCManager.isan_neuleben.initLevelAndReturn(this));
	}
	
	@Override
	protected void initSurroundings(){
		interactiveEntities.add(SavePointManager.p1_neuleben.initLevelAndReturn(this));
		interactiveEntities.add(ChestManager.woodenFishingPole_neuleben.initChestAndReturn(this));
		
		interactiveEntities.add(new Sign(72*8, 46*8, "Speicherpunkt", SignType.WOODEN)); 
		interactiveEntities.add(new Dregens_Bookshelf(68*8, 25*8, this)); 
	}
	
	@Override
	protected void initMobs(){
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