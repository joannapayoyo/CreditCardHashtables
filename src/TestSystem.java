public class TestSystem
{
    public static void main(String[] args)
    {
        CreditCardSystem sys = new CreditCardSystem();
        
        System.out.println("+------Create Records Test-------+\n");
        sys.createRecord(1111111111111111l, "Vicente Lynn", 21000, 0);
        sys.printRecord(1111111111111111l);
        sys.createRecord(0000000000000000l, "Allan Clark", 43100, 0);
        sys.printRecord(0000000000000000l);
        sys.createRecord(1111111111111111l, "Poop", 43100, 0);
        sys.printRecord(1111111111111111l);
        
        sys.purchase(1111111111111111l, 25);
        System.out.println("Vicente makes $25 purchase.");
        System.out.println("+------Purchase Test-------+\n");
        sys.printAll();
        
        sys.changeCreditLimit(1111111111111111l, 5000);
        System.out.println("Vicente changes credit limit for $5000.");
        System.out.println("+------Change Limit Test-------+\n");
        sys.printAll();
        
        sys.deleteRecord(1111111111111111l);
        System.out.println("Delete Vicente.");
        System.out.println("+------Delete Test-------+\n");
        sys.printAll();
        
        System.out.println("+------Print Record Test-------+\n");
        sys.printRecord(0000000000000000l);
    }
}
