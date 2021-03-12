/**
 * Activity of player,
 * The second activity that needs a pickaxe, but here player can
 * earn raw material like coal/iron,...
 */

package com.weidni96.Platformer.entities.player.activities;

import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.SlowMovingEntity;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.groundTreasures.Coal;
import com.weidni96.Platformer.entities.item.mainItems.groundTreasures.RawIron;
import com.weidni96.Platformer.entities.item.mainItems.tools.IronPickaxe;
import com.weidni96.Platformer.entities.item.mainItems.tools.UruPickaxe;
import com.weidni96.Platformer.entities.item.mainItems.tools.WoodenPickaxe;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Mine {
	
	private Timer mineTimer = new Timer(0);
	private Timer noStamina; // no spam in log that no stamina, only message every second
	private Player player;
	private Tile minedMaterial;
	
	private boolean started;
	private Item pickAxe;
	
	/**
	 * constructor
	 * @param player
	 */
	public Mine(Player player){
		this.player = player;
		this.noStamina = new Timer(90);
	}
	
	/**
	 * try to start mining with pickAxe
	 * @param pickAxe
	 */
	public void start(Item pickAxe){
		int x0 = (player.getX() - 1) / 8;
		int y0 = (player.getY()) / 8;
		if(player.getDirX() > 0) x0 = (player.getX() + player.getWidth() + 1) / 8;
		if(TileGetterList.getTile(x0, y0, player.getLevel()).isMinable() && !player.getPSM().isWalking()){
			minedMaterial = TileGetterList.getTile(x0, y0, player.getLevel());
			started = true;
			this.pickAxe = pickAxe;
			
			calculateMineTimer();
		}
	}
	
	/**
	 * calculate how long it will take to break stone depending on stone and pickAxe
	 */
	public void calculateMineTimer(){
		int time = 0;
		if(pickAxe instanceof WoodenPickaxe){
			time += 400;
		}else if(pickAxe instanceof IronPickaxe){
			time += 300;
		}else if(pickAxe instanceof UruPickaxe){
			time += 200;
		}else{
			time = 333;
		}
		
		if(minedMaterial == Tile.hardCoalTile){
			time *= 1.3;
		}
		else if(minedMaterial == Tile.ironTile){
			time *= 1.9;
		}
		else if(minedMaterial == Tile.ironTile){
			time *= 2.8;
		}
		
		mineTimer = new Timer((int)time);
		mineTimer.start();
	}
	
	/**
	 * stop mining by resetting everything
	 */
	public void reset(){
		started = false;
		
		AnimatedSprite.player_breakStone_left.reset();
		AnimatedSprite.player_breakStone_right.reset();
		
		mineTimer.stop();
	}
	
	/**
	 * if found stone, try to mine. stop if player is moving or has no stamina
	 */
	public void update(){
		if(!started) return;
		
		if(!player.getPSM().isMoving()){
			if(player.getStamina() >= pickAxe.getStaminaUse()){
				if(player.getDirX() < 0) 	player.setPlayerAnimated(AnimatedSprite.player_breakStone_left);
				else 						player.setPlayerAnimated(AnimatedSprite.player_breakStone_right);
				
				mineTimer.update();
				
				if(!mineTimer.isActive()){
					
					if(minedMaterial == Tile.hardCoalTile){
						player.getItemStore().addItem(Item.coal_ID, 1);
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()-4, player.getY()-8, Sprite.get_coal_sprite, 0, -1, 5, 50));
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()+4, player.getY()-8, Sprite.use_stamina_sprite, 0, -1, 5, 50));
						player.addLogEntry("Kohle gewonnen", 0xffFFFFFF);
					}
					
					else if(minedMaterial == Tile.ironTile){
						player.getItemStore().addItem(Item.rawIron_ID, 1);
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()-4, player.getY()-8, Sprite.get_rawIron_sprite, 0, -1, 5, 50));
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()+4, player.getY()-8, Sprite.use_stamina_sprite, 0, -1, 5, 50));
						player.addLogEntry("Eisen gewonnen", 0xffFFFFFF);
					}
					
					else if(minedMaterial == Tile.polluted_hardCoalTile){
						player.getItemStore().addItem(Item.coal_ID, 1);
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()-4, player.getY()-8, Sprite.get_coal_sprite, 0, -1, 5, 50));
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()+4, player.getY()-8, Sprite.use_stamina_sprite, 0, -1, 5, 50));
						player.addLogEntry("Verschmutzte Kohle gewonnen", 0xffFFFFFF);
					}
					
					else if(minedMaterial == Tile.polluted_ironTile){
						player.getItemStore().addItem(Item.rawIron_ID, 1);
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()-4, player.getY()-8, Sprite.get_rawIron_sprite, 0, -1, 5, 50));
						player.getLevel().addSlowMovingEntity(new SlowMovingEntity(player.getX()+4, player.getY()-8, Sprite.use_stamina_sprite, 0, -1, 5, 50));
						player.addLogEntry("Verschmutzes Eisen gewonnen", 0xffFFFFFF);
					}
					
					player.useStamina(pickAxe.getStaminaUse());
					mineTimer.start();
				}
			}else{
				reset();
				if(!noStamina.isActive()){
					player.addLogEntry("Nicht genug Stamina", 0xffFF0000);
					noStamina.start();
				}else{
					noStamina.update();
				}
			}
		}else{
			reset();
		}
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		if(!started) return;	
		screen.renderBar(player.getX(), player.getY()-2, mineTimer.getTime(), mineTimer.getMaxTime(),
				player.getWidth(), 0xff915E35, true);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean hasStarted(){
		return started;
	}
	public Timer getTimer(){
		return mineTimer;
	}
}
