package com.t4khosu.Platformer.entities.interactiveEntities.bookshelfes;

import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.Level.Level;

public class Walker1_Bookshelf extends Bookshelf {

	public Walker1_Bookshelf(int x, int y, Level level) {
		super(x, y, level, "Tagebuch 1");
	}

	@Override
	public void initSites() {
		sites.add("01.05.X231");
		sites.add("Auf meiner Reise zum Stadtzentrum von BELLMARE wollte ich meinem alten Freund Pran einen Besuch abstatten");
		sites.add("Es hat sich nichts ge\u00E4ndert. Noch immer lebt er hier unten, im alten Minenschacht G6... wie h\u00E4lt er das nur aus?");
		sites.add("Wir erz\u00E4hlten \u00FCber alte Zeiten, \u00FCber unsere Jugend... unsere Abenteuer.");
		sites.add("Es war eine sch\u00F6ne Zeit.");
		sites.add("Doch sind wir nun erwachsen und haben auch Verpflichtungen! ... zumindest ich ...");
		sites.add("Morgen werde ich dann unserer \"lieben\" Frau B\u00FCrgermeister \"Pleur Nightbush\" einen Besuch abstatten um Ihr die Dokumente zu geben.");
		sites.add("Im Endeffekt bin ich auch nicht mehr als ein Laufburche geworden... Ich frage mich ob aus mir mehr h\u00E4tte werden k\u00F6nnen...");
		sites.add("Aber daf\u00FCr ist es wohl zu sp\u00E4t... wie auch immer... gute Nacht.");
	}

}
