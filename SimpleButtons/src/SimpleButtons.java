//package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: SimpleButtons.java
 CIS400 Assignment 3 - Create a Button GUI Program
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron with contributions from Oracle
    Source: https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java
 Date Created:  2.3.2017
 Last Modified: 2.4.2017

 This program - creates a multi button interface which sends the label of the button to a text field
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleButtons extends JFrame {
    private JButton button0, button1, button2, button3;
    private JTextField outField;
    final static int maxGap = 20;

    GridLayout experimentLayout = new GridLayout(0,2);

    public SimpleButtons(String name) {
        super(name);
        setResizable(false);//prevents the window from being resized
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        outField = new JTextField(10);
    }//END SimpleButtons constructor


    /** addComponentsToPane - adds the buttons and outField to separate panels.
     *This also defines their characteristics and adds them to the Container pane
     * @param pane - where the content panels get added to
     */
    public void addComponentsToPane(final Container pane) {

        final JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(experimentLayout);
        JPanel outputField = new JPanel();//creates a new panel for the output field
        outputField.setLayout(new GridLayout());

        //Set up components preferred size
        JButton b = new JButton("NULL");
        Dimension buttonSize = b.getPreferredSize();
        ButtonPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 4.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

        //Add buttons to experiment with Grid Layout
        ButtonPanel.add(button0);
        ButtonPanel.add(button1);
        ButtonPanel.add(button2);
        ButtonPanel.add(button3);

        //adds the outField to the outputField
        outputField.add(outField);

        //sets the actions of the returnText ActionListener
        ActionListener returnText = (new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton c = (JButton) e.getSource();
                outField.setText(c.getText());
            }
        });//END ActionListener returnText

        //sets the returnText actionListener to all of the buttons
        button0.addActionListener(returnText);
        button1.addActionListener(returnText);
        button2.addActionListener(returnText);
        button3.addActionListener(returnText);

        pane.add(ButtonPanel, BorderLayout.NORTH);//adds the ButtonPanel pane to the north position
        pane.add(outputField, BorderLayout.SOUTH);//adds the outputField pane to the south position
    }// END addComponentsToPane

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        SimpleButtons frame = new SimpleButtons("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /** main */
    public static void main(String[] args) {
                createAndShowGUI();
    }//END main
}//END SimpleButtons
