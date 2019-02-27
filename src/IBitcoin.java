public interface IBitcoin {
    public double getBalance();
    public boolean withdrawal(double amt);
    public boolean deposit(double amt);
}
