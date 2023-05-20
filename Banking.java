import java.math.BigDecimal;
import java.util.*;
public class Banking {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            throw new IllegalArgumentException("Customer does not exist.");
        }
        customers.remove(customer);
    }

    public void removeCustomer(String customerID) {
        for (Customer customer : customers) {
            if (customer.getID().equals(customerID)) {
                customers.remove(customer);
            }
        }
        throw new NoSuchElementException("Customer with ID " + customerID + " does not exist.");
    }
    
    
    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String customerID) {
        for (Customer customer : customers) {
            if (customer.getID().equals(customerID)) {
                return customer;
            }
        }
        throw new NoSuchElementException("Customer with ID " + customerID + " does not exist.");
    }
    

    public CheckingAccount createCheckingAccount(Customer customer, BigDecimal balance, BigDecimal overDraftLimit) {
        CheckingAccount checkacc = new CheckingAccount(customer.getID(), balance, overDraftLimit);
        customer.addAccount(checkacc);
        return checkacc;
    }

    public SavingAccount createSavingAccount(Customer customer, BigDecimal balance, BigDecimal interestRate) {
        SavingAccount savingacc = new SavingAccount(customer.getID(), balance, interestRate);
        customer.addAccount(savingacc);
        return savingacc;
    }
}
