import java.io.*;
import java.util.*;
public class StartCreditCardSystem
{
    static ReadOpsFile ops      = new ReadOpsFile();      //initialize read operation file class
    static CreditCardSystem sys = new CreditCardSystem(); //initialize CreditCardSystem
        
    //time benchmarks for reading operations
    static long startTime, 
                endTime, 
                totalTime;
                
    public static void main(String[] args) throws IOException
    {
        //initialize user input for menu
        Scanner input = new Scanner(System.in);
        String  userInput;
        boolean menuExit = false;
        
        System.out.println("+-----------------------------------+\n" +
                           "+-----------Welcome to the----------+\n" + 
                           "+-----Credit Card Account System----+\n" +
                           "+-----------------------------------+");
        
        //initialize menu
        while(!menuExit)
        {
            System.out.print("\nPlease enter the operations file name or enter 'X' to exit: ");
            
            userInput = input.nextLine().toUpperCase();
            
            switch(userInput)
            {
                case "X":
                    menuExit = true;
                    break;
                default:
                    try 
                    {
                        runTest(userInput);
                    } 
                    catch (FileNotFoundException error) 
                    {
                        System.out.println("ERROR: File name does not exist. Please try again.");
                    }
                    break;
            }
        }
        
        System.out.println("Thank you for using the Credit Card Account System.\n" +
                           "Please run the TestSystem class for further system tests.");
    }
    
    /**
     * Runs the operations test on the credit card system.
     * 
     * @param test operations file name
     */
    public static void runTest(String test) throws IOException
    {
        System.out.println("+-----"+test+"-----+\n");
        startTime = System.currentTimeMillis();
        sys       = ops.readOperations(test, sys);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        
        System.out.format("Running Time of %1s: %2d ms", test, totalTime);
        System.out.println();
    }
}