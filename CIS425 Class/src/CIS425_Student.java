package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: CIS425_Student.java
 Assignment 2 - CIS425 Class
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.8.2017
 Last Modified: 1.24.2017
 Description: Defines the CIS425_Student class which inherits from Student
 */
public class CIS425_Student extends Student{
    //private Student CIS245;
    private int exam_array[];
    private int exam_count;

    /**
     * CIS425_Student() constructor creates a student object
     * @param name -- the student's name
     * @param num_exams -- the number of exams
     */
    public CIS425_Student( String name, int num_exams) {
        super(name);
        exam_array = new int [num_exams];
        exam_count = num_exams;
    }//END CIS425 Student

    /**
     * addGrade() adds grades to a given student.
     * @param exam -- the exam number
     * @param grade -- the grade of the exam
     */
    public boolean addGrade( int exam, int grade ) {
        if (exam_array[exam] >=0 && exam_array[exam] <= exam_count) {
            exam_array[exam] = grade;
            return true;
        }
        else
            return false;
    }//END addGrade

    /**
     * getGrade() retrieves the grade at a specific location
     * in the exam_array
     * @param exam -- the exam to be checked
     */
    public int getGrade( int exam ) {
        if (exam_array[exam] >= 0 || exam_array[exam] <=exam_count){
            return exam_array[exam];
        }
        else return -1;
    }//END getGrade

    public String getName() {
        return super.getName();
    }//END getName

    public int getCount(){
        return exam_count;
    }//END getCount


}//END CIS425_Student


