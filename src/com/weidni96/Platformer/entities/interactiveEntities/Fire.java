package com.weidni96.Platformer.entities.interactiveEntities;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.ItemStore;
import com.weidni96.Platformer.entities.ItemStore.StoreType;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.groundTreasures.IronBar;
import com.weidni96.Platformer.entities.item.mainItems.groundTreasures.RawIron;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Fire extends InteractiveEntity{

	public static Fire blacksmithFire = new Fire(41*8,22*8);
	

	private Item rawMaterial = null;
	private Item finishedMaterial = null;
	private ItemStore itemStore = null;
	
	private Timer coalTimer;
	private Timer meltTimer;
	
	private int pos = 0;
	
	private boolean active = false;
	private Player player;
	private World world;
	
	public Fire(int x, int y) {
		super(x, y, AnimatedSprite.a_blacksmithFire.getSprite());
		
		int storeWidth 	= 1;
		int storeHeight = 3;
		this.itemStore = new ItemStore(storeWidth, storeHeight, StoreType.FIRE, 1);
		
		//set time for coal to burn
		this.coalTimer = new Timer(60 * 30);
	}
	
	public void update(){
		this.sprite = AnimatedSprite.a_blacksmithFire.getSprite();
		
		//check for coal
		if(itemStore.getItems()[0][2] != null || coalTimer.isActive()){
			if(!coalTimer.isActive()){
				startBurningCoal();
			}
			coalTimer.update();
			
			//no more coal
			if(!coalTimer.isActive() && itemStore.getItems()[0][2] == null){
				if(meltTimer != null) meltTimer.stop();
			}
			
			//check for coal timer
			if(coalTimer.isActive()){
				if(meltTimer == null || !meltTimer.isActive()){
					if((rawMaterial = itemStore.getItems()[0][1]) != null){
						
						//start melting iron
						if(rawMaterial instanceof RawIron){
							meltTimer = new Timer(54*60);
							meltTimer.start();
						}
					}
				}
				if(meltTimer != null && meltTimer.isActive()){
					meltTimer.update();
					
					if(!meltTimer.isActive()){ //finished melting
						finishMeltingMaterial();
					}
					
					//took all raw material out while burning, so stop melting
					if(itemStore.getItems()[0][1] == null) meltTimer = null;
				}
			}
		}
	}
	
	private void finishMeltingMaterial(){
		rawMaterial.useItem(1);

		//add new refined product
		if(rawMaterial instanceof RawIron){
			if(itemStore.getItems()[0][0] == null){
				itemStore.getItems()[0][0] = new IronBar();
			}
			itemStore.getItems()[0][0].add(1);
		}
		
		
		if(rawMaterial.getAmount() == 0){
			itemStore.getItems()[0][1] = null;
		}
	}
	
	private void startBurningCoal(){
		coalTimer.start();
		itemStore.getItems()[0][2].useItem(1);
		if(itemStore.getItems()[0][2].getAmount() == 0){
			itemStore.getItems()[0][2] = null;
		}
	}

	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
		screen.renderSprite(x-8, y, Sprite.fire_left_sprite, true);
		screen.renderSprite(x+8, y, Sprite.fire_right_sprite, true);
		
		if(coalTimer.isActive()){
			screen.renderBar(x, y-3, coalTimer.getTime(), coalTimer.getMaxTime(), 8, 0xff0000, true);
			if(meltTimer != null && meltTimer.isActive()){
				screen.renderBar(x, y-1, meltTimer.getTime(), meltTimer.getMaxTime(), 8, 0xD86420, true);
			}
			
			if(world.getSurface().getInventory().isOpen()){
				screen.renderBar(itemStore.getX(), itemStore.getY()-4, coalTimer.getTime(), coalTimer.getMaxTime(), 16, 0xff0000, false);
				if(meltTimer != null && meltTimer.isActive()){
					screen.renderBar(itemStore.getX(), itemStore.getY()-2, meltTimer.getTime(), meltTimer.getMaxTime(), 16, 0xD86420, false);
				}
			}
		}
	}
	
	public void renderProcess(Screen screen) {
	}

	public Item getFinishedMaterial(){
		return finishedMaterial;
	}
	
	public Item getRawMaterial(){
		return rawMaterial;
	}
	public ItemStore getItemStore(){
		return itemStore;
	}

	public void finishedMaterial(Item finishedMaterial){
		this.finishedMaterial = finishedMaterial;
	}
	
	public void activate(){
		this.active = true;
	}
	public void deactivate(){
		this.active = false;
	}

	public boolean isActive() {
		return active;
	}

	public Fire initFireAndReturn(Level level){
		this.player = level.getPlayer();
		this.world = level.getArea().getWorld();
		return this;
	}
	
	/**
	 * use actual coal and all materials inside fire right now
	 * @return save data as string
	 */
	public String getSaveData(){
		int coalAmount = itemStore.getItems()[0][2] != null ? itemStore.getItems()[0][2].getAmount() : 0;
		int rawID = rawMaterial != null ? rawMaterial.getID() : -1;
		int finishedID = finishedMaterial != null ? finishedMaterial.getID() : -1;
		int rawAmount = rawMaterial != null ? rawMaterial.getAmount() : 0;
		int finishedAmount = finishedMaterial != null ? finishedMaterial.getAmount() : -1;
		
		return coalAmount + " " + rawID + " " + rawAmount + " " + finishedID + " " + finishedAmount;
	}
}
