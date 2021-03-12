package com.t4khosu.Platformer.Level.areas.singleLevels.Cimbria;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.graphics.Background;
import com.t4khosu.Platformer.graphics.Middleground;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.player.Player;

public class Cimbria_3_1 extends LoadLevel {

    /**
     * Constructor
     *
     * @param player
     * @param middleground
     * @param background
     * @param frontTiles
     * @param backTiles
     * @param type
     * @param area
     */
    public Cimbria_3_1(Player player, Middleground middleground,
                       Background background, String frontTiles, String backTiles, levelType type, Area area) {
        super(player, middleground, "", "", type, area, 0, 0);
    }

    @Override
    public void initNPCs() {
    }

    @Override
    public void initSurroundings() {
        images.add(new Entity(30 * 8 - 4, 46 * 8, Sprite.sign2_sprite));
        images.add(new Entity(58 * 8, 34 * 8, Sprite.gardenSign));
    }

    @Override
    public void initMobs() {
    }

    @Override
    protected void individualUpdate() {
    }

    @Override
    public void individualSaveFileLoad(String input) {
    }

    @Override
    public String individualSave() {
        return "";
    }
}