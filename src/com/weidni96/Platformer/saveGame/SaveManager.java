package com.weidni96.Platformer.saveGame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.NPC.forest.Dregen;
import com.weidni96.Platformer.entities.interactiveEntities.Chest;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;
import com.weidni96.Platformer.entities.interactiveEntities.Fire;
import com.weidni96.Platformer.entities.interactiveEntities.SavePoint;
import com.weidni96.Platformer.entities.interactiveEntities.SavePointManager;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.player.Player;

public class SaveManager {
	
	private World world;
	private Player player;
	
	private Level actualLevel;
	
	public SaveManager(World world){
		this.world = world;
		this.player = world.getPlayer();
	}
	
	
	/**
	 * save all actual data in save data.
	 * there is a specific format:
	 * 1. player data:
	 * 		*pa = player stati like level, health, ...
	 * 		*pb = actual save point
	 * 		*pc = complete inventory of player, put back in inventory, handy don't hold anything
	 * 
	 * 2. npc data (*n):
	 * 		1. position in list
	 * 		2. actual dialog position
	 * 		3. hQ = has Quest, aQ = activeQuest, no = nothing active
	 * 		4. extra data depending on specific npc
	 * 
	 * 3. chest data (*c): all chests that are open
	 * 
	 * 4. level data (l*)
	 * 		1. worldPosX, worldPosY, areaPosX, areaPosY
	 * 		2. *T: new front tiles, position and tileID
	 * 		3. *t: new background tiles, position and tileID
	 * 		4. individual save, will also be loaded individually
	 * 		5. plants: plant name, grow state, timer, ripe (boolean)
	 * 
	 * 5. fire data (f*)
	 * 		coal amount, item to burn, amount of item to burn
	 * 
	 */
	public void saveAllData(){
		try {
			PrintWriter writer = new PrintWriter("saveData.save", "UTF-8");

			//save position of player, his stats and actual inventory
			String playerStats = "*pa" + player.getLvl() + " " + player.getExperience() + " " + player.getStrength() + " " + player.getRul();
			String savePoint = "*pb" + SavePointManager.getActiveSavePointPos();
			String inventory = "*pc";
			Item[][] items = player.getItemStore().getItems();
			for(Item[] l1 : items){
				for(Item l2 : l1){
					if(l2 == null) continue;
					inventory += l2.getID() + " " + l2.getAmount() + " ";
				}
			}
			writer.println(playerStats);
			writer.println(savePoint);
			writer.println(inventory);
			
			//save npc data
			for(int i = 0; i < NPCManager.npcList.length; i++){
				NPC n = NPCManager.npcList[i];
				String npcData = "*n" + i + " ";
				
				npcData +=  n.getActualDialog() + " ";
				if(n.getHasQuest()) npcData += "hQ" + " ";
				else if(n.getActiveQuest()) npcData += "aQ" + " ";
				else npcData += "no ";
				
				//individual npc data
				if(n instanceof Dregen) npcData += ((Dregen)n).getSaveData();
				
				
				writer.println(npcData);
			}
			
			//save chests data
			String openChests = "*c";
			for(int i = 0; i < ChestManager.chestList.length; i++){
				Chest c = ChestManager.chestList[i];
				if(c.isOpen()){
					openChests += i + " ";
				}
			}
			writer.println(openChests);
			
			//get all levels
			Area[] areas = world.getAreas();
			for(Area a : areas){
				if( a == null) continue;
				for(Level l : a.getLevels()){
					if(l == null) continue;
					
					ArrayList<String> data = l.createSaveString();
					for(String d : data){
						writer.println(d);
					}
				}
			}
			
			String fire = "*f";
			Fire f = Fire.blacksmithFire;
			writer.println(f.getSaveData());
			
			//close writer
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not find file...");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not encode UTF-8");
			e.printStackTrace();
		}
	}
	
	public void initSaveData(){
		initPlayerStats("2 40 3 50");
		initPlayerPosition("2");
		initPlayerInventory("40 1 49 1 52 1 10 20 11 20 43 1");
		initNPC("4 6 no 0 10");
		initOpenChests("0 1 2 3 4");
		
		initLevels("0 1 3 1");
		actualLevel.initTilesFromSaveFile("4692 0 4592 0 4492 0");
		
		initLevels("1 1 2 2");
		actualLevel.individualSaveFileLoad("2");
	}
	
	public void initPlayerStats(String input){
		String[] split = input.split(" ");
		try{
			int lvl = Integer.parseInt(split[0]);
			player.setLvl(lvl);
			
			int exp = Integer.parseInt(split[1]);
			player.setExperience(exp);
			
			int strength = Integer.parseInt(split[2]);
			player.setStrength(strength);
			
			int rul = Integer.parseInt(split[3]);
			player.setRul(rul);
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Player Stats could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load player stats...");
		}
	}
	
	public void initPlayerPosition(String input){
		try{
			int savePointID = Integer.parseInt(input);
			SavePoint sp = SavePointManager.savePoints[savePointID];
			sp.activate();
			
			world.setActualArea(sp.getLevel().getArea());	
			world.getActualArea().setActualLevel(sp.getLevel().getAreaPosX(), sp.getLevel().getAreaPosY());	
			
			player.initLevel(sp.getLevel());
			player.setX(sp.getX() + 8);
			player.setY(sp.getY());
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Player Position could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not set Position for Player...");
		}
	}
	
	public void initPlayerInventory(String input){
		String[] split = input.split(" ");
		try{
			for(int i = 0; i < split.length-1; i+=2){
				int id = Integer.parseInt(split[i]);
				int amount = Integer.parseInt(split[i+1]);
				player.getItemStore().addItem(id, amount);
			}
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Player Inventory could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load player inventory...");
		}
	}
	
	public void initNPC(String input){
		String[] split = input.split(" ");
		try{
			int npcPos = Integer.parseInt(split[0]);
			NPC npc = NPCManager.npcList[npcPos];
			
			npc.loadData(split);
			
			if(npc instanceof Dregen){
				int questPoints = Integer.parseInt(split[3]);
				int slimeCounter = Integer.parseInt(split[4]);
				((Dregen)npc).setQuestPoints(questPoints);
				((Dregen)npc).setSlimeCounter(slimeCounter);
			}
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: NPC could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load npc...");
		}
	}
	
	public void initOpenChests(String input){
		if(input.trim().length() == 0) return;
		String[] split = input.split(" ");
		try{
			for(String s : split){
				int num = Integer.parseInt(s);
				ChestManager.chestList[num].setOpen(true);
			}
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Chest could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load chest...");
		}
	}
	
	public void initLevels(String input){
		if(input.trim().length() == 0) return;
		String[] split = input.split(" ");
		
		try{
			int worldPosX 	= Integer.parseInt(split[0]);
			int worldPosY 	= Integer.parseInt(split[1]);
			int areaPosX 	= Integer.parseInt(split[2]);
			int areaPosY 	= Integer.parseInt(split[3]);
			
			Area a = world.getAreas()[worldPosX + world.getAreaWidth() * worldPosY];
			actualLevel = a.getLevels()[areaPosX + a.getWidth() * areaPosY];
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Level could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load level...");
		}
	}
}
