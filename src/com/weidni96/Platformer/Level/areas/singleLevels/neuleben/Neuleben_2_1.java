package com.weidni96.Platformer.Level.areas.singleLevels.neuleben;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.graphics.Middleground;

public class Neuleben_2_1 extends LoadLevel{

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
	public Neuleben_2_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				Middleground.forest3, 
				"/level/standard/forest_village_3.png", 
				"/level/standard/forest_village_3_back.png", 
				levelType.VILLAGE,
				area,
				areaPosX,
				areaPosY
			);
	}
	
	@Override
	protected void initNPCs(){
		npcs.add(NPCManager.priest_neuleben.initLevelAndReturn(this)); 
	}
	
	@Override
	protected void initSurroundings(){
		interactiveEntities.add(new Sign(37*8, 46*8, "Ende - Verlassen auf eigene Gefahr", SignType.WOODEN)); 
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