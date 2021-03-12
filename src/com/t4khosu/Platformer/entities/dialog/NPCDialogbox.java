package com.t4khosu.Platformer.entities.dialog;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.player.Player;

public class NPCDialogbox extends Dialogbox{

	private NPC npc;
	
	/**
	 * constructor, predefined size, no sprite
	 * @param player
	 * @param sprite
	 * @param npc
	 * @param oncePressed
	 */
	public NPCDialogbox(Player player, Sprite sprite, NPC npc, boolean oncePressed) {
		super(player.getInput(), sprite);
		this.npc 			= npc;
		this.oncePressed 	= oncePressed;
		this.height 	= Game.height/4;
		this.width 		= Game.width/3;
		setPositionCenter();
		npc.talk();
		
		//init all string of dialog as text objects
		texts = new Text[npc.getDialog(npc.getActualDialog()).length];
		for(int i = 0; i < texts.length; i++){
			texts[i] = new Text(npc.getDialog(npc.getActualDialog())[i], this);
		}
	}
	
	/**
	 * update texts. Depending on the first letter, change headline
	 * # -> npc
	 * ~ -> player
	 */
	public void update(){
		texts[actualText].update();
		
		char c = texts[actualText].getText().charAt(0);
		if(c == '#') headline = npc.getName() + ": ";
		else if(c == '~') headline = "Du: ";
		
		if(input.typedInteract){
			if(oncePressed){
				if(texts[actualText].getShortText().length() != texts[actualText].getText().length()-1){ //-1 because of front sign
					texts[actualText].finishText();
				}else{
					if(actualText < texts.length-1) actualText++;
					else{
						removed = true;
						npc.stopTalking();
					}
				}
			}
			oncePressed = true;
		}
	}
}