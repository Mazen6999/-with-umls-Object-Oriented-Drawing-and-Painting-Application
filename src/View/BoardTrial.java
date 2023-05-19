/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import javax.swing.JPanel;



/**
 *
 * @author Mazen
 */
public class BoardTrial extends JPanel {

    @Override
    protected void paintComponent(Graphics d) {
        super.paintComponent(d);
        d.drawLine(10, 10, 100, 10);
        d.drawRect(10, 20, 200, 199);
        d.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
    }
}
