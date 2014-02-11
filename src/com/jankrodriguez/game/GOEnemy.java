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
public class GOEnemy extends GameObject
{
    
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float MAX_SPEED = 4f;
    public static final float DAMPING = 0.05f;
    
    private GOBall ball;
    
    public GOEnemy(float x, float y, GOBall ball)
    {
        this.x = x;
        this.y = y;
        
        this.width = SIZEX;
        this.height = SIZEY;
        
        this.ball = ball;
    }

    @Override
    void update() 
    {
        if(Physics.checkCollision(this, ball))
        {
            ball.reverseX(getCenterY());
        }
        
        float speed = (ball.getCenterY() - getCenterY()) * DAMPING;
        
        if(speed > MAX_SPEED)
        {
            speed = MAX_SPEED;
        }
        else if(speed < -MAX_SPEED)
        {
            speed = -MAX_SPEED;
        }
        y += speed;
    }
    
}
