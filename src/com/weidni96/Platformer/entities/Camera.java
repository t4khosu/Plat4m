/**
 * camera to control the screen.
 */

package com.weidni96.Platformer.entities;

import com.weidni96.Platformer.entities.player.Player;

public class Camera extends Entity{
    private int newX;
    private int newY;
    private double moveX = 0;
    private double moveY = 0;
    
    private boolean moving;
    private Entity focusedEntity;
    private int     speed;
    
    private Player player;
    
    /**
     * constructor
     * @param player
     */
    public Camera(Player player){
        this.player = player;
        this.x = player.getX();
        this.y = player.getY();
        
        focusedEntity = player;
        moving = false;
    }
    
    /**
     * move to a certain point on the map (new center)
     * decide with speed how fast to move
     * @param newX
     * @param newY
     * @param speed
     */
    public void moveTo(int newX, int newY, int speed){
        this.focusedEntity = null;
        this.moving = true;
        this.speed = speed;
        
        this.newX = newX * 8;
        this.newY = newY * 8;
        
        /*
         * Calculate how much to move every update
         * with simple trigonometry
         */
        double ankathete = this.newX - x;
        double gegenkathete = this.newY - y;
        double hypotenuse = Math.sqrt(ankathete * ankathete + gegenkathete * gegenkathete);
        
        this.moveX = (ankathete / hypotenuse) * speed;
        this.moveY = (gegenkathete / hypotenuse) * speed;
 
    }
    
    /**
     * immediately go to a certain position (new center)
     * @param x
     * @param y
     */
    public void jumpTo(int x, int y){
        this.focusedEntity = null;
        this.x = x * 8;
        this.y = y * 8;
    }
    
    
    private double actualMoveX = 0;
    private double actualMoveY = 0;
    
    /**
     * helping method to move to the next pixel
     */
    private void move(){
    	actualMoveX += moveX;
    	actualMoveY += moveY;
    	
    	double preX = Math.floor(actualMoveX);
    	actualMoveX -= preX;
    	
    	double preY = Math.floor(actualMoveY);
    	actualMoveY -= preY;
    	
    	 // if camera moves too fast, check that it doesn't go too far
    	if((moveX < 0 && this.x + preX < newX) || (moveX > 0 && this.x + preX > newX)){
    		this.x = newX;
    	}else{
    		this.x += (int)preX;
    	}
    	
    	if((moveY < 0 && this.y + preY < newY) || (moveY > 0 && this.y + preY > newY)){
    		this.y = newY;
    	}else{
    		this.y += (int)preY;
    	}
    }
    
    /**
     * update camera to move to the next position, using the helping methods
     */
    public void update(){
        if(focusedEntity != null){
            this.x = focusedEntity.getX();
            this.y = focusedEntity.getY();
        }
        
        if(moving){
            if(x != newX || y != newY){
            	move();
            }else{
                moving = false;
            }
        }
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  	/* Get and set methods */
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void focusEntity(Entity focusedEntity){
        this.focusedEntity = focusedEntity;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isMoving(){
    	return moving;
    }
}