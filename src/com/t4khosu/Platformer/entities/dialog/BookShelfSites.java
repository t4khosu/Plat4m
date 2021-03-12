package com.t4khosu.Platformer.entities.dialog;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.entities.player.Player;

public class BookShelfSites extends Dialogbox{
	
	
	private Bookshelf bookShelf;
	/**
	 * constructor, predefined size, no sprite
	 * @param player
	 * @param sprite
	 * @param npc
	 * @param oncePressed
	 */
	public BookShelfSites(Player player, Bookshelf bookShelf, boolean oncePressed) {
		super(player.getInput(), null);
		headline = bookShelf.getTitle();
		this.oncePressed 	= oncePressed;
		this.height 	= Game.height/4;
		this.width 		= Game.width/3;
		setPositionCenter();
		this.bookShelf = bookShelf;
		
		//init all string of dialog as text objects
		texts = new Text[bookShelf.getSites().size()];
		for(int i = 0; i < texts.length; i++){
			texts[i] = new Text(bookShelf.getSites().get(i), this);
		}
	}
	
	/**
	 * update texts. Depending on the first letter, change headline
	 * # -> npc
	 * ~ -> player
	 */
	public void update(){
		texts[actualText].update();
		
		if(input.typedInteract){
			if(oncePressed){
				if(texts[actualText].getShortText().length() != texts[actualText].getText().length()){ //-1 because of front sign
					texts[actualText].finishText();
				}else{
					if(actualText < texts.length-1) actualText++;
					else removed = true;
				}
			}else{
				oncePressed = true;
			}
		}
	}
}
