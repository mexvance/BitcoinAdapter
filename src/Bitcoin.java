import java.util.ArrayList;
import java.util.Vector;

public class Bitcoin implements IBitcoin {

    public Bitcoin () {}
    Vector Transactions = new Vector<Double>();
    ArrayList History = new ArrayList<Double>();
    @Override
    public double getBalance() {
        double total = 0;
        for (int i=0; i < Transactions.size(); i++){
            total += (double)Transactions.get(i);
        }
        return total;
    }

    @Override
    public boolean withdrawal(double amt) {
        //Loop in our array
        var expected = getBalance() - amt;
        if (amt >= getBalance())
        {
            return false;
        }
        History.add(-amt);
        for (int i=0; i < Transactions.size(); i++) {
            while (amt > 0) {
                double CoinAmt = (double) Transactions.get(i);
                if (amt >= CoinAmt) {
                    amt -= CoinAmt;
                    Transactions.remove(i);
                } else {
                    CoinAmt -= amt;

                    //we used all of amt so now we break out of the loop
                    amt = 0;
                    Transactions.remove(i);
                    Transactions.add(CoinAmt);
                }
            }
        }
        if (expected == getBalance())
            return true;
        else
            return false;
    }

    @Override
    public boolean deposit(double amt) {
        double expected = getBalance() + amt;
        if (amt < 0)
        {
            return false;
        }
        Transactions.add(amt);
        //Add to the transaction history
        History.add(amt);
        if (expected == getBalance())
            return true;
        else
            return false;
    }
}
