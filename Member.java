/**
 * Importing classes for 
 * ArrayList
 */
import java.util.*;
import java.util.ArrayList;
/**
 * This class is the Member
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class Member
{
    /**
     * Declaring instance variables
     */
    private ArrayList<Booking>Member_Bookings= new ArrayList<Booking>();
    private ArrayList<Sport>Sports_Played;
    private int Member_ID;
    private String Member_Name;
    private boolean financial;
    private String member; 

    /**
     * This is the Member Class Constructor used to
     * initialise the Objects Member_ID, Member_Name, financial
     * @param Member_ID, Member_Name, financial
     */
    public Member(int Member_ID, String Member_Name, boolean financial)
    {
        this.Member_ID=Member_ID;
        this.Member_Name=Member_Name;
        this.financial=financial;
    }

    /**
     * This is the Member Class Constructor with memberData used to
     * initialise the Objects Member_ID, Member_Name, financial
     */
    public Member(String memberData)
    {
        Sports_Played=new ArrayList<Sport>();
        String[] myData=memberData.split(",");
        this.Member_ID=Integer.parseInt(myData[0]);
        this.Member_Name=myData[1];
        this.financial=Boolean.parseBoolean(myData[2]);
        if(myData.length>3)
        {
            for (int i=3;i<myData.length;i++) 
            {
                if(myData[i].equalsIgnoreCase("Tennis")) 
                {
                    Sports_Played.add(new Tennis());
                } 
                else if(myData[i].equalsIgnoreCase("Squash")) 
                {
                    Sports_Played.add(new Squash());
                } 
                else if(myData[i].equalsIgnoreCase("Badminton")) 
                {
                    Sports_Played.add(new Badminton());
                }
            }
        }
        Collections.sort(Member_Bookings);
    }     

    /**
     * This is a getmethod() used to 
     * obtain the Member_Name
     * @return Member_Name
     */
    public String getMember_Name()
    {
        return Member_Name;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Member_ID
     * @return Member_ID
     */
    public int getMember_ID()
    {
        return Member_ID;
    }

    /**
     * This is a method() used to 
     * get the Sports from the ArrayList
     * @return Sports_Played
     */
    public ArrayList<Sport>getAllSports() 
    {
        return Sports_Played;
    }

    /**
     * This is a boolean method() used to 
     * find whether the member is financial or not
     * @return financial 
     */
    public boolean isFinancial()
    {
        return this.financial;
    }

    /**
     * This is a getmethod() used to 
     * obtain the Member_Bookings from the ArrayList
     * @return Member_Bookings
     */
    public ArrayList<Booking> getMemberBooking()
    {
        return Member_Bookings;
    }

    /**  
     * This is a boolean method used 
     * to check whether the member is Found or not
     */
    public boolean isFound()
    {
        if(member != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This is a saveBooking() method which
     * saves the Bookings to the ArrayList
     */
    public void saveBooking(ArrayList<String> saveToMe)
    {
        for(Booking booking : Member_Bookings)
        {
            saveToMe.add(booking.saveData());
        }
    }

    /**  
     * This booelean method used
     * to add the Booking to the ArrayList 
     */
    public boolean addBooking(Booking booking)
    {
        if(Member_Bookings.add(booking))
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
        if(Member_Bookings.remove(booking))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This is a method used to 
     * save the Member_Data
     * @return Member_ID, Member_Name, financial
     */
    public String saveMemberData()
    {
            return Member_ID + "," + Member_Name + "," + financial;
    }

    /**
     * This is a toString() method used to 
     * print the Member Data
     * @return Member_ID, Member_Name, financial
     */
    public String toString()
    {
        return  "Member_ID: " + Member_ID + "," +
        "Member_Name: " + Member_Name + "," + 
        "Financial: " + financial +
        "\n";
    }
}//endofclass