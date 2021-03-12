package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.item.mainItems.extras.Money;

public class Mendra extends NPC {

    /**
     * constructor, has quest
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
    public Mendra(int x, int y, Level level) {
        super(x, y, null, level, false, "Mendra", 50, 200);
        havingQuest = true;
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        String[] a = {"#Hey... WARTE WAS MACHST DU HIER?",
                "#Normalerweise traut sich niemand aus dem Dorf heraus!",
                "#Was ich hier mache? Nun ja, Neuleben mitsamt Einwohnern ist mir zu ignorant geworden.",
                "#Schau dich nur um, die Natur geht unter, \u00FCberall herrscht Chaos!",
                "#Mein Ziel war es, eine L\u00F6sung zu finden. Aber bis jetzt habe ich nicht mal verstanden was hier \u00FCberhaupt passiert...",
                "#All meine Forschungen... All meine M\u00FChen waren bis jetzt vergebens.",
                "#Und schau nur, das B\u00E4umchen dort dr\u00FCben habe ich gepflanzt als ich meine Forschungen begonnen habe.",
                "#Jetzt ist es genau so vers\u00E4uscht wie der Rest, nicht mal diesen Baum konnte ich retten...",
                "#Ich wei\u00df nicht mehr was ich tun soll...",
                "#Vielleicht findest du ja eine L\u00F6sung..."};
        dialogs.add(a);

        String[] b = {"#Bitte Hilf mir ein Heilmittel zu finden.",
                "#Allein komme ich nicht mehr weiter..."};
        dialogs.add(b);

        String[] c = {"#Du konntest kein Heilmittel finden... ich verstehe...",
                "#WARTE! Du konntest die Maschinen finden diese seltsame Fl\u00FCssigkeit pumpt und ausschalten?!",
                "#Ich glaube das ist mehr als genug, vielen Dank! Vielleicht erholt sich die Natur hier bald.",
                "#Hier nimm das als Dankesch\u00F6n!"};
        dialogs.add(c);

        String[] d = {"#Du hast diese Gegend gerettet.",
                "#Ich bin dir auf ewig Dankbar!!"};
        dialogs.add(d);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) {
            actualDialog++;
            startQuest();
        }
        if (actualDialog == 2) {
            finishQuest();
            givePlayerItem(new Money(), 70);
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
        screen.renderNewHSB(x, y, sprite, true, 0.35f, 0.4f);

        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.3f, 0.0f);
        }

        questRender(screen);
    }
}