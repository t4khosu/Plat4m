package com.t4khosu.Platformer.entities.NPC.town;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

public class Zane extends NPC {

	/**
	 * constructor, looking left
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param walker
	 * @param name
	 * @param actionChange
	 * @param basis
	 */
	public Zane(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
		super(x, y, sprite, level, walker, name, actionChange, basis);
		dirX = -1;
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		String[] ch = {"ja (50 Geld)", "nein"};
		choices.add(new Choices(0, ch));
		
		actualDialog = 0;
		String[] a = {"#Willkommen in meinen Shop!", "#Ich hoffe du findest wonach du suchst."};
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
		screen.renderNewHSB(x, y, sprite, true, 0.1f, 0.9f);
	}
}
