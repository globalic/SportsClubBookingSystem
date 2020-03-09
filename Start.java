import java.io.*;
/**
 * This is the Starting point of
 * SwinClub Booking System where the execution begins
 * @author Bhagyasree Lavanya
 * @@version (1.8.0_101)
 */ 
public class Start
{
    public static void main(String[] args) 
    {
        try
        {  
            Club swinClub = new Club("Swinburne University of Technology - Country Club");
            UserInterface consoleApp = new UserInterface(swinClub);
            consoleApp.run();
            swinClub.writeAllBookings();
            swinClub.readAllSports_List();
            swinClub.readAllMembers_List();
            swinClub.readAllBookings();
        }

        catch(Exception ex)
        {
            FileUtility.writeToLogFile("logFile.txt",ex.getMessage());
            System.out.println(ex);
        }
    }
}//endofclass
