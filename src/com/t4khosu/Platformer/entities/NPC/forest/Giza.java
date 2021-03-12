package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class Giza extends NPC {

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
    public Giza(int x, int y, Level level) {
        super(x, y, null, level, false, "Giza", 50, 400);

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
        String[] a = {"#Ich liebe B�cher! Ich k�nnte den ganzen Tag lesen!",
                "#Wenn du auch gerne liest, stell dich einfach vor ein B�cherregal und dr�cke <SPACE>.",
                "#Vielleicht findest du Literatur, die auch dich interessiert!"};
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
        screen.renderNewHSB(x, y, sprite, true, 0.55f, 0.7f);
        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.08f, 0.00f);
        }
    }
}
