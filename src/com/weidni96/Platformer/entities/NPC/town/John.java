package com.weidni96.Platformer.entities.NPC.town;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class John extends NPC{

	/**
	 * constructor, looks left
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param walker
	 * @param name
	 * @param actionChange
	 * @param basis
	 */
	public John(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
			super(x, y, sprite, level, walker, name, actionChange, basis);
			dirX = -1;
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		actualDialog = 0;
		String[] a = {"#Willkommen in John's Shop, der weitaus besser ist als der Laden unter mir!", 
						"#Ehrlich gesagt habe ich...",
						"#noch keine Waren...",
						"#Ich habe mich nur etwas verkalkuliert! Die kommen bald an, also hab nur Geduld!"};
		dialogs.add(a);
		
		String[] b = {"#In zwei oder drei Tagen sollten meine Waren da sein.",
						"#Hoffe ich."};
		dialogs.add(b);
	}
	
	/**
	 * check when npc stops talking
	 */
	public void stopTalking(){
		talking = false;
		if(actualDialog == 0) actualDialog++;
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
		screen.renderNewHSB(x, y, sprite, true, 0.3f, 0.9f);
	}

}
