package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: NumberCruncher.java
 Exercise 5 - Number Cruncher
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017
 Description: This class stores a number and contains
    methods to calculate the number's double, triple, and so on.

 Assignment: 1) add a new method cubeNumber() that returns the number^3
                 power (num*num*num)
              2) add a new method sixthNumber() that returns the number^6
                 power, but it can use only one multiplication in the
                 method (can't use num*num*num*num*num*num). Hint use the
                 other methods that are available - and do not use the
                 Math.pow() function
              3) Test cubeNumber() and sixthNumber() in the main method
 */

public class NumberCruncher
{
    private double num;    // The instance variable

    /**
     * NumberCruncher() constructor creates an instance that
     *  stores the number given as its parameter
     * @param number -- the number that will be stored
     */
    public NumberCruncher(double number)
    {
        num = number;
    }

    /**
     * getNum() returns the object's number
     */
    public double getNum()
    {
        return num;
    }

    /**
     * doubleNum() returns the object's number times 2
     */
    public double doubleNum()
    {
        return num * 2;
    }

    /**
     * tripleNum() returns the object's number times 3
     */
    public double tripleNum()
    {
        return num * 3;
    }

    /**
     * squareNum() returns the square of the object's number
     */
    public double squareNum()
    {
        return num * num;
    }

    /**
     * cubeNum() returns the cube of the object's number
     */
    public double cubeNum(){
        return num*num*num;
    }

    /**
     * sixthNum() returns the sixth power of the object's number
     */
    public double sixthNum(){
        num = cubeNum() * cubeNum();
        return num;
    }

    /**
     * main() creates an instance of this class and tests its
     various methods
     */
    public static void main( String args[] )
    {
        NumberCruncher cruncher1 = new NumberCruncher(10);
        System.out.println("Value of num is " + cruncher1.getNum());
        System.out.println("num doubled is " + 	cruncher1.doubleNum());
        System.out.println("num tripled is " + cruncher1.tripleNum());
        System.out.println("num squared is " + cruncher1.squareNum());
        System.out.println("num cubed is " + cruncher1.cubeNum());
        System.out.println("num ^6 is " + cruncher1.sixthNum());
    } //END main()
} //END NumberCruncher