/**
 * Keyboard inputs that are done by player
 * update function must be included into player's update function
 * 
 * psm is updated depending on inputs and animated sprites are set
 * this class is not for the actual movement of the player, only direction change if necessary!
 */

package com.t4khosu.Platformer.entities.player;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.entities.Door;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.potions.HealthPotion;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.input.Keyboard;
import com.t4khosu.Platformer.entities.player.activities.PlayerStatusManager;

public class KeyboardManager {
	
	private Player player;
	private World world;
	private PlayerStatusManager psm;
	private PlayerTimerManager ptm;
	private Keyboard input;
	private InteractManager interactManager;
	
	//Stuff close to player but not triggered with SPACE
	private Door door;
	private boolean entersDoor = false;
	
	/**
	 * constructor
	 * @param player
	 * @param am
	 * @param tm
	 */
	public KeyboardManager(Player player, PlayerStatusManager am, PlayerTimerManager tm){
		this.player = player;
		this.world = player.getWorld();
		this.psm = am;
		this.ptm = tm;
		this.input = player.getInput();
		this.interactManager = new InteractManager(player);
	}
	
	public void canMoveUpdate(){
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press RIGHT arrow */
		if(input.right){
				psm.setWalking(true);
				player.setDirX(1);
				if(psm.isCrawling()) player.setPlayerAnimated(AnimatedSprite.player_crawl_right);
				else player.setPlayerAnimated(AnimatedSprite.player_right);
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press LEFT arrow */
		if(input.left){
			psm.setWalking(true);
			player.setDirX(-1);
			if(psm.isCrawling()) player.setPlayerAnimated(AnimatedSprite.player_crawl_left);
			else player.setPlayerAnimated(AnimatedSprite.player_left);
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press DOWN arrow */
		if(input.down){
			psm.setCrawling(true);
			if(player.getDirX() < 0) player.setPlayerAnimated(AnimatedSprite.player_crawl_left);
			else if(player.getDirX() > 0) player.setPlayerAnimated(AnimatedSprite.player_crawl_right);
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Type UP arrow */
		if(input.typedUp){
			if(player.bottomCollision() && !psm.isWalking()){
				this.door = player.getLevel().getDoorAt(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2);
				
				if(door != null){
					player.getPSM().setEnteringDoor(true);
					world.startDoorCutscene(door.getDestiny());
					door = null;
					return;
				}
			}
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press UP arrow */
		if(input.up){
			if(!player.getPSM().isEnteringDoor()){
				if(!player.getMSM().getCanClimb()){
					player.getMSM().setJumping(true);
				}else{
					psm.setClimbing(true);
					player.setDirY(-1);
					player.setPlayerAnimated(AnimatedSprite.player_climb);
				}
			}
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press H */
		if(input.harvest){
			psm.harvesting.update();
		}else{
			psm.harvesting.reset();
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press J or K */
		if(input.j || input.k){
			int key = 0;
			if(input.k) key = 1;
			
			if(player.getJK()[key] != null){ /* holding an item */
				
				//Fishing:
				if(player.getJK()[key].getType() == Item.ItemType.POLE){
					psm.fishing.update(player.getJK()[key]);
				}
				
				//Planting:
				if(player.getJK()[key].getType() == Item.ItemType.SEEDS){
					psm.planting.update(player.getJK()[key]);
				}
				
				//Plowing:
				if(player.getJK()[key].getType() == Item.ItemType.SHOVEL){
					psm.plowing.update(player.getJK()[key]);
				}
				
				//Break stone:
				if(player.getJK()[key].getType() == Item.ItemType.PICKAXE){
					if(!psm.breakStone.hasStarted()) psm.breakStone.start(player.getJK()[key]);
					if(!psm.mine.hasStarted())		 psm.mine.start(player.getJK()[key]);
					psm.breakStone.update();
					psm.mine.update();
				}
			}
			
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Release J and K or is walking */
		} else if((!input.j && !input.k) || psm.isWalking()){
			psm.reset();
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Type J or K */
		if(input.typedJ || input.typedK){
			int key = 0;
			if(input.k) key = 1;
			
			Item i = null;
			if((i = player.getJK()[key]) != null){ /* holding an item */
				
				//Hitting:
				if(player.getLevel().getType() != Level.levelType.HOUSE && player.getLevel().getType() != Level.levelType.VILLAGE){ /* level where can hit */
					if(i.getType() == Item.ItemType.SWORD && !psm.swingSword.getSwingingSword()){
						player.setSprite(AnimatedSprite.player_hit_right.getSprite());
						AnimatedSprite.player_hit_right.update();
						psm.swingSword.init(player.getLevel(), player.getJK()[key]);
						psm.swingSword.update();
					}
				}
				
				//Fishing:
				if(i.getType() == Item.ItemType.POLE && player.getPSM().fishing.isCatching()){
					player.getPSM().fishing.increaseTypeCounter();
				}
				
				//eat berry
				
				if(i.getType() == Item.ItemType.BERRY &&  !ptm.getPotionTimer().isActive()){
					player.eatBerry(i);
				}
			}
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Press 1, 2, 3, 4, 5 or 6 */
		for(int i = 0; i < input.numbers.length; i++){
			if(input.numbersTyped[i]){
				if(player.getSmallSlots()[i] != null){ /* holding an item */
					if(player.getSmallSlots()[i].getAmount() > 0 && !ptm.getPotionTimer().isActive()){
						if(player.getSmallSlots()[i] instanceof HealthPotion && player.getLife() != player.getMaxLife()){
							player.usePotion(player.getSmallSlots()[i]);;
							ptm.getPotionTimer().start();
						}
						
					}
				}
			}
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Type L */
		if(input.typedLog){
			if(player.getLog().getPermaOpen()){
				player.getLog().setPermaOpen(false);
			}else player.getLog().setPermaOpen(true);
		}
	}
	
	/**
	 * check space update
	 */
	public void generalUpdate(){
		if(input.typedInventory){
			if(!world.getSurface().openTextBox()){
				world.getSurface().openInventory();
			}
			
		} else if(input.esc){
			world.getSurface().getInventory().close();
		}
		
		//Typed Space
		if(input.typedInteract && !world.getSurface().getInventory().isOpen()){
			interactManager.tryToInteract();
		}
	}
	
	/**
	 * normal update, look whether play can move -> moveUpdate.
	 * In any other case do general update.
	 */
	public void update(){
		if(world.canMove()){
			//look for keyboard input, while there is no inventory open nor an actual text box
			canMoveUpdate(); 
		}
		//look for keyboard inputs all the time
		generalUpdate();
	}
	
	public void typedUpUpdate(){
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/* Type UP arrow */
		if(input.typedUp && !player.getPSM().isEnteringDoor()){
			if(player.getJumpCount() > 0){
				if(!player.getMSM().getCanClimb()){
					player.getMSM().setJumping(true);
				}
			}
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public InteractManager getInteractManager(){
		return interactManager;
	}
}
