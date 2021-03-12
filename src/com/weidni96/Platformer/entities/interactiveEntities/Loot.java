package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class Loot extends InteractiveEntity{
	
	private Level level;
	private double vFall 	= 0;
	private AnimatedSprite lootSprites;
	private int dirY = 0;
	
	private int itemID;
	private int amount;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param mob
	 * @param level
	 * @param item
	 * @param amount
	 */
	public Loot(int x, int y, Level level, int itemID, int amount){
		super(x, y,  Sprite.loot_sprite);
		this.level = level;
		
		this.itemID = itemID;
		this.amount = amount;
		
		lootSprites = new AnimatedSprite(8, SpriteSheet.loot_sheet, 2, 60, false);
	}
	
	/**
	 * loot can fall when enemy mob was in air
	 */
	public void fall(){
		for(int i = 0; i < Math.abs((int)vFall); i++){
			if(vFall > 0 && !bottomCollision()){
				dirY = 1;
				y++;
			}
		}
		vFall += level.gravity;	
	}
	
	/**
	 * check if there is a collision beneath
	 * @return result
	 */
	public boolean bottomCollision(){
		
		int bottom = y + height - 1;
		int right  = x + width - 1;
		
		int y0 = (bottom + 1) / 8; //tile beneath mob
		int x0 = x / 8;
		int x1 = right / 8;
		
		
		 //normal block collision
		if(TileGetterList.getTile(x0, y0, level).isSolid() || TileGetterList.getTile(x1, y0, level).isSolid()){
			dirY = 1;
			return true;
		}
		
		//Part collision left side
		if(TileGetterList.getTile(x0, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x0, y0, level).getSolidFrame();
			int tileCoord = x0 * 8;
			
			for(int i = 0; i < width; i++){
				if(x + i > tileCoord + s[0][0] && x + i < tileCoord + s[1][0]){
					if(bottom + 1 >= y0 * 8 + s[0][1]){
						dirY = 1;
						return true;
					}
				}
			}
		}
		
		//Part collision right side
		if(TileGetterList.getTile(x1, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x1, y0, level).getSolidFrame();
			int tileCoord = x1 * 8;
					
			for(int i = 0; i < width; i++){
				if((x + i > tileCoord + s[0][0] && x + i < tileCoord + s[1][0])){
					if(bottom + 1 >= y0 * 8 + s[0][1]){
						dirY = 1;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * update falling and sprite
	 */
	public void update(){
		fall();
		lootSprites.update();
		sprite = lootSprites.getSprite();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void getCollected(){
		remove();
	}
	public int getItemID(){
		return itemID;
	}
	public int getAmount(){
		return amount;
	}
}