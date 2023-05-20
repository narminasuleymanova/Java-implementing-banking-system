import java.math.BigDecimal;
import java.util.*;
public class Customer {
    private String id;
    private String fullName;
    private List<Account> accs = new ArrayList<>();

    public Customer(String id, String fullName) {
        this.id=Util.getRandomString();
        this.fullName=fullName;
    }

    public void setID(String id) {
        this.id=Util.getRandomString();
    }

    public void setFullName(String fullName) {
        this.fullName=fullName;
    }

    public String getID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<Account> getAccounts() { //returns all accounts
        return new ArrayList<>(accs);
    }

    public void addAccount(Account account) {
        accs.add(account);
    }

    public void removeAccount(Account account) {
        if (!accs.contains(account)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        accs.remove(account);
    }
   

    public void removeAccount(String accountID) {
        for (Account account : accs) {
            if (account.getID().equals(accountID)) {
                accs.remove(account);
                return;
            }
        }
        throw new IllegalArgumentException("Account with ID " + accountID + " does not exist");
    }
    
    

    public BigDecimal getTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (Account account : accs) {
            total = total.add(account.getBalance());
        }
        return total;
    }

    public List<Account> getAccounts(String type) {
        if (!type.equals("checking") && !type.equals("saving")) {
            throw new IllegalArgumentException("Invalid account type specified: " + type);
        }
    
        List<Account> typeAcc = new ArrayList<>();
        for (Account account : accs) {
            if (account instanceof CheckingAccount && type.equals("cheking"))
                typeAcc.add(account);
            else if (account instanceof SavingAccount && type.equals("saving"))
                typeAcc.add(account);
        }
        return typeAcc;
    }
    
    
}
