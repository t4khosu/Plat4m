package com.weidni96.Platformer.Level.areas.singleLevels.dungeon_01;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.enemies.slimes.PoisonSlime;

public class Dungeon_01_2_0 extends LoadLevel{
	
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
	public Dungeon_01_2_0(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(),  
				null, 
				"/level/dungeon_01/dungeon_2_0_front.png", 
				"/level/dungeon_01/dungeon_2_0_back.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(47*8, 72*8, this));
		mobs.add(new PoisonSlime(49*8, 61*8, this));
		mobs.add(new PoisonSlime(13*8, 64*8, this));
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