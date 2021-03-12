/**
 * when two levers are pressed, a dungeon appears from the bottom
 * after camera changes its position to the upcoming dungeon
 */

package com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Level.tile.Tile;
import com.t4khosu.Platformer.entities.Door;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.graphics.cutscenes.Cutscene;

public class OpenDungeon_1_Cutscene extends Cutscene{
	private Entity dungeonEntry = new Entity(59 * 8 - 4, 42 * 8 + 4, Sprite.dungeonEntry); // 58/35
	private Entity dungeon_set1 = new Entity(70 * 8 - 4, 44 * 8 + 4, Sprite.dungeon_1_set1); // 58/35
	private Entity dungeon_set2 = new Entity(50 * 8 - 4, 44 * 8 + 4, Sprite.dungeon_1_set2); // 58/35
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
    public OpenDungeon_1_Cutscene( World world){
        super( world, 1, 1 );
    }
    
    @Override
    public void update(){
    	
    	/*
    	 * 0. Wait until timer = 100, then move camera to 63,37 with speed = 2
    	 * 1. Wait until camera stops moving
    	 * 2. Wait until timer = 30, then add dungeon images
    	 * 3. Slowly move image upwards until it reaches its destination
    	 * 4. Lighten the torches 
    	 * 5. Wait until timer = 100, then camera focus player again, remove cutscene
    	 * 
    	 */
    	
    	switch(action){
    		case 0: timer++;
    				if(timer == 100){
    					timer = 0;
    					camera.moveTo(63, 37, 2); 
    					action++;
    				}
    				break;
    				
    		case 1: if(!world.getCamera().isMoving()) action++;
    				break;
    				
    		case 2: timer++;
    				if(timer == 30){
    					timer = 0;
    					world.getActualArea().getActualLevel().addImage(dungeonEntry);
    					world.getActualArea().getActualLevel().addImage(dungeon_set1);
    					world.getActualArea().getActualLevel().addImage(dungeon_set2);
    					action++;
    				}
    				break;
    				
    		case 3: timer++;
					if(dungeonEntry.getY() > 35 * 8 + 4){
						if(timer%4 == 0){
							dungeonEntry.setY(dungeonEntry.getY()-1);
							dungeon_set1.setY(dungeon_set1.getY()-1);
							dungeon_set2.setY(dungeon_set2.getY()-1);
						}
					}else{
						timer = 0;
						Door d1 = new Door(61*8 - 2, 38*8, 18, 40, level, null, 1001);
						d1.connectDoors();
						level.addDoor(d1);
						action++;
					}
					break;
					
    		case 4: level.changeTiles(Tile.ID_torchOffTile, Tile.ID_torch);
					action++;
					break;
					
    		case 5: timer++;
    				if(timer == 100){
    					timer = 0;
    					camera.focusEntity(player);
    					remove();
    				}
    				break;
    	}
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public void render(Screen screen) {
	}
}
