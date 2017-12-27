//package edu.buffalostate.cis425.sp17.assignments.marron;

/**

 File: LeftRightPanel.java
 Exercise 14  - LeftRightPanel
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.11.2017
 Last Modified: 2.2.2017

  Description: This class defines a GUI in a JPanel which contains
  two JButtons with initial labels "Left", "Right", and "Center" and a
  JTextField. Pressing a button causes the label of that button
  to be printed into the textfield.

  Assignment: 1) Create a centerButton (label it "Center")
              2) Create another JPanel
              3) Add the Left,Center,Right Buttons to the JPanel
                 in step 2
              4) Change the Layout Manager of LeftRightPanel to
                 BorderLayout
              5) Place the JPanel of step 2 in the center position
                 of LeftRightPanel
              6) Place the JTextField( outField ) in the south
                 position of LeftRightPanel
              7) Change the ActionEvent code so the pressing the
                 centerButton displays "center' in the outField
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeftRightPanel extends JPanel implements ActionListener
{
    private JButton leftButton, rightButton, centerButton;

    private JTextField outField;

    public LeftRightPanel()
    {
        //creates new Jpanel and sets the border layout
        JPanel panel = new JPanel(new BorderLayout());

        //sets buttons
        leftButton = new JButton("Left");
        leftButton.addActionListener(this);

        rightButton = new JButton("Right");
        rightButton.addActionListener(this);

        centerButton = new JButton("Center");
        centerButton.addActionListener(this);

        outField = new JTextField(10);

        //adds the buttons and outfield to the new panel
        panel.add(leftButton, BorderLayout.EAST);
        panel.add(centerButton, BorderLayout.CENTER);
        panel.add(rightButton, BorderLayout.WEST);
        panel.add(outField, BorderLayout.SOUTH);

        //adds the new panel to the existing panel
        add(panel);

    }//END LeftRightPanel

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();
        outField.setText( b.getText() );

    } //END actionPeformed()
} //END LeftRightPanel class