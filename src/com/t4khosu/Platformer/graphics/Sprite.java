package com.t4khosu.Platformer.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

import javax.imageio.ImageIO;

public class Sprite {

    private final int SIZE;
    private final int WIDTH, HEIGHT;

    private final static String MIDDLEGROUD_DIR = "/middlegrounds/processed/";
    private final static String IMAGES_DIR = "/images/";
    private final static String TEXTURES_DIR = "/textures/";

    private int posX, posY;
    private int[] pixels;

    private String path;
    private SpriteSheet sheet;

    // Intro
    public static Sprite areaSign_neuleben = new Sprite(56, 12, IMAGES_DIR + "areaSign_neuleben.png");
    public static Sprite areaSign_villageForest = new Sprite(80, 13, IMAGES_DIR + "areaSign_villageForest.png");
    public static Sprite areaSign_hauntedForest = new Sprite(87, 12, IMAGES_DIR + "areaSign_hauntedForest.png");
    public static Sprite areaSign_poisonFactory = new Sprite(81, 12, IMAGES_DIR + "areaSign_poisonFactory.png");

    // Inventory
    public static Sprite handSlot = new Sprite(16, 16, IMAGES_DIR + "handSlot.png");
    public static Sprite extraSlot = new Sprite(12, 12, IMAGES_DIR + "extraSlot.png");
    public static Sprite frame = new Sprite(16, 16, IMAGES_DIR + "frame.png");
    public static Sprite lifeBackground = new Sprite(64, 16, IMAGES_DIR + "lifeBackground.png");
    public static Sprite extraBackground = new Sprite(64, 16, IMAGES_DIR + "extraBackground.png");

    // Atmosphere
    public static Sprite statue1 = new Sprite(32, 40, IMAGES_DIR + "statue1.png");
    public static Sprite picture1 = new Sprite(8, 24, IMAGES_DIR + "picture1.png");
    public static Sprite picture2 = new Sprite(16, 16, IMAGES_DIR + "picture2.png");
    public static Sprite picture3 = new Sprite(32, 16, IMAGES_DIR + "picture3.png");
    public static Sprite picture4 = new Sprite(16, 16, IMAGES_DIR + "picture4.png");

    public static Sprite shop1 = new Sprite(21, 9, IMAGES_DIR + "shop1.png");
    public static Sprite shop2 = new Sprite(27, 9, IMAGES_DIR + "shop2.png");
    public static Sprite lantern1 = new Sprite(8, 24, IMAGES_DIR + "lantern1.png");
    public static Sprite bench1 = new Sprite(16, 10, IMAGES_DIR + "bench1.png");
    public static Sprite emptyCupboard1 = new Sprite(12, 18, IMAGES_DIR + "emptyCupboard1.png");
    public static Sprite emptyCupboard2 = new Sprite(12, 18, IMAGES_DIR + "emptyCupboard2.png");
    public static Sprite bookShelf = new Sprite(12, 18, IMAGES_DIR + "bookShelf.png");
    public static Sprite fullCupboard1 = new Sprite(12, 18, IMAGES_DIR + "fullCupboard1.png");
    public static Sprite doubleBunkBed1 = new Sprite(16, 16, IMAGES_DIR + "doubleBunkBed1.png");
    public static Sprite telescope = new Sprite(16, 17, IMAGES_DIR + "telescope.png");
    public static Sprite sattelite = new Sprite(8, 16, IMAGES_DIR + "sattelite.png");
    public static Sprite gardenSign = new Sprite(16, 9, IMAGES_DIR + "gardenSign.png");
    public static Sprite tree1 = new Sprite(32, 40, IMAGES_DIR + "tree1.png", 2);

    public static Sprite firePlaceManager = new Sprite(20, 37, IMAGES_DIR + "firePlaceManager.png");

    //=========================================================================
    //== Middleground
    //=========================================================================

    public static Sprite empty = new Sprite(104, 104, MIDDLEGROUD_DIR + "empty.png", 2);

    // Jungle
    public static Sprite forest0 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest0.png", 2);
    public static Sprite forest1 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest1.png", 2);
    public static Sprite forest2 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest2.png", 2);
    public static Sprite forest3 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest3.png", 2);
    public static Sprite forest4 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest4.png", 2);
    public static Sprite forest5 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest5.png", 2);
    public static Sprite forest6 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest6.png", 2);
    public static Sprite forest7 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest7.png", 2);
    public static Sprite forest8 = new Sprite(104, 104, MIDDLEGROUD_DIR + "forest8.png", 2);

    public static Sprite[] forest_0 = {empty, forest0, forest1};
    public static Sprite[] forest_1 = {forest1, forest2, forest3};
    public static Sprite[] forest_2 = {forest3, forest4, forest5};
    public static Sprite[] forest_3 = {forest5, forest6, forest7};
    public static Sprite[] forest_4 = {forest7, forest8, empty};

    // Town
    public static Sprite town1 = new Sprite(104, 104, MIDDLEGROUD_DIR + "town1.png", 2);
    public static Sprite town2 = new Sprite(104, 104, MIDDLEGROUD_DIR + "town2.png", 2);
    public static Sprite town3 = new Sprite(104, 104, MIDDLEGROUD_DIR + "town3.png", 2);

    public static Sprite[] town_1 = {town1, town2, town3};

    //~Image Sprites: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static Sprite dungeonEntry = new Sprite(28, 30, IMAGES_DIR + "door_dungeon_1.png", 2);
    public static Sprite dungeonEntry_back = new Sprite(28, 30, IMAGES_DIR + "door_dungeon_1_back.png", 2);
    public static Sprite dungeon_1_set1 = new Sprite(28, 30, IMAGES_DIR + "set1_dungeon_1.png", 2);
    public static Sprite dungeon_1_set2 = new Sprite(28, 30, IMAGES_DIR + "set2_dungeon_1.png", 2);

    public static Sprite mobStatus = new Sprite(48, 12, IMAGES_DIR + "mobStatus.png");
    public static Sprite showStatusBar = new Sprite(35, 18, IMAGES_DIR + "showStatusBar.png");
    public static Sprite poisonMachineOff = new Sprite(64, 64, TEXTURES_DIR + "poison_machine_off.png");

    public static Sprite platamLogo = new Sprite(180, 24, IMAGES_DIR + "platamLogo.png");
    public static Sprite button_startNewGame = new Sprite(156, 16, IMAGES_DIR + "button_startNewGame.png");
    public static Sprite button_loadGame = new Sprite(156, 16, IMAGES_DIR + "button_loadGame.png");

    //=========================================================================
    //== Items Sheet
    //=========================================================================

    public static Sprite item_woodenFishingPole = new Sprite(16, 0, 0, SpriteSheet.items_sheet);
    public static Sprite item_ironFishingPole = new Sprite(16, 0, 1, SpriteSheet.items_sheet);
    public static Sprite item_uruFishingPole = new Sprite(16, 0, 2, SpriteSheet.items_sheet);
    public static Sprite item_woodenShovel = new Sprite(16, 1, 0, SpriteSheet.items_sheet);
    public static Sprite item_ironShovel = new Sprite(16, 1, 1, SpriteSheet.items_sheet);
    public static Sprite item_uruShovel = new Sprite(16, 1, 2, SpriteSheet.items_sheet);
    public static Sprite item_woodenPickaxe = new Sprite(16, 2, 0, SpriteSheet.items_sheet);
    public static Sprite item_ironPickaxe = new Sprite(16, 2, 1, SpriteSheet.items_sheet);
    public static Sprite item_uruPickaxe = new Sprite(16, 2, 2, SpriteSheet.items_sheet);
    public static Sprite item_woodenSword = new Sprite(16, 3, 0, SpriteSheet.items_sheet);
    public static Sprite item_ironSword = new Sprite(16, 3, 1, SpriteSheet.items_sheet);
    public static Sprite item_uruSword = new Sprite(16, 3, 2, SpriteSheet.items_sheet);
    public static Sprite item_boots = new Sprite(16, 4, 3, SpriteSheet.items_sheet);

    public static Sprite item_agroilberrySeed = new Sprite(16, 0, 3, SpriteSheet.items_sheet);
    public static Sprite item_wheatSeed = new Sprite(16, 1, 3, SpriteSheet.items_sheet);
    public static Sprite item_rolberrySeed = new Sprite(16, 2, 3, SpriteSheet.items_sheet);
    public static Sprite item_yocipSeed = new Sprite(16, 3, 3, SpriteSheet.items_sheet);

    public static Sprite item_rolberry = new Sprite(16, 2, 4, SpriteSheet.items_sheet);
    public static Sprite item_wheat = new Sprite(16, 1, 4, SpriteSheet.items_sheet);
    public static Sprite item_agroilberry = new Sprite(16, 0, 4, SpriteSheet.items_sheet);
    public static Sprite item_yocip = new Sprite(16, 3, 4, SpriteSheet.items_sheet);

    public static Sprite item_corjack = new Sprite(16, 5, 0, SpriteSheet.items_sheet);
    public static Sprite item_pompbass = new Sprite(16, 5, 1, SpriteSheet.items_sheet);
    public static Sprite item_snappon = new Sprite(16, 5, 2, SpriteSheet.items_sheet);

    public static Sprite item_rawIron = new Sprite(16, 6, 0, SpriteSheet.items_sheet);
    public static Sprite item_coal = new Sprite(16, 6, 1, SpriteSheet.items_sheet);
    public static Sprite item_rawUru = new Sprite(16, 6, 2, SpriteSheet.items_sheet);

    public static Sprite item_cd_1 = new Sprite(16, 0, 6, SpriteSheet.items_sheet);
    public static Sprite item_slimeBall = new Sprite(16, 4, 4, SpriteSheet.items_sheet);

    //=========================================================================
    //== Big Sheet
    //=========================================================================

    public static Sprite big_ownStoreBackground = new Sprite(16, 0, 0, SpriteSheet.big_sheet);
    public static Sprite big_ownFireBackground = new Sprite(16, 2, 1, SpriteSheet.big_sheet);
    public static Sprite big_tradeStoreBackground = new Sprite(16, 1, 0, SpriteSheet.big_sheet);
    public static Sprite big_activeStoreBackground = new Sprite(16, 2, 0, SpriteSheet.big_sheet);
    public static Sprite long_menuBackground_1 = new Sprite(16, 8, 1, 0, SpriteSheet.long_sheet);
    public static Sprite long_menuBackground_2 = new Sprite(16, 8, 1, 1, SpriteSheet.long_sheet);
    public static Sprite long_menuBackground_3 = new Sprite(16, 8, 1, 2, SpriteSheet.long_sheet);
    public static Sprite long_activeStoreBackground = new Sprite(16, 8, 2, 0, SpriteSheet.long_sheet);

    public static Sprite big_sign = new Sprite(16, 0, 1, SpriteSheet.big_sheet);
    public static Sprite big_sign2 = new Sprite(16, 1, 1, SpriteSheet.big_sheet);

    public static Sprite big_noAccess = new Sprite(16, 0, 2, SpriteSheet.big_sheet);
    public static Sprite big_money = new Sprite(16, 0, 3, SpriteSheet.big_sheet);

    //=========================================================================
    //== Player Sheet
    //=========================================================================

    public static Sprite player_right = new Sprite(8, 0, 0, SpriteSheet.player_sheet);
    public static Sprite player_left = new Sprite(8, 0, 1, SpriteSheet.player_sheet);
    public static Sprite player_right_punsh = new Sprite(8, 4, 0, SpriteSheet.player_sheet);
    public static Sprite player_left_punsh  = new Sprite(8, 4, 1, SpriteSheet.player_sheet);
    public static Sprite player_right_plant = new Sprite(8, 0, 5, SpriteSheet.player_sheet);
    public static Sprite player_left_plant = new Sprite(8, 1, 5, SpriteSheet.player_sheet);
    public static Sprite player_right_fishing = new Sprite(8, 0, 3, SpriteSheet.player_sheet);
    public static Sprite player_left_fishing = new Sprite(8, 1, 3, SpriteSheet.player_sheet);
    public static Sprite player_sleep1 = new Sprite(8, 6, 2, SpriteSheet.player_sheet);
    public static Sprite player_sleep2 = new Sprite(8, 7, 2, SpriteSheet.player_sheet);

    //=========================================================================
    //== NPC Sheet
    //=========================================================================

    public static Sprite npc_right_0 = new Sprite(8, 0, 0, SpriteSheet.npc_sheet);
    public static Sprite npc_left_0 = new Sprite(8, 0, 1, SpriteSheet.npc_sheet);
    public static Sprite female_npc_right_0 = new Sprite(8, 0, 2, SpriteSheet.npc_sheet);
    public static Sprite female_npc_left_0 = new Sprite(8, 0, 3, SpriteSheet.npc_sheet);
    public static Sprite beard_npc_right_0 = new Sprite(8, 0, 4, SpriteSheet.npc_sheet);
    public static Sprite beard_npc_left_0 = new Sprite(8, 0, 5, SpriteSheet.npc_sheet);
    public static Sprite hair1_right = new Sprite(8, 0, 2, SpriteSheet.npc_sheet);
    public static Sprite hair1_left = new Sprite(8, 0, 3, SpriteSheet.npc_sheet);
    public static Sprite hair2_right = new Sprite(8, 0, 4, SpriteSheet.npc_sheet);
    public static Sprite hair2_left = new Sprite(8, 0, 5, SpriteSheet.npc_sheet);

    //=========================================================================
    //== Mob Sheets
    //=========================================================================

    // Spinner
    public static Sprite enemy_0 = new Sprite(8, 0, 0, SpriteSheet.enemy_sheet);
    public static Sprite enemy_1 = new Sprite(8, 1, 0, SpriteSheet.enemy_sheet);

    // Slimes
    public static Sprite slime0_0 = new Sprite(8, 0, 0, SpriteSheet.slimes_sheet);
    public static Sprite slime0_1 = new Sprite(8, 1, 0, SpriteSheet.slimes_sheet);
    public static Sprite slime0_2 = new Sprite(8, 2, 0, SpriteSheet.slimes_sheet);

    public static Sprite slime1_0 = new Sprite(8, 0, 1, SpriteSheet.slimes_sheet);
    public static Sprite slime1_1 = new Sprite(8, 1, 1, SpriteSheet.slimes_sheet);
    public static Sprite slime1_2 = new Sprite(8, 2, 1, SpriteSheet.slimes_sheet);

    public static Sprite slime2_0 = new Sprite(8, 0, 2, SpriteSheet.slimes_sheet);
    public static Sprite slime2_1 = new Sprite(8, 1, 2, SpriteSheet.slimes_sheet);
    public static Sprite slime2_2 = new Sprite(8, 2, 2, SpriteSheet.slimes_sheet);

    public static Sprite blossSlime_0 = new Sprite(24, 0, 0, SpriteSheet.boss_slime_sheet);
    public static Sprite blossSlime_1 = new Sprite(24, 1, 0, SpriteSheet.boss_slime_sheet);
    public static Sprite blossSlime_2 = new Sprite(24, 2, 0, SpriteSheet.boss_slime_sheet);

    // Spiders
    public static Sprite brown_spider_1 = new Sprite(8, 0, 1, SpriteSheet.enemy_sheet);
    public static Sprite brown_spider_2 = new Sprite(8, 0, 2, SpriteSheet.enemy_sheet);
    public static Sprite green_spider_1 = new Sprite(8, 1, 1, SpriteSheet.enemy_sheet);
    public static Sprite green_spider_2 = new Sprite(8, 1, 2, SpriteSheet.enemy_sheet);
    public static Sprite blue_spider_1 = new Sprite(8, 2, 1, SpriteSheet.enemy_sheet);
    public static Sprite blue_spider_2 = new Sprite(8, 2, 2, SpriteSheet.enemy_sheet);

    // Stone Snail
    public static Sprite stone_snail_right_dead = new Sprite(8, 4, 3, SpriteSheet.enemy_sheet);
    public static Sprite stone_snail_left_dead = new Sprite(8, 4, 2, SpriteSheet.enemy_sheet);

    //=========================================================================
    //== Floor Sheet
    //=========================================================================

    // Water
    public static Sprite deep_water1_sprite = new Sprite(8, 3, 3, SpriteSheet.floor_sheet);
    public static Sprite deep_water2_sprite = new Sprite(8, 3, 4, SpriteSheet.floor_sheet);
    public static Sprite deep_water3_sprite = new Sprite(8, 5, 6, SpriteSheet.floor_sheet);
    public static Sprite deep_water_poison_sprite = new Sprite(8, 8, 2, SpriteSheet.floor_sheet);
    public static Sprite really_deep_water1_sprite = new Sprite(8, 4, 3, SpriteSheet.floor_sheet);
    public static Sprite really_deep_water2_sprite = new Sprite(8, 4, 4, SpriteSheet.floor_sheet);
    public static Sprite really_deep_water3_sprite = new Sprite(8, 6, 6, SpriteSheet.floor_sheet);
    public static Sprite really_deep_water_poison_sprite = new Sprite(8, 9, 2, SpriteSheet.floor_sheet);

    // Grass
    public static Sprite grass1_sprite = new Sprite(8, 0, 1, SpriteSheet.floor_sheet);
    public static Sprite grass2_sprite = new Sprite(8, 1, 1, SpriteSheet.floor_sheet);
    public static Sprite grass3_sprite = new Sprite(8, 2, 1, SpriteSheet.floor_sheet);
    public static Sprite grass4_sprite = new Sprite(8, 3, 1, SpriteSheet.floor_sheet);

    // Dirt
    public static Sprite dirt1_sprite = new Sprite(8, 0, 2, SpriteSheet.floor_sheet);
    public static Sprite dirt2_sprite = new Sprite(8, 1, 2, SpriteSheet.floor_sheet);
    public static Sprite dirt3_sprite = new Sprite(8, 2, 2, SpriteSheet.floor_sheet);
    public static Sprite dirt4_sprite = new Sprite(8, 4, 2, SpriteSheet.floor_sheet);
    public static Sprite field_sprite = new Sprite(8, 3, 2, SpriteSheet.floor_sheet);

    // Stone
    public static Sprite stone1_sprite = new Sprite(8, 0, 0, SpriteSheet.floor_sheet);
    public static Sprite stone2_sprite = new Sprite(8, 1, 0, SpriteSheet.floor_sheet);
    public static Sprite stone3_sprite = new Sprite(8, 2, 0, SpriteSheet.floor_sheet);
    public static Sprite stone4_sprite = new Sprite(8, 4, 1, SpriteSheet.floor_sheet);
    public static Sprite top_hard_stone1_sprite = new Sprite(8, 9, 0, SpriteSheet.floor_sheet);
    public static Sprite poisoned_stone1_sprite = new Sprite(8, 6, 1, SpriteSheet.floor_sheet);
    public static Sprite breakStone_sprite = new Sprite(8, 6, 0, SpriteSheet.floor_sheet);

    // Raw Materials
    public static Sprite iron_sprite = new Sprite(8, 3, 5, SpriteSheet.floor_sheet);
    public static Sprite polluted_iron_sprite = new Sprite(8, 7, 0, SpriteSheet.floor_sheet);
    public static Sprite hardCoal_sprite = new Sprite(8, 4, 5, SpriteSheet.floor_sheet);
    public static Sprite polluted_hardCoal_sprite = new Sprite(8, 8, 0, SpriteSheet.floor_sheet);

    // Asphalt Sprites
    public static Sprite asphalt1_sprite = new Sprite(8, 3, 0, SpriteSheet.floor_sheet);
    public static Sprite asphalt2_sprite = new Sprite(8, 4, 0, SpriteSheet.floor_sheet);
    public static Sprite asphalt3_sprite = new Sprite(8, 5, 0, SpriteSheet.floor_sheet);

    // Tree Sprites
    public static Sprite trunk1_sprite = new Sprite(8, 0, 5, SpriteSheet.floor_sheet);
    public static Sprite trunk2_sprite = new Sprite(8, 0, 6, SpriteSheet.floor_sheet);
    public static Sprite trunk3_sprite = new Sprite(8, 2, 5, SpriteSheet.floor_sheet);
    public static Sprite leaf1_sprite = new Sprite(8, 1, 5, SpriteSheet.floor_sheet);
    public static Sprite leaf2_sprite = new Sprite(8, 1, 6, SpriteSheet.floor_sheet);

    public static Sprite bars_sprite = new Sprite(8, 10, 0, SpriteSheet.floor_sheet);

    //=========================================================================
    //== Building Sheet
    //=========================================================================

    // Hard Jungle Wood
    public static Sprite wood_sprite = new Sprite(8, 0, 0, SpriteSheet.building_sheet);
    public static Sprite wood_right_sprite = new Sprite(8, 1, 0, SpriteSheet.building_sheet);
    public static Sprite wood_left_sprite = new Sprite(8, 2, 0, SpriteSheet.building_sheet);
    public static Sprite wood_top_sprite = new Sprite(8, 3, 0, SpriteSheet.building_sheet);
    public static Sprite wood_bottom_sprite = new Sprite(8, 4, 0, SpriteSheet.building_sheet);

    // Jungle Wood Pile
    public static Sprite wood_pile_sprite = new Sprite(8, 0, 1, SpriteSheet.building_sheet);
    public static Sprite wood_pileTop_sprite = new Sprite(8, 1, 1, SpriteSheet.building_sheet);
    public static Sprite wood_pileBottom_sprite = new Sprite(8, 2, 1, SpriteSheet.building_sheet);

    // Jungle Wood Bridge
    public static Sprite bridge_sprite = new Sprite(8, 3, 1, SpriteSheet.building_sheet);
    public static Sprite bridge_left_sprite = new Sprite(8, 4, 1, SpriteSheet.building_sheet);
    public static Sprite bridge_right_sprite = new Sprite(8, 0, 2, SpriteSheet.building_sheet);

    // Concrete
    public static Sprite concrete1_sprite = new Sprite(8, 1, 2, SpriteSheet.building_sheet);
    public static Sprite concrete2_sprite = new Sprite(8, 4, 2, SpriteSheet.building_sheet);
    public static Sprite concrete3_sprite = new Sprite(8, 0, 3, SpriteSheet.building_sheet);
    public static Sprite concrete_right_sprite = new Sprite(8, 2, 2, SpriteSheet.building_sheet);
    public static Sprite concrete_left_sprite = new Sprite(8, 3, 2, SpriteSheet.building_sheet);

    // Plastic
    public static Sprite plastic1_sprite = new Sprite(8, 1, 3, SpriteSheet.building_sheet);
    public static Sprite plastic2_sprite = new Sprite(8, 2, 3, SpriteSheet.building_sheet);

    // Spike
    public static Sprite spike01_sprite = new Sprite(8, 0, 4, SpriteSheet.building_sheet);
    public static Sprite spike02_sprite = new Sprite(8, 1, 4, SpriteSheet.building_sheet);

    // Red Stone
    public static Sprite redstone1_sprite = new Sprite(8, 5, 1, SpriteSheet.floor_sheet);

    //=========================================================================
    //== Background Sheet
    //=========================================================================

    // Wood
    public static Sprite wood1_background_sprite = new Sprite(8, 0, 0, SpriteSheet.background_sheet);
    public static Sprite wood2_background_sprite = new Sprite(8, 1, 0, SpriteSheet.background_sheet);
    public static Sprite wood3_background_sprite = new Sprite(8, 2, 0, SpriteSheet.background_sheet);
    public static Sprite wood4_background_sprite = new Sprite(8, 3, 0, SpriteSheet.background_sheet);
    public static Sprite fence1_background_sprite = new Sprite(8, 4, 0, SpriteSheet.background_sheet);
    public static Sprite fence2_background_sprite = new Sprite(8, 4, 1, SpriteSheet.background_sheet);

    // Dirt
    public static Sprite dirt1_background_sprite = new Sprite(8, 0, 1, SpriteSheet.background_sheet);

    // Wallpaper
    public static Sprite wallpaper1_background_sprite = new Sprite(8, 0, 2, SpriteSheet.background_sheet);
    public static Sprite wallpaper2_background_sprite = new Sprite(8, 1, 2, SpriteSheet.background_sheet);
    public static Sprite wallpaper3_background_sprite = new Sprite(8, 2, 2, SpriteSheet.background_sheet);
    public static Sprite wallpaper4_background_sprite = new Sprite(8, 3, 2, SpriteSheet.background_sheet);
    public static Sprite wallpaper5_background_sprite = new Sprite(8, 4, 2, SpriteSheet.background_sheet);

    // Glass
    public static Sprite glass1_background_sprite = new Sprite(8, 0, 3, SpriteSheet.background_sheet);
    public static Sprite glass2_background_sprite = new Sprite(8, 1, 3, SpriteSheet.background_sheet);

    // Stone
    public static Sprite stone1_background_sprite = new Sprite(8, 1, 1, SpriteSheet.background_sheet);
    public static Sprite stone2_background_sprite = new Sprite(8, 2, 1, SpriteSheet.background_sheet);
    public static Sprite stone3_background_sprite = new Sprite(8, 3, 1, SpriteSheet.background_sheet);
    public static Sprite stone4_background_sprite = new Sprite(8, 4, 3, SpriteSheet.background_sheet);

    // Plastic
    public static Sprite plastic1_background_sprite = new Sprite(8, 2, 3, SpriteSheet.background_sheet);
    public static Sprite plastic2_background_sprite = new Sprite(8, 3, 3, SpriteSheet.background_sheet);

    // Pipe
    public static Sprite pipe1_background_sprite = new Sprite(8, 0, 4, SpriteSheet.background_sheet);
    public static Sprite pipe1_stopped_sprite = new Sprite(8, 3, 4, SpriteSheet.background_sheet);

    //=========================================================================
    //== Furniture Sheet
    //=========================================================================

    // Any
    public static Sprite picture1_sprite = new Sprite(8, 0, 0, SpriteSheet.furniture_sheet);
    public static Sprite picture2_sprite = new Sprite(8, 0, 1, SpriteSheet.furniture_sheet);
    public static Sprite picture_blacksmith_sprite = new Sprite(8, 6, 0, SpriteSheet.furniture_sheet);
    public static Sprite bed1_sprite = new Sprite(8, 1, 0, SpriteSheet.furniture_sheet);
    public static Sprite sign1_sprite = new Sprite(8, 2, 0, SpriteSheet.furniture_sheet);
    public static Sprite sign2_sprite = new Sprite(8, 3, 3, SpriteSheet.furniture_sheet);
    public static Sprite sign3_sprite = new Sprite(8, 5, 1, SpriteSheet.furniture_sheet);
    public static Sprite cupboard1_sprite = new Sprite(8, 3, 0, SpriteSheet.furniture_sheet);
    public static Sprite cupboard2_sprite = new Sprite(8, 2, 2, SpriteSheet.furniture_sheet);
    public static Sprite shelf1_sprite = new Sprite(8, 4, 0, SpriteSheet.furniture_sheet);
    public static Sprite shelf2_sprite = new Sprite(8, 4, 2, SpriteSheet.furniture_sheet);
    public static Sprite shelf_with_vase_sprite = new Sprite(8, 5, 0, SpriteSheet.furniture_sheet);
    public static Sprite tv1_sprite = new Sprite(8, 1, 2, SpriteSheet.furniture_sheet);
    public static Sprite rubbishBin1_sprite = new Sprite(8, 3, 2, SpriteSheet.furniture_sheet);

    // Blacksmith fire stuff
    public static Sprite fire_left_sprite = new Sprite(8, 5, 3, SpriteSheet.furniture_sheet);
    public static Sprite fire_right_sprite = new Sprite(8, 6, 3, SpriteSheet.furniture_sheet);

    // Curtain
    public static Sprite curtain1_sprite = new Sprite(8, 1, 1, SpriteSheet.furniture_sheet);
    public static Sprite curtain2_sprite = new Sprite(8, 2, 1, SpriteSheet.furniture_sheet);
    public static Sprite curtain3_sprite = new Sprite(8, 3, 1, SpriteSheet.furniture_sheet);
    public static Sprite curtain4_sprite = new Sprite(8, 4, 1, SpriteSheet.furniture_sheet);
    public static Sprite halfCurtain_sprite = new Sprite(8, 0, 2, SpriteSheet.furniture_sheet);

    // Chest
    public static Sprite closed_chest1_sprite = new Sprite(8, 0, 3, SpriteSheet.furniture_sheet);
    public static Sprite open_chest1_sprite = new Sprite(8, 1, 3, SpriteSheet.furniture_sheet);
    public static Sprite closed_chest2_sprite = new Sprite(8, 2, 4, SpriteSheet.furniture_sheet);
    public static Sprite open_chest2_sprite = new Sprite(8, 3, 4, SpriteSheet.furniture_sheet);
    public static Sprite closed_chest3_sprite = new Sprite(8, 4, 4, SpriteSheet.furniture_sheet);
    public static Sprite open_chest3_sprite = new Sprite(8, 4, 3, SpriteSheet.furniture_sheet);
    public static Sprite closed_chest4_sprite = new Sprite(8, 0, 4, SpriteSheet.furniture_sheet);
    public static Sprite open_chest4_sprite = new Sprite(8, 1, 4, SpriteSheet.furniture_sheet);

    // Carpet
    public static Sprite carpet1_sprite = new Sprite(8, 2, 3, SpriteSheet.furniture_sheet);

    //=========================================================================
    //== Objects
    //=========================================================================

    public static Sprite pile_sprite = new Sprite(8, 1, 0, SpriteSheet.objects_sheet);
    public static Sprite ladder1_sprite = new Sprite(8, 1, 1, SpriteSheet.objects_sheet);
    public static Sprite ladder2_sprite = new Sprite(8, 0, 0, SpriteSheet.objects_sheet);
    public static Sprite tendril1_sprite = new Sprite(8, 1, 3, SpriteSheet.objects_sheet);
    public static Sprite tendril2_sprite = new Sprite(8, 2, 3, SpriteSheet.objects_sheet);
    public static Sprite forceRight_sprite = new Sprite(8, 2, 1, SpriteSheet.objects_sheet);
    public static Sprite forceLeft_sprite = new Sprite(8, 5, 2, SpriteSheet.objects_sheet);
    public static Sprite forceDown_sprite = new Sprite(8, 7, 2, SpriteSheet.objects_sheet);
    public static Sprite cross_sprite = new Sprite(8, 0, 1, SpriteSheet.objects_sheet);
    public static Sprite spike_sprite = new Sprite(8, 2, 0, SpriteSheet.objects_sheet);
    public static Sprite spikeDown_sprite = new Sprite(8, 5, 3, SpriteSheet.objects_sheet);
    public static Sprite bar_sprite = new Sprite(8, 3, 0, SpriteSheet.objects_sheet);
    public static Sprite fishingPole_right_sprite = new Sprite(8, 3, 1, SpriteSheet.objects_sheet);
    public static Sprite fishingPole_left_sprite = new Sprite(8, 4, 1, SpriteSheet.objects_sheet);
    public static Sprite fishingCatch_right_sprite = new Sprite(8, 3, 4, SpriteSheet.objects_sheet);
    public static Sprite fishingCatch_left_sprite = new Sprite(8, 4, 4, SpriteSheet.objects_sheet);
    public static Sprite lamp1_sprite = new Sprite(8, 4, 0, SpriteSheet.objects_sheet);
    public static Sprite lamp2_sprite = new Sprite(8, 3, 0, SpriteSheet.objects_sheet);
    public static Sprite topTrail_sprite = new Sprite(8, 0, 3, SpriteSheet.objects_sheet);
    public static Sprite loot_sprite = new Sprite(8, 0, 4, SpriteSheet.objects_sheet);
    public static Sprite potion_sprite = new Sprite(8, 2, 4, SpriteSheet.objects_sheet);
    public static Sprite lever_ON_sprite = new Sprite(8, 6, 0, SpriteSheet.objects_sheet);
    public static Sprite lever_OFF_sprite = new Sprite(8, 5, 0, SpriteSheet.objects_sheet);
    public static Sprite torch_OFF_sprite = new Sprite(8, 5, 1, SpriteSheet.objects_sheet);
    public static Sprite button_ON_sprite = new Sprite(8, 6, 2, SpriteSheet.objects_sheet);
    public static Sprite button_OFF_sprite = new Sprite(8, 6, 1, SpriteSheet.objects_sheet);
    public static Sprite laserHead_sprite = new Sprite(8, 7, 0, SpriteSheet.objects_sheet);
    public static Sprite laserHeadOn_sprite = new Sprite(8, 6, 3, SpriteSheet.objects_sheet);
    public static Sprite laser_sprite = new Sprite(8, 7, 3, SpriteSheet.objects_sheet);
    public static Sprite save_on_sprite = new Sprite(8, 4, 5, SpriteSheet.objects_sheet);
    public static Sprite save_off_sprite = new Sprite(8, 3, 5, SpriteSheet.objects_sheet);
    public static Sprite plant_frame_sprite = new Sprite(8, 5, 5, SpriteSheet.objects_sheet);
    public static Sprite anvil_sprite = new Sprite(8, 6, 5, SpriteSheet.objects_sheet);

    //=========================================================================
    //== Frames
    //=========================================================================

    public static Sprite frame1_left_sprite = new Sprite(8, 0, 0, SpriteSheet.frames_sheet);
    public static Sprite frame1_right_sprite = new Sprite(8, 2, 0, SpriteSheet.frames_sheet);
    public static Sprite frame1_top_sprite = new Sprite(8, 1, 0, SpriteSheet.frames_sheet);
    public static Sprite frame1_bottom_sprite = new Sprite(8, 3, 0, SpriteSheet.frames_sheet);
    public static Sprite frame1_top_left_sprite = new Sprite(8, 4, 0, SpriteSheet.frames_sheet);
    public static Sprite frame1_bottom_left_sprite = new Sprite(8, 3, 1, SpriteSheet.frames_sheet);
    public static Sprite frame1_top_right_sprite = new Sprite(8, 0, 1, SpriteSheet.frames_sheet);
    public static Sprite frame1_bottom_right_sprite = new Sprite(8, 2, 1, SpriteSheet.frames_sheet);

    //=========================================================================
    //== Bullets
    //=========================================================================

    // Normal bullet
    public static Sprite standard_bullet_sprite = new Sprite(8, 2, 0, SpriteSheet.bullet_sheet);
    public static Sprite orange_bullet_sprite = new Sprite(8, 0, 0, SpriteSheet.bullet_sheet);
    public static Sprite red_bullet_sprite = new Sprite(8, 1, 0, SpriteSheet.bullet_sheet);
    public static Sprite blue_bullet_sprite = new Sprite(8, 3, 0, SpriteSheet.bullet_sheet);
    public static Sprite green_bullet_sprite = new Sprite(8, 4, 0, SpriteSheet.bullet_sheet);
    public static Sprite enemy_bullet_sprite = new Sprite(8, 0, 4, SpriteSheet.bullet_sheet);
    public static Sprite violet_bullet_sprite = new Sprite(8, 1, 4, SpriteSheet.bullet_sheet);
    public static Sprite boss_bullet_sprite = new Sprite(8, 2, 4, SpriteSheet.bullet_sheet);

    // Big bullet
    public static Sprite big_standard_bullet_sprite = new Sprite(8, 2, 2, SpriteSheet.bullet_sheet);
    public static Sprite big_orange_bullet_sprite = new Sprite(8, 0, 2, SpriteSheet.bullet_sheet);
    public static Sprite big_red_bullet_sprite = new Sprite(8, 1, 2, SpriteSheet.bullet_sheet);
    public static Sprite big_blue_bullet_sprite = new Sprite(8, 3, 2, SpriteSheet.bullet_sheet);
    public static Sprite big_green_bullet_sprite = new Sprite(8, 4, 2, SpriteSheet.bullet_sheet);

    //=========================================================================
    //== Particles
    //=========================================================================

    // Explosive
    public static Sprite explosion_particle_sprite_0 = new Sprite(1, 0xff00DDDD);
    public static Sprite explosion_particle_sprite_1 = new Sprite(1, 0xff58D3F7);
    public static Sprite explosion_particle_sprite_2 = new Sprite(1, 0xffCEF6F5);

    // Fire
    public static Sprite fire_particle_sprite_0 = new Sprite(1, 0xffD82B2B);
    public static Sprite fire_particle_sprite_1 = new Sprite(1, 0xff8A0808);
    public static Sprite fire_particle_sprite_2 = new Sprite(1, 0xffFF0000);

    // Air
    public static Sprite air_particle_sprite = new Sprite(1, 0xffFFFFFF);

    // Health
    public static Sprite health_particle_sprite = new Sprite(3, 0, 0, SpriteSheet.mini3_sheet);
    public static Sprite stamina_particle_sprite = new Sprite(3, 1, 0, SpriteSheet.mini3_sheet);

    // Rain
    public static Sprite rain_particle1_sprite = new Sprite(1, 2, 0xff2E64FE);
    public static Sprite rain_particle2_sprite = new Sprite(1, 2, 0xffCED8F6);

    // Snow
    public static Sprite snow_particle1_sprite = new Sprite(1, 1, 0xffFFFFFF);
    public static Sprite snow_particle2_sprite = new Sprite(1, 1, 0xffBBFFFF);

    //=========================================================================
    //== Mini
    //=========================================================================

    public static Sprite mini_head_sprite = new Sprite(2, 0, 0, SpriteSheet.mini_sheet);
    public static Sprite mini_money_sprite = new Sprite(2, 1, 0, SpriteSheet.mini_sheet);

    //=========================================================================
    //== Items
    //=========================================================================

    public static Sprite rawIron_sprite = new Sprite(16, 6, 0, SpriteSheet.items_sheet);
    public static Sprite coal_sprite = new Sprite(16, 6, 1, SpriteSheet.items_sheet);
    public static Sprite ironBar_sprite = new Sprite(16, 6, 3, SpriteSheet.items_sheet);
    public static Sprite agroilberry_sprite = new Sprite(16, 0, 4, SpriteSheet.items_sheet);
    public static Sprite wheat_sprite = new Sprite(16, 1, 4, SpriteSheet.items_sheet);
    public static Sprite rolberry_sprite = new Sprite(16, 2, 4, SpriteSheet.items_sheet);
    public static Sprite yocip_sprite = new Sprite(16, 3, 4, SpriteSheet.items_sheet);
    public static Sprite health_sprite = new Sprite(8, 0, 0, SpriteSheet.items_sheet);

    //=========================================================================
    //== Get
    //=========================================================================

    public static Sprite get_rawIron_sprite = new Sprite(8, 0, 1, SpriteSheet.get_sheet);
    public static Sprite get_coal_sprite = new Sprite(8, 0, 2, SpriteSheet.get_sheet);
    public static Sprite get_uru_sprite = new Sprite(8, 0, 3, SpriteSheet.get_sheet);
    public static Sprite use_stamina_sprite = new Sprite(8, 1, 1, SpriteSheet.get_sheet);
    public static Sprite get_money_sprite = new Sprite(8, 1, 0, SpriteSheet.get_sheet);
    public static Sprite get_agroilberry_sprite = new Sprite(8, 2, 0, SpriteSheet.get_sheet);
    public static Sprite get_wheat_sprite = new Sprite(8, 2, 1, SpriteSheet.get_sheet);
    public static Sprite get_rolberry_sprite = new Sprite(8, 3, 0, SpriteSheet.get_sheet);
    public static Sprite get_yocip_sprite = new Sprite(8, 4, 0, SpriteSheet.get_sheet);

    //=========================================================================
    //== Status
    //=========================================================================

    public static Sprite s_poison_sprite = new Sprite(8, 0, 0, SpriteSheet.stati_sheet);

    //=========================================================================
    //== Expressions
    //=========================================================================

    public static Sprite haveQuest_sprite = new Sprite(8, 0, 0, SpriteSheet.expressions_sheet);
    public static Sprite activeQuest_sprite = new Sprite(8, 1, 0, SpriteSheet.expressions_sheet);
    public static Sprite bubble_sprite = new Sprite(8, 0, 1, SpriteSheet.expressions_sheet);

    //=========================================================================
    //== Plants
    //=========================================================================

    public static Sprite destroyable_grass0_1_sprite = new Sprite(8, 2, 0, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass0_2_sprite = new Sprite(8, 3, 0, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass1_1_sprite = new Sprite(8, 2, 1, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass1_2_sprite = new Sprite(8, 3, 1, SpriteSheet.flower_sheet);

    //=========================================================================
    //== Poison Factory
    //=========================================================================

    // Font
    public static Sprite tendril3_sprite = new Sprite(8, 2, 0, SpriteSheet.poisonFactory_sheet);
    public static Sprite destroyable_grass2_1_sprite = new Sprite(8, 0, 2, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass2_2_sprite = new Sprite(8, 1, 2, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass3_1_sprite = new Sprite(8, 0, 3, SpriteSheet.flower_sheet);
    public static Sprite destroyable_grass3_2_sprite = new Sprite(8, 1, 3, SpriteSheet.flower_sheet);
    public static Sprite blue_box_sprite = new Sprite(8, 1, 3, SpriteSheet.poisonFactory_sheet);
    public static Sprite red_box_sprite = new Sprite(8, 0, 3, SpriteSheet.poisonFactory_sheet);
    public static Sprite blue_box_frame_sprite = new Sprite(8, 1, 4, SpriteSheet.poisonFactory_sheet);
    public static Sprite red_box_frame_sprite = new Sprite(8, 0, 4, SpriteSheet.poisonFactory_sheet);

    // Background
    public static Sprite metal1_background_sprite = new Sprite(8, 0, 0, SpriteSheet.poisonFactory_sheet);
    public static Sprite metal2_background_sprite = new Sprite(8, 1, 0, SpriteSheet.poisonFactory_sheet);

    //=========================================================================
    //== Other
    //=========================================================================

    public static Sprite void_sprite = new Sprite(8, 0xffff00ff);
    public static Sprite warp_sprite = new Sprite(8, 16, 0xff000000);


    /**
     * constructor for square sprite without color
     */
    public Sprite(int size) {
        this.SIZE = size;
        this.WIDTH = size;
        this.HEIGHT = size;
    }

    /**
     * square sprite from a spritesheet
     */
    public Sprite(int size, int posX, int posY, SpriteSheet sheet) {
        this.SIZE = this.WIDTH = this.HEIGHT = size;
        this.sheet = sheet;
        this.posX = posX;
        this.posY = posY;
        this.pixels = new int[this.SIZE * this.SIZE];

        load();
    }

    /**
     * rectangle sprite from a spritesheet
     */
    public Sprite(int width, int height, int posX, int posY, SpriteSheet sheet) {
        this.SIZE = 1;
        this.WIDTH = width;
        this.HEIGHT = height;

        this.sheet = sheet;
        this.posX = posX;
        this.posY = posY;

        this.pixels = new int[this.WIDTH * this.HEIGHT];

        load();
    }

    /**
     * square sprite with special color
     */
    public Sprite(int size, int color) {
        this.SIZE = size;
        this.WIDTH = size;
        this.HEIGHT = size;

        this.pixels = new int[this.SIZE * this.SIZE];
        this.posX = -1;
        this.posY = -1;

        Arrays.fill(this.pixels, color);
    }

    /**
     * rectangular sprite with special color
     */
    public Sprite(int width, int height, int color) {
        this.SIZE = 1;
        this.WIDTH = width;
        this.HEIGHT = height;

        this.pixels = new int[this.WIDTH * this.HEIGHT];
        this.posX = -1;
        this.posY = -1;

        Arrays.fill(this.pixels, color);
    }

    /**
     * copy pixel array to new sprite
     */
    public Sprite(int[] pixels, int width, int height) {
        this.SIZE = width;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.pixels = new int[this.WIDTH * this.HEIGHT];

        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                this.pixels[x + y * this.WIDTH] = pixels[x + y * this.WIDTH];
            }
        }
    }

    /**
     * load a sprite without spritesheet, but with an inividual path
     */
    public Sprite(int width, int height, String path) {
        this.SIZE = 1;
        this.WIDTH = width;
        this.HEIGHT = height;

        this.pixels = new int[WIDTH * HEIGHT];
        this.path = path;

        load(1);
    }

    /**
     * load a sprite without spritesheet, but with an individual path and scale
     */
    public Sprite(int width, int height, String path, int scale) {
        this.SIZE = 1;
        this.WIDTH = width * scale;
        this.HEIGHT = height * scale;

        this.pixels = new int[WIDTH * HEIGHT];
        this.path = path;

        load(scale);
    }

    /**
     * load image into RGB-array, save colors in pixel array
     */
    public void load() { /* Spritesheet */
        int xa = this.posX * this.sheet.getStepX();
        int ya = this.posY * this.sheet.getStepY();

        for (int y = 0; y < this.HEIGHT; y++) {
            int yy = ya + y;
            for (int x = 0; x < this.WIDTH; x++) {
                int xx = xa + x;
                this.pixels[x + y * this.WIDTH] = this.sheet.getPixels()[xx + yy * this.sheet.getWidth()];
            }
        }
    }

    /**
     * if scale is not 1, resize image by scale. Only integer values possible
     */
    public void load(int scale) {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource(this.path)));
            int width = image.getWidth();
            int height = image.getHeight();

            if (scale <= 1) {
                image.getRGB(0, 0, width, height, this.pixels, 0, width);
            } else {
                BufferedImage newImage = resize(image,this.WIDTH, this.HEIGHT);
                width = newImage.getWidth();
                height = newImage.getHeight();
                newImage.getRGB(0, 0, width, height, this.pixels, 0, width);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * resize a buffered image
     * @return resized image
     */
    public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
        java.awt.Image tmp = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_DEFAULT);
        BufferedImage dimg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public int getSize() {
        return this.SIZE;
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    public int[] getPixels() {
        return this.pixels;
    }
}
