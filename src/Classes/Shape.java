/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mazen
 */
public abstract class Shape implements Cloneable{
    
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract void draw (Graphics g);
    
    public abstract boolean contains(int x,int y);
    
}
