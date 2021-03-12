package com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.interactiveEntities.Loot;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.enemies.insects.PoisonSpider;
import com.t4khosu.Platformer.entities.enemies.slimes.PoisonSlime;
import com.t4khosu.Platformer.entities.item.Item;

public class Dungeon_01_2_1 extends LoadLevel {

    private boolean hiddenLoot = false;

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
    public Dungeon_01_2_1(Area area, int areaPosX, int areaPosY) {
        super(area.getPlayer(),
                null,
                "/level/dungeon_01/dungeon_2_4_front.png",
                "/level/dungeon_01/dungeon_2_4_back.png",
                levelType.DUNGEON,
                area,
                areaPosX,
                areaPosY
        );
    }

    @Override
    protected void initMobs() {
        mobs.add(new PoisonSlime(28 * 8, 84 * 8, this));
        mobs.add(new PoisonSlime(59 * 8, 79 * 8, this));
        mobs.add(new PoisonSlime(24 * 8, 27 * 8, this));
        mobs.add(new PoisonSlime(55 * 8, 26 * 8, this));
        mobs.add(new PoisonSpider(35 * 8, 6 * 8, this));
        mobs.add(new PoisonSpider(63 * 8, 2 * 8, this));
    }

    @Override
    protected void initNPCs() {
    }

    @Override
    protected void initSurroundings() {
        for (int i = 0; i <= 8; i++) {
            hiders.add(new Entity(i * 8, 57 * 8, Sprite.stone1_sprite));
        }
    }

    @Override
    protected void individualUpdate() {
        if (!hiddenLoot && TileGetterList.getTile(59, 70, this).isPlantable()) {
            hiddenLoot = true;
            interactiveEntities.add(new Loot(59 * 8, 69 * 8, this, Item.money_ID, 20));
        }
    }

    @Override
    public void individualSaveFileLoad(String input) {
    }

    @Override
    public String individualSave() {
        return "";
    }
}