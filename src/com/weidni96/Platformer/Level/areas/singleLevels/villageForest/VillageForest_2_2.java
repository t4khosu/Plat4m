package com.weidni96.Platformer.Level.areas.singleLevels.villageForest;

import com.weidni96.Platformer.Level.Area;
import com.weidni96.Platformer.Level.LoadLevel;
import com.weidni96.Platformer.Level.NPCManager;
import com.weidni96.Platformer.entities.Timer;
import com.weidni96.Platformer.entities.enemies.StoneSnail;
import com.weidni96.Platformer.entities.enemies.insects.BrownSpider;
import com.weidni96.Platformer.entities.enemies.slimes.UndergroundSlime;
import com.weidni96.Platformer.entities.interactiveEntities.ChestManager;
import com.weidni96.Platformer.entities.interactiveEntities.Lever;
import com.weidni96.Platformer.entities.interactiveEntities.Sign;
import com.weidni96.Platformer.entities.interactiveEntities.Sign.SignType;
import com.weidni96.Platformer.entities.interactiveEntities.bookshelfes.Walker1_Bookshelf;
import com.weidni96.Platformer.graphics.cutscenes.ShakingCutscene;

public class VillageForest_2_2 extends LoadLevel{

	private boolean openDoor = false;
	private boolean hasOpened = false;
	private Lever lever1;
	private Lever lever2;
	private Timer activeTimer = new Timer(12*60);
	
	public VillageForest_2_2(Area area, int areaPosX, int areaPosY) {
		super(	area.getPlayer(), 
				null, 
				"/level/standard/village_forest_10.png", 
				"/level/standard/village_forest_10_back.png", 
				levelType.UNDERGROUND, 
				area,
				areaPosX,
				areaPosY
		);
	}

	@Override
	protected void initMobs() {
		mobs.add(new StoneSnail(30*8, 31*8, this));
		mobs.add(new UndergroundSlime(78*8, 26*8, this));
		mobs.add(new UndergroundSlime(88*8, 38*8, this));
		mobs.add(new BrownSpider(7*8, 14*8, this));
		mobs.add(new BrownSpider(33*8, 3*8, this));
	}

	@Override
	protected void initNPCs() {
		npcs.add(NPCManager.schatzsucher_villageForest.initLevelAndReturn(this));
	}

	@Override
	protected void initSurroundings() {
		interactiveEntities.add(new Sign(37*8, 26*8, "Minenschachte G6", SignType.WOODEN)); 
		
		lever1 = new Lever(3*8, 38*8, 0, false);
		interactiveEntities.add(lever1);
		lever2 = new Lever(90*8, 28*8, 0, false);
		interactiveEntities.add(lever2);
		
		interactiveEntities.add(new Walker1_Bookshelf(28*8, 47*8, this)); 
		interactiveEntities.add(ChestManager.woodenPickaxe_villageForest.initChestAndReturn(this));
		interactiveEntities.add(ChestManager.money_villageForest.initChestAndReturn(this));
	}

	@Override
	protected void individualUpdate() {
		if((this.lever1.isOn() ^ this.lever2.isOn()) && !activeTimer.isActive()){
			activeTimer.start();
			area.getWorld().getSurface().showTimer(activeTimer);
		}
		
		if(activeTimer.isActive()){
			activeTimer.update();
			if(!activeTimer.isActive()){
				if(this.lever1.isOn()){
					this.lever1.superSwitchLever();
				}else if(this.lever2.isOn()){
					this.lever2.superSwitchLever();
				}
			}
			
			if(this.lever1.isOn() && this.lever2.isOn()){
				activeTimer.stop();
				openDoor = true;
			}
		}
		if(openDoor && !hasOpened){
			area.getWorld().setCutscene(new ShakingCutscene(area.getWorld(), 1, 1, 50));
			setTile(57, 46, 0);
			setTile(57, 47, 0);
			hasOpened = true;
		}
		
	}
	
	@Override
	public void individualSaveFileLoad(String input) {
	}

	@Override
	public String individualSave() {
		return "";
	}
}
