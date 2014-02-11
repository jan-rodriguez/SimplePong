/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jankrodriguez.game;

import org.lwjgl.util.Rectangle;

/**
 *
 * @author jan
 */
public class Physics {
    
    public static boolean checkCollision(GameObject go1, GameObject go2)
    {
        Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getY(), (int)go1.getWidth(), (int)go1.getHeight());
        Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getY(), (int)go2.getWidth(), (int)go2.getHeight());
        
        return r1.intersects(r2);
    }
    
}
