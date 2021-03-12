package com.weidni96.Platformer.entities.NPC.forest;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.entities.NPC.Choices;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.interactiveEntities.Chest;
import com.weidni96.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.weidni96.Platformer.entities.interactiveEntities.plants.Plant;
import com.weidni96.Platformer.entities.item.mainItems.tools.WoodenShovel;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

import java.util.List;

public class Preng extends NPC {

    private boolean finishedField = false;

    /**
     * constructor, specific hair, player and world
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
    public Preng(int x, int y, Level level) {
        super(x, y, null, level, false, "Preng", 50, 400);

        hair_right = new AnimatedSprite(8, SpriteSheet.hair2_right_sheet, 4, 10, false);
        hair_left = new AnimatedSprite(8, SpriteSheet.hair2_left_sheet, 4, 10, false);
        hairRight = Sprite.hair2_right;
        hairLeft = Sprite.hair2_left;
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void generateDialogs() {
        actualDialog = 0;

        String[] ch = {"Ja", "Nein, danke."};
        choices.add(new Choices(4, ch));

        String[] a = {"#Die Feldarbeit wird wohl nie aufh\u00F6ren..."};
        dialogs.add(a);

        String[] b = {"#Ich habe den ganzen Tag gearbeitet und wollte mich nun um das Feld k\u00FCmmern",
                "#Doch habe ich mir den Kn\u00F6chel verstaucht und kann nicht mehr arbeiten...",
                "#K\u00F6nntest du mir vielleicht helfen?",
                "#Du kannst meine Schaufel haben. Die Saat befindet sich in der Kiste gegen\u00FCber vom Teich."};
        dialogs.add(b);

        String[] c = {"#Mit der Schaufel kannst du die Erde umgraben",
                "#Dann kannst du die Saat aus meiner Kiste streuen.",
                "#Ich z\u00E4hle auf dich!"};
        dialogs.add(c);

        String[] d = {"#Du hast es geschafft! Vielen dank f\u00FCr deine Hilfe!",
                "#Ich werde nicht die ganze Ernte brauchen. Und da alles schell nachw\u00E4chst, kannst du dich gerne am Ertrag bedienen.",
                "#Wir haben einen H\u00E4ndler. Diesem kannst du deinen Ertrag verkaufen."};
        dialogs.add(d);

        String[] e = {"#M\u00F6chtest du noch etwas \u00FCber Anbau und Ernte erfahren?"};
        dialogs.add(e);


        String[] f = {"#Okay, pass auf:",
                "#Dir ist sicher aufgefallen, dass Pflanzen verschiedene Wachstumsstadien haben.",
                "#Diese k\u00F6nnen von Pflanze zu Pflanze unterschiedlich sein.",
                "#Manche Pflanzen werden bei der Ernte zerst\u00F6rt und m\u00FCssen neu ges\u00E4t werden.",
                "#Andere kannst du abernten. Diese wachsen schneller wieder nach. Jedoch kannst du sie nur f\u00FCr weniger Geld verkaufen.",
                "#Ernten kannst du, indem du H gedr\u00FCckt h\u00E4lst.",
                "#Desweiteren gibt es neben dem Spaten auch eine Harke, mit der du Gras anbaubar machen kannst.",
                "#Jedoch kann ich dir meine nicht geben. Du musst dir wohl selbst eine suchen.",
                "#Das wars mit meinem Wissen. Ich hoffe ich konnte dir helfen."};
        dialogs.add(f);

        String[] g = {"#Okay, dann gutes Gelingen."};
        dialogs.add(g);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 1) {
            givePlayerItem(new WoodenShovel(), 1);

            List<InteractiveEntity> ies = level.getInteractiveEntities(21 * 8, 45 * 8);
            for (InteractiveEntity ie : ies) {
                if (ie instanceof Chest) {
                    ((Chest) ie).setPermission(true);
                    break;
                }
            }

            startQuest();
            actualDialog++;
        } else if (finishedField && actualDialog == 2) {
            finishQuest();
            actualDialog++;
        } else if (actualDialog == 3) actualDialog++;

        else if (actualDialog == 4) {
            if (choices.get(0).getSelectedChoice() == 0) { //explain
                actualDialog += 1;
            } else { //not explain
                actualDialog += 2;
            }
        } else if (actualDialog == 5 || actualDialog == 6) {
            actualDialog = 4;
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;

        if (actualDialog == 2) {
            for (int i = 64; i < 80; i++) {
                List<InteractiveEntity> ies = level.getInteractiveEntities(i * 8, 45 * 8);
                Plant p = null;
                for (InteractiveEntity ie : ies) {
                    if (ie instanceof Plant) {
                        p = (Plant) ie;
                        break;
                    }
                }
                if (p == null) {
                    return;
                }
            }
            actualDialog++;
            finishQuest();
            NPCManager.dregen_neuleben.subQuestPoint();
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.4f, 0.9f);
        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.3f, 0.0f);
        }
        questRender(screen);
    }
}
