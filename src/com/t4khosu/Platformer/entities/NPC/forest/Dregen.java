package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;
import com.t4khosu.Platformer.entities.item.mainItems.extras.Money;
import com.t4khosu.Platformer.entities.item.mainItems.tools.Sword.WoodenSword;

public class Dregen extends NPC {

    private int questPoints = 0;
    private int slimeCounter = 0;

    /**
     * constructor, special hair
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
    public Dregen(int x, int y, Level level) {
        super(x, y, null, level, false, "Dregen", 50, 400);

        hair_right = new AnimatedSprite(8, SpriteSheet.hair2_right_sheet, 4, 10, false);
        hair_left = new AnimatedSprite(8, SpriteSheet.hair2_left_sheet, 4, 10, false);
        hairRight = Sprite.hair2_right;
        hairLeft = Sprite.hair2_left;
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        havingQuest = true;

        String[] a = {"#Ich bin Dregen, der Stammesleiter.",
                "#Du fragst dich sicher, wo du hier bist.",
                "#Gestern Nacht haben dich meine Leute am Eingang des Dorfes gefunden, drum ließ ich dich bei einem von ihnen schlafen.",
                "#Ich hoffe, Ahb hat dir keine Angst eingejagt. Er mag keine Fremden...",
                "#Genug der Rede. Woher kommst du? Warum bist du hierher gekommen?",
                "#...",
                "#Du musstest fliehen??? Verrat???",
                "#Deine Lage klingt kompliziert. Aber ich mache dir einen Vorschlag.",
                "#Ich versuche mir etwas zu überlegen. In der Zwischenzeit kannst du unserem Dorf aushelfen.",
                "#Du sollst auch Nahrung dafür erhalten. Hilf dem Dorf und du darfst vorerst hier bleiben."};
        dialogs.add(a);

        String[] b = {"#Ich suche noch nach einer Lösung.",
                "#Hilf in der Zwischenzeit dem Dorf etwas aus.",
                "#Wir können immer Hilfe gebrauchen!"};
        dialogs.add(b);

        String[] c = {"#Wie ich sehe hast du dem Dorf gut ausgeholfen.",
                "#Ich habe nachgedacht und bin zu dem Schluss gekommen...",
                "#Du solltest vorerst hier bleiben.",
                "#...",
                "#Anders wird es wohl nicht gehen.",
                "#Jedoch haben viele deine Arbeit hier verfolgt und freuen sich sicher schon,",
                "#Dich in unserer Gemeinschaft willkommen zu hei\u00dfen.",
                "#...............",
                "#Trotzem Kannst du nicht in der Wildnis bleiben ohne eine Waffe.",
                "#Vor ein paar Jahren vielleicht, aber nicht heute...",
                "#Heute, wo uns die G\u00F6tter verlassen haben...",
                "#Drum nimm das Hier."
        };
        dialogs.add(c);

        String[] d = {"#Ohne Erfahrung wirst du nicht lange \u00DCberleben...",
                "#Geh in unseren Dorfwald und erlege 10 \"Gemeine Slimes\"",
                "#Dies soll mir beweisen, dass du f\u00E4hig bist hierbleiben zu d\u00FCrfen."};
        dialogs.add(d);

        String[] e = {"#Du hast bereits " + slimeCounter + " Slimes erledigt.",
                "#Streng dich noch etwas mehr an!"};
        dialogs.add(e);

        String[] f = {"#Wie ich sehe hast du 10 dieser Monster besiegen k\u00F6nnen",
                "#Damit bist du bereit dich neuen Aufgaben zu stellen!",
                "#Da ich mich um mein Dorf k\u00FCmmern muss, werde ich dir nicht viel helfen k\u00F6nnen",
                "#Doch du musst wissen, dass du hier immer willkommen sein wirst!",
                "#...",
                "#Wenn du willst kannst du Richtung Westen gehen, dort sind alte Ruinen vom vergangenen Krieg.",
                "#Dort scheint es Schriften zu geben, ob Sie dir weiter helfen... wei\u00df ich nicht...",
                "#Aber vielleicht findest du ja etwas!"};
        dialogs.add(f);

        String[] g = {"#Viel Erfolg auf deiner Reise!"};
        dialogs.add(g);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 0) {
            actualDialog++;
            startQuest();

            NPC n = NPCManager.levindra_neuleben;
            n.setActualDialog(1);
            n.hasQuest();
            questPoints++;

            n = NPCManager.ahb_neuleben;
            n.setActualDialog(2);

            n = NPCManager.preng_neuleben;
            n.setActualDialog(1);
            n.hasQuest();
            questPoints++;

            n = NPCManager.wachposten_villageForest;
            if (n.getActualDialog() == 0) {
                n.setActualDialog(1);
            }

            n = NPCManager.gorn_neuleben;
            n.setActualDialog(1);
            n.hasQuest();
            questPoints++;
        } else if (actualDialog == 2) {
            givePlayerItem(new WoodenSword(), 1);
            hasQuest();
            actualDialog++;
        } else if (actualDialog == 3) {
            startQuest();
            actualDialog++;
        } else if (actualDialog == 5) {
            finishQuest();
            givePlayerItem(new Money(), 50);
            actualDialog++;
        }
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;
        if (actualDialog == 1 && questPoints == 0) { //qp  == 0
            finishQuest();
            NPCManager.kurb_neuleben.setBuysItems(true);
            actualDialog++;
        }

        if (actualDialog == 4) {
            String[] e = new String[2];
            if (slimeCounter == 1) {
                e[0] = "#Du hast bereits " + slimeCounter + " Slime erledigt.";
                e[1] = "#Streng dich noch etwas mehr an!";
            } else if (slimeCounter < 10) {
                e[0] = "#Du hast bereits " + slimeCounter + " Slimes erledigt.";
                e[1] = "#Streng dich noch etwas mehr an!";
            } else {
                actualDialog++;
            }

            dialogs.set(4, e);
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.96f, 0.4f);

        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.3f, 0.2f);
        }

        questRender(screen);
    }

    public String getSaveData() {
        return questPoints + " " + slimeCounter + " ";
    }

    public void subQuestPoint() {
        if (questPoints - 1 >= 0) {
            questPoints--;
        }
    }

    public void addSlime() {
        slimeCounter++;
    }

    public void setQuestPoints(int questPoints) {
        this.questPoints = questPoints;
    }

    public void setSlimeCounter(int slimeCounter) {
        this.slimeCounter = slimeCounter;
    }
}
