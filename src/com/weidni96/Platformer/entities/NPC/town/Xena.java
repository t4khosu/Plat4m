package com.weidni96.Platformer.entities.NPC.town;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class Xena extends NPC{

	/**
	 * constructor, with specific hair
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param walker
	 * @param name
	 * @param actionChange
	 * @param basis
	 */
	public Xena(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
		super(x, y, sprite, level, walker, name, actionChange, basis);
		
		hair_right = new AnimatedSprite(8, SpriteSheet.hair1_right_sheet, 4, 10, false);
		hair_left  = new AnimatedSprite(8, SpriteSheet.hair1_left_sheet, 4, 10, false);
		hairRight = Sprite.hair1_right;
		hairLeft = Sprite.hair1_left;
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		actualDialog = 0;
		String[] a = {"#Dialog"};
		dialogs.add(a);
	}
	
	/**
	 * check when npc stops talking
	 */
	public void stopTalking(){
		talking = false;
	}
	
	/**
	 * check when npc starts talking
	 */
	public void talk(){
		talking = true;
	}
	
	/**
	 * render sprite
	 * @params creen
	 */
	public void render(Screen screen){
		screen.renderNewHSB(x, y, sprite, true, 0.2f, 0.9f);
		
		if(hairSprite != null){
			screen.renderNewHSB(x, y, hairSprite, true, 0.7f, 0.9f);
		}
	}
}