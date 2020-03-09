/**
 * This is ClubClassException which
 * extends Exception class to handle the error
 * which occured in the Club Class with the methods 
 * that throws this exception.
 * @author Bhagyasree Lavanya 
 * @version 1.8.0_101
 */

public class ClubClassException extends Exception
{
    public ClubClassException(String errorFound) 
    {
        super(errorFound);
    }
}//endofclass