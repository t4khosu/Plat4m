package com.weidni96.Platformer.entities.dialog;

import com.weidni96.Platformer.entities.interactiveEntities.Bookshelf;
import com.weidni96.Platformer.entities.player.Player;

public class BookShelfMessage extends MultiChoiceMessage{

	protected Bookshelf bookShelf;
	
	public BookShelfMessage(Player player, Bookshelf bookShelf) {
		super(player, bookShelf.getTitle(), "Dieses Buch lesen?", new String[]{"Lesen", "Nicht lesen"});
		this.bookShelf = bookShelf;
	}

	@Override
	public void individualUpdate(){
		if(removed){
			if(selectedChoice == 0){ //ja
				player.getWorld().getSurface().setDB(new BookShelfSites(player, bookShelf, true));
			}else{ //nein
			}
		}
	}
}
