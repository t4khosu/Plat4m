package com.t4khosu.Platformer.entities.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import com.t4khosu.Platformer.Game;

public class Text {
	
	private String text;
	private Dialogbox db;
	
	private String shortText = "";
	private int speed	 	 = 2;
	private boolean skipable = true;
	
	private boolean multiChoice = false;
	private String[] choices;
	
	/**
	 * constructor, text and dialogbox written in
	 * @param text
	 * @param db
	 */
	public Text(String text, Dialogbox db){
		this.text 	= text;
		this.db 	= db;
	}
	
	private int i = 0;
	/**
	 * Update text by making it longer. The smaller speed is, the faster the text will change
	 */
	public void update(){
		if(Game.timer % speed == 0){
			if(i < text.length()) i++;
			
			if(db instanceof NPCDialogbox || db instanceof MultiChoiceDialog){
				shortText = text.substring(1, i);
			}else{
				shortText = text.substring(0, i);
			}
			
		}
	}
	
	/**
	 * First render headline and then in a for-loop all the dialog parts
	 * @param g
	 */
	public void renderText(Graphics g){	
		int xOff = 160;
		int yOff = 210;
		
		g.setColor(new Color(180,240,180)); /* headline */
		g.setFont( new Font("Arial Hebrew", Font.BOLD, 14)); 
		
		if(db.getWaitTimer() == 0){
			g.drawString(db.getHeadline(), Game.width * Game.scale/2 - xOff, Game.height * Game.scale/2 - yOff);
		}
		
		g.setColor(Color.white); /* text */
		g.setFont(new Font("Arial Hebrew", Font.PLAIN, 14)); 
		
		ArrayList<String> text = stringSplit(g, 270, shortText);
		for(int i = 0; i < text.size(); i++){
			g.drawString(text.get(i),  Game.width * Game.scale/2 - xOff, Game.height * Game.scale/2 - yOff + 22 * (i+1));
		}
		
		if(multiChoice && i == this.text.length()){
			for(int i = 0; i < choices.length; i++){
				String arrow = " ";
				if(i == db.getSelectedChoice()){
					arrow = "\u21E8 ";
				}
				g.drawString(arrow + choices[i],  Game.width * Game.scale/2 - xOff, Game.height * Game.scale/2 - yOff + 22 * (text.size()+ i +1));
			}
		}
	}
	
	/**
	 * Split text into matching lines (length = maxSize) for a dialog box
	 * @param g
	 * @param maxSize
	 * @param dialog
	 * @return
	 */
	public ArrayList<String> stringSplit(Graphics g, int maxSize, String dialog){
		ArrayList<String> split = new ArrayList<String>();
		String[] splitted = dialog.split(" ");
		
		String add = "";
		for(int i = 0; i < splitted.length; i++){
			String s = splitted[i];
			add += s + " ";
			int width = g.getFontMetrics().stringWidth(add);
			if(width > maxSize){
				split.add(add);
				add = "";
			}
		}
		split.add(add);
		return split;
	}
	
	/**
	 * finish text when can skip
	 */
	public void finishText(){
		if(skipable){
			i = text.length();
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/* Get and set methods */
	public void setMultiChoice(boolean multiChoice){
		this.multiChoice = multiChoice;
	}
	public void setChoices(String[] choices){
		this.choices = choices;
	}
	
	public String getText(){
		return text;
	}
	public String getShortText(){
		return shortText;
	}
	public boolean getMultiChoice(){
		return multiChoice;
	}
}