package com.weidni96.Platformer.Level.areas.singleLevels.dungeon_01;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.enemies.slimes.PoisonSlime;

public class Dungeon_01_1_0 extends LoadLevel{
	
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
	public Dungeon_01_1_0(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(),
				null, 
				"/level/dungeon_01/dungeon_1_0_front.png", 
				"/level/dungeon_01/dungeon_1_0_back.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(51*8, 67*8, this));
		mobs.add(new PoisonSlime(56*8, 87*8, this));
	}

	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
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