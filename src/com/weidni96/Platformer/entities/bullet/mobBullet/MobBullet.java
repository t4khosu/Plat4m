package com.weidni96.Platformer.entities.bullet.mobBullet;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.entities.bullet.Bullet;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Sprite;

public class MobBullet extends Bullet{

	private int dirY = 0;
	
	protected boolean poisonous = false;
	
	public MobBullet(int x, int y, int dirX, int dirY, Level level) {
		super(x, y, dirX, level);
		
		this.dirY = dirY;
		
		sprite = Sprite.enemy_bullet_sprite;
		fireRate = 0;
		life = 30;
		speed = 2;
		damage = 3;
	}
	
	protected boolean collision(int nx, int ny){
		int xx, yy;
		for(int c = 0; c < 4; c++){
			xx = ((nx + 2) + c%2 * 2);
			yy = ((ny + 2) + c/2 * 2); 
			
			Player p = null;
			if(TileGetterList.getTile(xx/8, yy/8, level).isSolid() || (p = level.getPlayerAt(xx, yy)) != null){
				if(p != null){
					p.hit(damage);
					if(poisonous){
						p.getMTM().getPoisonedTimer().start();
					}
				}
				life = 0;
				return true;
			}
		}
		return false;
	}
	
	public void move(){
		for(int i = 0; i < speed; i++){
			if(life > 0 && !collision(x + dirX, y)){
				x += dirX;
			}else{
				break;
			}
		}
		
		for(int i = 0; i < speed; i++){
			if(life > 0 && !collision(x, y + dirY)){
				y += dirY;
			}else{
				break;
			}
		}
	}
	
	
	public boolean isPoisonous(){
		return poisonous;
	}
}
