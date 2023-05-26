package SBRmiPackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankImpl extends UnicastRemoteObject implements Bank {
	
	Account account = new Account();
	 private Map<String, Account> accounts;
	 
		public BankImpl() throws RemoteException {
			super();
			accounts = new HashMap<>();
		}

		@Override
		public boolean createAccount(String accountNumber, String accountHolder, double initialBalance)
				throws RemoteException {
			if (!accounts.containsKey(accountNumber)) {
	            Account account = new Account(accountNumber, accountHolder, initialBalance);
	            accounts.put(accountNumber, account);
	            return true;
	        } else {
	            return false;
	        }
		}

		@Override
		public double getBlance(String accountNumber) throws RemoteException {
			 Account account = getAccount(accountNumber);
		        if (account != null) {
		            return account.getBalance();
		        } else {
		            throw new RemoteException("Compte Inexistant !!!!");
		        }
		}

		@Override
		public boolean deposit(String accountNumber, double amount) throws RemoteException {
			 Account account = getAccount(accountNumber);
		        if (account != null) {
		            account.deposit(amount);
		            return true;
		        } else {
		        	return false;
		        }
		}

		@Override
		public boolean withdraw(String accountNumber, double amount) throws RemoteException {
			 Account account = getAccount(accountNumber);
		        if (account != null) {
		            account.withdraw(amount);
		            return true;
		        } else {
		        	return false;
		        }
		}

		@Override
		public boolean transfer(String sourceAccountNumber, String destinationAccountNumber, double amount)
				throws RemoteException {
			Account accountSource = getAccount(sourceAccountNumber);
			Account destinationSource = getAccount(destinationAccountNumber);
	        if (accountSource != null && destinationSource != null) {
	        	accountSource.transfer(destinationSource, amount);
	            return true;
	        } else {
	        	return false;
	        }
		}
		
		private Account getAccount(String accountNumber) {
	        return accounts.get(accountNumber);
	    }

}
