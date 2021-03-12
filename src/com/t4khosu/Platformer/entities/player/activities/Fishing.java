/**
 * Activity of player,
 * when player has a fishing pole, he can start fishing.
 * Fishing only works, when the bottom-left/-right tile is an UnderWater tile.
 * Chances of catching a fish depend on how fast the user can click j/k.
 * TODO more than one kind of fish
 * TODO different water types got different fish types
 */

package com.t4khosu.Platformer.entities.player.activities;

import java.util.Random;

import com.t4khosu.Platformer.Level.tile.Tile;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.dialog.Message;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.meat.Corjack;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class Fishing {
	
	private Player player;
	private Random random;
	
	private Timer fishingTimer;
	private Timer onHookTimer;
	private Timer catchingTimer;
	
	private int typeCounter = 0; /* for catching mode */
	private int neededTypes = 0;
	
	private Sprite fishingPole; /* extra fishing pole that must be rendered */
	private AnimatedSprite fishingPole_right = new AnimatedSprite(8, SpriteSheet.fishing_pole_right_sheet, 2, 25, false);
	private AnimatedSprite fishingPole_left  = new AnimatedSprite(8, SpriteSheet.fishing_pole_left_sheet, 2, 25, false);
	
	private Tile fishingSpot;
	
	/**
	 * constructor
	 * @param player
	 */
	public Fishing(Player player){
		this.player   = player;
		this.random   = new Random();
		catchingTimer = new Timer(random.nextInt(50)+200);
	}
	
	/**
	 * way to catch a fish
	 * 1. check if player is moving, if so then stop fishing
	 * 2. look whether there is water to fish in, if es, then start fishing
	 * 3. if there is a fish on the hook, wait until player releases key,
	 * 	  if key is released too late, go back to fishing again
	 * 4. if key was released in the right moment, the catching mode begins
	 * @param pole
	 */
	public void update(Item pole){
		
		//reset fishing immediately when player starts walking
		if(player.getPSM().isMoving() || player.getMSM().isUnderWater()){
			hardReset();
			return;
		}
		
		//before fishing check if it is possible
		if(!isFishing() && !isCatching() && !isOnHook()){
			int x0 = (player.getX() - 3) / 8;
			int y0 = (player.getY() + 8) / 8;
			if(player.getDirX() > 0) x0 = (player.getX() + player.getWidth() + 3) / 8;
			
			fishingSpot = TileGetterList.getTile(x0, y0, player.getLevel());
			if(fishingSpot.isFishable()){
				startFishing();
				if(player.getDirX() < 0) fishingPole = Sprite.fishingPole_left_sprite;
				else fishingPole = Sprite.fishingPole_right_sprite;
			}
		}
		
		//while fishing
		else if(isFishing() && !isOnHook() && !isCatching()){
			fishingTimer.update();
			if(player.getDirX() < 0) player.setSprite(Sprite.player_left_fishing);
			else player.setSprite(Sprite.player_right_fishing);
			
			if(!fishingTimer.isActive()){
				onHook();			
			}
		}
		
		//while fish is on hook
		else if(isOnHook() && !isFishing() && !isCatching()){
			onHookTimer.update();
			if(player.getDirX() < 0){
				player.setSprite(Sprite.player_left_fishing);
				fishingPole = fishingPole_left.getSprite();
				fishingPole_left.update();
			}else{
				player.setSprite(Sprite.player_right_fishing);
				fishingPole = fishingPole_right.getSprite();
				fishingPole_right.update();
			}
			
			/* look for released key in KeyboardManager Class */
			
			if(!onHookTimer.isActive()){
				startFishing();
				fishingPole_right.reset();
				fishingPole_left.reset();
				if(player.getDirX() < 0) fishingPole = Sprite.fishingPole_left_sprite;
				else fishingPole = Sprite.fishingPole_right_sprite;
			}
		}
	}
	
	/**
	 * count how many times key is pressed.
	 * depending on the amount, player catches or loses his actual fish on the hook
	 */
	public void catchingModeUpdate(){
		
		//reset fishing immediately when player starts walking
		if(player.getPSM().isMoving() || player.getMSM().isUnderWater()){
			hardReset();
			return;
		}

		catchingTimer.update();
		
		if(player.getDirX() < 0){
			player.setSprite(AnimatedSprite.player_catch_left.getSprite());
			AnimatedSprite.player_catch_left.update();
		}else{
			player.setSprite(AnimatedSprite.player_catch_right.getSprite());
			AnimatedSprite.player_catch_right.update();
		}
		
		if(!catchingTimer.isActive()){
			if(neededTypes < typeCounter){
				Item fish = new Corjack();
				//TODO can catch more than one fish
				player.getWorld().getSurface().setDB(new Message(player, fish.getSprite(), fish.getName() + " gefangen", fish.getDescription(), true));
				player.getItemStore().addItem(Item.corjack_ID, 1);
			}else{
				player.getWorld().getSurface().setDB(new Message(player, Sprite.big_noAccess, "Zu langsam", "Dieser Fisch ist dir entkommen", true));
			}
			
			typeCounter = 0;
			AnimatedSprite.player_catch_right.reset();
			AnimatedSprite.player_catch_left.reset();
		}
	}
	
	/**
	 * render fishing pole,
	 * it is too big for a player
	 * @param screen
	 */
	public void render(Screen screen){
		if(isFishing() || isOnHook()){
			if(player.getDirX() < 0) screen.renderSprite(player.getX()-8, player.getY()-8, fishingPole, true);
			else screen.renderSprite(player.getX()+8, player.getY()-8, fishingPole, true);
		} 
		
		else if(isCatching()){
			if(player.getDirX() < 0){
				if(AnimatedSprite.player_catch_left.getFrame() == 0){
					screen.renderSprite(player.getX() - 8, player.getY() - 8, Sprite.fishingPole_left_sprite, true);
				}else{
					screen.renderSprite(player.getX() + 8, player.getY() - 8, Sprite.fishingCatch_left_sprite, true);
				}
			}else{
				if(AnimatedSprite.player_catch_right.getFrame() == 0){
					screen.renderSprite(player.getX() + 8, player.getY() - 8, Sprite.fishingPole_right_sprite, true);
				}else{
					screen.renderSprite(player.getX() - 8, player.getY() - 8, Sprite.fishingCatch_right_sprite, true);
				}
			}
		}
	}
	
	/**
	 * once player has a fish on hook, he won't be able to stop the process just
	 * by releasing J/K. Because those keys are relevant for catching a fish
	 */
	public void reset(){
		if(!isOnHook() && !isCatching()){
			if(fishingTimer != null)  fishingTimer.stop();
		}else if(isOnHook()){
			startCatching();
			onHookTimer.stop();
		}
	}
	
	/**
	 * only used when player starts moving while fishing
	 */
	public void hardReset(){
		if(fishingTimer != null)  fishingTimer.stop();
		if(onHookTimer != null)  onHookTimer.stop();
		if(catchingTimer != null)  catchingTimer.stop();
		typeCounter = 0;
	}
	
	/**
	 * typed key -> counter increased by 1
	 */
	public void increaseTypeCounter(){
		typeCounter++;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Starter methods for next action */
	private void startFishing(){
		fishingTimer = new Timer(random.nextInt(500)+200);
		fishingTimer.start();
	}
	private void onHook(){
		onHookTimer = new Timer(random.nextInt(120)+40);
		onHookTimer.start();
	}
	private void startCatching(){
		catchingTimer = new Timer(random.nextInt(250)+100);
		catchingTimer.start();
		neededTypes = random.nextInt(20)+15;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	private boolean isFishing(){
		return fishingTimer != null && fishingTimer.isActive();
	}
	
	public boolean isCatching(){
		return catchingTimer != null && catchingTimer.isActive();
	}
	
	public boolean isOnHook(){
		return onHookTimer != null && onHookTimer.isActive();
	}
}
