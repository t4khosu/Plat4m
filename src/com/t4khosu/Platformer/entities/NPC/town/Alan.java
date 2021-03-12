package com.t4khosu.Platformer.entities.NPC.town;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;

public class Alan extends NPC {


    private boolean turnBackgroundBlack = false;

    /**
     * constructor, look left
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
    public Alan(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
        super(x, y, sprite, level, walker, name, actionChange, basis);
        dirX = -1;
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        String[] ch = {"ja (50 Rul)", "nein"};
        choices.add(new Choices(0, ch));

        actualDialog = 0;
        String[] a = {"#Willkommen in meinem Spieleparadies.",
                "#Hier kannst du viele, tolle Preise gewinnen.",
                "#Wie sieht's aus, möchtest du dein Können unter beweis stellen?"
        };
        dialogs.add(a);

        String[] b = {"#Okay, dann vielleicht ein andern mal..."};
        dialogs.add(b);

        String[] c = {"#Sehr gut, dann pass auf, die Regeln sind einfach!",
                "#Du bekommst von mir drei Versuche",
                "#Wenn du es schaffst das Spiel zu beenden, bekommst du einen Preis.",
                "#Also bist du bereit? Ja? Dann auf, lass das Spiel beginnen."};
        dialogs.add(c);

        String[] d = {"#Du hast nicht genug Geld."};
        dialogs.add(d);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 2) {
            //area.setCutscene(new Minigame1Cutscene(area));
        }
        if (actualDialog == 0) {
            if (choices.get(0).getSelectedChoice() == 0) {
                if (level.getPlayer().getRul() >= 50) {
                    actualDialog += 2;
                    level.getPlayer().useRul(50);
                    //start Game
                } else {
                    actualDialog += 3;
                }

            } else {
                actualDialog++;
            }
        } else {
            actualDialog = 0;
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
     * @params creen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.15f, 0.9f);
        if (turnBackgroundBlack) {
            screen.turnBlack();
        }
    }
}
