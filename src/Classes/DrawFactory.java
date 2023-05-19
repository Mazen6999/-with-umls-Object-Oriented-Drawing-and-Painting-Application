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
public class DrawFactory extends AbstractFactory{

    public DrawFactory() {
    }

    @Override
    public void drawrectangle(Rectangle r, Graphics g) {
        r = new Rectangle(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        g.setColor(r.getColor());
        if (x1 < x2 && y1 < y2) {
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        } else if (x1 > x2 && y1 > y2) {
            g.drawRect(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else if (x1 < x2 && y1 > y2) {
            g.drawRect(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            g.drawRect(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void drawcircle(Circle r, Graphics g) {
        r = new Circle(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        g.setColor(r.getColor());
        if (x1 < x2 && y1 < y2) {
            g.drawOval(x1, y1, Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 > y2) {
            g.drawOval(x1 - Math.abs(y2 - y1), y1 - Math.abs(y2 - y1), Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            g.drawOval(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
        } else {
            g.drawOval(x1, y2, Math.abs(y2 - y1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void drawline(Line r, Graphics g) {
        r = new Line(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        g.setColor(r.getColor());
        g.drawPolygon(new int[]{x1, x2}, new int[]{y1, y2}, 2);
    }

    @Override
    public void drawSquare(Square r, Graphics g) {
        r = new Square(r.getX1(), r.getY1(), r.getX2(), r.getY2(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y2 = r.getY2();
        g.setColor(r.getColor());
        if (x1 < x2 && y1 < y2) {
            g.drawRect(x1, y1, Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 > y2) {
            g.drawRect(x1 - Math.abs(y2 - y1), y1 - Math.abs(y2 - y1), Math.abs(y2 - y1), Math.abs(y2 - y1));
        } else if (x1 > x2 && y1 < y2) {
            g.drawRect(x2, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));
        } else {
            g.drawRect(x1, y2, Math.abs(y2 - y1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void drawTriangle(Triangle r, Graphics g) {
        r = new Triangle(r.getX1(), r.getX2(), r.getY1(), r.getY2(), r.getX3(), r.getY3(), r.getFill(), r.getColor());
        int x1 = r.getX1();
        int y1 = r.getY1();
        int x2 = r.getX2();
        int y3 = r.getY3();
        g.setColor(r.getColor());
        int x = Math.abs(x1 + (x2 - x1) / 2);
        g.drawPolygon(new int[]{x1, x2, x}, new int[]{y1, y1, y3}, 3);
    }

}
