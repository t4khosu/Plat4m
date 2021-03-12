package com.weidni96.Platformer.Level;

import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.cutscenes.Menu_Cutscene;
import com.weidni96.Platformer.graphics.cutscenes.oneTimeScenes.WakeUpCutscene;

public class BreakPointManager {
	
	private World world;
	private Player player;
	
	public BreakPointManager(World world){
		this.world = world;
		this.player = world.getPlayer();
	}
	
	public void setPlayerModus(int modus){
		if(modus == 0){ //god mode
			player.initLife(99999999);
			player.setStrength(99999999);
			player.setLvl(100);
			player.addExperience(5000);
		}
		
	}
	
	public void setBreakPointBeginning(int point){
		if(point == 0){ //Complete beginning, (final version)
			world.setCutscene(new Menu_Cutscene(world));
		}
		else if(point == 1){ //Beginning new Game
			world.setCutscene(new WakeUpCutscene(world)); 
		}
		
		if(point == 1 || point == 2){ //Beginning new Game without Cutscene
			world.setActualArea(world.getNeuleben());	
			world.getActualArea().setActualLevel(0, 1);	
			
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(8*8);
			player.setY(37*8);
		}
		
		if(point >= 3 && point <= 7){ //finished first 3 quests, time to get a sword :)
			world.setActualArea(world.getNeuleben());
			world.getActualArea().setActualLevel(0, 1);	
			
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(8*8);
			player.setY(37*8);

			player.addItem(Item.woodenFishingPole_ID);
			player.addItem(Item.woodenShovel_ID);
			player.addItem(Item.rolberry_ID, 0);
			player.addItem(Item.corjack_ID, 0);
			NPCManager.levindra_neuleben.setActualDialog(4);
			NPCManager.gorn_neuleben.setActualDialog(4);
			NPCManager.ahb_neuleben.setActualDialog(4);
			NPCManager.dregen_neuleben.setActualDialog(2);
			NPCManager.preng_neuleben.setActualDialog(4);
		}
		
		if(point == 4){ // Village Forest at the first riddle to get pickaxe
			world.setActualArea(world.getVillageForest());
			world.getActualArea().setActualLevel(2, 2);	
			
			player.addItem(Item.woodenSword_ID);
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(67*8);
			player.setY(46*8);
		}
		
		if(point == 5){ // In Front of the first dungeon
			world.setActualArea(world.getNeuleben());	
			world.getActualArea().setActualLevel(2, 2);	
			
			player.addItem(Item.woodenSword_ID);
			player.addItem(Item.woodenPickaxe_ID);
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(62*8);
			player.setY(42*8);
		}
		
		if(point == 6){ //inside dungeon
			world.setActualArea(world.getDungeon_01());
			world.getActualArea().setActualLevel(0, 1);	
			
			player.addItem(Item.woodenSword_ID);
			player.addItem(Item.woodenPickaxe_ID);
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(9*8);
			player.setY(88*8);
			
			System.out.println(world.actualArea);
		}
		
		if(point == 7){ //in Neuleben with full inventory
			world.setActualArea(world.getNeuleben());	
			world.getActualArea().setActualLevel(0, 1);	
			
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(8*8);
			player.setY(37*8);
			
			player.addItem(Item.woodenSword_ID);
			player.addItem(Item.woodenPickaxe_ID);
			player.addItem(Item.boots_ID);
			player.addItem(Item.ironBar_ID, 40);
		}
	}
		
	public void setBreakPointAfterFirstDungeon(int point){
		if(point == 1){ 
			world.setActualArea(world.getVillageForest());	
			world.getActualArea().setActualLevel(1, 1);	
			world.setCutscene(new Menu_Cutscene(world));
			player.initLevel(world.getActualArea().getActualLevel());
			player.setX(32*8);
			player.setY(23*8);
			
			player.addItem(Item.woodenSword_ID);
			player.addItem(Item.woodenPickaxe_ID);
			player.addItem(Item.boots_ID);
			player.addItem(Item.woodenFishingPole_ID);
			player.addItem(Item.woodenShovel_ID);
			player.addItem(Item.ironBar_ID, 40);
			player.addItem(Item.coal_ID, 40);
			player.addItem(Item.rawIron_ID, 40);
			player.addItem(Item.rolberry_ID, 10);
			player.addItem(Item.corjack_ID, 10);
		}
	}
}
