package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: CyberStudentApplet.java
 Exercise 11 - CyberStudent
 Programmer: Jeffrey Marron with contributions from Catherine Beise, PhD
 Source:http://ruby.fgcu.edu/courses/cbeise/3232/ch4/cyberpet.txt
 Date Created:  12.26.2016
 Last Modified: 1.24.2017
  File: CyberStudent.java
  Author: Java, Java, Java
  Description: This class represents a CyberStudent that can
   eat and sleep on command as well as perform other actions
   while in these states.  This version incorporates
   a public getState() method to report the student's state.
 */

public class CyberStudent
{
    private boolean isAwake = false;    // CyberStudent
    private boolean isSleeping = false;
    private boolean isEating = false;
    private boolean isWorking = false;
    private boolean isDreaming = false;
    private boolean isSnoring  = false;

    private String name = "no name";    // CyberStudent's name

    public CyberStudent (String str)        // Constructor method
    {
        name = str;
    }

    public void setName (String str)    // Access method
    {
        name = str;
    } // setName()

    public String getName()
    {
        return name;           // Return CyberStudent's name
    } // getName()

    boolean wake(int substate)          // Start eating
    {
        if (substate >2){
            return false;
        }
        else if (substate == 0){
            isAwake = true;       // Change the state
            isSleeping = false;
            isDreaming = false;
            isSnoring = false;
            return true;}
        else if (substate ==1 && isAwake){//is Eating
            eat();
            return true;
        }
        else if (substate ==2 && isAwake){//is Working
            work();
            return true;
        }
        else
            return false;
    } //END wake()

    boolean eat(){
        isEating = true;
        isWorking = false;
        return true;
    }

    boolean work(){
        isEating = false;
        isWorking = true;
        return true;
    }

    boolean sleep(int substate)        // Start sleeping
    {
        if (substate <3){
            return false;
        }
        else if (substate ==3){
            isSleeping = true;     // Change the state
            isAwake = false;
            isWorking = false;
            isEating = false;
            return true;
        }
        else if (substate ==4 && isSleeping){//is Dreaming
            dream();
            return true;
        }
        else if (substate ==5 &&isSleeping){//is Snoring
            snore();
            return true;
        }
        else
            return false;
    } //END sleep()

    boolean dream(){
        isDreaming = true;
        isSnoring = false;
        return true;
    }

    boolean snore(){
        isDreaming = false;
        isSnoring = true;
        return true;
    }

    public String getState ()
    {
        if (isAwake) {
            if (isWorking) {
                return "Awake & Working";
            }
            else if (isEating) {
                return "Awake & Eating";
            }
            else
                return "Awake";     // Exit the method
        }


        if (isSleeping) {
            if (isDreaming) {
                return "Sleeping & Dreaming";
            }
            else if (isSnoring) {
                return "Sleeping & Snoring";  // Exit the method
            }
            else
                return "Sleeping";   // Exit the method
        }

        return "Error in State"; // Exit the method
    } //END getState()

    public String toString()
    {
        return name + " is " + getState();
    }
} //END CyberStudent
