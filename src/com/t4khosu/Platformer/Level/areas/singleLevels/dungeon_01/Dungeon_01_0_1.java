package com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.Door;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.enemies.insects.PoisonSpider;
import com.t4khosu.Platformer.entities.enemies.slimes.PoisonSlime;

public class Dungeon_01_0_1 extends LoadLevel {

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
	public Dungeon_01_0_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 
				"/level/dungeon_01/dungeon_0_4_back.png", 
				"/level/dungeon_01/dungeon_0_4_front.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(50*8, 87*8, this));
		mobs.add(new PoisonSpider(20*8, 81*8, this));
		mobs.add(new PoisonSpider(58*8, 81*8, this));
	}

	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
		images.add(new Entity(3 * 8, 81 * 8 + 4, Sprite.dungeonEntry_back));
		doors.add(new Door(3*13+4, 84*8, 18, 40, this, null, 1001));
		
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