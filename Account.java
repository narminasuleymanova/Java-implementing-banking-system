import java.math.BigDecimal;

public abstract class Account {
    private String id; 
    private BigDecimal balance;

    public Account(String id) {
        this.id=Util.getRandomString();
        this.balance=BigDecimal.ZERO;
    }

    public void setID(String id) {
        this.id=Util.getRandomString();
    }

    public void setBalance(BigDecimal balance) {
        this.balance=balance;
    }

    public String getID() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
    }
    

    public abstract void withdraw(BigDecimal amount) throws IllegalArgumentException;

}

