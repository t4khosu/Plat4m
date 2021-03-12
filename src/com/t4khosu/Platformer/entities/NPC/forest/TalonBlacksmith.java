package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.SpriteSheet;

public class TalonBlacksmith extends NPC {

    public TalonBlacksmith(int x, int y, Level level) {
        super(x, y, null, level, false, "Talon", 400, 50);

        hair_right = new AnimatedSprite(8, SpriteSheet.hair2_right_sheet, 4, 10, false);
        hair_left = new AnimatedSprite(8, SpriteSheet.hair2_left_sheet, 4, 10, false);
        hairRight = Sprite.hair2_right;
        hairLeft = Sprite.hair2_left;
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 1;

        String[] ch = {"Alles klar.", "Jetzt eher nicht..."};
        choices.add(new Choices(1, ch));


        String[] d_0 = {"#Wow, ich habe schon lange niemanden mehr aus Neuleben gesehen!",
                "#Was?",
                "#Du bist gar nicht aus Neuleben?!",
                "#Das ist ja noch seltener!",
                "#...",
                "#*Er mustert dich*",
                "#Interessant interessant...",
                "#Sag, woher kommst du............",
                "#AUS CIMBRIA?!",
                "#Ein richtiger St�dter, ich glaube es nicht!",
                "#Ich habe eine Idee! Erz�hl mir ab und zu ein paar Geschichten vom Stadtleben, dann lasse ich dich meine Schmiede nutzen!",
                "#Ich bin in dieser Gegend sehr einsam, deswegen w�rdest du mir damit einen rie�en Gefallen tun...",
                "#*Er schaut dich erwartungsvoll an*",
                "#DU MACHST ES?!",
                "#Ich kann mein Gl�ck kaum fassen!",
                "#Nutz meine Schmiede wann immer du willst. Bei fragen schau unten in die B�cher, diese werden dir weiter helfen.",
                "#Ich freue mich schon auf deine Geschichten!"
        };
        dialogs.add(d_0);

        String[] d_1 = {"#Erz�hlst du mir eine deiner Geschichten?"};
        dialogs.add(d_1);

        String[] d_2 = {"#Schade... Hoffentlich ein anderes Mal."};
        dialogs.add(d_2);


        String[] d_3 = {"#erz�hlt geschichte..."};
        dialogs.add(d_3);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;

        if (actualDialog == 0) actualDialog++;

        else if (actualDialog == 1) {
            if (choices.get(0).getSelectedChoice() == 0) { //tell story
                actualDialog += 2;
            } else { //don't tell
                actualDialog += 1;
            }
        } else if (actualDialog > 1) {
            actualDialog = 1;
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
        screen.renderNewHSB(x, y, sprite, true, 0.65f, 0.9f);

        if (hairSprite != null) {
            screen.renderNewHSB(x, y, hairSprite, true, 0.0f, 0.0f);
        }

        questRender(screen);
    }

}
