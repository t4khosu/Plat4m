package com.weidni96.Platformer.entities.player.activities;

import java.util.List;

import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.weidni96.Platformer.entities.interactiveEntities.plants.AgroilberryPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.Plant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.PlantManager;
import com.weidni96.Platformer.entities.interactiveEntities.plants.RolberryPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.WheatPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.YocipPlant;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.plants.AgroilberrySeed;
import com.weidni96.Platformer.entities.item.mainItems.plants.RolberrySeed;
import com.weidni96.Platformer.entities.item.mainItems.plants.WheatSeed;
import com.weidni96.Platformer.entities.item.mainItems.plants.YocipSeed;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Sprite;

public class Planting {
	
	private Player player;
	
	private int maxPlantTimer = 50;
	private int plantTimer = maxPlantTimer;
	
	/**
	 * constructor
	 * @param player
	 */
	public Planting(Player player){
		this.player = player;
	}
	
	/**
	 * if player has more than one seed of a kind, he can plant it.
	 * yet the field beneath must have been plowed.
	 * @param seed
	 */
	public void update(Item seed){
		int x0 = player.getX() + player.getWidth()/2;
		int y0 = player.getY() + 8;
		
		List<InteractiveEntity> ies = player.getLevel().getInteractiveEntities((x0/8)*8, player.getY());
		for(InteractiveEntity ie : ies){
			if(ie instanceof Plant) return; /* is there already a plant? */
		}
		
		
		if(TileGetterList.getTile(x0/8, y0/8, player.getLevel()).isPlantable() && !player.getPSM().isMoving() && seed.getAmount() > 0){
			if(player.getDirX() < 0) player.setSprite(Sprite.player_left_plant);
			else player.setSprite(Sprite.player_right_plant);
			
			if(plantTimer > 0) plantTimer--;
			else{
				plantTimer 	 = maxPlantTimer;
				
				Plant p = null;
				if(seed instanceof AgroilberrySeed) 	p = new AgroilberryPlant((x0/8)*8, player.getY());
				else if(seed instanceof WheatSeed) 		p = new WheatPlant((x0/8)*8, player.getY());
				else if(seed instanceof RolberrySeed) 	p = new RolberryPlant((x0/8)*8, player.getY());
				else if(seed instanceof YocipSeed) 		p = new YocipPlant((x0/8)*8, player.getY());
				
				if(p != null){
					PlantManager.addPlant(p);
					player.getLevel().addInteractiveEntity(p);
					seed.useItem(1);
				}
			}
		}
	}
	
	/**
	 * stop planting
	 */
	public void reset(){
		plantTimer 	 = maxPlantTimer;
	}
}
