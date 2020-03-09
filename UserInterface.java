/**
 * Importing classes for time, ArrayList
 */
import java.util.ArrayList;
import java.time.*;
/**
 * This class is the actual User interface
 * of Parking Spot System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class UserInterface
{
    /**   
     * Declaring an instance of CarPark Class  
     */
    private Club swinClub;
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface(Club swinClub)
    {
        this.swinClub = swinClub; 
    }

    /**   
     * This method calls the menu() method 
     * which asks the user for his
     * input   
     */
    public void run() throws Exception
    {
        while(true)
            switch (menu()) 
            {
                case 1:
                showAvailableCourts();
                break;
                case 2:
                makeBooking();
                break;
                case 3:
                showMemberBookings();
                break;
                case 4:
                showCourtBookings();
                break;
                case 5:
                deleteBooking();
                break;
                case 6:
                return;   
                default:
                System.out.println ("Invalid option");
                break;
            }
    }

    /**  
     * This method asks the user for the input  
     * which is directed to the switch case above   
     */
    private int menu()
    {   
        IO_Support.println ("|------------------------------------------------|");
        IO_Support.println ("| 1. Show Available Courts                      |");
        IO_Support.println ("| 2. Make Booking for Member                    |");
        IO_Support.println ("| 3. Show Member Bookings                       |");
        IO_Support.println ("| 4. Show Court Bookings                        |");
        IO_Support.println ("| 5. Delete Booking                             |");
        IO_Support.println ("| 6. Exit                                       |");
        IO_Support.println ("|------------------------------------------------|");
        return IO_Support.getInteger("Select Option:");
    }

    /**
     * This method is used to
     * Show all the Available Courts for the ArrayList
     */
    private void showAvailableCourts()
    {
        IO_Support.println("Available Courts are:");
        LocalDate Date;
        LocalTime start_Time;
        int Duration=120;
        String Sport_Name = IO_Support.getString("|| Sports Selection || \n * Tennis \n * Squash \n * Badminton \n Please select a Sport_Name:");
        Sport sport_Name = swinClub.findSport(Sport_Name); 
        IO_Support.println("Sport Details:" + sport_Name); 
        String DateToBook = IO_Support.getString("Enter the Booking_Date in given Format (yyyy-mm-day):");
        Date = DateUtility.convertDate(DateToBook);
        LocalDate date = LocalDate.now();
        LocalDate checkDay = Date.plusDays(7);
        if(date.equals(checkDay)||checkDay.isAfter(date))
        {
            String time=IO_Support.getString("Please Enter Booking_Time in given Format (hh:mm):");
            start_Time = DateUtility.convertTime(time);
            Duration = IO_Support.getInteger("Please Enter Duration to play in Minutes:");
            if(Sport_Name.equals("Tennis"))
            {
                if(Duration>120)
                {
                    IO_Support.println("|| A Tennis Court can be Booked for 2 hours/day ||");
                    return;
                }
            }
            else if(Sport_Name.equals("Squash"))
            {
                if(Duration>60)
                {
                    IO_Support.println("|| A Squash Court can be Booked for 1 hour/day ||");
                    return;
                }
            }
            else if(Sport_Name.equals("Badminton"))
            {
                if(Duration>60)
                {
                    IO_Support.println("|| A Badminton Court can be Booked for 1 hour/day ||");
                    return;
                } 
            }
            for(Court court : sport_Name.getCourt_Bookings(Date,start_Time,Duration))
            {
                IO_Support.println("Court_ID:" + court.getCourt_ID());  
            }
        }
        else
        {
            IO_Support.println("|| Invalid Date || \n Booking can only be done in 7 days Advance");
        }
    }

    /**
     * This method is used to
     * make the Booking by checking the Member_ID 
     * whether it is Financial or not
     */
    private void makeBooking()
    {
        IO_Support.println("Creating a new Booking ...");
        int Member_ID;
        int Court_ID;
        LocalDate Date;
        LocalTime start_Time;
        LocalTime End_Time;
        int Duration=120;

        String Sport_Name=IO_Support.getString("|| Sports Selection || \n * Tennis \n * Squash \n * Badminton \n Please select a Sport_Name:");
        Sport sport_Name = swinClub.findSport(Sport_Name); 
        IO_Support.println("Sport Details:" + sport_Name);

        String date_String = IO_Support.getString("Please Enter Date in Format to  make Booking (yyyy-mm-day):");
        Date = DateUtility.convertDate(date_String);

        LocalDate date = LocalDate.now();
        LocalDate checkDay = Date.minusDays(7);
        if(date.equals(checkDay)||checkDay.isBefore(date))
        {
            String time = IO_Support.getString("Please Enter Time in Format to make Booking (hh:mm):");
            start_Time = DateUtility.convertTime(time);
            IO_Support.println("start_Time:" + start_Time);
            Duration = IO_Support.getInteger("Please Enter Duration in Minutes:");
            if(Sport_Name.equals("Tennis"))
            {
                if(Duration>120)
                {
                    IO_Support.println("|| A Tennis Court can be Booked for 2 hours/day ||");
                    return;
                }
            }
            else if(Sport_Name.equals("Squash"))
            {
                if(Duration>60)
                {
                    IO_Support.println("|| A Squash Court can be Booked for 1 hour/day ||");
                    return;
                }
            }
            else if(Sport_Name.equals("Badminton"))
            {
                if(Duration>60)
                {
                    IO_Support.println("|| A Badminton Court can be Booked for 1 hour/day ||");
                    return;
                } 
            }
            End_Time = start_Time.plusMinutes(Duration);
            IO_Support.println("End_Time:" + End_Time);
            if((start_Time.isAfter(Club.getOpenTime())) || (start_Time.equals(Club.getOpenTime())) &&
            (End_Time.isBefore(Club.getCloseTime())) || (start_Time.equals(Club.getCloseTime())))
            {
                IO_Support.println("Available Courts are:");
                for(Court court : sport_Name.getCourt_Bookings(Date,start_Time,Duration))
                {
                    IO_Support.println("Court_ID:" + court.getCourt_ID());  
                }
                Member_ID=IO_Support.getInteger("Please Enter Member_ID:");
                Member member=swinClub.findMember(Member_ID);
                if(this.swinClub.findMember(Member_ID).isFinancial())
                {
                    Court_ID = IO_Support.getInteger("Please Enter Court_ID:");
                    Court court=swinClub.findCourt(Court_ID); 
                    if(court==null)
                    {
                        IO_Support.println("Court not Found");
                        return;
                    }
                    else if(Court_ID==court.getCourt_ID())
                    {
                        ArrayList<Booking>newBooking=new ArrayList<Booking>();
                        newBooking = member.getMemberBooking();
                        //boolean bookedTime=false;
                        boolean bookedDate=false;
                        for(Booking b : newBooking)
                        {
                            //LocalTime newtime=b.getstart_Time();
                            LocalDate newDate=b.getBooking_Date();
                            if(Date.equals(newDate))// && start_Time.equals(newtime))
                            {
                                //bookedTime=true; 
                                bookedDate=true;
                            }
                        }
                        if(bookedDate==false)// && bookedTime==false)
                        {
                            court.addBooking(new Booking(Duration,Date,start_Time,End_Time,member,court));
                            member.addBooking(new Booking(Duration,Date,start_Time,End_Time,member,court));
                            IO_Support.println(" || This Member is Financial .. || \n Booking created Successfully !!");
                            //return true;
                        }
                        else
                        {
                            IO_Support.println("|| Booking is already done in this Date||\n || Please try to book in other Date .. ||");
                        }
                    }
                }
                else 
                {
                    IO_Support.println(" || This Member is not Financial .. || \n|| Court is not Available to make Booking as the Sport is not Supported to the given Member_ID");
                }
            }
            else
            {
                IO_Support.println("|| Please Enter Court Open_Time in between 8:00 AM to 23:00 PM ||");
            }
        }
        else
        {
            IO_Support.println("|| Invalid Date || \n || Booking can only be done in 7 days Advance ..||");
        }
    }

    /*Duration = IO_Support.getInteger("Please Enter Duration in Minutes:");
    End_Time = start_Time.plusMinutes(Duration);
    IO_Support.println("End_Time:" + End_Time);*/

    /**
     * This method is used to 
     * show the particualr Member_Booking 
     * when the user gives the input Member_ID
     */
    public void showMemberBookings()
    {
        IO_Support.println("|| Member-Bookings ||");
        int Member_ID;
        ArrayList<Booking> booking = new ArrayList<Booking>();
        Member_ID=IO_Support.getInteger("Please Enter Member_ID:");
        Member member=swinClub.findMember(Member_ID);
        if(member==null)
        {
            IO_Support.println("Member_Booking not found");
        }
        else
        {
            booking = member.getMemberBooking();
            for(Booking b : booking)
            {
                IO_Support.println("Member Booking Details:\n"+b.toString());
            }
            IO_Support.println("Member Found Successfully" + "\n" + member);
            //IO_Support.println(booking.toString());}w
        }
    }

    /**
     * This method is used to 
     * show the particualr Court_Booking 
     * when the user gives the input Court_ID
     */
    private void showCourtBookings()
    {
        IO_Support.println("|| Court-Bookings ||");
        int Court_ID;
        int Member_ID;
        //Booking booking=member.getMemberBooking();
        ArrayList<Booking> booking = new ArrayList<Booking>();
        Court_ID=IO_Support.getInteger("Please Enter Court_ID:");
        Court court=swinClub.findCourt(Court_ID);
        if(court==null)
        {
            IO_Support.println("Court_Booking not Found");
        }
        else
        {
            booking = court.getCourt_Bookings();
            for(Booking new_Booking : booking)
            {
                IO_Support.println("Booking Details of the Court :" + "\n" + new_Booking.toString());
            }
            IO_Support.println("Court Found Successfully" + "\n" + court);
        }
    }

    /**
     * This method is used to 
     * delete the particualr Member_Booking from the ArrayList
     * when the user gives the input Member_ID 
     */
    private void deleteBooking()
    {
        IO_Support.println("Deleting the Current Booking ...");
        int Member_ID;
        int Court_ID;
        LocalDate Date=null;
        LocalTime start_Time=null;
        LocalTime End_Time=null;
        ArrayList<Booking>aBooking;
        Member_ID=IO_Support.getInteger("Please Enter the Member-ID you wish to delete:");
        while(Date==null)
        {
            String Date_String=IO_Support.getString("Please Enter the Date of Booking you wish to delete in Format(yyyy-mm-day):");
            Date = DateUtility.convertDate(Date_String);
        }
        /*while(start_Time==null)
        {
        String starttime=IO_Support.getString("Please Enter the Start_Time of Booking you wish to delete in Format(hh:mm):");
        start_Time = DateUtility.convertTime(starttime);
        }
        while(End_Time==null)
        {
        String endtime=IO_Support.getString("Please Enter the End_Time of Booking you wish to delete in Format(hh:mm):");
        End_Time=DateUtility.convertTime(endtime);  
        }*/
        Member m=swinClub.findMember(Member_ID);
        //Booking booking = swinClub.findBooking(Date,start_Time,End_Time);
        if(m==null)
        {
            IO_Support.println("Booking not Found");
        }
        else
        {
            swinClub.removeBooking(m);
            //Court court =  booking.getCourt();
            //court.deleteBooking(booking);  
            IO_Support.println("Given Booking has been Deleted Successfully");
        } 
    }

    /**
     * This method is used to 
     * list the Member_Bookings
     */
    private void listMemberBooking()
    {
        IO_Support.println("List of the Member-Bookings are:");
        if (swinClub.getMember_Bookings().isEmpty())
        {
            IO_Support.println("No Bookings are currently Found");
        }
        else
        {
            for(Member m:swinClub.getMember_Bookings())
            {
                IO_Support.println(m.toString());
            }
        }
    }
} // end class