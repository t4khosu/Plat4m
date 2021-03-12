package com.weidni96.Platformer.entities.NPC.forest;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.extras.Money;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

public class Honja extends NPC {

    /**
     * constructor, specific hair
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
    public Honja(int x, int y, Level level) {
        super(x, y, null, level, false, "Honja", 50, 400);

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
        String[] d_0 = {"#Hey! Es ist geschafft! Ich bin endlich fertig!",
                "#Schau dir den Blick an!",
                "#Ich wei\u00df was manche sagen, dass es nutzlos w\u00E4re diesen Turm zu bauen. Aber man kann nicht nur Arbeiten des Nutzens wegen.",
                "#Ich brauche etwas anderes. Etwas das mich erf\u00FCllt.",
                "#Man hat uns fast alles genommen und wir m\u00FCssen ums \u00dcberleben k\u00E4mpfen. Aber das ist nicht fair! Auch wir verdienen es das Leben zu leben!",
                "#Die Menschen hier haben viel durchgemacht, Gewalt, Terror, Unterdr\u00FCckung. Aber nur deswegen kann man sein altes Leben doch nicht vergessen!",
                "#Wir m\u00FCssen weiter machen und nach vorne sehen!",
                "#...",
                "#Entschuldige, hier oben versinke ich schnell in Gedanken...",
                "#Hast du eigentlich Lust heute mit auf das Dorffest zu kommen?",
                "#MOMENT",
                "#Wer bist du \u00FCberhaupt??",
                "#Hmm... na ja, ist ja auch egal."
        };
        dialogs.add(d_0);

        String[] d_1 = {"#Vielleicht sieht man sich ja irgendwann!"};
        dialogs.add(d_1);

        String[] d_2 = {"#Hey, ich habe geh�rt du bist ein richtiger Abenteurer wenn man das so nennen kann.",
                "#Auch ich ben�tige deine Hilfe. Ich will diesen Turm ausbauen, mir eine kleine Basis aufbauen.",
                "#Daf�r brauche ich aber noch mehr Materialien.",
                "#Zum Beispiel 7 Eisenbarren!",
                "#K�nntest du mir diese besorgen, es w�re eine rie�ige Hilfe."};
        dialogs.add(d_2);

        String[] d_3 = {"#Bitte bring mir 7 Eisenbarren.",
                "#Erst dann kann ich meinen Turm ausbauen!"};
        dialogs.add(d_3);

        String[] d_4 = {"#Wow danke dir!",
                "#Endlich kann ich weiter arbeiten!"};
        dialogs.add(d_4);

        String[] d_5 = {"#*Arbeitet an Ihrem Turm*"};
        dialogs.add(d_5);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) actualDialog++;
        else if (actualDialog == 2) {
            startQuest();
            actualDialog++;
        } else if (actualDialog == 4) {
            actualDialog++;
            givePlayerItem(new Money(), 70);
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;

        if (actualDialog == 3) {
            Item i = playerHoldsItem(Item.ironBar_ID, 7);
            if (i != null) {
                actualDialog++;
                finishQuest();
                i.useItem(7);
            }
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.6f, 0.6f);
        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.78f, 0.70f);
        }
        questRender(screen);
    }
}
