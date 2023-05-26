package SBRmiPackage;

public class Account {

	private String accountNumber;
	private String accountHolder;
	private double balance = 0.0;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountNumber, String accountHolder, double balance){
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean deposit(double amount){
		
		if (amount > 0) {
			double newBalance = balance + amount;
			if (newBalance > balance ) {
				return true;
			} else {
			return false;
		}
			}else {
				return false;}
	}

	public boolean withdraw(double amount) {
		
		if (amount > 0) {
			double newBalance = balance - amount;
			if (newBalance < balance ) {
				return true;
			} else {
			return false;
		}
			}else {
				return false;}
	}

	public boolean transfer(Account destinationAccount, double amount) {
		     
        if (amount > 0) {
        	withdraw(amount);
			if (withdraw(amount)) {
				destinationAccount.deposit(amount);
				return true;
				
			} else {
			return false;
		}
			}else {
				return false;}
	}

}


