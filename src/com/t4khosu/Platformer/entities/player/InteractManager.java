/**
 * Save and work with stuff that is close to player,
 * when player tries to interact (presses space)
 */

package com.t4khosu.Platformer.entities.player;

import java.util.ArrayList;
import java.util.List;

import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.NPC.Trader;
import com.t4khosu.Platformer.entities.dialog.BookShelfMessage;
import com.t4khosu.Platformer.entities.dialog.Message;
import com.t4khosu.Platformer.entities.dialog.SavePointMessage;
import com.t4khosu.Platformer.entities.item.Item;
import com.t4khosu.Platformer.entities.item.mainItems.extras.Money;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.entities.interactiveEntities.Anvil;
import com.t4khosu.Platformer.entities.interactiveEntities.Bookshelf;
import com.t4khosu.Platformer.entities.interactiveEntities.Chest;
import com.t4khosu.Platformer.entities.interactiveEntities.Fire;
import com.t4khosu.Platformer.entities.interactiveEntities.InteractiveEntity;
import com.t4khosu.Platformer.entities.interactiveEntities.Lever;
import com.t4khosu.Platformer.entities.interactiveEntities.Loot;
import com.t4khosu.Platformer.entities.interactiveEntities.SavePoint;
import com.t4khosu.Platformer.entities.interactiveEntities.Sign;
import com.t4khosu.Platformer.entities.interactiveEntities.Warp;

public class InteractManager {
	
	private List<InteractiveEntity> interactiveEntities = new ArrayList<InteractiveEntity>();
	private Chest chest 	= null;
	private Lever lever     = null;
	private Sign sign		= null;
	private Loot loot		= null;
	private Warp  warp		= null;
	private SavePoint savePoint = null;
	private Bookshelf bookShelf = null;
	private Anvil anvil = null;
	private Fire fire = null;
	
	private NPC npc		= null;
	private Player player;
	private World world;
	
	/**
	 * constructor
	 * @param player
	 */
	public InteractManager(Player player){
		this.player = player;
		this.world = player.getWorld();
	}
	
	/**
	 * find and interact with entities that are close
	 */
	public void tryToInteract(){
		resetInteractiveStuff();
		findInteractiveStuff();
		findCloseNPC();
		
		//Priority 1: chests
		if(chest != null && !chest.isOpen() && !world.getSurface().openTextBox() ){
			if(chest.getOpenPermission()){
				chest.open();
				world.getSurface().setDB(new Message(player, Item.getItem(chest.getItemID()), chest.getAmount()));
			}else{
				world.getSurface().setDB(new Message(player, Sprite.big_noAccess, "Warte!", "Die Kiste geh\u00F6rt dir nicht!"));
			}
		}
		
		//Priority 2: NPCs
		else if(npc != null && !npc.isWalking() && !world.getSurface().openTextBox()){
			if(npc instanceof Trader){
				player.getPSM().setTrading(true);
				npc.initSurface(world.getSurface());
			}
			world.getSurface().startDialog(player, npc, false);
		}
		
		//Priority 3: signs
		else if(sign != null && !world.getSurface().openTextBox()){
			world.getSurface().setDB(new Message(player, sign));
		}
		
		//Priority 4: switch lever
		else if(lever != null && !world.getSurface().openTextBox()){
            lever.switchLever();
        }
		
		//Priority 5: loot
		else if(loot != null && !world.getSurface().openTextBox()){
			loot.remove();
			Item i = Item.getItem(loot.getItemID());
			
			if(i instanceof Money) player.addRul(loot.getAmount());
			else player.addItem(loot.getItemID(), loot.getAmount());
			
			player.addLogEntry(i.getName() + " (+" + loot.getAmount() + ")", 0xFFffffff);
		}
		
		//Priority 6: warp
		else if(warp != null && !world.getSurface().openTextBox()){
			warp.warp();
		}
		
		
		else if(savePoint != null && !world.getSurface().openTextBox()){
			world.getSurface().setDB(new SavePointMessage(player, savePoint));
			savePoint.getSaveManager().saveAllData();
		}
		
		
		else if(bookShelf != null && !world.getSurface().openTextBox()){
			world.getSurface().setDB(new BookShelfMessage(player, bookShelf));
		}
		
		else if(fire != null && !world.getSurface().openTextBox()){
			//player.getPSM().setMelting(true);
			world.getSurface().getInventory().openWithFire(fire);
		}
		
		else if(anvil != null && !world.getSurface().openTextBox()){
			world.getSurface().getInventory().openWithAnvil(anvil);
		}
	}
	
	/**
	 * reset all interactive entities before searching for them
	 * otherwise old ones won't be deleted
	 */
	public void resetInteractiveStuff(){
		chest = null;
		lever = null;
		sign = null; 
		loot = null;
		npc = null;
		warp = null;
		savePoint = null;
		bookShelf = null;
		anvil = null;
		fire = null;
	}
	
	/**
	/* Find all interactive Entities and NPCs close to Player 
	 */
	private void findInteractiveStuff(){
		interactiveEntities = player.getLevel().getInteractiveEntities(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2);
		for(InteractiveEntity i : interactiveEntities){
			if(i instanceof Chest) 		chest = (Chest)i;
			else if(i instanceof Lever) lever = (Lever)i;
			else if(i instanceof Sign) 	sign  = (Sign)i;
			else if(i instanceof Loot)  loot  = (Loot)i;
			else if(i instanceof Warp)	warp  = (Warp)i;
			else if(i instanceof SavePoint) savePoint = (SavePoint)i;
			else if(i instanceof Bookshelf) bookShelf = (Bookshelf)i;
			else if(i instanceof Anvil) anvil = (Anvil)i;
			else if(i instanceof Fire) fire = (Fire)i;
		}
	}
	
	private void findCloseNPC(){
		for(int i = 0; i < 6; i++){
			int x0 = player.getX() + player.getWidth()/2; /* middle of player */
			NPC npc = null;
			if ((npc = player.getLevel().getNPCAt(x0 + i * player.getDirX(), player.getY())) != null){	
				this.npc = npc;
				break;
			}else this.npc = null;
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public NPC getNPC(){
		return npc;
	}
}
