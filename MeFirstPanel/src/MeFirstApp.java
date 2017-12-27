package edu.buffalostate.cis425.sp17.exercises.marron;
/**
  File: MeFirstApp.java
  Exercise 13 - MeFirstPanel
  For: CIS 425 Object Oriented Programming
  Programmer: Jeffrey Marron
  Date Created:  1.17.17
  Last Modified: 1.24.17

  Description: This app creates a MeFirstPanel and
  adds it to the app's content pane.

  Assignment: see MeFirstPanel.java

 */

import javax.swing.*;

public class MeFirstApp extends JFrame
{   public MeFirstApp()
{
    setSize(300,100);
    getContentPane().add(new MeFirstPanel());
    //register 'Exit upon closing' as a default close operation
    setDefaultCloseOperation( EXIT_ON_CLOSE );
}

    public static void main(String args[]) {
        MeFirstApp b = new MeFirstApp();
        b.setVisible(true);
    } // main()

} // MeFirstApp class