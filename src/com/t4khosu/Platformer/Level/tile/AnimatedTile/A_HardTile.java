package com.t4khosu.Platformer.Level.tile.AnimatedTile;

import com.t4khosu.Platformer.graphics.AnimatedSprite;

public class A_HardTile extends AnimatedTile{

	public A_HardTile(AnimatedSprite as) {
		super(as);
	}

	@Override
	public void update(){
		as.update();
		sprite = as.getSprite();
	}
	
	@Override
	public boolean isSolid(){ return true; }
}
