package bankapp;
import java.util.ArrayList;
import java.util.List;

public class User {
	 private String username;
	    private String password;
	    private double balance;
	    private List<String> transactionHistory;

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.balance = 0.0;
	        this.transactionHistory = new ArrayList<>();
	    }

	    public String getUsername() {
	        return username;
	    }

	    public boolean authenticate(String inputPassword) {
	        return this.password.equals(inputPassword);
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	    	
	        balance += amount;
	        transactionHistory.add("Deposited $" + amount);
	    }

	    public boolean withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            transactionHistory.add("Withdrew $" + amount);
	            return true;
	        }
	        return false;
	    }

	    public List<String> getTransactionHistory() {
	        return transactionHistory;

}
}
