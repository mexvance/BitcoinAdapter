public class BitcoinToUSDAdapter implements IBitcoin {


    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public boolean withdrawal(double amt) {
        return true;
    }

    @Override
    public boolean deposit(double amt) {
        return true;
    }
}
