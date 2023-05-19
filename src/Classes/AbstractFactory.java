/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Graphics;

/**
 *
 * @author Mazen
 */
public abstract class AbstractFactory {
    public abstract void drawrectangle(Rectangle r, Graphics g);
    public abstract void drawcircle(Circle r, Graphics g);
    public abstract void drawline(Line r, Graphics g);
    public abstract void drawSquare(Square r, Graphics g);
    public abstract void drawTriangle(Triangle r, Graphics g);
    
}
