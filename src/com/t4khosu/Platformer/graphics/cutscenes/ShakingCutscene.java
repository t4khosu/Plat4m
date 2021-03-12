package com.t4khosu.Platformer.graphics.cutscenes;

import java.awt.Graphics;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.Level.World;

public class ShakingCutscene extends Cutscene{

	private int duration;
	
	public ShakingCutscene(World world, int removeText, int removeScreen, int duration) {
		super(world, removeText, removeScreen);
		this.duration = duration;
		this.x = world.getPlayer().getX()/8;
		this.y = world.getPlayer().getY()/8;
	}

	@Override
	public void update() {
		switch(action){
			case 0:
				timer++;
				if(timer >= 40){
					action++;
					timer = 0;
					camera.jumpTo(x, y);
				}
				break;
			
			case 1: 
				if(!world.getCamera().isMoving()){
					if(timer%2 == 0){
						camera.moveTo(x, y, 2); 
					}else{
						camera.moveTo(x-1, y, 2); 
					}
				}
				if(timer >= duration){
					action++;
					timer = 0;
					camera.moveTo(x, y, 2); 
				}
				timer++;
				break;
				
			case 2:
				timer++;
				if(timer >= 60 && !camera.isMoving()){
					remove();
					camera.focusEntity(world.getPlayer());
				}
				break;
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Screen screen) {
		// TODO Auto-generated method stub
		
	}

}
