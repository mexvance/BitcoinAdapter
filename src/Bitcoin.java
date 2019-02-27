import java.util.ArrayList;

public class Bitcoin implements IBitcoin {
    ArrayList MyList = new ArrayList<Double>();
    double  total = 0;
    @Override
    public double getBalance() {
        for (int i=0; i < MyList.size(); i++){
            total += (double)MyList.get(i);
        }
        return total;
    }

    @Override
    public boolean withdrawal(double amt) {
        //Loop in our array
        var expected = getBalance() - amt;
        if (getBalance()-amt < 0)
        {
            return false;
        }
        for (int i=0; i < MyList.size(); i++) {
            while (amt > 0) {
                double CoinAmt = (double) MyList.get(i);
                if (amt >= CoinAmt) {
                    amt -= CoinAmt;
                    MyList.remove(i);
                } else {
                    CoinAmt -= amt;
                    MyList.remove(i);
                    MyList.add(CoinAmt);
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
        double expected = getBalance();
        MyList.add(amt);

        if (expected == getBalance())
            return true;
        else
            return false;
    }
}
