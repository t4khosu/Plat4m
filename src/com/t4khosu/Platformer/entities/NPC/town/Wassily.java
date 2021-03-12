package com.t4khosu.Platformer.entities.NPC.town;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

public class Wassily extends NPC {
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param walker
	 * @param name
	 * @param actionChange
	 * @param basis
	 */
	public Wassily(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
		super(x, y, sprite, level, walker, name, actionChange, basis);
	}
	
	/**
	 * generate all dialogs
	 */
	public void generateDialogs(){
		
		actualDialog = 0;
		String[] a = {"#Jede Kunst ist ein eigenes Leben. Sie ist ein Reich f�r sich.",
					"#Willkommen in meinem Atelier!",
					"#Ich hoffe dir gefallen meine Werke."};
		dialogs.add(a);
		
		String[] b = {"#Das Bild unten rechts tr�gt den Titel \"Sonnen- zwischengang\", eines meiner sp�teren Werke.",
						"#Wie du siehst sind die Farben irreal, abstrakt. Leider mochten nicht all meine Freunde diesen Stil.",
						"#Drum haben sich einige von mir und meiner Kunst abgewandt..."};
		dialogs.add(b);
		
		String[] c = {"#Das Bild links daneben ist das \"Blaue Feuer\" ein fr�heres Werk.",
						"#Meine damaligen Freunde und ich wollten die Romantik wieder ins Leben rufen",
						"#Dabei haben wir sie mit modernen Mitteln wiederbelebt."};
		dialogs.add(c);	
		
		String[] d = {"#Und das obere Bild... Tja, eigentlich nur eine Studie",
						"#Obwohl es kein wirkliches Werk ist, hat mir ein Reisender eine Menge Geld daf�r geboten.",
						"#Ein Verr�ckter, der dieses Symbol, das ich geschaffen hatte zum \"Symbol seinen K�nigreichs\" machen wollte.",
						"#Er nannte es... Heisser Stuhl? ... High-School? ... was wei� ich.",
						"#Manche Leute leben wohl in ihrer Wahnvorstellung."};
		dialogs.add(d);	
	}
	
	/**
	 * check when npc stops talking
	 */
	public void stopTalking(){
		talking = false;
		if(actualDialog == dialogs.size()-1){
			actualDialog = 0;
		}
		actualDialog++;
	}
	
	/**
	 * check when npc starts talking
	 */
	public void talk(){
		talking = true;
	}

	/**
	 * render sprite
	 * @params creen
	 */
	public void render(Screen screen){
		screen.renderNewHSB(x, y, sprite, true, 0.83f, 0.9f);
	}
}