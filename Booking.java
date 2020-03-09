/**
 * Importing classes for 
 * time,ArrayList
 */
import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * This class is the Booking
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class Booking implements Comparable<Booking>
{
    /**
     * Declaring instance variables
     */
    private int Booking_ID;
    private LocalDate Booking_Date;
    private LocalTime start_Time;
    private LocalTime End_Time;
    private Member Booked_By;
    private Court Booked_For;
    private int Duration;
    private ArrayList<Booking>member_Bookings= new ArrayList<Booking>();
    /**
     * This is the Booking Class Constructor used to
     * initialise the Objects Duration, Booking_Date, satrt_Time, End_Time, Booked_By, Booked_For
     * @param Duration, Booking_Date, satrt_Time, End_Time, Booked_By, Booked_For
     */
    public Booking(int Duration, LocalDate Booking_Date, LocalTime start_Time, LocalTime End_Time, Member Booked_By, Court Booked_For)
    {
        // this.Booking_ID=Booking_ID;
        this.Duration=Duration;
        this.Booking_Date=Booking_Date;
        this.start_Time=start_Time;
        this.End_Time=End_Time;
        this.Booked_By=Booked_By;
        this.Booked_For=Booked_For;
    }

    /**
     * Constructor with one parameter 
     * @param BookingData 
     * 
     */
    public Booking(String BookingData)
    {
        String[] myData = BookingData.split(",");
        this.Booked_By = Club.findMember(Integer.parseInt(myData[0]));
        this.Duration = Integer.parseInt(myData[1]);
        this.Booking_Date = LocalDate.parse(myData[2]);
        this.start_Time= LocalTime.parse(myData[3]);
        this.End_Time = LocalTime.parse(myData[4]);
        this.Booked_For = Club.findCourt(Integer.parseInt(myData[5])); 
        Booked_By.addBooking(this);
        Booked_For.addBooking(this);
    }

    /**
     * This is a getmethod() used to 
     * obtain the Booking_ID
     * @return Booking_ID
     */
    public int getBooking_ID()
    {
        return Booking_ID;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Booking_Date
     * @return Booking_Date
     */
    public LocalDate getBooking_Date()
    {
        return Booking_Date;
    }

    /**
     * This is a getmethod() used to 
     * obtain the start_Time
     * @return start_Time
     */
    public LocalTime getstart_Time()
    {
        return start_Time;
    }

    /**
     * This is a getmethod() used to 
     * obtain the End_Time
     * @return End_Time
     */
    public LocalTime getEnd_Time()
    {
        return End_Time;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Duration
     * @return Duration in minutes
     */
    public int getDuration()
    {
        return Duration;
    }

    /**
     * This is a getmethod() used to 
     * obtain the details of the Court
     * @return Booked_For
     */
    public Court getCourt()
    {
        return Booked_For;
    }

    /**
     * This is a getmethod() used to 
     * obtain the details of the Member
     * @return Booked_By
     */
    public Member getMember()
    {
        return Booked_By;
    }

    /**
     * This is a method used to 
     * remove the Booking from the ArrayList
     * @param booking
     */
    public boolean removeBooking(Booking booking)
    {
        if(Booked_By.deleteBooking(booking) && Booked_For.deleteBooking(booking))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This is a saveData() used to 
     * save the Data of the Booking
     * @return Duration, Booking_Date, start_Time, End_Time, Booked_By, Booked_For
     */
    public String saveData()
    {
        return Booked_By.getMember_ID() + "," +Duration + "," + Booking_Date + "," + start_Time + "," + End_Time + "," + Booked_For.getCourt_ID();
    }

    /*public int compareTo(Booking compareWith)
    {
        return this.startDateTime.compareTo(compareWith.startDateTime);
    }*/
    /**
     * This is a saveBookings() method used to 
     * save the Data of the Booking
     */
    public void saveBookings(ArrayList<String> booking)
    {
        for(Booking b:member_Bookings)
        {
            booking.add(b.saveData());
        }
    }

    /**
     * This compareTo method compare with other booking 
     * @return Booking_ID
     */
    public int compareTo(Booking otherBooking_Date)
    {
        return  this.Booking_Date.compareTo(otherBooking_Date.Booking_Date);
    }    

    /**
     * This is a toString() used to 
     * print the details of the Booking
     * @return Booked_For, Booked_By, Duration, start_Time, End_Time
     */
    public String toString()
    {
        return  "Court_Booked with Court_ID : " + Booked_For.getCourt_ID() + "\n" +
        "Booked by the Member_Name : " + Booked_By.getMember_Name() + "\n" +
        "Duration in Minutes : " + Duration + "\n" +
        "Start_Time : " + this.getstart_Time() + "\n" +
        "End_Time : " +this.getEnd_Time() + "\n" +
        "Booking_Date  : " +this.Booking_Date;
        //"at Court_ID:" + Booked_For.getCourt_ID() + "\n" +      
    }
}//endofclass