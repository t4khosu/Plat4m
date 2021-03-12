package com.weidni96.Platformer.entities.interactiveEntities;

import java.util.ArrayList;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public abstract class Bookshelf extends InteractiveEntity{

	private Sprite bookShelf = Sprite.bookShelf;
	protected ArrayList<String> sites = new ArrayList<String>();
	protected String title;
	
	public Bookshelf(int x, int y, Level level, String title) {
		super(x, y);
		initLevel(level);	
		this.title = title;
		initSites();
	}
	
	public void render(Screen screen){
		screen.renderSprite(x-2, y-10, bookShelf, true);
	}
	
	/**
	 * initialize all sites of the book
	 */
	public abstract void initSites();
	
	public String getTitle(){
		return title;
	}
	public ArrayList<String> getSites(){
		return sites;
	}

}
