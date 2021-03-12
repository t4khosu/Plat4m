package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.extras.Money;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Sprite;

public class Chest extends InteractiveEntity{
	
	public enum ChestType{
		WOODEN, IRON, UNDERGROUND, GOLD;
	}
	
	private boolean open 			= false;
	private boolean openPermission 	= false;
	private int itemID;
	private int amount;
	private Player player;
	private Sprite openSprite;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param item
	 * @param amount
	 * @param openPermission
	 * @param level
	 * @param type
	 * @param player
	 */
	public Chest(int x, int y, int itemID, int amount, boolean openPermission, Level level, ChestType type){
		super(x, y);
		
		this.itemID 		= itemID;
		this.amount 		= amount;
		
		if(player != null){
			this.player 		= level.getPlayer();
		}
		
		this.openPermission = openPermission;
		
		switch(type){
			case WOODEN: 		sprite = Sprite.closed_chest1_sprite; 
						 		openSprite = Sprite.open_chest1_sprite;
						 		break;
			case IRON: 			sprite = Sprite.closed_chest2_sprite; 
								openSprite = Sprite.open_chest2_sprite;
								break;
			case UNDERGROUND: 	sprite = Sprite.closed_chest3_sprite; 
								openSprite = Sprite.open_chest3_sprite;
								break;
			case GOLD: 			sprite = Sprite.closed_chest4_sprite; 
								openSprite = Sprite.open_chest4_sprite;
								break;
			default: 			sprite = Sprite.closed_chest1_sprite; 
			 					openSprite = Sprite.open_chest1_sprite;
		}
	}
	
	/**
	 * open a chest, change sprite and give player what is inside
	 */
	public void open(){
		open 	= true;
		sprite 	= openSprite;
		
		if(itemID == Item.money_ID){
			player.addRul(amount);
		}else{
			player.getItemStore().addItem(itemID, amount);
		}
	}
	
	/**
	 * close chest again
	 */
	public void close(){
		open = false;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setPermission(boolean permission){
		openPermission = permission;
	}
	public void setOpen(boolean open){ //for saving options
		this.open = open;
		sprite 	= openSprite;
	}
	public Chest initChestAndReturn(Level level){
		this.player = level.getPlayer();
		return this;
	}
	
	public boolean isOpen(){
		return open;
	}
	public boolean getOpenPermission(){
		return openPermission;
	}
	public int getItemID(){
		return itemID;
	}
	public int getAmount(){
		return amount;
	}
}