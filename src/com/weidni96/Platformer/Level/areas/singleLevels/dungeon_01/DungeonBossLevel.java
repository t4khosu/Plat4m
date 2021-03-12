package com.weidni96.Platformer.Level.areas.singleLevels.dungeon_01;

import java.util.ArrayList;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.Level.dungeons.Dungeon;
import com.weidni96.Platformer.entities.Button;
import com.weidni96.Platformer.entities.Button.Dir;
import com.weidni96.Platformer.entities.PoisonMachineBoss;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.enemies.slimes.BossSlime;
import com.weidni96.Platformer.entities.interactiveEntities.Lever;
import com.weidni96.Platformer.entities.interactiveEntities.Warp;
import com.weidni96.Platformer.entities.interactiveEntities.bookshelfes.Walker2_Bookshelf;
import com.weidni96.Platformer.entities.mob.Mob;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.cutscenes.ShakingCutscene;
import com.weidni96.Platformer.graphics.cutscenes.oneTimeScenes.OpenDungeon_1_Boss;

public class DungeonBossLevel extends LoadLevel{

	private boolean started = false;
	private Timer activeTimer = new Timer(10*60);
	private Timer laserTimer = new Timer(2*60);
	
	private ArrayList<Integer> redBoxes = new ArrayList<Integer>();
	private ArrayList<Integer> blueBoxes = new ArrayList<Integer>();
	private ArrayList<Integer> lasers = new ArrayList<Integer>();
		
	private Button red;
	private Button blue;
	
	private Lever leverRed;
	private Lever leverBlue;
	private Lever poisonMachineOFF;
	private boolean justSwitchedRedLever = false;
	private boolean justSwitchedBlueLever = false;
	private boolean switchedPoisonMachineOFF = false;
	private boolean setMachineOFF = false;
	
	private boolean bossJustDied = false;
	
	private Mob boss;
	
	private PoisonMachineBoss poisonMachine;
	
	/**
	 * Constructor
	 * @param player
	 * @param middleground
	 * @param background
	 * @param frontTiles
	 * @param backTiles
	 * @param type
	 * @param area
	 */
	public DungeonBossLevel(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null,  
				"/level/dungeon_01/dungeon_01_boss_front.png", 
				"/level/dungeon_01/dungeon_01_boss_back.png", 
				levelType.BOSSROOM, 
				area,
				areaPosX,
				areaPosY
		);
		
		initBoxes();
		initLasers();
		deleteBlueBoxes();
		deleteRedBoxes();
		
		this.red = new Button(36*8, 15*8, this, Dir.TOP, 0.05f, 1);
		this.blue = new Button(40*8, 15*8, this, Dir.TOP, 0.52f, 1);
		
		addButton(this.red);
		addButton(this.blue);
		
		this.poisonMachine = new PoisonMachineBoss(17*8, 38*8, this);
		this.boss = new BossSlime(37*8, 23*8, this);
		mobs.add(boss);
	}
	
	/**
	 * add all color boxes
	 */
	private void initBoxes(){
		for(int i = 0; i < frontTiles.length; i++){
			if(frontTiles[i] == 0xffE5444F){ //red box
				redBoxes.add(i);
			}else if(frontTiles[i] == 0xff487AE6){ //blue box
				blueBoxes.add(i);
			}
		}
	}
	
	private void startLasers(){
		for(int i : lasers){
			frontTiles[i] = 0xffB5F6FF;
			for(int j = i + tileWidth; j < tileWidth*tileHeight; j += tileWidth){	
				if(frontTiles[j] == 0xffFFFFFF){
					frontTiles[j] = 0xff93D9E2;
				}else{
					break;
				}
			}
		}
	}
	
	private void stopLasers(){
		for(int i : lasers){
			frontTiles[i] = 0xffCCF9FF;
			for(int j = i + tileWidth; j < tileWidth*tileHeight; j += tileWidth){	
				if(frontTiles[j] == 0xff93D9E2){
					frontTiles[j] = 0xffFFFFFF;
				}else{
					break;
				}
			}
		}
	}
	
	/**
	 * add all lasers to list
	 */
	private void initLasers(){
		for(int i = 0; i < frontTiles.length; i++){
			if(frontTiles[i] == 0xffCCF9FF){ 
				lasers.add(i);
			}
		}
	}
	
	/**
	 * add blue boxes 
	 */
	private void addBlueBoxes(){
		for(int i : blueBoxes){
			frontTiles[i] = 0xff487AE6;
		}
	}
	
	/**
	 * add red boxes
	 */
	private void addRedBoxes(){
		for(int i : redBoxes){
			frontTiles[i] = 0xffE5444F;
		}
	}
	
	/**
	 * delete blue boxes
	 */
	private void deleteBlueBoxes(){
		for(int i : blueBoxes){
			frontTiles[i] = 0xff487AE5;
		}
	}
	
	/**
	 * delete blue boxes
	 */
	private void deleteRedBoxes(){
		for(int i : redBoxes){
			frontTiles[i] = 0xffE5444E;
		}
	}

	@Override
	protected void initMobs() {
	}
	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
		leverRed = new Lever(7*8, 11*8, 0, false);
		interactiveEntities.add(leverRed);
		
		leverBlue = new Lever(68*8, 11*8, 0, false);
		interactiveEntities.add(leverBlue);
		
		poisonMachineOFF = new Lever(29*8, 45*8, 0, false);
		interactiveEntities.add(poisonMachineOFF);
		
		interactiveEntities.add(new Walker2_Bookshelf(32*8, 45*8, this)); 
	}

	@Override
	protected void individualUpdate() {	
		if(!started){
			player.setCanAct(false);
			if(player.bottomCollision()){
				started = true;
				area.getWorld().setCutscene(new OpenDungeon_1_Boss(area.getWorld(), 1, 2));
			}
		}
		
		this.poisonMachine.update();
		
		if(this.blue.isPressed() && !activeTimer.isActive()){
			this.blue.press();
			addBlueBoxes();
			activeTimer.start();
			area.getWorld().getSurface().showTimer(activeTimer);
		}
		if(this.red.isPressed() && !activeTimer.isActive()){
			this.red.press();
			addRedBoxes();
			activeTimer.start();
			area.getWorld().getSurface().showTimer(activeTimer);
		}
		
		if(activeTimer.isActive() && !area.getWorld().getSurface().getInventory().isOpen()){
			activeTimer.update();
			if(!activeTimer.isActive()){
				this.red.reset();
				this.blue.reset();
				deleteRedBoxes();
				deleteBlueBoxes();
			}
		}
		
		if(!justSwitchedRedLever && leverRed.isOn()){
			justSwitchedRedLever = true;
			laserTimer.start();
			startLasers();
			
			if(leverBlue.isOn()){
				justSwitchedBlueLever = false;
				leverBlue.superSwitchLever();
			}
			
		}
		
		if(!justSwitchedBlueLever && leverBlue.isOn()){
			justSwitchedBlueLever = true;
			laserTimer.start();
			startLasers();
			
			if(leverRed.isOn()){
				justSwitchedRedLever = false;
				leverRed.superSwitchLever();
			}
		}
		
		if(switchedPoisonMachineOFF && !setMachineOFF){
			setMachineOFF = true;
			poisonMachine.setOff();
		}
		
		if(!switchedPoisonMachineOFF && poisonMachineOFF.isOn()){
			switchedPoisonMachineOFF = true;
			addInteractiveEntity(new Warp(11*8,44*8, area.getWorld().getDungeon_01().getLevel(4), 12*8, 88*8));
			
			NPCManager.drHarun_neuleben.setActualDialog(NPCManager.drHarun_neuleben.getActualDialog()+1);
			NPCManager.mendra_hauntedForest.setActualDialog(2);
			NPCManager.ahb_neuleben.setActualDialog(7); //new quest for slimes
			NPCManager.ahb_neuleben.hasQuest();
			NPCManager.honja_neuleben.setActualDialog(2);
			NPCManager.honja_neuleben.hasQuest();
			
			area.getWorld().setCutscene(new ShakingCutscene(area.getWorld(), 1, 1, 200));
			
			Level poisonLevel = area.getWorld().getNeuleben().getLevels()[8];
			changeToShining(poisonLevel);
			
			poisonLevel = area.getWorld().getHauntedForest().getLevels()[6];
			changeToShining(poisonLevel);
			
			((Dungeon)area).finishDungeon();
		}
		
		//finish boss
		if(boss.getMSM().isDead() && !bossJustDied){
			bossJustDied = true;
			removeBlocks();
		}
		
		
		if(laserTimer.isActive()){
			laserTimer.update();
			
			if(!laserTimer.isActive()){
				stopLasers();
			}
		}
	}
	
	private void changeToShining(Level poisonLevel){
		if(poisonLevel != null){
			for(int i = 0; i < poisonLevel.getFrontTiles().length; i++){
				if(poisonLevel.getFrontTiles()[i] == 0xff8B6B99){
					poisonLevel.setTile(i, 0xff75FFFF);
				}
				else if(poisonLevel.getFrontTiles()[i] == 0xff210A0A){
					poisonLevel.setTile(i, 0xff050505);
				}
				else if(poisonLevel.getFrontTiles()[i] == 0xff7A4527){
					poisonLevel.setTile(i, 0xff6D2800);
				}
				else if(poisonLevel.getBackTiles()[i] == 0xff3F3027){
					poisonLevel.setBGTile(i, 0xff150000);
				}
			}
		}
	}
	
	private void removeBlocks(){
		for(int i = 26; i <= 32; i++){
			setTile(38, i, 0xfff);
			setTile(39, i, 0xfff);
		}
	}
	
	@Override
	public void individualRender(Screen screen){
		poisonMachine.render(screen);
	}
	
	@Override
	public void individualSaveFileLoad(String input) {
	}
	
	@Override
	public String individualSave() {
		return "";
	}
}