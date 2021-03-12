package com.weidni96.Platformer.Level;

import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.entities.NPC.forest.Ahb;
import com.weidni96.Platformer.entities.NPC.forest.Ans;
import com.weidni96.Platformer.entities.NPC.forest.Barus;
import com.weidni96.Platformer.entities.NPC.forest.DrHarun;
import com.weidni96.Platformer.entities.NPC.forest.Dregen;
import com.weidni96.Platformer.entities.NPC.forest.Giza;
import com.weidni96.Platformer.entities.NPC.forest.Gorn;
import com.weidni96.Platformer.entities.NPC.forest.Honja;
import com.weidni96.Platformer.entities.NPC.forest.Isan;
import com.weidni96.Platformer.entities.NPC.forest.Kurb;
import com.weidni96.Platformer.entities.NPC.forest.Levindra;
import com.weidni96.Platformer.entities.NPC.forest.Locus;
import com.weidni96.Platformer.entities.NPC.forest.Mendra;
import com.weidni96.Platformer.entities.NPC.forest.Preng;
import com.weidni96.Platformer.entities.NPC.forest.Priest;
import com.weidni96.Platformer.entities.NPC.forest.Schatzsucher;
import com.weidni96.Platformer.entities.NPC.forest.TalonBlacksmith;
import com.weidni96.Platformer.entities.NPC.forest.Tobi;
import com.weidni96.Platformer.entities.NPC.forest.Wachposten;

public class NPCManager {
	
	//Neuleben NPCs
	public static Ahb ahb_neuleben			= new Ahb(10*8, 37*8, null);
	public static Ans ans_neuleben			= new Ans(24*8, 46*8, null);
	public static Barus barus_neuleben		= new Barus(81*8, 31*8, null);
	public static Locus locus_neuleben	 	= new Locus(15*8, 37*8, null);
	public static Dregen dregen_neuleben 	= new Dregen(70*8, 25*8, null);
	public static Gorn gorn_neuleben		= new Gorn(33*8, 40*8, null);
	public static Honja honja_neuleben		= new Honja(49*8, 10*8, null);
	public static Levindra levindra_neuleben = new Levindra(66*8, 37*8, null);
	public static Tobi tobi_neuleben		= new Tobi(86*8, 31*8, null);
	public static Giza giza_neuleben		= new Giza(72*8, 32*8, null);
	public static Isan isan_neuleben		= new Isan(15*8, 30*8, null);
	public static Preng preng_neuleben		= new Preng(62*8, 45*8, null);
	public static Priest priest_neuleben	= new Priest(15*8, 46*8, null);
	public static DrHarun drHarun_neuleben	= new DrHarun(82*8, 45*8, null);
	public static Kurb kurb_neuleben		= new Kurb(10*8, 39*8, null);
	
	//Village Forest
	public static Wachposten wachposten_villageForest = new Wachposten(94*8, 46*8, null);
	public static Schatzsucher schatzsucher_villageForest = new Schatzsucher(61*8, 47*8, null);
	public static TalonBlacksmith talonBlacksmith_villageForest = new TalonBlacksmith(29*8, 23*8, null);
	
	//Haunted Forest
	public static Mendra mendra_hauntedForest	= new Mendra(67*8, 36*8, null);
	
	/**
	 * list of all npc's
	 * NEVER CHANGE POSTIONS! COULD CORRUPT SAVE FILES
	 * ONLY ADD NEW ONES AT THE END
	 */
	public static NPC[] npcList = {ahb_neuleben, ans_neuleben, barus_neuleben,
			locus_neuleben, dregen_neuleben, gorn_neuleben, honja_neuleben, levindra_neuleben, tobi_neuleben,
			preng_neuleben, priest_neuleben, drHarun_neuleben, kurb_neuleben, wachposten_villageForest,
			schatzsucher_villageForest, mendra_hauntedForest, talonBlacksmith_villageForest, giza_neuleben};
}
