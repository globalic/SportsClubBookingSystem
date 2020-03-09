/**
 * Imporing classes for util
 * and LocalDate
 */
import java.util.*;
import java.io.*;
/**
 * This class is the FileUtility
 * of SwinClub Booking System
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */
public class FileUtility
{
    /**
     * This is the FileUtility Class Constructor 
     * with no parameters
     */
    public FileUtility()
    {
    }

    /**
     * This method is used to save data into a file 
     * specified by filename
     * @param fileName is the name of the file 
     * @param data is the actual arrayList to be
     * stored into a file
     * @throws IOException to check for any errors
     * related to file writing
     */
    public static void writeToFile(String fileName, ArrayList<String> data) throws IOException
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for(String s : data)
            {
                pw.println(s);
            }
            pw.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    /**
     * This methos is used to Write data to file 
     * @param fileName
     * @param data 
     */
    public static void writeToLogFile(String fileName,String data)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.println(data);
            pw.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    /**
     * This method is used to read data from a file 
     * specified by filename
     * @param fileName is the name of the file 
     * @throws IOException to check for any errors
     * related to file reading
     */
    public static ArrayList<String> readFromFile(String fileName) throws Exception
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String temp = in.readLine(); 
        while (temp != null)
        {
            data.add(temp);
            temp = in.readLine();
        }
        in.close();
        return data;
    }
    
    /**
     * This method is used to read data from a file 
     * specified by filename
     * @param fileName is the name of the file 
     * @throws IOException to check for any errors
     * related to file reading
     */
    public static ArrayList<String> readData(String fileName) throws Exception
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String temp = in.readLine(); 
        while (temp != null)
        {
            data.add(temp);
            temp = in.readLine();
        }
        in.close();
        return data;
    }
}//end of class