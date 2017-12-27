//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: Ball.java
 Exercise 18 - Bounce
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017

 * Description: This class defines a ball that bounces up and
 *  down within an applet. The "bouncing" is effected by repeatedly
 *  drawing, and erasing and moving the ball in the run() method.
 *  Note the use class constants in the program
 *
 * In this version of Ball, instead of starting every Ball in the center
 *  of the bounce area, each ball is given a random x-coordinate. So each
 *  bounces in its own vertical space. Also, the balls bounce at random
 *  angles off of the four walls. The randomness is introduced by changing
 *  the y-coordinate by a random amount between -4 and +4 each time the
 *  ball bounces off either the right or left wall. This changes the angle
 *  of the ball's motion.
 *
 * Assignment: See BounceApp for more information
 *
 *
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Ball extends Thread implements Runnable {

    Random rand = new Random();              //used for random color generator

    private static final int SIZE = 5;       // Diameter of the ball

    private int SizeX = ThreadLocalRandom.current().nextInt(MINDY, MAXDY + 1);//random X size value
    private int SizeY = ThreadLocalRandom.current().nextInt(MINDY, MAXDY + 1);//random Y size value

    float r = rand.nextFloat();//random red
    float d = rand.nextFloat();//random green
    float b = rand.nextFloat();//random blue

    private static final int DX = 5;        // Number of pixels to move the ball
    private static final int DY = 5;        // Number of pixels to move the ball
    //    private static final int BORDER = 50;   // A 50 pixel border around drawing area
    private static final int MINDY = -4;    // Used by randomizer: Vertical changes goes from
    private static final int MAXDY = 9;     //   -4 to +4, giving 9 discrete values

    private BounceApp app;                 	// Reference to the app
    private int topWall, bottomWall;        // Boundaries
    private int leftWall, rightWall;        // Boundaries

    private Point location;                 // Current location of the ball
    private int directionX = 1, directionY = 1;  // Ball's x- and y-direction (1 or -1)
    private int deltaY;                      // Change in the Y coordinate
    private Color ballcolor;

    /**
     * Ball() constructor sets a pointer to the app and initializes the ball's location
     *  at the center of the bouncing region
     */
    public Ball(BounceApp f) {
        app = f;
        Graphics g;
        Dimension gameArea = app.getSize();       // Define bouncing region
        rightWall = gameArea.width - app.BORDER - SIZE;  // And location of walls
        leftWall = app.BORDER + 1;
        topWall = app.BORDER + 1;
        bottomWall = gameArea.height - app.BORDER - SIZE;

        int xLoc = app.BORDER + (int)(Math.random() * (gameArea.width - 2*app.BORDER)); // Pick a random xLoc

        location = new Point(xLoc, gameArea.height/2);  // Set initial location

        // HINT: Create a new random color
        ballcolor = new Color(r, d, b);
        synchronized( app ) {  // make sure one ball at a time is allowed to access canvas
            g=app.getGraphics();
            g.setColor(ballcolor);
            g.dispose();
        }

    } // Ball()


    /**
     * erase() erases the ball
     *
     */
    public void erase() {
        synchronized(app) { // only one ball at a time is allowed to do drawing
            Graphics g = app.getGraphics();
            g.setColor(Color.white);
            g.fillOval(location.x, location.y, SizeX, SizeY); //  erase
            g.dispose();
        }
    } // erase()



    /**
     * draw() draws ball
     */
    public void draw() {
        synchronized(app) {				// only one ball at a time is allowed to do drawing
            Graphics g = app.getGraphics();
            g.setColor(ballcolor);
            // HINT: set Oval to random SizeX, SizeY values
            g.fillOval(location.x, location.y, SizeX, SizeY); //  draw
            g.dispose();
        }
    } // draw()



    /**
     * move() changes the ball's vertical location (y-coordinate) by DY pixels.
     *  It then checks if the ball has reached a boundary and if so reverses direction
     */
    public void move() {
        location.x = location.x + DX * directionX; // Calculate a new location
        location.y = location.y + deltaY * directionY;

        if (location.y > bottomWall) {    // If ricochet
            directionY = -directionY;      //  reverse direction
            location.y =  bottomWall;

        }
        if (location.y < topWall) {
            directionY = -directionY;       // Reverse direction
            location.y = topWall;

        }
        if (location.x > rightWall )  {
            directionX = -directionX;
            deltaY = MINDY + (int) (Math.random() * MAXDY); // CHANGE VERTICAL DIRECTION
            location.x =  rightWall;

        }

        if ( location.x < leftWall ) {
            directionX = -directionX;
            deltaY = MINDY + (int) (Math.random() * MAXDY); // CHANGE VERTICAL DIRECTION
            location.x = leftWall;

        }
    } // move()

    /**
     * run() repeatedly draws, erases and moves the ball
     */
    public void run() {
        while (true) {
            draw();                          // Draw
            try {
                sleep(50);
            }
            catch (InterruptedException e) {}
            erase();                        // Erase
            move();                         // Move
        } // while
    } // run()
} // Ball
