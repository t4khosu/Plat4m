package com.weidni96.Platformer.Level.areas.singleLevels.hauntedForest;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.enemies.StoneSnail;
import com.weidni96.Platformer.entities.enemies.insects.BrownSpider;
import com.weidni96.Platformer.entities.enemies.slimes.UndergroundSlime;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;

public class HauntedForest_0_2 extends LoadLevel{
	
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
	public HauntedForest_0_2(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 								   
				"/level/standard/haunted_forest_6.png", 	
				"/level/standard/haunted_forest_6_back.png", 
				levelType.UNDERGROUND, 
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
		interactiveEntities.add(ChestManager.healthPotion_hauntedForest.initChestAndReturn(this));
		interactiveEntities.add(ChestManager.agroilBerry_hauntedForest.initChestAndReturn(this));
		interactiveEntities.add(ChestManager.rolBerrySeed_hauntedForest.initChestAndReturn(this));
	}
	
	@Override
	protected void initMobs(){
		mobs.add(new StoneSnail(38*8, 23*8, this));
		mobs.add(new StoneSnail(67*8, 17*8, this));
		mobs.add(new StoneSnail(75*8, 13*8, this));
		mobs.add(new StoneSnail(73*8, 20*8, this));
		mobs.add(new StoneSnail(64*8, 33*8, this));
		mobs.add(new StoneSnail(58*8, 33*8, this));
		mobs.add(new StoneSnail(50*8, 36*8, this));
		mobs.add(new StoneSnail(18*8, 21*8, this));
		mobs.add(new UndergroundSlime(39*8, 36*8, this));
		mobs.add(new UndergroundSlime(42*8, 42*8, this));
		mobs.add(new UndergroundSlime(65*8, 43*8, this));
		mobs.add(new UndergroundSlime(28*8, 44*8, this));
		mobs.add(new BrownSpider(42*8, 33*8, this));
		mobs.add(new BrownSpider(5*8,  19*8, this));
		mobs.add(new BrownSpider(34*8, 32*8, this));
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