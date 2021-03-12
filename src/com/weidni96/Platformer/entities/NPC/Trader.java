package com.weidni96.Platformer.entities.NPC;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.ItemStore;
import com.weidni96.Platformer.entities.ItemStore.StoreType;
import com.weidni96.Platformer.entities.item.Item;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Trader extends NPC {

    private ItemStore itemStore; /* Trader has own Store */
    protected boolean buysItems;

    /**
     * constructor, with all items
     *
     * @param x
     * @param y
     * @param sprite
     * @param level
     * @param walker
     * @param name
     * @param actionChange
     * @param basis
     * @param items
     */
    public Trader(int x, int y, Level level, String name) {
        super(x, y, Sprite.npc_right_0, level, false, name, 50, 200);

        int storeWidth = 2;
        int storeHeight = 4;

        this.itemStore = new ItemStore(storeWidth, storeHeight, StoreType.TRADESTORE, 1);
        this.buysItems = true;
    }

    /**
     * fill store of trader with items
     *
     * @param items
     */
    public void fillStore(Item[] items) {
        for (Item i : items) {
            if (i != null) itemStore.addItem(i.getID(), i.getAmount());
        }
    }

    /**
     * Standard dialog for traders
     */
    public void generateDialogs() {
        actualDialog = 0;
        String[] a = {"#Willkommen in meinem Shop.",
                "#Such dir aus was dir gef\u00E4llt! Sofern du das n\u00F6tige Kleingeld hast."};
        dialogs.add(a);

    }

    /**
     * trader is talking
     */
    public void talk() {
        talking = true;
    }

    /**
     * finish talking -> open itemstore
     */
    public void stopTalking() {
        talking = false;
        openInventory();
    }

    /**
     * open inventory of trader
     */
    public void openInventory() {
        itemStore.initInventory(surface.getInventory());
        surface.getInventory().openWithTraderItemStore(this);
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.96f, 0.6f);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* Get and set methods */
    public ItemStore getItemStore() {
        return itemStore;
    }

    public boolean buysItems() {
        return buysItems;
    }

    public void setBuysItems(boolean buysItems) {
        this.buysItems = buysItems;
    }
}
