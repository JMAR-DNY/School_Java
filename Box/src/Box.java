package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: Box.java
 Exercise 9 - Box
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017
 Description: This program draws a rectangular box of
   asterisks given the number of rows and columns from
   the user.

  Assignment: 1) Add to the KeyboardReader class a new method:
                 public int getKeyboardIntegerRange(int min, int max) {}
                 that inputs a number from the keyboard, but limited to
                 a range: min, max. The function should not return
                 until the user cooperates and enters a number in the
                 correct range. Check for exceptions and handle errors
                 properly.
              2) Fix Box.java so that it compiles properly, there are
                 at least two possible fixes
              3) Test your new getKeyboardIntegerRange() method in
                 the Box (main) class to see if it works
 */

import java.io.*;

public class Box {

    /**
     * drawBox() draws a row x col box of asterisks
     * @param row -- an int giving the number of rows
     * @param col -- an int giving the number of columns
     */
    public void drawBox (int row, int col) {
        for (int k = 0; k < row; k++) {
            for (int j = 0;j < col; j++)
                System.out.print('*');
            System.out.println();
        }
    } //END drawBox()

    /**
     * main() inputs the number of rows and columns from the
     *  user and invokes the Box.drawBox() method to draw a box.
     */
    public static void main(String args[]) throws IOException{
        int nRows = 0;
        int nColumns = 0;

        KeyboardReader input = new KeyboardReader();
        Box Box1 = new Box();

        System.out.print("Enter the number of rows you want in your box: ");
        nRows = input.getKeyboardInteger(0, 11);
        System.out.print("Enter the number of columns you want in your box: ");
        nColumns =  input.getKeyboardInteger(0, 11);
        System.out.println("This is what your box looks like: \n");
        Box1.drawBox(nRows, nColumns);
    } //END main
} //END Box


