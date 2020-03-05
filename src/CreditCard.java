
public class CreditCard {
    private Long ccNum;         //credit card number
    private String cardHolder;  //card holder name
    private double creditLimit, //credit limit
                   curBalance;  //current balance of card
                   
    public CreditCard(Long ccNum)
    {
        this.ccNum  = ccNum;
        cardHolder  = null;
        creditLimit = 0;
        curBalance  = 0;
    }
                   
    public CreditCard (Long ccNum, String cardHolder, double creditLimit, double curBalance)
    {
        this.ccNum       = ccNum;
        this.cardHolder  = cardHolder;
        this.creditLimit = creditLimit;
        this.curBalance  = curBalance;
    }
    
    public void setCcNum(Long ccNum)
    {
        this.ccNum = ccNum;
    }
    
    public Long getCcNum()
    {
        return ccNum;
    }
    
    public void setCardHolder(String cardHolder)
    {
        this.cardHolder = cardHolder;
    }
    
    public String getCardHolder()
    {
        return cardHolder;
    }
    
    public void setCreditLimit(double creditLimit)
    {
        this.creditLimit = creditLimit;
    }
    
    public double getCreditLimit()
    {
        return creditLimit;
    }
    
    public void setCurBalance(double curBalance)
    {
        this.curBalance = curBalance;
    }
    
    public double getCurBalance()
    {
        return curBalance;
    }
    
    public String toString()
    {
        return "Credit Card Number: " + ccNum +
               "\nName: " + cardHolder +
               "\nCredit Limit: " + creditLimit +
               "\nCurrent Balance: " + curBalance + "\n";
    }
    
    /**
     * Returns the position of the CreditCard object for sorted lists
     * according to the cardholder's name in ascending order.
     * 
     * @return position of CreditCard object
     */
    public int compareTo(CreditCard cc)
    {
        return cardHolder.compareTo(cc.cardHolder);
    }
}
