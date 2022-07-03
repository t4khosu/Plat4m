package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.interactiveEntities.Chest;
import com.t4khosu.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.item.Item;

public class Ahb extends NPC {

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
    public Ahb(int x, int y, Level level) {
        super(x, y, null, level, false, "Ahb", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        this.actualDialog = 0;

        String[] choices = {"Ja ... bitte?", "Nein, ich bin doch nicht blöd!"};
        this.choices.add(new Choices(4, choices));

        String[] d_0 = {"#Na endlich bist du wach!",
                "#Dregen hat mich gezwungen auf dich aufzupassen...",
                "#Wegen dir musste ich den ganzen Tag drinnen verbringen!",
                "#...",
                "#Ach ja, ich soll dich direkt zu ihm schicken. Er wird entschieden, was wir mit dir machen.",
                "#Es gab schon lange keine Hinrichtung mehr.",
                "#Hehe.",
                "#Na los, geh! Sonst nehme ich Dregen die Entscheidung ab!"
        };
        dialogs.add(d_0);

        String[] d_1 = {"#Was willst du noch von mir?! Geh zu Dregen! Er wohnt im großen Gebäude rechts."};
        dialogs.add(d_1);

        String[] d_2 = {"#Was willst du hier?"};
        dialogs.add(d_2);

        String[] d_3 = {"#WAS? Du brauchst MEINE Angel?! Das kannst du vergessen!",
                "#Ein Fremdling wie du wei\u00df doch gar nicht wie man damit umgehen soll!",
                "#Aber okay, ich will nicht so herzlos wie ihr St\u00E4dter sein, also kannst du die alte Angel aus meiner Kiste nehmen.",
                "#Die ist eh schon am zerfallen, da kannst du nichts mehr falsch machen.",
                "#Bei Fragen sag bescheid, vielleicht beantworte ich sie dir sogar..."};
        dialogs.add(d_3);

        String[] d_4 = {"#Soll ich dir etwa noch erkl\u00E4ren wie man eine Angel benutzt?!"};
        dialogs.add(d_4);

        String[] d_5 = {"#Okay, pass auf!",
                "#Zuerst gehst du mit E in dein Inventar und nimmst die Angel in eine Hand (J oder K)",
                "#Soll ich langsamer machen oder kommst du mit?",
                "#...",
                "#Okay, ich mache langsam weiter damit selbst du es verstehst.",
                "#Angenommen du hast die Angel auf J. Dann gehst du zum Wasser und h\u00E4lst J gedr\u00FCckt.",
                "#Wenn ein Fisch anbei\u00dft, nicht erschrecken und wegrennen, kleine Fische essen keine Menschen!",
                "#Jetzt kommt der knifflige Punkt. Dr\u00FCcke so oft wie m\u00F6glich auf J, um den Fisch aus dem Wasser zu ziehen.",
                "#Und nicht wieder rein werfen! Ich will es nur gesagt haben.",
                "#Und schon hast du einen Fisch gefangen. Ganz, ganz, einfach."};
        dialogs.add(d_5);

        String[] d_6 = {"#Nicht bl\u00F6d, der war gut. Haha."};
        dialogs.add(d_6);

        String[] d_7 = {"#Hey, ich habe gehört dass du das Funkeln der Sternenhöhle im Osten wiederhergestellt hast...",
                "#Du scheinst ja doch zu irgendwas nütze zu sein!",
                "#Von daher habe ich eine neue Aufgabe.",
                "#Ich brauche Schleimbälle!",
                "#Wozu??",
                "#Ehhmmmmm...",
                "#Experimente *hust*",
                "#Bring mir einfach 42 Stück, dann bekommst du auch eine Belohnung!"};
        dialogs.add(d_7);

        String[] d_8 = {"#Ohne Schleim gibts nichts.",
                "#Bring mir 6 Schleimbälle, dann bin ich zufrieden... vielleicht."};
        dialogs.add(d_8);

        String[] d_9 = {"Gute Arbeit!",
                "#Jetzt kann ich mit meinen ... \"Experimenten\" beginnen!"};
        dialogs.add(d_9);

        String[] d_10 = {"Nerv mich nicht weiter!"};
        dialogs.add(d_10);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) actualDialog++;
        else if (actualDialog == 3) {
            actualDialog++;
            for (InteractiveEntity ie : level.getInteractiveEntities(4 * 8, 40 * 8)) {
                if (ie instanceof Chest) {
                    ((Chest) ie).setPermission(true);
                    break;
                }
            }
        } else if (actualDialog == 4) {
            if (choices.get(0).getSelectedChoice() == 0) { //explain
                actualDialog += 1;
            } else { //not explain
                actualDialog += 2;
            }
        } else if (actualDialog == 5 || actualDialog == 6) {
            actualDialog = 4;
        } else if (actualDialog == 7) {
            actualDialog++;
            startQuest();
        } else if (actualDialog == 9) {
            actualDialog++;
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;
        if (actualDialog == 2) {
            for (NPC npc : level.npcs) {
                if (npc instanceof Levindra) {
                    if (npc.getActualDialog() == 2) {
                        actualDialog++;
                    }
                }
            }
        } else if (actualDialog == 8) {
            Item i = null;
            i = playerHoldsItem(Item.slimeBall_ID, 42);
            if (i != null) {
                i.useItem(42);
                actualDialog++;
                finishQuest();
            }
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.3f, 0.3f);
    }
}