/**
 * generate loot after killing an enemy 
 */

package com.t4khosu.Platformer.entities;

import java.util.Random;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.interactiveEntities.Loot;
import com.t4khosu.Platformer.entities.mob.Mob;

public class LootGenerator {
	
	private Mob mob;
	
	/**
	 * constructor
	 * @param mob
	 */
	public LootGenerator(Mob mob){
		this.mob = mob;
	}
	
	/**
	 * generate random loot
	 */
	public void randomLoot(){
		Random random = new Random();
		Level l = mob.getLevel();
		
		//TODO Generate loot depending on enemy and decide on kind of loot
		if(random.nextInt(100)+1  <= 15){ // <= 15
			l.interactiveEntities.add(new Loot(mob.getX(), mob.getY(), l, mob.getLootID(), random.nextInt(10)+1));
		}
	}
}
