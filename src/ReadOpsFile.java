import java.util.*;
import java.io.*;
public class ReadOpsFile
{
    public CreditCardSystem readOperations(String fileName, CreditCardSystem sys) throws IOException
    {
        Scanner scan = new Scanner(new File(fileName)); //initialize scanner for operation file
        
        String operation;   //operation command
        Long   ccNum;       //credit card number
        String cardHolder;  //card holder name
        double creditLimit, //credit limit
               curBalance,  //current balance of card
               purchaseAmt; //purchase amount
        
        //list of credit card numbers with purchase order errors
        ArrayList<Long> purchaseErrors  = new ArrayList<Long>();
                        
        int numOperations = 0, //total number of operations
            numPurErrors  = 0, //total number of purchase errors
            numPurSuccess = 0; //total number of purchase successes
        
        //reads operations file and executes operations
        while(scan.hasNext())
        {
            operation = scan.nextLine();
            numOperations++;
            
            switch(operation)
            {
                case "cre":
                    ccNum = scan.nextLong();
                    scan.nextLine();
                    cardHolder  = scan.nextLine();
                    creditLimit = (double) scan.nextInt();
                    curBalance  = (double) scan.nextInt();
                    sys.createRecord(ccNum, cardHolder, creditLimit, curBalance);
                    break;
                case "del":
                    ccNum = scan.nextLong();
                    sys.deleteRecord(ccNum);
                    break;
                case "lim":
                    ccNum = scan.nextLong();
                    creditLimit = scan.nextDouble();
                    sys.changeCreditLimit(ccNum, creditLimit);
                    break;
                case "pur":
                    ccNum = scan.nextLong();
                    purchaseAmt = scan.nextDouble();
                    try
                    {
                        sys.purchase(ccNum, purchaseAmt);
                        numPurSuccess++;
                    }
                    catch (NullPointerException exc)
                    {
                        purchaseErrors.add(ccNum);
                        numPurErrors++;
                    }
                    break;
            }
            
            if(scan.hasNext())
                scan.nextLine();
        }
        
        System.out.printf("%-32s%-10d\n", "Number of Purchase Errors: ", numPurErrors);
        
        System.out.printf("%-32s%-10d\n", "Number of Purchase Successes: ", numPurSuccess);
                             
        System.out.printf("%-32s%-10d\n", "Number of Operations: ", numOperations);
                           
        return sys;
    }
}