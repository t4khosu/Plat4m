/**
 * Activity of player,
 * if tehre is dirt beneath player that has not be plown, player
 * can plow it.
 */

package com.t4khosu.Platformer.entities.player.activities;

import java.util.List;

import com.t4khosu.Platformer.Level.tile.Tile;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.Plant;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.AnimatedSprite;

public class Plowing {
	
	private Player player;
	
	private int maxPlowTimer = 100;
	private int plowTimer = maxPlowTimer;
	
	private boolean plowing 	= false;
	
	/**
	 * constructor
	 * @param player
	 */
	public Plowing(Player player){
		this.player = player;
	}
	
	/**
	 * reset everything, when stop plowing
	 */
	public void reset(){
		plowing 	= false;
		plowTimer	 = maxPlowTimer;
		AnimatedSprite.player_plow_left.reset();
		AnimatedSprite.player_plow_right.reset();
	}
	
	/**
	 * update, plow dirt beneath if tehre is dirt
	 * @param shovel
	 */
	public void update(Item shovel){
		//getPosition
		int x0 = (player.getX() + 1) / 8;
		int y0 = (player.getY() + 8) / 8;
		if(player.getDirX() > 0) x0 = (player.getX() + player.getWidth() - 2) / 8;
		
		//check if there is a plant already
		Plant p = null;
		List<InteractiveEntity> ies = player.getLevel().getInteractiveEntities(x0*8, (y0-1)*8);
		for(InteractiveEntity ie : ies){
			if(ie instanceof Plant){
				p = (Plant)ie;
				break;
			}
		}
		
		if(TileGetterList.getTile(x0, y0, player.getLevel()).isPlowable() && !player.getPSM().isWalking() &&
				!TileGetterList.getTile(player.getX()/8, player.getY()/8, player.getLevel()).isUnderWater()){
			plowing = true;
			if(plowTimer > 0){
				if(player.getDirX() < 0) player.setPlayerAnimated(AnimatedSprite.player_plow_left);
				else player.setPlayerAnimated(AnimatedSprite.player_plow_right);
				plowTimer--;
			}
			else{
				player.getLevel().setTile(x0, y0, Tile.ID_field);
				reset();
			}	
		}else if(p != null){
			plowing = true;
			if(plowTimer > 0){
				if(player.getDirX() < 0) player.setPlayerAnimated(AnimatedSprite.player_plow_left);
				else player.setPlayerAnimated(AnimatedSprite.player_plow_right);
				plowTimer--;
			}
			else{
				p.remove();
				reset();
			}	
		}else{
			reset();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean getPlowing(){
		return plowing;
	}
}
