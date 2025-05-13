package bankapp;
import java.util.HashMap;
import java.util.Scanner;


public class BankApplication {
	
	static HashMap<String, User> users = new HashMap<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		 users.put("alice", new User("alice", "1234"));
	        users.put("bob", new User("bob", "abcd"));

	        System.out.println("=== Welcome to Simple Banking App ===");
	        User currentUser = login();

	        if (currentUser != null) {
	        	
	            showBankingMenu(currentUser);
	            
	        }

	        scanner.close();
	    }

	    private static User login() {
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();

	        if (!users.containsKey(username)) {
	            System.out.println("User not found!");
	            return null;
	        }

	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();

	        User user = users.get(username);
	        if (user.authenticate(password)) {
	            System.out.println("Login successful. Welcome, " + username + "!");
	            return user;
	        } else {
	            System.out.println("Incorrect password.");
	            return null;
	        }
	    }

	    private static void showBankingMenu(User user) {
	        int choice;

	        do {
	            System.out.println("\n--- Banking Menu ---");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. View Transaction History");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	
	                    System.out.print("Enter amount to deposit: ");
	                    double depositAmount = scanner.nextDouble();
	                    user.deposit(depositAmount);
	                    System.out.println("Deposited successfully.");
	                    break;
	                case 2:
	                    System.out.print("Enter amount to withdraw: ");
	                    double withdrawAmount = scanner.nextDouble();
	                    if (user.withdraw(withdrawAmount)) {
	                        System.out.println("Withdrawal successful.");
	                    } else {
	                        System.out.println("Insufficient balance or invalid amount.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Current Balance: $" + user.getBalance());
	                    break;
	                case 4:
	                    System.out.println("--- Transaction History ---");
	                    for (String record : user.getTransactionHistory()) {
	                        System.out.println(record);
	                    }
	                    break;
	                case 5:
	                    System.out.println("Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }

	        } while (choice != 5);

	}

}
