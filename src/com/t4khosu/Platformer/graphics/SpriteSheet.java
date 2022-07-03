package com.t4khosu.Platformer.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

/**
 * Sheet to save multiple sprites or even to generate an animation
 *
 * @author Christian
 */
public class SpriteSheet {
    private final int WIDTH;
    private final int HEIGHT;

    public final int STEP;
    public final int STEPX, STEPY;

    private int[] pixels;
    private String path;

    public Sprite[] sprites;

    private static final String TEXTURES_DIR = "/textures/";

    //=========================================================================
    //== Player
    //=========================================================================

    public static SpriteSheet player_sheet = new SpriteSheet(64, 64, 8, TEXTURES_DIR + "player.png");
    public static SpriteSheet player_right_sheet = new SpriteSheet(player_sheet, 0, 0, 4, 1, 8);
    public static SpriteSheet player_left_sheet = new SpriteSheet(player_sheet, 0, 1, 4, 1, 8);
    public static SpriteSheet player_climb_sheet = new SpriteSheet(player_sheet, 0, 2, 2, 1, 8);
    public static SpriteSheet player_crawl_left_sheet = new SpriteSheet(player_sheet, 2, 2, 3, 1, 8);
    public static SpriteSheet player_crawl_right_sheet = new SpriteSheet(player_sheet, 2, 3, 3, 1, 8);
    public static SpriteSheet player_plow_left_sheet = new SpriteSheet(player_sheet, 2, 4, 2, 1, 8);
    public static SpriteSheet player_plow_right_sheet = new SpriteSheet(player_sheet, 2, 5, 2, 1, 8);
    public static SpriteSheet player_catch_right_sheet = new SpriteSheet(player_sheet, 0, 3, 1, 2, 8);
    public static SpriteSheet player_catch_left_sheet = new SpriteSheet(player_sheet, 1, 3, 1, 2, 8);
    public static SpriteSheet player_hit_right_sheet = new SpriteSheet(player_sheet, 0, 6, 3, 1, 8);
    public static SpriteSheet player_hit_left_sheet = new SpriteSheet(player_sheet, 0, 7, 3, 1, 8);
    public static SpriteSheet player_breakStone_right_sheet = new SpriteSheet(player_sheet, 4, 4, 1, 2, 8);
    public static SpriteSheet player_breakStone_left_sheet = new SpriteSheet(player_sheet, 3, 6, 1, 2, 8);
    public static SpriteSheet player_stand_right_sheet = new SpriteSheet(player_sheet, 6, 0, 2, 1, 8);
    public static SpriteSheet player_stand_left_sheet = new SpriteSheet(player_sheet, 6, 1, 2, 1, 8);

    //=========================================================================
    //== NPCs
    //=========================================================================

    public static SpriteSheet npc_sheet = new SpriteSheet(40, 48, 8, TEXTURES_DIR + "NPC_standard.png");
    public static SpriteSheet npc_right_sheet = new SpriteSheet(npc_sheet, 0, 0, 4, 1, 8);
    public static SpriteSheet npc_left_sheet = new SpriteSheet(npc_sheet, 0, 1, 4, 1, 8);
    public static SpriteSheet female_npc_right_sheet = new SpriteSheet(npc_sheet, 0, 2, 4, 1, 8);
    public static SpriteSheet female_npc_left_sheet = new SpriteSheet(npc_sheet, 0, 3, 4, 1, 8);
    public static SpriteSheet beard_npc_right_sheet = new SpriteSheet(npc_sheet, 0, 4, 4, 1, 8);
    public static SpriteSheet beard_npc_left_sheet = new SpriteSheet(npc_sheet, 0, 5, 4, 1, 8);

    public static SpriteSheet hair1_right_sheet = new SpriteSheet(npc_sheet, 0, 2, 4, 1, 8);
    public static SpriteSheet hair1_left_sheet = new SpriteSheet(npc_sheet, 0, 3, 4, 1, 8);
    public static SpriteSheet hair2_right_sheet = new SpriteSheet(npc_sheet, 0, 4, 4, 1, 8);
    public static SpriteSheet hair2_left_sheet = new SpriteSheet(npc_sheet, 0, 5, 4, 1, 8);

    //=========================================================================
    //== Mobs
    //=========================================================================

    public static SpriteSheet slimes_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "slimes.png");
    public static SpriteSheet boss_slime_sheet = new SpriteSheet(72, 24, 24, TEXTURES_DIR + "bossSlime.png");

    //=========================================================================
    //== Objects
    //=========================================================================

    public static SpriteSheet objects_sheet = new SpriteSheet(64, 64, 8, TEXTURES_DIR + "objects.png");
    public static SpriteSheet red_torch_sheet = new SpriteSheet(objects_sheet, 0, 2, 3, 1, 8);
    public static SpriteSheet blue_torch_sheet = new SpriteSheet(objects_sheet, 5, 4, 3, 1, 8);
    public static SpriteSheet loot_sheet = new SpriteSheet(objects_sheet, 0, 4, 2, 1, 8);
    public static SpriteSheet fishing_pole_right_sheet = new SpriteSheet(objects_sheet, 3, 2, 1, 2, 8);
    public static SpriteSheet fishing_pole_left_sheet = new SpriteSheet(objects_sheet, 4, 2, 1, 2, 8);
    public static SpriteSheet warp_sheet = new SpriteSheet(objects_sheet, 0, 5, 3, 1, 8);


    //=========================================================================
    //== Floors
    //=========================================================================

    public static SpriteSheet floor_sheet = new SpriteSheet(88, 56, 8, TEXTURES_DIR + "floor.png");
    public static SpriteSheet water1_sheet = new SpriteSheet(floor_sheet, 0, 3, 3, 1, 8);
    public static SpriteSheet water2_sheet = new SpriteSheet(floor_sheet, 0, 4, 3, 1, 8);
    public static SpriteSheet water3_sheet = new SpriteSheet(floor_sheet, 2, 6, 3, 1, 8);
    public static SpriteSheet waterPoison_sheet = new SpriteSheet(floor_sheet, 5, 2, 3, 1, 8);
    public static SpriteSheet waterfall1_sheet = new SpriteSheet(floor_sheet, 5, 3, 2, 1, 8);
    public static SpriteSheet waterfall2_sheet = new SpriteSheet(floor_sheet, 5, 4, 2, 1, 8);
    public static SpriteSheet waterfall3_sheet = new SpriteSheet(floor_sheet, 5, 5, 2, 1, 8);
    public static SpriteSheet waterfall4_sheet = new SpriteSheet(floor_sheet, 7, 4, 2, 1, 8);
    public static SpriteSheet glowingStone_sheet = new SpriteSheet(floor_sheet, 7, 1, 4, 1, 8);

    //=========================================================================
    //== Bullets
    //=========================================================================

    public static SpriteSheet bullet_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "bullets.png");
    public static SpriteSheet red_bullet_sheet = new SpriteSheet(bullet_sheet, 1, 1, 1, 3, 8);
    public static SpriteSheet blue_bullet_sheet = new SpriteSheet(bullet_sheet, 3, 1, 1, 3, 8);
    public static SpriteSheet green_bullet_sheet = new SpriteSheet(bullet_sheet, 4, 1, 1, 3, 8);
    public static SpriteSheet orange_bullet_sheet = new SpriteSheet(bullet_sheet, 0, 1, 1, 3, 8);
    public static SpriteSheet standard_bullet_sheet = new SpriteSheet(bullet_sheet, 2, 1, 1, 3, 8);

    //=========================================================================
    //== Plants
    //=========================================================================

    public static SpriteSheet plant_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "plants.png");
    public static SpriteSheet plant1_sheet = new SpriteSheet(plant_sheet, 0, 0, 2, 1, 8);
    public static SpriteSheet plant2_sheet = new SpriteSheet(plant_sheet, 0, 1, 2, 1, 8);
    public static SpriteSheet plant3_sheet = new SpriteSheet(plant_sheet, 0, 2, 2, 1, 8);
    public static SpriteSheet plant4_sheet = new SpriteSheet(plant_sheet, 0, 3, 2, 1, 8);

    public static SpriteSheet plant21_sheet = new SpriteSheet(plant_sheet, 2, 0, 2, 1, 8);
    public static SpriteSheet plant22_sheet = new SpriteSheet(plant_sheet, 2, 1, 2, 1, 8);
    public static SpriteSheet plant23_sheet = new SpriteSheet(plant_sheet, 2, 2, 2, 1, 8);
    public static SpriteSheet plant24_sheet = new SpriteSheet(plant_sheet, 2, 3, 2, 1, 8);

    //=========================================================================
    //== Flowers
    //=========================================================================

    public static SpriteSheet flower_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "flowers.png");
    public static SpriteSheet flower1_sheet = new SpriteSheet(flower_sheet, 0, 0, 2, 1, 8);
    public static SpriteSheet flower2_sheet = new SpriteSheet(flower_sheet, 0, 1, 2, 1, 8);

    //=========================================================================
    //== Enemies
    //=========================================================================

    public static SpriteSheet enemy_sheet = new SpriteSheet(64, 64, 8, TEXTURES_DIR + "enemies.png");
    public static SpriteSheet brownSpider_sheet = new SpriteSheet(enemy_sheet, 0, 0, 1, 2, 8);
    public static SpriteSheet greenSpider_sheet = new SpriteSheet(enemy_sheet, 1, 0, 1, 2, 8);
    public static SpriteSheet blueSpider_sheet = new SpriteSheet(enemy_sheet, 2, 0, 1, 2, 8);

    public static SpriteSheet flying_mob_sheet = new SpriteSheet(enemy_sheet, 1, 0, 1, 4, 8);

    public static SpriteSheet stoneSnail_left_sheet = new SpriteSheet(enemy_sheet, 0, 2, 3, 1, 8);
    public static SpriteSheet stoneSnail_right_sheet = new SpriteSheet(enemy_sheet, 0, 3, 3, 1, 8);
    public static SpriteSheet stoneSnail_move_left_sheet = new SpriteSheet(enemy_sheet, 2, 2, 2, 1, 8);
    public static SpriteSheet stoneSnail_move_right_sheet = new SpriteSheet(enemy_sheet, 2, 3, 2, 1, 8);

    //=========================================================================
    //== Sword
    //=========================================================================

    public static SpriteSheet sword_sheet = new SpriteSheet(64, 64, 16, TEXTURES_DIR + "swords.png");
    public static SpriteSheet wooden_sword1_right_sheet = new SpriteSheet(sword_sheet, 0, 0, 3, 1, 16);
    public static SpriteSheet wooden_sword1_left_sheet = new SpriteSheet(sword_sheet, 0, 1, 3, 1, 16);

    //=========================================================================
    //== pMachine
    //=========================================================================

    public static SpriteSheet pMachine_sheet = new SpriteSheet(288, 48, 48, TEXTURES_DIR + "pMachine.png", 3);
    public static SpriteSheet pMachineParts_sheet = new SpriteSheet(60, 40, 10, TEXTURES_DIR + "pMachineParts.png", 3);
    public static SpriteSheet pMachine1_sheet = new SpriteSheet(pMachine_sheet, 0, 0, 6, 1, 48 * 3);

    public static SpriteSheet pMachineBlue_sheet = new SpriteSheet(pMachineParts_sheet, 0, 0, 6, 1, 10 * 3);
    public static SpriteSheet pMachineRed_sheet = new SpriteSheet(pMachineParts_sheet, 0, 1, 6, 1, 10 * 3);
    public static SpriteSheet pMachineYellow_sheet = new SpriteSheet(pMachineParts_sheet, 0, 2, 6, 1, 10 * 3);
    public static SpriteSheet pMachineGreen_sheet = new SpriteSheet(pMachineParts_sheet, 0, 3, 6, 1, 10 * 3);

    //=========================================================================
    //== Poison Factory
    //=========================================================================

    public static SpriteSheet poisonFactory_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "poisonFactory.png");
    public static SpriteSheet pipe2_sheet = new SpriteSheet(poisonFactory_sheet, 0, 1, 3, 1, 8);
    public static SpriteSheet pipe2top_sheet = new SpriteSheet(poisonFactory_sheet, 0, 2, 3, 1, 8);

    //=========================================================================
    //== Furniture
    //=========================================================================

    public static SpriteSheet furniture_sheet = new SpriteSheet(80, 40, 8, TEXTURES_DIR + "furniture.png");
    public static SpriteSheet blacksmith_fire_sheet = new SpriteSheet(furniture_sheet, 5, 2, 3, 1, 8);

    //=========================================================================
    //== Background
    //=========================================================================

    public static SpriteSheet background_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "backgrounds.png");
    public static SpriteSheet pipe1_sheet = new SpriteSheet(background_sheet, 0, 4, 3, 1, 8);

    //=========================================================================
    //== Other
    //=========================================================================

    public static SpriteSheet items_sheet = new SpriteSheet(112, 112, 16, TEXTURES_DIR + "items.png");
    public static SpriteSheet big_sheet = new SpriteSheet(80, 80, 16, TEXTURES_DIR + "bigSprites.png");
    public static SpriteSheet long_sheet = new SpriteSheet(48, 40, 16, 8, TEXTURES_DIR + "longFurniture.png");
    public static SpriteSheet get_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "getSomething.png");
    public static SpriteSheet poisonMachine_sheet = new SpriteSheet(384, 64, 64, TEXTURES_DIR + "poisonMachine.png");
    public static SpriteSheet poisonMachine1_sheet = new SpriteSheet(poisonMachine_sheet, 0, 0, 6, 1, 64);
    public static SpriteSheet building_sheet = new SpriteSheet(40, 40, 8, TEXTURES_DIR + "buildings.png");
    public static SpriteSheet frames_sheet = new SpriteSheet(64, 64, 16, TEXTURES_DIR + "frames.png");
    public static SpriteSheet mini_sheet = new SpriteSheet(8, 8, 2, TEXTURES_DIR + "mini.png");
    public static SpriteSheet mini3_sheet = new SpriteSheet(12, 12, 3, TEXTURES_DIR + "mini3.png");
    public static SpriteSheet stati_sheet = new SpriteSheet(16, 16, 8, TEXTURES_DIR + "stati.png");
    public static SpriteSheet expressions_sheet = new SpriteSheet(24, 24, 8, TEXTURES_DIR + "expressions.png");

    /**
     * constructor load sheet, square sprites
     */
    public SpriteSheet(int width, int height, int step, String path) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.STEP = this.STEPX = this.STEPY = step;
        this.path = path;
        this.pixels = new int[this.WIDTH * this.HEIGHT];

        load();
    }

    /**
     * Dynamic size
     */
    public SpriteSheet(int width, int height, int step, String path, int multiplier) {
        this.WIDTH = width * multiplier;
        this.HEIGHT = height * multiplier;
        this.STEP = this.STEPX = this.STEPY = step * multiplier;
        this.path = path;
        this.pixels = new int[this.WIDTH * this.HEIGHT];

        load(multiplier);
    }

    /**
     * Rectangular sprites
     */
    public SpriteSheet(int width, int height, int stepX, int stepY, String path) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.STEP = -1;
        this.STEPX = stepX;
        this.STEPY = stepY;
        this.path = path;
        this.pixels = new int[this.WIDTH * this.HEIGHT];

        load();
    }

    /**
     * Sub-spritesheet for animations
     */
    public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
        this.STEP = sheet.STEP;
        this.STEPX = sheet.STEPX;
        this.STEPY = sheet.STEPY;

        int w = width * this.STEPX;
        int h = height * this.STEPY;
        int xx = x * this.STEPX;
        int yy = y * this.STEPY;

        this.WIDTH = w;
        this.HEIGHT = h;

        this.pixels = new int[this.WIDTH * this.HEIGHT];

        for (int y0 = 0; y0 < h; y0++) {
            int ya = yy + y0;
            for (int x0 = 0; x0 < w; x0++) {
                int xa = xx + x0;
                this.pixels[x0 + y0 * w] = sheet.getPixels()[xa + ya * sheet.getWidth()];
            }
        }

        int frames = 0;
        sprites = new Sprite[width * height];

        for (int y0 = 0; y0 < height; y0++) {
            int y1 = y0 * spriteSize;
            for (int x0 = 0; x0 < width; x0++) {
                int x1 = x0 * spriteSize;
                int[] spritePixels = new int[spriteSize * spriteSize];

                for (int ys = 0; ys < spriteSize; ys++) {
                    for (int xs = 0; xs < spriteSize; xs++) {
                        spritePixels[xs + ys * spriteSize] = this.pixels[(x1 + xs) + (y1 + ys) * this.WIDTH];
                    }
                }

                Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
                sprites[frames] = sprite;
                frames++;
            }
        }
    }

    /**
     * Load image into RGB-array
     */
    public void load() {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(SpriteSheet.class.getResource(this.path)));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, this.pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load spritesheet with multiplier
     */
    public void load(int scale) {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource(this.path)));
            int width = image.getWidth();
            int height = image.getHeight();

            if (scale <= 1) {
                image.getRGB(0, 0, width, height, this.pixels, 0, width);
            } else {
                BufferedImage newImage = Sprite.resize(image, this.WIDTH, this.HEIGHT);
                width = newImage.getWidth();
                height = newImage.getHeight();
                newImage.getRGB(0, 0, width, height, this.pixels, 0, width);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getPixels() {
        return this.pixels;
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    public int getStep() {
        return this.STEP;
    }

    public int getStepX() {
        return this.STEPX;
    }

    public int getStepY() {
        return this.STEPY;
    }
}