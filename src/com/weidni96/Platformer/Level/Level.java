package com.weidni96.Platformer.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.Button;
import com.weidni96.Platformer.entities.Door;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.SlowMovingEntity;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.bullet.Bullet;
import com.weidni96.Platformer.entities.interactiveEntities.Anvil;
import com.weidni96.Platformer.entities.interactiveEntities.Bookshelf;
import com.weidni96.Platformer.entities.interactiveEntities.Chest;
import com.weidni96.Platformer.entities.interactiveEntities.Fire;
import com.weidni96.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.weidni96.Platformer.entities.interactiveEntities.Lever;
import com.weidni96.Platformer.entities.interactiveEntities.Loot;
import com.weidni96.Platformer.entities.interactiveEntities.SavePoint;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Warp;
import com.weidni96.Platformer.entities.interactiveEntities.plants.AgroilberryPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.Plant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.RolberryPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.WheatPlant;
import com.weidni96.Platformer.entities.interactiveEntities.plants.YocipPlant;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.entities.particles.particleTypes.Particle;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Middleground;
import com.weidni96.Platformer.graphics.Screen;

/**
 * width * height 2D field, here all entities and tiles are saved that are needed
 * @author Christian
 *
 */
public abstract class Level {
	
	//area level is located in and player
	protected Area area;
	protected Player player;
	
	//level size
	public int tileWidth;
	public int tileHeight;
	public int[] frontTiles, backTiles;
	
	//position in area
	protected int areaPosX;
	protected int areaPosY;
	
	//Type
	public enum levelType{ NATURE, VILLAGE, MINIGAME, HOUSE, DUNGEON, UNDERGROUND, BOSSROOM; }
	protected levelType type;
	
	//gravity
	public final double STANDARD_G = 1; 
	public double gravity 		   = 0.25; //0.25 
	public double fraction		   = 0.35; //0.35
	
	//item spawn chances
	public final int SPAWN_CHANCE 	= 200; // 100 : 1000
	public final int HEALTH_CHANCE 	= 100;
	public final int COIN_CHANCE 	= 1000;
	
	//lists:
	public List<Bullet>	  bullets 	= new ArrayList<Bullet>();
	public List<Mob>	  mobs 		= new ArrayList<Mob>();
	public List<NPC>	  npcs 		= new ArrayList<NPC>();
	public List<Entity>   hiders	= new ArrayList<Entity>();
	public List<Entity>   images	= new ArrayList<Entity>();
	public List<Entity>   warpers	= new ArrayList<Entity>();
	public List<Button>   buttons	= new ArrayList<Button>();
	public List<Door>     doors		= new ArrayList<Door>();
	public List<SlowMovingEntity> slowMovingEntities = new ArrayList<SlowMovingEntity>();
	public List<InteractiveEntity> interactiveEntities = new ArrayList<InteractiveEntity>();
	
	//Extras:
	protected Random random = new Random();
	
	//Middlegound and background (optional)
	protected Middleground middleground = null;
	
	//data for save manager, what tiles got changed
	protected HashMap<Integer, Integer> newBgTiles = new HashMap<Integer, Integer>();
	protected HashMap<Integer, Integer> newTiles = new HashMap<Integer, Integer>();
	

	/**
	 * Constructor, needed for LoadLevel
	 * @param player
	 * @param middleground
	 * @param background
	 * @param type
	 * @param area
	 */
	public Level(Player player, Middleground middleground, 
			levelType type, Area area, int areaPosX, int areaPosY){
		this.player 		= player;
		this.middleground 	= middleground;
		this.type 			= type;
		this.area 			= area;
		
		this.areaPosX = areaPosX;
		this.areaPosY = areaPosY;
		
		random = new Random();
	}
	
	/**
	 * Constructor that can be used for not loadLevels
	 * @param tileWidth
	 * @param tileHeight
	 * @param player
	 * @param type
	 */
	public Level(int tileWidth, int tileHeight, Player player, levelType type){
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		frontTiles = new int[tileWidth * tileHeight];
		this.player = player;
		this.type = type;
		random = new Random();
	}
	
	/**
	 * Render background and middleground if set
	 * @param screen
	 */
	public void renderBack(Screen screen){
		if(middleground != null) screen.renderMiddleground(0, 180, middleground);
	}
	
	/**
	 * render all tiles
	 * @param xScroll
	 * @param yScroll
	 * @param screen
	 */
	public void render(int xScroll, int yScroll, Screen screen){	
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll/8;
		int x1 = (xScroll+screen.getWidth()) / 8 + 8;
		int y0 = yScroll/8;
		int y1 = (yScroll+screen.getHeight()) / 8 + 8;
		
		//render back tiles
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				Tile bt = null;
				if((bt = TileGetterList.getBackTile(x, y, this)) != Tile.voidTile){
					bt.render(x*8, y*8, screen);
				}
			}
		}
		
		//must be here, otherwise overridden by front tiles
		for(Entity e : images) 	e.render(screen);
		
		//render front tiles
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				Tile ft = null;
				if((ft = TileGetterList.getTile(x, y, this)) != Tile.voidTile){
					ft.render(x*8, y*8, screen);
				}
			}
		}
		
		//render lists:
		for(Bullet b : bullets) 				b.render(screen);
		for(Button b : buttons) 				b.render(screen);
		for(Particle p : Particle.particles) 	p.render(screen);
		for(NPC n : npcs) 						n.render(screen);
		for(Mob m : mobs) 						m.render(screen);
		for(Entity w : warpers) 				w.render(screen);
		for(Door d : doors)						d.render(screen);
		for(SlowMovingEntity se : slowMovingEntities) se.render(screen);
		for(InteractiveEntity ie : interactiveEntities) ie.render(screen);
		
		individualRender(screen);
	}
	
	public void individualRender(Screen screen){
		
	}
	
	/**
	 * special rendering for hider that can hide paths
	 * @param screen
	 */
	public void afterRender(Screen screen){
		for(Entity e : hiders) e.render(screen);
	}
	
	/**
	 * update level, move stuff or player, interact
	 */
	public void update(){
		//if no inventory is open, update normally
		if(area == null || !area.getWorld().getSurface().getInventory().isOpen()){
			for(Bullet b : bullets) b.update();
			for(Particle p : Particle.particles) p.update();
			for(Mob m : mobs){
				m.update();
			}
			for(NPC n : npcs) n.update();
			for(SlowMovingEntity se : slowMovingEntities) se.update();
			for(InteractiveEntity ie : interactiveEntities){
				if(!(ie instanceof Plant)){
					ie.update();
				}
			}
			for(Entity i : images) i.update();
			
			AnimatedSprite.staticUpdate();
			remove();
		}
		
		//update extra stuff for individual levels
		individualUpdate();
	}
	
	/**
	 * Remove all elements whose removed value is true
	 */
	public void remove(){
		for(int i = 0; i < bullets.size(); i++){ /* Bulltes */
			if(bullets.get(i).isRemoved()) bullets.remove(bullets.get(i));
		}
		
		for(int i = 0; i < Particle.particles.size(); i++){ /* Particles */
			if(Particle.particles.get(i).isRemoved()) Particle.particles.remove(Particle.particles.get(i));
		}
		
		for(int i = 0; i < mobs.size(); i++){ /* enemies */
			if(mobs.get(i).isRemoved()) mobs.remove(mobs.get(i));
		}
		
		for(int i = 0; i < slowMovingEntities.size(); i++){ /* enemies */
			if(slowMovingEntities.get(i).isRemoved()) slowMovingEntities.remove(slowMovingEntities.get(i));
		}
		
		for(int i = 0; i <  interactiveEntities.size(); i++){
			if(interactiveEntities.get(i).isRemoved()) interactiveEntities.remove(interactiveEntities.get(i));
		}
	}

	/**
	 * Check position for mob
	 * @param x
	 * @param y
	 * @return
	 */
	public Mob getEnemyAt(int x, int y){
		for(Mob m : mobs){
			if(m.getX() <= x && m.getX() + m.getWidth() >= x && m.getY() <= y && m.getY() + m.getHeight() >= y){
				return m;
			}
		} return null;
	}
	
	/**
	 * Look for all interactive items at one position
	 * @param x
	 * @param y
	 * @return list of elements /can have size 0)
	 */
	public List<InteractiveEntity> getInteractiveEntities(int x, int y){
		List<InteractiveEntity> list = new ArrayList<InteractiveEntity>();
		
		for(InteractiveEntity i : interactiveEntities){
			if(i instanceof Sign || i instanceof Plant || i instanceof Chest || i instanceof Lever 
					|| i instanceof Warp || i instanceof SavePoint || i instanceof Bookshelf || i instanceof Fire 
					|| i instanceof Anvil){
				if(i.getX()/8 == x/8 && i.getY()/8 == y/8) list.add(i);
			}
			else if(i instanceof Loot){
				if(i.getX() <= x && i.getX() + i.getWidth() >= x && i.getY() <= y && i.getY() + i.getHeight() >= y) list.add(i);
			}
		}
		
		return list;
	}
	
	/**
	 * get an NPC at one certain location
	 * @param x
	 * @param y
	 * @return npc or null
	 */
	public NPC getNPCAt(int x, int y){
		for(NPC n : npcs){
			if(n.getX() <= x && n.getX() + n.getWidth() >= x && n.getY() <= y && n.getY() + n.getHeight() >= y) return n;
		}
		return null;
	}
	
	/**
	 * get door at certain position
	 * @param x
	 * @param y
	 * @return door or null
	 */
	public Door getDoorAt(int x, int y){ /* not triggered with SPACE -> not interactObject */
		for(Door n : doors){
			if(n.getX() <= x && n.getX() + n.getWidth() >= x && n.getY() <= y && n.getY() + n.getHeight() >= y) return n;
		}
		return null;
	}
	
	/**
	 * check if player is at (x,y)
	 * @param x
	 * @param y
	 * @return player if he is there, otherwise null
	 */
	public Player getPlayerAt(int x, int y){
		if(player.getX() <= x && player.getX() + player.getWidth() >= x && player.getY() <= y && player.getY() + player.getHeight() >= y){
			return player;
		}
		else return null;
	}
	
	/**
	 * check if there is a button at x, y
	 * @param x
	 * @param y
	 * @return button if there is one, else null
	 */
	public Button getButtonAt(int x, int y){
		for(Button b : buttons){
			if(b.getX() <= x && b.getX() + b.getWidth() >= x && b.getY() <= y && b.getY() + b.getHeight() >= y) return b;
		}
		return null;
	}
	
	/**
	 * change Tile t1 to t2
	 * @param t1
	 * @param t2
	 */
	public void changeTiles(int t1, int t2){
		for(int i = 0; i < frontTiles.length; i++){
			if(frontTiles[i] == t1){
				frontTiles[i] = t2;
			}
		}
	}
	
	/**
	 * reset a level after entering it
	 */
	public void resetLevel(){
		resetGrass();
		
		//don't reset mobs and loot from boss rooms
		if(type != levelType.BOSSROOM){
			mobs.clear();
			for(InteractiveEntity ie : interactiveEntities){
				if(ie instanceof Loot){
					ie.remove();
				}
			}
			initMobs();
		}
	}
	
	/**
	 * helping function to only reset grass that was destroyed
	 */
	private void resetGrass(){
		for(int i = 0; i < frontTiles.length; i++){
			if(frontTiles[i] == Tile.ID_destroyableGrass02){
				frontTiles[i] = Tile.ID_destroyableGrass01;
			}
			else if(frontTiles[i] == Tile.ID_destroyableGrass12){
				frontTiles[i] = Tile.ID_destroyableGrass11;
			}
		}
	}
	
	/**
	 * get input from a save file and convert it into tiles
	 * @param input
	 */
	public void initTilesFromSaveFile(String input){
		if(input.trim().length() == 0) return;
		String[] split = input.split(" ");
		
		try{
			for(int i = 0; i < split.length-1; i+=2){
				int pos = Integer.parseInt(split[i]);
				int id = Integer.parseInt(split[i+1]);
				
				setTile(pos, id);
			}
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: Tiles for level could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load tiles for level...");
		}
	}
	
	/**
	 * get input from a save file and convert it into BG tiles
	 * @param input
	 */
	public void initBgTilesFromSaveFile(String input){
		if(input.trim().length() == 0) return;
		String[] split = input.split(" ");
		
		try{
			for(int i = 0; i < split.length-1; i+=2){
				int pos = Integer.parseInt(split[i]);
				int id = Integer.parseInt(split[i+1]);
				
				setBGTile(pos, id);
			}
		}catch(NumberFormatException nfe){
			System.err.println("Corrupted Save File: BGTiles for level could not be loaded...");
		}catch(Exception e){
			System.err.println("Could not load BGtiles for level...");
		}
	}
	
	/**
	 * create a string with everything every level must save
	 * @return
	 */
	public ArrayList<String> createSaveString(){
		ArrayList<String> save = new ArrayList<String>();
		
		String pos = "*l";
		pos += area.worldPosX + " " + area.worldPosY + " ";
		pos += areaPosX + " " + areaPosY;
		save.add(pos);
		
		String nTiles = "*T";
		for(Integer key : newTiles.keySet()){
			nTiles += key + " " + newTiles.get(key) + " ";
		}
		save.add(nTiles);
		
		String nBgTiles = "*t";
		for(Integer key : newBgTiles.keySet()){
			nTiles += key + " " + newBgTiles.get(key) + " ";
		}
		save.add(nBgTiles);
		
		String extra = individualSave();
		save.add(extra);
		
		//Load plants
		
		for(InteractiveEntity ie : interactiveEntities){
			String plant = "";
			if(ie instanceof Plant){
				Plant p = (Plant)ie;

				if(p instanceof AgroilberryPlant) plant += "agroilberry";
				else if(p instanceof RolberryPlant) plant += "rolberry";
				else if(p instanceof WheatPlant) plant += "wheat";
				else if(p instanceof YocipPlant) plant += "yocip";
				
				
				plant += " " + p.getGrowState() + " " + p.getTimer() + " ";
				if(p.isRipe()) plant += "t";
				else plant += "f";
				save.add(plant);
			}
		}

		return save;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getHeight(){
		return tileHeight*8;
	}
	public int getWidth(){
		return tileWidth*8;
	}
	public int[] getBackTiles(){
		return backTiles;
	}
	public int[] getFrontTiles(){
		return frontTiles;
	}
	public int getTileWidth(){
		return tileWidth;
	}
	public int getTileHeight(){
		return tileHeight;
	}
	public Area getArea(){
		return area;
	}
	public Player getPlayer(){
		return player;
	}
	public levelType getType(){
		return type;
	}
	public List<Door> getDoors(){
		return doors;
	}
	public int getAreaPosX(){
		return areaPosX;
	}
	public int getAreaPosY(){
		return areaPosY;
	}
	public HashMap<Integer, Integer> getNewTiles(){
		return newTiles;
	}
	public HashMap<Integer, Integer> getNewBgTiles(){
		return newBgTiles;
	}
	
	public void setTile(int i, int ID){
		frontTiles[i] = ID;
		newTiles.put(i, ID);
	}
	public void setTile(int x, int y, int ID){
		frontTiles[x + y * tileWidth] = ID;
		newTiles.put(x + y * tileWidth, ID);
	}
	public void setBGTile(int x, int y, int ID){
		backTiles[x + y * tileWidth] = ID;
		newBgTiles.put(x + y * tileWidth, ID);
	}
	public void setBGTile(int i, int ID){
		backTiles[i] = ID;
		newBgTiles.put(i, ID);
	}
	
	public abstract void individualSaveFileLoad(String input);
	public abstract String individualSave();
	protected abstract void initMobs();
	protected abstract void initNPCs();
	protected abstract void initSurroundings(); /* images ; interactive items ; hider */
	protected abstract void individualUpdate();
	
	
	public void addBullet(Bullet b)		{ bullets.add(b); }
	public void addButton(Button b)		{ buttons.add(b); }
	public void addParticle(Particle p)	{ Particle.particles.add(p); }
	public void addMob(Mob m)			{ mobs.add(m); }
	public void addImage(Entity i)		{ images.add(i); }
	public void addDoor(Door d)			{ doors.add(d); }
	public void addSlowMovingEntity(SlowMovingEntity se) { slowMovingEntities.add(se); }
	public void addInteractiveEntity(InteractiveEntity ie) { interactiveEntities.add(ie); }
}