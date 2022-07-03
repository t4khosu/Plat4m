package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

public class Barus extends NPC {

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
    public Barus(int x, int y, Level level) {
        super(x, y, null, level, false, "Barus", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {
                "#Tobi versteckt sich mal wieder...",
                "#Vielleicht kannst du mit ihm sprechen?",
                "#Drücke nach unten, um in seinen Raum zu kriechen."
        };
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
        screen.renderNewHSB(x, y, sprite, true, 0.45f, 0.9f);
    }
}
