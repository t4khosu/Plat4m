package com.weidni96.Platformer.graphics.cutscenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

/**
 * start a minigame
 * @author Christian
 *
 */
public class Minigame1Cutscene extends Cutscene{
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
	public Minigame1Cutscene(World world, int removeText, int removeScreen) {
		super(world, removeText, removeScreen);
	}
	
	@Override
	public void update(){
		
		switch(action){
			case 0: if(timer == 100){
						action++;
						timer = 0;
					}
					timer++;
					break;
					
			case 1: if(timer == 60){
						action++;
						timer = 0;
						remove();
					}
					timer++;
					break;
		}
		
		timer++;
		
		/*if(timer == 160){
			world.getActualArea().changeLevelTo(17);
			world.getActualArea().getActualLevel().getPlayer().setX(8*8);
			world.getActualArea().getActualLevel().getPlayer().setY(48*8);
		}*/
	}
	
	@Override
	public void render(Screen screen){
		if(action == 0){
			screen.clear();
		}
		if(action == 1){
			screen.renderSprite(Game.width/2-16, Game.height/2, Sprite.player_right, false);
		}
	}
	
	@Override
	public void render(Graphics g){
		if(action == 1){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial Hebrew", Font.PLAIN, 14)); 
			g.drawString("x3", (Game.width/2)*Game.scale-16, (Game.height/2)*Game.scale + 24);
		}
	}
}
