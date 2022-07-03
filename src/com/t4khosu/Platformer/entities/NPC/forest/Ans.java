package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

public class Ans extends NPC {

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
    public Ans(int x, int y, Level level) {
        super(x, y, null, level, true, "Ans", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {"#Schon gewusst: wenn du <Space> drückst, kannst du Leute und Schilder ansprechen.",
                "#...",
                "#Was? Das weißt du schon?",
                "#Hmm, dann etwas anderes.",
                "#Drücke E um in dein Inventar zu gelangen.",
        };
        dialogs.add(a);

        String[] b = {"#Ich hoffe, ich konnte dir wenigstens EINE nützliche Information gegeben."};
        dialogs.add(b);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) {
            actualDialog++;
        }
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
        screen.renderNewHSB(x, y, sprite, true, 0.8f, 0.5f);
    }
}
