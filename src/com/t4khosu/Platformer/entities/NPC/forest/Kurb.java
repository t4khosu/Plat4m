package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Trader;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Rolberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.RolberrySeed;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Wheat;
import com.t4khosu.Platformer.entities.item.mainItems.potions.HealthPotion;

public class Kurb extends Trader {
	
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
	public Kurb(int x, int y, Level level) {
		super(x, y, level, "Kurb");
		
		Item[] items = new Item[2*4];
		items[0] = new Rolberry();
		items[1] = new Wheat();
		items[2] = new HealthPotion();
		items[3] = new RolberrySeed();
		this.buysItems = false;
		fillStore(items);
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		actualDialog = 0;
		String[] a = {"#WILLKOMMEN IN KURBS LADEN!",
				"#DAS BIN ICH!",
						"#M\u00F6chtest du etwas kaufen????"};
		dialogs.add(a);
	}
	
	/**
	 * render sprite
	 * @param screen
	 */
	public void render(Screen screen){
		screen.renderNewHSB(x, y, sprite, true, 0.96f, 0.6f);
	}
}
