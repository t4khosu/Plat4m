package com.weidni96.Platformer.entities.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.input.Keyboard;

public class ItemBox extends Dialogbox{

	private Item item;
	private String extra;
	
	/**
	 * got special item
	 * @param key
	 * @param item
	 * @param extra
	 */
	public ItemBox(Keyboard key, Item item, String extra) {
		super(key);
		this.item = item;
		this.extra = extra;
		this.sprite = item.getSprite();
		
		this.width = Game.width/3;
		this.height = Game.height/9;
		
		this.x = Game.width/2 - width/2;
		this.y = 20;
		
		texts 		= new Text[1];
		texts[0] 	= new Text(item.getDescription(), this);
	}
	
	/**
	 * render text
	 */
	public void render(Graphics g){
		int xOff = 155;
		int yOff = 210;
		
		g.setColor(new Color(180,240,180));
		g.drawString(item.getName() + extra,  Game.width * Game.scale/2 - xOff + 50, Game.height * Game.scale/2 - yOff);
			
		g.setColor(Color.white);
		g.setFont(new Font("Arial Hebrew", Font.PLAIN, 14)); 
		g.drawString(texts[0].getShortText(),  Game.width * Game.scale/2 - xOff + 50, Game.height * Game.scale/2 - yOff + 22);
	}
	
	/**
	 * render background
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
		if(item != null){
			
			int xOff = 2;
			int yOff = 2;
			
			if(item.getSprite().getWidth() < 16){
				item.render(screen, x + xOff+4, y + yOff+4);
			}else{
				item.render(screen, x + xOff, y + yOff);
			}
		}
	}
	
	/**
	 * update item message box
	 */
	public void update(){
		texts[0].update();	
	}
}