package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: Donor.java
 Exercise 8 - Donor
 For: CIS 425 Object Oriented Programming
 Programmer: Jeffrey Marron
 Date Created:  12.22.2016
 Last Modified: 1.24.2017
  Description: This class represents a donor to an
               organization. It stores the donor's name and rating.
               The main() method tests the class's methods.

  Assignment: 1) Add a new level "low" to this class (in addition to
                 "high", "medium", "none")
              2) Add a new method:
                 public void updateRating(double amt){ } which
                 recalculates a donor's rating according to the following
                 schedule:
                 a) amt = 0 - none
                 b) amt < $100 - low level
                 c) amt >= $100 and amt < $1000 - medium level
                 d) amt >= $1000 - high level
                 updateRating() should change the instance variable:
                 rating to the new value
              3) Modify this template to include an address variable and
                 change the constructor to accept this new variable
                 (along with the parameters). Basically, the object
                 stores the donor's name, address and rating
              4) Create a new donor (donor4) with an initial "low" rating,
                 a) then let donor4 contribute $150,
                 b) print this donor's new rating to the CRT
              5) Modify the rest of the program (as needed) so that it compiles and runs correctly

 */

public class Donor
{
    private String name = "no name", rating = "none", address = "nowhere";

    /**
     * Donor() constructor sets the object's name and rating
     * @param str -- a String giving the donor's name
     * @param str2 -- a String giving the donor's rating
     * @param str3 -- a String giving the donor's address
     */
    public Donor(String str, String str2, String str3)
    {
        name = str;
        rating = str2;
        address = str3;
    }

    /**
     * getName() returns the donor's name
     * @return a String giving the person's name
     */
    public String getName()
    {
        return name;
    }//END getName

    /**
     * getRating() returns the donor's rating
     * @return a String giving the person's rating
     */
    public String getRating()
    {
        if (rating.equals ("high"))
            return "high";
        if (rating.equals ("medium"))
            return "medium";
        if (rating.equals ("low"))
            return "low";
        return "none";
    }//END getRating

    /**updateRating() evaluates donor rating based on input value
    * @param amt -- a double of the donation amount
    * */
    public void updateRating(double amt){

        if (amt > 0 && amt < 100){
            rating.equals("low");
        }
        if (amt > 100 && amt <1000){
            rating = "medium";
        }
        if (amt > 1000){
            rating = "high";
        }
    }//END updateRating


    /**
     * main() creates four Donor instances and tests this
     *  classes methods.
     */
    public static void main (String argv[])
    {
        Donor donor1 = new Donor("NewDonor", "high", "somewhere");
        System.out.println("Donor's name is " + donor1.getName());
        System.out.println(donor1.getName() + "'s rating is " + donor1.getRating());
        System.out.println();

        Donor donor2 = new Donor("NewDonor2", "medium", "somewhere");
        System.out.println("Donor's name is " + donor2.getName());
        System.out.println(donor2.getName() + "'s rating is " + donor2.getRating());
        System.out.println();

        Donor donor3 = new Donor("NewDonor3", "none", "somewhere");
        System.out.println("Donor's name is " + donor3.getName());
        System.out.println(donor3.getName() + "'s rating is " + donor3.getRating());
        System.out.println();

        Donor donor4 = new Donor("NewDonor4", "low", "somewhere");
        System.out.println("Donor's name is " + donor4.getName());
        System.out.println(donor3.getName() + "'s rating is " + donor4.getRating());
        System.out.println();

        System.out.println("After donor 4 makes a 150$ donation: ");
        donor4.updateRating(150);//updates donor4 with a 150$ donation
        System.out.println("Donor's name is " + donor4.getName());
        System.out.println(donor4.getName() + "'s rating is " + donor4.getRating());
    } //END main()
} //END Donor