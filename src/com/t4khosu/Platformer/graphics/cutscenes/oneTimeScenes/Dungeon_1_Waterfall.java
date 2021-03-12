/**
 * when two levers are pressed, a dungeon appears from the bottom
 * after camera changes its position to the upcoming dungeon
 */

package com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.cutscenes.Cutscene;
import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;

public class Dungeon_1_Waterfall extends Cutscene {
	
	private float factor = 1.0f;
	private int waterfallY = 44;
	private Level actualLevel = null;
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
    public Dungeon_1_Waterfall( World world, int removeText, int removeScreen ){
        super( world, removeText, removeScreen );
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
    			if(timer >= 20){
    				timer = 0;
    				action++;
    			}
    			break;
    				
    		case 1: factor = (100-timer) * 0.01f;
				if(timer >= 100){
					timer = 0;
					action++;
					actualLevel = world.getActualArea().getActualLevel();
					world.actualArea.setActualLevel(1,  1);
					camera.jumpTo(29, 78);
					player.setVisible(false);
				}
				timer++;
				break;
    				
    		case 2: timer++;
	    		if(timer >= 60){
					timer = 0;
					action++;
				}
	    		break;
    			
    		case 3:	factor = timer * 0.01f;
					if(timer >= 100){
						timer = 0;
						action++;
					}
					timer+=2;
					break;
					
    		case 4: timer++;
	    		if(timer >= 45){
					timer = 0;
					action++;
				}
	    		break;
					
    		case 5: if(!world.getCamera().isMoving()){
    					timer++;
    					if(timer%2 == 0){
    						camera.moveTo(29, 78, 2); 
    					}else{
    						camera.moveTo(28, 78, 2); 
    					}
    				}
    				if(timer >= 41){ 
    					timer = 0;
    					action++;
    				}
		    		break;
		    		
    		case 6: factor = (100-timer) * 0.01f;
    				if(!world.getCamera().isMoving()){
						if(timer%2 == 0){
							camera.moveTo(29, 78, 2); 
						}else{
							camera.moveTo(28, 78, 2); 
						}
					}
    				if(timer >= 100){
    					action++;
    					timer = 0;
    				}
    				timer++;
    				break;
	    		
    		case 7: timer++;
    				if(!camera.isMoving()){
    					world.actualArea.setActualLevel(1,  0);
    					camera.jumpTo(40, 44);
    				}
		    		if(timer >= 60){
						timer = 0;
						action++;
					}
		    		break;
    				
    		case 8:	factor = timer * 0.01f;
    		
		    		if(!world.getCamera().isMoving()){
						if(timer%2 == 0){
							camera.moveTo(40, 44, 2); 
						}else{
							camera.moveTo(39, 44, 2); 
						}
					}
		    		
					if(timer >= 100){
						timer = 0;
						camera.moveTo(40, 44, 2); 
						action++;
					}
					timer++;
					break;
					
    		case 9: if(!world.getCamera().isMoving()){
						timer++;
						if(timer%2 == 0){
							camera.moveTo(40, 44, 2); 
						}else{
							camera.moveTo(39, 44, 2); 
						}
					}
					if(timer >= 31){ 
						timer = 0;
						action++;
						camera.moveTo(40, 44, 2); 
					}
		    		break;
		    		
    		case 10: timer++;
		    		if(timer >= 90){
						timer = 0;
						action++;
					}
		    		break;
		    		
    		case 11: for(int xx = 31; xx <= 45; xx++){
		    			world.getActualArea().getActualLevel().setTile(xx, 44, 0xfff);
		    		}
    				action++;
    				break;
    				
    		case 12: timer++;
		    		if(timer >= 30){
						timer = 0;
						action++;
					}
		    		break;
		    		
    		case 13: camera.moveTo(40, 80, 1); 
    				action++;
    		case 14: timer++;
					if(timer%8 == 0){
						if(waterfallY <= 89){
							for(int xx = 31; xx <= 45; xx++){
    							world.getActualArea().getActualLevel().setBGTile(xx, waterfallY, 0xffAB70E6);
    							if(waterfallY == 89){
    								world.getActualArea().getActualLevel().setTile(xx, waterfallY, 0xfff);
    							}
    						}
						}
						waterfallY++;
					}
					
					if(waterfallY > 89){
						action++;
						timer = 0;
					}
					break;
					
    		case 15: factor = (100-timer) * 0.01f;
					if(timer >= 100){
						timer = 0;
						action++;
					}
					timer+=2;
					break;
			
			case 16: timer++;
					if(timer >= 40){
						timer = 0;
						world.actualArea.setActualLevel(1,  1);
    					camera.jumpTo(40, 0);
    					waterfallY = 0;
    					camera.moveTo(40, 80, 1); 
						action++;
					}
					break;
					
			case 17: timer++;
					if(timer%8 == 0){
						if(waterfallY <= 89){
							for(int xx = 31; xx <= 45; xx++){
								world.getActualArea().getActualLevel().setBGTile(xx, waterfallY, 0xffAB70E6);
								if(waterfallY == 89  || waterfallY == 0){
									world.getActualArea().getActualLevel().setTile(xx, waterfallY, 0xfff);
								}
							}
						}
						waterfallY++;
					}
					
					if(waterfallY > 89){
						action++;
						timer = 0;
					}
					break;
					
			case 18: timer++;
		    		if(timer >= 80){
						timer = 0;
						world.getActualArea().setActualLevel(actualLevel);
						player.setVisible(true);
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
		switch(action){
			case 1: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
			break;
			case 2: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
			break;
			case 3: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
			break;
			case 6: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
			break;
			case 7: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
			break;
			case 8: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
			break;
			case 15: screen.renderDarker(0, 0, Game.width, Game.height, factor, false);
			break;
			case 16: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
			break;
		}
	}
}
