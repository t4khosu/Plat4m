/**
 * first cutscene when player wakes up in the forest village
 */

package com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.NPC.forest.Ahb;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.cutscenes.Cutscene;

public class WakeUpCutscene extends Cutscene{
	
	private Player player;
	private int subText = 0;
	private String text = "";
	
	/**
	 * constructor
	 * @param world
	 * @param removeText
	 * @param removeScreen
	 */
	public WakeUpCutscene(World world) {
		super(world, 0, 0);
		world.setActualArea(world.getNeuleben());	
		world.getActualArea().setActualLevel(0, 1);
		this.player = world.getActualArea().getActualLevel().getPlayer();
		player.setX(8*8);
		player.setY(37*8);
	}
	
	@Override
	public void update(){
		
		/*
    	 * 0. put player in sleeping position
    	 * 1. change sleeping position of player
    	 * 2. player wakees up, looking right
    	 * 3. player looks left
    	 * 4. player looks right 
    	 * 5. start conversation with npc
    	 * 6. end cutscene
    	 * 
    	 */
		switch(action){
		
			case 0: 
				textTimer();
				break;
				
			case 1: 
				text = "Stehen geblieben!";
				textTimer();	
				break;
				
			case 2: 
				text = "Alle Einheiten. Er rennt zur verbotenen Deponie!";
				textTimer();
				break;
				
			case 3: 
				text = "Wir haben keine Zeit f\u00FCr Verst\u00E4rkung! Dieses Monster bekommen wir auch so!";
				textTimer();
				break;
				
			case 4: 
				text = "Los los...";
				textTimer();
				break;
				
			case 5: 
				text = "...";
				textTimer();
				break;
				
			case 6: 
				text = "*Wenige Minuten sp\u00E4ter*";
				textTimer();
				break;
				
			case 7: 
				text = "Bist du dir sicher, dass er \u00FCber diese Mauer geklettert ist?";
				textTimer();
				break;
				
			case 8: 
				text = "Kein Zweifel!";
				textTimer();
				break;
				
			case 9: 
				text = "Perfekt. Unter den Wildlingen und den Gifts\u00FCmpfen sollte er keinen Tag \u00FCberleben.";
				textTimer();
				break;
				
			case 10: 
				text = "Wir gehen zur\u00FCck. Es gibt hier nichts mehr zu tun.";
				textTimer();
				break;
			case 11:
				timer++;
				if(timer == 400){
					action++;
					timer = 0;
					removeText = 2;
					removeScreen = 2;
				}
				break;
		
			case 12: timer++;
					if(timer == 200){
						action++;
						timer = 0;
					}
					player.setSprite(Sprite.player_sleep1);
					break;
					
			case 13: timer++;
					if(timer == 100){
						player.setSprite(Sprite.player_sleep2);
						action++;
						timer = 0;
					}
					break;
					
			case 14: timer++;
					if(timer == 180){
						player.setSprite(Sprite.player_right);
						action++; 
						timer = 0;
					}
					break;
			
			case 15: timer++;
					if(timer == 40){
						player.setSprite(Sprite.player_left);
						action++; 
						timer = 0;
					}
					break;
					
			case 16: timer++;
					if(timer == 40){
						player.setSprite(Sprite.player_right);
						action++; 
						timer = 0;
					}
					break;
					
			case 17: timer++;
					if(timer == 50){
						for(NPC npc : world.getActualArea().getActualLevel().npcs){
							if(npc instanceof Ahb){
								world.getSurface().startDialog(player, npc, true);
								timer++;
								break;
							}	
						}
						action++; 
						timer = 0;
					}
					break;
					
			case 18: remove();	
					break;
		}
	}
	
	public void textTimer(){
		if(subText == text.length()){
			timer++;
			if(timer == 100){
				action++;
				text = "";
				subText = 0;
				timer = 0;
			}
		}else{
			if(Game.timer%4 == 0){
				subText++;
			}
		}
		
	}
	
	@Override
	public void render(Screen screen){
		if(action == 13){
			screen.renderSprite(player.getX()+4, player.getY()-8, Sprite.haveQuest_sprite, true);
		}
	}
	
	@Override
	public void render(Graphics g){
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 25)); 
		g.setColor(Color.white);
		switch(action){
			case 1:
				g.setColor(new Color(255, 162, 162));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
			
			case 2:
				g.setColor(new Color(255, 162, 162));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
				
			case 3:
				g.setColor(new Color(162, 255, 255));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
				
			case 4:
				g.setColor(new Color(162, 255, 255));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
				
			case 5:
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
			case 6:
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
				
			case 7:
				g.setColor(new Color(255, 162, 162));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
			case 8:
				g.setColor(new Color(162, 255, 255));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
			case 9:
				g.setColor(new Color(255, 162, 162));
				g.drawString(text.substring(0, subText),  20, Game.height/2*Game.scale);
				break;
				
			case 10:
				g.setColor(new Color(255, 162, 162));
				g.drawString(text.substring(0, subText), 20, Game.height/2*Game.scale);
				break;
			}
	}
}