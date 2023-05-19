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
public class Square extends TwoDShapes implements Cloneable {

    private int x1, x2, y1, y2;

    public Square(int x1, int y1, int x2, int y2, boolean fill, Color color) {
        super(fill, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        DrawFactory s = new DrawFactory();
        s.drawSquare(this, g);
    }

    public void fill(Graphics g) {
        FillFactory s = new FillFactory();
        s.drawSquare(this, g);
    }

    @Override
    public boolean contains(int x, int y) {
        ShapeDecorator s = new ShapeDecorator();
        java.awt.Rectangle r = null;
        r = s.selectsquare(this);
        return r.contains(x, y);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Square r = (Square) super.clone();
        r.setX1(x1 + 16);
        r.setX2(x2 + 15);
        r.setY1(y1 + 16);
        r.setY2(y2 + 15);
        return r;
    }

    public Object undoclone() throws CloneNotSupportedException {
        Square r = (Square) super.clone();
        r.setX1(x1);
        r.setX2(x2);
        r.setY1(y1);
        r.setY2(y2);
        return r;
    }
}
