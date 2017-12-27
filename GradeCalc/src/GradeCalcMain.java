package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: GradeCalcMain.java
 Exercise 10 - Grade Calc
 Programmer: Jeffrey Marron
 Date Created:  12.23.2016
 Last Modified: 1.24.2017
 Description: This program creates a GradeCalcPanel and
    adds it to the Frame's content pane and sets its size.
 */

import javax.swing.*;

public class GradeCalcMain extends JFrame
{
    public GradeCalcMain()
    {
        getContentPane().add(new GradeCalcPanel());
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } //END GradeCalcFrame() constructor************************

    public static void main(String args[]){

        // change GUI so that it looks like Windows GUI, don't worry about this now
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {}

        GradeCalcMain aframe = new GradeCalcMain();
        aframe.setSize(650,85);
        aframe.setVisible(true);
    } //END main

} //END GradeCalcMain class
