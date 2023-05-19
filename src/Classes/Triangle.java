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
public class Triangle extends TwoDShapes implements Cloneable {

    private int x1, x2, y1, y2, x3, y3;

    public Triangle(int x1, int x2, int y1, int y2, int x3, int y3, boolean fill, Color color) {
        super(fill, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
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

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public void draw(Graphics g) {
        DrawFactory s=new DrawFactory();
        s.drawTriangle(this, g);
    }

    public void fill(Graphics g) {
        FillFactory s=new FillFactory();
        s.drawTriangle(this, g);
    }

    @Override
    public boolean contains(int x, int y) {
        
       ShapeDecorator s = new ShapeDecorator();
        java.awt.Polygon r = null;
        r = s.selectTriangle(this);
        return r.contains(x, y);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Triangle r = (Triangle) super.clone();
        r.setX1(x1 + 15);
        r.setX2(x2 + 16);
        return r;
    }
    public Object undoclone() throws CloneNotSupportedException {
        Triangle r = (Triangle) super.clone();
        r.setX1(x1 );
        r.setX2(x2 );
        r.setY1(y1 );
        r.setY2(y2 );
        return r;
    }

}
