
/**
 * Q2
 * A general function to split text in a file by a specific pattern
 */
public static void splitStringBy(String filename, String pattern) {
    // read texts from file
    // TODO: String[] strs = all lines of text in the file


    // split every line of text by pattern specified in argument
    // this loop is known as 'for each' loop, its usage is the same as normal
    // for loop, just the syntax is different, and it doesn't need any counter
    for(String str: strs) {

        // split a line of text by pattern
        String[] tempStr = str.split(pattern);

        // TODO: print out every line of text splitted by the pattern

    }
}

/**
 * Q4
 * A simple explanation on how to create an ArrayList of Transactions
 */
public static void createArrayListofTransaction() {
    // To create an ArrayList
    // Let E = data type of elements in ArrayList
    // ArrayList<E> anyName = new ArrayList<>();
    // In this case, E = Transaction and 
    // I name this ArrayList as transactionHistory
    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    // In order to add element into ArrayList, use .add(a_transaction)
    transactionHistory.add();
}


/**
 * Q4
 * This part shows the concept you might use for Q4
 * You can create a new class Account1 and 
 * make this class inherit Account class in Q3
 * In this way you can reuse all variables and methods in Q3
 * and overwrite deposit and withdraw methods for new implementations in Q4
 */
public class Class1 {
    private int var1;
    private String var2;

    public Class1(int var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int aFunc() {
        return var1 + 5;
    }
    
}

public class Class2 extends Class1 {
    private int var3;

    public Class2(int var1, String var2, int var3) {
        // super() is to call parent class's constructor
        super(var1, var2);
        this.var3 = var3;
    }

    // Method overwriting
    // This function overwrite the logic of aFunc method in parent class
    public int aFunc() {
        return var3 + 5;
    }

}
