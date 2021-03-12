package com.weidni96.Platformer.entities.interactiveEntities.plants;

import java.util.ArrayList;

public class PlantManager {
	
	public static ArrayList<Plant> plants = new ArrayList<Plant>();
	
	public static void addPlant(Plant p){
		plants.add(p);
	}
	
	public static void update(){
		for(Plant p : plants){
			p.update();
		}
	}
}
