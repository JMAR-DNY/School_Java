//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: BankCD.java
 Exercise 15 - CDInterest
 Programmer: Jeffrey Marron
 Date Created:  2.4.2017
 Last Modified: 2.4.2017
  Description: This class calculates the maturity value of
   a CD given its principal, interest rate and time period
   in years. It contains a single method to perform
   this task.
 */

public class BankCD
{ private double principal;  // Purchase price of the CD.
    private double rate;  // Yearly interest rate.
    private double years; // The period until maturity of CD.
    boolean error = false;

    /**  BankCD constructor assigns values to instance variables. Also sets error value
     * from try catch block.  if error was caught then pry values are all -1 thus creating an error here
     * @param p -- a double representing the initial principal
     * @param r -- a double representing the interest rate
     * @param y -- a double representing the number of years.
     */
    public BankCD(double p, double r, double y) {
        if (p >= 0 && r >= 0 && y >= 0) {

            principal = p;
            rate = r;
            years = y;
            error = false;
        } else {//pry values are less than 0
            error = true;
        }
    }//END BankCD

    /**
     * used to get the value of error set in the BankCD constructor
     * @return
     */
    public boolean testError(){
        return error;
    }

    /**
     * calcYearly() calculates the maturity value of a CD given
     *   its principal, yearly interest rate, and maturity period.
     *   It uses the formula a = p * (1 + r)^y
     * @param p -- a double representing the initial principal
     * @param r -- a double representing the interest rate
     * @param y -- a double representing the number of years
     * @return -- a doublein currency format is returned
     */
    public double calcYearly()
    {
        return (principal * Math.pow(1 + rate, years));
    } // calcYearly()

    /**
     * calcDaily() calculates the maturity value of a CD given
     * its principal, yearly interest rate, and maturity period
     * assuming daily compound interest.
     * It uses the formula a = p * (1 + r/365)^(365*y)
     * @param p -- a double representing the initial principal
     * @param r -- a double representing the interest rate
     * @param y -- a double representing the number of years
     * @return -- a doublein currency format is returned
     */
    public double calcDailyly()
    {
        return (principal * Math.pow(1 + rate/365, years*365));
    } // calcDaily()

} // BankCD class
