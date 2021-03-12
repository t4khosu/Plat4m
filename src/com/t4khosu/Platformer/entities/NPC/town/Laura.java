package com.t4khosu.Platformer.entities.NPC.town;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class Laura extends NPC {

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
	public Laura(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
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
		String[] a = {"#Meine Lieblingstiere sind K\u00E4ngurus. Sie sind stark, edel und h\u00FCpfen wohin sie auch wollen",
						"#Dagegen finde ich Pinguine total \u00F6de und langweilig. Wozu ist denn bitte ein flugunf\u00E4higer Vogel gut?! ..."};
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
		screen.renderNewHSB(x, y, sprite, true, 0.63f, 0.9f);
		if(hairSprite != null){
			screen.renderNewHSB(x, y, hairSprite, true, 0.45f, 0.9f);
		}
	}
}