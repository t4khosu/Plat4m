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
        actualDialog = 0;
        String[] a = {"#Schon gewusst:",
                "#Manche Personen sagen verschiedene Dinge wenn man sie anspricht!",
                "#Eigentlich logisch... ist ja nicht so als seien wir irgendwelche k�nstlichen Intelligenzen die nur vorgeschriebene Texte sagen k�nnen.",
                "#Hahaha"};
        dialogs.add(a);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
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
        screen.renderNewHSB(x, y, sprite, true, 0.85f, 0.7f);
    }
}
