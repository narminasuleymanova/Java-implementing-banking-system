import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BankingDemo {
    public static void main(String[] args) {
        CheckingAccount checkacc = new CheckingAccount(null, null, BigDecimal.valueOf(200));
        System.out.println(checkacc.getBalance()); // to show that initial value is set to zero 
        checkacc.setBalance(BigDecimal.valueOf(1200));
        System.out.println("the balance is: " + checkacc.getBalance());
        System.out.println("the over draft limit is: " + checkacc.getOverDraftLimit());
        try {
            checkacc.deposit(BigDecimal.valueOf(100));
        }  catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("new balance is: " + checkacc.getBalance());
        try {
            checkacc.deposit(BigDecimal.valueOf(-100));
        }  catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } // the deposit method
        

        try {
            checkacc.withdraw(new BigDecimal("50"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("balance after withdraw is: " + checkacc.getBalance());
        try {
            checkacc.withdraw(new BigDecimal("2000"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } //to show that i cant withdraw to negative value
        System.out.println("balance after withdraw is: " + checkacc.getBalance());

        SavingAccount savingacc = new SavingAccount(null, null, BigDecimal.valueOf(40));
        System.out.println(savingacc.getBalance()); //to show that initial value is set to zero
        savingacc.setBalance(BigDecimal.valueOf(3000));
        System.out.println("the balance is: " + savingacc.getBalance());
        savingacc.deposit(BigDecimal.valueOf(1000));
        System.out.println("the new balance is: " + savingacc.getBalance());
        try {
            savingacc.withdraw(BigDecimal.valueOf(100));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the balance after withdraw is: " + savingacc.getBalance());
        try {
            savingacc.withdraw(BigDecimal.valueOf(5000));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } // to show that this value cant be withdrawed 
        System.out.println("the balance after withdraw is: " + savingacc.getBalance());

        Customer customer = new Customer(null, "Narmina");
        System.out.println("the id is: " + customer.getID());
        System.out.println("the full name is: " + customer.getFullName());
        customer.addAccount(savingacc);
        customer.addAccount(checkacc);
        System.out.println(customer.getAccounts());
        try {
            customer.removeAccount(savingacc);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.getAccounts()); // to show that saving acc is removed
        try {
            customer.removeAccount(savingacc);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.getAccounts()); // to show that already removed account cant be removed again
        customer.addAccount(savingacc);
        System.out.println(customer.getAccounts());
        System.out.println("total balance is: " + customer.getTotalBalance());
        System.out.println("get all saving accs: " + customer.getAccounts("saving"));
        Customer customer2 = new Customer(null, "Jeyla");
        Customer customer3 = new Customer(null, "Sabina");
        Customer customer4 = new Customer(null, "Fakhri");

        
        Banking bank = new Banking();
        bank.addCustomer(customer);
        System.out.println("the customer is: " + bank.getCustomers());
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);
        System.out.println("all the customers are: " + bank.getCustomers());
        bank.removeCustomer(customer3);
        System.out.println("the customers are: " + bank.getCustomers()); //to show that customer is deleted
        try{
            bank.removeCustomer(customer3);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()); // to show that i cant delete already deleted customer
        }
        System.out.println("the customers are: " + bank.getCustomers());
        bank.addCustomer(customer3);
        bank.createCheckingAccount(customer3, BigDecimal.valueOf(5000), BigDecimal.valueOf(100));
        bank.createSavingAccount(customer4, BigDecimal.valueOf(3000), BigDecimal.valueOf(40));
        System.out.println("the customers are: " + bank.getCustomers());
        try {
            bank.getCustomer("42110406");
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the customers are: " + bank.getCustomers());

        

     }
}
