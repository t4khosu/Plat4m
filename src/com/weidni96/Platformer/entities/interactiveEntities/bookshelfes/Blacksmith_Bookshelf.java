package com.weidni96.Platformer.entities.interactiveEntities.bookshelfes;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.interactiveEntities.Bookshelf;

public class Blacksmith_Bookshelf extends Bookshelf{

	public Blacksmith_Bookshelf(int x, int y, Level level) {
		super(x, y, level, "Schmieden für Noobs");
	}

	@Override
	public void initSites() {
		sites.add("");
	}

}
