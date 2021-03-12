package com.t4khosu.Platformer.entities.interactiveEntities.bookshelfes;

import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.Level.Level;

public class Blacksmith_Bookshelf extends Bookshelf {

	public Blacksmith_Bookshelf(int x, int y, Level level) {
		super(x, y, level, "Schmieden f�r Noobs");
	}

	@Override
	public void initSites() {
		sites.add("");
	}

}
