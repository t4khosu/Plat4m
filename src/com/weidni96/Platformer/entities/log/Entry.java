package com.weidni96.Platformer.entities.log;

public class Entry {
	
	private String text;
	private int color;
	
	/**
	 * constructor
	 * @param text
	 * @param color
	 */
	public Entry(String text, int color){
		this.text = text;
		this.color = color;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public int getColor(){
		return color;
	}
	public String getText(){
		return text;
	}
}