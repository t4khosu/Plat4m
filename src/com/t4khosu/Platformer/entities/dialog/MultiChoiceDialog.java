package com.t4khosu.Platformer.entities.dialog;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.input.Keyboard;

public class MultiChoiceDialog extends Dialogbox{
	
	private NPC npc;
	private int selectedChoice = 0;
	private String[] choices;
	private Player player;

	/**
	 * create dialogbox with possible choices
	 * @param player
	 * @param key
	 * @param sprite
	 * @param npc
	 * @param choices
	 */
	public MultiChoiceDialog(Player player, Keyboard key, Sprite sprite, NPC npc, String[] choices) {
		super(player.getInput(), sprite);
		this.player = player;
		this.npc = npc;
		this.choices = choices;
		
		height = Game.height/4;
		width = Game.width/3;
		
		setPositionCenter();
		npc.talk();
		
		texts = new Text[npc.getDialog(npc.getActualDialog()).length];
		for(int i = 0; i < texts.length; i++){
			texts[i] = new Text(npc.getDialog(npc.getActualDialog())[i], this);
			if(i == texts.length-1){
				texts[i].setMultiChoice(true);
				texts[i].setChoices(choices);
			}
		}
	}
	
	
	
	/**
	 * update box, move selected answer
	 */
	public void update(){
		texts[actualText].update();
		
		char c = texts[actualText].getText().charAt(0);
		if(c == '#') headline = npc.getName() + ": ";
		else if(c == '~') headline = "Du: ";
		
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
				if(texts[actualText].getShortText().length() != texts[actualText].getText().length()-1){ //-1 because of front sign
					texts[actualText].finishText();
				}else{
					if(actualText < texts.length-1) actualText++;
					else{
						if(texts[actualText].getMultiChoice()){
							Choices choices = null;
							if((choices = npc.dialogHasChoice()) != null){
								choices.setSelectedChoice(selectedChoice);
							}
						}
						removed = true;
						npc.stopTalking();
						player.getWorld().getSurface().startDialog(player, npc, true);
					}
				}
			}
			oncePressed = true;
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getSelectedChoice(){
		return selectedChoice;
	}
}