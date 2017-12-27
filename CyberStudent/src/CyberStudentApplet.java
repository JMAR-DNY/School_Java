package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: CyberStudentApplet.java
 Exercise 11 - CyberStudent
 Programmer: Jeffrey Marron with contributions from Catherine Beise, PhD
 Source:http://ruby.fgcu.edu/courses/cbeise/3232/ch4/cyberpet.txt
 Date Created:  12.26.2016
 Last Modified: 1.24.2017
  Description: This apply provides a graphical user
   interface to the CyberStudent class. The interface consists
   of two Buttons that can be clicked to tell the CyberStudent
   to eat or drink, and a TextField which reports the
   CyberStudent's state.

   The interface is initialized in the init() method and
   user actions are handled in the actionPerformed() method.
   Create a CyberStudent class (similar to CyberStudent) with the following characteristics/properties:

CyberStudent has 2 basic states and each of these basic states have several substates:
    a) awake
    Substates:

        eating
        working

    b) sleeping
    Substates:

        dreaming
        snoring

A constructor that accepts a String object which is the name of the newly created CyberStudent, which is initially sleeping and dreaming
CyberStudent has 2 basic methods that change the state of the CyberStudent to one of the 2 basic allowable states:
    boolean Awake( int Substate )
    boolean Sleep( int Substate )

Check the substate parameter ( int Substate ) in the above methods for consistency (within range) before changing the state (and substate).
 Return true if state was successfully changed, false otherwise. If there is a problem, return false without changing anything.

In addition, create mutator methods for each of the substates:
boolean Eat( ), Work( ), Dream( ), Snore( )
Each of these substate mutator methods should check for consistency, for example, a Cyberstudent in the awake state cannot be placed in the
substate snoring. Return true if substate was changed, false otherwise.

CyberStudent has 2 accessor methods:

    getState( ): returns a String object giving the current state (and substate) of the CyberStudent
    getName( ): returns a String object giving the name of the CyberStudent object.

 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CyberStudentApplet extends Applet implements ActionListener
{
    // Declare instance variables
    private CyberStudent student1;                   // The CyberStudent
    private Label nameLabel;                 // A Label
    private TextField stateField;            // A TextField
    private Button wakeButton, sleepButton, eatButton, workButton,
    dreamingButton, snoringButton;   // Two Buttons

    int subState;
    /*
     * The init() method instantiates the instance variables, including both the
     * CyberStudent (student1) and the GUI elements that are displayed on the applet.
     */
    public void init()
    {
        student1 = new CyberStudent("Socrates");   // student1
        student1.sleep(3);
        student1.sleep(4);
        // Create the GUI components

        nameLabel = new Label("Hi! My name is " + student1.getName() +
                " and currently I am : ");
        stateField = new TextField(18);
        wakeButton = new Button("Wake");     // Buttons
        wakeButton.addActionListener(this);    // Assign the listeners.
        sleepButton = new Button("Sleep");
        sleepButton.addActionListener(this);

        eatButton = new Button("Eat");
        eatButton.addActionListener(this);

        workButton = new Button("Work");
        workButton.addActionListener(this);

        dreamingButton = new Button("Dream");
        dreamingButton.addActionListener(this);

        snoringButton = new Button("Snore");
        snoringButton.addActionListener(this);

        // Initialize the TextField

        stateField.setText(student1.getState());
        stateField.setEditable(false);

        // Add the components to the applet.

        add(nameLabel);
        add(stateField);

        add(wakeButton);
        add(sleepButton);
        add(eatButton);
        add(workButton);
        add(dreamingButton);
        add(snoringButton);

        setSize(300,150);          // Set the applet's size to 300 x 150 pixels
    } // init

    /**
     * The actionPerformed() method is called whenever
     * one of the buttons is pressed.
     */
    public void actionPerformed( ActionEvent e)
    {
        if (e.getSource() == wakeButton)
            student1.wake(0);
        else if (e.getSource() == eatButton)
            student1.wake(1);
        else if (e.getSource() == workButton)
            student1.wake(2);

        else if (e.getSource() == sleepButton)
            student1.sleep(3);
        else if (e.getSource() == dreamingButton)
            student1.sleep(4);
        else if (e.getSource() == snoringButton)
            student1.sleep(5);

        stateField.setText(student1.getState());
    }//END actionPerformed

} //END studentApplet

