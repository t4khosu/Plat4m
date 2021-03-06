package com.t4khosu.Platformer.entities.enemies.insects;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.bullet.mobBullet.MobBullet;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class BrownSpider extends Spider{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public BrownSpider(int x, int y, Level level) {
		super(x, y, level);
		this.as = new AnimatedSprite(8, SpriteSheet.brownSpider_sheet, 2, 30, false);
		this.sprite = as.getSprite();
		
		this.name = "Braune Spinne";
		this.collisionDamage = 4;
		experience = 30;
		initLife(6);
		money = 1;
		lvl = 1;
	}
	
	/**
	 * shoot standard mob bullets
	 */
	public void shoot(){
		if(timer%bulletSpawnSpeed == 0){
			level.addBullet(new MobBullet(x, y, 0, 1, level));
		}
	}
}
