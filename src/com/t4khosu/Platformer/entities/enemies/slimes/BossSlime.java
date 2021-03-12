package com.t4khosu.Platformer.entities.enemies.slimes;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.tile.Tile;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.bullet.mobBullet.BossSlimeBullet;
import com.t4khosu.Platformer.graphics.Sprite;

public class BossSlime extends Slime{

	
	private int jumpCount = 0;
	private int state = 0;
	private int maxLife;
	
	private boolean shooting = false;
	
	public BossSlime(int x, int y, Level level) {
		super(x, y, Sprite.blossSlime_0, level);
	
		actTime 	= 60;
		jumpForce = -4.5;
		
		sprites[0] = Sprite.blossSlime_0;
		sprites[1] = Sprite.blossSlime_1;
		sprites[2] = Sprite.blossSlime_2;
		
		this.name 		= "Grosser Schleim";
		collisionDamage = 25;
		experience 		= 4270;
		money 			= 1000;
		lvl 			= 15;
		shield 			= 3;
		speed 			= 1;
		
		initLife(100);
	}

	@Override
	public void moveAlgorithm() {
		if(jumpCount < 6){
			if(bottomCollision()){
				jumpCount++;
				msm.setJumping(true);
				if(world.getPlayer().getX() < this.x){
					nx = -1;
				}else{
					nx = 1;
				}
			}else{
				timer = nextActionTime();
			}
		}else{
			jumpCount = 0;
			shoot();
		}
	}
	
	@Override
	public void aliveUpdate(){
		//jumping movement while jumping
		jump();
		
		//sprite check
		if(!bottomCollision()){
			sprite = sprites[2];
			falling();
			msm.setJumping(false);
		}else{
			sprite = sprites[1];
			nx = 0;
		}
		
		//move to direction nx
		if(nx != 0) move(nx * speed);

		//gets hit by laser, do nothing
		if(checkLaserCollision()){
			hit(20);
			if(life <= 0){ 	/* die if no life */
				if(!msm.isDead()) die(world.getPlayer());
			}
			return;
		}
		
		//change speed after life < 2/3
		if(state == 0 && life <= (max_life*2)/3){
			state++;
			actTime = 40;
			jumpForce = -5.0;
		}
		
		//change speed after life < 1/3
		if(state == 1 && life <= (max_life)/3){
			state++;
			actTime = 35;
			speed = 2;
			jumpForce = -4.5;
		}
		
		//go to next action
		if(timer >= nextActionTime){
			timer = 0;
			nextActionTime = nextActionTime();
			moveAlgorithm(); /* do one specific thing */
		}
	}
	
	private boolean checkLaserCollision(){
		for(int c = 0; c < 4; c++){
			int xx = (x + c%2 * width) / 8;
			int yy = (y + c/2 * height) / 8;
			if(TileGetterList.getTile(xx, yy, level) == Tile.laserTile){
				return true;
			}
		}
		return false;
	}
	
	public void shoot() {
		level.addBullet(new BossSlimeBullet(x-8, y-8, -1, -1, level));
		level.addBullet(new BossSlimeBullet(x+width, y-8, 1, -1, level));
		level.addBullet(new BossSlimeBullet(x+width, y+width, 1, 1, level));
		level.addBullet(new BossSlimeBullet(x-8, y+height, -1, 1, level));
		
		if(state > 0){
			level.addBullet(new BossSlimeBullet(x-8, y+(height/2) - Sprite.boss_bullet_sprite.getHeight()/2, -1, 0, level));
			level.addBullet(new BossSlimeBullet(x+width, y+(height/2) - Sprite.boss_bullet_sprite.getHeight()/2, 1, 0, level));
		}
	}
}
