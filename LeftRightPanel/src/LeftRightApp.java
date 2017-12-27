//package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 * File: LeftRightApp.java
 *
 * Description: This program creates a LeftRightPanel and
 *  adds it to the Frame's content pane and sets its size.
 *
 * Assignment: See LeftRightPanel.java
 *
 */
import javax.swing.*;

public class LeftRightApp extends JFrame
{
    public LeftRightApp()
    {
        getContentPane().add(new LeftRightPanel());
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } //END LeftRightFrame() constructor


    public static void main(String args[]){
        LeftRightApp aframe = new LeftRightApp();
        aframe.setSize(600,400);
        aframe.setVisible(true);
    } //END main()

} //END LeftRightFrame class