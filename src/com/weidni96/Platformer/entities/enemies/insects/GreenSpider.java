package com.weidni96.Platformer.entities.enemies.insects;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.bullet.mobBullet.PoisonousBullet;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class GreenSpider extends Spider{

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public GreenSpider(int x, int y, Level level) {
		super(x, y, level);
		this.as = new AnimatedSprite(8, SpriteSheet.greenSpider_sheet, 2, 30, false);
		this.sprite = as.getSprite();
		
		this.name = "Gruene Spinne";
		this.collisionDamage = 10;
		initLife(10);
	}
	
	/**
	 * shoot poisonous bullets
	 */
	public void shoot(){
		if(timer%bulletSpawnSpeed == 0){
			level.addBullet(new PoisonousBullet(x, y + height, 0, 1, level));
		}
	}
}
