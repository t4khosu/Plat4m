package com.t4khosu.Platformer.Level.areas.singleLevels.neuleben;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.Level.tile.Tile;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.interactiveEntities.ChestManager;
import com.t4khosu.Platformer.entities.interactiveEntities.Lever;
import com.t4khosu.Platformer.entities.interactiveEntities.SavePointManager;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes.OpenDungeon_1_Cutscene;
import com.t4khosu.Platformer.entities.Door;
import com.t4khosu.Platformer.entities.Entity;

public class Neuleben_2_2 extends LoadLevel {
    
    private boolean leverFound = false;
    private boolean openDungeon = false;
    
    private Lever lever1;
    private Lever lever2;
    
    /**
     * Constructor
     * @param player
     * @param middleground
     * @param background
     * @param frontTiles
     * @param backTiles
     * @param type
     * @param area
     */
	public Neuleben_2_2(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null,				  			  
				"/level/standard/haunted_forest_7.png", 
				"/level/standard/haunted_forest_7_back.png", 
				levelType.UNDERGROUND, 
				area,
				areaPosX,
				areaPosY
			);
	}
	
	@Override
	protected void initNPCs(){
		npcs.add(NPCManager.drHarun_neuleben.initLevelAndReturn(this));
	}
	
	@Override
	protected void initSurroundings(){
		lever1 = new Lever(37*8, 45*8, 0, false);
		interactiveEntities.add(lever1);
		
		hiders.add(new Entity(40*8, 45*8, Sprite.stone4_sprite));
		hiders.add(new Entity(41*8, 45*8, Sprite.stone4_sprite));
		hiders.add(new Entity(42*8, 45*8, Sprite.stone4_sprite));
		
		interactiveEntities.add(SavePointManager.p4_neuleben.initLevelAndReturn(this));
		interactiveEntities.add(ChestManager.ironBar_neuleben.initChestAndReturn(this));
	}
	
	@Override
	protected void initMobs(){
	}
	
	@Override
	protected void individualUpdate(){
		//First dungeon can be found here
		//Check if levers are switched so the dungeon shows itself
	    if(!leverFound && TileGetterList.getTile( 89, 21 , this).isPlantable()){
	        leverFound = true;
	        lever2 = new Lever(89*8, 20*8, 1, false);
	        interactiveEntities.add(lever2);
	    }
	    
	    if(lever2 != null && !openDungeon){
	        if(lever1.isOn() && lever2.isOn()){
	            openDungeon = true;
	            area.getWorld().setCutscene(new OpenDungeon_1_Cutscene(area.getWorld()));
	        }
	    }
	}

	@Override
	public void individualSaveFileLoad(String input) {
		if(input.trim().length() == 0) return;
		String[] split = input.split(" ");
		
		try{
			int status = Integer.parseInt(split[0]);
			
			if(status == 1 || status == 2){ //show lever
				leverFound  = true;
				lever2 = new Lever(89*8, 20*8, 1, false);
		        interactiveEntities.add(lever2);
			}
			if(status == 2){ //open dungeon
				openDungeon = true;
				
				Door d1 = new Door(61*8 - 2, 38*8, 18, 40, this, null, 1001);
				d1.connectDoors();
				addDoor(d1);
				
				Entity dungeonEntry = new Entity(59 * 8 - 4, 35 * 8 + 4, Sprite.dungeonEntry); // 58/35
				Entity dungeon_set1 = new Entity(70 * 8 - 4, 37 * 8 + 4, Sprite.dungeon_1_set1); // 58/35
				Entity dungeon_set2 = new Entity(50 * 8 - 4, 37 * 8 + 4, Sprite.dungeon_1_set2); // 58/35
				addImage(dungeonEntry);
				addImage(dungeon_set1);
				addImage(dungeon_set2);
				
				lever1.switchLever();
				lever2.switchLever();
				changeTiles(Tile.ID_torchOffTile, Tile.ID_torch);
			}
			
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Neuleben_2_2 could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load Neuleben_2_2... " + e);
		}
	}

	@Override
	public String individualSave() {
		String s = "";
		if(leverFound) s = "*e1";
		if(openDungeon) s = "*e2";
		return s;
	}
}
