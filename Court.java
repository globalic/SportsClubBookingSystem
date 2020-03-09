/**
 * Importing classes for 
 * time,ArrayList
 */
import java.util.*;
import java.time.*;
import java.util.ArrayList;
/**
 * This class is the Member
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class Court
{
    /**
     * Declaring instance variables
     */
    private ArrayList<Booking>Court_Bookings=new ArrayList<Booking>();
    private int Court_ID;
    private String Court_Name;
    private String CourtOccupied;
    private Booking booking;
    /**
     * This is a getmethod() used to 
     * obtain the Court_ID from the Court
     * @return Court_ID
     */
    public Court(int Court_ID)
    {
        this.Court_ID=Court_ID;
        this.Court_Name=Court_Name;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Court_ID 
     * @return Court_ID
     */
    public int getCourt_ID()
    {
        return Court_ID;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Court_Name from the Court
     * @return Court_Name
     */
    public String getCourt_Name()
    {
        return Court_Name;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Court_Bookings from the Court
     * @return Court_Bookings
     */
    public ArrayList<Booking>getCourt_Bookings()
    {
        return Court_Bookings;
    }

    /**  
     * This is a boolean method used 
     * to check whether the Court is Occupied or not
     */
    public boolean isAvailable(LocalDate Date,LocalTime Time,int Duration)
    {
        for(Booking Court_Booking: Court_Bookings)
        {
            if(Court_Booking.getBooking_Date().equals(Date) && Court_Booking.getstart_Time().equals(Time) && Court_Booking.getDuration()==Duration)
            {
                return false;
            }
        }
        return true;
    }

    /**  
     * This booelean method used
     * to add the Booking to the ArrayList 
     */
    public boolean addBooking(Booking booking)
    {
        if(Court_Bookings.add(booking))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**  
     * This booelean method used
     * to delete the Booking to the ArrayList 
     */
    public boolean deleteBooking(Booking booking)
    {
        if(Court_Bookings.remove(booking))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**  
     * This booelean method used
     * to delete the Booking from the ArrayList 
     * @param delBooking
     */
    public boolean removeBooking(Court delBooking) 
    {
        if (Court_Bookings.remove(delBooking)) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    /**  
     * This is the saveBooking() method used
     * to save the Booking from the ArrayList
     */
    public void saveBookings(ArrayList<String> saveBookingData)
    {
        saveBookingData.add(booking.saveData());
    }
    
    /**
     * This is a toString() method to
     * print the Court details
     * @return Court_ID
     */
    public String toString()
    {
        return  "Court_ID:" + Court_ID; 
    }  
}//endofclass