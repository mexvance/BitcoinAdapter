public class BitcoinToUSDAdapter implements IBitcoin {

    private Bitcoin bitcoin;
    private double BitValue = 3803.77;
    public BitcoinToUSDAdapter(Bitcoin bitcoin){
        this.bitcoin = bitcoin;
    }
    @Override
    public double getBalance() {
        double total;
        total = bitcoin.getBalance() * BitValue;
        return total;

    }

    @Override
    public boolean withdrawal(double dollarAmt) {
        var BitAmt = dollarAmt / BitValue;
        bitcoin.withdrawal(BitAmt);
        return true;
    }

    @Override
    public boolean deposit(double dollarAmt) {
        var BitAmt = dollarAmt / BitValue;
        bitcoin.deposit(BitAmt);
        return true;
    }
}
