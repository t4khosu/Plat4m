package com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.entities.enemies.StoneSnail;
import com.t4khosu.Platformer.entities.enemies.insects.PoisonSpider;
import com.t4khosu.Platformer.entities.enemies.slimes.PoisonSlime;

public class Dungeon_01_0_0 extends LoadLevel {
	
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
	public Dungeon_01_0_0(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(),
				null, 
				"/level/dungeon_01/dungeon_0_0_front.png", 
				"/level/dungeon_01/dungeon_0_0_back.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(24*8, 73*8, this));
		mobs.add(new PoisonSlime(37*8, 75*8, this));
		mobs.add(new PoisonSlime(63*8, 73*8, this));
		mobs.add(new StoneSnail(36*8, 75*8, this));
		mobs.add(new StoneSnail(29*8, 59*8, this));
		mobs.add(new PoisonSpider(33*8, 61*8, this));
		mobs.add(new PoisonSpider(44*8, 67*8, this));
		mobs.add(new PoisonSpider(39*8, 67*8, this));
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