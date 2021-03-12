package com.t4khosu.Platformer.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Keyboard class to check inputs
 * @author Christian
 *
 */
public class Keyboard implements KeyListener{
	
	public boolean[] keys = new boolean[200];
	public boolean up, down, left, right;
	public boolean j, k;
	public boolean inventory, interact;
	public boolean map;
	public boolean punsh;
	public boolean log;
	public boolean esc;
	public boolean plow;
	public boolean plant;
	public boolean harvest;
	
	int typeableKeys = 20;
	public boolean[] numbers = new boolean[6];
	public boolean[] keys_t	 = new boolean[typeableKeys]; //20 keys to type, can get bigger if wanted to
	
	public boolean 		upPressed, downPressed, leftPressed, rightPressed, jPressed, kPressed, inventoryPressed, interactPressed, logPressed;
	public boolean[] 	pressedKeys	= new boolean[typeableKeys];
	public boolean[] 	numbersPressed = new boolean[6];
	public boolean 		typedUp, typedDown, typedLeft, typedRight, typedJ, typedK, typedInventory, typedInteract, typedLog;
	public boolean[] 	typedKeys		= new boolean[typeableKeys];
	public boolean[] 	numbersTyped = new boolean[6];

	/**
	 * check if a boolean becomes true or false for keys,
	 * also check if a key got typed
	 */
	public void update(){
		//Long pressed
		up    	 = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down  	 = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		right 	 = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		left  	 = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		
		map		  = keys[KeyEvent.VK_M];
		punsh	  = keys[KeyEvent.VK_O];
		log	 	  = keys[KeyEvent.VK_L];
		
		interact  = keys[KeyEvent.VK_SPACE];
		inventory = keys[KeyEvent.VK_E];
		harvest   = keys[KeyEvent.VK_H];
		
		j		  = keys[KeyEvent.VK_J];
		k 		  = keys[KeyEvent.VK_K];
		
		esc 	  = keys[KeyEvent.VK_ESCAPE];
		
		//numbers
		numbers[0]	= keys[KeyEvent.VK_1];
		numbers[1]	= keys[KeyEvent.VK_2];
		numbers[2]	= keys[KeyEvent.VK_3];
		numbers[3]	= keys[KeyEvent.VK_4];
		numbers[4]	= keys[KeyEvent.VK_5];
		numbers[5]	= keys[KeyEvent.VK_6];
		
		//Just typed:
		if(interact && !interactPressed){
			typedInteract 	= true;
			interactPressed = true;
		}else typedInteract = false;
		
		if(inventory && !inventoryPressed){
			typedInventory 	 = true;
			inventoryPressed = true;
		}else typedInventory = false;
		
		if(j && !jPressed){
			typedJ 	 = true;
			jPressed = true;
		}else typedJ = false;
		
		if(k && !kPressed){
			typedK 	 = true;
			kPressed = true;
		}else typedK = false;
		
		if(up && !upPressed){
			typedUp 	= true;
			upPressed 	= true;
		}else typedUp 	= false;
		
		if(down && !downPressed){
			typedDown 	= true;
			downPressed = true;
		}else typedDown = false;
		
		if(right && !rightPressed){
			typedRight 	 = true;
			rightPressed = true;
		}else typedRight = false;
		
		if(left && !leftPressed){
			typedLeft 	= true;
			leftPressed = true;
		}else typedLeft = false;
		
		if(log && !logPressed){
			typedLog = true;
			logPressed = true;
		}else typedLog = false;
		
		//numbers:
		
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] && !numbersPressed[i]){
				numbersTyped[i] = true;
				numbersPressed[i] = true;
			}else{
				numbersTyped[i] = false;
			}
		}
	}
	
	/**
	 * when key is pressed, set its value true
	 */
	public void keyPressed(KeyEvent e) {
		try{
			keys[e.getKeyCode()] = true;
		}catch(Exception ex){
			
		}
		
	}

	/**
	 * when a key is released, set pressed attribute of this key = false
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) interactPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_E)		inventoryPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_J)		jPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_K)		kPressed = false;
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) upPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) downPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) rightPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) leftPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_L) logPressed = false;
		
		if(e.getKeyCode() == KeyEvent.VK_1) numbersPressed[0] = false;
		if(e.getKeyCode() == KeyEvent.VK_2) numbersPressed[1] = false;
		if(e.getKeyCode() == KeyEvent.VK_3) numbersPressed[2] = false;
		if(e.getKeyCode() == KeyEvent.VK_4) numbersPressed[3] = false;
		if(e.getKeyCode() == KeyEvent.VK_5) numbersPressed[4] = false;
		if(e.getKeyCode() == KeyEvent.VK_6) numbersPressed[5] = false;
	}

	/**
	 * not used
	 */
	public void keyTyped(KeyEvent e) {
	}
}
