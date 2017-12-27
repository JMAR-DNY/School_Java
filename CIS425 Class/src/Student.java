package edu.buffalostate.cis425.sp17.assignments.marron;
/**
 File: Student.java
 Assignment 2 - CIS425 Class
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  1.8.2017
 Last Modified: 1.24.2017
 Description: This class defines the student class
 */

public class Student {
        private String name;

        // Constructor, set name of student
        public Student( String name ) {
            this.setName(name);
        }

        // return name of student
        public String getName() {
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

}//END Student
