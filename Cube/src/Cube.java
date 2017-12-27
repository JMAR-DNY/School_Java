package edu.buffalostate.cis425.sp17.exercises.marron;

/**
 File: CubeUser.java
 Exercise 7 - Cube
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017
 Description: This class creates an instance of the Cube
 class and prints its area and volume.

 Assignment: 1) Create 3 cube objects. The size of each of the cubes
 should be input from the keyboard
 (hint: study the code below)
 2) Print the Side length, Surface area and Volume to the
 users screen for each of the cubes
 3) The program should catch input error exceptions and
 deal with them in a reasonable manner

 */
import java.util.Scanner;
import java.io.*;

public class Cube{
    private int side;

    /** default cube class constructor */
    Cube(){
        side = 0;
    }

    /** cube class constructor with 1 int parameter */
    Cube(int s){
        side = s;
    }

    /** getLength() gets the length of the side */
    public int getLength(){
        return side;
    }//END getLength

    /**calculateSurfaceArea() calculates the surface area of a cube object */
    public int calculateSurfaceArea(){
        return side*side*6;
    }//END calculateSurfaceArea

    /**calculateVolume() calculates the volume of a cube object */
    public int calculateVolume(){
        return side*side*side;
    }//END calculateVolume


    /**
     * main() -- creates an instance of Cube and tests it
     */
    public static void main(String args[]) throws IOException
    {
        int length;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a side length: ");
        length = sc.nextInt();

        if (length != (int)length){//compares length to a cast int of length to determine if its an int
            throw new IOException();//throws IOException
        }

        Cube cube1 = new Cube(length);//creates new cube object

        System.out.println("Side length of cube1 is " + cube1.getLength());
        System.out.println("Surface Area of cube1 is " + cube1.calculateSurfaceArea ());
        System.out.println("Volume of cube1 is " + 	cube1.calculateVolume());

    } //END main
} //END Cube