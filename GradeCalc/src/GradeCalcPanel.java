package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: GradeCalcPanel.java
 Exercise 10 - Grade Calc
 Programmer: Jeffrey Marron
 Date Created:  12.23.2016
 Last Modified: 1.24.2017
 Description:
  This class provides a user interface to
  the GradeCalc class, which calculates a student's average
  and letter grade for grades input into a JTextField.
  The interface consists of input and output JTextFields and
  and button to calculate the course average and letter grades.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class GradeCalcPanel extends JPanel implements ActionListener
{
    private JLabel prompt;           // GUI components
    private JTextField inputField;
    private JLabel resultLabel;
    private JTextField resultField;
    private JLabel resultLabel1;
    private JTextField resultField1;
    private JButton button;
    private GradeCalculator calculator;  // The Calculator object

    public GradeCalcPanel()
    {
        calculator = new GradeCalculator(); // Create a calculator instance
        //setLayout( new GridLayout(1,5,10,20));
        prompt = new JLabel("Grade:");
        resultLabel = new JLabel("Average:");
        inputField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        inputField = new JTextField(10);
        resultLabel1 = new JLabel("#of grades entered:");
        resultField1 = new JTextField(5);
        resultField1.setEditable(false);
        button = new JButton("Enter");
        button.addActionListener(this);

        add(prompt);
        add(inputField);
        add(button);
        add(resultLabel);
        add(resultField);
        add(resultLabel1);
        add(resultField1);

        inputField.setText("");

    } // GradeCalcPanel()


    /**
     * actionPerformed() handles clicks on the button.
     *  It takes the data from the input JTextFields, and sends them to
     *  the GradeCalculater class to calculate a running average and
     *   computes the letter grade, which are displayed in TextFields.
     * @param e -- the ActionEvent the generated this system call
     */
    public void actionPerformed(ActionEvent e)
    {

        double grade, ave;
        DecimalFormat df = new DecimalFormat("0.00");

        String inputString = inputField.getText();

        //Test for bad input sets grade to 101 making it out of valid range
            try{
                grade = Double.parseDouble(inputString);
            }
            catch(Throwable Thrown) {
                grade = 101;
            }

        inputField.setText("");

        calculator.addGrade(grade);

        ave = calculator.calcAvg();
        String average = "" + df.format(ave);
        String letterGrade = calculator.calcLetterGrade();
        int count = calculator.getCount();
        resultField.setText(average + " " + letterGrade);
        resultField1.setText("" + count);
    } //END actionPeformed()

} //END GradeCalcPanel class
