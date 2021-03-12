package com.weidni96.Platformer.graphics.cutscenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.interactiveEntities.SavePoint;
import com.weidni96.Platformer.entities.interactiveEntities.SavePointManager;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Screen;

public class PlayerDeath_Cutscene extends Cutscene{

	private float factor = 0f;
	private Player player;
	private SavePoint sp;
	
	public PlayerDeath_Cutscene(World world, Player player) {
		super(world, 0, 1);
		this.player = player;
		sp = SavePointManager.getActiveSavePoint();
	}

	@Override
	public void update(){
		
		/*
    	 * 0. Wait until timer = 40, then start doing stuff
    	 * 1. Render everything black except player
    	 * 2. Render first text
    	 * 3. Render second text
    	 * 4. Render third text
    	 */
		
		switch(action){
			case 0: timer++;
					if(timer >= 100){
						timer = 0;
						action++;
						removeScreen = 0;
					}
					break;
					
			case 1: timer++;
			if(timer >= 60){
				timer = 0;
				action++;
			}
			break;
			
			case 2: timer++;
			if(timer >= 100){
				timer = 0;
				action++;
			}
			break;
					
			case 3: timer++;
					if(timer >= 100){
						timer = 0;
						action++;
					}
					break;
					
			case 4: timer++;
			if(timer >= 200){
				timer = 0;
				action++;
			}
			break;
			
			case 5: timer++;
			if(timer >= 200){
				timer = 0;
				action++;
			}
			break;
					
			case 6: world.levelChange(sp.getLevel(), sp.getX() + player.getWidth(), sp.getY());
					player.initLife(player.getMaxLife());
					remove();
					break;
		}
	}
	
	@Override
	public void render(Screen screen){
		switch(action){
			case 1: screen.renderDarker(0, 0, Game.width, Game.height, 0, false);
					player.render(screen);
					break;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 25)); 
		g.setColor(Color.white);
		if(action < 5){
			switch(action){
			case 4:
				g.drawString("Es wird immer ein n\u00E4chstes Mal geben!",  Game.width/5*Game.scale, Game.height/2*Game.scale + 60);
			case 3:
				g.drawString("Doch gib nicht auf Abenteurer!",  Game.width/5*Game.scale, Game.height/2*Game.scale + 30);
			case 2: 
				g.drawString("Du bist gestorben...",  Game.width/5*Game.scale, Game.height/2*Game.scale);
			}
		}
		
	}
}
