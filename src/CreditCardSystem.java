import java.util.*;
public class CreditCardSystem
{
    //hashtable to contain credit cards
    private TreeMap<Long,CreditCard> creditCards = new TreeMap<Long,CreditCard>();
    
    /**
     * Creates a new record of the credit card account and
     * adds it into the system.
     * 
     * @param ccNum       credit card number
     * @param cardHolder  card holder name
     * @param creditLimit credit limit
     * @param curBalance  current balance of card
     */
    public void createRecord(Long ccNum, String cardHolder, double creditLimit, double curBalance)
    {
        if(!creditCards.containsKey(ccNum))
        {
            creditCards.put(ccNum, new CreditCard(ccNum, cardHolder, creditLimit, curBalance));
        }
        else
        {
            System.out.println("ERROR: Credit card number " + ccNum + " is already in the system.\n" +
                               cardHolder + " not added to system.\n");
        }
    }
    
    /**
     * Deletes record of the credit card account from the system.
     * 
     * @param ccNum credit card number
     */
    public void deleteRecord(Long ccNum)
    {
        creditCards.remove(ccNum);
    }
    
    /**
     * Changes the credit limit of a specific credit card account.
     * 
     * @param ccNum credit card number
     * @param creditLimit  credit limit
     */
    public void changeCreditLimit(Long ccNum, double creditLimit)
    {
        creditCards.get(ccNum).setCreditLimit(creditLimit);
    }
    
    /**
     * Records the purchase record by adding it into the current balance
     * of the specific credit card account.
     * 
     * @param ccNum        credit card number
     * @param purchaseAmt  amount purchased
     */
    public void purchase(Long ccNum, double purchaseAmt)
    {
        double curBalance = creditCards.get(ccNum).getCurBalance();
        creditCards.get(ccNum).setCurBalance(curBalance + purchaseAmt);
    }
    
    /**
     * Prints the details of a specific credit card account.
     * 
     * @param ccNum credit card number
     */
    public void printRecord(Long ccNum)
    {
        System.out.println(creditCards.get(ccNum));
    }
    
    /**
     * Prints all the credit card account details of the credit card system.
     */
    public void printAll()
    {   List<Map.Entry> list = new ArrayList<Map.Entry>(creditCards.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry>() 
        {
            public int compare(Map.Entry card1, Map.Entry card2) 
            {                
                CreditCard c1 = (CreditCard) card1.getValue();
                CreditCard c2 = (CreditCard) card2.getValue();
                
                return c1.compareTo(c2);
            }
        });
        
        System.out.println("+-------------------------+\n" +
                           "+----PRINT ALL RECORDS----+\n" +
                           "+-------------------------+\n");
        
        for(Map.Entry cc: list)
        {
            System.out.println(cc.getValue());
        }
    }
}
