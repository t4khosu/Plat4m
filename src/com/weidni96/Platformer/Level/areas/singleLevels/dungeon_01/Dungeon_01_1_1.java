package com.weidni96.Platformer.Level.areas.singleLevels.dungeon_01;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.entities.Entity;
import com.weidni96.Platformer.entities.pMachineDungeon_1;
import com.weidni96.Platformer.entities.enemies.StoneSnail;
import com.weidni96.Platformer.entities.enemies.insects.PoisonSpider;
import com.weidni96.Platformer.entities.enemies.slimes.PoisonSlime;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.entities.particles.Dripper;
import com.weidni96.Platformer.graphics.Screen;
import com.weidni96.Platformer.graphics.Sprite;

public class Dungeon_01_1_1 extends LoadLevel{
	
	private Dripper d1;
	private Dripper d2;
	private pMachineDungeon_1 machine;
	
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
	public Dungeon_01_1_1(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 
				"/level/dungeon_01/dungeon_1_4_front.png", 
				"/level/dungeon_01/dungeon_1_4_back.png", 
				levelType.DUNGEON, 
				area,
				areaPosX,
				areaPosY
		);
		
		d1 = new Dripper(180, 0xff4F1F7F, 20*8, 68*8, this);
		d2 = new Dripper(180, 0xff4F1F7F, 48*8, 60*8, this);
		machine = new pMachineDungeon_1(18 * 8, 71 * 8, this);
	}

	@Override
	protected void initMobs() {
		mobs.add(new PoisonSlime(18*8, 39*8, this));
		mobs.add(new PoisonSlime(48*8, 18*8, this));
		mobs.add(new PoisonSlime(42*8, 58*8, this));
		mobs.add(new StoneSnail(48*8, 81*8, this));
		mobs.add(new StoneSnail(10*8, 53*8, this));
		mobs.add(new PoisonSpider(50*8, 8*8, this));
	}

	@Override
	protected void initNPCs() {
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(ChestManager.money_dungeon01.initChestAndReturn(this));
		interactiveEntities.add(ChestManager.cd1_dungeon01.initChestAndReturn(this));
		interactiveEntities.add(new Sign(22*8, 88*8, "Sch\u00FCttel-Reaktor, DEFEKT", SignType.WOODEN)); 
		
		hiders.add(new Entity(60*8, 58*8, Sprite.stone1_sprite));
		for(int i = 60; i <= 69; i++){
			hiders.add(new Entity(i*8, 57*8, Sprite.stone1_sprite));
		}
		
	}

	@Override
	protected void individualUpdate() {	
		d1.update();
		d2.update();
		machine.update();
	}
	
	@Override
	public void individualRender(Screen screen){
		machine.render(screen);
	}
	
	@Override
	public void individualSaveFileLoad(String input) {
	}
	
	public pMachineDungeon_1 getMachine(){
		return machine;
	}
	
	@Override
	public String individualSave() {
		return "";
	}
}