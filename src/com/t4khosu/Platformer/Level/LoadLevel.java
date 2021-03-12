package com.t4khosu.Platformer.Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.t4khosu.Platformer.graphics.Middleground;
import com.t4khosu.Platformer.entities.player.Player;

public abstract class LoadLevel extends Level{

	protected String path_backTiles;
	protected String path_frontTiles;
	
	/**
	 * Constructor
	 * @param player
	 * @param middleground
	 * @param background
	 * @param frontTiles
	 * @param backTiles
	 * @param type
	 * @param area
	 */
	public LoadLevel(Player player, Middleground middleground,
			String frontTilePath, String backTilePath, levelType type, Area area, int areaPosX, int areaPosY) {
		super(player, middleground, type, area, areaPosX, areaPosY);
		
		this.path_frontTiles = frontTilePath;
		this.path_backTiles = backTilePath;
		generate();
		
		initMobs();
		initNPCs();
		initSurroundings();
	}
	
	/**
	 * generate an array that saves the whole map as colorMap
	 */
	private void generate(){
		try {
			BufferedImage image = ImageIO.read(LoadLevel.class.getResource(path_frontTiles));
			BufferedImage image2 = ImageIO.read(LoadLevel.class.getResource(path_backTiles));
			
			tileWidth = image.getWidth();
			tileHeight = image.getHeight();
			
			frontTiles = new int[tileWidth * tileHeight];
			backTiles  = new int[tileWidth * tileHeight];
			
			image.getRGB(0, 0, tileWidth, tileHeight, frontTiles, 0, tileWidth);
			image2.getRGB(0, 0, tileWidth, tileHeight, backTiles, 0, tileWidth);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	protected abstract void initMobs();
	protected abstract void initNPCs();
	protected abstract void initSurroundings();
	protected abstract void individualUpdate();
}