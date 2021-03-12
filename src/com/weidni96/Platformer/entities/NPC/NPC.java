package com.weidni96.Platformer.entities.NPC;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.tile.TileGetterList;
import com.weidni96.Platformer.Level.tile.TopHardTile;
import com.weidni96.Platformer.Surface.Surface;
import com.weidni96.Platformer.entities.dialog.Message;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.entities.item.mainItems.extras.Money;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.entities.player.Player;
import com.weidni96.Platformer.graphics.AnimatedSprite;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;
import com.weidni96.Platformer.graphics.SpriteSheet;

import java.util.ArrayList;
import java.util.Random;

public class NPC extends Mob {

    //all dialoges, single choices and actual dialog
    protected ArrayList<String[]> dialogs = new ArrayList<String[]>();
    protected ArrayList<Choices> choices = new ArrayList<Choices>();
    protected int actualDialog;

    //for specific design
    protected AnimatedSprite npc_right;
    protected AnimatedSprite npc_left;
    protected AnimatedSprite hair_right;
    protected AnimatedSprite hair_left;

    protected Sprite npcRight;
    protected Sprite npcLeft;

    protected Sprite hairRight;
    protected Sprite hairLeft;
    protected AnimatedSprite animated_npc;
    protected AnimatedSprite animated_hair;

    protected Sprite hairSprite;

    protected Random random;
    protected Surface surface;

    protected String[] dialog;
    protected boolean walker;
    protected boolean talking;

    //for npcs that give quests
    protected boolean havingQuest = false;
    protected boolean activeQuest = false;

    protected int basis = 0; /* time npc moves at least when moving */
    protected int actionChange; /* random parameter added to "basis" when moving */
    protected int moveTimer = 0;
    protected int randMove = 0;

    protected String name;

    //stati
    protected boolean walking = false;

    protected Player player;

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
    public NPC(int x, int y, Sprite sprite, Level level, boolean walker, String name, int actionChange, int basis) {
        super(x, y, Sprite.npc_right_0, level);

        this.walker = walker;
        this.random = new Random();
        this.actionChange = actionChange;
        this.randMove = basis + this.random.nextInt(actionChange);
        this.moveTimer = 0;
        this.basis = basis;
        this.name = name;

        npc_right = new AnimatedSprite(8, SpriteSheet.npc_right_sheet, 4, 10, false);
        npc_left = new AnimatedSprite(8, SpriteSheet.npc_left_sheet, 4, 10, false);
        npcRight = Sprite.npc_right_0;
        npcLeft = Sprite.npc_left_0;

        speed = 1;

        //start direction
        if (random.nextInt(2) == 0) dirX = 1;
        else dirX = -1;

        generateDialogs();
    }

    /**
     * move into one direction, update animations
     *
     * @param steps
     */
    public void move(int steps) { //nx steps
        if (steps < 0) dirX = -1;
        else dirX = 1;
        for (int i = 0; i < Math.abs(steps); i++) {
            if (!sideCollision(dirX)) {
                animated_npc.update();
                sprite = animated_npc.getSprite();
                if (animated_hair != null) {
                    animated_hair.setFrame(animated_npc.getFrame());
                    hairSprite = animated_hair.getSprite();
                }

                x += dirX;
            } else {
                moveTimer = 0;
                walking = false;
            }
        }
    }

    /**
     * dialogs of a simple npc
     * chosen randomly when talked to
     */
    public void generateDialogs() {
        actualDialog = 0;

        String[] a = {"#Hey."};
        dialogs.add(a);

        String[] b = {"#Kennt man sich?"};
        dialogs.add(b);

        String[] c = {"#Hi, wie geht's?"};
        dialogs.add(c);

        String[] d = {"#Die Arbeit hier ist so verdammt schwer..."};
        dialogs.add(d);

        String[] e = {"#Ich hasse Montage..."};
        dialogs.add(e);

        String[] f = {"#Sind wir und schon mal \u00FCber den Weg gelaufen?"};
        dialogs.add(f);
    }

    /**
     * receive matching choice-set to specific dialog
     *
     * @return Choice
     */
    public Choices dialogHasChoice() {
        for (Choices c : choices) {
            if (actualDialog == c.getID()) {
                return c;
            }
        }
        return null;
    }

    /**
     * whole actions of a simple npc
     */
    public void update() {
        if (!talking) {
            if (timer < randMove) {
                timer++;
            } else {
                timer = 0;
                if (basis != 0) {
                    if (random.nextInt(2) == 0) {
                        dirX *= -1;
                    }
                    if (walker) {
                        if (dirX > 0) {
                            animated_npc = npc_right;
                            if (hair_right != null) animated_hair = hair_right;
                        } else {
                            animated_npc = npc_left;
                            if (hair_left != null) animated_hair = hair_left;
                        }
                        moveTimer = (basis + random.nextInt(actionChange)) / 4;
                        walking = true;
                    }
                }
            }
        }

        if (moveTimer > 0) {
            moveTimer--;
        } else walking = false;

        if (walking) {
            if (canWalk()) {
                move(dirX);
            } else {
                moveTimer = 0;
                walking = false;
            }

        } else {
            if (dirX > 0) {
                sprite = npcRight;
                if (hairRight != null) hairSprite = hairRight;
            } else {
                sprite = npcLeft;
                if (hairLeft != null) hairSprite = hairLeft;
            }
        }
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderSprite(x, y, sprite, true);

        if (hairSprite != null) {
            screen.renderSprite(x, y, hairSprite, true);
        }
    }

    /**
     * render a quest symbol if npc has quest/there is an active quest
     *
     * @param screen
     */
    public void questRender(Screen screen) {
        if (havingQuest) {
            screen.renderSprite(x + width / 2, y - height, Sprite.haveQuest_sprite, true);
        } else if (activeQuest) {
            screen.renderSprite(x + width / 2, y - height, Sprite.activeQuest_sprite, true);
        }
    }

    /**
     * if there is no collision where npc wants to go to, return true
     *
     * @return result
     */
    public boolean canWalk() {
        int x0 = (x - 2) / 8;
        if (dirX > 0) x0 = (x + width + 2) / 8;
        int y0 = (y + height) / 8;
        if (TileGetterList.getTile(x0, y0, level).isSolid() || TileGetterList.getTile(x0, y0, level) instanceof TopHardTile) {
            return true;
        }
        return false;
    }

    /**
     * start random dialog
     */
    public void talk() {
        actualDialog = random.nextInt(dialogs.size());
        talking = true;
    }

    /**
     * stop dialog
     */
    public void stopTalking() {
        talking = false;
    }

    public int type() {
        return 1;
    }

    /**
     * test if palyer holds item
     */
    public Item playerHoldsItem(int id, int amount) {
        for (Item i : player.getJK()) {
            if (i != null && i.getID() == id && i.getAmount() >= amount) {
                return i;
            }
        }
        return null;
    }

    public void givePlayerItem(Item i, int amount) {
        if (i instanceof Money) {
            player.addRul(amount);
        } else {
            player.getItemStore().addItem(i.getID(), amount);
        }
        world.getSurface().setDB(new Message(player, i, amount));
    }

    public void loadData(String[] input) {
        int dialog = Integer.parseInt(input[1]);
        setActualDialog(dialog);

        finishQuest();
        if (input[2].equals("aQ")) startQuest();
        else if (input[2].equals("hQ")) hasQuest();
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* Get and set methods */
    public void hasQuest() {
        havingQuest = true;
    }

    public void startQuest() {
        havingQuest = false;
        activeQuest = true;
    }

    public void finishQuest() {
        activeQuest = false;
        havingQuest = false;
    }

    public void initSurface(Surface surface) {
        this.surface = surface;
    }

    public void setActualDialog(int i) {
        this.actualDialog = i;
    }

    public void changeDirection() {
        dirX *= -1;
    }

    public void setDir(int dir) {
        dirX = dir;
    }

    public NPC initLevelAndReturn(Level level) {
        initLevel(level);
        this.player = level.getPlayer();
        return this;
    }

    public String getName() {
        return name;
    }

    public int getActualDialog() {
        return actualDialog;
    }

    public boolean getHasQuest() {
        return havingQuest;
    }

    public boolean getActiveQuest() {
        return activeQuest;
    }

    public boolean isWalking() {
        return walking;
    }

    public String[] getDialog(int i) {
        return dialogs.get(i);
    }
}