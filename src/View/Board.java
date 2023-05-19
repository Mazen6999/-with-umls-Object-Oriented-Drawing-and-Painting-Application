/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Circle;
import Classes.Line;
import Classes.Rectangle;
import Classes.Shape;
import Classes.Square;
import Classes.Triangle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Mazen
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener, Cloneable {

    // public instance initialized when loading the class
    private static Board p = null;

    private Board() {
        // private constructor
        x = new ArrayList<>();
        redotemp = new ArrayList<>();
        resizeTemp = new ArrayList<>();
        delTemp = new ArrayList<>();
        moveTemp = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public static Board getInstance() {
        if (p == null) {
            p = new Board();
        }
        return p;
    }

    public void Drawshape(int i, Graphics d) {
        if (x.get(i) instanceof Line) {
            Line l = (Line) x.get(i);
            l.draw(d);
        } else if (x.get(i) instanceof Rectangle) {
            Rectangle r = (Rectangle) x.get(i);
            if (r.getFill() == false) {
                r.draw(d);
            } else if (r.getFill() == true) {
                r.fill(d);
            }
        } else if (x.get(i) instanceof Circle) {
            Circle c = (Circle) x.get(i);
            if (c.getFill() == false) {
                c.draw(d);
            } else if (c.getFill() == true) {
                c.fill(d);
            }
        } else if (x.get(i) instanceof Square) {
            Square s = (Square) x.get(i);
            if (s.getFill() == false) {
                s.draw(d);
            } else if (s.getFill() == true) {
                s.fill(d);
            }
        } else if (x.get(i) instanceof Triangle) {
            Triangle t = (Triangle) x.get(i);
            if (t.getFill() == false) {
                t.draw(d);
            } else if (t.getFill() == true) {
                t.fill(d);
            }
        }
    }

    private Shape selectedshape = null;
    int xdrag, ydrag;
    int x1, y1;
    int x2, y2;
    int x3, y3;
    boolean fill = false;
    int mode = -1;
    Color currentcolor = Color.red;
    int[] undomode = new int[100];
    int[] redomode = new int[100];
    int delx1, delx2, dely1, dely2, dely3, delx3;
    int undocount = 1;
    int redocount = 1;
    ArrayList<Shape> x;
    ArrayList<Shape> redotemp;
    ArrayList<Shape> resizeTemp;
    ArrayList<Shape> moveTemp;
    ArrayList<Shape> delTemp;

    @Override
    protected void paintComponent(Graphics d) {
        super.paintComponent(d);
        for (int i = 0; i < x.size(); i++) {
            Drawshape(i, d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        undomode[0] = 10;
        redomode[0] = 10;
        if (mode == 0) {
            Line l = new Line(x1, y1, x1, y1, currentcolor);
            x.add(l);
            System.out.println("added null to resizeTemp");
            repaint();
        } else if (mode == 1) {
            Rectangle r = new Rectangle(x1, y1, x1, y1, fill, currentcolor);
            x.add(r);
            repaint();
        } else if (mode == 2) {
            Circle c = new Circle(x1, y1, x1, y1, fill, currentcolor);
            x.add(c);
            repaint();
        } else if (mode == 3) {
            Square s = new Square(x1, y1, x1, y1, fill, currentcolor);
            x.add(s);
            repaint();
        } else if (mode == 4) {
            Triangle t = new Triangle(x1, x1, y1, y1, x1, y1, fill, currentcolor);
            x.add(t);
            repaint();
        } else if (mode == 5) { // resize

            for (int i = x.size() - 1; i >= 0; i--) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        System.out.println("selected shape");
                        selectedshape = x.get(i);
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (selectedshape instanceof Circle) {
                Circle l = (Circle) selectedshape;
                try {
                    Circle r = (Circle) l.undoclone();
                    resizeTemp.add(r);
                    undocount++;
                    undomode[undocount] = 1;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Line) {
                Line l = (Line) selectedshape;
                try {
                    Line r = (Line) l.undoclone();
                    resizeTemp.add(r);
                    undocount++;
                    undomode[undocount] = 1;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Rectangle) {
                Rectangle l = (Rectangle) selectedshape;
                try {
                    Rectangle r = (Rectangle) l.undoclone();
                    resizeTemp.add(r);
                    undocount++;
                    undomode[undocount] = 1;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Square) {
                Square l = (Square) selectedshape;
                try {
                    Square r = (Square) l.undoclone();
                    resizeTemp.add(r);
                    undocount++;
                    undomode[undocount] = 1;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Triangle) {
                Triangle l = (Triangle) selectedshape;
                try {
                    Triangle r = (Triangle) l.undoclone();
                    resizeTemp.add(r);
                    undocount++;
                    undomode[undocount] = 1;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (mode == 6) { //move
            for (int i = x.size() - 1; i >= 0; i--) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        System.out.println("selected shape");
                        selectedshape = x.get(i);
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (selectedshape instanceof Circle) {
                Circle l = (Circle) selectedshape;
                try {
                    Circle r = (Circle) l.undoclone();
                    moveTemp.add(r);
                    undocount++;
                    undomode[undocount] = 3;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Line) {
                Line l = (Line) selectedshape;
                try {
                    Line r = (Line) l.undoclone();
                    moveTemp.add(r);
                    undocount++;
                    undomode[undocount] = 3;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Rectangle) {
                Rectangle l = (Rectangle) selectedshape;
                try {
                    Rectangle r = (Rectangle) l.undoclone();
                    moveTemp.add(r);
                    undocount++;
                    undomode[undocount] = 3;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Square) {
                Square l = (Square) selectedshape;
                try {
                    Square r = (Square) l.undoclone();
                    moveTemp.add(r);
                    undocount++;
                    undomode[undocount] = 3;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (selectedshape instanceof Triangle) {
                Triangle l = (Triangle) selectedshape;
                try {
                    Triangle r = (Triangle) l.undoclone();
                    moveTemp.add(r);
                    undocount++;
                    undomode[undocount] = 3;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (mode == 7) { //delete
            int i;
            for (i = x.size() - 1; i >= 0; i--) {
                if (x.get(i).contains(x1, y1)) {
                    System.out.println("deleted shape");
                    delTemp.add(x.get(i));
                    undocount++;
                    undomode[undocount] = 2;
                    x.remove(i);
                    break;
                }
            }
            repaint();
        } else if (mode == 8) { // copy
            int i;
            for (i = x.size() - 1; i >= 0; i--) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        System.out.println("shape copied");
                        selectedshape = x.get(i);
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (selectedshape != null) {
                System.out.println("added null to resizeTemp");
                if (selectedshape instanceof Circle) {
                    Circle l = (Circle) selectedshape;
                    try {
                        Circle r = (Circle) l.clone();
                        x.add(r);
                        undocount++;
                        undomode[undocount] = 5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedshape instanceof Line) {
                    Line l = (Line) selectedshape;
                    try {
                        Line r = (Line) l.clone();
                        x.add(r);
                        undocount++;
                        undomode[undocount] = 5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedshape instanceof Rectangle) {
                    Rectangle l = (Rectangle) selectedshape;
                    try {
                        Rectangle r = (Rectangle) l.clone();
                        x.add(r);
                        undocount++;
                        undomode[undocount] = 5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedshape instanceof Square) {
                    Square l = (Square) selectedshape;
                    try {
                        Square r = (Square) l.clone();
                        x.add(r);
                        undocount++;
                        undomode[undocount] = 5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (selectedshape instanceof Triangle) {
                    Triangle l = (Triangle) selectedshape;
                    try {
                        Triangle r = (Triangle) l.clone();
                        x.add(r);
                        undocount++;
                        undomode[undocount] = 5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                repaint();
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (mode == 5) {
            x2 = me.getX();
            y2 = me.getY();
            if (selectedshape instanceof Rectangle) {
                Rectangle r = (Rectangle) selectedshape;
                int temp;
                if (x2 > r.getX1() && y2 > r.getY1()) {
                    r.setX2(x2);
                    r.setY2(y2);
                } else if (x2 < r.getX1() && y2 > r.getY1()) {
                    temp = r.getX1();
                    r.setX1(x2);
                    r.setX2(temp);
                } else if (x2 > r.getX1() && y2 < r.getY1()) {
                    temp = r.getY1();
                    r.setY1(y2);
                    r.setY2(temp);
                } else if (x2 < r.getX1() && y2 < r.getY1()) {
                    temp = r.getX1();
                    r.setX1(x2);
                    r.setX2(temp);
                    temp = r.getY1();
                    r.setY1(y2);
                    r.setY2(temp);
                }
                repaint();
            }
        }
        selectedshape = null;
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(cursor);
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }
            repaint();
        } else if (mode == 1) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 2) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.setX2(x2);
                c.setY2(y2);
            }
            repaint();
        } else if (mode == 3) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Square) {
                Square c = (Square) s;
                c.setX2(x2);
                c.setY2(y2);
            }
            repaint();
        } else if (mode == 4) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Triangle) {
                Triangle c = (Triangle) s;
                c.setX2(x2);
                c.setY3(y2);
            }
            repaint();
        } //resize
        else if (mode == 5) {
            x2 = me.getX();
            y2 = me.getY();
            if (selectedshape != null) {
                Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
                setCursor(cursor);
                if (selectedshape instanceof Line) {
                    Line r = (Line) selectedshape;
                    r.setX2(x2);
                    r.setY2(y2);
                    repaint();
                } else if (selectedshape instanceof Rectangle) {
                    Rectangle r = (Rectangle) selectedshape;
                    r.setX2(x2);
                    r.setY2(y2);
                    repaint();
                } else if (selectedshape instanceof Circle) {
                    Circle r = (Circle) selectedshape;
                    r.setX2(x2);
                    r.setY2(y2);
                    repaint();
                } else if (selectedshape instanceof Square) {
                    Square r = (Square) selectedshape;
                    r.setX2(x2);
                    r.setY2(y2);
                    repaint();
                } else if (selectedshape instanceof Triangle) {
                    Triangle r = (Triangle) selectedshape;
                    r.setX2(x2);
                    r.setY3(y2);
                    repaint();
                }
            }//end of resize
        } else if (mode == 6) {//move
            x2 = me.getX();
            y2 = me.getY();
            if (selectedshape instanceof Line) {
                Line l = (Line) selectedshape;
                int length = l.getX2() - l.getX1();
                int height = l.getY2() - l.getY1();
                l.setX1(x2 - length);
                l.setY1(y2 - height);
                l.setX2(x2);
                l.setY2(y2);
                repaint();
            }
            if (selectedshape instanceof Rectangle) {
                Rectangle r = (Rectangle) selectedshape;
                int length = r.getX2() - r.getX1();
                int height = r.getY2() - r.getY1();
                r.setX1(x2 - length);
                r.setY1(y2 - height);
                r.setX2(x2);
                r.setY2(y2);
                repaint();
            }
            if (selectedshape instanceof Square) {
                Square r = (Square) selectedshape;
                int length = Math.abs(r.getY2() - r.getY1());
                r.setX1(x2 - length);
                r.setY1(y2 - length);
                r.setX2(x2);
                r.setY2(y2);
                repaint();
            }
            if (selectedshape instanceof Circle) {
                Circle r = (Circle) selectedshape;
                int length = Math.abs(r.getY2() - r.getY1());
                r.setX1(x2 - length);
                r.setY1(y2 - length);
                r.setX2(x2);
                r.setY2(y2);
                repaint();
            }
            if (selectedshape instanceof Triangle) {
                Triangle r = (Triangle) selectedshape;
                int height = Math.abs(r.getY3() - r.getY1());
                int length = r.getX2() - r.getX1();
                if (r.getY3() > r.getY1()) {
                    r.setY3(y2 + height);
                }
                if (r.getY3() < r.getY1()) {
                    r.setY3(y2 - height);
                }
                r.setX1(x2 - length);
                r.setY1(y2);
                r.setX2(x2);
                r.setY2(y2);
                repaint();
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        if (mode == 5) {
            Cursor cursor;
            int found = 0;
            for (int i = 0; i < x.size(); i++) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        found = 1;
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (found == 1) {
                cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
                setCursor(cursor);
            } else if (found == 0) {
                cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                setCursor(cursor);
            }
        } else if (mode == 6) {
            Cursor cursor;
            int found = 0;
            for (int i = 0; i < x.size(); i++) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        found = 1;
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (found == 1) {
                cursor = new Cursor(Cursor.MOVE_CURSOR);
                setCursor(cursor);
            } else if (found == 0) {
                cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                setCursor(cursor);
            }
        } else if (mode == 7) {
            Cursor cursor;
            int found = 0;
            for (int i = 0; i < x.size(); i++) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        found = 1;
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (found == 1) {
                cursor = new Cursor(Cursor.HAND_CURSOR);
                setCursor(cursor);
            } else if (found == 0) {
                cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                setCursor(cursor);
            }
        } else if (mode == 8) {
            Cursor cursor;
            int found = 0;
            for (int i = 0; i < x.size(); i++) {
                try {
                    if (x.get(i).contains(x1, y1)) {
                        found = 1;
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            if (found == 1) {
                cursor = new Cursor(Cursor.HAND_CURSOR);
                setCursor(cursor);
            } else if (found == 0) {
                cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                setCursor(cursor);
            }
        }
    }

}
