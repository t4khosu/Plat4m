package com.t4khosu.Platformer.Surface;

import com.t4khosu.Platformer.entities.interactiveEntities.Anvil;
import com.t4khosu.Platformer.entities.interactiveEntities.Fire;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.input.Keyboard;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.ItemStore;
import com.t4khosu.Platformer.entities.NPC.Trader;
import com.t4khosu.Platformer.entities.dialog.Dialogbox;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.IronBar;
import com.t4khosu.Platformer.entities.item.mainItems.potions.Potion;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Boots;
import com.t4khosu.Platformer.entities.player.Player;

/**
 * create whole inventory with three sub menus
 * @author Christian
 *
 */
public class Inventory extends Entity{
	
	private ItemStore activeStore;
	private ItemStore headItemStore;
	
	private boolean open 	= false;
	private Trader trader 	= null;
	private Fire fire		= null;
	private Anvil anvil		= null;
	
	private Keyboard key;
	private Player player;
	private Surface surface;
	private Dialogbox db;
	private boolean[] menu;
	
	/**
	 * Constructor
	 * @param player
	 * @param surface
	 */
	public Inventory(Player player, Surface surface){
		this.player  = player;
		this.key 	 = player.getInput();
		this.surface = surface;
		
		int headMenuWidth = 3;
		
		//defaultStore = SubMenuList
		headItemStore = new ItemStore(headMenuWidth, 1, player.getItemStore(), 1);
		headItemStore.initInventory(this);
		
		//default value is first headMenu
		menu = new boolean[headMenuWidth];
		menu[0] = true;
		
		player.getItemStore().activate();
		this.activeStore = player.getItemStore();
	}
	
	/**
	 * Update position in inventory that is moved to and set hand slots if item shall be used
	 */
	public void update(){
		//check weather active store is initialized
		
		//*********************************************
		//ckeck for items in hand that activate once, like shoes (no permanent updates)
		for(Item i : player.getJK()){
			if(i instanceof Boots){
				player.setMaxJumpCount(2);
				break;
			}else{
				player.setMaxJumpCount(1);
			}
		}
		
		
		if(activeStore.getInventory() == null){
			activeStore.initInventory(this);
		}
		
		db = activeStore.getDb();
		activeStore.update();
		
		// delete DialogBox when pressing a key, otherwise a new one can't appear
		if(key.typedUp || key.typedDown || key.typedLeft || key.typedRight || key.typedJ || key.typedK){
			activeStore.resetDb();
		}
		
		//set subStore depending which headMenuPoint the player selects
		if(activeStore == headItemStore){
			player.getItemStore().setActiveStore(headItemStore.getHoverX());
		}
		
		//check for key presses
		if(key.typedUp){
			if(activeStore.getHoverY() - 1  >= 0){
				activeStore.moveHoverY(-1);
			}else if(activeStore == player.getItemStore()){
				player.getItemStore().deactivate();
				headItemStore.activate();
				
				headItemStore.setHoverX(player.getItemStore().getActiveStore());
				headItemStore.setHoverY(0);
				
				activeStore = headItemStore;
			}
		}else if(key.typedDown){
			if(activeStore.getHoverY() + 1 < activeStore.getHeight()){
				activeStore.moveHoverY(1);
			}else if(activeStore == headItemStore){
				headItemStore.deactivate();
				player.getItemStore().activate();
				
				player.getItemStore().setHoverX(0);
				player.getItemStore().setHoverY(0);
				activeStore = player.getItemStore();
			}
		}else if(key.typedLeft){
			if(activeStore.getHoverX() - 1  >= 0){
				activeStore.moveHoverX(-1);
			}else{
				if(trader != null && activeStore != headItemStore && activeStore == player.getItemStore() &&
						player.getItemStore().getHoverX() == 0){
					
					trader.getItemStore().activate();
					player.getItemStore().deactivate();
					activeStore = trader.getItemStore();
					
					trader.getItemStore().setHoverX(trader.getItemStore().getWidth()-1);
					/*
					 * Calculate where to jump. (example)
					 * 
					 *  2	  x
					 * --- = --- -> 4 (trader hight) * 2 (actual row) / 5 (inventar height)
					 *  5	  4
					 */
					trader.getItemStore().setHoverY((trader.getItemStore().getHeight() * player.getItemStore().getHoverY()) / player.getItemStore().getHeight());
				}else if(fire != null && activeStore != headItemStore && activeStore == player.getItemStore() &&
						player.getItemStore().getHoverX() == 0){
					int hy = 0;
					if(activeStore.getHoverY() == 2 || activeStore.getHoverY() == 3) hy = 1;
					else if(activeStore.getHoverY() == 4) hy = 2;
					fire.getItemStore().activate();
					player.getItemStore().deactivate();
					activeStore = fire.getItemStore();
					activeStore.setHoverY(hy);
				}
			}
		}else if(key.typedRight){
			if(activeStore.getHoverX() + 1 < activeStore.getWidth()){
				activeStore.moveHoverX(1);
			}else if(trader != null && activeStore == trader.getItemStore() && 
					trader.getItemStore().getHoverX() == trader.getItemStore().getWidth()-1){
				trader.getItemStore().deactivate();
				player.getItemStore().activate();
				/*
				 * Calculate where to jump. (example)
				 * 
				 *  x	  2
				 * --- = --- -> 5 (inventory hight) * 2 (actual row) / 4 (trader height)
				 *  5	  4
				 */
				player.getItemStore().setHoverX(0);
				player.getItemStore().setHoverY((player.getItemStore().getHeight() * trader.getItemStore().getHoverY()) / trader.getItemStore().getHeight());
				activeStore = player.getItemStore();
			}else if(fire != null && activeStore == fire.getItemStore()){
				int hy = 1;
				if(activeStore.getHoverY() == 1) hy = 2;
				else if(activeStore.getHoverY() == 2) hy = 4;
				fire.getItemStore().deactivate();
				player.getItemStore().activate();
				activeStore = player.getItemStore();
				player.getItemStore().setHoverY(hy);
			}
		}
		
		if(key.typedJ || key.typedK){
			int keyC = 0;
			if(key.typedK) keyC = 1;
			
			if(player.getItemStore().isActive()){
				Item tmp = activeStore.getSelectedItem();
				//don't put potions on j or k
				if(tmp instanceof Potion) return;
				
				//same Store
				if(activeStore.getItemQuantity(player.getJK()[keyC]) == activeStore.getActiveStore()){
					activeStore.setSelectedItem(player.getJK()[keyC]);
				}else{
					//different Store
					activeStore.addItem(player.getJK()[keyC].getID(), 0);
					activeStore.setSelectedItem(null);
				}
				player.setJK(keyC, tmp);
			}
		}
		
		//numberInventory for potions, player can press 1 - 6
		if(key.numbersTyped[0]) numberInventory(0);
		if(key.numbersTyped[1]) numberInventory(1);
		if(key.numbersTyped[2]) numberInventory(2);
		if(key.numbersTyped[3]) numberInventory(3);
		if(key.numbersTyped[4]) numberInventory(4);
		if(key.numbersTyped[5]) numberInventory(5);
			
		//press space
		if(key.typedInteract){
			if(trader != null && trader.getItemStore().isActive()){
				Item i = trader.getItemStore().getSelectedItem();
				if(i != null && i.getValue() <= player.getRul()){
					player.useRul(i.getValue());
					int a = player.addItem(i.getID());
					player.addLogEntry(i.getName() + " gekauft. Im Inventar: " + a, 0xffDDDDDD);
				}else if(i != null && i.getValue() > player.getRul()){
					player.addLogEntry("Zu wenig Geld!", 0xffff0000);

				}
			}else if(trader != null && player.getItemStore().isActive()){
				Item i = player.getItemStore().getSelectedItem();
				if(i != null && i.getAmount() >= 1){
					if(!trader.buysItems()){
						player.addLogEntry("Sorry, ich kaufe derzeit nichts...", 0xffff0000);
					}else if(i.getValue() == 0){
						player.addLogEntry("Item hat keinen Nutzen...!", 0xffff0000);
					}else{
						player.addRul(i.getValue()/2);
						i.useItem(1);
						player.addLogEntry("1 " + i.getName() + " verkauft.", 0xffDDDDDD);
						activeStore.createDb();
					}
				}
				
				
			}else if(fire != null && fire.getItemStore().isActive()){ //in fire item store
				
				int hY = fire.getItemStore().getHoverY();
				Item i = fire.getItemStore().getItems()[0][hY];
				if(i != null && i.getAmount() > 0){
					fire.getItemStore().getItems()[0][hY].useItem(1);
					
					//I have absolutely no idea why to differentiate here...
					if(i instanceof IronBar){
						player.addItem(Item.ironBar_ID);
					}else{
						player.addItem(i.getID());
					}
					
					if(fire.getItemStore().getItems()[0][hY].getAmount() == 0){
						fire.getItemStore().getItems()[0][hY] = null;
					}
						
					activeStore.createDb();
				}
			}else if(fire != null & player.getItemStore().isActive()){
				Item i = player.getItemStore().getSelectedItem();
				fire.getItemStore().addItemToFire(i, fire);
				activeStore.createDb();
			}
		}
	}

	/**
	 * if open, make the background darker and open player inventory
	 * if trader is active, do special rendering
	 */
	public void render(Screen screen){
		if(open){
			screen.darkerScreen();
			if(trader != null){
				trader.getItemStore().render(screen);
			}
			if(fire != null){
				fire.getItemStore().render(screen);
			}
			player.getItemStore().render(screen);
			headItemStore.render(screen);
		}
	}
	
		/**
		 * 1. Simple way to open without trader
		 */
		public void open(){
			open = true;
			player.getItemStore().allignCenter();
		}
		
		/**
		 * 2. Open Inventor with a trader
		 */
		public void openWithTraderItemStore(Trader npc){
			open = true;
			this.trader = npc;
			
			//reset positions
			trader.getItemStore().allignCenter();
			player.getItemStore().allignCenter();
			
			//set new positions
			trader.getItemStore().moveX(-trader.getItemStore().getPixelWidth());
			trader.getItemStore().moveX(-20);
			player.getItemStore().moveX(20);
		}
		
		/**
		 * 3. Open Inventor with fire
		 */
		public void openWithFire(Fire fire){
			open = true;
			this.fire = fire;
			//reset positions
			fire.getItemStore().allignCenter();
			player.getItemStore().allignCenter();
			
			//set new positions
			fire.getItemStore().moveX(-fire.getItemStore().getPixelWidth()-20);
			player.getItemStore().moveX(20);
		}
		
		/**
		 * 4. Open Inventory with anvil
		 */
		public void openWithAnvil(Anvil anvil){
			open = true;
			this.anvil = anvil;
			
			
			player.getItemStore().allignCenter();
			player.getItemStore().moveX(20);
		}

	/**
	 * Close Inventory and reset everything 
	 */
	public void close(){
		if(trader != null) trader.getItemStore().deactivate();
		headItemStore.deactivate();
		if(fire != null) fire.getItemStore().deactivate();
		player.getItemStore().activate();
		
		player.getItemStore().setHoverX(0);
		player.getItemStore().setHoverY(0);
		activeStore = player.getItemStore();
		
		open 	= false;
		trader 	= null;
		fire 	= null;
		db 		= null;
		surface.removeDB();
	}
	
	/**
	 * do stuff when pressing a number between 1 and 6
	 * @param number
	 */
	public void numberInventory(int number){
		if(player.getItemStore().isActive()){
			Item tmp = activeStore.getSelectedItem();
			if(!(tmp instanceof Potion) && tmp != null) return;
			//same Store
			if(activeStore.getItemQuantity(player.getSmallSlots()[number]) == activeStore.getActiveStore()){
				activeStore.setSelectedItem(player.getSmallSlots()[number]);
			}else{
				//different Store
				activeStore.addItem(player.getSmallSlots()[number].getID(), 0);
				activeStore.setSelectedItem(null);
			}
			
			player.setSmallSlots(number, tmp);
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Keyboard getKey(){
		return key;
	}
	public Player getPlayer(){
		return player;
	}
	public Surface getSurface(){
		return surface;
	}
	public Dialogbox getDb(){
		return db;
	}
	public boolean isOpen(){
		return open;
	}
	public Trader getTrader(){
		return trader;
	}
}