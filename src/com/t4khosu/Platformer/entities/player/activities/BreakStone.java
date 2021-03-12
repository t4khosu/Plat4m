/**
 * Activity for player
 * When player has a pickaxe, he can break some stones
 * to create a new way or shortcut
 * How fast the process of breaking a stone is depends
 * on the quality of player's actual pickaxe
 */

package com.t4khosu.Platformer.entities.player.activities;

import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.tools.IronPickaxe;
import com.t4khosu.Platformer.entities.item.mainItems.tools.UruPickaxe;
import com.t4khosu.Platformer.entities.item.mainItems.tools.WoodenPickaxe;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.AnimatedSprite;

public class BreakStone {
	
	private Player player;
	private Item pickAxe;
	private boolean started;
	
	private int tileX = 0;
	private int tileY = 0;
	
	private Timer breakTimer = new Timer(0);
	
	/**
	 * constructor
	 * @param player
	 */
	public BreakStone(Player player){
		this.player = player;
	}
	
	/**
	 * check if there is stone -> start activity
	 * @param pickAxe
	 */
	public void start(Item pickAxe){
		int x0 = (player.getX() - 1) / 8;
		int y0 = (player.getY()) / 8;
		if(player.getDirX() > 0) x0 = (player.getX() + player.getWidth() + 1) / 8;
		if(TileGetterList.getTile(x0, y0, player.getLevel()).isBreakable() && !player.getPSM().isWalking()){
			tileX 			= x0;
			tileY 			= y0;
			this.pickAxe 	= pickAxe;
			started 		= true;
			
			calculateBreakTimer();
		}
	}
	
	/**
	 * calculate how long it will take to break stone with pickaxe
	 */
	private void calculateBreakTimer(){
		//TODO change all values by dividing by 10
		if(pickAxe instanceof WoodenPickaxe){
			breakTimer = new Timer(160);
		}else if(pickAxe instanceof IronPickaxe){
			breakTimer = new Timer(80);
		}else if(pickAxe instanceof UruPickaxe){
			breakTimer = new Timer(40);
		}else{
			breakTimer = new Timer(1);
		}
		breakTimer.start();
	}
	
	/**
	 * stop activity
	 */
	public void reset(){
		breakTimer.stop();
		started 		= false;
		this.pickAxe 	= null;
		
		AnimatedSprite.player_breakStone_left.reset();
		AnimatedSprite.player_breakStone_right.reset();
	}
	
	/**
	 * update activity
	 */
	public void update(){
		if(!started) return;
		if(!player.getPSM().isWalking()){
			if(breakTimer.isActive()){
				if(player.getDirX() < 0) player.setPlayerAnimated(AnimatedSprite.player_breakStone_left);
				else player.setPlayerAnimated(AnimatedSprite.player_breakStone_right);
				breakTimer.update();
			}
			else{
				player.getLevel().setTile(tileX, tileY, 0);
				reset();
			}	
		}else{
			reset();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean hasStarted(){
		return started;
	}
}