package com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;

public class HauntedForest_2_1 extends LoadLevel {

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
	public HauntedForest_2_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 				
				"/level/standard/forest_4.png", 			
				"/level/standard/forest_4_back.png", 
				levelType.NATURE, 
				area,
				areaPosX,
				areaPosY
		);
	}
	
	@Override
	protected void initNPCs(){
	}
	
	@Override
	protected void initSurroundings(){
	}
	
	@Override
	protected void initMobs(){
	}

	@Override
	protected void individualUpdate() {	
	}
	
	@Override
	public String individualSave() {
		return "";
	}

	@Override
	public void individualSaveFileLoad(String input) {
		
	}
}