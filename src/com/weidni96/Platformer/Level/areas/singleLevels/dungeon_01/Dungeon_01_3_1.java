package com.weidni96.Platformer.Level.areas.singleLevels.dungeon_01;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.enemies.slimes.PoisonSlime;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;

public class Dungeon_01_3_1 extends LoadLevel{

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
	public Dungeon_01_3_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 
				"/level/dungeon_01/dungeon_3_1_front.png", 
				"/level/dungeon_01/dungeon_3_1_back.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
		
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(27*8, 36*8, this));
		mobs.add(new PoisonSlime(40*8, 80*8, this));
		mobs.add(new PoisonSlime(67*8, 45*8, this));
	}
	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(ChestManager.boots_dungeon01.initChestAndReturn(this));
		interactiveEntities.add(ChestManager.rawIron_dungeon01.initChestAndReturn(this));
		interactiveEntities.add(new Sign(43*8, 35*8, "Willst du zum Schatz, so finde die Schalter...", SignType.WOODEN)); 
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