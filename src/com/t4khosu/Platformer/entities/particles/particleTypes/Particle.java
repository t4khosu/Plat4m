/**
 * created a normal particle with standard gravity influence
 */

package com.t4khosu.Platformer.entities.particles.particleTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.mob.Mob;

public abstract class Particle extends Entity{
	
	public static List<Particle> particles = new ArrayList<Particle>();
	protected int    life;
	protected double vFall;
	protected double dirX;
	protected double dirY;
	protected double speed;
	protected int    damage;
	protected Random random;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public Particle(int x, int y, Level level) {
		super(x, y);
		initLevel(level);
		
		random = new Random();
		life   = 40 + random.nextInt(20);
		vFall  = -1.0;
		damage = 1;
		speed  = random.nextGaussian();
		dirX   = 0;
	}
	
	/**
	 * move to next position, influenced by gravity and speed
	 */
	protected void move(){
		if(vFall < 0) dirY = -1;
		else dirY = 1;
		
		if(dirX > -1 && dirX < 1){
			dirX += speed;
		}else{
			x += dirX;
			dirX = 0;
		}
		for(int i = 0; i < Math.abs(vFall); i++){
			if(life > 0 && !collision()){
				y += dirY;
			}
		}
		vFall += (level.gravity)/2.0;
	}
	
	/**
	 * check if there is a collision
	 * @return result
	 */
	protected boolean collision(){
		int xx = x / 8;
		int yy = (y + sprite.getHeight()) / 8;
		
		
		Mob m = null;
		if((m = level.getEnemyAt(xx, yy)) != null){
			life = 0;
			m.hit(damage);
			return true;
		}
		if(TileGetterList.getTile(xx, yy, level).isSolid() || TileGetterList.getTile(xx, yy, level).isPartlySolid()){
			if(vFall > 0){
				life = 0;
				return true;
			}
			else{
				vFall = 0.5;
				y += 2;
			}
		}
		return false;
	}
	
	/**
	 * update particle, delete or move it
	 */
	public void update(){
		if(life <= 0) remove();
		else life--;
		move();
	}
}