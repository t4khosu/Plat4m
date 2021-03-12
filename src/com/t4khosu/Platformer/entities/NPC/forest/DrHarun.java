package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

public class DrHarun extends NPC {

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
    public DrHarun(int x, int y, Level level) {
        super(x, y, null, level, true, "Dr. Harun", 30, 150);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {"#Einst funkelten die Kristalle dieser H\u00F6le himmelblau und sternenklar,",
                "#Doch seitdem diese Rohre gebaut wurden, hat diese Fl\u00FCssigkeit nicht nur das \u00D6kosystem",
                "#Sondern auch unserer Mineralien verschmutzt...",
                "#Ich habe versucht den Ursprung des Schadens zu finden, aber hier ist nichts.",
                "#Nirgends etwas. Nicht einmal ein Anhaltspunkt.",
                "#Ich werde meine Suche wohl aufgeben m\u00FCssen..."};
        dialogs.add(a);

        String[] b = {"#Ich wei\u00df nicht was passiert ist...",
                "#ES GAB EINEN RIESEN KNALL",
                "#Und pl\u00F6tzlich haben die Rohe aufgeh\u00F6rt zu arbeiten!",
                "#Schau dich nur um!",
                "#Das Funkeln dieser H\u00F6le ist endlich wieder da.",
                "#Ich wei\u00df nicht wie du es gemacht hast, aber ich werde dir auf ewig dankbar sein!"};
        dialogs.add(b);

        String[] c = {"#Ich bin so gl\u00FCcklich!"};
        dialogs.add(c);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 1) {
            actualDialog++;
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        if (actualDialog == 0 && world.getDungeon_01().isFinished()) {
            actualDialog++;
        }
        talking = true;
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.08f, 1.0f);
    }

}
