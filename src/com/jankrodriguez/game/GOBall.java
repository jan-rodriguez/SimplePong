/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jankrodriguez.game;

/**
 *
 * @author jan
 */
public class GOBall extends GameObject
{
    public static final int SIZE = 16;
    public static final float MAX_SPEEDX = 4;
    public static final float MAX_SPEEDY = 8;
    public static final float DAMPING = 0.05f;
    
    public float velX;
    public float velY;
    
    private float startX;
    private float startY;
    
    public GOBall(float x, float y)
    {
        //Moving ball to correct location
        this.x = startX = x;
        this.y = startY = y;
        
        //Setting width and height to size since it is a square
        this.width = this.height = SIZE;
        
        velX = -MAX_SPEEDX;
        velY = 0;
    }
    
    @Override
    void update() 
    {
        //Move the ball according to the velocitiy
        x += velX;
        y += velY;
    }
    
    public void reverseX(float center)
    {
        velX *= -1;
        
         //Move the ball up or down based on where it hit the player
        velY += (getCenterY() - center) * DAMPING;
        
        //Assure that we don't go over or under the max speed
        if(velY > MAX_SPEEDY)
        {
            velY = MAX_SPEEDY;
        }
        else if(velY < -MAX_SPEEDY)
        {
            velY = -MAX_SPEEDY;
        }
    }
    
    public void reverseY()
    {
        velY *= -1;
    }
    
    public void resetPosition()
    {
        x = startX;
        y = startY;
        
        //Get rid of vertical velocity and make the ball go to opposing paddle
        velY = 0;
        velX *= -1;
    }
}
