//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: Canvas.java
 Exercise 19 - ColorPicker
 Programmer: Jeffrey Marron
 Date Created:  2.5.2017
 Last Modified: 2.5.2017

   Description: This class implements a drawing canvas as
     a subclass of JPanel. It is used with the ColorPicker applet.
   It simply displays various shades of a given Color.

  Assignment: See ColorPicker.java

 */

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private final int HREF = 40, VREF = 55;     // Reference points
    private final int WIDTH = 40, HEIGHT = 50;  // Rectangle dimensions
    private final int HGAP = 70,  VGAP = 60;    // Spacing constants

    private Color color = Color.gray;

    /**
     *  setColor() changes the default color for the Canvas.
     *  @param c -- a Color
     */
    public void setColor(Color c) {
        color = c;
    }

    /**
     *  paintComponent() is called each time the canvas needs to be
     *   painted. It draws three strings and three rectangles in
     *   various shades of the Canvas's current color.
     *  @param g -- the Canvas's Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);                        // Make the panel opaque
        g.setColor(color);                              // Set the pen's color
        g.drawString(color.toString(), HREF, VREF-15 ); // Draw the color's RGB's
        g.fillRect(HREF, VREF, WIDTH, HEIGHT);          // Color a rectangle
        g.drawString("color", HREF, VREF+VGAP);
        g.setColor(color.brighter());                   // Brighten the color
        g.fillRect(HREF+HGAP, VREF, WIDTH, HEIGHT);
        g.drawString("brighter", HREF+HGAP, VREF+VGAP);
        g.setColor(color.darker());                     // Darken the color
        g.fillRect(HREF+HGAP*2, VREF, WIDTH, HEIGHT);
        g.drawString("darker", HREF+HGAP*2, VREF+VGAP);
    } // paintComponent()
} // Canvas

