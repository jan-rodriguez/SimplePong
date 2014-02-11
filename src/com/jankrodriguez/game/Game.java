/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jankrodriguez.game;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 *
 * @author jan
 */
public class Game 
{
    
    private ArrayList<GameObject> objects;
    
    private final GOPlayer player;
    private final GOEnemy enemy;
    private final GOBall ball;
    
    private int playerScore = 0;
    private int enemyScore = 0;
    
    public Game()
    {
        objects = new ArrayList<GameObject>();
        
        //Set ball to the center of the screen
        ball = new GOBall(Display.getWidth() / 2 - GOBall.SIZE / 2, Display.getHeight() / 2 - GOBall.SIZE / 2);
        objects.add(ball);
        
        //Adding player paddle
        player = new GOPlayer(0, Display.getHeight() / 2 - GOPlayer.SIZEY / 2, ball);
        objects.add(player);
        
        //Adding enemy paddle
        enemy = new GOEnemy(Display.getWidth() - GOEnemy.SIZEX, Display.getHeight() / 2 - GOEnemy.SIZEY / 2, ball);
        objects.add(enemy);
        
        //Adding walls
        GOWall wall1 = new GOWall(0, 0, Display.getWidth(), GOWall.STDSIZE, ball);
        GOWall wall2 = new GOWall(0, Display.getHeight() - GOWall.STDSIZE, Display.getWidth(), GOWall.STDSIZE, ball);
        objects.add(wall1);
        objects.add(wall2);
    }
    
    public void update()
    {
        for(GameObject go : objects)
        {
            go.update();
        }
        
        if(ball.getX() > Display.getWidth())
        {
            playerScore ++;
            ball.resetPosition();
        }
        else if(ball.getX() < 0){
            enemyScore ++;
            ball.resetPosition();
        }
    }
    
    public void getInput()
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP))
        {
            player.move(1);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))
        {
            player.move(-1);
        }
    }
    
    public void render()
    {
        for(GameObject go : objects)
        {
            go.render();
        }
        
        Display.setTitle("P"+playerScore+" E"+enemyScore);
    }
}
