package edu.buffalostate.cis425.sp17.exercises.marron;

/**
 File: NumberAdder.java
 Exercise 4 - Number Adder
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017


  Description: This class adds its two instance variables
  when the getSum() method is called.

  Assignment: 1) Add a getDifference method (to subtract num1-num2)
              2) Add a getMult method to multiply the numbers
              3) Add a getDiv method to divide the numbers num1/num2
                 - check if num2 is not equal to 0.0 before division
                 - if num2 is 0.0 return the value: Double.NaN
              4) Test the new methods in the main()
 */
import java.text.DecimalFormat;

public class NumberAdder
{
    private double num1;
    private double num2;



    /**
     * setNums() sets the two instance variables from the given parameters
     * @param n1 -- one of the given numbers
     * @param n2 -- the second given number
     */
    public void setNums(double n1, double n2)
    {
        num1 = n1;
        num2 = n2;
    } //END setNums()

    /**
     * getSum() returns the sum of the two instance variables
     */
    public double getSum()
    {
        return num1 + num2 ;
    } //END getSum()

    /**
     * getDifference() returns the difference of the two instance variables
     */
    public double getDifference(){
        return num1 - num2;
    }//END getDifference()

    /**
     * getMult() returns the multiplication of the two instance variables
     */
    public double getMult(){
        return num1*num2;
    }//END getMult()

    /**
     * getDiv() returns the division of the two instance variables. checks for zero value
     */
    public double getDiv(){
        if (num2 == 0){//tests if num2 is a zero value
            System.out.println("Error: num2 has a zero value");
            return Double.NaN;
        }
        else{
            return num1/num2;
        }
    }//END getDiv()

    /**
     * main() creates two instances of this class and tests its
     *  setNums() and getSum() methods
     */
    public static void main(String args[])
    {
        DecimalFormat stuff = new DecimalFormat("#,###.00");

        NumberAdder adder1 = new NumberAdder(); // Create two instances
        NumberAdder adder2 = new NumberAdder();
        adder1.setNums(10,15);                  // Set the instances' values
        adder2.setNums(100,200);

        System.out.println("Difference of adder1: " + stuff.format(adder1.getSum()));// Print the values
        System.out.println("Difference of adder2: " + stuff.format(adder2.getSum()));

        System.out.println("Difference of adder1: " + stuff.format(adder1.getDifference()));
        System.out.println("Difference of adder2: " + stuff.format(adder2.getDifference()));

        System.out.println("Multiplication of adder1: " + stuff.format(adder1.getMult()));
        System.out.println("Multiplication of adder2: " + stuff.format(adder2.getMult()));

        System.out.println("Division of adder1: " + stuff.format(adder1.getDiv()));
        System.out.println("Division of adder2: " + stuff.format(adder2.getDiv()));

    } //END main()
} //END NumberAdder
