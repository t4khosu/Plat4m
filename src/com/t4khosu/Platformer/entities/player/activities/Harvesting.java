/**
 * Activity of player, 
 * if a plant is ripe and right beneath the player,
 * he can harvest it. No special equipment needed.
 */

package com.t4khosu.Platformer.entities.player.activities;

import java.util.List;

import com.t4khosu.Platformer.entities.SlowMovingEntity;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Agroilberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Rolberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Wheat;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Yocip;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.AgroilberryPlant;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.Plant;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.RolberryPlant;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.WheatPlant;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.YocipPlant;

public class Harvesting {
	
	private Player player;
	private Timer harvestTimer;
	
	public Harvesting(Player player){
		this.player = player;
		harvestTimer = new Timer(70);
	}
	
	/**
	 * harvest plant when player is not moving around
	 */
	public void update(){
		int x0 = player.getX() + player.getWidth()/2;
		
		if(!player.getPSM().isWalking()){
			
			Plant p = null;
			List<InteractiveEntity> ies = player.getLevel().getInteractiveEntities((x0/8)*8, player.getY());
			for(InteractiveEntity ie : ies){
				if(ie instanceof Plant){
					p = (Plant)ie;
					break;
				}
			}
			if(p == null) return; /* no plant there */
			
			if(p.isRipe()){
				if(!harvestTimer.isActive()) harvestTimer.start();
				
				if(player.getDirX() < 0) player.setSprite(Sprite.player_left_plant);
				else player.setSprite(Sprite.player_right_plant);
				
				if(harvestTimer.isActive()) harvestTimer.update();
				if(!harvestTimer.isActive()){
					p.harvest();
					Item outcome = null;
					Sprite upSymbol = null;
					if(p instanceof WheatPlant){
						outcome = new Wheat();
						upSymbol = Sprite.get_wheat_sprite;
					}else if(p instanceof AgroilberryPlant){
						outcome = new Agroilberry();
						upSymbol = Sprite.get_agroilberry_sprite;
					}else if(p instanceof RolberryPlant){
						outcome = new Rolberry();
						upSymbol = Sprite.get_rolberry_sprite;
					}else if(p instanceof YocipPlant){
						outcome = new Yocip();
						upSymbol = Sprite.get_yocip_sprite;
					}
					player.getItemStore().addItem(outcome.getID(), 1);
					player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX(), player.getY()-8, upSymbol, 0, -1, 5, 50));
				}
			}
		}
	}
	
	/**
	 * when stopped harvesting or finished
	 */
	public void reset(){
		harvestTimer.stop();
	}
}
