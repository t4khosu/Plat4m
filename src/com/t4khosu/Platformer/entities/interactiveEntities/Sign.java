package com.t4khosu.Platformer.entities.interactiveEntities;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

public class Sign extends InteractiveEntity{
	
	public enum SignType{
		WOODEN, OLDWOODEN, ELECTRONICAL;
	}
	
	public Sprite showImage;
	private String text = "";
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param text
	 * @param type
	 */
	public Sign(int x, int y, String text, SignType type) {
		super(x, y);
		this.text = text;
		
		switch(type){
			case WOODEN: 		sprite = Sprite.sign1_sprite;
						 		showImage = Sprite.big_sign;
						 		break;
			case ELECTRONICAL: 	sprite = Sprite.sign2_sprite;
			 			 		showImage = Sprite.big_sign2;
			 			 		break;
			 			 		
			case OLDWOODEN: 	sprite = Sprite.sign3_sprite;
		 						showImage = Sprite.big_sign;
		 						break;
		 						
			default:			sprite = Sprite.sign1_sprite;
		 						showImage = Sprite.big_sign;
		 						break;
		}
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public String getText(){
		return text;
	}
}