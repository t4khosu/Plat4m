package com.t4khosu.Platformer.Level;

import com.t4khosu.Platformer.Level.areas.HauntedForest;
import com.t4khosu.Platformer.Level.areas.Neuleben;
import com.t4khosu.Platformer.Level.areas.VillageForest;
import com.t4khosu.Platformer.Level.dungeons.Dungeon;
import com.t4khosu.Platformer.Level.dungeons.DungeonBoss_01;
import com.t4khosu.Platformer.Level.dungeons.Dungeon_01;
import com.t4khosu.Platformer.Surface.Surface;
import com.t4khosu.Platformer.entities.Camera;
import com.t4khosu.Platformer.entities.Door;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.dialog.Dialogbox;
import com.t4khosu.Platformer.entities.interactiveEntities.Fire;
import com.t4khosu.Platformer.entities.interactiveEntities.plants.PlantManager;
import com.t4khosu.Platformer.entities.player.Player;
import com.t4khosu.Platformer.entities.weather.Rain;
import com.t4khosu.Platformer.entities.weather.Weather;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.cutscenes.ChangeAreaCutscene;
import com.t4khosu.Platformer.graphics.cutscenes.Cutscene;
import com.t4khosu.Platformer.graphics.cutscenes.Enter_Door_Cutscene;
import com.t4khosu.Platformer.input.Keyboard;
import com.t4khosu.Platformer.saveGame.SaveManager;

import java.awt.*;
import java.util.Random;

/**
 * many areas create a whole world
 *
 * @author Christian
 */
public class World {

    private Player player;
    private Camera camera;
    private Surface surface;
    private Cutscene cutscene;

    //areas
    private Area neuleben;
    private Area villageForest;
    private Area hauntedForest;
    private Dungeon dungeon_01;
    private Dungeon dungeonBoss_01;

    //breakpoints
    private BreakPointManager bpm;

    //actual weather, may change when switch to other areas
    private Weather weather;
    private Timer weatherTimer;

    private final int FAST_WEATHER = 1; // 1 = normal
    private int minWeatherLength = 4000 / FAST_WEATHER;
    private int randWeatherLengthAdd = 3000 / FAST_WEATHER;
    private int minWaitForWeatherLength = 12000 / FAST_WEATHER;
    private int randWaitForWeatherLengthAdd = 6000 / FAST_WEATHER;
    private Random random;

    //Init matrix for all areas in this world
    private int areaWidth = 4;
    private int areaHeight = 4;
    public Area actualArea; //area player is in right now

    //actual Area position
    private int actualAreaX = 1; /* 1, 1 (dungeon entry) */ /*0, 2  (dungeon 1)*/
    private int actualAreaY = 1;
    private Area[] areas;

    private Dialogbox db = null;
    public boolean openDialog = false;

    //public boolean justStarted = true;

    private Timer areaChangeTitleTimer; /* show title of dungeon area certain time */
    private int areaSpriteIn = 0;

    //SAVE FILES
    private SaveManager saveManager;

    /**
     * Constructor
     *
     * @param input
     */
    public World(Keyboard input) {
        this.player = new Player(10, 10, input, this); /* 60, 41 */ /* 20, 81 */
        this.camera = new Camera(player);
        this.saveManager = new SaveManager(this);


        this.random = new Random();
        weatherTimer = new Timer(minWaitForWeatherLength + random.nextInt(randWaitForWeatherLengthAdd));
        weatherTimer.start();

        this.areas = new Area[areaWidth * areaHeight];
        initAreas();
        areaChangeTitleTimer = new Timer(160);

        setActualArea(getNeuleben());
        getActualArea().setActualLevel(0, 1);

        //=================================================
        bpm = new BreakPointManager(this);
        bpm.setBreakPointBeginning(5);
        bpm.setPlayerModus(0);
        //=================================================
    }

    /**
     * init all areas according to the map
     */
    public void initAreas() {
        neuleben = new Neuleben(this, 1, 1);
        hauntedForest = new HauntedForest(this, 2, 1);
        villageForest = new VillageForest(this, 0, 1);
        dungeon_01 = new Dungeon_01(this, 1, 2);
        dungeonBoss_01 = new DungeonBoss_01(this, 1, 3);

        areas[0 + areaWidth * 1] = villageForest;
        areas[1 + areaWidth * 1] = neuleben;
        areas[2 + areaWidth * 1] = hauntedForest;
        areas[1 + areaWidth * 2] = dungeon_01;
        areas[1 + areaWidth * 3] = dungeonBoss_01;

        /*
         * WHEN ADDING AREA:
         * make sure to set the right worldX and worldY coordinates!
         * And also change the other areas coordinates if a new column/row is added
         *
         */
        // +---------------------+---------------------+---------------------+---------------------+
        // |				     |					   |
        // |				     |  				   |
        // |				     |					   |
        // +---------------------+---------------------+---------------------+---------------------+
        // |				     |					   |					 |
        // |	Village Forest	 |       Neuleben      |    Haunted Forest   |
        // |				     |					   |					 |
        // +---------------------+---------------------+---------------------+---------------------+
        // |				     |				       |
        // |				     |	     Dungeon 1     |
        // |				     |					   |
        // +---------------------+---------------------+---------------------+---------------------+
        // |				     |				       |
        // |				     |    Boss Dungeon 1   |
        // |				     |					   |
        // +---------------------+---------------------+---------------------+---------------------+
    }

    /**
     * move player to another level when going through a door
     *
     * @param d
     */
    public void moveTo(Door d) {
        if (d != null) { /* null -> no door was found */
            levelChange(d.getLevel(),
                    d.getX() + d.getWidth() / 2 - player.getWidth() / 2,
                    d.getY() + d.getHeight() - player.getHeight());
        }
    }

    /**
     * move player to another level when going through a door or warp (teleport)
     *
     * @param d
     */
    public void levelChange(Level level, int posX, int posY) {
        setActualArea(level.getArea());
        actualArea.resetArea();
        actualArea.setActualLevel(level);
        actualAreaX = actualArea.getWorldPosX();
        actualAreaY = actualArea.getWorldPosY();

        player.setX(posX);
        player.setY(posY);
        player.initLevel(level);

        areaSpriteIn = -actualArea.getAreaSprite().getWidth();
        areaChangeTitleTimer.start();
    }

    /**
     * Change level depending in which direction player goes
     * and trigger switch-area-animation if needed
     */
    public void levelChange(int dirX, int dirY) {
        if (dirX < 0) { /* left */

            if (actualArea.getActualLevelX() - 1 >= 0) {
                actualArea.setActualLevel(actualArea.getActualLevelX() - 1, actualArea.getActualLevelY());
                player.setX(getActualLevel().getWidth() - 8);
                player.initLevel(getActualLevel());
            } else startChangeAreaCutscene(-1, 0);

        } else if (dirX > 0) { /* right */
            if (actualArea.getActualLevelX() + 1 < actualArea.getWidth()) {
                actualArea.setActualLevel(actualArea.getActualLevelX() + 1, actualArea.getActualLevelY());
                player.setX(0);
                player.initLevel(getActualLevel());
            } else startChangeAreaCutscene(1, 0);
        }

        if (dirY != 0) { // Up and Down Levels
            Level l;
            int helperDirY = (dirY + 1) / 2;
            if ((l = actualArea.getLevelY(dirY)) != null) {
                actualArea.setActualLevel(l);
                player.setY((1 - helperDirY) * actualArea.getActualLevel().getHeight() + dirY * 8);
                player.initLevel(getActualLevel());
            } else if (actualArea.getActualLevelY() == helperDirY * (actualArea.getHeight() - 1)) {
                startChangeAreaCutscene(0, dirY);
            }
        }
    }

    /**
     * change whole area when going to a specific direction (by foot)
     *
     * @param dirX
     * @param dirY
     */
    public void areaChange(int dirX, int dirY) {
        Area tempArea = actualArea;
        int areaPosY = getActualLevel().getAreaPosY();
        int areaPosX = getActualLevel().getAreaPosX();

        if (dirX != 0 && areas[actualAreaX + dirX + areaWidth * actualAreaY] != null) {
            int helperDirX = (dirX + 1) / 2; // right = 1, left = 0
            setActualArea(areas[actualAreaX + dirX + areaWidth * actualAreaY]);

            actualArea.setActualLevel((1 - helperDirX) * actualArea.getWidth() + (1 - helperDirX) * -1, areaPosY);
            player.setX((1 - helperDirX) * getActualLevel().getWidth() + dirX * (2 - helperDirX) * 8);
        }

        if (dirY != 0 && areas[actualAreaX + areaWidth * (actualAreaY + dirY)] != null) {
            int helperDirY = (dirY + 1) / 2; // top = 1, down = 0
            setActualArea(areas[actualAreaX + areaWidth * (actualAreaY + dirY)]);
            actualArea.setActualLevel(areaPosX, (1 - helperDirY) * actualArea.getHeight() + (1 - helperDirY) * -1);
            player.setY((1 - helperDirY) * getActualLevel().getHeight() + dirY * 9);
        }

        player.initLevel(getActualLevel());
        actualArea.initBackground(tempArea);

        areaSpriteIn = -actualArea.getAreaSprite().getWidth();
        areaChangeTitleTimer.start();
    }

    /**
     * start door Cutscene
     *
     * @param d
     */
    public void startDoorCutscene(Door d) {
        this.cutscene = new Enter_Door_Cutscene(this, d);
    }

    /**
     * when changing area, fade away before entering new area
     */
    public void startChangeAreaCutscene(int dirX, int dirY) {
        this.cutscene = new ChangeAreaCutscene(this, dirX, dirY);
    }

    /**
     * render screen
     *
     * @param screen
     * @param xOff
     * @param yOff
     */
    public void render(Screen screen, int xOff, int yOff) {
        if (cutscene == null || cutscene.getRemoveScreen() != 0) { /* cutscene and screen */
            actualArea.render(xOff, yOff, screen);
            surface.render(screen);
        }
        if (cutscene != null && cutscene.getRemoveScreen() != 1) { /* only cutscene */
            cutscene.render(screen);
        }

        if (areaChangeTitleTimer.isActive() && cutscene == null && actualArea.getAreaSprite() != null) { /* just changed area to dungeon area, show area text */
            if (areaSpriteIn < 0) {
                areaSpriteIn++;
            }
            screen.renderSprite(areaSpriteIn, 12, actualArea.getAreaSprite(), false);
        }
    }

    /**
     * render graphics
     *
     * @param g
     */
    public void render(Graphics g) {
        if (cutscene == null || cutscene.getRemoveText() != 0) { /* cutscene and screen */
            actualArea.render(g);
            surface.render(g);
        }
        if (cutscene != null && cutscene.getRemoveText() != 1) { /* only cutscene */
            cutscene.render(g);
        }
    }

    /**
     * update screen xor cutscene, then always update weather, surface and camera
     */
    public void update() {
        //scene update
        if (cutscene == null) {
            actualArea.update();
            PlantManager.update();
            Fire.blacksmithFire.update();
        } else {
            cutscene.update();
        }

        //weather update (always)
        if (weather != null) {
            weather.update();
            removeWeather();
        } else {
            weatherTimer.update();

            if (!weatherTimer.isActive()) {
                //start new weather if possible
                if (actualArea.getActualLevel().getType() != Level.levelType.UNDERGROUND) {
                    if (actualArea.canRain) {
                        weather = new Rain(minWeatherLength + random.nextInt(randWeatherLengthAdd), actualArea.getActualLevel(), true);
                        //weather = new Snow(minWeatherLength + random.nextInt(randWeatherLengthAdd), actualArea.getActualLevel());
                    }
                }
            }
        }

        //surface and camera update (always)
        surface.update();
        camera.update();
        areaChangeTitleTimer.update();
    }

    /**
     * check whether weather can be removed
     */
    private void removeWeather() {
        if (weather.isRemoved()) {
            weather = null;
            weatherTimer.setMaxTime(minWaitForWeatherLength + random.nextInt(randWaitForWeatherLengthAdd));
            weatherTimer.start();
        }
    }

    /**
     * check if entity is able to move
     *
     * @return boolean
     */
    public boolean canMove() {
        return !surface.openTextBox() &&            //no open Textbox
                !surface.getInventory().isOpen();    //no open inventory
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* Get and set methods */
    public Area getActualArea() {
        return actualArea;
    }

    public Level getActualLevel() {
        return actualArea.getActualLevel();
    }

    public Camera getCamera() {
        return camera;
    }

    public Area[] getAreas() {
        return areas;
    }

    public Weather getWeather() {
        return weather;
    }

    public Surface getSurface() {
        return surface;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean cutsceneIsRunning() {
        return cutscene != null;
    }

    public int getAreaWidth() {
        return areaWidth;
    }

    public int getAreaHeight() {
        return areaHeight;
    }

    public Area getNeuleben() {
        return neuleben;
    }

    public Area getHauntedForest() {
        return hauntedForest;
    }

    public Dungeon getDungeon_01() {
        return dungeon_01;
    }

    public Area getVillageForest() {
        return villageForest;
    }

    public Timer getWeatherTimer() {
        return weatherTimer;
    }

    public SaveManager getSaveManager() {
        return saveManager;
    }


    public void setActualArea(Area area) {
        actualArea = area;
        actualAreaX = area.getWorldPosX();
        actualAreaY = area.getWorldPosY();
        actualArea.resetArea();
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setCutscene(Cutscene cutscene) {
        this.cutscene = cutscene;
    }

    public void setActualAreaPosition(int x, int y) {
        actualAreaX = x;
        actualAreaY = y;
    }

    public void initSurface(Surface surface) {
        this.surface = surface;
    }
}