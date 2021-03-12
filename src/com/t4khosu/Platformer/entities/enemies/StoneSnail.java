package com.t4khosu.Platformer.entities.enemies;

import java.util.Random;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.mob.Mob;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class StoneSnail extends Mob {
	
	private Random random;
	private int nextAction;
	
	private int action = 0;
	
	private AnimatedSprite changeShellLeft  = new AnimatedSprite(8, SpriteSheet.stoneSnail_left_sheet, 3, 30, true);
	private AnimatedSprite changeShellRight = new AnimatedSprite(8, SpriteSheet.stoneSnail_right_sheet, 3, 30, true);
	private AnimatedSprite moveLeft 		= new AnimatedSprite(8, SpriteSheet.stoneSnail_move_left_sheet, 2, 8, true);
	private AnimatedSprite moveRight 		= new AnimatedSprite(8, SpriteSheet.stoneSnail_move_right_sheet, 2, 8, true);
	
	protected int full_dead_time = 150;
	protected int dead_time	= full_dead_time;
	
	private AnimatedSprite as;
	
	private float floatSpeed = 0.6f;
	private float speedCount = 0f;
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 */
	public StoneSnail(int x, int y, Level level) {
		super(x, y, Sprite.void_sprite, level);
		this.random 	= new Random();
		
		dirX = random.nextInt(1)*2 - 1;
		if(dirX < 0) as = changeShellLeft;
		else as = changeShellRight;
		
		sprite = as.getSprite();
		
		nextAction = getNextActionTime();
		
		this.name = "Steinschnecke";
		collisionDamage = 12;
		experience = 160;
		initLife(12);
		money = 2;
		shield = 5;
		lvl = 5;
	}
	
	/**
	 * calculate random next time for action
	 * @return result
	 */
	public int getNextActionTime(){
		return random.nextInt(200)+300;
	}
	
	/**
	 * update when alive
	 */
	public void aliveUpdate(){
		if(timer >= nextAction && action != 1 && action != 3){ //change state
			if(action <= 2) action++;
			else action = 0;
			
			timer = 0;
			nextAction = getNextActionTime();
		}
		
		if(action == 1){
			goOutOfShell();
		}
		if(action == 2){
			move(dirX);
		}
		if(action == 3){
			goIntoShell();
		}
	}
	
	/**
	 * update when dead
	 */
	public void deadUpdate(){
		if(dead_time == 0){
			remove();
		}else{
			dead_time--;
			if(dirX < 0){
				sprite = Sprite.stone_snail_left_dead;
			}
			else{
				sprite = Sprite.stone_snail_right_dead;
			}
		}
	}

	/**
	 * go back out of shell
	 */
	public void goOutOfShell(){
		shield = 0;
		if(as.getFrame() != 2){
			as.update();
		}else{
			action++;
			if(dirX < 0){
				as = moveLeft;
			}else{
				as = moveRight;
			}
			
			changeShellLeft.setFrame(2);
			changeShellRight.setFrame(2);
		}
	}
	
	/**
	 * go back into shell
	 */
	public void goIntoShell(){
		shield = 5;
		if(dirX < 0){
			as = changeShellLeft;
		}else{
			as = changeShellRight;
		}
		
		if(as.getFrame() != 0){
			as.update();
		}else{
			action = 0;
			changeShellLeft.setFrame(0);
			changeShellRight.setFrame(0);
		}
	}
	
	/**
	 * move direction, collision -> change direction
	 * @param steps
	 */
	public void move(int steps){ //nx steps
		as.update();
		int xx = x + 8;
		if(steps < 0){
			dirX = -1;
			xx = x - 1;
		}
		else dirX = 1;
		
		if(speedCount < 1.0f){
			speedCount += floatSpeed;
		}else{
			speedCount--;
			for(int i = 0; i < Math.abs(steps); i++){
				if(!sideCollision(dirX) && TileGetterList.getTile(xx/8,(y+8)/8, level).isSolid()){
					x += dirX;
				}else{
					dirX *= -1;
					if(dirX < 0){
						as = moveLeft;
					}else{
						as = moveRight;
					}
				}
			}
		}
		
		
	}
	
	/**
	 * render sprite
	 * @param Screen screen
	 */
	public void render(Screen screen){
		if(!msm.isDead()){
			sprite = as.getSprite();
			if(life < max_life){ /* life bar */
				screen.renderLifeBar(x, y-2, life, max_life, sprite.getWidth(), 1, true);
			}
		}
		
		if(msm.getBlinkON()){ /* blinking */
			screen.renderNewHSB(x, y, sprite, true, 1.0f, 0.5f);
		}else{
			screen.renderSprite(x, y, sprite, true);
		}
	}
}
