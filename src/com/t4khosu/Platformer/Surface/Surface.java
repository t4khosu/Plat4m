package com.t4khosu.Platformer.Surface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.t4khosu.Platformer.Game;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.input.Keyboard;
import com.t4khosu.Platformer.entities.InformationBar;
import com.t4khosu.Platformer.entities.Timer;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.entities.dialog.Dialogbox;
import com.t4khosu.Platformer.entities.dialog.MultiChoiceDialog;
import com.t4khosu.Platformer.entities.dialog.NPCDialogbox;
import com.t4khosu.Platformer.entities.log.Log;
import com.t4khosu.Platformer.entities.mob.Mob;
import com.t4khosu.Platformer.entities.player.Player;

public class Surface {
		
	private Dialogbox 		db;
	private InformationBar 	ib;
	private World world;
	private Log 			log;
	private Inventory 		inventory;
	
	private boolean showTimer = false;
	private Timer showingTimer;
	private int showTimerSecondsLeft = 0;
	
	//when a mob got hit, show mob, life and lvl of Mob
	private Mob activeMob;
	private Timer activeMobTimer;
	private boolean drawMobStatus = false;
	
	private boolean openTextBox = false;
	
	/**
	 * Constructor
	 * @param input
	 * @param world
	 */
	public Surface(Keyboard input, World world){
		this.world 		= world;
		this.log 		= world.getPlayer().getLog();
		this.ib 		= new InformationBar(world);
		this.inventory 	= new Inventory(world.getPlayer(), this);
		
		this.activeMobTimer = new Timer(5*60);
	}
	
	/**
	 * render slots, log, informationBar, inventory and dialogbox
	 * (just if needed)
	 * @param screen
	 */
	public void render(Screen screen){
		renderFrontSlots(screen);
		renderActualMobStatus(screen);
		log.render(screen);
		ib.render(screen);
		inventory.render(screen);
		if(db != null) db.render(screen);
		
		if(showTimer){
			screen.renderSprite(Game.width - Sprite.showStatusBar.getWidth() - 2, 15, Sprite.showStatusBar, false);
		}
	}
	
	/**
	 * render slot backgrounds and items inside
	 * @param screen
	 */
	private void renderFrontSlots(Screen screen){
		
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[0], 0, Sprite.handSlot, false);
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[1], 0, Sprite.handSlot, false);
		
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[2], 0, Sprite.extraSlot, false);
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[3], 0, Sprite.extraSlot, false);
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[4], 0, Sprite.extraSlot, false);
		
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[5], 0, Sprite.extraSlot, false);
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[6], 0, Sprite.extraSlot, false);
		screen.renderSprite(SurfaceCalculator.frontSlotBGs_x[7], 0, Sprite.extraSlot, false);
		
		if(inventory.getPlayer().getJK()[0] != null) screen.renderSprite(SurfaceCalculator.frontSlotsJK_x[0], 0, inventory.getPlayer().getJK()[0].getSprite(), false);
		if(inventory.getPlayer().getJK()[1] != null) screen.renderSprite(SurfaceCalculator.frontSlotsJK_x[1], 0, inventory.getPlayer().getJK()[1].getSprite(), false);
		
		if(inventory.getPlayer().getSmallSlots()[0] != null) inventory.getPlayer().getSmallSlots()[0].render(screen, SurfaceCalculator.smallSlots_x[0], 3);
		if(inventory.getPlayer().getSmallSlots()[1] != null) inventory.getPlayer().getSmallSlots()[1].render(screen, SurfaceCalculator.smallSlots_x[1], 3);
		if(inventory.getPlayer().getSmallSlots()[2] != null) inventory.getPlayer().getSmallSlots()[2].render(screen, SurfaceCalculator.smallSlots_x[2], 3);
		
		if(inventory.getPlayer().getSmallSlots()[3] != null) inventory.getPlayer().getSmallSlots()[3].render(screen, SurfaceCalculator.smallSlots_x[3], 3);
		if(inventory.getPlayer().getSmallSlots()[4] != null) inventory.getPlayer().getSmallSlots()[4].render(screen, SurfaceCalculator.smallSlots_x[4], 3);
		if(inventory.getPlayer().getSmallSlots()[5] != null) inventory.getPlayer().getSmallSlots()[5].render(screen, SurfaceCalculator.smallSlots_x[5], 3);
	}
	
	public void renderActualMobStatus(Screen screen){
		if(!drawMobStatus) return;
		screen.renderSprite(SurfaceCalculator.mobStatus_x[0], SurfaceCalculator.mobStatus_y[0], Sprite.mobStatus, false);
		screen.renderBar(SurfaceCalculator.mobStatus_x[0] + 2, SurfaceCalculator.mobStatus_y[0] + 8, activeMob.getLife(), activeMob.getMaxLife(), Sprite.mobStatus.getWidth()-4, 0xff00ff00, false);
	}
	
	public void renderActualMobStatus(Graphics g){
		if(!drawMobStatus) return;
		String name = activeMob.getName();
		String lvl = "lvl " + activeMob.getLvl();
		
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 12)); 
		if(activeMob.getLvl() > world.getPlayer().getLvl()){
			g.setColor(new Color(0xffE06266));
		}else{
			g.setColor(new Color(0xffA7C657));
		}
		
		
		g.drawString(name + ", " + lvl,  SurfaceCalculator.mobStatus_x[1], SurfaceCalculator.mobStatus_y[1]);
	}
	
	/**
	 * render graphics
	 * @param g
	 */
	public void render(Graphics g){
		renderActualMobStatus(g);
		
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 14)); 
		g.setColor(Color.white);
		g.drawString("J",  SurfaceCalculator.graphics_x[0], 13);
		g.drawString("K",  SurfaceCalculator.graphics_x[1], 13);
		
		g.setFont(new Font("Arial Hebrew", Font.BOLD, 11)); 
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("1",  SurfaceCalculator.graphics_x[2], 11);
		g.drawString("2",  SurfaceCalculator.graphics_x[3], 11);
		g.drawString("3",  SurfaceCalculator.graphics_x[4], 11);
		
		g.drawString("4",  SurfaceCalculator.graphics_x[5], 11);
		g.drawString("5",  SurfaceCalculator.graphics_x[6], 11);
		g.drawString("6",  SurfaceCalculator.graphics_x[7], 11);
		
		ib.render(g);
		log.render(g);
		if(db != null) db.render(g);
		
		if(showTimer){
			g.setFont(new Font("Arial Hebrew", Font.BOLD, 35)); 
			g.setColor(Color.LIGHT_GRAY);
			g.drawString(""+showTimerSecondsLeft,  SurfaceCalculator.showTimer_x, SurfaceCalculator.showTimer_y);
		}
	}
	
	/**
	 * update inventory and dialogBox
	 */
	public void update(){
		for(Mob m : world.getActualArea().getActualLevel().mobs){
			if(m.getMTM().getInvincibleTimer().isActive()){
				this.activeMob = m;
				this.activeMobTimer.start();
				break;
			}
		}
		
		if(inventory.isOpen()){
			inventory.update();
			db = inventory.getDb();
		}
		
		if(db != null){
			db.update();
			if(db.isRemoved()){
				db = null;
				openTextBox = false;
			}
		}
		
		if(activeMobTimer.isActive()  && !activeMob.getMSM().isDead() && !inventory.isOpen() && db == null && 
				activeMob.getLevel() == world.getActualArea().getActualLevel()){
			this.drawMobStatus = true;
			activeMobTimer.update();
		}else{
			if(activeMob != null && activeMob.getLevel() != world.getActualArea().getActualLevel()){
				this.activeMob = null;
				activeMobTimer.stop();
			}
			
			this.drawMobStatus = false;
		}
		
		if(showTimer){
			if(!showingTimer.isActive()){
				showTimer = false;
			}else{
				showTimerSecondsLeft = (showingTimer.getMaxTime()/60) - (showingTimer.getTime()/60);
			}
			
		}
	}
	
	/**
	 * try starting a new dialog with a NPC	
	 * @param player
	 * @param npc
	 * @param autoTalk
	 */
	public void startDialog(Player player, NPC npc, boolean autoTalk){
		if(npc.getDirX() == player.getDirX()) npc.changeDirection(); // turn to player
			
		Choices choices = null;
		Dialogbox ndb;
		if((choices = npc.dialogHasChoice()) != null){
			ndb = new MultiChoiceDialog(player, player.getInput(), null, npc, choices.getChoices());
		}else{
			ndb = new NPCDialogbox(player, null, npc, autoTalk);
		}
		setDB(ndb);
	}
	
	/**
	 * open inventory if possible
	 */
	public void openInventory(){
		if(!inventory.isOpen() && !openTextBox){
			inventory.open();
		}else{
			inventory.close();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Inventory getInventory(){
		return inventory;
	}
	public Log getLog(){
		return log;
	}
	public boolean openTextBox(){
		return openTextBox;
	}
	
	public void setDB(Dialogbox db){
		openTextBox = true;
		this.db = db;
	}
	public void removeDB(){
		openTextBox = false;
		this.db = null;
	}
	public void showTimer(Timer t){
		showTimer = true;
		this.showingTimer = t;
	}
}