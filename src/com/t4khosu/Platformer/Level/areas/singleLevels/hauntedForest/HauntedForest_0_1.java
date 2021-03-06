package com.t4khosu.Platformer.Level.areas.singleLevels.hauntedForest;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.interactiveEntities.ChestManager;
import com.t4khosu.Platformer.entities.interactiveEntities.SavePointManager;
import com.t4khosu.Platformer.entities.interactiveEntities.Sign;
import com.t4khosu.Platformer.graphics.Middleground;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.enemies.insects.GreenSpider;
import com.t4khosu.Platformer.entities.enemies.slimes.GrassSlime;

public class HauntedForest_0_1 extends LoadLevel {

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
    public HauntedForest_0_1(Area area, int areaPosX, int areaPosY) {
        super(area.getPlayer(),
                Middleground.forest4,
                "/level/standard/forest_2.png",
                "/level/standard/forest_2_back.png",
                levelType.NATURE,
                area,
                areaPosX,
                areaPosY
        );
    }

    @Override
    protected void initNPCs() {
        npcs.add(NPCManager.mendra_hauntedForest.initLevelAndReturn(this));
        npcs.add(new NPC(17 * 8, 5 * 8, null, this, false, "Person", 50, 200));
    }

    @Override
    protected void initSurroundings() {
        images.add(new Entity(46 * 8, 43 * 8 - 2, Sprite.bench1));
        images.add(new Entity(27 * 8, 27 * 8, Sprite.tree1));

        interactiveEntities.add(new Sign(71 * 8, 44 * 8, "Minenschachte G3", Sign.SignType.WOODEN));
        interactiveEntities.add(new Sign(33 * 8, 36 * 8, "Gepflanzt am 02.08.26XX", Sign.SignType.WOODEN));

        hiders.add(new Entity(38 * 8, 46 * 8, Sprite.dirt1_sprite));
        hiders.add(new Entity(39 * 8, 46 * 8, Sprite.dirt1_sprite));
        hiders.add(new Entity(40 * 8, 46 * 8, Sprite.dirt4_sprite));
        hiders.add(new Entity(40 * 8, 47 * 8, Sprite.stone4_sprite));
        hiders.add(new Entity(40 * 8, 48 * 8, Sprite.stone4_sprite));
        hiders.add(new Entity(41 * 8, 48 * 8, Sprite.stone4_sprite));
        hiders.add(new Entity(42 * 8, 48 * 8, Sprite.stone4_sprite));
        hiders.add(new Entity(43 * 8, 48 * 8, Sprite.stone4_sprite));

        interactiveEntities.add(SavePointManager.p2_hauntedForest.initLevelAndReturn(this));
        interactiveEntities.add(ChestManager.money_hauntedForest.initChestAndReturn(this));

    }

    @Override
    protected void initMobs() {
        mobs.add(new GrassSlime(7 * 8, 46 * 8, this));
        mobs.add(new GrassSlime(31 * 8, 36 * 8, this));
        mobs.add(new GrassSlime(72 * 8, 23 * 8, this));
        mobs.add(new GreenSpider(44 * 8, 38 * 8, this));
    }

    @Override
    protected void individualUpdate() {
    }

    @Override
    public String individualSave() {
        return "";
    }

    @Override
    public void individualSaveFileLoad(String input) {
    }
}