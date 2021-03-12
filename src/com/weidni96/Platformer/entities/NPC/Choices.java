package com.weidni96.Platformer.entities.NPC;

public class Choices {
	
	private int id = 0; /* to connect with certain dialog parts */
	private String[] choices;
	private int selectedChoice = 0;
	
	/**
	 * constructor
	 * @param id
	 * @param choices
	 */
	public Choices(int id, String[] choices){
		this.id = id;
		this.choices = choices;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setSelectedChoice(int s){
		this.selectedChoice = s;
	}
	
	public int getID(){
		return id;
	}
	public String[] getChoices(){
		return choices;
	}
	public int getSelectedChoice(){
		return selectedChoice;
	}
}