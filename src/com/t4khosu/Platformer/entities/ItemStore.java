/**
 * print the itemstore when player is in menu or trading.
 * manage moving around itemstore and display items with texts
 */

package com.t4khosu.Platformer.entities;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Surface.Inventory;
import com.t4khosu.Platformer.entities.interactiveEntities.Fire;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.dialog.Dialogbox;
import com.t4khosu.Platformer.entities.dialog.ItemBox;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.Item.ItemType;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.Coal;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.RawIron;
import com.t4khosu.Platformer.entities.item.mainItems.potions.Potion;

public class ItemStore extends Entity{
	
	public enum StoreType{
		OWNSTORE, TRADESTORE, FIRE;
	}
	
	private Inventory inventory;
	
	private Sprite slotSprite;
	private Sprite hoverSprite;
	private Sprite[] slotSprites;
	
	//storetype to seperate player and other stores
	private StoreType storeType;
	
	//dialogbox if there is an item on hoverX/hoverY
	private Dialogbox db;
	private boolean active = false;
	
	//position in store that is selected
	private int hoverX = 0;
	private int hoverY = 0;
	
	//SPACE for render issues
	private final int SPACE = 2;
	
	private int activeStore = 0;
	
	//all item slots that must be managed, i.e. player has tools, seeds, potions,...
	private Item[][] items;
	
	/**
	 * constructor
	 * @param width
	 * @param height
	 * @param storeType
	 * @param amount
	 */
	public ItemStore(int width, int height, StoreType storeType, int amount){
		this.width 		= width;
		this.height 	= height;
		this.storeType 	= storeType;
		
		//amount: stores with this width and height
		items = new Item[amount][width*height];
		
		//set sprites for slots
		switch(storeType){
			case OWNSTORE: 		slotSprite = Sprite.big_ownStoreBackground;
								hoverSprite = Sprite.big_activeStoreBackground;
								break;
			case TRADESTORE: 	slotSprite = Sprite.big_tradeStoreBackground;
								hoverSprite = Sprite.big_activeStoreBackground;
								break;
			case FIRE:			slotSprite = Sprite.big_ownFireBackground;
								hoverSprite = Sprite.big_activeStoreBackground;
								break;
			default:			slotSprite = Sprite.big_ownStoreBackground;
								hoverSprite = Sprite.big_activeStoreBackground;
								break;
		}
		
		//always set position to center
		allignCenter();
	}
	
	/**
	 * constructor for ItemStore that only exists with another store
	 * -> store for traders
	 * @param width
	 * @param height
	 * @param referenceStore
	 * @param amount
	 */
	public ItemStore(int width, int height, ItemStore referenceStore, int amount){
		this.width 		= width;
		this.height 	= height;
		this.storeType 	= referenceStore.storeType;
		
		this.items 		= new Item[amount][width * height];
		this.active 	= false;
		
		slotSprite = Sprite.long_menuBackground_1;
		
		slotSprites 	= new Sprite[3];
		slotSprites[0] 	= Sprite.long_menuBackground_1;
		slotSprites[1] 	= Sprite.long_menuBackground_2;
		slotSprites[2] 	= Sprite.long_menuBackground_3;
		
		hoverSprite = Sprite.long_activeStoreBackground;
		
		x = referenceStore.getX() + ((referenceStore.getPixelWidth()- getPixelWidth()) / 2);
		y = referenceStore.getY() - slotSprite.getHeight() - SPACE * 2;
	}
	
	/**
	 * move Store to the middle of the screen
	 */
	public void allignCenter(){
		int gameWidth 	= Game.width;
		int gameHeight 	= Game.height;
		
		int pxStoreWidth 	= width * slotSprite.getWidth() + (width - 1) * SPACE;
		int pxStoreHeight 	= height * slotSprite.getHeight() + (height - 1) * SPACE;
		
		this.x = gameWidth/2  - pxStoreWidth/2;
		this.y = gameHeight/2 - pxStoreHeight/2;
	}
	
	/**
	 * get amount of an item inside the active store
	 * @param item_ID
	 * @return amount, if not in inventory, return -1
	 */
	public int getAmountOfItem(int item_ID){
		for(int j = 0; j < items.length; j++){
			if(items[activeStore][j] != null && items[activeStore][j].getID() == item_ID){
				return items[activeStore][j].getAmount();
			}
		}
		//not in itemstore, return -1
		return -1;
	}

	/**
	 * add a new item with specific amount to an itemStore.
	 * which items are stored at which place is described at the getItemQuantity method
	 * @param newItem
	 * @param amount
	 */
	public int addItem(int itemID, int amount){
		int chooseStore = 0;
		Item i = Item.getItem(itemID);
		
		//decide in which itemStore the new item must be saved
		if(items.length > 1){
			//check in which substore when it is own store
			if(storeType == StoreType.OWNSTORE) chooseStore = getItemQuantity(i);
		}
		
		//already in inventory, so just add new amount
		for(int j = 0; j < items[chooseStore].length; j++){
			if(items[chooseStore][j] != null && items[chooseStore][j].getID() == itemID){
				if(!items[chooseStore][j].isStackable()) return -1;
				items[chooseStore][j].add(amount);
				return items[chooseStore][j].getAmount();
			}
		}
		
		//not in inventory, so add new item
		for(int j = 0; j < items[activeStore].length; j++){
			//search for empty place
			if(items[chooseStore][j] == null){
				items[chooseStore][j] = i;
				items[chooseStore][j].add(amount);
				return items[chooseStore][j].getAmount();
			}
		}
		
		//did not work
		return -1;
	}
	
	public int addItemToFire(Item newItem, Fire fire){
		if(newItem.getAmount() > 0){
			if(newItem instanceof Coal){
				//add Coal-Object to fire if it is null
				if(fire.getItemStore().getItems()[0][2] == null){
					fire.getItemStore().getItems()[0][2] = new Coal();
				}
				
				//add amount
				fire.getItemStore().getItems()[0][2].add(1);
				
				//player uses Item
				newItem.useItem(1);
				
			}else if(newItem instanceof RawIron){
				if(items[0][1] == null) items[0][1] = new RawIron();
				items[0][1].add(1);
				newItem.useItem(1);
			}
		}
		
		//did not work
		return -1;
	}
	
	/**
	 * if player is hovering an item in his or a trader's store,
	 * an dialog box is created to show stats / price
	 */
	public void createDb(){
		Item i = null;
		if((i = items[activeStore][hoverX + hoverY * width]) != null){
			
			String extra = "";
			
			switch(storeType){
				case OWNSTORE: 		if(i.isStackable()) extra = " ("+i.getAmount()+")";
									if(inventory.getTrader() != null){
										extra += " - " + (i.getValue()/2) + "Rul";
									}
									break;
				case TRADESTORE: 	extra = " - " + i.getValue() + "Rul";
									break;
				case FIRE:			extra = " ("+i.getAmount()+")";
			}
			db = new ItemBox(inventory.getKey(), i, extra);
		}else{
			db = null;
		}
	}
	
	/**
	 * delete DB
	 */
	public void resetDb(){
		db = null;
	}
	
	/**
	 * set an item on a specific position null
	 * @param x
	 * @param y
	 */
	public void deleteItem(int x, int y){
		items[activeStore][x + y * width] = null;
	}
	
	/**
	 * specify in which menu category item must be saved
	 * @param newItem
	 * @return
	 */
	public int getItemQuantity(Item newItem){
		if(newItem == null) return activeStore;
		
		//tools in 0
		if(newItem.getType() == ItemType.TOOLS ||
			newItem.getType() == ItemType.POLE  ||
			newItem.getType() == ItemType.PICKAXE ||
			newItem.getType() == ItemType.SWORD ||
			newItem.getType() == ItemType.SHOVEL ||
			newItem.getType() == ItemType.RAWMATERIAL){
			return 0;
		}
		
		//food and seed in 1
		else if(newItem.getType() == ItemType.FOOD ||
				newItem.getType() == ItemType.SEEDS){
				return 1;
		}
		
		//other stuff in 2
		else return 2;
	}
	
	/**
	 * activate store
	 */
	public void activate(){
		active = true;
	}
	
	/**
	 * deactivate store
	 */
	public void deactivate(){
		active = false;
	}
	
	/**
	 * try to create a DB every time 
	 * since player can hover an item at any time
	 */
	public void update(){
		if(db == null){
			createDb();
		}
	}
	
	/**
	 * render a whole itemStore at position x/y (top left corner)
	 */
	public void render(Screen screen){
		for(int y0 = 0; y0 < height; y0++){
			int ya = y + y0 * slotSprite.getHeight() + SPACE * y0;
			if(storeType == StoreType.FIRE){
				if(y0 == 1) ya += 11;
				else if(y0 == 2) ya += 19;
			}
			
			for(int x0 = 0; x0 < width; x0++){
				int xa = x + x0 * slotSprite.getWidth() + SPACE * x0;
				
				//render slots for itemStore
				if(slotSprites != null){
					screen.renderSprite(xa, ya, slotSprites[x0 + y0 * width], false);
				}else{
					screen.renderSprite(xa, ya, slotSprite, false);
				}
				
				//render all items that are in an item slot
				Item i;
				if((i = items[activeStore][x0 + y0 * width]) != null){
					if(i instanceof Potion){
						items[activeStore][x0 + y0 * width].render(screen, xa + 4, ya + 4);
					}else{
						items[activeStore][x0 + y0 * width].render(screen, xa, ya);
					}
					
				}
				
				//if hovering actual position, also render a frame around slot
				if(active && hoverX == x0 && hoverY == y0){
					screen.renderSprite(xa, ya, hoverSprite, false);
				}
				xa += slotSprite.getWidth() + SPACE;
			}
		}
		
		if(storeType == StoreType.FIRE){
			screen.renderSprite(x-2, y + slotSprite.getHeight() + SPACE - 1, Sprite.firePlaceManager, false);
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getActiveStore(){
		return activeStore;
	}
	public Dialogbox getDb(){
		return db;
	}
	public int getHoverX(){
		return hoverX;
	}
	public int getHoverY(){
		return hoverY;
	}
	public int getPixelWidth(){
		return slotSprite.getWidth() * width + (width-1) * SPACE; /* get pixel width of whole store */
	}
	public Item getSelectedItem(){
		return items[activeStore][hoverX + hoverY * width];
	}
	public Inventory getInventory(){
		return inventory;
	}
	public boolean isActive(){
		return active;
	}
	public Item[][] getItems(){
		return items;
	}
	
	public void initItems(Item[][] items){
		this.items = items;
	}
	
	public void initInventory(Inventory inventory){
		this.inventory = inventory;
	}
	public void setActiveStore(int activeStore){
		this.activeStore = activeStore;
	}
	public void setSelectedItem(Item i){
		items[activeStore][hoverX + hoverY * width] = i; /* change/set item on current position */
	}
	public void setHoverX(int hoverX){
		this.hoverX = hoverX;
	}
	public void setHoverY(int hoverY){
		this.hoverY = hoverY;
	}
	public void moveX(int moveX){
		x += moveX;
	}
	public void moveY(int moveY){
		y += moveY;
	}
	public void moveHoverX(int moveHoverX){
		hoverX += moveHoverX;
	}
	public void moveHoverY(int moveHoverY){
		hoverY += moveHoverY;
	}
}
