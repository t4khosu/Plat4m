/**
 * character controlled by user
 */

package com.t4khosu.Platformer.entities.player;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Level.tile.TileGetterList;
import com.t4khosu.Platformer.entities.Bar;
import com.t4khosu.Platformer.entities.Button;
import com.t4khosu.Platformer.entities.ItemStore;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Agroilberry;
import com.t4khosu.Platformer.entities.item.mainItems.plants.Rolberry;
import com.t4khosu.Platformer.entities.item.mainItems.potions.HealthPotion;
import com.t4khosu.Platformer.entities.log.Entry;
import com.t4khosu.Platformer.entities.log.Log;
import com.t4khosu.Platformer.entities.mob.Mob;
import com.t4khosu.Platformer.entities.particles.Spawner;
import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.cutscenes.PlayerDeath_Cutscene;
import com.t4khosu.Platformer.input.Keyboard;
import com.t4khosu.Platformer.entities.enemies.slimes.PoisonSlime;
import com.t4khosu.Platformer.entities.player.activities.PlayerStatusManager;

public class Player extends Mob {

    private AnimatedSprite player_animated = AnimatedSprite.player_right;
    private Item[] JK;
    private Item[] smallSlots;
    private Keyboard input;
    private Log log;

    //Standard character attributes
    private int rul = 0; /*currency in this world */
    public int actualExperienceAdd = 0;
    private int next_experience;
    private int experience;
    private boolean visible = true;
    private boolean canAct = true;
    private int strength = 0;

    //Stamina
    private int max_stamina;
    private int stamina;

    //Bars
    private Bar breathBar;

    //Managers
    private PlayerStatusManager psm;
    private PlayerTimerManager ptm;
    private ItemStoreManager itemStoreManager;
    private KeyboardManager keyboardManager;

    /**
     * constructor
     *
     * @param x
     * @param y
     * @param sprite
     * @param input
     * @param world
     */
    public Player(int x, int y, Keyboard input, World world) {
        super(x * 8, y * 8, Sprite.player_right);
        this.world = world;
        this.input = input;
        this.itemStoreManager = new ItemStoreManager(5, 5, ItemStore.StoreType.OWNSTORE, 3);
        this.ptm = new PlayerTimerManager();
        this.psm = new PlayerStatusManager(this);
        this.keyboardManager = new KeyboardManager(this, psm, ptm);
        this.log = new Log(this);
        this.breathBar = new Bar(width, 200, Bar.BarType.NORMAL, true, this);
        JK = new Item[2]; //middle fields
        smallSlots = new Item[6]; //side fields

        //start values:
        initStartValues();
    }

    /**
     * Initialize start values for player
     */
    private void initStartValues() {
        lvl = 1;
        experience = 0;
        speed = 2;
        next_experience = getNextExperience(lvl + 1);
        initLife(40);
        max_stamina = 140;
        stamina = max_stamina;
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        if (!visible) return;
        if (msm.getBlinkON()) {
            screen.renderNewHSB(x, y, sprite, true, 1.0f, 0.5f);
        } else {
            screen.renderSprite(x, y, sprite, true);
        }

        if (mtm.getInvincibleTimer().isActive() || ptm.getDamageTimer().isActive())
            screen.renderLifeBar(x, y - 2, life, max_life, 8, 1, true);
        if (mtm.getPoisonedTimer().isActive()) {
            screen.renderSprite(0, 10, Sprite.s_poison_sprite, false);
            screen.renderBar(x, y - 2, life, max_life, width, 0xffFF14E7, true);
        }

        if (msm.isUnderWater()) breathBar.render(screen); /* breathing bar in water */
        psm.render(screen); /* special activities e.g.  planting */

        if (psm.plowing.getPlowing()) {
            int xx = ((x + 1) / 8) * 8;
            if (dirX > 0) {
                xx = ((x + width - 2) / 8) * 8;
            }
            screen.renderSprite(xx, ((y / 8 + 1) * 8), Sprite.plant_frame_sprite, true);
        }
    }

    /**
     * update player with all activities and timers
     */
    public void update() {
        mtm.updateTimers();
        ptm.updateTimers();
        blinkManager();

        checkTile(); /* tile player standing on */
        positionCorrection(); /* when not moving with half speed anymore */
        damageBySpikes();
        regenerateStamina();

        //change Levels:
        if (x + width - 1 > level.getWidth()) world.levelChange(1, 0);
        else if (x < 0) world.levelChange(-1, 0);

        if (y + height - 1 > level.getHeight()) world.levelChange(0, 1);
        else if (y < 0) world.levelChange(0, -1);


        //check if under water, set timer:
        if (!msm.isUnderWater()) {
            breathBar.reset();
        } else {
            if (breathBar.getValue() == 0) {
                hit(max_life / 10);
            } else {
                breathBar.sub(1);
            }

            if (Game.timer % 30 == 0) new Spawner(x + 4 + (3 * dirX), y, 1, level, Spawner.ParticleType.AIR); //air particle
        }

        //******************************************************************************

        if (dirX == -1) { /* standard movement, can be overridden with keyboardManager */
            if (psm.isCrawling()) sprite = AnimatedSprite.player_crawl_left.getSprite();
            else sprite = Sprite.player_left;
        } else {
            if (psm.isCrawling()) sprite = AnimatedSprite.player_crawl_right.getSprite();
            else sprite = Sprite.player_right;
        }

        if (psm.isCrawling()) { /* crawling */
            crawlY = 5;
        } else crawlY = 0;

        if (!(TileGetterList.getTile(x / 8, y / 8, level).isPartlySolid() ||
                TileGetterList.getTile((x + width - 1) / 8, y / 8, level).isPartlySolid()) && !input.down)
            psm.setCrawling(false);

        //******************************************************************************

        //Control of all Inputs
        if (canAct) {
            keyboardManager.update(); /* keyboardManager -> updates activityManager */
        }

        //******************************************************************************

        //Actual animation:
        if (psm.isAnimated() && !psm.swingSword.getSwingingSword()) {
            player_animated.update();
            sprite = player_animated.getSprite();
        }

        //******************************************************************************

        if (psm.swingSword.getSwingingSword()) { /* swinging sword */
            psm.swingSword.update();
            if (dirX == -1) {
                sprite = AnimatedSprite.player_hit_left.getSprite();
            } else {
                sprite = AnimatedSprite.player_hit_right.getSprite();
            }
        }

        if (psm.fishing.isCatching()) {
            psm.fishing.catchingModeUpdate();
        }

        //******************************************************************************
        /* No bottom -> fall, take damage if too fast ; same for jumping */

        if (!bottomCollision() && !psm.isClimbing()) {
            falling();
        } else {
            if (vFall > 10) { /* fall damage */
                life -= (int) vFall / 2;
                new Spawner(x + 4, y, 5, level, Spawner.ParticleType.BLOOD);
                ptm.getDamageTimer().start();
            }
            vFall = level.STANDARD_G;

            if (!psm.isClimbing()) {
                jumpCount = maxJumpCount;
            }

        }

        //*******************************
        /* button collision */
        buttonCollision();

        //******************************************************************************
        /* Invincible time */
        if (mtm.getInvincibleTimer().isActive()) {
            msm.blink();
        }

        mobCollision();

        if (mtm.getPoisonedTimer().isActive() && !world.getSurface().getInventory().isOpen()) {
            //can't use hit, otherwise player could get invulnerable (rather good than bad for player)
            if (mtm.getPoisonedTimer().getTime() % 50 == 0) {
                if (life - 1 > 0) {
                    life--;
                }
            }
        }

        //check for double jump and count the types of UP
        if (world.canMove() && canAct) {
            keyboardManager.typedUpUpdate();
        }


        //move function:
        if (msm.isJumping()) {
            jump(); /* can jump -> push player in the air */
        }


        if (psm.isWalking()) {
            if (psm.isCrawling() || msm.isUnderWater() || msm.isSlowed()) moveX(dirX * speed / 2);
            else moveX(dirX * speed);
        }
        if (psm.isClimbing()) {
            moveY(-speed);
        }
        psm.setWalking(false);
        psm.setClimbing(false);
    }

    private void positionCorrection() {
        if (x % 2 != 0 && !msm.isUnderWater() && !psm.isCrawling()) {
            if (dirX == 1) moveX(1);
            else moveX(-1);
        }

    }

    /**
     * player gets damage if standing on spikes
     */
    public void damageBySpikes() {
        if (TileGetterList.getTile(x / 8, (y + 4) / 8, level).damage() > 0 && !mtm.getInvincibleTimer().isActive()) {
            hit(TileGetterList.getTile(x / 8, (y + 4) / 8, level).damage());
        }
    }

    /**
     * player collides with an enemy mob
     */
    public void mobCollision() {
        if (mtm.getInvincibleTimer().isActive()) {
            blinkManager();
        } else {
            for (int c = 0; c < 4; c++) {
                int xx = x + 1 + c % 2 * 6;
                int yy = y + c / 2 * 8;

                Mob m = null;
                if ((m = level.getEnemyAt(xx, yy)) != null && !m.getMSM().isDead()) { /* run into enemy mob */
                    hit(m.getCollisionDamage());
                    if (m instanceof PoisonSlime) {
                        poison();
                    }
                    return;
                }
            }
        }
        if (life <= 0) {
            world.setCutscene(new PlayerDeath_Cutscene(world, this));
            mtm.getPoisonedTimer().stop();
        }
    }

    /**
     * test if collides with a button
     *
     * @return
     */
    public void buttonCollision() {
        Button b = null;
        if ((b = level.getButtonAt(x + 4, y)) != null && b.getDir() == Button.Dir.TOP) { /* run into enemy mob */
            b.press();
        }
    }

    /**
     * add experience points and level up if possible
     *
     * @param exp
     */
    public void addExperience(int exp) {
        ptm.getGetTimer().start();
        if (experience + exp < next_experience) {
            experience += exp;
        } else {
            levelUp();
            int dif = experience + exp - next_experience;

            experience = 0;
            lvl++;

            addLogEntry("********** Level Up! **********", 0xff98DEAD);
            addLogEntry("Lebenspunkt erh\u00F6ht auf: " + max_life + "LP", 0xff98DEAD);
            addLogEntry("St\u00E4rke erh\u00F6ht auf: " + strength, 0xff98DEAD);

            next_experience = getNextExperience(lvl + 1);
            addExperience(dif);
        }
    }

    private void levelUp() {
        max_life *= 1.3;
        life = max_life;
        strength++;
    }

    /**
     * Regenerate Stamina if player doesnt work
     */
    public void regenerateStamina() {
        if (!psm.isWorking()) {
            if (Game.timer % 50 == 0) {
                if (stamina + 1 <= max_stamina) {
                    stamina++;
                }
            }
        }
    }

    /**
     * use a specific potion with individual effects
     *
     * @param potion
     */
    public void usePotion(Item potion) {
        if (potion instanceof HealthPotion) {
            new Spawner(x + 1, y - 1, 0, level, Spawner.ParticleType.HEALTH);
            if (life + 8 > max_life) {
                life = max_life;
            } else life += 8;
        }
        potion.useItem(1);
    }

    public void eatBerry(Item berry) {
        if (berry.getAmount() <= 0) return;
        if (berry instanceof Rolberry) {
            System.out.println(life + " " + max_life);
            if (life != max_life) {
                System.out.println("rolberry");
                new Spawner(x + 1, y - 1, 0, level, Spawner.ParticleType.HEALTH);
                addLife(4);
                berry.useItem(1);
                ptm.getPotionTimer().start();
            }

        } else if (berry instanceof Agroilberry) {
            if (stamina != max_stamina) {
                System.out.println("agroilberry");
                new Spawner(x + 1, y - 1, 0, level, Spawner.ParticleType.STAMINA);
                addStamina(10);
                berry.useItem(1);
                ptm.getPotionTimer().start();
            }

        }

    }

    /**
     * give player an item
     *
     * @param itemID
     * @param amount
     */
    public int addItem(int itemID, int amount) {
        //check if item is already in hands
        for (int j = 0; j < JK.length; j++) {
            if (JK[j] != null && JK[j].getID() == itemID) {
                JK[j].add(amount);
                return JK[j].getAmount();
            }
        }

        //ckeck if item is in small slots
        for (int j = 0; j < smallSlots.length; j++) {
            if (smallSlots[j] != null && smallSlots[j].getID() == itemID) {
                smallSlots[j].add(amount);
                return JK[j].getAmount();
            }
        }

        //otherwise add item to store
        return itemStoreManager.getItemStore().addItem(itemID, amount);
    }

    /**
     * give player a single item
     *
     * @param itemID
     * @param amount
     */
    public int addItem(int itemID) {
        return addItem(itemID, 1);
    }

    /**
     * add an Entry with color font
     *
     * @param s
     * @param color
     */
    public void addLogEntry(String entry, int fontColor) {
        ptm.getLogTimer().start();
        log.addEntry(new Entry(entry, fontColor));
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* Get and set methods */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setPlayerAnimated(AnimatedSprite as) {
        player_animated = as;
    }

    public void setJK(int t, Item i) {
        JK[t] = i;
    }

    public void setSmallSlots(int t, Item i) {
        smallSlots[t] = i;
    }

    public void setMaxStamina(int max_stamina) {
        this.max_stamina = max_stamina;
    }

    public void initWorld(World world) {
        this.world = world;
    }

    public void useRul(int s) {
        rul -= s;
    }

    public void useStamina(int s) {
        this.stamina -= s;
    }

    public void addRul(int add) {
        this.rul += add;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setCanAct(boolean canAct) {
        this.canAct = canAct;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void addLife(int l) {
        if (life + l > max_life) {
            life = max_life;
        } else {
            life += l;
        }
    }

    public void addStamina(int s) {
        if (stamina + s > max_stamina) {
            stamina = max_stamina;
        } else stamina += s;
    }

    public void setExperience(int exp) {
        this.experience = exp;
    }

    public void setRul(int rul) {
        this.rul = rul;
    }

    public int getLvl() {
        return lvl;
    }

    public int getNextExperience() {
        return next_experience;
    }

    public int getExperience() {
        return experience;
    }

    public Keyboard getInput() {
        return input;
    }

    public int getRul() {
        return rul;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return max_stamina;
    }

    public Log getLog() {
        return log;
    }

    public PlayerStatusManager getPSM() {
        return psm;
    }

    public PlayerTimerManager getPTM() {
        return ptm;
    }

    public Item[] getJK() {
        return JK;
    }

    public Item[] getSmallSlots() {
        return smallSlots;
    }

    public ItemStore getItemStore() {
        return itemStoreManager.getItemStore();
    }

    public AnimatedSprite getPlayerAnimated() {
        return player_animated;
    }

    public int getNextExperience(int lvl) {
        return 232 * lvl * lvl - 1087 * lvl + 1502;
    }

    public boolean getCanAct() {
        return canAct;
    }

    public int getStrength() {
        return strength;
    }
}