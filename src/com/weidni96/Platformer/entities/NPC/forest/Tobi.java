package com.weidni96.Platformer.entities.NPC.forest;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.graphics.Screen;

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
        String[] a = {"#Du hast mein Versteck gefunden! Erz\u00E4hle bitte niemanden davon!"};
        dialogs.add(a);

        String[] b = {"#Du musst es mir versprechen!"};
        dialogs.add(b);

        String[] c = {"#Das ist mein Platz und er muss auf jedenfall geheim bleiben!"};
        dialogs.add(c);

        String[] d = {"#Keine Eindringlinge erw\u00FCnscht!"};
        dialogs.add(d);

        String[] e = {"#Ich komme immer hier her, wenn ich mich schlecht f\u00FChle..."};
        dialogs.add(e);

        String[] f = {"#Bitte lass mich alleine hier sein."};
        dialogs.add(f);

        String[] g = {"#Wieso gehst du nicht einfach?"};
        dialogs.add(g);

        String[] h = {"#Dann bleib halt wenn es dich gl\u00FCcklich macht..."};
        dialogs.add(h);

        String[] i = {"#Das war nat\u00FCrlich nicht ernst gemeint! Was willst du von mir?!"};
        dialogs.add(i);

        String[] j = {"#Wir k\u00F6nnen das hier auf die harte oder weiche Tour regeln!"};
        dialogs.add(j);

        String[] k = {"#Willst du es wirklich drauf anlegen?"};
        dialogs.add(k);

        String[] l = {"#Ich z\u00E4hle bis 3 und wenn du dann noch nicht verschwunden bist gibt es ein Problem. also:"};
        dialogs.add(l);

        String[] m = {"#1...2...3..."};
        dialogs.add(m);

        String[] n = {"#Okay, du hast mich durchschaut, ich kann keine Gewalt anwenden! zufrieden?!"};
        dialogs.add(n);

        String[] o = {"#Hasst du mich allen ernstes so sehr?..."};
        dialogs.add(o);

        String[] p = {"#Na gut, letzter Versuch: Was h\u00E4lst du davon, wenn ich dir Geld gebe damit du verschwindest?"};
        dialogs.add(p);

        String[] q = {"#Eine gute Idee, oder? Also warte kurz."};
        dialogs.add(q);

        String[] r = {"#Warte ich habe gleich mein Geld gefunden..."};
        dialogs.add(r);

        String[] s = {"#Nur noch eine Sekunde."};
        dialogs.add(s);

        String[] t = {"#So, hier, nimm es und lass mich in Ruhe."};
        dialogs.add(t);

        String[] u = {"#Was? Ich habe dir kein Geld gegeben? HA, da siehst du mal wie es ist verarscht zu werden!"};
        dialogs.add(u);

        String[] v = {"#Das kommt davon wenn du dich mit dem Falschen anlegst. Ich bin kein meister der Gewalt, aber Meister darin Hoffnungen zerplatzen zu lassen."};
        dialogs.add(v);

        String[] w = {"#Ich hoffe der Groll wird dir auf ewig inne wohnen!"};
        dialogs.add(w);
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
