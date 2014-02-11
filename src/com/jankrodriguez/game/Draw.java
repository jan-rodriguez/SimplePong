/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jankrodriguez.game;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author jan
 */
public class Draw 
{
    
    public static void rect(float x, float y, float width, float height)
    {
        rect(x, y, width, height, 0);
    }
    
    public static void rect(float x, float y, float width, float height, float rotation)
    {
        
        //Adding another matrix for the individual rectangle
        glPushMatrix();
        {            
            //Translate the picture
            glTranslatef(x, y, 0);

            //Rotate picture
            glRotatef(rotation, 0, 0, 1);

            //Drawing squares
            glBegin(GL_QUADS);
            //points for our square
            {
                glVertex2f(0, 0); //bottom-left
                glVertex2f(0, height); //bottom-right
                glVertex2f(width, height); //top-right
                glVertex2f(width, 0); //top-left
            }
            glEnd();
        }
        
        //Remove the matrix from the stack
        glPopMatrix();
    }
    
}
