package com.t4khosu.Platformer.Level.areas.singleLevels.neuleben;

import com.t4khosu.Platformer.Level.Area;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.Level.NPCManager;
import com.t4khosu.Platformer.entities.interactiveEntities.ChestManager;
import com.t4khosu.Platformer.entities.interactiveEntities.Sign;
import com.t4khosu.Platformer.graphics.Middleground;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.Entity;
import com.t4khosu.Platformer.entities.NPC.NPC;

public class Neuleben_1_1 extends LoadLevel {

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
    public Neuleben_1_1(Area area, int areaPosX, int areaPosY) {
        super(area.getPlayer(),
                Middleground.forest2,
                "/level/standard/forest_village_2.png",
                "/level/standard/forest_village_2_back.png",
                levelType.VILLAGE,
                area,
                areaPosX,
                areaPosY
        );
    }

    @Override
    protected void initNPCs() {
        npcs.add(new NPC(36 * 8, 42 * 8, null, this, true, "Fischer", 50, 200));
        npcs.add(new NPC(56 * 8, 39 * 8, null, this, false, "Bewohner", 50, 200));
        npcs.add(new NPC(32 * 8, 37 * 8, null, this, false, "Fischer", 50, 200));
        npcs.add(NPCManager.preng_neuleben.initLevelAndReturn(this));
        npcs.add(NPCManager.kurb_neuleben.initLevelAndReturn(this));
    }

    @Override
    protected void initSurroundings() {
        images.add(new Entity(6 * 8 - 2, 38 * 8 - 2, Sprite.emptyCupboard2));

        interactiveEntities.add(ChestManager.rolBerrySeed_neuleben.initChestAndReturn(this));
        interactiveEntities.add(ChestManager.agroilBerrySeed_neuleben.initChestAndReturn(this));

        interactiveEntities.add(new Sign(10 * 8, 45 * 8, "Kurbs Laden für Allerlei", Sign.SignType.WOODEN));
        interactiveEntities.add(new Sign(29 * 8, 42 * 8, "Angelplatz", Sign.SignType.WOODEN));
        interactiveEntities.add(new Sign(60 * 8, 45 * 8, "Prengs Farm", Sign.SignType.WOODEN));
    }

    @Override
    protected void initMobs() {
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