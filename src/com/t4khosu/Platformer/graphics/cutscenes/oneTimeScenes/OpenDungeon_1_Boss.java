/**
 * when two levers are pressed, a dungeon appears from the bottom
 * after camera changes its position to the upcoming dungeon
 */

package com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.graphics.cutscenes.Cutscene;

public class OpenDungeon_1_Boss extends Cutscene{
	
	private boolean drawInterogation = false;
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
    public OpenDungeon_1_Boss( World world, int removeText, int removeScreen ){
        super( world, removeText, removeScreen );
    }
    
    @Override
    public void update(){
    	
    	switch(action){
    		case 0: timer++;
    				if(timer == 100){
    					timer = 0;
    					action++;
    					
    					for(int i = 31; i <= 45; i++){
    						world.getActualArea().getActualLevel().setTile(i, 0, 0xff404040);
    					}
    				}
    				break;
					
    		case 1: timer++;
    				if(timer == 30){
    					changePlayerLookingDirection();
    				}
    				if(timer == 60){
    					changePlayerLookingDirection();
    				}
    				if(timer == 90){
    					changePlayerLookingDirection();
    				}
    				if(timer >= 140){
    					action++;
    					timer = 0;
    				}
    				break;
    				
    		case 2: timer++;
		    		if(timer < 120){
		    			drawInterogation = true;
		    		}else{
		    			drawInterogation = false;
		    			timer = 0;
		    			action++;
		    		}
    				break;
    		
    		case 3: camera.moveTo(38, 24, 1); 
					action++;
					break;
					
    		case 4: if(!camera.isMoving()){
    					timer++;
    					
    				}
    				if(timer >= 60){
    					action++;
    					timer = 0;
    				}
    				break;
    				
    		case 5: remove();
    				camera.focusEntity(player);
					player.setCanAct(true);
					break;
    	}
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public void render(Screen screen) {
		if(drawInterogation){
			screen.renderSprite(player.getX() + 6, player.getY() - 8, Sprite.haveQuest_sprite, true);
		}
	}
}
