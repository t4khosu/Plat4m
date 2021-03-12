package com.t4khosu.Platformer.entities.item;

import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.item.mainItems.cds.CD_1;
import com.t4khosu.Platformer.entities.item.mainItems.extras.Money;
import com.t4khosu.Platformer.entities.item.mainItems.extras.SlimeBall;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.Coal;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.IronBar;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.RawIron;
import com.t4khosu.Platformer.entities.item.mainItems.groundTreasures.RawUru;
import com.t4khosu.Platformer.entities.item.mainItems.meat.Corjack;
import com.t4khosu.Platformer.entities.item.mainItems.meat.Pompbass;
import com.t4khosu.Platformer.entities.item.mainItems.meat.Snappon;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Agroilberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.AgroilberrySeed;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Rolberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.RolberrySeed;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Wheat;
import com.t4khosu.Platformer.entities.item.mainItems.plants.WheatSeed;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Yocip;
import com.t4khosu.Platformer.entities.item.mainItems.plants.YocipSeed;
import com.t4khosu.Platformer.entities.item.mainItems.potions.HealthPotion;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Boots;
import com.t4khosu.Platformer.entities.item.mainItems.tools.IronFishingPole;
import com.t4khosu.Platformer.entities.item.mainItems.tools.IronPickaxe;
import com.t4khosu.Platformer.entities.item.mainItems.tools.IronShovel;
import com.t4khosu.Platformer.entities.item.mainItems.tools.UruFishingPole;
import com.t4khosu.Platformer.entities.item.mainItems.tools.UruPickaxe;
import com.t4khosu.Platformer.entities.item.mainItems.tools.UruShovel;
import com.t4khosu.Platformer.entities.item.mainItems.tools.WoodenFishingPole;
import com.t4khosu.Platformer.entities.item.mainItems.tools.WoodenPickaxe;
import com.t4khosu.Platformer.entities.item.mainItems.tools.WoodenShovel;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Sword.IronSword;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Sword.UruSword;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Sword.WoodenSword;

public abstract class Item extends Entity {
	
	public final static int coal_ID 		= 10;
	public final static int rawIron_ID 		= 11;
	public final static int rawUru_ID 		= 12;
	public final static int ironBar_ID 		= 13;
	
	public final static int rolberrySeed_ID 	= 20;
	public final static int wheatSeed_ID 		= 21;
	public final static int agroilberrySeed_ID 	= 22;
	public final static int yocipSeed_ID 		= 23;
	
	public final static int rolberry_ID 	= 30;
	public final static int wheat_ID 		= 31;
	public final static int agroilberry_ID  = 32;
	public final static int yocip_ID  		= 33;
	
	public final static int woodenPickaxe_ID		= 40;
	public final static int ironPickaxe_ID 			= 41;
	public final static int uruPickaxe_ID 			= 42;
	public final static int woodenFishingPole_ID 	= 43;
	public final static int ironFishingPole_ID	 	= 44;
	public final static int uruFishingPole_ID 	 	= 45;
	public final static int woodenShovel_ID 	 	= 46;
	public final static int ironShovel_ID 		 	= 47;
	public final static int uruShovel_ID 		 	= 48;
	public final static int woodenSword_ID 			= 49;
	public final static int ironSword_ID 			= 50;
	public final static int uruSword_ID 			= 51;
	public final static int boots_ID 				= 52;
	
	public final static int money_ID 		= 60;
	public final static int slimeBall_ID	= 61;
	
	public final static int corjack_ID		= 70;
	public final static int pompbass_ID		= 71;
	public final static int snappon_ID		= 72;
	
	public final static int healthPotion_ID = 80;
	
	public final static int cd1_ID = 90;
	
	public enum ItemType{
		FOOD, TOOLS, SEEDS, MONEY, RAWMATERIAL,
		SWORD, POLE, PICKAXE, SHOVEL, POTION, FISHINGPOLE, CD, BERRY;
	}
	
	public 	  int ID 				= 0;
	protected boolean stackable 	= false;
	
	protected String description 	= "";
	protected String name			= "";
	protected int amount		  	= 0;
	protected int value				= 0;
	protected boolean sellable		= true;
	protected int damage			= 0;
	
	protected int staminaUse 		= -1;
	
	protected ItemType type;
	
	protected int spawnTime;
	protected AnimatedSprite as;
	protected Sprite collectSprite = null; //when collected from a chest or npc gives it to you etc...
	
	/**
	 * constructor
	 * everything must be defined in class
	 */
	public Item(){
	}
	
	/**
	 * update item
	 */
	public void update(){
		if(as != null){
			as.update();
			sprite = as.getSprite();
		}
	}
	
	/**
	 * render sprite
	 * @param screen
	 * @param xx
	 * @param yy
	 */
	public void render(Screen screen, int xx, int yy){
		screen.renderSprite(xx, yy, sprite, false);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void add(int amount){
		if(stackable){
			this.amount += amount;
		}
	}
	public void setSellable(boolean sellable){
		this.sellable = sellable;
	}
	
	public void useItem(int amount){
		this.amount -= amount;
	}
	
	public boolean isSellable(){
		return sellable;
	}
	public Sprite getCollectSprite(){
		return collectSprite;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public boolean isStackable(){
		return stackable;
	}
	public int getAmount(){
		return amount;
	}
	public ItemType getType(){
		return type;
	}
	public int getDamage(){
		return damage;
	}
	public int getStaminaUse(){
		return staminaUse;
	}
	public int getID(){
		return ID;
	}
	public int getValue(){
		return value;
	}
	public Sprite getSprite(){
		return sprite;
	}
	public static Item getItem(int ID){
		switch(ID){
			case coal_ID: 	 			return new Coal();
			case rawIron_ID: 			return new RawIron();
			case rawUru_ID: 			return new RawUru();
			case ironBar_ID:			return new IronBar();
			
			case agroilberrySeed_ID: 	return new AgroilberrySeed();
			case rolberrySeed_ID:		return new RolberrySeed();
			case wheatSeed_ID: 			return new WheatSeed();
			case yocipSeed_ID:			return new YocipSeed();
			
			case agroilberry_ID :		return new Agroilberry();
			case rolberry_ID:			return new Rolberry();
			case wheat_ID: 				return new Wheat();
			case yocip_ID:				return new Yocip();
			
			case ironFishingPole_ID:	return new IronFishingPole();
			case ironPickaxe_ID:		return new IronPickaxe();
			case ironShovel_ID:			return new IronShovel();
			case ironSword_ID:			return new IronSword();
			
			case uruFishingPole_ID:		return new UruFishingPole();
			case uruPickaxe_ID:			return new UruPickaxe();
			case uruShovel_ID:			return new UruShovel();
			case uruSword_ID:			return new UruSword();
			
			case woodenFishingPole_ID:	return new WoodenFishingPole();
			case woodenPickaxe_ID:		return new WoodenPickaxe();
			case woodenShovel_ID:		return new WoodenShovel();
			case woodenSword_ID:		return new WoodenSword();
			
			case corjack_ID:			return new Corjack();
			case pompbass_ID:			return new Pompbass();
			case snappon_ID:			return new Snappon();
			
			case money_ID: 				return new Money();
			case slimeBall_ID:			return new SlimeBall();
			
			case healthPotion_ID:		return new HealthPotion();
			case cd1_ID:				return new CD_1();
			case boots_ID:				return new Boots();
			default: return null;
		}
	}
}