package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.item.Item;

public class Wachposten extends NPC {

    private boolean openDoor = false;

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
    public Wachposten(int x, int y, Level level) {
        super(x, y, null, level, false, "Wachposten", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {"#Entschuldige, f\u00FCr Fremde ist dieses Gebiet abgesperrt. Und ohne Waffe darfst du erst recht nicht hier durch!"};
        dialogs.add(a);

        String[] b = {"#Nun gut, Dregen hat dich akzeptiert, doch ohne Waffe darfst du trotzdem nicht passieren!"};
        dialogs.add(b);

        String[] c = {"#Oh, wie ich sehen kann besitzt du ein Schwert! Dann kann ich dich auch passieren lassen!"};
        dialogs.add(c);

        String[] d = {"#Sei immer auf der Hut."};
        dialogs.add(d);
    }

    /**
     * check when npc stops talking
     */
    public void talk() {
        talking = true;
        if (!openDoor) {
            for (Item i : level.getPlayer().getJK()) {
                if (i == null) continue;
                if (i.getID() == Item.woodenSword_ID) {
                    openDoor = true;
                    actualDialog = 2;
                    break;
                }
            }
        }
    }

    /**
     * check when npc starts talking
     */
    public void stopTalking() {
        talking = false;
        if (actualDialog == 2) {
            if (openDoor) {
                openDoor();
                actualDialog++;
            }
        }
    }

    /**
     * open door by changing tiles
     */
    public void openDoor() {
        level.setTile(92, 44, 0);
        level.setTile(92, 45, 0);
        level.setTile(92, 46, 0);
    }

    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.1f, 0.5f);
    }
}
