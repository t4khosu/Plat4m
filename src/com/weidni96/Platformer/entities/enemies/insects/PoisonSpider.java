package com.weidni96.Platformer.entities.enemies.insects;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.bullet.mobBullet.UndergroundBullet;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class PoisonSpider extends Spider{

	public PoisonSpider(int x, int y, Level level) {
		super(x, y, level);
		
		this.as = new AnimatedSprite(8, SpriteSheet.blueSpider_sheet, 2, 30, false);
		this.sprite = as.getSprite();
		
		this.name = "Gift Spinne";
		this.collisionDamage = 12;
		initLife(12);
		experience = 60;
		initLife(14);
		money = 2;
		lvl = 3;
	}

	@Override
	public void shoot() {
		if(timer%bulletSpawnSpeed == 0){
			level.addBullet(new UndergroundBullet(x, y + height, 0, 1, level));
		}
		if(timer%bulletSpawnSpeed == bulletSpawnSpeed/5){
			level.addBullet(new UndergroundBullet(x, y + height, 0, 1, level));
		}
	}
}
