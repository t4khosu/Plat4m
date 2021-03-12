package com.t4khosu.Platformer.graphics;

/**
 * create all midlegrounds that are needed for the full middleground
 * the attribut Sprite Array is used to combine single pictures for one regions/level
 * @author Christian
 *
 */
public class Middleground {
	
	// all single middleground pictures
	public static Middleground forest0 = new Middleground(Sprite.forest_0);
	public static Middleground forest1 = new Middleground(Sprite.forest_1);
	public static Middleground forest2 = new Middleground(Sprite.forest_2);
	public static Middleground forest3 = new Middleground(Sprite.forest_3);
	public static Middleground forest4 = new Middleground(Sprite.forest_4);
	
	public static Middleground town1 = new Middleground(Sprite.town_1);
	
	private Sprite[] sprites;
	private int imageWidth;
	private int imageHeight;
	
	/**
	 * constructor
	 * @param sprites
	 */
	public Middleground(Sprite[] sprites){
		this.sprites = sprites;
		
		imageWidth  = sprites[0].getWidth();
		imageHeight = sprites[0].getHeight();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Sprite[] getSprites(){
		return sprites;
	}
	public int getPartWidth(){
		return imageWidth;
	}
	public int getPartHeight(){
		return imageHeight;
	}
}