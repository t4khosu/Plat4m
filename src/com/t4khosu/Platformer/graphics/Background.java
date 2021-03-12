package com.t4khosu.Platformer.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.t4khosu.Platformer.Game;

public class Background {
	
	//load backgrounds
	public static Background background_01 = new Background(Game.width, Game.height, "/backgrounds/sunset.png");
	public static Background background_02 = new Background(Game.width, Game.height, "/backgrounds/night.png");
	public static Background background_03 = new Background(Game.width, Game.height, "/backgrounds/underground.png");
	public static Background background_04 = new Background(Game.width, Game.height, "/backgrounds/sunset2.png");
	public static Background background_05 = new Background(Game.width, Game.height, "/backgrounds/sunset3.png");
	
	private static Background[] bgList = {background_01, background_04, background_05};
	
	private final int WIDTH;
	private final int HEIGHT;
	private String path;
	private int[] pixels;
	private int[] pixelsSafe;
	
	private float saturation = 1.0f;
	private float brightness = 1.0f;
	
	/**
	 * constructor
	 * @param width
	 * @param height
	 * @param path
	 */
	public Background(int width, int height, String path){
		this.path = path;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[HEIGHT * WIDTH];
		pixelsSafe = new int[HEIGHT * WIDTH];
		load();
	}

	/**
	 * Initialize background by loading image and saving data into RGB-array. Also resize Picture before
	 */
	public void load(){
		try {
			BufferedImage image = ImageIO.read(Background.class.getResource(path));
			BufferedImage newImage = Sprite.resize(image, Game.width, Game.height);
			newImage.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
			for(int i = 0; i < pixels.length; i++){
				pixelsSafe[i] = pixels[i];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Change saturation and brightness, so the background looks darker
	 * @param brightness
	 * @param saturation
	 */
	public void darker(float brightness, float saturation){
		//save values for area changes, so not all backgrounds must be updated
		this.brightness = brightness;
		this.saturation = saturation;
		
		for(int i = 0; i < pixels.length; i++){
			Color c = new Color(pixelsSafe[i]);	
			float hsbVals[] = Color.RGBtoHSB( c.getRed(), c.getGreen(), c.getBlue(), null);
			Color darker = Color.getHSBColor( hsbVals[0], saturation * hsbVals[1], brightness * hsbVals[2]);
			pixels[i] = darker.getRGB();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}
	public int[] getPixels(){
		return pixels;
	}
	
	/**
	 * get Attributes to change darkness of background
	 * @return
	 */
	public float[] getDarkerAttributes(){
		return new float[]{brightness, saturation};
	}
}