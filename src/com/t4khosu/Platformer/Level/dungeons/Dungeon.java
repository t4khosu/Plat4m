package com.t4khosu.Platformer.Level.dungeons;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.World;

public abstract class Dungeon extends Area {
	
	protected int keys;
	protected boolean finished = false;
	
	/**
	 * Constructor
	 * @param player
	 * @param world
	 */
	public Dungeon(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.keys = 0;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void finishDungeon(){
		finished = true;
	}
	public boolean isFinished(){
		return finished;
	}
}
