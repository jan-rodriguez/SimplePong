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
public class GOWall extends GameObject
{
    
    public static final int STDSIZE = 16;
    private GOBall ball;
    
    public GOWall(float x, float y, float width, float height, GOBall ball)
    {
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
        
        this.ball = ball;
    }

    @Override
    void update() 
    {
        if(Physics.checkCollision(this, ball))
        {
            ball.reverseY();
        }
    }
}
