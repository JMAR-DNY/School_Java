package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: CubeUser.java
 Exercise 12 - Pair Manager
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.12.2017
 Last Modified: 1.24.2017
 Description: This is an implementation of a pair class in Java

 Create a PairManager class with the following characteristics/properties/methods:

 A default constructor that initializes the pair of integers to 0.
 There will be several public and private methods defined in this class:
 private int getInput(String prompt) - this method returns an integer from the keyboard. You must check for exceptions with try/catch blocks and recover gracefully from an exception. The prompt string is printed as a user prompt.
 public boolean getPair( ) - this method assigns values to the pair of integers by reading two numbers. You should call getInput( ) for each number.
 public int getFirst() - this method returns the first integer
 public int compAverage( ) - returns the average of the pairs.
 main ( ) - this method is the entry point to the program; it should create a PairManager object, call getPairs( ) and output the average of the pair.


 */

import java.util.Scanner;
import java.io.*;

public class PairManager {
    private int x,y;


    /**
     * PairmMnager() constructor creates a pair object with
     *  both values set to 0
     */
    PairManager(){
        x=0; y=0;
    }

    /**
     * private int getInput(String prompt) called in the getPair() function.
     * used to test for valid integer input and throws exceptions
     * @param prompt -- the string from Scanner sc in getPair
     */
    private int getInput(String prompt){
            try
            {
                int i = Integer.parseInt(prompt);
                return i;
            }

            catch(NumberFormatException er)
            {
                System.out.println("Not a valid integer");
                return 0;
            }
    }//END getInput

    /**
     * public boolean getPair() gets a pair of ints by calling getInput twice.
     * if the int value remains unchanged from the constructor then it will
     * keep looping until it receives valid input
     */
    public boolean getPair(){
        String temp;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first Integer for pair: ");
            temp = sc.nextLine();
            x = getInput(temp);
        }
        while(x==0);

        do {
            System.out.print("Enter Second Integer for pair: ");
            temp = sc.nextLine();
            y = getInput(temp);
        }
        while(y==0);

        return true;
    }//END getPair

    /**
     * public int compAverage() prints the average of ints x and y
     */
    public int compAverage(){
        System.out.println("The average of the pair is: " + (((double)x+(double)y))/2);
        return 0;
    }//END compAverage


    public static void main(String args[]){

    PairManager pair1 = new PairManager();//creates new pair object

    pair1.getPair();
    pair1.compAverage();

    }///END main

}//END PairManager
