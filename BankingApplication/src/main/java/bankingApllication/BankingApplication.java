package bankingApllication;

import java.util.Scanner;

public class BankingApplication {
	
	/* This is a mobile banking application  
	 * ->	 Application will first display a welcome message to the user
	 * ->    It will display actions to be performed:
	 *   								1.) Check Balance
	 *   								2.) Deposit
	 *  							    3.) Withdraw
	 *                           		4.) Check previous transaction
     *                             	    5.) Exit
	 */
	
	private int balance;
	int deposit;
	private int previousTransaction;
	Scanner scanner = new Scanner(System.in);
	
	BankingApplication(){
//	This is a constructor to get username, greet user, show application options and call the various application methods
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.printf("Welcome %s\n\n",name );
			
		System.out.println(" 1.) Check balance\n 2.) Deposit\n 3.) Withdraw\n 4.) Check previous transaction\n 5.) Exit");
		
		int option;
		do {
			System.out.print("\nEnter an option to proceed: ");
			option = scanner.nextInt();
			
			switch (option) {
				case 1 :
					getBalance(); //Call a method to get user's account balance
					break;
				case 2 : 
					System.out.print("Enter an amount: ");
					int depositAmount = scanner.nextInt();
					deposit(depositAmount);  //Call the deposit method for cash deposit
					break;
				case 3 :
					if (balance <= 0) {
						System.out.print("You don't have a withdrawable balance\n");
					}
					else {
						withdraw(); //Call the withdrawal method for cash withdrawal
					}
					break;
				case 4 :
					if (balance >= 0) {
					getPreviousTransaction(); //Call a method to get user's previous transaction
					}
					break;
				case 5:
					System.out.println("You ended the session");
					break;
				default :
					System.out.println("Your input is incorrect!");
			}
		}		
		while(option != 5);
	}
	
// This is a method for cash deposit
	void deposit(int amount) {
		if (amount != 0) {
			this.deposit = amount;
			this.previousTransaction = amount;
			balance = balance + amount;
			System.out.printf("Deposit of %,d successful👍\n", amount);
		}
	}
	
//	This is a method for cash withdrawal
	void withdraw() {
		int amount;
		do {
			System.out.print("Enter an amount to withdraw: ");
			amount = scanner.nextInt();
			if (amount != 0) {
				if (amount > balance) {
					System.out.print("\nInsufficient balance to carry out transaction\n Enter a lesser amount\n\n");
				}
				else {	
					this.previousTransaction = -amount;
					System.out.printf("Withdrawal of %,d successful👍\n",amount);
				}
			}
		}
		while (amount > balance);
		this.balance = balance - amount;		
	}
	
//	This is a getter method for user's previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.printf("You deposited %,d\n", previousTransaction );
		}
		else if (previousTransaction < 0) {
			System.out.printf("You withdrew %,d\n",Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occurred\n");
		}
	}
	
//	This is a getter method for user's account balance
	void getBalance() {
		if (balance <=0) {
			System.out.println("Your account is empty");
		}
		else {
			System.out.printf("Your balance is %,d\n",balance);
		}
	}
	
	
	
	
	

}

