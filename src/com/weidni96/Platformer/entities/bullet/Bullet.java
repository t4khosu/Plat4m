package com.weidni96.Platformer.entities.bullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.mob.Mob;

public class Bullet extends Entity{
	
	protected int dirX = 0;
	protected int dirY = 0;
	protected int speed;
	public int fireRate;
	protected int life;
	protected int damage;
	
	protected Level level;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dirX
	 * @param level
	 */
	public Bullet(int x, int y, int dirX, Level level) {
		super(x, y);
		this.level = level;
		this.dirX = dirX;
		
		damage   = 2;
		speed    = 4;
		fireRate = 20;
	}
	
	/**
	 * check for collision at next nx
	 * @param nx
	 * @return
	 */
	protected boolean collision(int nx){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 3) + c%2 * 4) / 8;
			yy = ((y  + 3) + c/2 * 4) / 8; 
			
			Mob m = null;	
			if(TileGetterList.getTile(xx, yy, level).isSolid() || (m = level.getEnemyAt(xx, yy)) != null){
				if(m != null){
					m.hit(damage);
				}
				life = 0;
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * move with speed in direction
	 */
	public void move(){
		for(int i = 0; i < speed; i++){
			if(life > 0 && !collision(x+dirX)){
				x += dirX;
			}else{
				break;
			}
		}
	}
	
	/**
	 * update bullet
	 */
	public void update(){
		if(life <= 0) remove();
		else life--;
		
		move();
	}
}
