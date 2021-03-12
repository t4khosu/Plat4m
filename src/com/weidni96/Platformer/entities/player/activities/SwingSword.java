/**
 * Activity of Player,
 * when player has a sword and uses it,
 * it needs to check for collisions and hit enemies
 */

package com.weidni96.Platformer.entities.player.activities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;

public class SwingSword extends Entity{
	
	private Player player;
	private Item sword;
	private boolean swingingSword;
	
	/**
	 * constructor
	 * @param player
	 */
	public SwingSword(Player player){
		this.player = player;
		swingingSword = false;
	}
	
	/**
	 * animate sword when used and check for hit
	 */
	public void update(){
		swingingSword = true;
		
		AnimatedSprite.player_hit_right.update();
		AnimatedSprite.player_hit_left.update();
		
		AnimatedSprite.wooden_sword1_left.update();
		AnimatedSprite.wooden_sword1_right.update();
		
		if(AnimatedSprite.wooden_sword1_left.getAtTheEnd() && swingingSword){
			swingingSword = false;
			AnimatedSprite.player_hit_right.reset();
			AnimatedSprite.player_hit_left.reset();
			
			AnimatedSprite.wooden_sword1_left.reset();
			AnimatedSprite.wooden_sword1_right.reset();
			
			sprite = null;
		}
		hit();
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
			
		if(swingingSword){
			if(player.getDirX() == -1){
				sprite = AnimatedSprite.wooden_sword1_left.getSprite();
			}else{
				sprite = AnimatedSprite.wooden_sword1_right.getSprite();
			}
		}
		
		if(sprite != null){
			if(player.getDirX() == 1){
				if(AnimatedSprite.wooden_sword1_right.getFrame() == 0){
					screen.renderSprite(player.getX()+3, player.getY()-sprite.getHeight(), sprite, true);
				}else if(AnimatedSprite.player_hit_right.getFrame() == 1){
					screen.renderSprite(player.getX()+8-2, player.getY()-sprite.getHeight()+2, sprite, true);
				}else{
					screen.renderSprite(player.getX()+8, player.getY()-sprite.getHeight()+5, sprite, true);
				}
			}else{
				if(AnimatedSprite.wooden_sword1_left.getFrame() == 0){
					screen.renderSprite(player.getX()-sprite.getWidth() + 5, player.getY()-sprite.getHeight(), sprite, true);
				}else if(AnimatedSprite.player_hit_right.getFrame() == 1){
					screen.renderSprite(player.getX()-sprite.getWidth()+2, player.getY()-sprite.getHeight()+2, sprite, true);
				}else{
					screen.renderSprite(player.getX()-sprite.getWidth(), player.getY()-sprite.getHeight()+5, sprite, true);
				}
			}
		}
		
		/*
		 * 
		 * COLOR SHOWS WHICH AREA HITS MOBS
		 * 
		 */
		
		/*if(player.getDirX() == 1){
			if(AnimatedSprite.wooden_sword1_right.getFrame() == 0){
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX()+4, player.getY()-(4*i), 0xffff0000, true);
					screen.renderPixel(player.getX()+6, player.getY()-(3*i), 0xffff0000, true);
				}
			}else if(AnimatedSprite.wooden_sword1_right.getFrame() == 1){
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX()+7+(2*i), player.getY()-(2*i)-2, 0xffff0000, true);
					screen.renderPixel(player.getX()+7+(2*i)+1, player.getY()-(2*i)+3, 0xffff0000, true);
					screen.renderPixel(player.getX()+7+(2*i)+2, player.getY()-(2*i)-1, 0xffff0000, true);
				}
			}else{
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX()+8+(4*i), player.getY()+3, 0xffff0000, true);
					screen.renderPixel(player.getX()+8+(4*i), player.getY()+1, 0xffff0000, true);
				}
			}
			
			
		}else if(player.getDirX() == -1){
			if(AnimatedSprite.wooden_sword1_left.getFrame() == 0){
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX() + 3, player.getY()-(4*i), 0xffff0000, true);
					screen.renderPixel(player.getX() + 1, player.getY()-(3*i), 0xffff0000, true);
				}
			}else if(AnimatedSprite.wooden_sword1_left.getFrame() == 1){
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX()-(2*i), player.getY()-(2*i)-2, 0xffff0000, true);
					screen.renderPixel(player.getX()-(2*i)-1, player.getY()-(2*i)+3, 0xffff0000, true);
					screen.renderPixel(player.getX()-(2*i)-2, player.getY()-(2*i) -1, 0xffff0000, true);
				}
			}else{
				for(int i = 0; i < 5; i++){
					screen.renderPixel(player.getX()-(4*i), player.getY()+3, 0xffff0000, true);
					screen.renderPixel(player.getX()-(4*i), player.getY()+1, 0xffff0000, true);
				}
			}
		}*/
		
		/************************************************************************************************/
	}
	
	/**
	 * check for collisions at certain pixels.
	 * remodels the natural collision boxes of a swinging sword
	 */
	private void hit(){
		//RIGHT
		if(player.getDirX() == 1){
			
			if(AnimatedSprite.wooden_sword1_right.getFrame() == 0){
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()+4, player.getY()-(4*i));
					lookForCollisions(player.getX()+6, player.getY()-(3*i));
				}
			}else if(AnimatedSprite.wooden_sword1_right.getFrame() == 1){
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()+7+(2*i), 	player.getY()-(2*i)-2);
					lookForCollisions(player.getX()+7+(2*i)+1,	player.getY()-(2*i)+3);
					lookForCollisions(player.getX()+7+(2*i)+2, 	player.getY()-(2*i)-1);
					
				} 
			}else if(AnimatedSprite.wooden_sword1_right.getFrame() == 2){
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()+8+(4*i), player.getY()+3);
					lookForCollisions(player.getX()+8+(4*i), player.getY()+1);
				}
			}
			
		//LEFT
		}else if(player.getDirX() == -1){
			
			if(AnimatedSprite.wooden_sword1_left.getFrame() == 0){
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()+3, player.getY()-(4*i));
					lookForCollisions(player.getX()+1, player.getY()-(3*i));
				}
			}else if(AnimatedSprite.wooden_sword1_left.getFrame() == 1){
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()-(2*i), player.getY()-(2*i)-2);
					lookForCollisions(player.getX()-(2*i)-1, player.getY()-(2*i)+3);
					lookForCollisions(player.getX()-(2*i)-2, player.getY()-(2*i)-1);
				}
			}else{
				for(int i = 0; i < 5; i++){
					lookForCollisions(player.getX()-(4*i), player.getY()+3);	
					lookForCollisions(player.getX()-(4*i), player.getY()+1);
				}
			}
			
		}
	}
	
	/**
	 * check for stuff that interacts with sword at x/y
	 * @param x
	 * @param y
	 */
	private void lookForCollisions(int x, int y){
		for(Mob mob : level.mobs){
			if(mob.collision(x, y)){
				mob.getsHitBy(player, sword);
			}
		}
		if(TileGetterList.getTile(x/8, y/8, level).isDestroyable()){
			destroyGrass(x, y, TileGetterList.getTile(x/8,  y/8, level));
		}
	}
	
	/**
	 * destroy grass, change tile to destroyed grass
	 * @param x
	 * @param y
	 * @param tile
	 */
	private void destroyGrass(int x, int y, Tile tile){
		if(tile == Tile.destroyableGrass01Tile){
			level.setTile(x/8, y/8, 0xff00B561);
		}
		else if(tile == Tile.destroyableGrass11Tile){
			level.setTile(x/8, y/8, 0xff51DB99);
		}
		else if(tile == Tile.destroyableGrass21Tile){
			level.setTile(x/8, y/8, 0xffD30236);
		}
		else if(tile == Tile.destroyableGrass31Tile){
			level.setTile(x/8, y/8, 0xffD302C9);
		}
	}
	
	/**
	 * initialize swinging action
	 * @param level
	 * @param sword
	 */
	public void init(Level level, Item sword){
		this.level = level;
		this.sword = sword;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean getSwingingSword(){
		return swingingSword;
	}
}
