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
		super(x, y, level, "Geschichte des Stammes");
	}

	@Override
	public void initSites() {
		sites.add("*Einige Seiten scheinen zu fehlen*");
		sites.add("[...]");
		sites.add("X232: Nach dem Tag des violetten Regens behauptete sich Orna Daithron als willensträkstes und intelligentestes");
		sites.add("Gruppenmitglied. Man beschloss, Sie als neue Stammesführerin einzusetzen.");
		sites.add("X245: Als Daithron an der violetten Pockenkrankheit starb, setzte man Ihren Bruder Neem Daithron als Stammesleiter ein.");
		sites.add("Neem lies neben einfachen Häusern auch die neue Dorfkirche Mezquita im Osten erbauen.");
		sites.add("[...]");
		sites.add("... starb in hohem Alter. Trotz Sohn Flick kam es zum Konflikt, wer die Stammesleistung übernehmen soll.");
		sites.add("Ein Teil des Stammes bestand auf Flick Daithron, Sohn von Neem Daithron.");
		sites.add("Ein anderer Teil kritisierte Flick und wollte stattdessen Tora Menis als neue Leiterin kühren.");
		sites.add("Der Konflikt hatte zur Folge, dass sich der Stamm splittete.");
		sites.add("X285: Flick Daithron übernimmt die Stammesführung.");
		sites.add("[...]");
		sites.add("X289: Flick wurde von einer Gruppe infizierter Waldwesen überrascht und getötet.");
		sites.add("Sein einziger Sohn, Dregen Daithron, muss im alter von 16 Jahren die Leitung des Stammes übernehmen.");
		sites.add("[...]");
	}
}
