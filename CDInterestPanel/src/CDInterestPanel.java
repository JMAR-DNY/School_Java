//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: CDInterestPanel.java
 Exercise 15 - CDInterest
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017

  Description: This class defines a GUI in a JPanel which contains
  JTextFields for entering principal, interest rate, and years
  and a JButton which when clicked will compute the maturity
  value of a CD with those values and will display this value
  in a JTextField.  It uses the BankCD class.

  Assignment:  1) Change the layout of the component so that it looks
                  more "professional" (use a Layout Manager). You can
                  decide on the aesthetics...
               2) Add error checking to the inputs, so that data is
                  entered correctly. Catch errors and other bad input
               3) Add a TextField or TextArea object to display any
                  error messages from 2) above
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class CDInterestPanel extends JPanel implements ActionListener
{

    private JLabel prompt1; // Prompt for the principal.
    private JLabel prompt2; // Prompt for the interest rate.
    private JLabel prompt3; // Prompt for the number of years.
    private JTextField inputField1; // For principal.
    private JTextField inputField2; // For interest rate.
    private JTextField inputField3; // For number of years
    private JLabel resultLabel;  // Labels the output
    private JTextField resultField;  // The output
    private JLabel resultLabel1;  // Labels the output
    private JTextField resultField1;  // The output
    private JButton button;  // Click to compute the maturity value.

    GridLayout experimentLayout = new GridLayout(0,2);

    public CDInterestPanel()
    {
        final JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(experimentLayout);

        JPanel ButtonPanel0 = new JPanel();
        ButtonPanel0.setLayout(new FlowLayout());

        JPanel outputField = new JPanel();//creates a new panel for the output field
        outputField.setLayout(experimentLayout);

        prompt1 = new JLabel("Enter the CD's initial principal:");
        prompt2 = new JLabel("Enter the CD's interest rate (percent):");
        prompt3 = new JLabel("Enter the number of years to maturity:");
        resultLabel = new JLabel("The Maturity Value is:");
        resultLabel1 = new JLabel("Errors:");
        inputField1 = new JTextField(10);
        inputField1.setEditable(true);
        inputField2 = new JTextField(10);
        inputField2.setEditable(true);
        inputField3 = new JTextField(10);
        inputField3.setEditable(true);
        resultField = new JTextField(10);
        resultField1 = new JTextField(16);
        button = new JButton("Calculate the Maturity Value");
        button.addActionListener(this);

        ButtonPanel.add(prompt1);
        ButtonPanel.add(inputField1);
        ButtonPanel. add(prompt2);
        ButtonPanel.add(inputField2);
        ButtonPanel.add(prompt3);
        ButtonPanel.add(inputField3);

        ButtonPanel0.add(button);
        outputField.add(resultLabel);
        outputField.add(resultField);
        outputField.add(resultLabel1);
        outputField.add(resultField1);


        add(ButtonPanel, BorderLayout.NORTH);//adds the ButtonPanel to the north position
        add(ButtonPanel0, BorderLayout.CENTER);//adds the ButtonPanel0 to the center position
        add(outputField, BorderLayout.SOUTH);//adds the outputField to the south position
    } // CDInterestPanel()


    /**
     * actionPerformed() handles clicks on the calculate button.
     *  It inputs the data from the JTextFields, converts them to
     *  numeric values and calls on the BankCD object to perform
     *  the calculation. It translates the result into a currency format
     *  and displays it in a JTextField.
     */
    public void actionPerformed(ActionEvent e)
    {
        String inputString1, inputString2, inputString3;
        double principal, rate, years;
        boolean error;

        //put the getText actions all in one block so 1 try catch could catch all at once
        inputString1 = inputField1.getText();
        inputString2 = inputField2.getText();
        inputString3 = inputField3.getText();

        try {
            principal = Double.parseDouble(inputString1);
            rate = Double.parseDouble(inputString2)/100.0;
            years = Double.parseDouble(inputString3);
        }
        //sets the values all to -1 to set off error in BankCD constructor
        catch(Throwable Thrown){
            principal = -1;
            rate = -1;
            years = -1;
        }

        BankCD cd = new BankCD(principal, rate, years);
        error = cd.testError();//gets the error value generated from the BankCD constructor

        if(error == false) {
            double maturityValue = cd.calcYearly();
            NumberFormat dollars = NumberFormat.getCurrencyInstance();
            String resultStr = dollars.format(maturityValue);
            resultField.setText(resultStr);
            resultField1.setText("");//clears the error text field
        }
        else{//error exists
            resultField.setText("");//clear the calculation result field
            resultField1.setText("values must be greater than 0");//sets the error text field
        }
    } //END actionPeformed()
} //END CDInterestPanel class



