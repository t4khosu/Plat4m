/**
 * class to manage an itemStore.
 * adds Items to store.
 */

package com.weidni96.Platformer.entities.player;

import com.weidni96.Platformer.entities.ItemStore;
import com.weidni96.Platformer.entities.ItemStore.StoreType;

public class ItemStoreManager {

    public ItemStore itemStore;

    /**
     * creates new itemStore with predefined items
     *
     * @param width
     * @param height
     * @param storeType
     * @param amount
     */
    public ItemStoreManager(int width, int height, StoreType storeType, int amount) {
        this.itemStore = new ItemStore(width, height, storeType, amount);
		
		/*itemStore.addItem(new WoodenFishingPole(),  1);
		itemStore.addItem(new WoodenPickaxe(), 1);
		itemStore.addItem(new WoodenSword(),  1);
		itemStore.addItem(new WoodenShovel(),  1);
		itemStore.addItem(new Boots(),  1);
		itemStore.addItem(new Corjack(),  3);
		itemStore.addItem(new Agroilberry(),  30);
		itemStore.addItem(new Rolberry(),  30);*/
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* Get and set methods */
    public ItemStore getItemStore() {
        return itemStore;
    }
}
