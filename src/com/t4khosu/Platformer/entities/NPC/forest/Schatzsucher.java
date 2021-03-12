package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class Schatzsucher extends NPC {

    public Schatzsucher(int x, int y, Level level) {
        super(x, y, null, level, true, "Schatzsucher", 50, 400);

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

        String[] a = {"#Hallo Fremder!",
                "#Ich bin Schatzsucher und schon seit einer Weile hier...",
                "#Bis jetzt habe ich leider noch nicht viel finden k\u00F6nnen.",
                "#Vielleicht hast du ja mehr Erfolg",
                "#..."};
        dialogs.add(a);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;
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
        screen.renderNewHSB(x, y, sprite, true, 0.76f, 0.4f);

        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.6f, 0.5f);
        }

        questRender(screen);
    }

}
