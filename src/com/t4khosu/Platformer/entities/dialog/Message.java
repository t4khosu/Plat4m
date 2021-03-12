package com.t4khosu.Platformer.entities.dialog;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.interactiveEntities.Sign;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.player.Player;

public class Message extends Dialogbox{
	
	protected Player player;
	/**
	 * individual message
	 * @param player
	 * @param sprite
	 * @param headline
	 * @param text
	 */
	public Message(Player player, Sprite sprite, String headline, String text) {
		super(player.getInput(), sprite);
		this.player = player;
		this.headline = headline;
		
		width 		= Game.width/3 + 35;
		height 		= Game.height/9;
		texts 		= new Text[1];
		texts[0] 	= new Text(text,this);
		
		setPositionCenter();
	}
	
	/**
	 * message for sign
	 * @param player
	 * @param sign
	 */
	public Message(Player player, Sign sign) {
		super(player.getInput(), sign.showImage);
		this.headline = "Schild:";
		width 		= Game.width/3 + 35;
		height 		= Game.height/9;
		texts 		= new Text[1];
		texts[0] 	= new Text(sign.getText(), this);
		setPositionCenter();
	}

	/**
	 * message when got new item
	 * @param player
	 * @param item
	 * @param amount
	 */
	public Message(Player player, Item item, int amount) {
		super(player.getInput(), item.getSprite());
		
		if(amount > 1){
			this.headline = item.getName() + "( " + amount + ")";
		}else{
			this.headline = item.getName();
		}
		
		width 		= Game.width/3 + 35;
		height 		= Game.height/9;
		texts 		= new Text[1];
		texts[0] 	= new Text(item.getDescription(), this);
		this.waitTimer = 40;
		oncePressed = true;
		setPositionCenter();
	}
	
	/**
	 * message with delay, pops up not directly
	 * @param player
	 * @param sprite
	 * @param headline
	 * @param text
	 * @param delay
	 */
	public Message(Player player, Sprite sprite, String headline, String text, int delay) {
		super(player.getInput(), sprite);
		this.headline = headline;
		width 		= Game.width/3 + 35;
		height 		= Game.height/9;
		texts 		= new Text[1];
		texts[0] 	= new Text(text, this);
		this.waitTimer = delay;
		oncePressed = true;
		setPositionCenter();
	}
	
	/**
	 * constructor
	 * @param player
	 * @param sprite
	 * @param headline
	 * @param text
	 * @param oncePressed
	 */
	public Message(Player player, Sprite sprite, String headline, String text, boolean oncePressed) {
		super(player.getInput(), sprite);
		this.headline = headline;
		width 		= Game.width/3 + 35;
		height 		= Game.height/9;
		texts 		= new Text[1];
		texts[0] 	= new Text(text, this);
		this.oncePressed = oncePressed;
		setPositionCenter();
	}
	
	/**
	 * message with individual width and height
	 * @param player
	 * @param width
	 * @param height
	 * @param sprite
	 * @param headline
	 * @param text
	 */
	public Message(Player player, int width, int height, Sprite sprite, String headline, String text) {
		super(player.getInput(), width, height, sprite);
		this.headline = headline;
		this.width = width;
		this.height = height;
		texts = new Text[1];
		texts[0] = new Text(text, this);
		setPositionCenter();
	}
}