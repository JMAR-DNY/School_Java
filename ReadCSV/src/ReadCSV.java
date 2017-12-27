//package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: ReadCSV.java
 CIS400 Assignment 4 - Create a ReadCSV Class
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron

 This program reads an infile containing the months and the amount of days they have and parses that info.
 It then prints the parsed info into a proper output format on the console

 I was debating having a separate month class, and an infile reader class to test for compatibility.
 I also planned to store each month in a list or perhaps create my own tree implementation
 however I decided on a lightweight solution
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSV {
    int i=0;
    int[] MonthNum = new int[12];// 3 array to keep track of the values
    int[] Days = new int[12];
    String[] MonthName = new String[12];
/** getInfile() - gets the infile into scanner SC.  parses each line into scanner lineParser*/
public void getInfile()throws IOException{
    String temp;
    Scanner sc = new Scanner(new File("test.txt"));//src/edu/buffalostate/cis425/cis425_io.txt/

    while (sc.hasNextLine()){
        temp = sc.next();//string temp gets the entire next line
        Scanner lineParser = new Scanner(temp);//the lineParser gets the entire value of temp
        lineParser.useDelimiter(",");//sets delimiter to comma
        MonthNum[i]= Integer.parseInt(lineParser.next());//MonthNum at position i gets the next parsed value
        MonthName[i] = lineParser.next();
        Days[i]= Integer.parseInt(lineParser.next());
        i++;//increments the position of each array element
    }
}//END getInfile

/**print() - this function prints the values stored in the multiple arrays*/
public void print(){
    System.out.println("--------------------------");
    System.out.println("| No | Month Name | Days |");
    System.out.println("--------------------------");
    for(i =0; i<12; i++){
        System.out.printf("| %2s | %-10s |  %s  | %n", MonthNum[i], MonthName[i], Days[i]);}//formatted output
    System.out.println("--------------------------");
}//END print

/**main*/
public static void main(String[] args)throws IOException{
    ReadCSV RCSV = new ReadCSV();
    RCSV.getInfile();
    RCSV.print();
    }//END main
}//END ReadCSV