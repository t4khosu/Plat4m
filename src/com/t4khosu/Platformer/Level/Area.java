package com.t4khosu.Platformer.Level;

import java.awt.Graphics;
import java.util.Random;

import com.t4khosu.Platformer.graphics.Background;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.player.Player;

public abstract class Area {
	
	//World this area is part of and player
	protected World world;
	protected Player player;
	
	//With and height of area in rooms/levels and actual selected level
	protected int width;
	protected int height;
	protected Level[] levels;
	
	//position in world
	protected int worldPosX;
	protected int worldPosY;
	
	protected Level actualLevel;
	protected int actualLevelX;
	protected int actualLevelY;
	
	//Name of area
	protected String name;
	
	//Random object
	protected Random random;
	
	//Weather (rain)
	protected boolean canRain;
	protected boolean canSnow;
	
	protected int wait = 0;
	
	//sprite when entering
	protected Sprite areaSprite;
	
	protected Background background = null;
	
	/**
	 * Constructor
	 * Attributes like width, height and name are
	 * declared inside the specific areas, like "Neuleben" etc.
	 * @param world
	 * @param worldPosX
	 * @param worldPosY
	 */
	public Area(World world, int worldPosX, int worldPosY){
		this.world 		= world;
		this.player 	= world.getPlayer();	
		this.worldPosX 	= worldPosX;
		this.worldPosY 	= worldPosY;
		this.areaSprite = Sprite.areaSign_neuleben;
		
		this.random = new Random();
	}
	
	/**
	 *  Render actual level, player and inventory of player if open 
	 * @param xOff
	 * @param yOff
	 * @param screen
	 */
	public void render(int xOff, int yOff, Screen screen){
		if(background != null) screen.renderBackground(0, 0, background);
		actualLevel.renderBack(screen);
		if(world.getWeather() != null){
			if(actualLevel.getType() != Level.levelType.UNDERGROUND) world.getWeather().render(screen);
		}
		
		actualLevel.render(xOff, yOff, screen);
		player.render(screen);
		actualLevel.afterRender(screen);
	}
	
	/**
	 * Render letters/numbers of graphic component
	 * @param g
	 */
	public void render(Graphics g){	
	}
	
	/**
	 * Update player, level and rain (raindrops) is there is rain. Calculate next rain if time is up and remove rain
	 */
	public void update(){
		
		if(wait == 0){
			player.update();
			actualLevel.update();
		}else wait--;
		
		individualUpdate();
	}
	
	/**
	 * set wait timer for update
	 * @param time
	 */
	public void wait(int time){
		this.wait = time;
	}
	
	public void resetArea(){
		for(Level l : levels){
			if(l != null) l.resetLevel();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Level getActualLevel(){
		return actualLevel;
	}
	public World getWorld(){
		return world;
	}
	public Level getLevel(int i){
		return levels[i];
	}
	public Level getLevel(int x, int y){
		return levels[x + width * y];
	}
	public Level[] getLevels(){
		return levels;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public String getName(){
		return name;
	}
	public int getWorldPosX(){
		return worldPosX;
	}
	public int getWorldPosY(){
		return worldPosY;
	}
	public Player getPlayer(){
		return player;
	}
	public int getActualLevelX(){
		return actualLevelX;
	}
	public int getActualLevelY(){
		return actualLevelY;
	}
	public Sprite getAreaSprite(){
		return areaSprite;
	}
	
	public void setActualLevel(Level level){
		this.actualLevel = level;
		this.actualLevelX = level.getAreaPosX();
		this.actualLevelY = level.getAreaPosY();
		player.initLevel(this.actualLevel);
	}
	public void setActualLevel(int x, int y){
		Level l = levels[x + y * width];
		this.actualLevel = l;
		this.actualLevelX = l.getAreaPosX();
		this.actualLevelY = l.getAreaPosY();
		player.initLevel(l);
	}
	public void setLevel(int i, Level level){
		levels[i] = level;
	}
	
	public void initBackground(Area tempArea) {
		if(tempArea.getBackground() != null){
			float[] bgInformation = tempArea.getBackground().getDarkerAttributes();
			background.darker(bgInformation[0], bgInformation[1]);
		}	
	}
	
	public Level levelLeft(){
		if(actualLevelX > 0){
			return levels[actualLevelX-1 + width * actualLevelY];
		}
		return null;
	}
	public Level levelRight(){
		if(actualLevelX < width-1){
			return levels[actualLevelX+1 + width * actualLevelY];
		}
		return null;
	}
	
	public Level getLevelY(int dirY){
		if(dirY == -1 && actualLevelY > 0 || dirY == 1 && actualLevelY < height-1){
			return levels[actualLevelX + width * (actualLevelY+dirY)];
		}
		return null;
	}
	public Background getBackground(){
		return background;
	}
	
	protected abstract void individualUpdate();
	protected abstract void initLevels();

	
}