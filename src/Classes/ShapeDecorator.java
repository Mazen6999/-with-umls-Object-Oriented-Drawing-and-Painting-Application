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
public class ShapeDecorator {

    public java.awt.Rectangle selectrectangle(Rectangle r) {
        java.awt.Rectangle k = null;
        r = new Rectangle(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        if (x1 < x2 && y1 < y2) {
            k = new java.awt.Rectangle(x1, y1, x2 - x1, y2 - y1);
        } else if (x1 > x2 && y1 > y2) {
            k = new java.awt.Rectangle(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else if (x1 < x2 && y1 > y2) {
            k = new java.awt.Rectangle(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            k = new java.awt.Rectangle(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        return k;
    }

    public java.awt.Rectangle selectcircle(Circle r) {
        java.awt.Rectangle k = null;
        r = new Circle(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        if (x1 < x2 && y1 < y2) {
            k = new java.awt.Rectangle(x1, y1, Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 > y2) {
            k = new java.awt.Rectangle(x1 - Math.abs(y2 - y1), y1 - Math.abs(y2 - y1), Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            k = new java.awt.Rectangle(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
        } else {
            k = new java.awt.Rectangle(x1, y2, Math.abs(y2 - y1), Math.abs(y2 - y1));
        }
        return k;
    }

    public java.awt.Rectangle selectline(Line r) {
        java.awt.Rectangle k = null;
        r = new Line(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        if (x2 > x1 && y2 > y1) {
            k = new java.awt.Rectangle(x1, y1, Math.abs(x1 - x2), Math.abs(y2 - y1));
        } else if (x2 < x1 && y2 > y1) {
            k = new java.awt.Rectangle(x2, y1, Math.abs(x1 - x2), Math.abs(y2 - y1));
        } else if (x2 > x1 && y2 < y1) {
            k = new java.awt.Rectangle(x1, y2, Math.abs(x1 - x2), Math.abs(y2 - y1));
        } else if (x2 < x1 && y2 < y1) {
            k = new java.awt.Rectangle(x2, y2, Math.abs(x1 - x2), Math.abs(y2 - y1));
        }
        return k;
    }

    public java.awt.Rectangle selectsquare(Square r) {
        java.awt.Rectangle k = null;
        r = new Square(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        if (x1 < x2 && y1 < y2) {
            k = new java.awt.Rectangle(x1, y1, Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 > y2) {
            k = new java.awt.Rectangle(x1 - Math.abs(y2 - y1), y1 - Math.abs(y2 - y1), Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            k = new java.awt.Rectangle(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
        } else {
            k = new java.awt.Rectangle(x1, y2, Math.abs(y2 - y1), Math.abs(y2 - y1));
        }
        return k;
    }

    public java.awt.Polygon selectTriangle(Triangle r) {
        java.awt.Polygon k = null;
        r = new Triangle(r.getX1(), r.getX2(), r.getY1(), r.getY2(), r.getX3(), r.getY3(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y3 = r.getY3();
        int b = Math.abs(x1 + (x2 - x1) / 2);
        k = new java.awt.Polygon(new int[]{x1, x2, b}, new int[]{y1, y1, y3}, 3);
        return k;
    }

}
