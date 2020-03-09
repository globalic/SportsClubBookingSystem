/**
 * Importing classes for 
 * time,ArrayList
 */
import java.util.*;
import java.time.*;
import java.util.ArrayList;
/**
 * This class is the Sport
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public abstract class Sport
{
    /**
     * Declaring instance variables
     */
    private ArrayList<Court>Court_Bookings;
    private String Sport_Name;
    private double Usage_Fee;
    private double Insurance_Fee;
    private double Affiliation_Fee;
    private int limit;
    private Court court;

    /**
     * This is the Sport Class Constructor 
     * with no parameters
     */
    public Sport()
    {
    }
    
    /**
     * This is the Sport Class Constructor used to
     * initialise the Objects Sport_Name, Usage_Fee, Insuration_Fee, Affiliation_Fee
     * @param Sport_Name, Usage_Fee, Insuration_Fee, Affiliation_Fee
     */
    public Sport(String sportData)
    {  
        Court_Bookings= new ArrayList<Court>();
        String[] myData=sportData.split(",");
        this.Sport_Name=myData[0];
        this.Usage_Fee=Double.parseDouble(myData[1]);
        this.Insurance_Fee=Double.parseDouble(myData[2]);
        this.Affiliation_Fee=Double.parseDouble(myData[3]);
        if(myData.length>4)
        {
            for(int i=4;i<(myData.length);i++)
            {
                int Court_ID=Integer.parseInt(myData[i]);
                this.Court_Bookings.add(new Court(Court_ID));
            }
        }
        //IO_Support.println("Available_Courts in Sports_List:" + "\n" + Court_Bookings);
    }
    
    //Each Sport is allocated a number of court
    /**
     * This is a getmethod() used to 
     * obtain the Sport_Name
     * @return Sport_Name
     */
    public String getSport_Name()
    {
        return Sport_Name;
    }
    
    /**
     * This is a getmethod() used to 
     * obtain the Usage_Fee
     * @return Usage_Fee
     */
    public double getUsage_Fee()
    {
        return Usage_Fee;
    }
    
    /**
     * This is a getmethod() used to 
     * obtain the Insurance_Fee
     * @return Insurance_Fee
     */
    public double getInsurance_Fee()
    {
        return Insurance_Fee;
    }
    
    /**
     * This is a getmethod() used to 
     * obtain the Affiliation_Fee
     * @return Affiliation_Fee
     */
    public double getAffiliation_Fee()
    {
        return Affiliation_Fee;
    }
    
    /**
     * This is a getmethod() used to 
     * obtain the Court_ID from the Court
     * @return Court_ID
     */
    public Court getCourt()
    {
        return court;
    }
    
    /**
     * This is a getmethod() used to 
     * obtain the Court_List
     * @return Court_Bookings
     */
    public ArrayList<Court>getCourt_List()
    {
        return Court_Bookings;
    }
    
    /**  
     * This booelean method used
     * to add the Court to the ArrayList 
     */
    public boolean addCourt(Court newCourt)
    {
        if(Court_Bookings.add(newCourt))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**  
     * This is a method used 
     * to show the Court_Bookings from the ArrayList 
     * @return Court_Bookings
     */
    public ArrayList<Court> getCourt_Bookings(LocalDate Date,LocalTime Time,int Duration)
    {
        ArrayList<Court> courtBookings=new ArrayList<Court>();
        for(Court c : Court_Bookings) 
        {
            if(c.isAvailable(Date,Time,Duration))
            {
                courtBookings.add(c);
            }
        }
        IO_Support.println("|| Displaying Available_Courts ||");
        return courtBookings;
    }
    
    /**  
     * This is a toString() method used 
     * to show the Sport_Name, Usage_Fee, Insurance_Fee, Affiliation_Fee from the ArrayList 
     * @return Sport_Name, Usage_Fee, Insurance_Fee, Affiliation_Fee
     */
    public String toString()
    {
        return  "\n" + "\n" +
                "Sport_Name:" + Sport_Name + "\n" +
                "Usage_Fee:" + Usage_Fee + "\n" +
                "Insurance_Fee:" + Insurance_Fee + "\n" +
                "Affiliation_Fee:" + Affiliation_Fee +
                "\n";
    }
}//endofclass