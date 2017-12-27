//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: CDInterestApp.java
 Exercise 15 - CDInterest
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017
  Description: This program creates a CDInterestPanel and
   adds it to the Frame's content pane and sets its size.

  Assignment: See CDInterestPanel.java file

 */


import javax.swing.*;

public class CDInterestApp extends JFrame
{
    public CDInterestApp()
    {
        getContentPane().add(new CDInterestPanel());
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } //END CDInterestFrame() constructor

    public static void main(String args[]){
        CDInterestApp aframe = new CDInterestApp();
        aframe.setSize(450,185);
        aframe.setResizable(false);
        aframe.setVisible(true);
    } //END main()

} //END CDInterestFrame class

