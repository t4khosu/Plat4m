package com.weidni96.Platformer.entities.interactiveEntities;

public class SavePointManager {
	
	public static SavePoint p1_neuleben 		= new SavePoint(74*8, 46*8, null, true);
	public static SavePoint p2_hauntedForest 	= new SavePoint(64*8, 36*8, null);
	public static SavePoint p3_villageForest 	= new SavePoint(81*8, 43*8, null);
	public static SavePoint p4_neuleben 		= new SavePoint(70*8, 43*8, null);
	
	public static SavePoint[] savePoints = {
			p1_neuleben, 
			p2_hauntedForest, 
			p3_villageForest, 
			p4_neuleben
	};
	
	public static SavePoint getActiveSavePoint(){
		for(SavePoint s : savePoints){
			if(s.isActive()) return s;
		}
		return p1_neuleben;
	}
	
	public static int getActiveSavePointPos(){
		for(int i = 0; i < savePoints.length; i++){
			if(savePoints[i].isActive()) return i;
		}
		return 0;
	}
}
