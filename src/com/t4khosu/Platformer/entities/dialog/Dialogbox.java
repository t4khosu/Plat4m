package com.t4khosu.Platformer.entities.dialog;

import java.awt.Color;
import java.awt.Graphics;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.input.Keyboard;

public abstract class Dialogbox extends Entity {
	
	protected Keyboard input;
	protected Text[] texts;
	protected int width 	 = 0;
	protected int height 	 = 0;
	protected int actualText = 0;
	protected String headline  = "";
	protected boolean oncePressed = false;
	protected int waitTimer	= 0;
	
	/*
	 *  +--------------------------------------------------------------+
	 *  |	Sprite	...headline...									   |
	 *  |															   |
	 *  |	texts[]...........................................		   |
	 *  |	................................................		   |
	 *  |															   |
	 *  +--------------------------------------------------------------+
	 */
	
	/**
	 * constructor, only position and input
	 * @param key
	 */
	public Dialogbox(Keyboard key) {
		this.input 	= key;
		setPositionCenter();
	}
	
	/**
	 * constructor, but also with a picture
	 * @param key
	 * @param sprite
	 */
	public Dialogbox(Keyboard key, Sprite sprite) {
		this.input 	= key;
		this.sprite = sprite;
		setPositionCenter();
	}
	
	 /**
	  * constructor, but already declare width and height
	  * @param key
	  * @param width
	  * @param height
	  * @param sprite
	  */
	public Dialogbox(Keyboard key, int width, int height, Sprite sprite) {
		this.input	= key;
		this.height = height;
		this.width 	= width;
		this.sprite = sprite;
		setPositionCenter();
	}
	
	/**
	 * center position
	 */
	public void setPositionCenter(){
		this.x 	= Game.width / 2 - width / 2;
		this.y 	= Game.height / 10;
	}
	
	/**
	 * update texts. If text is not finished writing and pressed space, finish text. if finished and press space, go to next text 
	 */
	public void update(){
		if(waitTimer == 0){
			if(input.typedInteract){
				if(oncePressed){
					if(!texts[actualText].getShortText().equals(texts[actualText].getText())){
						texts[actualText].finishText();
					}else{
						if(actualText < texts.length-1) actualText++;
						else remove();
					}	
				}
				oncePressed = true;
			}
			texts[actualText].update();	
		}else{
			waitTimer--;
		}
	}
	
	/**
	 * Render dialogbox without text
	 */
	public void render(Screen screen){
		if(waitTimer == 0){
			renderBack(screen);
		}
	}
	
	/**
	 * render transparent background with frame
	 * @param screen
	 */
	public void renderBack(Screen screen){
		int[] pixels = screen.getPixels();
		for(int y0 = 0; y0 < height; y0++){
			int ya = y0 + y;
			for(int x0 = 0; x0 < width; x0++){
				int xa = x0 + x;
				Color c = new Color(pixels[xa + ya * screen.getWidth()]);	
				float hsbVals[] = Color.RGBtoHSB( c.getRed(), c.getGreen(), c.getBlue(), null);
				Color darker;
				if(x0 == 0 || x0 == width -1 || y0 == 0 || y0 == height -1){
					darker = Color.getHSBColor( 0.4f, 0.8f * hsbVals[1], 1.0f * hsbVals[2]);
				}else{
					darker = Color.getHSBColor( 0.4f, 0.4f * hsbVals[1], 0.4f * hsbVals[2]);
				}
				pixels[xa + ya * screen.getWidth()] = darker.getRGB();
			}
		}
		if(sprite != null){
			
			int xOff = 2;
			int yOff = 2;
			
			if(sprite.getWidth() < 16){
				screen.renderSprite(x + xOff+4, y + yOff+4, sprite, false);
			}else{
				screen.renderSprite(x + xOff, y + yOff, sprite, false);
			}
		}
	}

	/**
	 * Render text into dialogbox
	 * @param g
	 */
	public void render(Graphics g){
		texts[actualText].renderText(g);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public String getHeadline(){
		return headline;
	}
	public Text[] getTexts(){
		return texts;
	}
	public int getActualText(){
		return actualText;
	}
	public int getWaitTimer(){
		return waitTimer;
	}
	public int getSelectedChoice(){
		return 0;
	}
}