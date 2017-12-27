package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: Box.java
 Assignment 1 - Create a Box Class
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.20.2016
 Last Modified: 1.24.2017

 Assignment:
 The class has four private integer instance variables L1, W1, H1, Weight to store the Length, Width, Height, and Weight of the Box. Measurements are in feet and pounds.
 This class has two constructors:
 Constructor #1 - has no parameters and initializes the Box's instance variables to 0
 Constructor #2 - has four integer parameters that initializes the Box object's L,W,H,Weight
 This class has a method calculateVolume( ) which returns the volume (formula: L1*W1*H1) of the Box object as an integer
 This class has a method calculateDensity( ) which returns the density of the Box (formula: weight/volume) as a double, check for divide by 0.
 This class contains a main( ) method which creates an instance of the Box object with L1=10, W1=5, H1=5, Weight=2600 and computes the Box's Volume and Density, then outputs the results to the user's screen.

 */
public class Box {
    final int Length, Width, Height, Weight;
    int Volume, Density;

    /** Default Box constructor */
    Box(){
        Length = Width = Height = Weight = 0;
    }

    /** Box constructor with 4 int initialization */
    Box(int L1, int W1, int H1, int W2){
        Length = L1;
        Width = W1;
        Height = H1;
        Weight = W2;
    }

    /**Calculates the volume of a Box object */
    void CalculateVolume(){
       /**Tests the box variables for a zero result*/
        if (Length == 0 || Width == 0|| Height == 0){
            System.out.println("Error: box has no volume");
        }
        /**Calculates the volume of a box object and prints the output to console*/
        else {
            Volume = (Length * Width * Height);
            System.out.println("Volume of box: " + Volume + " ft^3");
        }
    }

    /** Calculates the Density of a Box object */
    void CalculateDensity(){
        /**Calculates the density of a box object and prints the output to
         * console if the Volume varialbe hass a non zero value */
        if (Volume != 0) {
            Density = Weight / Volume;
            System.out.println("Density of box: " + Density + " lbs/ft^3");
        }
        /**Prints error message to console if the Volume variable has a zero value*/
        else{
            System.out.println("Error: cannot divide by zero");
        }
    }

    /** int main */
    public static void main(String args[]) {
        Box Box1 = new Box (10, 5, 5, 2600);
        Box1.CalculateVolume();
        Box1.CalculateDensity();
        System.out.println();

        Box Box2 = new Box();
        Box2.CalculateVolume();
        Box2.CalculateDensity();
    }//END main
}//END Box