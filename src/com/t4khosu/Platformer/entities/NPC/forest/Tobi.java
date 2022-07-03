package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

public class Tobi extends NPC {

    /**
     * constructor
     *
     * @param x
     * @param y
     * @param sprite
     * @param level
     * @param walker
     * @param name
     * @param actionChange
     * @param basis
     */
    public Tobi(int x, int y, Level level) {
        super(x, y, null, level, false, "Tobi", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {"#Du hast mein geheimes Versteck gefunden? Bitte erzähle niemanden davon!"};
        dialogs.add(a);

        String[] b = {"#Du musst es mir versprechen!"};
        dialogs.add(b);

        String[] c = {"#Das ist mein Versteck und es muss geheim bleiben!"};
        dialogs.add(c);

        String[] d = {"#Eigentlich darf niemand außer mir hier sein."};
        dialogs.add(d);

        String[] e = {"#Ich bin immer hier, wenn ich mich unwohl fühle."};
        dialogs.add(e);

        String[] f = {"#Also lass mich bitte in Ruhe."};
        dialogs.add(f);

        String[] g = {"#Wieso gehst du nicht?"};
        dialogs.add(g);

        String[] h = {"#Dann bleib halt. Wenn es dich glücklich macht..."};
        dialogs.add(h);

        String[] i = {"#Das war nicht ernst gemeint! Geh!"};
        dialogs.add(i);

        String[] j = {"#Wir können das auch auf die harte Tour machen!"};
        dialogs.add(j);

        String[] k = {"#Willst du es riskieren?"};
        dialogs.add(k);

        String[] l = {"#Ich zähle bis 3. Wenn du bis dahin nicht verschwunden bist, dann..."};
        dialogs.add(l);

        String[] m = {"#1...2...3..."};
        dialogs.add(m);

        String[] n = {"#Okay, du hast mich durchschaut. Ich hasse Gewalt. Bist du jetzt zufrieden?"};
        dialogs.add(n);

        String[] o = {"#Willst du mir den Tag allen ernstes kaputt machen?"};
        dialogs.add(o);

        String[] p = {"#Na gut. Was hälst du davon: Ich gebe dir Geld und dafür verschwindest du."};
        dialogs.add(p);

        String[] q = {"#Das klingt doch gut, oder? Ich muss nur eben mein Geld suchen."};
        dialogs.add(q);

        String[] r = {"#Warte ich habe es gleich gefunden..."};
        dialogs.add(r);

        String[] s = {"#Nur noch eine Sekunde."};
        dialogs.add(s);

        String[] s1 = {"#.........."};
        dialogs.add(s1);

        String[] t = {"#So. Hier, nimm es und lass mich in Ruhe."};
        dialogs.add(t);

        String[] u = {"#Was? Ich habe dir kein Geld gegeben? Haha! Da siehst du mal wie es ist verspottet zu werden!"};
        dialogs.add(u);

        String[] v = {"#Das kommt davon, wenn du dich mit Tobi anlegst."};
        dialogs.add(v);

        String[] v1 = {"#Ich bin kein Meister der Gewalt, aber Meister darin Hoffnungen zerplatzen zu lassen."};
        dialogs.add(v1);

        String[] w = {"#Ich wünsche dir, dass du nie wieder jemanden vertrauen kannst."};
        dialogs.add(w);

        String[] x = {"#Tschüss."};
        dialogs.add(x);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog < dialogs.size() - 1) actualDialog++;
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.55f, 0.9f);
    }
}
