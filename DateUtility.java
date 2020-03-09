/**
 * Imporing classes for util
 * and LocalDate, LocalTime
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 * This class is the DateUtility
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class DateUtility 
{
    /**
     * This is a method used to convert 
     * Date string into LocalDate
     * @param Date date string
     * @return LocalDate
     */
    public static LocalDate convertDate(String Date) 
    {
        LocalDate date=null;
        try 
        {
            date=LocalDate.parse(Date);
        } 
        catch (Exception ex) 
        {
            IO_Support.println("Exception in String to Date conversion" +ex);
        }
        return date;
    }

    /**
     * This is a method used 
     * to convert Time string into LocalTime
     * @param aDate time string
     * @return LocalTime 
     */
    public static LocalTime convertTime(String Time) 
    {
        LocalTime time=null;
        try 
        {
            time=LocalTime.parse(Time);
        } 
        catch (Exception ex) 
        {
            IO_Support.println("Exception in String to Time conversion" + ex);
        }
        return time;
    }

    /**
     * This method is used to 
     * convert the time to String from the Object of LocalTime
     * @param Time  LocalTime 
     * @return time as string
     */
    public static String timeToString(LocalTime Time) 
    {
        LocalTime time=Time;
        return time.toString();
    }

    /**
     * This method is used to 
     * convert the date to String from the Object of LocalDate
     * @param Date LocalDate
     * @return dt as string
     */
    public static String dateToString(LocalDate Date) 
    {
        LocalDate dt=Date;
        return dt.toString();
    }
}//endofcalss