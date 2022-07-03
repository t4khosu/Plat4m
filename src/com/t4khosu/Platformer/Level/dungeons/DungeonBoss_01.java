package com.t4khosu.Platformer.Level.dungeons;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.DungeonBossLevel;
import com.t4khosu.Platformer.graphics.Sprite;

/**
 * The first dungeon a player can find, the
 * "Poison Factory"
 * @author Christian
 *
 */
public class DungeonBoss_01 extends Dungeon{
	
	/**
	 * Constructor
	 * @param player
	 * @param world
	 */
	public DungeonBoss_01(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.name = "";
		this.width = 4;
		this.height = 1;
		
		this.background = null;
		this.areaSprite = Sprite.void_sprite;
		
		this.levels = new Level[width * height];
		initLevels();
	}
	
	
	@Override
	protected void individualUpdate(){
	}
	
	@Override
	protected void initLevels(){
		/*
		 * 0 1 2 3 
		 */
		levels[1 + width * 0] = new DungeonBossLevel(this, 1, 0);
	}
}