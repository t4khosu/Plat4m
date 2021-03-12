package com.t4khosu.Platformer.entities.item.mainItems.tools;

import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.bullet.Bullet;
import com.t4khosu.Platformer.entities.bullet.ExplosiveBullet;
import com.t4khosu.Platformer.entities.bullet.FireBullet;
import com.t4khosu.Platformer.entities.bullet.IceBullet;
import com.t4khosu.Platformer.entities.bullet.SniperBullet;
import com.t4khosu.Platformer.entities.bullet.StandardBullet;
import com.t4khosu.Platformer.entities.player.Player;

public abstract class Gun extends Item {
	
	public enum BulletType{
		STANDARD, ICE, FIRE, SNIPER, EXPLOSIVE;
	}
	
	protected Player player;
	protected BulletType bulletType;
	protected int fireRate;
	
	/**
	 * constructor
	 * @param player
	 */
	public Gun(Player player) {
		this.player = player;
		this.bulletType = BulletType.STANDARD;
		this.fireRate = 0;
	}
	
	/**
	 * create bullet depending on type and shoot
	 */
	public void shoot(){
		Bullet bullet, bullet2 = null;
		
		switch(bulletType){
			case STANDARD:
				bullet = new StandardBullet(player.getX() + (player.getDirX() * 4), y, player.getDirX(), level);
				break;
			case ICE:
				bullet = new IceBullet(player.getX() + (player.getDirX() * 4), y, player.getDirX(), level);
				break;
			case FIRE:
				bullet = new FireBullet(player.getX() + (player.getDirX() * 4), y, player.getDirX(), level);
				break;
			case SNIPER:
				bullet = new SniperBullet(x + (player.getDirX() * 4), y-2, player.getDirX(), level);
				bullet2 = new SniperBullet(x + (player.getDirX() * 4), y+2, player.getDirX(), level);
				break;
			case EXPLOSIVE:
				bullet = new ExplosiveBullet(player.getX() + (player.getDirX() * 4), y, player.getDirX(), level);
				break;
			default:
				bullet = new ExplosiveBullet(x + (player.getDirX() * 4), y, player.getDirX(), level);
		}
		
		level.addBullet(bullet);
		if(bullet2 != null) level.addBullet(bullet2);
		fireRate = bullet.fireRate;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setBulletType(BulletType bulletType){
		this.bulletType = bulletType;
	}
	
	public BulletType getBulletType(){
		return bulletType;
	}
}