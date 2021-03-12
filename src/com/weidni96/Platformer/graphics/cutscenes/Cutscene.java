/**
 * create a cutscene for special kinds of stuff to happen, like huge animations#
 * or camera movement
 */

package com.weidni96.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.Camera;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public abstract class Cutscene extends Entity{
	
	protected int timer = 0;
	protected int action = 0;
	protected int removeText;
	protected int removeScreen;
	
	protected World world;
	protected Camera camera;
	protected Player player;
	protected Level level;
	
	//remove text:
	// 0 -> only render cutscene text with own render function
	// 1 -> only render screen text without any extras
	// 2 -> render both
	
	//remove screen:
	// 0 -> only render cutscene with own render function
	// 1 -> only render screen without any extras
	// 2 -> render both

	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
	public Cutscene(World world, int removeText, int removeScreen){
		this.world = world;
		
		this.camera = world.getCamera();
		this.player = world.getPlayer();
		this.level = world.getActualArea().getActualLevel();
		
		this.removeText = removeText;
		this.removeScreen = removeScreen;
	}
	
	/**
	 * switch(action) case ... = standard construction
	 * timer after every case must be reset
	 */
	public abstract void update();
	
	/**
	 * switch(action) case ... 
	 * @param g
	 */
	public abstract void render(Graphics g);
	
	/**
	 * switch(action) case ... 
	 * @param screen
	 */
	public abstract void render(Screen screen);
		
	/**
	 * Remove itself
	 */
	public void remove(){
		world.setCutscene(null);
	}
	
	protected void changePlayerLookingDirection(){
		if(player.getDirX() < 0){
			player.setDirX(1);
			player.setSprite(Sprite.player_right);
		}else{
			player.setDirX(-1);
			player.setSprite(Sprite.player_left);
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get - and set methods */
	public int getRemoveText(){
		return removeText;
	}
	public int getRemoveScreen(){
		return removeScreen;
	}
}
