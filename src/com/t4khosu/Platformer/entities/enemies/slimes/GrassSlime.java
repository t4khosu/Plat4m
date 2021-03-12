package com.t4khosu.Platformer.entities.enemies.slimes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.Sprite;

public class GrassSlime extends Slime{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 */
	public GrassSlime(int x, int y, Level level) {
		super(x, y, Sprite.slime0_0, level);
		
		actTime 	= 120;
		jumpForce = -5.5;
		
		sprites[0] = Sprite.slime0_0;
		sprites[1] = Sprite.slime0_1;
		sprites[2] = Sprite.slime0_2;
		
		this.name 		= "Gemeiner Schleim";
		collisionDamage = 5;
		experience 		= 40;
		money 			= 1;
		lvl 			= 1;
		initLife(10);
	}
	
	/**
	 * mob dies, give player loot
	 * @param player
	 */
	public void die(Player player){
		super.die(player);
		if(NPCManager.dregen_neuleben.getActualDialog() == 4) {
			NPCManager.dregen_neuleben.addSlime();
		}
	}
}