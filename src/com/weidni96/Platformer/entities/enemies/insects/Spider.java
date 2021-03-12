package com.weidni96.Platformer.entities.enemies.insects;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public abstract class Spider extends Mob{

	protected final int STARTY;
	protected AnimatedSprite as;
	protected int bulletSpawnSpeed = 80;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 * @param world
	 */
	public Spider(int x, int y, Level level) {
		super(x, y, Sprite.brown_spider_1, level);
		this.speed = 2;
		STARTY = y;
	}
	
	/**
	 * shooting method must be implemented by every spider
	 */
	public abstract void shoot();
	
	/**
	 * moving up and down
	 * @param ny
	 */
	public void move(int ny){
		y += ny;
	}
	
	/**
	 * check if there are blocks between player and this
	 * @return result
	 */
	public boolean blocksInWay(){
		for(int i = STARTY/8; i < level.getPlayer().getY()/8; i++){
			if(TileGetterList.getTile(x/8, i, level).isSolid()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * do stuff when alive
	 */
	public void aliveUpdate(){
		int ny = 0;
		
		if(y == level.getPlayer().getY()-4 && (level.getPlayer().getX()/8 == x/8  || (level.getPlayer().getX() + 7)/ 8 == x/8)){
			as.update(); /* animate */
		}
		else if((level.getPlayer().getX()/8 == x/8  || (level.getPlayer().getX() + 7)/ 8 == x/8) && y < level.getPlayer().getY()-4){
			ny = speed;
			as.update(); /* move down */
		}else if(STARTY != y){
			ny = -speed/2; /* move back up */
			as.update();
		}else{
			as.setFrame(0);
		}
		
		if(!blocksInWay()){
			move(ny);
			if(y < STARTY){
				y = STARTY;
			}
		}
		
		shoot();
	}
	
	/**
	 * do stuff when dead
	 */
	public void deadUpdate(){
		remove();
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		sprite = as.getSprite();
		if(STARTY != y){  /* line */
			for(int i = 0; i < Math.abs(STARTY-y); i++){
				screen.renderPixel(x+4, STARTY+i, 0xffDDDDDD, true);
			}
		}
		
		if(msm.getBlinkON()){ /* blinking */
			screen.renderNewHSB(x, y, sprite, true, 1.0f, 0.5f);
		}else{
			screen.renderSprite(x, y, sprite, true);
		}
		
		if(life < max_life){ /* life bar */
			screen.renderLifeBar(x, y-2, life, max_life, sprite.getWidth(), 1, true);
		}
	}
}