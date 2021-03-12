/**
 * mobs are entities that can move and do stuff (e.g. npcs)
 */

package com.t4khosu.Platformer.entities.mob;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.LootGenerator;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.player.Player;

public abstract class Mob extends Entity {
	
	protected World world;
	
	protected int dirX				= 1;
	protected int dirY				= 0;
	protected int timer				= 0;
	
	protected double jumpForce 		= -5.5;
	protected String name 			= "standard mob";
	protected int speed    			= 0;
	protected int crawlY 			= 0;
	protected double pushBackForce	= 0;
	
	protected int jumpCount = 1;
	protected int maxJumpCount = 1;
	
	protected int max_life;
	protected int life;
	protected int lvl = 1;
	protected int shield;
	
	protected int collisionDamage = 0; /*player has collition with this mob */
	protected int experience 	  = 20; /*player kills mob and gets... */
	protected int money			  = 1;
	protected int lootID;
	
	protected MobStatusManager msm;
	protected MobTimerManager  mtm;
	
	protected boolean jumpTo = false;
	
	/**
	 * constructor
	 * @param x position
	 * @param y position
	 * @param sprite as start sprite for rendering
	 */
	public Mob(int x, int y, Sprite sprite, Level level) {
		super(x, y, sprite);
		msm = new MobStatusManager(this);
		mtm = new MobTimerManager(this);
		initLife(10);
		lootID = Item.money_ID;
		
		//For NPCs in Manager Class, otherwise error occurs
		if(level != null){
			initLevel(level);
		}
	}
	
	/**
	 * constructor, level must be initiated seperately
	 * @param x position
	 * @param y position
	 * @param sprite as start sprite for rendering
	 */
	public Mob(int x, int y, Sprite sprite) {
		super(x, y, sprite);
		msm = new MobStatusManager(this);
		mtm = new MobTimerManager(this);
		initLife(10);
	}
	
	public Mob(int x, int y, Level level) {
		super(x, y);
		initLevel(level);
		msm = new MobStatusManager(this);
		mtm = new MobTimerManager(this);
		initLife(10);
	}
	
	/**
	 * Move in x direction a width of steps
	 * @param steps = pixels 
	 */
	public void moveX(int steps){ /* nx steps */
		if(steps < 0) dirX = -1;
		else dirX = 1;
		
		for(int i = 0; i < Math.abs(steps); i++){
			if(!sideCollision(dirX)){
				x += dirX;
			}
		}
	}
	
	/**
	 * Move in y direction a width of steps
	 * @param steps = pixels
	 */
	public void moveY(int steps){
		if(steps < 0) dirY = -1;
		else dirY = 1;
		
		for(int i = 0; i < Math.abs(steps); i++){
			if(!topCollision()){
				y += dirY;
			}
		}
	}
	
	protected double vFall 	= 0;
	/**
	 * if there is no floor, player falls with gravity of this level
	 */
	protected void falling(){
		if(!world.canMove()) return;
			msm.setJumping(false);
			
			for(int i = 0; i < Math.abs((int)vFall); i++){
				if(vFall > 0 && !bottomCollision()){
					//fall down
					dirY = 1;
					y++;
				}
				else if(vFall <= 0){
					if(!topCollision()){
						//jump up
						dirY = -1;
						y--;
					}else{
						vFall = level.STANDARD_G;
					}
				}
			}
			vFall += level.gravity;	
	}
	
	/**
	 * check if there is a bottom collision
	 * @return result
	 */
	public boolean bottomCollision(){
		
		int bottom = y + height - 1;
		int right  = x + width - 1;
		
		int y0 = (bottom + 1) / 8; //tile beneath mob
		int x0 = x / 8;
		int x1 = right / 8;
		
		
		 //normal block collision
		if(TileGetterList.getTile(x0, y0, level).isSolid() || TileGetterList.getTile(x1, y0, level).isSolid()){
			dirY = 1;
			return true;
		}
		
		//Part collision left side
		if(TileGetterList.getTile(x0, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x0, y0, level).getSolidFrame();
			int tileCoord = x0 * 8;
			
			for(int i = 0; i < width; i++){
				if(x + i > tileCoord + s[0][0] && x + i < tileCoord + s[1][0]){
					if(bottom + 1 >= y0 * 8 + s[0][1]){
						dirY = 1;
						return true;
					}
				}
			}
		}
		
		//Part collision right side
		if(TileGetterList.getTile(x1, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x1, y0, level).getSolidFrame();
			int tileCoord = x1 * 8;
			
			for(int i = 0; i < width; i++){
				if((x + i > tileCoord + s[0][0] && x + i < tileCoord + s[1][0])){
					if(bottom + 1 >= y0 * 8 + s[0][1]){
						dirY = 1;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Check if there is a top collision
	 * @return result
	 */
	protected boolean topCollision(){
		
		int right  = x + width - 1;
		int y0 = (y - 1) / 8; // tile about mob
		
		int x0 = x / 8;
		int x1 = right / 8;
		
		
		if(TileGetterList.getTile(x0, y0, level).isSolid() || TileGetterList.getTile(x1, y0, level).isSolid() ||
				TileGetterList.getTile(x0, y0, level).forcesDown() || TileGetterList.getTile(x1, y0, level).forcesDown()){
			return true;
		}
		
		//Part collision left side
		if(TileGetterList.getTile(x0, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x0, y0, level).getSolidFrame();
					
			for(int i = 0; i < width; i++){
				if((x + i >  x0 * 8 + s[3][0] && x + i < x0 * 8 + s[2][0])){
					if(y - 1 <= (y0 * 8) + s[3][1]){ 
						dirY = 1;
						return true;
					}
				}
			}
		}
						
		//Part collision right side
		if(TileGetterList.getTile(x1, y0, level).isPartlySolid()){
			int[][] s = TileGetterList.getTile(x1, y0, level).getSolidFrame();
							
			for(int i = 0; i < width; i++){
				if((x + i >  x1 * 8 + s[3][0] && x + i < x1 * 8 + s[2][0])){
					if(y - 5 <= (y0 * 8) + s[3][1]){
						dirY = 1;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Check if there is a side collision
	 * @param dirX -1 = left, 1 = right
	 * @return
	 */
	protected boolean sideCollision(int dirX){
		
		int bottom = y + height - 1;
		int right  = x + width - 1;
		
		int y0 = y / 8;
		int y1 = bottom / 8;
		int x0;
		
		if(dirX < 0) x0 = (x + dirX) / 8;
		else		 x0 = (right + dirX) / 8;
		
		if(TileGetterList.getTile(x0, y0, level).isSideSolid(dirX) || TileGetterList.getTile(x0, y1, level).isSideSolid(dirX)){
				return true;
		}
		
		if(TileGetterList.getTile(x0, y0, level).isSolid() || TileGetterList.getTile(x0, y1, level).isSolid()){
			return true;
		}
		
		//Part collision
		if(TileGetterList.getTile(x0, y0, level).isPartlySolid() || TileGetterList.getTile(x0, y1, level).isPartlySolid()){
			int[][] s1 = TileGetterList.getTile(x0, y0, level).getSolidFrame();
			int[][] s2 = TileGetterList.getTile(x0, y1, level).getSolidFrame();
			
			int nextTile = x0 * 8;
			if(bottom >= y0 * 8 + s1[0][1] && bottom >= y1 * 8 + s2[0][1]){
				if(dirX < 0){
					if(TileGetterList.getTile(x0, y0, level).isPartlySolid()){
						if(y + crawlY <= y0 * 8 + s1[3][1]){
							if(x <= (nextTile + s1[1][0])) return true;
							if(x <= (nextTile + s2[2][0])) return true;
						}
					}else{
						if(x <= (nextTile + s1[1][0])) return true;
						if(x <= (nextTile + s2[2][0])) return true;
					}
					
				}
				else{
					if(TileGetterList.getTile(x0, y1, level).isPartlySolid()){
						if(y + crawlY <= y1 * 8 + s1[3][1]){
							if((nextTile + s1[0][0]) <= x + width + 1) return true;
							if((nextTile + s2[3][0]) <= x + width + 1) return true;
						}
					}else{
						if((nextTile + s1[0][0]) <= x + width + 1) return true;
						if((nextTile + s2[3][0]) <= x + width + 1) return true;
					}
					
				}
			}
		}
		return false;
	}
	
	/**
	 * Check on what floor mob is at this moment
	 */
	protected void checkTile(){
		msm.underWaterAt(x+4, y+4);
		msm.isSlowedAt(x+4, y+4);
		msm.canClimbAt(x+4, y+4);
	}
	
	/**
	 * make mob jump if there is a floor
	 */
	public void jump(){
		if(msm.isJumping() && (bottomCollision() || jumpCount > 0)){ /*jumping and on floor */
			jumpCount--;
			double div = 1.0;
			if(jumpCount == 0 && maxJumpCount != 1){
				div = 0.8;
			}
			if(msm.isUnderWater() || TileGetterList.getTile(x/8, y/8, level).slows()){
				vFall = jumpForce/1.5;
			}else{
				vFall = jumpForce;
			}
			vFall *= div;
			falling();
		}
	}
	/**
	 * test if player at this position
	 * @param xc
	 * @param yc
	 * @return result
	 */
	public boolean collision(int xc, int yc){
		if(xc >= x && xc <= x + width){
			if(yc >= y && yc <= y + height){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * if mob is not invincible, it gets hit
	 * @param player
	 * @param sword
	 */
	public void getsHitBy(Player player, Item sword){
		if(!mtm.getInvincibleTimer().isActive()){
			int damage = 0;
			if(lvl > player.getLvl()){
				damage = (sword.getDamage() + player.getStrength())/2;
			}else{
				damage = sword.getDamage() + player.getStrength();
			}
			damage -= shield;
			if(damage <= 0) damage = 0;
			hit(damage);
					
			if(life <= 0){ 	/* die if no life */
				if(!msm.isDead()) die(player);
			}else{			/* pushed back */
				if(msm.isPushable()){
					msm.setGotPushed(true);
					calculatePushforce(player.getDirX(), 3); //TODO force is calculated with weapon strength
				}
			}
			
			mtm.getInvincibleTimer().start();
		}
	}
	
	/**
	 * hit mob with certain damage
	 * @param damage
	 */
	public void hit(int damage){
		if(!mtm.getInvincibleTimer().isActive() && !world.getSurface().getInventory().isOpen()){
			life -= damage;
			mtm.getInvincibleTimer().start();
		}
	}
	
	/**
	 * mob dies, give player loot
	 * @param player
	 */
	public void die(Player player){
		LootGenerator lg = new LootGenerator(this);
		lg.randomLoot();
		
		msm.setDead(true);
		
		player.addLogEntry("| " + name + ": " + experience + "Exp, " + money + "G", 0xffFFFFFF);
		player.addExperience(experience);
		player.addRul(money);
	}
	
	/**
	 * poison mob
	 */
	public void poison(){
		mtm.getPoisonedTimer().start();
	}
	
	/**
	 * calculate pushforce for a mob if pushed
	 * @param dirX
	 * @param force
	 */
	public void calculatePushforce(int dirX, int force){
		pushBackForce = dirX * force;
	}
	
	/**
	 * only blink when invincible timer is true
	 */
	public void blinkManager(){
		if(mtm.getInvincibleTimer().isActive()){
			msm.blink();
		}else{
			msm.stopBlinking();
		}
	}
	
	/**
	 * general update for mob	
	 */
	public void update(){
		if((world.canMove())){
			mtm.updateTimers();
			if(!msm.isDead()){
				blinkManager();
				aliveUpdate();
			}else{
				deadUpdate();
			}
		}
	}
	
	/**
	 * update when alive
	 */
	public void aliveUpdate(){
	}
	
	/**
	 * update when dead
	 */
	public void deadUpdate(){
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		if(msm.getBlinkON()){
			screen.renderNewHSB(x, y, sprite, true, 1.0f, 0.5f);
		}else{
			screen.renderSprite(x, y, sprite, true);
		}
		
		if(life < max_life && !msm.isDead()){ /* lost life -> show lifebar */
			screen.renderLifeBar(x, y-2, life, max_life, sprite.getWidth(), 1, true);
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setDirX(int dirX){
		this.dirX = dirX;
	}
	public void setDirY(int dirY){
		this.dirY = dirY;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public void setMaxLife(int max_life){
		this.max_life = max_life;
	}
	public void setMobTimer(int mobTimer){
		this.timer = mobTimer;
	}
	public void initLife(int max_life){
		this.max_life = max_life;
		this.life = max_life;
	}
	public void setJumpCount(int jumpCount){
		this.jumpCount = jumpCount;
	}
	public void setMaxJumpCount(int maxJumpCount){
		this.maxJumpCount = maxJumpCount;
	}
	public void setLvl(int lvl){
		this.lvl = lvl;
	}
	public void initLevel(Level l){
		this.level = l;
		this.world = l.getArea().getWorld();
	}
	
	public int getDirX(){
		return dirX;
	}
	public int getDirY(){
		return dirY;
	}
	public int getSpeed(){
		return speed;
	}
	public int getCollisionDamage(){
		return collisionDamage;
	}
	public MobStatusManager getMSM(){
		return msm;
	}
	public MobTimerManager getMTM(){
		return mtm;
	}
	public World getWorld(){
		return world;
	}
	public int getMobTimer(){
		return timer;
	}
	public int getMaxLife(){
		return max_life;
	}
	public int getLife(){
		return life;
	}
	public int getJumpCount(){
		return jumpCount;
	}
	public String getName(){
		return name;
	}
	public int getLvl(){
		return this.lvl;
	}
	public int getShield(){
		return shield;
	}
	public int getLootID(){
		return lootID;
	}
}