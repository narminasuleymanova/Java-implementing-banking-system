import java.math.BigDecimal;

public class SavingAccount extends Account {
    private BigDecimal interestRade;

    public SavingAccount(String id, BigDecimal balance, BigDecimal interestRade) {
        super(id);
        this.interestRade=interestRade;
    }

    public BigDecimal getInterestRade() {
        return interestRade;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (getBalance().compareTo(amount) >= 0) {
            BigDecimal newBalance = getBalance().subtract(amount);
            setBalance(newBalance);
        } else {
            throw new IllegalArgumentException("Withdrawal amount exceeds available balance");
        }
    }
}
