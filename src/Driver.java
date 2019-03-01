public class Driver {
    public static void main(String [] args){

        //Test out our Bitcoin buying and using only bitcoin
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.deposit(2);
        bitcoin.deposit(5);
        bitcoin.deposit(5);
        bitcoin.deposit(5);
        bitcoin.withdrawal(6);
        var val = bitcoin.getBalance();
        System.out.println("There are: " + val + " many Bitcoins in your account \n");
        System.out.println("*****************************************************************************");

        //Test out our dollar functions only using dollars
        USD dollar = new USD();
        dollar.deposit(5);
        dollar.deposit(5);
        dollar.deposit(5);
        dollar.deposit(5);
        dollar.withdrawal(6);
        var val2 = dollar.getBalance();
        System.out.println("There are: " + val2 + " many Dollars in your account \n");
        System.out.println("*****************************************************************************");
        //Test out our adapter using Dollars and converting to bitcoin
        BitcoinToUSDAdapter Adapter = new BitcoinToUSDAdapter(bitcoin);
        var val3 = Adapter.getBalance();
        System.out.println("There are: " + val3 + " many Dollars in your Bitcoin account");
        System.out.println("Buying a 5 dollar Little Ceasars Pizza");
        Adapter.withdrawal(5);
        val3 = Adapter.getBalance();
        System.out.println("There are: " + val3 + " many Dollars in your Bitcoin account");
        val3 = bitcoin.getBalance();
        System.out.println("There are: " + val3 + " many Bitcoins in your Bitcoin account");

        System.out.println("*****************************************************************************");
        //Display the bitcoin history
        System.out.println("There is your Bitcoin transaction history");
        for (int i = 0; i < bitcoin.History.size(); i++){
            System.out.println(i + ". " + bitcoin.History.get(i));
        }
    }
}
