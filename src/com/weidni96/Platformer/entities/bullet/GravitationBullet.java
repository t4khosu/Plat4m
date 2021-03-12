package com.weidni96.Platformer.entities.bullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.mob.Mob;

public class GravitationBullet extends Bullet{

	protected double vFall;	
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param dirX
	 * @param level
	 */
	public GravitationBullet(int x, int y, int dirX, Level level) {
		super(x, y, dirX, level);
		vFall = 0.5;
	}
	
	/**
	 * move into direction, influenced by gravity
	 */
	public void move(){
		if( vFall < 0) dirY = -1;
		else dirY = 1;
		vFall += level.gravity;
		
		if(dirX != 0){
			for(int i = 0; i < speed; i++){
				if(life > 0 && !collision(x + dirX, y + dirY)){
					x += dirX;
				}else{
					dirX = 0;
					break;
				}
			}
		}
		
		for(int j = 0; j < Math.abs(vFall); j++){
			if(life > 0 && !collision(x, y + dirY)){
				y += dirY;
			}else break;
		}
	}
	
	/**
	 * collision with enemy or wall
	 * @param nx
	 * @param ny
	 * @return
	 */
	protected boolean collision(int nx, int ny){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 4) + c%2) / 8;
			yy = ((ny + 3) + c/2) / 8;
			
			Mob m = null;
			if(TileGetterList.getTile(xx, yy, level).isSolid() || (m = level.getEnemyAt(xx, yy)) != null){ 
				if(m != null){
					m.hit(damage);
				}
				if(!isBottomResistant()) life = 0;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * can fall through floor
	 * @return
	 */
	protected boolean isBottomResistant(){
		return false;
	}
}
