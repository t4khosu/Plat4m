/**
 * the information bar isn't a single bar!
 * it is about all static information that is displayed on top of the screen
 */
package com.weidni96.Platformer.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.Level.levelType;
import com.weidni96.Platformer.Level.World;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class InformationBar extends Entity{
	private Player player;
	private World world;
	
	/**
	 * constructor, create an information bar
	 * @param world
	 */
	public InformationBar(World world){
		this.world = world;
		this.player = world.getPlayer();
		x = 0;
		y = 0;
		width = 100;
		height = 50;
	}
	
	/**
	 * render all information on a bar on screen. it is static, so no changes possible!
	 * print: HP (HitPoints), SP (StaminaPoints), Level, Experience.
	 * If player has countable item on J/K: print amount
	 * Print all numbers for small slots and chars for big slots
	 * @param g
	 */
	public void render(Graphics g){
		if(world.getActualArea().getActualLevel().getType() == levelType.MINIGAME) return;
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 11)); 
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("HP",  6, 11);
		g.drawString("SP",  6, 22);
		
		g.drawString("Lvl. " + player.getLvl(),  880, 11);
		g.drawString(String.valueOf("x" + player.getRul()),  950, 11);
		//g.drawString("x4",  1024, 11);
		
		g.drawString("Exp",  879, 23);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 13)); 
		if((player.getJK()[0] != null && player.getJK()[0].isStackable())){
			g.drawString(String.valueOf(player.getJK()[0].getAmount()),  (Game.width * Game.scale / 2) - 18, 43);
		}
		if(player.getJK()[1] != null && player.getJK()[1].isStackable()){
			g.drawString(String.valueOf(player.getJK()[1].getAmount()),  (Game.width * Game.scale / 2) + 37, 43);
		}
		
		int midX = Game.width * Game.scale / 2;
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 11)); 
		if(player.getSmallSlots()[0] != null) g.drawString(String.valueOf(player.getSmallSlots()[0].getAmount()), midX - ((Sprite.handSlot.getWidth() + 2*Sprite.extraSlot.getWidth() + 4)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
		if(player.getSmallSlots()[1] != null) g.drawString(String.valueOf(player.getSmallSlots()[1].getAmount()), midX - ((Sprite.handSlot.getWidth() + Sprite.extraSlot.getWidth() + 3)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
		if(player.getSmallSlots()[2] != null) g.drawString(String.valueOf(player.getSmallSlots()[2].getAmount()), midX - ((Sprite.handSlot.getWidth() + 2)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
		
		if(player.getSmallSlots()[3] != null) g.drawString(String.valueOf(player.getSmallSlots()[3].getAmount()), midX + ((Sprite.handSlot.getWidth() + Sprite.extraSlot.getWidth() + 3)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
		if(player.getSmallSlots()[4] != null) g.drawString(String.valueOf(player.getSmallSlots()[4].getAmount()), midX + ((Sprite.handSlot.getWidth() + 2*Sprite.extraSlot.getWidth() + 4)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
		if(player.getSmallSlots()[5] != null) g.drawString(String.valueOf(player.getSmallSlots()[5].getAmount()), midX + ((Sprite.handSlot.getWidth() + 3*Sprite.extraSlot.getWidth() + 5)*Game.scale)-10, (Sprite.extraSlot.getHeight())*Game.scale-3);
	}
	
	/**
	 * render backgrounds for information, like slots
	 */
	public void render(Screen screen){
		if(world.getActualArea().getActualLevel().getType() == levelType.MINIGAME) return;
		screen.renderSprite(0, 0, Sprite.lifeBackground, false);
		screen.renderSprite(screen.getWidth()-Sprite.extraBackground.getWidth(), 0, Sprite.extraBackground, false);
		if(!player.getMTM().getPoisonedTimer().isActive()){
			screen.renderLifeBar(10, 2, player.getLife(), player.getMaxLife(), 50, 1,  false);
		}else{
			screen.renderBar(10, 2, player.getLife(), player.getMaxLife(), 50, 0xffFF14E7,  false);
		}
		
		screen.renderBar(10, 5, player.getStamina(), player.getMaxStamina(), 40, 0xff57B2A1,  false);
		
		screen.renderBar(screen.getWidth()-52, 6, player.getExperience(), player.getNextExperience(), 47, 0xffDBCC9D,  false);
		
		screen.renderSprite(screen.getWidth()-40, 2, Sprite.mini_money_sprite, false);
		//screen.renderSprite(screen.getWidth()-16, 2, Sprite.mini_head_sprite, false);
	}
}
