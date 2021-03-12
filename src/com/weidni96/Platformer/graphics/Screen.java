package com.weidni96.Platformer.graphics;

import java.awt.Color;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.Tile;
import com.weidni96.Platformer.Surface.Map;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.particles.particleTypes.Particle;

/**
 * Render all sprites and objects that are used on screen, save them in a pixel array.
 * This array will be used in the Game class
 * @author Christian
 *
 */
public class Screen {
	private int width;
	private int height;
	private int[] pixels;
	
	private int xOffset = 0;
	private int yOffset = 0;
	
	public static int transColor = 0xffff00ff;
	public static int windowColor = 0xff68AFD6;
	public static float darkLevel = 0.001f;
	
	/**
	 * constructor
	 * @param width
	 * @param height
	 */
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	/**
	 * clear screen -> everything black
	 */
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}

	/**
	 * lifebar with three colors
	 * @param xp
	 * @param yp
	 * @param life
	 * @param max_life
	 * @param size
	 * @param boldnes
	 * @param offset
	 */
	public void renderLifeBar(int xp, int yp, int life, int max_life, int size, int boldnes, boolean offset){
		double lifeDif = (double)life / max_life;
		
		if(lifeDif <= 0.5){
			renderBar(xp, yp, life,max_life, size, 0xffBBBB00, offset);
		}
		else if(lifeDif <= 0.3){
			renderBar(xp, yp, life,max_life, size, 0xffBB0000, offset);
		}else{
			renderBar(xp, yp, life,max_life, size, 0xff00BB00, offset);
		}
	}
	
	/**
	 * render a bar with background black and foreground = certain color
	 * @param xp
	 * @param yp
	 * @param value
	 * @param max_value
	 * @param size
	 * @param col
	 * @param offset
	 */
	public void renderBar(int xp, int yp, int value, int max_value, int size, int col, boolean offset){
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int i = 0; i < size; i++){
			int xa = xp + i;
			if(xa < 0 || xa >= width || yp < 0  || yp >= height) continue;
			pixels[xa + yp * width] = 0;
		}
		
		double dif = (double)value / max_value;
		size = (int)(dif*size);
		
		if(size >= 0){
			for(int i = 0; i < size; i++){
				int xa = xp + i;
				if(xa < 0 || xa >= width || yp < 0  || yp >= height) continue;
				pixels[xa + yp * width] = col;
			}
		}
	}
	
	/**
	 * render sprite with new hue and saturation
	 * @param xp
	 * @param yp
	 * @param sprite
	 * @param offset
	 * @param hue
	 * @param saturation
	 */
	public void renderNewHSB(int xp, int yp, Sprite sprite, boolean offset, float hue, float saturation){
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0; y < sprite.getSize(); y++){
			int ya = yp+y; //absolute y position
			
			for(int x = 0; x < sprite.getSize(); x++){
				int xa = xp+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = sprite.getPixels()[x + y * sprite.getSize()];
				
				if(col != transColor){
					Color c = new Color(col);	
					float hsbVals[] = Color.RGBtoHSB( c.getRed(), c.getGreen(), c.getBlue(), null);
					Color darker = Color.getHSBColor( hue, saturation, hsbVals[2]);
					pixels[xa + ya * width] = darker.getRGB();
				}
			}
		}
	}
	
	/**
	 * render a normal sprite
	 * @param xp
	 * @param yp
	 * @param sprite
	 * @param offset
	 */
	public void renderSprite(int xp, int yp, Sprite sprite, boolean offset){
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0; y < sprite.getHeight(); y++){
			int ya = yp+y; //absolute y position
			
			for(int x = 0; x < sprite.getWidth(); x++){
				int xa = xp+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = sprite.getPixels()[x + y * sprite.getWidth()];
				if(col != transColor){
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	/**
	 * render a potion with its specific potion color //TODO
	 * @param xp
	 * @param yp
	 * @param color
	 * @param offset
	 */
	public void renderPotion(int xp, int yp, int color, boolean offset){
		int liquidColor = 0xffD1B58A;
		
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0; y < Sprite.potion_sprite.getHeight(); y++){
			int ya = yp+y; //absolute y position
			
			for(int x = 0; x < Sprite.potion_sprite.getWidth(); x++){
				int xa = xp+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = Sprite.potion_sprite.getPixels()[x + y * Sprite.potion_sprite.getWidth()];
				if(col != transColor){
					if(col == liquidColor){
						pixels[xa + ya * width] = color;
					}else{
						pixels[xa + ya * width] = col;
					}
				}
			}
		}
	}
	
	/**
	 * render background	
	 * @param xp
	 * @param yp
	 * @param b
	 */
	public void renderBackground(int xp, int yp, Background b){
		
		for(int y = 0; y < b.getHeight(); y++){
			int ya = yp+y; //absolute y position
			for(int x = 0; x < b.getWidth(); x++){
				int xa = xp+x; //absolute x position
				
				int col = b.getPixels()[x + y * b.getWidth()];
				pixels[xa + ya * width] = col;
			}
		}
	}
	
	/**
	 * render a middleground that moves half the speed of the player
	 * @param xp
	 * @param yp
	 * @param m
	 */
	public void renderMiddleground(int xp, int yp, Middleground m){
		yp = yp / 2 - 6;
		xp -= xOffset/2;
		yp -= yOffset/2;
		
		int picWidth = 0;
		
		for(int i = 0; i < m.getSprites().length; i++){
			
			picWidth  = m.getSprites()[i].getWidth();
			
			if(i * picWidth + xp + picWidth < 0) continue;
			if(i * picWidth + xp >  width) continue;
			
			for(int y = 0; y < m.getSprites()[i].getHeight(); y++){
				int ya = yp+y; //absolute y position
				
				for(int x = 0; x < picWidth; x++){
					int xa = (i * picWidth) +  xp + x; //absolute x position
					if(xa < 0 || ya < 0) continue;
					if(xa >= width || ya >= height) break;
					int col = m.getSprites()[i].getPixels()[x + y *picWidth];
					if(col != transColor){
						pixels[xa + ya * width] = col;
					}
				}
			}
		}
	}
	
	/**
	 * render a particle
	 * @param xp
	 * @param yp
	 * @param particle
	 */
	public void renderParticle(int xp, int yp, Particle particle){
		renderSprite(xp, yp, particle.getSprite(), true);
	}
	
	/**
	 * render a map of the level
	 * @param map
	 * @param level
	 */
	public void renderMap(Map map, Level level){
		int xp = map.getPlayer().getX() / 8;
		int yp = map.getPlayer().getY() / 8;
		for(int y = 0; y < map.getHeight(); y++){
			int y0 = y;
			for(int x = 0; x < map.getWidth(); x++){
				int x0 = width - map.getWidth() + x;
				
				int col = map.getPixels()[x + y * map.getWidth()];
				
				if(y == yp && x == xp){
					pixels[x0 + y0 * width] = 0xffFF0040;
				}
				else if(col == Tile.ID_ladder1 || col == Tile.ID_water1 || col == Tile.ID_pile || col == Tile.ID_forceRight){
					pixels[x0 + y0 * width] = 0xffDDDDDD;
				}
				else{
					pixels[x0 + y0 * width] = 0xff7AC5CD;
				}
			}
		}
		
		//render items and stuff that is all around
		/*for(Item i : level.items){
			int x0 = width - map.getWidth();
			pixels[(x0 + i.getX()/ 8) + i.getY()/8 * width] = 0xff00ff00;
		}*/
	}
	
	/**
	 * render a green plant with its typical fruit color
	 * @param xp
	 * @param yp
	 * @param sprite
	 * @param fruitColor
	 * @param offset
	 */
	public void renderPlant(int xp, int yp, Sprite sprite, int fruitColor, boolean offset) {
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0; y < sprite.getHeight(); y++){
			int ya = yp+y; //absolute y position
			
			for(int x = 0; x < sprite.getWidth(); x++){
				int xa = xp+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = sprite.getPixels()[x + y * sprite.getWidth()];
				if(col != transColor){
					if(col == 0xffFFFFFF){
						pixels[xa + ya * width] = fruitColor;
					}else{
						pixels[xa + ya * width] = col;
					}
				}
			}
		}
	}
	
	/**
	 * render a sprite with transparent effects,
	 * the color must be windowsColor to be rendered transparent
	 * @param xp
	 * @param yp
	 * @param sprite
	 */
	public void renderTransparentSprite(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		
		for(int y = 0; y < sprite.getSize(); y++){
			int ya = yp+y; //absolute y position
			
			for(int x = 0; x < sprite.getSize(); x++){
				int xa = xp+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				
				if(sprite.getPixels()[x + y * sprite.getSize()] == windowColor){
					Color c1 = new Color(pixels[xa + ya * width]);
					float hsbVals1[] = Color.RGBtoHSB( c1.getRed(), c1.getGreen(), c1.getBlue(), null);
					
					Color c2 = new Color(sprite.getPixels()[x + y * sprite.getSize()]);
					float hsbVals2[] = Color.RGBtoHSB( c2.getRed(), c2.getGreen(), c2.getBlue(), null);
					
					Color newColor = Color.getHSBColor( hsbVals2[0], hsbVals1[1], 0.6f * hsbVals1[2]);
					pixels[xa + ya * width] = newColor.getRGB();
				}else{
					pixels[xa + ya * width] = sprite.getPixels()[x + y * sprite.getSize()];
				}
				
			}
		}
	}
	
	/**
	 * change level of darkness for certain area
	 * @param xp
	 * @param yp
	 * @param width
	 * @param height
	 * @param factor
	 * @param offset
	 */
	public void renderDarker(int xp, int yp, int width, int height, float factor, boolean offset){
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for(int y = 0; y < height; y++){
			int yy = yp + y;
			for(int x = 0; x < width; x++){
				int xx = xp + x;
				if(xx < 0 || xx >= this.width || yy < 0  || yy >= this.height) continue;
				Color c1 = new Color(pixels[xx + yy * this.width]);
				float hsbVals1[] = Color.RGBtoHSB( c1.getRed(), c1.getGreen(), c1.getBlue(), null);
				//create new brightness
				Color newColor = Color.getHSBColor( hsbVals1[0], hsbVals1[1], factor * hsbVals1[2]);
				pixels[xx + yy * this.width] = newColor.getRGB();
			}
		}
	}
	

	/**
	 * just render a single pixel (for tests)
	 * @param xp
	 * @param yp
	 * @param col
	 * @param offset
	 */
	public void renderPixel(int xp, int yp, int col, boolean offset){
		if(offset){
			xp -= xOffset;
			yp -= yOffset;
		}
			
		if(xp < 0 || xp >= width || yp < 0  || yp >= height) return;
		if(col != transColor){
			pixels[xp + yp * width] = col;
		}
	}
	
	/**
	 * render whole spritesheet (for tests)
	 * @param sheet
	 */
	public void renderSheet(SpriteSheet sheet){
		
		for(int y = 0; y < sheet.getHeight(); y++){
			int ya = 20+y; //absolute y position
			
			for(int x = 0; x < sheet.getWidth(); x++){
				int xa = 20+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = sheet.getPixels()[x + y * sheet.getWidth()];
				pixels[xa + ya * width] = col;
			}
		}
	}
	
	/**
	 * render a single sprite at position 30, 30 (for tests)
	 * @param sprite
	 */
	public void renderSprite(Sprite sprite){
		
		for(int y = 0; y < sprite.getSize(); y++){
			int ya = 30+y; //absolute y position
			
			for(int x = 0; x < sprite.getSize(); x++){
				int xa = 30+x; //absolute x position
				if(xa < 0 || xa >= width || ya < 0  || ya >= height) continue;
				int col = sprite.getPixels()[x + y * sprite.getSize()];
				pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void darkerScreen(){
		for(int i = 0; i < getPixels().length; i++){
			Color c = new Color(getPixels()[i]);	
			float hsbVals[] = Color.RGBtoHSB( c.getRed(), c.getGreen(), c.getBlue(), null);
			Color darker = Color.getHSBColor(hsbVals[0], 0.5f * hsbVals[1], 0.8f * hsbVals[2]);
			getPixels()[i] = darker.getRGB();
		}
	}
	
	public void turnBlack(){
		for(int i = 0; i < getPixels().length; i++){
			Color c = new Color(getPixels()[i]);	
			float hsbVals[] = Color.RGBtoHSB( c.getRed(), c.getGreen(), c.getBlue(), null);
			if(hsbVals[2] - darkLevel < 0){
				hsbVals[2] = 0;
			}else{
				hsbVals[2] -= darkLevel;
			}
			Color darker = Color.getHSBColor(hsbVals[0], hsbVals[1], hsbVals[2]);
			getPixels()[i] = darker.getRGB();
		}	
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getOffsetY(){
		return yOffset;
	}
	public int[] getPixels(){
		return pixels;
	}
}
