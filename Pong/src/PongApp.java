//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: PongApp.java
 Exercise 17 - Pong
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017

  Description:  In the game of pong a ball ricochets off
   by the up the walls of a square. The paddle on the right wall
   is controlled and down arrow keys. The ball bounces at a random
   angle of the paddle and the walls.

  DO NOT SUBMIT A SOLUTION THAT WAS DOWNLOADED - USE THIS TEMPLATE

  Assignment: 1) This is a fun game, so let's make it more exciting!
                 - Add to this program a mouse capability. As the mouse
                   is moved up and down, the paddle should move up and
                   down too.
              2) When a ball misses the paddle and hits the right wall,
                 the ball should disappear - the user will have to
                 launch another ball
              3) Add some kind of scoring capability to the game
                 - award the player skill points
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongApp extends JFrame implements MouseMotionListener, KeyListener{
    private Thread ball;
    private Paddle paddle;
    private int ComputerScore, UserScore;

    public final int BORDER=50, SIZE=400;

    // int mouseX=-1;
     int mouseY=-1;

    /**
     *  Constructor: creates the ball and paddle objects, and registers as the
     *  KeyListener. It also must requestFocus() so that it will receive
     *  key events.
     */
    public PongApp() {
        ComputerScore=UserScore=0;
        setSize(400,400);
        setBackground(Color.white);
        requestFocus();                         // Required to receive key events
        addKeyListener(this);
        // HINT:
        addMouseMotionListener(this);
        paddle = new Paddle(this);              // Create the paddle
        ball = new Thread(new Ball(this));      // Create the ball
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } // PongApp

    /**
     * startGame(): starts the ball (which causes it to draw) and draws the paddle.
     */

    public void startGame() {
        ball.start();
        repaint();
    }//END startGame

    /**
     * paint() starts the ball (which causes it to draw) and draws the paddle.
     */
    public void paint (Graphics g ) {
        g.setColor(Color.white);
        g.fillRect(0,0,SIZE,SIZE);
        g.setColor(Color.red);                  // Draw the bouncing region
        g.drawRect(BORDER,BORDER,SIZE-2*BORDER,SIZE-2*BORDER);
        g.setColor(Color.blue);

        g.drawString("Score: User: " + UserScore + " Computer: " + ComputerScore, 10,40);
        g.drawString("Press up/down arrow keys or move the mouse to move paddles",10,370);

        if (!ball.isAlive() )
            g.drawString("Ball Died!, You Lose! - Hit Space", 10, 385);

        paddle.draw();                          // And draw the paddle
    } //END paint()

    /**
     * hitPaddle() is the callback routine called by ball to check whether it
     *  hit the paddle.
     * @param p -- A Point giving the ball's location
     * @return -- a boolean set to true if the paddle and ball are touching
     */
    public boolean hitPaddle(Point p) {
        Point paddleLoc = paddle.getLocation();
        if ( p.x + Ball.SIZE >= paddleLoc.x
                && p.y >= paddleLoc.y
                && p.y <= paddleLoc.y + Paddle.SIZE)
            return true;
        else
            return false;
    } //END hitPaddle()

    /**
     * informGame() is the callback routine called by ball when it dies
     *
     */

    public void informGame() {
        repaint();
        return;
    }//END informGame

    /**
     * keyTyped() is invoked every time a KeyEvent occurs. The getKeyChar()
     *  method gets the value of the key that was pressed. Whenever the
     *  spacebar is pressed, a new bouncing ball is introduced into the applet.
     */
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {    // If spacebar pressed
            if (!ball.isAlive() ) {     // and current ball is dead
                ball = new Thread(new Ball(this));
                ball.start();
                repaint();
            }
        }
    } //END keyType()


    /**
     *  keyPressed() is invoked every time a KeyEvent occurs. It gets the key's code
     *  and checks whether the up or down arrow keys were pressed. If so it moves
     *  the paddle.
     */
    public void keyPressed( KeyEvent e) {  // Check for arrow keys
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_UP)            // Up arrow
            paddle.moveUp();
        else if (keyCode == e.VK_DOWN)     // Down arrow
            paddle.moveDown();
    } //END KeyPressed()


    public void keyReleased( KeyEvent e ) {
    } //END keyReleased() - unused


	public void mouseDragged( MouseEvent e ) {}//END mouseDragged

    /**
     *  mouseMoved() is invoked every time the mouse is moved.  If the y coordinate
     *  is less than the previous y coordinate the paddle moves up. Else if the y coordinate
     *  is greater than the previous y coordinate the paddle moves down.
     */
    public void mouseMoved( MouseEvent e ) {
        //int x = e.getX();
        int y = e.getY();

        if (y < mouseY)//tests current value to previous
            paddle.moveUp();
        else if (y> mouseY)
            paddle.moveDown();

        mouseY=y;//updates y coordinate
    }//END mouseMoved

    /**getComputerScore() - increases the computer score by 1 */
    public void getComputerScore(){
        ComputerScore ++;
    }//END getComputerScore

    /**getUserScore() - increases the user score by 1 */
    public void getUserScore(){
        UserScore ++;
    }//END getUserScore

    /** main */
    public static void main(String args[]) {
        PongApp p = new PongApp();
        p.setVisible(true);
        p.startGame();
    } //END main()

} //END PongApp

