package com.t4khosu.Platformer.Level.dungeons;

import java.util.ArrayList;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.graphics.cutscenes.ButtonPress_Cutscene;
import com.t4khosu.Platformer.graphics.cutscenes.oneTimeScenes.Dungeon_1_Waterfall;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_0_0;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_0_1;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_1_0;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_1_1;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_2_0;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_2_1;
import com.t4khosu.Platformer.Level.areas.singleLevels.dungeon_01.Dungeon_01_3_1;
import com.t4khosu.Platformer.entities.Button;
import com.t4khosu.Platformer.entities.Button.Dir;
import com.t4khosu.Platformer.entities.pMachineDungeon_1;

/**
 * The first dungeon a player can find, the
 * "Poison Factory"
 * @author Christian
 *
 */
public class Dungeon_01 extends Dungeon{
	
	private boolean colorDoor = false;
	private Button red;
	private Button blue;
	private Button blue2;
	
	private Button pYellow;
	private Button pGreen;
	private Button pBlue;
	private Button pRed;
	
	private boolean buttonCreatedRed = false;
	
	private boolean pBluePressed = false;
	private boolean pGreenPressed = false;
	private boolean pYellowPressed = false;
	private boolean pRedPressed = false;
	
	private ArrayList<Integer> redBoxes = new ArrayList<Integer>();
	private ArrayList<Integer> blueBoxes = new ArrayList<Integer>();
	
	/**
	 * Constructor
	 * @param player
	 * @param world
	 */
	public Dungeon_01(World world, int worldPosX, int worldPosY) {
		super(world, worldPosX, worldPosY);
		this.name = "Poison Factory";
		this.width = 4;
		this.height = 2;
		
		this.background = null;
		this.areaSprite = Sprite.areaSign_poisonFactory;
		
		this.levels = new Level[width * height];
		initLevels();
		
		this.red = new Button(54*8, 56*8, levels[6], Dir.TOP, 0.00f, 1);
		levels[6].addButton(red);
		
		this.blue = new Button(67*8, 3*8, levels[6], Dir.TOP, 0.6f, 1);
		this.blue.press();
		this.blue2 = new Button(42*8, 24*8, levels[7], Dir.TOP, 0.6f, 1);
		this.blue2.press();
		
		//TODO Farbanpassung
		this.pYellow 	= new Button(28*8, 56*8, levels[7], Dir.TOP, 0.15f, 1);
		this.pGreen  	= new Button(56*8, 80*8, levels[2], Dir.TOP, 0.3f, 1);
		this.pBlue  	= new Button(65*8, 24*8, levels[6], Dir.TOP, 0.52f, 1);
		this.pRed  		= new Button(42*8, 61*8, levels[0], Dir.TOP, 0.05f, 1);
		
		levels[6].addButton(blue);
		levels[7].addButton(blue2);
		
		levels[7].addButton(pYellow);
		levels[4].addButton(pBlue);
		levels[2].addButton(pGreen);
		
		initBoxes();
		addBlueBoxes();
	}
	
	/**
	 * add all color boxes to lvl 7
	 */
	private void initBoxes(){
		for(int i = 0; i < levels[7].frontTiles.length; i++){
			if(levels[7].frontTiles[i] == 0xffE5444F){ //red box
				redBoxes.add(i);
			}else if(levels[7].frontTiles[i] == 0xff487AE6){ //blue box
				blueBoxes.add(i);
			}
		}
	}
	
	/**
	 * add blue boxes to lvl 7
	 */
	private void addBlueBoxes(){
		for(int i : blueBoxes){
			levels[7].frontTiles[i] = 0xff487AE6;
		}
		for(int i : redBoxes){
			levels[7].frontTiles[i] = 0xffE5444E;
		}
	}
	
	/**
	 * add red boxes to lvl 7
	 */
	private void addRedBoxes(){
		for(int i : blueBoxes){
			levels[7].frontTiles[i] = 0xff487AE5;
		}
		for(int i : redBoxes){
			levels[7].frontTiles[i] = 0xffE5444F;
		}
	}
	
	@Override
	protected void individualUpdate(){
		if(colorDoor && (blue.isPressed() || blue2.isPressed()) && red.isPressed()){// is red and both pressed
			colorDoor = false; // turn blue
			addBlueBoxes();
			red.reset();
			
			//make sure same color are all pressed
			blue.press();
			blue2.press();
		}
		if(!colorDoor && (blue.isPressed() || blue2.isPressed()) && red.isPressed()){ // is blue and both pressed
			colorDoor = true; //turn red
			addRedBoxes();
			blue.reset();
			blue2.reset();
		}
		
		pMachineDungeon_1 m = ((Dungeon_01_1_1)levels[5]).getMachine();
		if(pBlue.isPressed() && !pBluePressed){
			pBluePressed = true;
			m.activateBlue();
			
			if(pYellow.isPressed() && pGreen.isPressed() && pRed.isPressed() && pBlue.isPressed()){
				getWorld().setCutscene(new Dungeon_1_Waterfall(getWorld(), 0, 2));
			}else{
				getWorld().setCutscene(new ButtonPress_Cutscene(getWorld(), 1, 1));
			}
			
		}
		if(pYellow.isPressed() && !pYellowPressed){
			pYellowPressed = true;
			m.activateYellow();

			if(pYellow.isPressed() && pGreen.isPressed() && pRed.isPressed() && pBlue.isPressed()){
				getWorld().setCutscene(new Dungeon_1_Waterfall(getWorld(), 0, 2));
			}else{
				getWorld().setCutscene(new ButtonPress_Cutscene(getWorld(), 1, 1));
			}
			
		}
		if(pGreen.isPressed() && !pGreenPressed){
			pGreenPressed = true;
			m.activateGreen();

			if(pYellow.isPressed() && pGreen.isPressed() && pRed.isPressed() && pBlue.isPressed()){
				getWorld().setCutscene(new Dungeon_1_Waterfall(getWorld(), 0, 2));
			}else{
				getWorld().setCutscene(new ButtonPress_Cutscene(getWorld(), 1, 1));
			}
		}
		if(pRed.isPressed() && !pRedPressed){
			pRedPressed = true;
			m.activateRed();

			if(pYellow.isPressed() && pGreen.isPressed() && pRed.isPressed() && pBlue.isPressed()){
				getWorld().setCutscene(new Dungeon_1_Waterfall(getWorld(), 0, 2));
			}else{
				getWorld().setCutscene(new ButtonPress_Cutscene(getWorld(), 1, 1));
			}
		}
		
		if(!buttonCreatedRed && levels[0].mobs.size() == 0){
			buttonCreatedRed = true;
			levels[0].addButton(pRed);
		}
	}
	
	@Override
	protected void initLevels(){
		/*
		 * [0.0] | [1.0] | [2.0] |  3.0 
		 * -----------------------------
		 * [0.1] | [1.1] | [2.1] | [3.1]  
		 */
		
		levels[0 + width * 0] = new Dungeon_01_0_0(this, 0, 0);
		levels[1 + width * 0] = new Dungeon_01_1_0(this, 1, 0);
		levels[2 + width * 0] = new Dungeon_01_2_0(this, 2, 0);
		levels[0 + width * 1] = new Dungeon_01_0_1(this, 0, 1);
		levels[1 + width * 1] = new Dungeon_01_1_1(this, 1, 1);
		levels[2 + width * 1] = new Dungeon_01_2_1(this, 2, 1);
		levels[3 + width * 1] = new Dungeon_01_3_1(this, 3, 1);
	}
}