package com.t4khosu.Platformer.entities.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.player.Player;

public class Log extends Entity {
	
	private Player player;
	private int width;
	private int height;
	private int logSize;
	
	private boolean permaOpen;
	
	private ArrayList<Entry> entries = new ArrayList<Entry>();
	
	/**
	 * constructor
	 * @param player
	 */
	public Log(Player player){
		this.player = player;
		this.permaOpen = false;
		
		this.width = 80;
		this.height = 30;
		this.logSize = 4;
	}
	
	/**
	 * add an Entry and delete old one if too many
	 * @param e
	 */
	public void addEntry(Entry e){
		if(entries.size() < logSize){
			entries.add(e);
		}else{
			while(entries.size() >= logSize){
				entries.remove(0);
			}
			entries.add(e);
		}
	}
	
	/**
	 * render transparent background and frame
	 * @param screen
	 */
	public void render(Screen screen){
		if(player.getPTM().getLogTimer().isActive() || permaOpen){
			screen.renderDarker(Game.width-width, Game.height-height, width, height, 0.70f, false);
			//TODO screen.renderFrame(Game.width-width, Game.height-height, width, height, 0xff222222, false);
		}
	}
	
	/**
	 * render text
	 * @param g
	 */
	public void render(Graphics g){
		int fontsize = 12;
		g.setFont(new Font("Arial Hebrew", Font.BOLD, fontsize)); 
		
		if(player.getPTM().getLogTimer().isActive() || permaOpen){
			for(int i = 0; i < entries.size(); i++){
				Entry e = entries.get(entries.size()-1-i);
				if(i == 0){
					g.setFont(new Font("Arial Hebrew", Font.BOLD, fontsize));  /* actual entry */
					g.setColor(new Color(0xffFFFFFF));
				}else{
					g.setFont(new Font("Arial Hebrew", Font.PLAIN, fontsize)); /* other entries */
					g.setColor(Color.LIGHT_GRAY);
				}
				
				g.setColor(new Color(e.getColor()));
				g.drawString(e.getText(), Game.width * Game.scale - 220, Game.height * Game.scale - 75 + logSize * 19 - i * 19);
			}
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public boolean getPermaOpen(){
		return permaOpen;
	}
	public void setPermaOpen(boolean permaOpen){
		this.permaOpen = permaOpen;
	}
}