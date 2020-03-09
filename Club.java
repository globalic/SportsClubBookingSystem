/**
 * Importing classes for 
 * LocalTime, ArrayList
 */
import java.util.*;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
/**
 * This class is the Club
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class Club
{
    /**
     * Declaring instance variables
     */
    private static ArrayList<Member>Members_List;
    private static ArrayList<Member>Members;
    private static ArrayList<Sport>Sports_List;
    private static ArrayList<Court>Court_Bookings;
    private String Club_Name;
    private static LocalTime OpenTime = DateUtility.convertTime("08:00");
    private static LocalTime CloseTime = DateUtility.convertTime("23:00");
    /**
     * The Club Constructor is implemented in Class Club is used to
     * initialise the objects created Members_List, Sports_List 
     * also calls  readAllMembers_List(), readAllSports_List()
     * by using a try-catch mechanism for indicating errors if occurred
     */
    public Club(String name) throws ClubClassException
    {
        Members_List=new ArrayList<Member>();
        Sports_List=new ArrayList<Sport>();
        this.Club_Name=Club_Name;
        this.OpenTime=OpenTime;
        this.CloseTime=CloseTime;
        try
        {
            readAllMembers_List();
            readAllSports_List();
            readAllBookings();
        }
        catch(Throwable ex)
        {
            //System.out.println(ex);
            throw new ClubClassException("Error Found in Class Club() during Initialization or with readAllMembers_List() and readAllSports_List() methods");
        }
    } 

    /**
     * This is a get method() which is used 
     * to get value of openTime.
     * @return openTime
     */
    public static LocalTime getOpenTime()
    {
        return OpenTime;
    }

    /**
     * This is a get method() which is used 
     * to get value of closeTime.
     * @return closeTime
     */
    public static LocalTime getCloseTime()
    {
        return CloseTime;
    }

    /**  
     * This booelean method used
     * to add the Member to the ArrayList 
     * @param newMember
     */
    public boolean addMember(Member newMember)
    {
        if(Members_List.add(newMember))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**  
     * This is a static method used
     * to Find the Sport from the ArrayList 
     * @param Sport_Name
     */
    public static Sport findSport(String Sport_Name) 
    {
        for(Sport s : Sports_List) 
        {
            //if (member.getMember_ID().equals(Member_ID))  
            if(Sport_Name.equalsIgnoreCase(s.getSport_Name()))
            {
                IO_Support.println("Sport Found: " + Sport_Name);
                return s;
            }
        }
        return null;
    }

    /**  
     * This is a static method used
     * to Find the Member from the ArrayList 
     * @param Member_ID
     */
    public static Member findMember(int Member_ID) 
    {
        for(Member member : Members_List) 
        {
            //if (member.getMember_ID().equals(Member_ID))  
            if(Member_ID == member.getMember_ID())
            {
                //IO_Support.println("Member Found: " + Member_ID);
                return member;
            }
        }
        return null;
    }

    /**  
     * This is a static method used
     * to Find the Court from the ArrayList 
     * @param Court_ID
     */
    public static Court findCourt(int Court_ID) 
    {
        ArrayList<Court> court_Bookings = new ArrayList<Court>();
        for(Sport s : Sports_List)
        {
            court_Bookings=s.getCourt_List();
            for(Court c : court_Bookings) 
            {
                //if (member.getMember_ID().equals(Member_ID))  
                if(Court_ID == c.getCourt_ID())
                {
                    //IO_Support.println("Court Found: " + Court_ID);
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * This methos is used to
     * findBooking with parameters bookingdate,starttime,endtime in club
     * @param bookingDate 
     * @param startTime 
     * @return Booking
     */
    public Booking findBooking(LocalDate Date,LocalTime start_Time, LocalTime End_Time)
    {       
        Booking booking  = null;
        for(Court c : Court_Bookings)
        {
            ArrayList<Booking> Court_Bookings = c.getCourt_Bookings();             
            for(Booking b : Court_Bookings)
            { 
                if(b.getBooking_Date().equals(Date)&&b.getstart_Time().equals(start_Time)&&b.getEnd_Time().equals(End_Time))
                {
                    booking=b;
                    break;
                }
            }
        }
        return booking;
    }

    /**  
     * This booelean method used
     * to delete the Booking from the ArrayList 
     * @param delBooking
     */
    public boolean removeBooking(Member delBooking) 
    {
        if (Members_List.remove(delBooking)) 
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
     * This booelean method used
     * to make the new Member & Court Booking
     * @param new_Booking
     */
    public boolean Make_Booking(Booking new_Booking)
    {
        Court c = new_Booking.getCourt();
        Member m= new_Booking.getMember();
        if(c.addBooking(new_Booking) && m.addBooking(new_Booking))
        {
            return true;
        }
        else
        {
            return false;
        }
        //return true;
    }

    /**  
     * This is a method used 
     * to get the Member_Bookings from the ArrayList 
     * @return Members_List
     */
    public ArrayList<Member> getMember_Bookings()
    {
        ArrayList<Member> memberBookings=new ArrayList<Member>();
        for(Member member : Members_List) 
        {
            if(member.isFound())
            {
                memberBookings.add(member);
            }
        }
        return memberBookings;
    }

    /** 
     * This is a method used 
     * to get the read all the Members from the ArrayList 
     * thrown Exception
     * @return Members_List
     */ 
    public void readAllMembers_List() throws ClubClassException
    {
        try
        {
            ArrayList<String> Data=FileUtility.readFromFile("MemberList.txt");
            for(String member : Data)
            {
                this.Members_List.add(new Member(member));
            }
            //IO_Support.println("Members" + Members_List);
        }
        catch(Exception ex)
        {
            throw new ClubClassException("Error Found in readAllMembers_List() method while reading a file which was not found or was corrupted");
        }
    }

    /**  
     * This is a method used 
     * to get the read all the Sports from the ArrayList 
     * thrown Exception
     * @return Sports_List
     */
    public void readAllSports_List() throws ClubClassException
    {
        try
        {
            ArrayList<String> Data=FileUtility.readFromFile("SportList.txt");
            for(String sport: Data)
            {
                if(sport.startsWith("Tennis"))
                {
                    this.Sports_List.add(new Tennis(sport));
                    //IO_Support.println(Sports_List);
                }
                else if(sport.startsWith("Squash"))
                {
                    Sports_List.add(new Squash(sport));
                    //IO_Support.println(Sports_List);
                }
                else if(sport.startsWith("Badminton"))
                {
                    Sports_List.add(new Badminton(sport));
                    //IO_Support.println(Sports_List);
                }
            }
            //IO_Support.println("Sports" + Sports_List);
        }
        catch(Exception ex)
        {
            throw new ClubClassException("Error Found in readAllSports_List() method while reading a file which was not found or was corrupted");
        }
    }

    /**  
     * This is a method used 
     * to get the Write all the Bookings from the ArrayList
     */
    public void writeAllBookings() throws ClubClassException
    {
        try
        {
            ArrayList<String> Data=new ArrayList<String>();
            for(Member m : Members_List)
            {
                m.saveBooking(Data);
            }
            FileUtility.writeToFile("SavedData.txt",Data);
            //IO_Support.saveData("SavedData.txt",Data);
        }
        catch(Exception ex)
        {
            throw new ClubClassException("Error Found in writeAllBookings() method while Writing a file which was not found or was corrupted");
        }
    }

    /**  
     * This is a method used 
     * to get the read all the Bookings 
     */
    public void readAllBookings() throws ClubClassException
    {
        try
        {
            ArrayList<String> Data = FileUtility.readFromFile("SavedData.txt");
            for(String s:Data)
            {
                new Booking(s);
            }
        }
        catch(Exception ex)
        {
            throw new ClubClassException("Error Found in readAllBookings() method while reading a file which was not found or was corrupted");
        }
    }

    /**  
     * This is a toString() method used 
     * to print the Club_Name from the Class Club
     * @return Club_Name
     */
    public String toString()
    {
        return "Club_Name" + this.Club_Name ;
    }
}//endofclass