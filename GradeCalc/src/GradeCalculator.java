package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: GradeCalculator.java
 Exercise 10 - Grade Calc
 Programmer: Jeffrey Marron
 Date Created:  12.23.2016
 Last Modified: 1.24.2017
 Description: Instances of this class are used to calculate
   a course average and a letter grade. In order to calculate
   the average and the letter grade, a GradeCalculator must store
   two essential pieces of data: the number of grades and the sum
   of the grades.  Therefore these are declared as instance variable.
   Each time calcAverage(grade) is called, a new grade is added to
   the running total, and the number of grades is incremented.
 */

/**
   1) Change the program so that it outputs +/- letter grades (you can decide
      the thresholds )

   2) Output, in addition to the average and letter grade, the number of grades
      entered so far. This requires a new method in the GradeCalculator class:
        public int getCount()

   3) Modify the addGrade() method in the GradeCalculator class so that it will
      reject grades that are out of range... and do not update the grade count if
      there is a problem with the grade range.
      a) notify the user that the grade has been rejected, but keep the program
         running

   4) Check user input for errors. The program should handle the entry of characters,
      and other non-numeric symbols without causing a crash
 */
import javax.swing.*;

public class GradeCalculator
{
    private int gradeCount = 0;      // GradeCalculator's internal state
    private double gradeTotal = 0.0;


    /**
     * calcAdd() is given a grade, which is added to
     *  the running total. It then increments the grade count
     *  if the grade is out of range an error message alerts the user
     *  .
     */
    public boolean addGrade(double grade)
    {
        if(grade >=0 && grade <=100) {
            gradeTotal += grade;
            ++gradeCount;
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Must enter a numeric value 0-100", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } //END calcAdd()*****************************************

    /**
     * calcAverage() is given a grade, which is added to
     *  the running total. It then increments the grade count
     *  and returns the running average.
     */
    public double calcAvg()
    {
        return gradeTotal/gradeCount;
    } //END calcAvg()

    /**
     * getCount() returns the grade count
     */
	public int getCount(){
        return gradeCount;
    }//END gradeCount()

    /**
     * calcLetterGrade() returns the letter grade for this object.
     * Algorithm: The course average is first computed from the stored
     *  gradeTotal and gradeCount and then converted into a
     *  letter grade.
     * @return a String representing "A" through "F"
     */
    public String calcLetterGrade ()
    {
        double avg = gradeTotal / gradeCount; // Get the average
        if (avg == 100.0)
            return "A+";
        else if (avg >= 95.0)
            return "A";
        else if (avg >= 89.9)
            return "A-";
        else if (avg >= 87.0)
            return "B+";
        else if (avg >= 83.0)
            return "B";
        else if (avg >= 79.9)
            return "B-";
        else if (avg >= 77.0)
            return "C+";
        else if (avg >= 73.0)
            return "C";
        else if (avg >= 69.9)
            return "C-";
        else if (avg >= 67.0)
            return "D+";
        else if (avg >= 65.0)
            return "D";
        else if (avg >= 0)
            return "F";
        return "Error";
    } //END calcLetterGrade
} //END GradeCalculator



