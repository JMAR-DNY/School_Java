package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: Average.java
 Exercise 1 - Average
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.19.2016
 Last Modified: 1.24.2017

 Assignment:
 Write a program that inputs 10 integers from the keyboard and
 computes their average.
 if the user enters 9999, the program exits early, and outputs
 the average of the numbers entered so far.
 */

import java.util.Scanner;

public class Average {

    public static void main( String args[] ) {
        int ave=0, cnt, num;
        Scanner sc = new Scanner(System.in);

        System.out.println( "Integer Averaging Program" );
        System.out.println( "Enter 10 Integers" );
        cnt=0;
        for ( int i = 1; i<11; i++) {
            System.out.print("Enter Integer "+i+": ");
            num=sc.nextInt();

            if (num==9999)
                break;
            cnt++;
            ave=ave+num;
        }
        if (cnt == 0)
            System.out.println("No Ints Entered");
        else
            ave= ave/cnt;

        System.out.println("The average of " + cnt + " numbers is " + ave );
    }//END main
}//END Average