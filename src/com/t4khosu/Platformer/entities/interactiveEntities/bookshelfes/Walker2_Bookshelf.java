package com.t4khosu.Platformer.entities.interactiveEntities.bookshelfes;

import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.Level.Level;

public class Walker2_Bookshelf extends Bookshelf {

	public Walker2_Bookshelf(int x, int y, Level level) {
		super(x, y, level, "Tagebuch 2");
	}

	@Override
	public void initSites() {
		sites.add("06.05.X231");
		sites.add("Diese Hexe von B\u00FCrgermeisterin hat mich ernsthaft nochmals losgeschickt weil ein Dokument gefehlt hat...");
		sites.add("Ich hasse mein Leben...");
		sites.add("Aber okay... heute bin ich in der Sternenh\u00F6hle. Pran meinte ich solle unbedingt herkommen.");
		sites.add("Und es hat sich mehr als gelohnt, alles hier funkelt wie der Sternenhimmel!");
		sites.add("Doch war ich nicht der einzige hier. Auf meinem Weg traf ich einen Dr. Copperwing.");
		sites.add("Er meinte man h\u00E4tte hier ein sehr seltenes \u00D6l gefunden, das BELLMARE reich werden lassen k\u00F6nnte!");
		sites.add("Schon verr\u00FCckt wo sich manche Sch\u00E4tze verstecken.");
		sites.add("Aber es soll mich nicht weiter st\u00F6ren. F\u00FCrs erste bleibe ich hier und genie\u00dfe meine Ruhe.");
		sites.add("====================");
		sites.add("ENDE ALPHA");
		sites.add("Ich hoffe du hattest spa\u00df :)");
	}

}
