package com.weidni96.Platformer.graphics;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.Level.tile.Tile;

public class AnimatedSprite extends Sprite{
	
	public int frame 	= 0;
	private int length 	= -1;
	private int rate 	= 10;
	private int adder 	= 1;
	private int timer 	= -1;
	
	private static int playerSwingTime = 7;
	
	private SpriteSheet sheet;
	private boolean loop = false;
	private boolean atTheEnd = false;
	private Sprite sprite;
	
	private boolean playOnce = false;
	
	//create new with parameters: size, spritesheet, number of sprites, time (lower is faster), repeat mode
	//repeat mode, true: 1 2 3 2 1 2 3 ... false: 1 2 3 1 2 3 1 2 3 ... (number = sprite in spritesheet)
	
	//Player Animated Sprites:
	public static AnimatedSprite player_right 			= new AnimatedSprite(8, SpriteSheet.player_right_sheet, 4, 10, false);
	public static AnimatedSprite player_left  			= new AnimatedSprite(8, SpriteSheet.player_left_sheet,  4, 10, false);
	public static AnimatedSprite player_climb 			= new AnimatedSprite(8, SpriteSheet.player_climb_sheet, 2, 15, false);
	public static AnimatedSprite player_crawl_left 		= new AnimatedSprite(8, SpriteSheet.player_crawl_left_sheet, 3, 10, true);
	public static AnimatedSprite player_crawl_right 	= new AnimatedSprite(8, SpriteSheet.player_crawl_right_sheet, 3, 10, true);
	public static AnimatedSprite player_plow_left 		= new AnimatedSprite(8, SpriteSheet.player_plow_left_sheet, 2, 30, true);
	public static AnimatedSprite player_plow_right 		= new AnimatedSprite(8, SpriteSheet.player_plow_right_sheet, 2, 30, true);
	public static AnimatedSprite player_catch_left 		= new AnimatedSprite(8, SpriteSheet.player_catch_left_sheet, 2, 30, true);
	public static AnimatedSprite player_catch_right 	= new AnimatedSprite(8, SpriteSheet.player_catch_right_sheet, 2, 30, true);
	public static AnimatedSprite player_hit_right 		= new AnimatedSprite(8, SpriteSheet.player_hit_right_sheet, 3, playerSwingTime, false);
	public static AnimatedSprite player_hit_left 		= new AnimatedSprite(8, SpriteSheet.player_hit_left_sheet, 3, playerSwingTime, false);
	public static AnimatedSprite player_stand_right 	= new AnimatedSprite(8, SpriteSheet.player_stand_right_sheet, 2, 30, false);
	public static AnimatedSprite player_stand_left	 	= new AnimatedSprite(8, SpriteSheet.player_stand_left_sheet, 2, 30, false);
	public static AnimatedSprite player_breakStone_right 	= new AnimatedSprite(8, SpriteSheet.player_breakStone_right_sheet, 2, 30, false);
	public static AnimatedSprite player_breakStone_left 	= new AnimatedSprite(8, SpriteSheet.player_breakStone_left_sheet, 2, 30, false);
	
	//Sword Animated Sprites:
	public static AnimatedSprite wooden_sword1_right 	= new AnimatedSprite(8, SpriteSheet.wooden_sword1_right_sheet,  3, playerSwingTime, false);
	public static AnimatedSprite wooden_sword1_left 	= new AnimatedSprite(8, SpriteSheet.wooden_sword1_left_sheet, 3, playerSwingTime, false);
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* global sprites that need static update in this class */
	
	//Plants Animated Sprites:
	public static AnimatedSprite plant11 = new AnimatedSprite(8, SpriteSheet.plant1_sheet, 2, 80, false);
	public static AnimatedSprite plant12 = new AnimatedSprite(8, SpriteSheet.plant2_sheet, 2, 80, false);
	public static AnimatedSprite plant13 = new AnimatedSprite(8, SpriteSheet.plant3_sheet, 2, 80, false);
	public static AnimatedSprite plant14 = new AnimatedSprite(8, SpriteSheet.plant4_sheet, 2, 80, false);
	
	public static AnimatedSprite plant21 = new AnimatedSprite(8, SpriteSheet.plant21_sheet, 2, 80, false);
	public static AnimatedSprite plant22 = new AnimatedSprite(8, SpriteSheet.plant22_sheet, 2, 80, false);
	public static AnimatedSprite plant23 = new AnimatedSprite(8, SpriteSheet.plant23_sheet, 2, 80, false);
	public static AnimatedSprite plant24 = new AnimatedSprite(8, SpriteSheet.plant24_sheet, 2, 80, false);
	
	//Rest Animated Sprites:
	public static AnimatedSprite a_red_torch 	= new AnimatedSprite(8, SpriteSheet.red_torch_sheet, 3, 11, true);
	public static AnimatedSprite a_blue_torch 	= new AnimatedSprite(8, SpriteSheet.blue_torch_sheet, 3, 11, true);
	public static AnimatedSprite a_water1 		= new AnimatedSprite(8, SpriteSheet.water1_sheet, 3, 50, true);
	public static AnimatedSprite a_water2 		= new AnimatedSprite(8, SpriteSheet.water2_sheet, 3, 50, true);
	public static AnimatedSprite a_water3 		= new AnimatedSprite(8, SpriteSheet.water3_sheet, 3, 50, true);
	public static AnimatedSprite a_waterPoison 	= new AnimatedSprite(8, SpriteSheet.waterPoison_sheet, 3, 70, true);
	public static AnimatedSprite a_waterfall1 	= new AnimatedSprite(8, SpriteSheet.waterfall1_sheet, 2, 20, true);
	public static AnimatedSprite a_waterfall2 	= new AnimatedSprite(8, SpriteSheet.waterfall2_sheet, 2, 20, true);
	public static AnimatedSprite a_waterfall3 	= new AnimatedSprite(8, SpriteSheet.waterfall3_sheet, 2, 20, true);
	public static AnimatedSprite a_waterfall4 	= new AnimatedSprite(8, SpriteSheet.waterfall4_sheet, 2, 20, true);
	public static AnimatedSprite a_flower1 		= new AnimatedSprite(8, SpriteSheet.flower1_sheet, 2, 60, false);
	public static AnimatedSprite a_flower2 		= new AnimatedSprite(8, SpriteSheet.flower2_sheet, 2, 60, false);
	public static AnimatedSprite a_pipe1  		= new AnimatedSprite(8, SpriteSheet.pipe1_sheet, 3, 40, false);
	public static AnimatedSprite a_glowingStone = new AnimatedSprite(8, SpriteSheet.glowingStone_sheet, 4, 15, true);
	public static AnimatedSprite a_blacksmithFire = new AnimatedSprite(8, SpriteSheet.blacksmith_fire_sheet, 3, 70, true);
	
	
	public static AnimatedSprite a_pipe2  		= new AnimatedSprite(8, SpriteSheet.pipe2_sheet, 3, 40, false);
	public static AnimatedSprite a_pipe2top  	= new AnimatedSprite(8, SpriteSheet.pipe2top_sheet, 3, 40, false);
	
	//pMachines
	public static AnimatedSprite pMachine_1 	= new AnimatedSprite(48*3, SpriteSheet.pMachine1_sheet, 6, 11, false);
	
	/**
	 * constructor, can create a loop
	 * @param size
	 * @param sheet
	 * @param length
	 * @param rate
	 * @param loop
	 */
	public AnimatedSprite(int size, SpriteSheet sheet, int length, int rate, boolean loop) {
		super(size);
		this.length = length;
		this.sheet 	= sheet;
		this.rate 	= rate;
		this.loop 	= loop;
		
		timer  = 0;
		sprite = sheet.sprites[0];
		
		if(length > sheet.sprites.length) System.err.println("Your length is too long for the given Sprites...");
	}
	
	/**
	 * constructor
	 * @param size
	 * @param sheet
	 * @param length
	 * @param rate
	 */
	public AnimatedSprite(int size, SpriteSheet sheet, int length, int rate) {
		super(size);
		this.length = length;
		this.sheet 	= sheet;
		this.rate 	= rate;
		this.playOnce = true;
		
		timer = 0;
		sprite = sheet.sprites[0];
		
		if(length > sheet.sprites.length) System.err.println("Your length is too long for the given Sprites...");
	}

	/**
	 * Update to next sprite if timer % rate = 0. If loop, dont restart, 
	 * but go through the frames backwards and back forth in the end etc.
	 */
	public void update(){
		if(Game.timer < 2000) timer++;
		else timer = 0;
		
		if(timer % rate == 0){
			if(frame == 0 && loop){
				adder = 1;
			}
			
			if(frame >= length-1){
				if(loop){
					adder = -1;
					frame += adder;
				}else{
					atTheEnd = true;
					if(!playOnce){
						frame = 0;
					}
				}
			}else{
				frame += adder;
			}
			sprite = sheet.sprites[frame];
		}
	}
	
	/**
	 * update animated sprites that should always move alike, like torches, flowers,...
	 */
	public static void staticUpdate(){
		Tile.a_red_torchTile.update();
		Tile.a_blue_torchTile.update();
		Tile.a_water1Tile.update();
		Tile.a_water2Tile.update();
		Tile.a_water3Tile.update();
		Tile.a_waterPoisonTile.update();
		Tile.a_waterfall1Tile.update();
		Tile.a_waterfall2Tile.update();
		Tile.a_waterfall3Tile.update();
		Tile.a_waterfall4Tile.update();
		Tile.a_flower1Tile.update();
		Tile.a_flower2Tile.update();
		Tile.a_pipe1BackgroundTile.update();
		Tile.a_pipe2Tile.update();
		Tile.a_pipe2TopTile.update();
		Tile.a_glowingStoneTile.update();
		
		plant11.update();
		plant12.update();
		plant13.update();
		plant14.update();
		
		plant21.update();
		plant22.update();
		plant23.update();
		plant24.update();
		
		a_blacksmithFire.update();
		
	}
	
	/**
	 * Reset animated sprite by changing attributes to the beginning
	 */
	public void reset(){
		frame = 0;
		timer = 0;
		sprite = sheet.sprites[0];
		atTheEnd = false;
	}
	
	/**
	 * check if actual frame is the last frame
	 * @return result
	 */
	public boolean isLastFrame(){
		return length-1 == frame;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setFrameRate(int rate){
		this.rate = rate;
	}
	public void setFrame(int i){
		frame = i;
		sprite = sheet.sprites[frame];
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	public int getFrame(){
		return frame;
	}
	public int getLength(){
		return length;
	}
	public boolean getAtTheEnd(){
		return atTheEnd;
	}
}