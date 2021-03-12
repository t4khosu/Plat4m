package com.t4khosu.Platformer.entities.dialog;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.player.Player;

public class MultiChoiceMessage extends Message{
	protected int selectedChoice = 0;
	private String[] choices;

	/**
	 * create dialogbox with possible choices
	 * @param player
	 * @param key
	 * @param sprite
	 * @param npc
	 * @param choices
	 */
	public MultiChoiceMessage(Player player, String headline, String text, String[] choices) {
		super(player, null, headline, text);
		this.choices = choices;
		
		texts[0].setMultiChoice(true);
		texts[0].setChoices(choices);
		
		height = Game.height/4;
		this.width 	= Game.width/3;
		setPositionCenter();
	}
	
	
	
	/**
	 * update box, move selected answer
	 */
	public void update(){
		texts[actualText].update();
		
		if(texts[actualText].getMultiChoice()){
			if(input.typedDown){
				if(selectedChoice+1 < choices.length){
					selectedChoice++;
				}
			}else if(input.typedUp){
				if(selectedChoice-1 >= 0){
					selectedChoice--;
				}
			}
		}
			
		if(input.typedInteract){
			if(oncePressed){
				//finish text
				if(texts[actualText].getShortText().length() != texts[actualText].getText().length()){ //-1 because of front sign
					texts[actualText].finishText();
				//text is finished:
				}else{
					removed = true;
				}
			}
			oncePressed = true;
			individualUpdate();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getSelectedChoice(){
		return selectedChoice;
	}
	
	/**
	 * At the end of each update -- after space-input
	 */
	public void individualUpdate(){
		
	}
}
