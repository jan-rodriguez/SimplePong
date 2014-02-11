/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jankrodriguez.game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*; //Import all of openGL

/**
 *
 * @author jan
 */
public class Main 
{
    private static Game game;
    
    public static void main(String[] args)
    {
        
        //Initialize program
        initDisplay();
        initGL();
        
        initGame();
        
        gameLoop();
        cleanUp();
        
    }
    
    private static void initGame()
    {
        game = new Game();
    }
    
    private static void getInput()
    {
        game.getInput();
    }
    
    private static void update()
    {
        game.update();
    }
    
    private static void render()
    {
        //Clear matrix
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        game.render();
        
        Display.update();
        Display.sync(60);
    }
    
    private static void gameLoop()
    { 
        while(!Display.isCloseRequested())
        {
            getInput();
            update();
            render();   
        }
    }
    
    private static void initDisplay()
    {
        
        //Create display
        try
        {
            Display.setDisplayMode( new DisplayMode(800, 600));
            Display.create();
            Display.setVSyncEnabled(true); //Sync to the monitor's framerate
            
            Keyboard.create(); //Set up keyboard to get user inputs
        }catch(LWJGLException e)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    private static void initGL()
    {
        
        //Set up the projection matrix
        glMatrixMode(GL_PROJECTION);
        //Clear the matrix, start from scratch
        glLoadIdentity();
        //Orthographic matrix
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        //Swtich back to model view matrix
        glMatrixMode(GL_MODELVIEW);
        
        //Black
        glClearColor(0, 0, 0, 1);
        
        //Disable depth since we only want to display stuff in 2-D
        glDisable(GL_DEPTH_TEST);
    }
    
    private static void cleanUp()
    {
        
        //Clean up all the OpenGL stuff
        Display.destroy();
        Keyboard.destroy();
        
    }    
}
