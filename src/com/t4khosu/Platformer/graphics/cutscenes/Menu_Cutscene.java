package com.t4khosu.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Level.areas.singleLevels.MenuLevel;
import com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes.WakeUpCutscene;

public class Menu_Cutscene extends Cutscene{

	private float factor = 0.0f;
	private Level actualLevel;
	
	private int hoveredSetting = 0;
	private Sprite[] buttons = {Sprite.button_startNewGame, Sprite.button_loadGame};
	
	public Menu_Cutscene(World world) {
		super(world, 0, 0);
		actualLevel = new MenuLevel(world.getPlayer());
	}

	@Override
	public void update() {
		actualLevel.update();
		switch(action){
		
		//wähle zufälliges level und eine von 4 startpositionen
		//bewege dich schräg, mit aktueller move funktion zu neuer position, und wechsel am ende das level
			case 0: timer++;
					if(timer > 60){
						timer = 0;
						action++;
					}
					break;
			case 1: factor = timer * 0.005f;
					timer ++;
					if(timer >= 200){
						factor = 1.0f;
						timer = 0;
						action++;
					}
					break;
			case 2: timer++;
					if(timer > 60){
						timer = 0;
						action++;
					}
					break;
			case 3: factor = (200-timer) * 0.005f;
					timer ++;
					if(timer >= 200){
						factor = 0.0f;
						timer = 0;
						action++;
					}
					break;
			case 4: timer++;
					if(timer > 60){
						timer = 0;
						action++;
					}
					break;
			
			case 5: factor = timer * 0.01f;
					timer ++;
					if(timer >= 100){
						factor = 1.0f;
						timer = 0;
						action++;
					}
					break;
					
			case 7: factor = (100-timer) * 0.01f;
				timer ++;
				if(timer >= 100){
					factor = 0.0f;
					timer = 0;
					action++;
				}
				break;
				
			case 8: timer++;
					if(timer > 90){
						timer = 0;
						action++;
					}
					break;
					
			case 9: if(hoveredSetting == 0){ //start new game
						player.setVisible(true);
						remove();
						world.setCutscene(new WakeUpCutscene(world));
					}
					break;
		}
		
		if(action == 5 || action == 6){
			if(world.getPlayer().getInput().typedDown){
				if(hoveredSetting + 1 < buttons.length){
					hoveredSetting++;
				}
			}
			else if(world.getPlayer().getInput().typedUp){
				if(hoveredSetting - 1 >= 0){
					hoveredSetting--;
				}
			}
			
			else if(world.getPlayer().getInput().typedInteract){
				if(hoveredSetting == 0){
					action = 7;
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) {

	}

	@Override
	public void render(Screen screen) {
		if(action <= 4){
			screen.renderSprite(screen.getWidth()/2 - Sprite.platamLogo.getWidth()/2, screen.getHeight()/2-Sprite.platamLogo.getHeight()/2, Sprite.platamLogo, false);
			screen.renderDarker(0, 0, screen.getWidth(), screen.getHeight(), factor, false);
		}else{
			actualLevel.render(0, 0, screen);
			int xx = screen.getWidth()/2 - Sprite.button_startNewGame.getWidth()/2;
			for(int i = 0; i < buttons.length; i++){
				screen.renderSprite(xx, 50 + 28 * i, buttons[i], false);
				if(hoveredSetting != i){
					screen.renderDarker(xx, 50 + 28 * i, buttons[i].getWidth(), buttons[i].getHeight(), 0.3f, false);
				}
			}	
			screen.renderDarker(0, 0, screen.getWidth(), screen.getHeight(), factor, false);
		}
	}
}
