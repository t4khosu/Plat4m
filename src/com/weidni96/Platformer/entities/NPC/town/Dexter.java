package com.weidni96.Platformer.entities.NPC.town;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Dexter extends NPC{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param walker
	 * @param name
	 * @param actionChange
	 * @param basis
	 */
	public Dexter(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
		super(x, y, sprite, level, walker, name, actionChange, basis);
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		actualDialog = 0;
		String[] a = {"#Kennen wir uns?"};
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
		screen.renderNewHSB(x, y, sprite, true, 0.7f, 0.9f);
	}
}