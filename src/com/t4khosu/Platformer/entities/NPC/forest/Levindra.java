package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;
import com.t4khosu.Platformer.entities.item.Item;

public class Levindra extends NPC {

    /**
     * constructor, with specific hait and player
     *
     * @param x
     * @param y
     * @param sprite
     * @param level
     * @param walker
     * @param name
     * @param actionChange
     * @param basis
     * @param player
     */
    public Levindra(int x, int y, Level level) {
        super(x, y, null, level, true, "Levindra", 50, 400);

        hair_right = new AnimatedSprite(8, SpriteSheet.hair1_right_sheet, 4, 10, false);
        hair_left = new AnimatedSprite(8, SpriteSheet.hair1_left_sheet, 4, 10, false);
        hairRight = Sprite.hair1_right;
        hairLeft = Sprite.hair1_left;
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;

        String[] a = {"#Ein neues Gesicht. Willkommen!"};
        dialogs.add(a);

        String[] b = {"#Hallo",
                "#Du musst mir dringend helfen.",
                "#Heute findet ein Fest statt, und ich habe versprochen, mich um das Essen zu k\u00FCmmern.",
                "#...Jedoch habe vergessen, Fische zu besorgen.",
                "#K\u00F6nntest du mir ein paar Fische fangen?",
                "#...",
                "#Du machst es? Vielen dank!",
                "#Da ich viele Beilagen vorbereitet habe, sollten drei Fische reichen. Bitte beeile dich."};
        dialogs.add(b);

        String[] c = {"#Drei Fische sollten f\u00FCr heute Abend ausreichen.",
                "#Und falls du eine Angel brauchst, solltest du Ahb fragen. Er ist leidenschaftlicher Angler!"};
        dialogs.add(c);

        String[] d = {"#Wow, die sehen fabelhaft aus! Damit sollten wir gen\u00FCgend Essen f\u00FCr heute Abend haben."};
        dialogs.add(d);

        String[] e = {"#Vielen Dank f\u00FCr deine Hilfe!"};
        dialogs.add(e);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 1) {
            actualDialog++;
            startQuest();
        }
        if (actualDialog == 3) {
            finishQuest();
            actualDialog++;
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
            if ((i = playerHoldsItem(Item.corjack_ID, 3)) != null) {
                actualDialog++;
                i.useItem(3);
            }
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.2f, 0.9f);

        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.6f, 0.9f);
        }

        questRender(screen);
    }
}