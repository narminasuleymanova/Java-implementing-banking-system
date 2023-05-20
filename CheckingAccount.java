import java.math.BigDecimal;

public class CheckingAccount extends Account {
    private BigDecimal overDraftLimit;

    public CheckingAccount(String id, BigDecimal balance, BigDecimal overDraftLimit) {
        super(id);
        this.overDraftLimit = overDraftLimit;
    }


    public BigDecimal getOverDraftLimit() {
        return overDraftLimit;
    }


    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal overdraftLimit = getOverDraftLimit();
        BigDecimal availableBalance = getBalance().add(overdraftLimit);
    
        if (amount.compareTo(availableBalance) <= 0) {
            setBalance(getBalance().subtract(amount));
        } else {
            throw new IllegalArgumentException("Withdrawal amount exceeds available balance plus overdraft limit");
        }
}
}