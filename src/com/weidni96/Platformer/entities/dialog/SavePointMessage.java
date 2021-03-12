package com.weidni96.Platformer.entities.dialog;

import com.weidni96.Platformer.entities.interactiveEntities.SavePoint;
import com.weidni96.Platformer.entities.player.Player;

public class SavePointMessage extends MultiChoiceMessage{

	private SavePoint savePoint;
	
	public SavePointMessage(Player player, SavePoint savePoint) {
		super(player, "Speichern", "Position speichern?", new String[]{"ja", "nein"});
		this.savePoint = savePoint;
	}
	
	@Override
	public void individualUpdate(){
		if(removed){
			if(selectedChoice == 0){ //ja
				savePoint.activate();
			}else{ //nein
				
			}
		}
	}

}
