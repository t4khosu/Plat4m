package com.t4khosu.Platformer.Level.tile;

import com.t4khosu.Platformer.Level.Level;

/**
 * this class only provides 2 static functions.
 * Both for looking which color returns which tile.
 * @author Christian
 *
 */
public class TileGetterList {
	
	private static final int voidColor =  0xffffffff;
	
	/**
	 * get front tiles
	 * @param x
	 * @param y
	 * @param level
	 * @return
	 */
	public static Tile getTile(int x, int y, Level level){
		if(x < 0 || y < 0 || x >= level.getTileWidth() || y >= level.getTileHeight()) return Tile.voidTile;
		
		switch(level.getFrontTiles()[x + y * level.getTileWidth()]){
			case voidColor: return Tile.voidTile;
			
		//Water Tiles:
			case Tile.ID_deepWater1: return Tile.deepWater1Tile;
			case Tile.ID_deepWater2: return Tile.deepWater2Tile;
			case Tile.ID_deepWater3: return Tile.deepWater3Tile;
			case Tile.ID_deepWaterPoison: return Tile.deepWaterPoisonTile;
			case Tile.ID_reallyDeepWater1: return Tile.reallyDeepWater1Tile;
			case Tile.ID_reallyDeepWater2: return Tile.reallyDeepWater2Tile;
			case Tile.ID_reallyDeepWater3: return Tile.reallyDeepWater3Tile;	
			case Tile.ID_reallyDeepWaterPoison: return Tile.reallyDeepWaterPoisonTile;
			case Tile.ID_water1: return Tile.a_water1Tile;
			case Tile.ID_water2: return Tile.a_water2Tile;
			case Tile.ID_water3: return Tile.a_water3Tile;
			case Tile.ID_waterPoison: return Tile.a_waterPoisonTile;
			
		//Grass Tiles:
			case Tile.ID_grass1: return Tile.grass1Tile;
			case Tile.ID_grass2: return Tile.grass2Tile;
			case Tile.ID_grass3: return Tile.grass3Tile;
			case Tile.ID_grass4: return Tile.grass4Tile;
			case Tile.ID_destroyableGrass01: return Tile.destroyableGrass01Tile;
			case Tile.ID_destroyableGrass02: return Tile.destroyableGrass02Tile;
			case Tile.ID_destroyableGrass11: return Tile.destroyableGrass11Tile;
			case Tile.ID_destroyableGrass12: return Tile.destroyableGrass12Tile;
			case Tile.ID_destroyableGrass21: return Tile.destroyableGrass21Tile;
			case Tile.ID_destroyableGrass22: return Tile.destroyableGrass22Tile;
			case Tile.ID_destroyableGrass31: return Tile.destroyableGrass31Tile;
			case Tile.ID_destroyableGrass32: return Tile.destroyableGrass32Tile;
			
		//Dirt Tiles:
			case Tile.ID_dirt1: return Tile.dirt1Tile;
			case Tile.ID_dirt2: return Tile.dirt2Tile;
			case Tile.ID_dirt3: return Tile.dirt3Tile;
			case Tile.ID_dirt4: return Tile.dirt4Tile;
			case Tile.ID_field: return Tile.fieldTile;
			
		//Stone Tiles:
			case Tile.ID_stone1: return Tile.stone1Tile;
			case Tile.ID_stone2: return Tile.stone2Tile;
			case Tile.ID_stone3: return Tile.stone3Tile;
			case Tile.ID_stone4: return Tile.stone4Tile;
			case Tile.ID_topHardStone1: return Tile.topHardStone1Tile;
			case Tile.ID_poisoned_stone1: return Tile.poisoned_stone1Tile;
			case Tile.ID_glowingStone: return Tile.a_glowingStoneTile;
			case Tile.ID_breakStone: return Tile.breakStoneTile;
			
		//Raw Material Tiles:
			case Tile.ID_iron: return Tile.ironTile;
			case Tile.ID_polluted_iron: return Tile.polluted_ironTile;
			case Tile.ID_hardCoal: return Tile.hardCoalTile;
			case Tile.ID_polluted_hardCoal:	return Tile.polluted_hardCoalTile;
			
		//Asphalt Tiles:
			case Tile.ID_asphalt1: return Tile.asphalt1Tile;
			case Tile.ID_asphalt2: return Tile.asphalt2Tile;
			case Tile.ID_asphalt3: return Tile.asphalt3Tile;
			
		//Tree Tiles:
			case Tile.ID_trunk1: return Tile.trunk1Tile;
			case Tile.ID_trunk3: return Tile.trunk3Tile;
			case Tile.ID_leaf1: return Tile.leaf1Tile;
			case Tile.ID_leaf2: return Tile.leaf2Tile;
			
		//Flower Tiles:
			case Tile.ID_flower1: return Tile.a_flower1Tile;
			case Tile.ID_flower2: return Tile.a_flower2Tile;
			
		//Building Tiles:
			case Tile.ID_wood: return Tile.woodTile;
			case Tile.ID_rightBlank: return Tile.rightBlank;
			case Tile.ID_leftBlank: return Tile.leftBlank;
			case Tile.ID_topBlank: return Tile.topBlank;
			case Tile.ID_bottomBlank: return Tile.bottomBlank;
			
			case Tile.ID_woodPile: return Tile.woodPileTile;
			case Tile.ID_woodTopPile: return Tile.woodPileTopTile;
			case Tile.ID_woodBottomPile: return Tile.woodPileBottomTile;
			
			case Tile.ID_bridge: return Tile.bridgeTile;
			case Tile.ID_bridgeleft: return Tile.bridgeLeftTile;
			case Tile.ID_bridgeright: return Tile.bridgeRightTile;
			case Tile.ID_bars: return Tile.barsTile;
			
			case Tile.ID_concrete1: return Tile.concrete1Tile;
			case Tile.ID_concrete2: return Tile.concrete2Tile;
			case Tile.ID_concrete3: return Tile.concrete3Tile;
			case Tile.ID_rightConcrete: return Tile.concreteRightTile;
			case Tile.ID_leftConcrete: return Tile.concreteLeftTile;
			
			case Tile.ID_plastic1: return Tile.plastic1Tile;
			case Tile.ID_plastic2: return Tile.plastic2Tile;
			
			case Tile.ID_spike01: return Tile.spike01Tile;
			case Tile.ID_spike02: return Tile.spike02Tile;
			
			case Tile.ID_redstone1: return Tile.redstone1Tile;
			
		//Random Furniture Tiles:
			case Tile.ID_picture1: return Tile.picture1Tile;
			case Tile.ID_picture2: return Tile.picture2Tile;
			case Tile.ID_pictureBlacksmith: return Tile.pictureBlacksmithTile;
			case Tile.ID_bed1: return Tile.bed1Tile;
			case Tile.ID_sign1: return Tile.sign1Tile;
			case Tile.ID_cupboard1: return Tile.cupboard1Tile;
			case Tile.ID_cupboard2: return Tile.cupboard2Tile;
			case Tile.ID_shelf1: return Tile.shelf1Tile;
			case Tile.ID_shelf2: return Tile.shelf2Tile;
			case Tile.ID_shelfWithVase: return Tile.shelfWithVaseTile;
			case Tile.ID_tv1: return Tile.tv1Tile;
			case Tile.ID_rubbishBin1: return Tile.rubbishBin1Tile;
			
		//Curtain Tiles:
			case Tile.ID_curtain1: return Tile.curtain1Tile;
			case Tile.ID_curtain2: return Tile.curtain2Tile;
			case Tile.ID_curtain3: return Tile.curtain3Tile;
			case Tile.ID_curtain4: return Tile.curtain4Tile;
			
		//Object Tiles:
			case Tile.ID_pile: return Tile.pileTile;
			case Tile.ID_ladder1: return Tile.ladder1Tile;
			case Tile.ID_ladder2: return Tile.ladder2Tile;
			case Tile.ID_tendril1: return Tile.tendril1Tile;
			case Tile.ID_tendril2: return Tile.tendril2Tile;
			case Tile.ID_tendril3: return Tile.tendril3Tile;
			case Tile.ID_forceRight: return Tile.forceRightTile;
			case Tile.ID_forceLeft:  return Tile.forceLeftTile;
			case Tile.ID_forceDown:  return Tile.forceDownTile;
			case Tile.ID_cross: return Tile.crossTile;
			case Tile.ID_torch: return Tile.a_red_torchTile;
			case Tile.ID_blue_torch: return Tile.a_blue_torchTile;
			case Tile.ID_lamp1: return Tile.lamp1Tile;
			case Tile.ID_lamp2: return Tile.lamp2Tile;
			case Tile.ID_topTrail: return Tile.topTrailTile;
			case Tile.ID_spikeTile: return Tile.spikeTile;
			case Tile.ID_spikeDownTile: return Tile.spikeDownTile;
			case Tile.ID_torchOffTile: return Tile.torchOffTile;
			case Tile.ID_laserHeadTile: return Tile.laserHeadTile;
			case Tile.ID_laserHeadOnTile: return Tile.laserHeadOnTile;
			case Tile.ID_laserTile: return Tile.laserTile;
			
			case Tile.ID_redBoxTile: return Tile.redBoxTile;
			case Tile.ID_blueBoxTile: return Tile.blueBoxTile;
			case Tile.ID_redBoxFrameTile: return Tile.redBoxFrameTile;
			case Tile.ID_blueBoxFrameTile: return Tile.blueBoxFrameTile;
			
		//Carpet Tiles:
			case Tile.ID_carpet1: return Tile.carpet1Tile;
			
		//Rest Tiles:
			case Tile.ID_invicibleWall: return Tile.invicibleWall;
		
		//Background and front:
			//case Tile.ID_fence1_bg: return Tile.fence1BackgroundTile;
			case Tile.ID_fence2_bg: return Tile.fence2BackgroundTile;
			
		//Default:
			default: return Tile.voidTile;
		}
	}
	
	/**
	 * get background tiles
	 * @param x
	 * @param y
	 * @param level
	 * @return
	 */
	public static Tile getBackTile(int x, int y, Level level){
		if(x < 0 || y < 0 || x >= level.getTileWidth() || y >= level.getTileHeight()) return Tile.voidTile;
		
		switch(level.getBackTiles()[x + y * level.getTileWidth()]){
			case voidColor: return Tile.voidTile;
			case Tile.ID_wood1_bg: return Tile.wood1BackgroundTile;
			case Tile.ID_wood2_bg: return Tile.wood2BackgroundTile;
			case Tile.ID_wood3_bg: return Tile.wood3BackgroundTile;
			case Tile.ID_wood4_bg: return Tile.wood4BackgroundTile;
			case Tile.ID_fence1_bg: return Tile.fence1BackgroundTile;
			case Tile.ID_fence2_bg: return Tile.fence2BackgroundTile;
			case Tile.ID_wallpaper1_bg: return Tile.wallpaper1BackgroundTile;
			case Tile.ID_wallpaper2_bg: return Tile.wallpaper2BackgroundTile;
			case Tile.ID_wallpaper3_bg: return Tile.wallpaper3BackgroundTile;
			case Tile.ID_wallpaper4_bg: return Tile.wallpaper4BackgroundTile;
			case Tile.ID_wallpaper5_bg: return Tile.wallpaper5BackgroundTile;
			case Tile.ID_glass1_bg: return Tile.glass1BackgroundTile;
			case Tile.ID_glass2_bg: return Tile.glass2BackgroundTile;
			
			case Tile.ID_dirt1_bg: return Tile.dirt1BackgroundTile;
			case Tile.ID_stone1_bg: return Tile.stone1BackgroundTile;
			case Tile.ID_stone2_bg:	return Tile.stone2BackgroundTile;
			case Tile.ID_stone3_bg:	return Tile.stone3BackgroundTile;
			case Tile.ID_stone4_bg:	return Tile.stone4BackgroundTile;
			
			case Tile.ID_metal1_bg:	return Tile.metal1BackgroundTile;
			case Tile.ID_metal2_bg:	return Tile.metal2BackgroundTile;
			
			case Tile.ID_plastic1_bg: return Tile.plastic1BackgroundTile;
			case Tile.ID_plastic2_bg: return Tile.plastic2BackgroundTile;
			
			case Tile.ID_pipe1_bg: return Tile.a_pipe1BackgroundTile;
			case Tile.ID_pipe2_bg: return Tile.a_pipe2Tile;
			case Tile.ID_pipe1stopped_bg: return Tile.pipe1stoppedTile;
			case Tile.ID_pipe2top_bg: return Tile.a_pipe2TopTile;
			
			case Tile.ID_waterfall1: return Tile.a_waterfall1Tile;
			case Tile.ID_waterfall2: return Tile.a_waterfall2Tile;
			case Tile.ID_waterfall3: return Tile.a_waterfall3Tile;
			case Tile.ID_waterfall4: return Tile.a_waterfall4Tile;
			
			case Tile.ID_trunk2: return Tile.trunk2Tile;
			default: return Tile.voidTile;
		}
	}
}
