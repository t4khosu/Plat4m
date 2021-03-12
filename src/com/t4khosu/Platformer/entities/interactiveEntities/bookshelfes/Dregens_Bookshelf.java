package com.t4khosu.Platformer.entities.interactiveEntities.bookshelfes;

import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.Level.Level;

public class Dregens_Bookshelf extends Bookshelf {

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param level
	 */
	public Dregens_Bookshelf(int x, int y, Level level) {
		super(x, y, level, "Geschichte unserer Stammesleiter");
	}

	@Override
	public void initSites() {
		sites.add("*Einige Seiten scheinen zu fehlen*");
		sites.add("[...]");
		sites.add("X232: Nach dem Tag des violetten Regens behauptete sich \"Orna Daythorn\" als willenstr\u00E4kstes und intelligentestes " + 
					"Gruppenmitglied. Man beschloss Sie als neue Stammesf\u00FChrerin von Neuleben einzusetzen.");
		sites.add("X245: Als Daythrons an der Pockenkrankheit zugrunde ging, setzte man Ihren Bruder \"Neem Daythorn\""
					+ " als neuen Stammesleiter ein.");
		sites.add("Neem lies neben vielen, einfachen Unterk\u00FCnften auch die neue Dorfkirche \"Mezquita\" im Osten erbauen.");
		sites.add("[...]");
		sites.add("... starb in hohem Alter. Trotz vorhandenem Sohn als Nachfolger kam zum Streit, wer neuer Stammesleiter werden soll.");
		sites.add("Der konservative Teil des Stammes wollte Flick Daythorn, Sohn von Neem Daythorn, als neuen Leiter." + 
					"Der anderer Teil wollte \u00FCber eine kollektive Abstimmung den neuen Leiter w\u00E4hlen.");
		sites.add("Dieser Streit hatte zur Folge, dass sich der Stamm splittete und die zweite Gruppe gen Westen zog.");
		sites.add("X285: Flick Daythorn \u00FCbernimmt die Stammesf\u00FChrung.");
		sites.add("[...]");
		sites.add("X289: Flick wurde von einer Gruppe Schleimen �berrascht und get�tet.");
		sites.add("Sein einziger Sohn, Dregen Daythorn, muss im alter von 16 die Rolle des Stammesf\u00FChrers einnehmen...");
		sites.add("[...]");
	}
}
