/**
 * Imporing classes for util, IO
 * and LocalDate
 */
import java.util.*;
import java.io.*;
import java.time.*;
/**
 * This class is the IO_Support
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class IO_Support
{
    private static Scanner in = new Scanner(System.in);
    /**
     * This method validates the String input from the user
     * and ask to enter it again if it fails to
     * validate
     * @param prompt is the argument passed from the
     * User-Interface Class
     */
    public static String getString(String prompt)
    {
        System.out.print(prompt + " " );
        return in.nextLine();
    }

    /**
     * This method validates the double input from the user
     * and ask to enter it again if it fails to
     * validate
     * @param prompt is the argument passed from the
     * User-Interface Class
     */
    public static Double getDouble(String prompt)
    {
        Double d = 0.00;
        while(true)
        {
            try
            {
                System.out.print(prompt + " ");
                d = Double.parseDouble(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid Double");
            }
        }
        return d;
    }

    /**
     * This method validates the integer input from the user
     * and ask to enter it again if it fails to
     * validate
     * @param prompt is the argument passed from the
     * User-Interface Class
     */
    public static Integer getInteger(String prompt)
    {
        Integer i = 0;
        while(true)
        {
            try
            {
                System.out.print(prompt + " ");
                i = Integer.parseInt(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid Integer");
            }
        }
        return i;
    }

    /**
     * This method is used to print the String
     * passed as an argument in the method
     * @param toPrint is the String to be printed
     * as passed from the User-Interface class
     */
    public static void println(String toPrint)
    {
        System.out.println(toPrint);
    }

    /**
     * This method validates the integer input from the user
     * and ask to enter it again if it fails to
     * validate
     * @param prompt is the argument passed from the
     * User-Interface Class
     */
    public static Integer getInteger()
    {
        Integer i = 0;
        while (true)
        {
            try
            {
                System.out.print("Please enter an integer");
                i = Integer.parseInt(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid integer");
            }
        }
        return i;
    }
}//endofclass