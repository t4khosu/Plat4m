package com.weidni96.Platformer.Level.areas.singleLevels.Cimbria;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.NPC.town.*;
import com.weidni96.Platformer.entities.interactiveEntities.Chest;
import com.weidni96.Platformer.entities.interactiveEntities.Chest.ChestType;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.Background;
import com.weidni96.Platformer.graphics.Middleground;
import com.weidni96.Platformer.graphics.Sprite;

public class Cimbria_2_1 extends LoadLevel {

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
    public Cimbria_2_1(Player player, Middleground middleground,
                       Background background, String frontTiles, String backTiles, levelType type, Area area) {
        super(player, middleground, "", "", type, area, 0, 0);
    }

    @Override
    public void initNPCs() {
        npcs.add(new Marc(30 * 8, 46 * 8, Sprite.npc_right_0, this, false, "Marc", 35, 250));
        npcs.add(new NPC(35 * 8, 46 * 8, null, this, true, "Fremder", 20, 300));
        npcs.add(new Catrina(45 * 8, 46 * 8, Sprite.npc_right_0, this, true, "Catrina", 50, 400));
        npcs.add(new NPC(52 * 8, 37 * 8, null, this, false, "Fremder", 50, 200));
        npcs.add(new Robert(55 * 8, 37 * 8, Sprite.npc_right_0, this, false, "Robert", 50, 200));
        npcs.add(new NPC(52 * 8, 29 * 8, null, this, false, "Fremder", 50, 200));
        npcs.add(new Laura(62 * 8, 33 * 8, Sprite.npc_right_0, this, false, "Laura", 50, 200));
        npcs.add(new Jessy(54 * 8, 21 * 8, Sprite.npc_right_0, this, false, "Jessy", 50, 200));
        npcs.add(new NPC(50 * 8, 13 * 8, null, this, false, "Fremder", 50, 200));
        npcs.add(new Maisie(12 * 8, 44 * 8, Sprite.npc_right_0, this, false, "Maisie", 50, 200));
        npcs.add(new Wassily(6 * 8, 37 * 8, Sprite.npc_right_0, this, true, "Wassily", 50, 200));
        npcs.add(new Zane(27 * 8 - 4, 37 * 8, Sprite.npc_left_0, this, false, "Zane", 50, 200));
        npcs.add(new John(27 * 8 - 4, 30 * 8, Sprite.npc_left_0, this, false, "John", 50, 200));
        npcs.add(new Iakob(16 * 8, 13 * 8, Sprite.npc_right_0, this, true, "Iakob", 50, 200));
        npcs.add(new NPC(22 * 8, 11 * 8, null, this, true, "Fremder", 50, 200));
        npcs.add(new NPC(12 * 8, 17 * 8, null, this, false, "Fremder", 50, 200));
        npcs.add(new Dexter(16 * 8, 17 * 8, Sprite.npc_right_0, this, false, "Dexter", 50, 200));
        npcs.add(new Alexa(17 * 8, 23 * 8, Sprite.npc_right_0, this, true, "Alexa", 50, 200));
        npcs.add(new NPC(10 * 8, 23 * 8, null, this, false, "Fremder", 50, 200));
        npcs.add(new NPC(84 * 8, 27 * 8, null, this, true, "Fremder", 50, 200));
        npcs.add(new NPC(85 * 8, 41 * 8, null, this, true, "Fremder", 50, 200));
        npcs.add(new NPC(80 * 8, 17 * 8, null, this, false, "Fremder", 50, 200));
    }

    @Override
    public void initSurroundings() {
        interactiveEntities.add(new Chest(52 * 8, 13 * 8, Item.agroilberrySeed_ID, 8, true, this, ChestType.IRON));
        interactiveEntities.add(new Chest(17 * 8, 17 * 8, Item.agroilberrySeed_ID, 8, true, this, ChestType.IRON));
        interactiveEntities.add(new Sign(54 * 8, 46 * 8, "Block AG-01", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(13 * 8, 3 * 8, "Block AG-02", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(58 * 8, 37 * 8, "Block AG-01 WG-01", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(58 * 8, 29 * 8, "Block AG-01 WG-02", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(58 * 8, 21 * 8, "Block AG-01 WG-03", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(19 * 8, 44 * 8, "Monument \"Inigo Narid\"", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(22 * 8, 37 * 8, "Zane's Shop", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(22 * 8, 30 * 8, "John's Shop+  (Viel besser als Zane's Laden)", SignType.ELECTRONICAL));
        interactiveEntities.add(new Sign(9 * 8, 37 * 8, "Wassily's Atelier", SignType.ELECTRONICAL));

        images.add(new Entity(14 * 8, 40 * 8, Sprite.statue1));
        images.add(new Entity(27 * 8, 42 * 8, Sprite.picture1));
        images.add(new Entity(4 * 8, 42 * 8, Sprite.picture1));
        images.add(new Entity(5 * 8 + 4, 35 * 8, Sprite.picture2));
        images.add(new Entity(2 * 8 - 2, 32 * 8 + 4, Sprite.picture3));
        images.add(new Entity(2 * 8, 30 * 8, Sprite.picture4));
        images.add(new Entity(23 * 8, 32 * 8, Sprite.shop1));
        images.add(new Entity(23 * 8, 25 * 8, Sprite.shop2));
        images.add(new Entity(36 * 8, 44 * 8, Sprite.lantern1));
        images.add(new Entity(43 * 8, 44 * 8, Sprite.lantern1));
        images.add(new Entity(45 * 8, 7 * 8, Sprite.lantern1));
        images.add(new Entity(70 * 8, 44 * 8, Sprite.lantern1));
        images.add(new Entity(95 * 8, 44 * 8, Sprite.lantern1));
        images.add(new Entity(89 * 8, 18 * 8, Sprite.lantern1));
        images.add(new Entity(41 * 8, 46 * 8 - 1, Sprite.bench1));
        images.add(new Entity(4 * 8 - 4, 46 * 8 - 1, Sprite.bench1));
        images.add(new Entity(27 * 8 + 5, 36 * 8 - 2, Sprite.fullCupboard1));
        images.add(new Entity(24 * 8 + 6, 36 * 8 - 2, Sprite.fullCupboard1));
        images.add(new Entity(23 * 8 + 2, 36 * 8 - 2, Sprite.emptyCupboard1));
        images.add(new Entity(23 * 8 + 3, 29 * 8 - 2, Sprite.emptyCupboard1));
        images.add(new Entity(1 * 8, 36 * 8, Sprite.doubleBunkBed1));
        images.add(new Entity(49 * 8, 20 * 8, Sprite.doubleBunkBed1));
        images.add(new Entity(9 * 8, 7 * 8, Sprite.doubleBunkBed1));
        images.add(new Entity(10 * 8, 16 * 8, Sprite.doubleBunkBed1));
        images.add(new Entity(14 * 8, 16 * 8, Sprite.doubleBunkBed1));
        images.add(new Entity(81 * 8, 16 * 8 - 1, Sprite.telescope));
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
