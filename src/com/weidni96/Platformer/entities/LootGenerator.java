/**
 * generate loot after killing an enemy 
 */

package com.weidni96.Platformer.entities;

import java.util.Random;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.interactiveEntities.Loot;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.extras.Money;
import com.weidni96.Platformer.entities.mob.Mob;

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
