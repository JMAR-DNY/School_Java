package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: CIS425_Course.java
 Assignment 2 - CIS425 Class
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.8.2017
 Last Modified: 1.24.2017
 Description: This class creates a CIS425_Course object which
    contains student records which can be modified
 */
public class CIS425_Course {
    private CIS425_Student roster[];
    private int student_num, counter = 0;

    /**
     * CIS425_Course() constructor creates a Course object which
     * is comprised of an array of CIS425_Student objects
     * @param capacity -- the given class size
     */
    public CIS425_Course( int capacity ) {
        roster = new CIS425_Student[capacity];
        student_num = capacity;
    }//END CIS425_Course

    /**
     * addStudent() adds a student record to the roster array
     * @param name -- the student's name
     * @param num_exams -- the number of exams
     */
    public boolean addStudent( String name, int num_exams ) {

    if (counter !=student_num) {
        CIS425_Student peon = new CIS425_Student(name, num_exams);
        roster[counter] = peon;
        counter++;
        return true;
    }
    else
        return false;
    }//END addStudent

    /**
     * findStudent() searches the roster array for
     * a student record
     * @param name -- student's name
     */
    public CIS425_Student findStudent( String name ) {
        for(int i = 0; i<student_num; i++){
            if(roster[i].getName() == name){
                //System.out.println("TEST");
                return roster[i];
            }
        }
        return null;
    }//END findStudent

    /**ADD EXCEPTION THROW HERE */
    public double computeAverage( int exam ) {
        double temp_grades = 0;
        for(int i = 0; i<counter; i++) {
            temp_grades = (temp_grades+roster[i].getGrade(exam));
            }
        return temp_grades/counter;//temp_grades/roster[0].getCount();
    }//END computeAverage


    /** MAIN */
    public static void main(String args[]) {
    CIS425_Course class1 = new CIS425_Course (30); //Declares a new CIS425_Course object
    class1.addStudent("Sally Smarty", 3);   //Populate class1
    class1.addStudent("Phil Phailure", 3);


    class1.findStudent("Sally Smarty").addGrade(1, 100); //Search records and modify
    class1.findStudent("Phil Phailure").addGrade(1, 60);
    System.out.println(class1.computeAverage(1)); //calculate and print output to terminal


    }//END main
}//END CIS425_Course