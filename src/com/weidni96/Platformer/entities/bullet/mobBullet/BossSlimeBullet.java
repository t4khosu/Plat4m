package com.weidni96.Platformer.entities.bullet.mobBullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Sprite;

public class BossSlimeBullet extends MobBullet{

	public BossSlimeBullet(int x, int y, int dirX, int dirY, Level level) {
		super(x, y, dirX, dirY, level);
		
		sprite = Sprite.boss_bullet_sprite;
		fireRate = 0;
		life = 300;
		speed = 1;
		damage = 5;
	}
	
	@Override
	protected boolean collision(int nx, int ny){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 2) + c%2 * 2);
			yy = ((ny + 2) + c/2 * 2); 
			
			Player p = null;
			if((p = level.getPlayerAt(xx, yy)) != null){
				p.hit(damage);
				if(poisonous){
					p.getMTM().getPoisonedTimer().start();
				}
				life = 0;
				return true;
			}
		}
		return false;
	}
	

}
