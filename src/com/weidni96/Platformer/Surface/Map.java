package com.weidni96.Platformer.Surface;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Screen;

/**
 * pixel sized map
 * @author Christian
 *
 */
public class Map {
	
	private Player player;
	public Level level;
	private String path;
	private int width, height;
	private int[] pixels;
	private boolean visible = false;
	
	/**
	 * Constructor
	 * @param player
	 * @param level
	 */
	public Map(Player player, Level level){
		this.level = level;
		this.path = "";
		this.player = player;
		load();
	}
	
	/**
	 * load the map by reading the level file
	 */
	private void load(){
		try {
			if(!path.equals("")){
				BufferedImage image = ImageIO.read(LoadLevel.class.getResource(path));
				width = image.getWidth();
				height = image.getHeight();
				pixels = new int[width * height];
				image.getRGB(0, 0, width, height, pixels, 0, width);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * render Map
	 * @param screen
	 */
	public void render(Screen screen){
		if(visible){
			screen.renderMap(this, level);
		}
		
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int[] getPixels(){
		return pixels;
	}
	public Player getPlayer(){
		return player;
	}
	public boolean isVisible(){
		return visible;
	}
	
	public void setVisibility(boolean visibility){
		visible = visibility;
	}
}