package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.extras.Money;

public class Gorn extends NPC {

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
    public Gorn(int x, int y, Level level) {
        super(x, y, null, level, true, "Gorn", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {
                "#...",
                "#Ehm..",
                "#Ha-a-llo.... Fremder?",
                "#Also...",
                "#Hmm....",
                "#*Gorn schaut nervös in eine andere Richtung*"

        };
        dialogs.add(a);

        String[] b = {"#Hey du...",
                "#Also ehm...",
                "#Ich habe geh\u00F6-h\u00F6rt........ du.... ehm...",
                "#S-s-sollst und aushelfen?...",
                "#Also... also wie soll ich sagen...",
                "#I-ich brauche deine Hilfe.........",
                "#Ehm... K-Kurb verkauft zur Zeit... Weizen!",
                "#Ich brauche Weizen!",
                "#...................",
                "#A-Aber Kurb ist... ist immer so grob",
                "#K-k-k\u00F6nntest duuu... ehhhm.... mir etwas... WEIZEN KAUFEN?!",
                "#Ich gebe dir auch Geld!",
                "#......................",
                "#W-w-w-wirklich???? Das tust du??",
                "#Vielen vielen vielen vielen Dank!! .... ehhhhm......",
                "#Ich b-brauche 5 Weizen",
                "#Bitte beeil dich!",
        };
        dialogs.add(b);

        String[] c = {"#Ehmmmm",
                "#W-w-w-wo ist mein Weizen??",
                "#*Schluchz*",
                "#*Wein*"
        };
        dialogs.add(c);

        String[] d = {"#Mein W-w-w-WEIZEN!",
                "#DANKE! .... ehm.... du hast es geschafft....",
                "#Hier... nimm das als Dank...",
                "#................ehm...........",
                "#*Sein Gesicht ist rot angelaufen*",
        };
        dialogs.add(d);

        String[] e = {"#*Er schaut dich mit rotem Gesicht an*"
        };
        dialogs.add(e);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) {
            dirX *= -1;
        }
        if (actualDialog == 1) {
            actualDialog++;
            startQuest();
            givePlayerItem(new Money(), 60);
        }
        if (actualDialog == 3) {
            actualDialog++;
            finishQuest();
            givePlayerItem(new Money(), 40);
            NPCManager.dregen_neuleben.subQuestPoint();
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;

        if (actualDialog == 2) {
            Item i;
            if ((i = playerHoldsItem(Item.wheat_ID, 5)) != null) {
                actualDialog++;
                i.useItem(5);
            }
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.2f, 0.7f);
        questRender(screen);
    }
}
