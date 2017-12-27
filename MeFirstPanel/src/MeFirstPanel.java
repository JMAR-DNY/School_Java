package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: MeFirstPanel.java
 Exercise 13 - MeFirstPanel
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.17.17
 Last Modified: 1.24.17

  Description: This class defines a GUI in a JPanel which contains
  two JButton with initial labels "Me first!" and "Me next!".
  Pressing either button causes the labels to be exchanged.

  Assignment: 1) Add a third button to the panel, with the label "third"
              2) Every time any of the buttons are pressed, the labels
                 should shift one place to the right first->second->third
                 would shift to third->first->second when one of the buttons
                 was pressed
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeFirstPanel extends JPanel implements ActionListener
{
    private JButton aButton, bButton, cButton;
    String aText = "first", bText = "second", cText = "third";

    String tempText; // To use to exchange labels

    public MeFirstPanel()
    {
        aButton = new JButton(aText);
        aButton.addActionListener(this); // add event handler
        bButton = new JButton(bText);
        bButton.addActionListener(this); // add event handler
        cButton = new JButton(cText);
        cButton.addActionListener(this); // add event handler

        add(aButton); // add button to JPanel
        add(bButton); // add button to JPanel
        add(cButton); // add button to JPanel
    }


    public void actionPerformed(ActionEvent e)
    {
        tempText = aText;  // Exchange the strings
        aText = cText;
        cText = bText;
        bText = tempText;

        aButton.setText(aText); // Set button labels
        bButton.setText(bText);
        cButton.setText(cText);


    } //END actionPeformed
} //END MeFirstPanel
