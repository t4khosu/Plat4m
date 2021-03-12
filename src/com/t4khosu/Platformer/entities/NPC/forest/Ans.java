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
        String[] a = {"#Schon gewusst: wenn du SPACE dr\u00FCckst, kannst du Leute und Schilder ansprechen.",
                "#...",
                "#Was soll das hei\u00dfen, das wei\u00dft du schon?",
                "#Hmm, okay, dann etwas, das du noch nicht wusstest!",
                "#Dr\u00FCcke E um in dein Inventar zu gelangen!",
                "#HAHA damit hast du nicht gerechnet!"
        };
        dialogs.add(a);

        String[] b = {"#Ich hoffe ich habe dir wenigstens eine n\u00FCtzliche Information gegeben."};
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
