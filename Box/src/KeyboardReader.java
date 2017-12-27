package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: KeyBoardReader.java
 Exercise 9 - Box
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017
 */
import java.io.*;

public class KeyboardReader implements UserInterface
{    private BufferedReader reader;

    public KeyboardReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getKeyboardInput() {
        return readKeyboard();
    }

    public int getKeyboardInteger() {
        return Integer.parseInt(readKeyboard());
    }

    /** getKeyboardInteger gets user entered integer value and evaluates it
     * @param min -- minimum value
     * @param max -- maximum value*/
    public int getKeyboardInteger(int min, int max) {
        int temp=0, x=1;

       do{
            try {
                temp = Integer.parseInt(readKeyboard()); //parses input string to integer while using readKeyboard()
                if (temp > min && temp < max) {//evaluates if the input is within target threshold
                    x = 0;//ends do while loop
                } else {
                    System.out.println("error: number outside of min/max.  Retry: ");
                }
            }
           catch(Throwable Thrown){
               System.out.println("error: invalid input. Retry: ");
           }
        }while (x==1);

       return temp;
    }//END getKeyboardInteger


    public double getKeyboardDouble() {
        return Double.parseDouble(readKeyboard());
    }

    public String getUserInput() {
        return getKeyboardInput();
    }

    public void prompt(String s) {
        System.out.print(s);
    }

    public void report(String s) {
        System.out.print(s);
    }

    public void display(String s) {
        System.out.print(s);
    }

    private String readKeyboard() {
        String line = "";
        try {
            line = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}


