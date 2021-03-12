package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.entities.weather.Rain;

public class Locus extends NPC {

    private World world;
    private Timer weatherTimer;

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
    public Locus(int x, int y, Level level) {
        super(x, y, null, level, false, "Locus", 50, 400);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] d_0 = {"#Das Wetter heute ist wundervoll, nicht wahr?"};
        dialogs.add(d_0);

        String[] d_1 = {"#Es riecht nach Regen, ich k\u00F6nnte es mir aber auch nur einbilden"};
        dialogs.add(d_1);

        String[] d_2 = {"#Sieht so aus als kommt ein Sturm auf uns zu."};
        dialogs.add(d_2);

        String[] d_3 = {"#Das Ger\u00E4usch von Regen und Gewitter beruhigt mich immer."};
        dialogs.add(d_3);
    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;
        if (world.getWeather() != null && world.getWeather() instanceof Rain) {
            actualDialog = 3;
        } else if (weatherTimer.getTime() <= weatherTimer.getMaxTime() / 3) {
            actualDialog = 0;
        } else if (weatherTimer.getTime() <= (weatherTimer.getMaxTime() * 2) / 3) {
            actualDialog = 1;
        } else if (weatherTimer.getTime() <= weatherTimer.getMaxTime()) {
            actualDialog = 2;
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.1f, 0.5f);
    }

    public NPC initLevelAndReturn(Level level) {
        initLevel(level);
        this.player = level.getPlayer();
        this.world = level.getArea().getWorld();
        this.weatherTimer = world.getWeatherTimer();
        return this;
    }
}
