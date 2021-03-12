/*
 * Plat4m, Version Alpha 0.1.1
 * Letztes Update: 28.08.2016:
 * 
 * - Ferstigstellung NPCs im zweiten Abschnitt des Walddorfes
 * - NPCs die keine Besonderheit haben sagen zufaellige Texte
 * - Neue Behaarung: Baerte
 * - Neue Pflanze zum Anbauen: Weizen
 * - Anfang Garten-center
 * 
 * Plat4m, Version Alpha 0.1.2
 * Letztes Update: 29.08.2016:
 * 
 * - Pflanzen (Weizen und Kirschen) kann man jetzt ernten
 * - Warper um in grosse Gebaeude zu kommen
 * - Farmhaus in der Stadt fertig gebaut
 * 
 * Plat4m, Version Alpha 0.1.3
 * Letztes Update: 31.08.2016:
 * 
 * - Multible Choice antworten bei NPCs sind moeglich
 * - Neus Interface
 * - Geldeinheit eingefuehrt
 * 
 * Plat4m, Version Alpha 0.1.4
 * Letztes Update: 01.09.2016:
 * 
 * - Schnellleiste fuer kleine Items hat jetzt Zahlen
 * - Einfueren von Sprites fuer Leben und Geld, dazu eine Anzeige
 * - Erfahrungspunkteleiste
 * - Schwert kann man jetzt schwingen, macht aber noch keinen Schaden
 * 
 * Plat4m, Version Alpha 0.1.5
 * Letztes Update: 03.09.2016:
 * 
 * - natuerlichere Bewegung von Slimes
 * - Slimes geben Erfahrung wenn sie sterben
 * - Haben Mobs nicht mehr volles Leben wird die Lebensanzeige angezeigt
 * - Schwerter machen nun damage an Mobs mit optimierter Kollision
 * - Level ups sind moeglich bei genug exp
 * - Slimes fallen nicht mehr aus dem level
 * - Slimes haben ein Sterbesprite und geben nun auch Geld
 * - Wand am Waldeseingang, NPC laesst einen nicht durch, bevor man eine Waffe hat
 * 
 * Plat4m, Version Alpha 0.1.6
 * Letztes Update: 05.09.2016:
 * 
 * - Es gibt nun Blumen
 * - neues Level designt 
 * - Neue Gegner: Spinnen
 * - Gras das man kaputt machen kann
 * - Man findet jetzt auch Geld in Kisten
 * - Neuer Mittelgrund fuer den ersten Waldteil
 * - Spinnen bewegen sich nicht mehr durch Bloecke
 * - Schwerter kann man in Stadtgebieten nicht mehr nutzen
 * - Fertigstellung neuer Waldabschnitt
 * 
 * Plat4m, Version Alpha 0.1.7
 * Letztes Update: 05.09.2016:
 * 
 * - Baeume gibt es jetzt auch im vordergrund
 * - Unterschiedliche Spinnen
 * - Mobs koennen nun damage am Spieler machen
 * - Gras schneiden gefixt
 * - Betten haben keine Kollision mehr
 * 
 * Plat4m, Version Alpha 0.1.8
 * Letztes Update: 26.09.2016:
 * 
 * - Gruene Spinnen schiessen Giftkugeln
 * - Player kann vergiftet werden und nimmt Schaden ueber Zeit hinweg
 * - Stati: unter Wasser, gerade schaden genommen und vergiftet werden ueber dem Spieler angezeigt
 * - NPCs haben eine Anzeige fuer Quests
 * - Fix schwerter Sprites, geht jetzt fliessend
 * - Fix, tote Slimes machen keinen Schaden mehr
 * - Fix, Gegner nehmen so viel Schaden wie das Schwert machen kann
 * - Coins spawnen aus grass und man bekommt das Geld
 * - neue Textur fuer Slimes
 * 
 * Plat4m, Version Alpha 0.1.9
 * Letztes Update: 03.10.2016:
 * 
 * - Sprites fuer Kisten, die man nicht oeffnen kann und fuer Fehlschlaege beim Angeln
 * - Levindra's Fischquest fertiggestellt
 * - Prens's Erntequest fertiggestellt
 * - Anzeige fuer Damage ist nun Lebensanzeige
 * - Bei Vergiftung wird Lebensanzeige pink
 * - Vergiftung toetet nicht mehr, sondern saenkt HP hoechstens auf 1
 * - Log, der anzeigt wenn man etwas toetet bzw findet. kann mit L permanent angezeigt werden
 * - Mine mit Pflanzen, neuem Wasser und Hintergrund versehen
 * - Eisen in den Minen das man abbauen kann
 * - Geld wird nicht mehr im log angezeigt + neuer Sprite
 * - Health gibt es nicht mehr im Gras
 * - Spitzhacken brauchen Stamina
 * - Stamina regeneriert sich ueber Zeit sofern man nicht arbeitet
 * - Ueberarbeiteter Log
 * 
 * Plat4m, Version Alpha 0.1.10
 * Letztes Update: 03.10.2016:
 * 
 * - neue Gegner: Steinschnecken, in H\u00F6len
 * - Einfuerung von simplen Shops in denen man kaufen kann
 * - Einfuegen von Itemstores fuer alle Entitaeten. Beim kauf wird Log angezeigt + Inventaranzahl
 * - BreakStone funktioniert mit verschiedenen Aexten
 * - Eisen und Kohle kann man nun abbauen
 * - Fix Inventory
 * - Mining hat eine Zeitanzeige wie lange das Abbauen dauert
 * - neuer Gegner: Untergrund Schleim
 * - in Hoelen waechst nun anderes Gras
 * - einfuegen von Spikes die Damage machen
 * - Pflanzen kann man wieder anbauen
 * - Rolbeeren als neue Pflanze funktionieren
 * - Yocip als Pflanze hinzugefuegt, Pflanzen funktioniren nun alle
 * - unterirdische Kisten
 * - Ernten funktioniert fuer alle Pflanzen
 * - Rolbeeren sind nun voll funktionsfaehig
 * - Yocip -"-
 * - Handel fixen, Spruenge funktionieren fuer Variable ItemStore Hoehen
 * - Loot Beutel wenn Gegner besiegt werden
 * - Loot Beutel erhalten wahrscheinlichkeit des Droppens
 * - Loot Beutel blinken, verschwindet beim Druecken der Aktionstaste und geben Loot + Symbol zum Anzeigen
 * - Erweitern Lootbeute fuer alle Mobs + definiertes Upward Symbol fuer jeweilige Items
 * - Vollstaendig funktionierendes Inventar mit Unterabschnitten
 * - Haunted Forest 02 fertig ausgebaut
 * - Chest messages funktionieren nun ueberall
 * - neue Inventarabschnitte fuer Lebensmittel und Extras

 * Plat4m, Version Alpha 0.1.11
 * Letztes Update: 02.12.2016:
 * - Heiltraenke implementiert, funktionieren komplett
 * - Traenke kann man in die kleinen Slots bewegen, Zahlen als Inputs funktionieren
 * - Traenke Anzahl in small Slots
 * 
 * + Explosion beim Level up
 * + Fix beim Pause druecken und Gegner auf einem verliert man Leben.
 * + typeable keys implementieren in der Klasse Keyboard
 * + Mine ausbauen bis zum 2. Dungeon
 * + Moeglichkeit Traenke zu mischen
 * + Haunted Forest ausbauen + weitere Gebiete fertig anbringen, neue hidden spots einbauen
 * + Neues Gras fuer das Gebiet nahe Cimbria
 * + Raetsel ueberlegen um ins zweite Dungeon zu kommen
 * + Ausgraben eines schalters + zerstoeren einer wand fuer zweiten schalter -> steinwand bewegt sich nach unten nachdem kamera darauf geht, alles im 2. Minenteil
 * + Spoiler Mann, "willst du einen Spoiler hoeren?" - Liste mit Antworten. Muss in der Stadt sein.
 * + Buecherregale
 * + Codierte Zeichenketten in Buecherregalen einfuegen
 * 
 * 
 * Plat4m, Version Alpha 0.6
 * Letztes Update: 17.02.2017:
 * 
 * - Cutscenes funktionieren mit beweglicher Kamera
 * - 1. Dungeon Eingang fertig
 * - Sprites als Images ermoeglichen
 * - richtiges rendern der pipes
 * - funktionierende Tueren
 * - Eintreten in das Dungeon
 * - Dungeontitel anzeigen beim Eintreten
 * - Blaue Fackeln
 * 
 * 
 * Plat4m, Version Alpha 0.7 (Refactoring)
 * Letztes Update: 17.02.2017:
 * 
 * - keine Images mehr
 * - Refactoring der foorest NPCs fertig, NPC, Player, Mob, Enemies
 * - Mobs funktionieren alle und sind kommentiert
 * - Slimes springen wenn sie geschlagen werden
 * - fixPosition funktion in activityManager bzw. player nicht mehr benoetigt
 * - town Leute kommentieren
 * - mining, breakStone, plowing und SlowMovingEntities funktionieren und sind dokumentiert
 * - Planting geht und plowing auch perfekt
 * - harvesting geht
 * - fix upward symbol
 * - "Diese Kiste gehoert dir nicht" - Bug entfernen
 * - interactive items to reduce amount of lists in level
 * - fishing geht wieder mit einem Fisch bis jetzt + dokumentier
 * - liquid -> UnderWater und top liquid slowed wieder
 * - activities fixen und dokumentieren
 * - fix upward symbol
 * - entities finished commenting
 * - create weather class abstract
 * - snow als weather
 * - areal aendern laesst den bildschirm schwarz werden -> zeit benoetigt um es besser darzustellen
 * - dokumentation cutscenes bis inigame fertig
 * - Tile getter muss effizienter werden(switch/case) und auslagern
 * - Upward Symbol Klasse noch gebraucht? - nein!
 * - private/public, abstract koordinieren
 * - Unn\u00F6tige Ausgaben entfernen
 * - Dokumentation aller #ddddddddKlassen + wichtige Funktionen
 * - nicht gebrauchten Code entfernen
 * - fixe inventory, mit trader gibt es probleme
 * - betreten von t\u00FCren l\u00E4sst player kurz springen
 * - loot fixen, dass player es aufsammeln kann
 * - aufflackern screen wenn man durch t\u00FCren geht
 * - Regen unterirdisch, wenn kein background da ist der dunkler wird --> error
 * 
 * 
 * Plat4m, Version Alpha 0.8
 * Letztes Update: 30.07.2017:
 * 
 * - slimes fliegen beim schild lesen xD
 * - Zuletzt gehitteter Mob wird angezeigt mit Leben und Lifebar
 * - Hat ein Mob ein hoeheres lvl als der player, bekommt er nur halben Schaden
 * - 1. dungeon ausbauen
 * 		- Neue Sprites f\u00FCr das Dungeon, Flare aufbauen, Moos, 
 * 		- Positionierung pMachine
 * 		- neue Items, keys und sowas
 * 		- Boss
 * - einfacherer Funktion um areale/levels zu aendern. muss position mit aendern
 * - Boss Raeume resetten sich nicht
 * - Berechnungen Surface Klasse auslagern und nur einmal ausfuehren
 * - exp ueberlauf
 * + boss slime auslagern in level, bis man ueberall verwenden kann
 * + kisten brauchen eine leertaste zu viel beim dialog
 * - Timer beim Boss geht im pause modus nach unten
 * - gift zieht im pause modus leben ab, soll nicht so sein!
 * - funkelsteine im 2. teil untergrund auch einbringen
 * - schwert schlag animation macht manchmal noch probleme
 * - areas nicht ueber array zugreifen, sondern name (vlt)
 * 
 * Plat4m, Version Alpha 0.9 (Prae Alpha)
 * Letztes Update: 19.09.2017:
 * 
 * - Locus sagt das Wetter nicht an
 * - Ans Text ragt aus der Textbox
 * - Gorn kennt player schon zu beginn
 * - Honja kennt player schon zu beginn
 * - NPCs in der manager klasse uebertragen
 * - Funktionierende Speicherpunkte implementiert
 * - Neues Areal weiter gebaut mit Raesel um die wooden pickaxe zu bekommen
 * - funktionierende bookshelves
 * - umlaute austauschen
 * - area-schild beim betreten besser
 * - droppen von items von gegnern mit wahrscheinlichkeit
 * - unterschiedliche drops pro gegner
 * 		- slime droppen schleim
 * 		- neue Quests nach bosssleim:
 * 			- jemand will 42 schleim
 * 			- jemand anders fertiges eisen (Honja, will turm erweitern)
 * - defensiv-werte fuer gegner
 * - Steinschnecken langsamer und weniger defensiv wenn draußen
 * - health potions heilen nur noch wenn leben fehlt
 * - Pflanzen wachsen auch woanders weiter
 * + mehrfach wachsende pflanzen wachsen max. 4 mal nach
 * - pflanzen kann man wieder weg machen mit schaufel
 * - anzeige welche pflanze wo gepflanzt wird bei schaufel
 * - areale neue backgrounds, verschoben
 * - pflanzen koennen entfernt werden mit der Schaufel
 * - anpflanzen zeigt einen Rahmen wo genau man etwas anpflanzt
 * - item dialog braucht zu viele inputs
 * - wetter timer auf die welt auslagern und nicht pro areal
 * - bug wenn area wechselt
 * - ChestManager fuer speicheroptionen implementieren
 * - raffiniertes Eisen gibt es
 * 
 * Plat4m, Version Beta 0.1 
 * Letztes Update: 07.10.2017:
 * 
 * + Speichern
 * 		- Position Spieler
 * 		- alles im Inventar von Spieler
 * 		- aktuelle Quests und NPC-Dialoge
 * 		- Chests die schon offen sind
 * 		- pflanzen die angebaut wurden mit stadium + erde darunter anpflanzbar
 * 		+ bug bei front tiles speichern
 * + Haus bauen in neuem Dorf
 * - bug: items beim adden in handslots werden ignoriert
 * + Schmiede
 * 		- Schmelze
 * 		+ Amboss
 * - bug regen, wenn areal wechseln wird hintergrund wieder hell 
 * - schnee testen und analog zu regen fixen
 * - item verwaltung verbessern + items geben (itemstore)
 * - startmenü vorhanden, man kann ein neues Spiel starten
 * - wo wird startcutscene gestartet wtf?! (im breakpointmanager ...)

 * - schwerter mit stärkezuwachs, neue Klasse für schwerter!
 * + speicher spezialisieren und auslagern pro klasse s. NPCs
 * 
 * Arbeit Beginn am 30.03.2018, Änderungen am Log:
 * # -> ToDo, 
 * - -> Fertig
 * ! -> Wichtige Fixes
 * ? -> Hat Zeit
 * . -> Mittlere Wichtung der Dringlichkeit
 * 
 * -. softlock am Anfang des Spiels, Verkauf der Saat!
 * -! Manchmal Pixel Verschiebung, s.d. man leiter nicht mehr hoch klettern kann -> wenn man aus Wasser kommt
 * -? Buch mit Geschichte umschreiben (Manches klingt doof)
 * -. Angeln auch außerhalb von Wasser
 * #? Rechts von Neuleben: stärkeres Naturchaos
 * -. wenn tod sollten player info zahlen auch weg sein
 * -! Boss Slime kann in ecke hängen bleiben - für alle slimes fixen
 * -? Bessere lösung für erstes mal wildnis, tor, dass man nicht drüber springt. behindert nur
 * -. Analog top beschränkungen nicht notwendig. aus dem level hoch rauss springen soltle möglich sein
 * -! Wetter Hintergrund Probleme, Helligkeit
 * -? Nur noch Areale haben Hintergründe, einzelne Level nicht mehr
 * -! Speichern geht nicht mehr
 * -! Bug: nach tod noch immer vergiftet
 * 
 * -? Tutorial ausbauen
 * 		- NPC der erklärt, dass man andere NPSc mehrmals ansprechen kann
 * 		- NPC der sagt, dass man auch Bücherregale ansprechen kann
 * 
 * # Geschichte weiterentwickeln und sinnvoller gestalten
 */

/*
 * Settings 
 * -------------------
 * 
 * 1) Breakpoints ändern
 * 		Einstellungen dazu befinden sich in World.java->Konstruktor.
 * 		Hier wird ein neuer BreakPointManager erzeugt und der aktuelle Punkt gesetzt.
 * 		SetBreakPointBeginning(0) ist der Standardbeginn. Bei points = 3 ist
 * 		man direkt in der Welt.
 * 		Weiterhin kann man den PlayerModus einstellen, wobei modus = 0 der Gottmodus ist.
 * 
 * 2) Wetter Setting
 * 		Wetter wird in World.java pro Tick geupdatet. Startzeitpunkt und Dauer werden
 * 		als Attribut verwaltet und können dort zu Testzwecken geändert werden.
 * 		Das Attribut fasterWeather kann hierfür verwendet werden. Umso größer der Wert,
 * 		Desto schneller läuft der Wettervorgang ab.
 */





package com.t4khosu.Platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Surface.Surface;
import com.t4khosu.Platformer.input.Keyboard;

public class Game extends Canvas implements Runnable{
	
	/*
	 * Umlaute:
	 * ae -> \u00E4, Ae -> \u00C4
	 * oe -> \u00F6, Oe -> \u00D6
	 * ue -> \u00FC, Ue ->\u00DC
	 * sz -> \u00df,
	 * arrow right -> \u21E8,
	 */
	
	private static final long serialVersionUID = 1L;
	
	public static int 	width = 350;
	public static int 	height = width * 9 / 16;
	public static int 	scale = 3;
	
	private static String title = "Plat4m";
	private static boolean running = false;
	
	private int lastUpdatesPerSecond = 0;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	Thread thread;
	JFrame frame;
	Screen screen;
	
	Keyboard key;
	World world;
	Surface surface;
	
	public static int timer = 0;
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		screen = new Screen(width, height);
		
		//Erzeuge alles relevante hier
		key = new Keyboard();
		addKeyListener(key);
		world  = new World(key);
		surface = new Surface(key, world);
		world.initSurface(surface);
	}
	
	public synchronized void start(){
		world.getPlayer().initWorld(world);
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		requestFocus();
		
		int updates = 0;
		double lastTime = System.nanoTime();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		double deltaMili = 0;
		double lastMili = System.currentTimeMillis();
		while(running){
				
			double currentMili = System.currentTimeMillis();
			double currentTime = System.nanoTime();
			delta += (currentTime-lastTime) / ns;
			lastTime = currentTime;
				
			deltaMili += currentMili - lastMili;
			lastMili = currentMili;
			
				
			if(delta >= 1){
				if(lastUpdatesPerSecond > 55 && lastUpdatesPerSecond < 65) update(); //update
				updates++;
				delta--;
			}
			render(); //render
				
			if(deltaMili >= 1000){
				deltaMili = 0;
				lastUpdatesPerSecond = updates;
				frame.setTitle(title + " | Updates: " + updates);
				updates = 0;
			}
		}
	}
	
	public void update(){
		if(timer > 2000) timer = 0;
		timer++;

		key.update();
		world.update();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		boolean loaded = lastUpdatesPerSecond > 55 && lastUpdatesPerSecond < 65;
		//int xScroll = world.getPlayer().getX() - screen.getWidth()/2;
		//int yScroll = world.getPlayer().getY() - screen.getHeight()/2;
		
		int xScroll = world.getCamera().getX() - screen.getWidth()/2;
        int yScroll = world.getCamera().getY() - screen.getHeight()/2;
		
		if(xScroll < 0) xScroll = 0;
		if(yScroll < 0) yScroll = 0;
		if(yScroll > (world.getActualArea().getActualLevel().tileHeight*8) - screen.getHeight()) yScroll = (world.getActualArea().getActualLevel().tileHeight*8) - screen.getHeight();
		if(xScroll > (world.getActualArea().getActualLevel().tileWidth*8)  - screen.getWidth())  xScroll = (world.getActualArea().getActualLevel().tileWidth*8)  - screen.getWidth();
		
		screen.clear();
		if(loaded){
			world.render(screen, xScroll, yScroll);	
		}else{
			screen.clear();
		}
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.getPixels()[i];
		}
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		if(loaded){
			world.render(g);
		}else{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial Hebrew", Font.PLAIN, 30)); 
			g.drawString("Loading...", 30, 30);
		}
				
		g.dispose();
		bs.show();
	}
	
	
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args){
		Game game = new Game();
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setTitle(title);
		game.frame.setVisible(true);
		game.frame.setLocationRelativeTo(null);
		game.frame.setResizable(false);
		
		game.start();
	}
}
