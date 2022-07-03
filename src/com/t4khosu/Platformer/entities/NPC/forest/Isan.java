package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

public class Isan extends NPC {

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
    public Isan(int x, int y, Level level) {
        super(x, y, null, level, true, "Isan", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        this.actualDialog = 0;

        String[] d1 = {
                "#Schon gewusst:",
                "#Manche Personen sagen verschiedene Dinge wenn man sie mehrfach anspricht!",
                "#Eigentlich logisch.",
                "#Wir sind schließlich keine Programme, die nur vorgeschriebene Texte sagen können.",
                "#Hahaha."
        };
        dialogs.add(d1);

        String[] d2 = {
                "#Schon gewusst:",
                "#Manche Personen sagen verschiedene Dinge wenn man sie anspricht!",
                "#Eigentlich logisch.",
                "#Wir sind schließlich keine Programme, die nur vorgeschriebene Texte sagen können.",
                "#Aber das habe ich dir ja bereits gesagt."
        };
        dialogs.add(d2);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (this.actualDialog == 0) {
            this.actualDialog += 1;
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        this.talking = true;
    }

    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.85f, 0.9f);
    }
}
