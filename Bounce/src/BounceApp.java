//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: BounceApp.java
 Exercise 18 - Bounce
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017
 * Description:  This version allows the user to introduce new balls
 *  by clicking the spacebar. It implements the KeyListener interface.
 *
 *
 * Assignment: 1) Modify this program so that each bouncing ball is
 *                a different shape, size, and color
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BounceApp extends JFrame implements KeyListener {

    public final int SIZE=500;
    public final int BORDER=50;

    private Thread  ball;

    /**
     * init() gets the focus for key events and registers the app
     *  as a KeyListener.
     */
    public BounceApp() {
        setSize(500,500);
        getContentPane().setBackground(Color.white);
        requestFocus();                         // Required to receive key events
        addKeyListener(this);
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void startApp() {
        ball = new Thread(new Ball(this));      // Create and start the ball
        ball.start();
        repaint();
    }


    /**
     * paint() paints a red rectangle for the bouncing region and creates the
     *   first bouncing ball.
     */
    public void paint(Graphics g ) {
        g.setColor(Color.white);
        g.fillRect(0,0,SIZE,SIZE);
        g.setColor(Color.red);                  // Draw the bouncing region
        g.drawRect(BORDER,BORDER,SIZE-2*BORDER,SIZE-2*BORDER); // actually (50,50,400,400)
        g.drawString("Hit space bar to start a new ball", 10, 40);
    } // paint()

    /**
     * keyTyped() is invoked every time a KeyEvent occurs. The getKeyChar()
     *  method gets the value of the key that was pressed. Whenever the
     *  spacebar is pressed, a new bouncing ball is introduced into the applet.
     */
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {    // If spacebar pressed
            ball = new Thread(new Ball(this));
            ball.start();
        }
    } // keyType()

    public void keyReleased( KeyEvent e) {} // Unused part of KeyListener interface
    public void keyPressed( KeyEvent e) {}  // Unused


    public static void main(String args[]) {
        BounceApp b = new BounceApp();
        b.setVisible(true);
        b.startApp();
    } // main()


} // BounceApp

