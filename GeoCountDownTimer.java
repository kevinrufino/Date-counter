package project1;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/***************************************************************************
 * This calendar allows us to take a date and increment and decrement days from it.
 * Also allowing us to count the amount of days until a future date and how many days
 * ago another date was. Whilst also being able to write and read a file.
 *
 * @author Kevin Rufino and Nico Deciechi
 * @version 9/25/2019
 * CIS 163 Fall 2019
 **************************************************************************/

public class GeoCountDownTimer {
    /** the day of the month assigned*/
    private int days;

    /** the month thats assigned to ______*/
    private int months;

    /** the year thats assigned*/
    private int years;

    /** the calendar object from the Calendar class, used for keeping track
     * of specifics*/
    private Calendar cal = Calendar.getInstance();

    /** the gregorian calendar object used for the isLeapYear method*/
    private GregorianCalendar c = (GregorianCalendar) GregorianCalendar.getInstance();

    /****************************************************************************
     * Constructor for objects of class GeoCountDownTimer
     * This is the default constructor
     ****************************************************************************/
    private GeoCountDownTimer (){
        days = 0;
        months = 0;
        years = 0;
    }

    /****************************************************************************
     * Constructor for objects of class GeoCountDownTimer
     * This is an alternative constructor
     *
     * @param other other GeoCountDownTimer object
     ****************************************************************************/
    public void GeoCountDownTimer (GeoCountDownTimer other){
        this.days = other.days;
        this.months = other.months;
        this.years = other.years;
    }

    /****************************************************************************
     * Constructor for objects of class GeoCountDownTimer
     * This is an alternative constructor
     *
     * @param month,day,year the new date
     ****************************************************************************/
    public GeoCountDownTimer (int month, int day, int year){
        days = day;
        months = month;
        years = year;

        /** Testing */

        if (months <= 0 || months > 12){
            throw new IllegalArgumentException();
        }

        if (years <= 0){
            throw new IllegalArgumentException();
        }

        if(c.isLeapYear(years) && months == 2){
            if (days > 29)
                throw new IllegalArgumentException();
        }

        if
        (days <= 0 || days > 31 || (days > 30 && months == 4) || (days > 30 && months == 6) ||
                (days > 30 && months == 9) || (days > 30 && months == 11) || (days > 28 && months == 2))
        {
            throw new IllegalArgumentException();
        }
    }

    /****************************************************************************
     * Constructor for objects of class GeoCountDownTimer
     * This is an alternative constructor
     *
     * @param geoDate the new date written as a string
     ****************************************************************************/
    public GeoCountDownTimer (String geoDate){
        int slash1 = geoDate.indexOf("/");
        int slash2 = geoDate.lastIndexOf("/");

        months = Integer.parseInt(geoDate.substring(0,slash1));
        days = Integer.parseInt(geoDate.substring(slash1 + 1,slash2));
        years = Integer.parseInt(geoDate.substring(slash2 +1));

        /** Testing */

        if (months <= 0 || months > 12){
            throw new IllegalArgumentException();
        }

        if (years <= 0){
            throw new IllegalArgumentException();
        }

        if(c.isLeapYear(years) && months == 2){
            if (days > 29)
                throw new IllegalArgumentException();
        }

        if
        (days <= 0 || days > 31 || (days > 30 && months == 4) || (days > 30 && months == 6) ||
                (days > 30 && months == 9) || (days > 30 && months == 11) || (days > 28 && months == 2))
        {
            throw new IllegalArgumentException();
        }

    }

    /****************************************************************************
     * Checks if both objects are the same
     * This is an accesor method
     *
     * @param other other date object
     * @return whether the objects are acutally the same
     ****************************************************************************/
    public boolean equals (Object other){
        if (this == other){
            return true;
        }
        if (other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }

        GeoCountDownTimer that = (GeoCountDownTimer) other;
        if (this.years != that.years || this.months != that.months || this.days != that.days){
            return false;
        }
        return true;
    }

    /****************************************************************************
     * Compares the two dates and checks which one is greater
     * This is an accessor method
     *
     * @param other the other date object
     * @return the value of >,<, or =
     ****************************************************************************/
    public int compareTo (GeoCountDownTimer other){
        if (this.equals(other)){
            return 0;
        }

        if (this.years > other.years){
            return 1;
        }
        if (this.months > other.months){
            return 1;
        }
        if (this.days > other.days){
            return 1;
        }

        return -1;
    }

    /****************************************************************************
     * Decrements the amount of days from the date object
     * This is a mutator method
     *
     * @param days the number of days you wish to decrement from the date
     ****************************************************************************/
    public void dec (int days){
        //sets currents values to a calendar object to follow calendar rules
        cal.set(years, months, this.days);
        cal.add(Calendar.DAY_OF_MONTH, -days);

        this.days = cal.get(Calendar.DAY_OF_MONTH);
        months = cal.get(Calendar.MONTH);
        years = cal.get(Calendar.YEAR);
    }

    /****************************************************************************
     * Decrements one day from the date object
     * This is a mutator method
     ****************************************************************************/
    public void dec (){
        //sets currents values to a calendar object to follow calendar rules
        cal.set(years, months, this.days);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        this.days = cal.get(Calendar.DAY_OF_MONTH);
        months = cal.get(Calendar.MONTH);
        years = cal.get(Calendar.YEAR);
    }

    /****************************************************************************
     * Increments the amount of days from the date object
     * This is a mutator method
     *
     * @param days the number of days you wish to increment from the date
     ****************************************************************************/
    public void inc (int days){
        //sets currents values to a calendar object to follow calendar rules
        cal.set(years, months, this.days);
        cal.add(Calendar.DAY_OF_MONTH, days);

        this.days = cal.get(Calendar.DAY_OF_MONTH);
        months = cal.get(Calendar.MONTH);
        years = cal.get(Calendar.YEAR);
    }

    /****************************************************************************
     * Increments one day from the date object
     * This is a mutator method
     ****************************************************************************/
    public void inc () {
        //sets currents values to a calendar object to follow calendar rules
        cal.set(years, months, this.days);
        cal.add(Calendar.DAY_OF_MONTH, 1);

        this.days = cal.get(Calendar.DAY_OF_MONTH);
        months = cal.get(Calendar.MONTH);
        years = cal.get(Calendar.YEAR);
    }

    /****************************************************************************
     * This takes the information from our date and prints it as a string with
     * names of the months
     ****************************************************************************/
    public String toString (){
        String month = "";
        switch (months){
            case 1: month = "January"; break;
            case 2: month = "February"; break;
            case 3: month = "March"; break;
            case 4: month = "April"; break;
            case 5: month = "May"; break;
            case 6: month = "June"; break;
            case 7: month = "July"; break;
            case 8: month = "August"; break;
            case 9: month = "September"; break;
            case 10: month = "October"; break;
            case 11: month = "November"; break;
            case 12: month = "December"; break;

        }
        return month + " " + days + ", " + years;
    }

    /****************************************************************************
     * This takes the information from our date and prints it as a string
     ****************************************************************************/
    public String toDateString() {
        return months + "/" + days + "/" + years;
    }

    /****************************************************************************
     * Saves the object to a file
     * This is a mutator method
     *
     * @param fileName name of file were looking for
     ****************************************************************************/
    public void save(String fileName){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        out.println(this.days);
        out.println(this.months);
        out.println(this.years);
        out.close();
    }

    /****************************************************************************
     * Loads the date object from a file
     * This is a mutator method
     *
     * @param fileName name of file were looking for
     ****************************************************************************/
    public void load(String fileName){
        try{
            // open the data file
            Scanner fileReader = new Scanner(new File(fileName));


            this.days = fileReader.nextInt();
            this.months = fileReader.nextInt();
            this.years = fileReader.nextInt();
        }

        // could not find file
        catch(Exception error) {
            System.out.println("File not found ");
        }
    }

    /****************************************************************************
     * This counts the number of days until another date
     * This is a mutator method
     *
     * @param fromDate the date in the future
     * @return the number of days until fromDate
     ****************************************************************************/
    public int daysToGo(String fromDate) {
        int counter = 0;

        GeoCountDownTimer fromdate1 = new GeoCountDownTimer(fromDate);
        if (fromdate1.compareTo(this) == 0) {
            return 0;

        }
        //decrements from future sate until dates are equal
        if (fromdate1.compareTo(this) == 1) {
            GeoCountDownTimer hellyeah;
            hellyeah = this;
            while (!this.equals(fromdate1)) {
                hellyeah.dec();
                counter++;
            }
        }
        return counter;
    }
    /****************************************************************************
     * Checks for date that is n days from current date object
     * This is a mutator method
     *
     * @param n number of days in the future
     * @return date that is n days in the future
     ****************************************************************************/
    public GeoCountDownTimer daysInFuture(int n){
        GeoCountDownTimer s = new GeoCountDownTimer(1,2,2019);
        s = this;
        //keeps dec until reached current date
        if(n<=0){
            s.dec(n);
        }
        s.inc(n);
        return s;
    }

    /****************************************************************************
     * Main method that tests multiple situations in our date
     ****************************************************************************/
    public static void main(String[] args) {
        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: " + s);

        GeoCountDownTimer s1 = new GeoCountDownTimer("2/10/2022");
        System.out.println("Date: " + s1.toDateString());

        s1.dec(365);
        System.out.println("Date: " + s1);

        GeoCountDownTimer s2 = new GeoCountDownTimer("2/10/2019");
        for (int i = 0; i < (365 + 366 ); i++)
            s2.inc(1);
        System.out.println("Date: " + s2);

        // Create many more test cases in this driver method to
        // prove the class is functioning correctly.


    }

}
