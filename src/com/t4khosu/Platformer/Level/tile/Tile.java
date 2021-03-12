package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.graphics.AnimatedSprite;
import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.graphics.Sprite;
import com.t4khosu.Platformer.Level.tile.AnimatedTile.A_BackgroundTile;
import com.t4khosu.Platformer.Level.tile.AnimatedTile.A_HardTile;
import com.t4khosu.Platformer.Level.tile.AnimatedTile.A_LiquidTile;
import com.t4khosu.Platformer.Level.tile.AnimatedTile.A_PoisonLiquidTile;

public abstract class Tile {
	
	protected Sprite sprite;
	protected int[][] solidFrame = {{0,0},{0,0},{0,0},{0,0}};
	
	//IDs: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Water IDs:
	public final static int ID_deepWater1 	 	= 0xff1F2663;
	public final static int ID_deepWater2 	 	= 0xff184547;
	public final static int ID_deepWater3 	 	= 0xff5ECCC6;
	public final static int ID_deepWaterPoison 	= 0xff4F1F7F;
	
	public final static int ID_reallyDeepWater1 = 0xff171D49;
	public final static int ID_reallyDeepWater2 = 0xff113133;
	public final static int ID_reallyDeepWater3 = 0xff5EA8C6;
	public final static int ID_reallyDeepWaterPoison = 0xff3C1860;
	
	public final static int ID_water1	= 0xff262DFF;
	public final static int ID_water2   = 0xff226063;
	public final static int ID_water3   = 0xff87FFD5;
	public final static int ID_waterPoison  = 0xff7C47B2;
	
	public final static int ID_waterfall1   = 0xff8488FF;
	public final static int ID_waterfall2   = 0xff262DFF;
	public final static int ID_waterfall3   = 0xff86E8EE;
	public final static int ID_waterfall4   = 0xffAB70E6;
	
	//Grass IDs:
	public final static int ID_grass1     = 0xff51FF39;
	public final static int ID_grass2     = 0xff48D831;
	public final static int ID_grass3     = 0xff72811B;
	public final static int ID_grass4     = 0xff8E811B;
	public final static int ID_destroyableGrass01 = 0xff00B560;
	public final static int ID_destroyableGrass02 = 0xff00B561;
	public final static int ID_destroyableGrass11 = 0xff51DB98;
	public final static int ID_destroyableGrass12 = 0xff51DB99;
	public final static int ID_destroyableGrass21 = 0xffD30235;
	public final static int ID_destroyableGrass22 = 0xffD30236;
	public final static int ID_destroyableGrass31 = 0xffD302C8;
	public final static int ID_destroyableGrass32 = 0xffD302C9;
	
	//Dirt IDs:
	public final static int ID_dirt1  	  = 0xff904217;
	public final static int ID_dirt2  	  = 0xffA05024;
	public final static int ID_dirt3  	  = 0xff832F12;
	public final static int ID_dirt4  	  = 0xff351708;
	public final static int ID_field  	  = 0xff683A21;
	
	//Stone IDs:
	public final static int ID_stone1     			= 0xff404040;
	public final static int ID_stone2     			= 0xff8E8EFF;
	public final static int ID_stone3	  			= 0xff132600;
	public final static int ID_stone4	  			= 0xff777777;
	public final static int ID_topHardStone1	  	= 0xff594747;
	public final static int ID_poisoned_stone1	  	= 0xff8B6B99;
	public final static int ID_glowingStone		  	= 0xff75FFFF;
	public final static int ID_breakStone 			= 0xff494958;
	
	//Raw Material IDs:
	public final static int ID_iron       			= 0xff6D2800;
	public final static int ID_polluted_iron    	= 0xff7A4527;
	public final static int ID_hardCoal   			= 0xff050505;
	public final static int ID_polluted_hardCoal	= 0xff210A0A;
	
	//Asphalt IDs:
	public final static int ID_asphalt1	  = 0xff2A2B38;
	public final static int ID_asphalt2	  = 0xff1B1B23;
	public final static int ID_asphalt3	  = 0xff151519;
	
	//Tree IDs:
	public final static int ID_trunk1	  = 0xff714467;
	public final static int ID_trunk2	  = 0xff995788;
	public final static int ID_trunk3	  = 0xff7F5666;
	public final static int ID_leaf1	  = 0xff69B450;
	public final static int ID_leaf2	  = 0xff3A3B68;
	
	//Flower Tiles:
	public final static int ID_flower1   = 0xffF4FF2D;
	public final static int ID_flower2   = 0xffFF0C0C;
	
	//Building IDs:
	public final static int ID_wood  	   = 0xffC47C25;
	public final static int ID_rightBlank  = 0xffFFC27C;
	public final static int ID_leftBlank   = 0xff875419;
	public final static int ID_topBlank    = 0xffDDB78B;
	public final static int ID_bottomBlank = 0xffC67D7D;
	
	public final static int ID_woodPile   		= 0xff442B0E;
	public final static int ID_woodTopPile   	= 0xff99821E;
	public final static int ID_woodBottomPile   = 0xffC2D32A;
	public final static int ID_bars			   = 0xffA04B46;
	
	public final static int ID_bridge 			= 0xff808724;
	public final static int ID_bridgeleft 		= 0xff575B18;
	public final static int ID_bridgeright 		= 0xffBBC15E;
	
	//Concrete Tiles:
	public final static int ID_concrete1       	= 0xff7F7F7F;
	public final static int ID_concrete2      	= 0xff7C6161;
	public final static int ID_concrete3      	= 0xff686868;
	public final static int ID_rightConcrete	= 0xff442B0D;
	public final static int ID_leftConcrete     = 0xff442B0F;
	
	//Plastic Tiles:
	public final static int ID_plastic1       	= 0xffEAEAEA;
	public final static int ID_plastic2       	= 0xffE8DADA;
	
	//Spike Tiles:
	public final static int ID_spike01       	= 0xffA50000;
	public final static int ID_spike02       	= 0xff700100;
	
	//Red stone Tiles:
	public final static int ID_redstone1       	= 0xff916B58;
	
	//Background IDs:
	public final static int ID_wood1_bg   = 0xff352012;
	public final static int ID_wood2_bg   = 0xff965E2D;
	public final static int ID_wood3_bg   = 0xffC67543;
	public final static int ID_wood4_bg   = 0xff492B19;
	
	public final static int ID_fence1_bg   = 0xff892000;
	public final static int ID_fence2_bg   = 0xff353D66;
	public final static int ID_wallpaper1_bg = 0xffD2D4DD;
	public final static int ID_wallpaper2_bg = 0xffA3A5AD;
	public final static int ID_wallpaper3_bg = 0xff9196AA;
	public final static int ID_wallpaper4_bg = 0xffA3C6AD;
	public final static int ID_wallpaper5_bg = 0xff84B792;
	public final static int ID_glass1_bg = 0xff9BE2E2;
	public final static int ID_glass2_bg = 0xff47E0E0;
	
	public final static int ID_dirt1_bg    = 0xff7F3914;
	public final static int ID_stone1_bg   = 0xff433E51;
	public final static int ID_stone2_bg   = 0xff232323;
	public final static int ID_stone3_bg   = 0xff0F180F;
	public final static int ID_stone4_bg   = 0xff161616;
	
	public final static int ID_plastic1_bg   = 0xffE5E5E5;
	public final static int ID_plastic2_bg   = 0xffA0A0A0;
	
	public final static int ID_pipe1_bg   	= 0xff3F3027;
	public final static int ID_pipe2_bg   	= 0xff150053;
	public final static int ID_pipe1stopped_bg   = 0xff150000;
	public final static int ID_pipe2top_bg  = 0xff0D0035;
	
	//Random Furniture IDs:
	public final static int ID_picture1 	= 0xffC6B9EA;
	public final static int ID_picture2 	= 0xffCECCCE;
	public final static int ID_pictureBlacksmith = 0xff121212;
	public final static int ID_bed1 		= 0xffB78886;
	public final static int ID_sign1 		= 0xffFF0000;
	public final static int ID_cupboard1 	= 0xffFFAAFF;
	public final static int ID_cupboard2 	= 0xffCE61CE;
	public final static int ID_shelf1 		= 0xffFFB600;
	public final static int ID_shelf2 		= 0xff00A9FF;
	public final static int ID_shelfWithVase = 0xffFFC132;
	public final static int ID_tv1	 		= 0xff1F252D;
	public final static int ID_rubbishBin1	= 0xffB6FF00;
	
	//Curtain IDs:
	public final static int ID_curtain1 	= 0xffBC3200;
	public final static int ID_curtain2 	= 0xffA52900;
	public final static int ID_curtain3 	= 0xff892000;
	public final static int ID_curtain4 	= 0xff701A00;
	
	//Object IDs:
	public final static int ID_pile       = 0xffA1B280;
	public final static int ID_ladder1    = 0xffC17E5E;
	public final static int ID_ladder2    = 0xffC3C4D8;
	public final static int ID_tendril1   = 0xff082F2A;
	public final static int ID_tendril2   = 0xff374714;
	public final static int ID_forceRight = 0xffFFFF00;
	public final static int ID_forceLeft  = 0xffFF8000;
	public final static int ID_forceDown  = 0xffFF4C00;
	public final static int ID_cross      = 0xff000000;
	public final static int ID_torch      = 0xffFF5500;
	public final static int ID_blue_torch = 0xff43AAD3;
	public final static int ID_lamp1	  = 0xffFFECBF;
	public final static int ID_lamp2	  = 0xffBFFFE2;
	public final static int ID_topTrail	  = 0xffC4B72D;
	public final static int ID_spikeTile  = 0xffCC4141;
	public final static int ID_spikeDownTile  	= 0xff8E2D2D;
	public final static int ID_torchOffTile 	= 0xff963200;
	public final static int ID_redBoxTile 		= 0xffE5444F;
	public final static int ID_blueBoxTile 		= 0xff487AE6;
	public final static int ID_redBoxFrameTile 	= 0xffE5444E;
	public final static int ID_blueBoxFrameTile = 0xff487AE5;
	public final static int ID_laserHeadTile 	= 0xffCCF9FF;
	public final static int ID_laserHeadOnTile 	= 0xffB5F6FF;
	public final static int ID_laserTile 		= 0xff93D9E2;
	
	//Carpet IDs:
	public final static int ID_carpet1    = 0xff5D77D8;
	
	//Poison Factory IDs:
	public final static int ID_metal1_bg = 0xff606280;
	public final static int ID_metal2_bg = 0xff262733;
	public final static int ID_tendril3  = 0xff19082D;
	
	//Rest IDs:
	public final static int ID_invicibleWall = 0xffFF00FF;
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~Floor Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Water Tiles:
	public static Tile deepWater1Tile  		= new UnderWater(Sprite.deep_water1_sprite);
	public static Tile reallyDeepWater1Tile = new UnderWater(Sprite.really_deep_water1_sprite);
	public static Tile deepWater2Tile  		= new UnderWater(Sprite.deep_water2_sprite);
	public static Tile reallyDeepWater2Tile = new UnderWater(Sprite.really_deep_water2_sprite);
	public static Tile deepWater3Tile  		= new UnderWater(Sprite.deep_water3_sprite);
	public static Tile reallyDeepWater3Tile = new UnderWater(Sprite.really_deep_water3_sprite);
	public static Tile deepWaterPoisonTile  	 = new UnderWaterPoison(Sprite.deep_water_poison_sprite);
	public static Tile reallyDeepWaterPoisonTile = new UnderWaterPoison(Sprite.really_deep_water_poison_sprite);
	
	public static Tile a_water1Tile  		= new A_LiquidTile(AnimatedSprite.a_water1);
	public static Tile a_water2Tile  		= new A_LiquidTile(AnimatedSprite.a_water2);
	public static Tile a_water3Tile  		= new A_LiquidTile(AnimatedSprite.a_water3);
	public static Tile a_waterPoisonTile  	= new A_PoisonLiquidTile(AnimatedSprite.a_waterPoison);
	public static Tile a_waterfall1Tile  	= new A_BackgroundTile(AnimatedSprite.a_waterfall1);
	public static Tile a_waterfall2Tile  	= new A_BackgroundTile(AnimatedSprite.a_waterfall2);
	public static Tile a_waterfall3Tile  	= new A_BackgroundTile(AnimatedSprite.a_waterfall3);
	public static Tile a_waterfall4Tile  	= new A_BackgroundTile(AnimatedSprite.a_waterfall4);
	public static Tile a_glowingStoneTile  	= new A_HardTile(AnimatedSprite.a_glowingStone);
	
	//Grass Tiles:
	public static Tile grass1Tile      		 = new HardTile(Sprite.grass1_sprite);
	public static Tile grass2Tile      		 = new HardTile(Sprite.grass2_sprite);
	public static Tile grass3Tile      		 = new HardTile(Sprite.grass3_sprite);
	public static Tile grass4Tile      		 = new HardTile(Sprite.grass4_sprite);
	public static Tile destroyableGrass01Tile = new DestroyableTile(Sprite.destroyable_grass0_1_sprite);
	public static Tile destroyableGrass02Tile = new BackgroundTile(Sprite.destroyable_grass0_2_sprite);
	public static Tile destroyableGrass11Tile = new DestroyableTile(Sprite.destroyable_grass1_1_sprite);
	public static Tile destroyableGrass12Tile = new BackgroundTile(Sprite.destroyable_grass1_2_sprite);
	
	//Dirt Tiles:
	public static Tile dirt1Tile  	  		= new PlowTile(Sprite.dirt1_sprite);
	public static Tile dirt2Tile  	  		= new PlowTile(Sprite.dirt2_sprite);
	public static Tile dirt3Tile  	  		= new PlowTile(Sprite.dirt3_sprite);
	public static Tile dirt4Tile  	  		= new PlowTile(Sprite.dirt4_sprite);
	public static Tile fieldTile  	  		= new FieldTile(Sprite.field_sprite);
	
	//Stone Tiles:
	public static Tile stone1Tile      		= new HardTile(Sprite.stone1_sprite);
	public static Tile stone2Tile      		= new HardTile(Sprite.stone2_sprite);
	public static Tile stone3Tile      		= new HardTile(Sprite.stone3_sprite);
	public static Tile stone4Tile      		= new HardTile(Sprite.stone4_sprite);
	public static Tile topHardStone1Tile    = new TopHardTile(Sprite.top_hard_stone1_sprite);
	public static Tile poisoned_stone1Tile  = new HardTile(Sprite.poisoned_stone1_sprite);
	public static Tile breakStoneTile      	= new BreakableTile(Sprite.breakStone_sprite);
	
	//Raw Materials Tiles:
	public static Tile ironTile 				= new MineTile(Sprite.iron_sprite);
	public static Tile polluted_ironTile		= new MineTile(Sprite.polluted_iron_sprite);
	public static Tile hardCoalTile 			= new MineTile(Sprite.hardCoal_sprite);
	public static Tile polluted_hardCoalTile	= new MineTile(Sprite.polluted_hardCoal_sprite);
	
	//Asphalt Tiles:
	public static Tile asphalt1Tile	   	= new HardTile(Sprite.asphalt1_sprite);
	public static Tile asphalt2Tile	   	= new HardTile(Sprite.asphalt2_sprite);
	public static Tile asphalt3Tile	   	= new HardTile(Sprite.asphalt3_sprite);
	
	//Tree Tiles:
	public static Tile trunk1Tile	   	= new HardTile(Sprite.trunk1_sprite);
	public static Tile trunk2Tile	   	= new BackgroundTile(Sprite.trunk2_sprite);
	public static Tile trunk3Tile	   	= new HardTile(Sprite.trunk3_sprite);
	public static Tile leaf1Tile	   	= new HardTile(Sprite.leaf1_sprite);
	public static Tile leaf2Tile	   	= new HardTile(Sprite.leaf2_sprite);
	
	//~Flower Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static Tile a_flower1Tile  	= new A_BackgroundTile(AnimatedSprite.a_flower1);
	public static Tile a_flower2Tile  	= new A_BackgroundTile(AnimatedSprite.a_flower2);
	
	//~Building Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Hard Jungle Wood Tiles:
	public static Tile woodTile  	  		= new HardTile(Sprite.wood_sprite);
	public static Tile rightBlank		 	= new RightHardTile(Sprite.wood_right_sprite);
	public static Tile leftBlank 			= new LeftHardTile(Sprite.wood_left_sprite);
	public static Tile topBlank 			= new TopHardTile(Sprite.wood_top_sprite);
	public static Tile bottomBlank		 	= new BottomHardTile(Sprite.wood_bottom_sprite);
	
	//Jungle Wood Pile Tiles:
	public static Tile woodPileTile 		= new BackgroundTile(Sprite.wood_pile_sprite);
	public static Tile woodPileTopTile      = new BackgroundTile(Sprite.wood_pileTop_sprite);
	public static Tile woodPileBottomTile   = new BackgroundTile(Sprite.wood_pileBottom_sprite);
	
	//Jungle Wood Bridge Tiles:
	public static Tile bridgeTile		 	= new TopHardTile(Sprite.bridge_sprite);
	public static Tile bridgeLeftTile		= new TopHardTile(Sprite.bridge_left_sprite);
	public static Tile bridgeRightTile		= new TopHardTile(Sprite.bridge_right_sprite);
	public static Tile barsTile		        = new HardTile(Sprite.bars_sprite);
	
	//Concrete Tiles:
	public static Tile concrete1Tile        = new HardTile(Sprite.concrete1_sprite);
	public static Tile concrete2Tile        = new HardTile(Sprite.concrete2_sprite);
	public static Tile concrete3Tile        = new HardTile(Sprite.concrete3_sprite);
	public static Tile concreteRightTile	= new HardTile(Sprite.concrete_right_sprite);
	public static Tile concreteLeftTile     = new HardTile(Sprite.concrete_left_sprite);
	
	//Plastic Tiles:
	public static Tile plastic1Tile        	= new HardTile(Sprite.plastic1_sprite);
	public static Tile plastic2Tile        	= new HardTile(Sprite.plastic2_sprite);
	
	//Spikes Tiles:
	public static Tile spike01Tile        	= new HardTile(Sprite.spike01_sprite);
	public static Tile spike02Tile        	= new HardTile(Sprite.spike02_sprite);
	
	//Red stone Tiles:
	public static Tile redstone1Tile        = new HardTile(Sprite.redstone1_sprite);
	
	//~Background Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Wood Background Tiles:
	public static Tile wood1BackgroundTile 	= new BackgroundTile(Sprite.wood1_background_sprite);
	public static Tile wood2BackgroundTile 	= new BackgroundTile(Sprite.wood2_background_sprite);
	public static Tile wood3BackgroundTile 	= new BackgroundTile(Sprite.wood3_background_sprite);
	public static Tile wood4BackgroundTile 	= new BackgroundTile(Sprite.wood4_background_sprite);
	
	//Fence Background Tiles:
	public static Tile fence1BackgroundTile  = new BackgroundTile(Sprite.fence1_background_sprite);
	public static Tile fence2BackgroundTile  = new BackgroundTile(Sprite.fence2_background_sprite);
	
	//Dirt Background Tiles:
	public static Tile dirt1BackgroundTile 	= new BackgroundTile(Sprite.dirt1_background_sprite);
	
	//Wallpaper Tiles:
	public static Tile wallpaper1BackgroundTile = new BackgroundTile(Sprite.wallpaper1_background_sprite);
	public static Tile wallpaper2BackgroundTile = new BackgroundTile(Sprite.wallpaper2_background_sprite);
	public static Tile wallpaper3BackgroundTile = new BackgroundTile(Sprite.wallpaper3_background_sprite);
	public static Tile wallpaper4BackgroundTile = new BackgroundTile(Sprite.wallpaper4_background_sprite);
	public static Tile wallpaper5BackgroundTile = new BackgroundTile(Sprite.wallpaper5_background_sprite);
	
	//Glass Tiles:
	public static Tile glass1BackgroundTile 	= new TransparentTile(Sprite.glass1_background_sprite);
	public static Tile glass2BackgroundTile 	= new TransparentTile(Sprite.glass2_background_sprite);
	
	//Stone Tiles:
	public static Tile stone1BackgroundTile 	= new BackgroundTile(Sprite.stone1_background_sprite);
	public static Tile stone2BackgroundTile 	= new BackgroundTile(Sprite.stone2_background_sprite);
	public static Tile stone3BackgroundTile 	= new BackgroundTile(Sprite.stone3_background_sprite);
	public static Tile stone4BackgroundTile 	= new BackgroundTile(Sprite.stone4_background_sprite);
	
	//Plastic Tiles:
	public static Tile plastic1BackgroundTile 	= new TransparentTile(Sprite.plastic1_background_sprite);
	public static Tile plastic2BackgroundTile 	= new TransparentTile(Sprite.plastic2_background_sprite);
	
	//Pipe Tiles:
	public static Tile pipe1BackgroundTile 		= new TransparentTile(Sprite.pipe1_background_sprite);
	public static Tile a_pipe1BackgroundTile  	= new A_BackgroundTile(AnimatedSprite.a_pipe1);
	
	//~Furniture Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Random Furniture Tiles:
	public static Tile picture1Tile     = new BackgroundTile(Sprite.picture1_sprite);
	public static Tile picture2Tile     = new BackgroundTile(Sprite.picture2_sprite);
	public static Tile pictureBlacksmithTile  = new BackgroundTile(Sprite.picture_blacksmith_sprite);
	public static Tile bed1Tile       	= new BackgroundTile(Sprite.bed1_sprite);
	public static Tile sign1Tile       	= new BackgroundTile(Sprite.sign1_sprite);
	public static Tile cupboard1Tile    = new BackgroundTile(Sprite.cupboard1_sprite);
	public static Tile cupboard2Tile    = new BackgroundTile(Sprite.cupboard2_sprite);
	public static Tile shelf1Tile       = new BackgroundTile(Sprite.shelf1_sprite);
	public static Tile shelf2Tile       = new BackgroundTile(Sprite.shelf2_sprite);
	public static Tile shelfWithVaseTile    = new BackgroundTile(Sprite.shelf_with_vase_sprite);
	public static Tile tv1Tile       	= new BackgroundTile(Sprite.tv1_sprite);
	public static Tile rubbishBin1Tile  = new BackgroundTile(Sprite.rubbishBin1_sprite);
	
	//Curtain Tiles:
	public static Tile curtain1Tile 	= new BackgroundTile(Sprite.curtain1_sprite);
	public static Tile curtain2Tile 	= new BackgroundTile(Sprite.curtain2_sprite);
	public static Tile curtain3Tile 	= new BackgroundTile(Sprite.curtain3_sprite);
	public static Tile curtain4Tile 	= new BackgroundTile(Sprite.curtain4_sprite);
	
	//~Object Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Tile pileTile       	= new ClimbTile(Sprite.pile_sprite);
	public static Tile ladder1Tile     	= new ClimbTile(Sprite.ladder1_sprite);
	public static Tile ladder2Tile     	= new ClimbTile(Sprite.ladder2_sprite);
	public static Tile tendril1Tile     = new ClimbTile(Sprite.tendril1_sprite);
	public static Tile tendril2Tile     = new ClimbTile(Sprite.tendril2_sprite);
	public static Tile tendril3Tile     = new ClimbTile(Sprite.tendril3_sprite); //sick poison
	public static Tile forceRightTile 	= new ForceRightTile(Sprite.forceRight_sprite);
	public static Tile forceLeftTile 	= new ForceLeftTile(Sprite.forceLeft_sprite);
	public static Tile forceDownTile 	= new ForceDownTile(Sprite.forceDown_sprite);
	public static Tile crossTile  	  	= new BackgroundTile(Sprite.cross_sprite);
	public static Tile a_red_torchTile  = new A_BackgroundTile(AnimatedSprite.a_red_torch);
	public static Tile a_blue_torchTile = new A_BackgroundTile(AnimatedSprite.a_blue_torch);
	public static Tile lamp1Tile 		= new BackgroundTile(Sprite.lamp1_sprite);
	public static Tile lamp2Tile 		= new BackgroundTile(Sprite.lamp2_sprite);
	public static Tile topTrailTile 	= new BackgroundTile(Sprite.topTrail_sprite);
	public static Tile spikeTile		= new DamageTile(Sprite.spike_sprite);
	public static Tile spikeDownTile	= new DamageTile(Sprite.spikeDown_sprite);
	public static Tile torchOffTile		= new BackgroundTile(Sprite.torch_OFF_sprite);
	public static Tile laserHeadTile	= new BackgroundTile(Sprite.laserHead_sprite);
	public static Tile laserHeadOnTile	= new BackgroundTile(Sprite.laserHeadOn_sprite);
	public static Tile laserTile		= new BackgroundTile(Sprite.laser_sprite);
	
	//Carpet Tiles:
	public static Tile carpet1Tile      = new BackgroundTile(Sprite.carpet1_sprite);
	
	//~Frames Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static Tile frame1LeftTile      	= new BackgroundTile(Sprite.frame1_left_sprite);
	public static Tile frame1RightTile      = new BackgroundTile(Sprite.frame1_right_sprite);
	public static Tile frame1TopTile       	= new BackgroundTile(Sprite.frame1_top_sprite);
	public static Tile frame1BottomTile     = new BackgroundTile(Sprite.frame1_bottom_sprite);

	public static Tile frame1TopLeftTile     = new BackgroundTile(Sprite.frame1_top_left_sprite);
	public static Tile frame1BottomLeftTile  = new BackgroundTile(Sprite.frame1_bottom_left_sprite);
	public static Tile frame1TopRightTile    = new BackgroundTile(Sprite.frame1_top_right_sprite);
	public static Tile frame1BottomRightTile = new BackgroundTile(Sprite.frame1_bottom_right_sprite);
	
	//~poison factory Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
			//front:
			public static Tile destroyableGrass21Tile = new DestroyableTile(Sprite.destroyable_grass2_1_sprite);
			public static Tile destroyableGrass22Tile = new BackgroundTile(Sprite.destroyable_grass2_2_sprite);
			public static Tile destroyableGrass31Tile = new DestroyableTile(Sprite.destroyable_grass3_1_sprite);
			public static Tile destroyableGrass32Tile = new BackgroundTile(Sprite.destroyable_grass3_2_sprite);
			
			public static Tile blueBoxTile 		= new HardTile(Sprite.blue_box_sprite);
			public static Tile redBoxTile 		= new HardTile(Sprite.red_box_sprite);
			public static Tile blueBoxFrameTile = new BackgroundTile(Sprite.blue_box_frame_sprite);
			public static Tile redBoxFrameTile 	= new BackgroundTile(Sprite.red_box_frame_sprite);
			
			public static Tile a_pipe2Tile  	= new A_BackgroundTile(AnimatedSprite.a_pipe2);
			public static Tile pipe1stoppedTile = new BackgroundTile(Sprite.pipe1_stopped_sprite);
			public static Tile a_pipe2TopTile  	= new A_BackgroundTile(AnimatedSprite.a_pipe2top);
	
			//background:
			public static BackgroundTile metal1BackgroundTile = new BackgroundTile(Sprite.metal1_background_sprite);
			public static BackgroundTile metal2BackgroundTile = new BackgroundTile(Sprite.metal2_background_sprite);
	
	//~Rest Tiles: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Tile voidTile     	= new VoidTile(Sprite.void_sprite);
	public static Tile invicibleWall	= new HardTile(Sprite.void_sprite);
	
	/**
	 * Constructor
	 * @param sprite
	 */
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	/**
	 * possible empty constructor
	 */
	public Tile(){
	}
	
	/**
	 * render tile with sprite at certain position
	 * @param x
	 * @param y
	 * @param screen
	 */
	public void render(int x, int y, Screen screen){
		screen.renderSprite(x, y, sprite, true);
	}

	/**
	 * update a tile (animation)
	 */
	public void update() {
	}
	
	/**
	 * damage this tile does
	 * @return
	 */
	public int damage(){
		return 0;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public Sprite getSprite(){
		return sprite;
	}
	public int[][] getSolidFrame(){
		return solidFrame;
	}
	public boolean isSolid()		 { return false; }
	public boolean isPartlySolid()	 { return false; }
	public boolean isUnderWater()	 { return false; }
	public boolean isFishable()		 { return false; }
	public boolean isClimbable()	 { return false; }
	public boolean isVoid()			 { return false; }
	public boolean isPlantable()	 { return false; }
	public boolean isPlowable()		 { return false; }
	public boolean isSideSolid(int x){ return false; }
	public boolean isBreakable()	 { return false; }
	public boolean isDestroyable()	 { return false; }
	public boolean isMinable()		 { return false; }
	public boolean slows()			 { return false; }
	public boolean forcesDown()		 { return false; }
}
