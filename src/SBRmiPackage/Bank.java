package SBRmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
	public boolean createAccount(String accountNumber, String accountHolder, double initialBalance) throws RemoteException;
	public double getBlance(String accountNumber) throws RemoteException;
	public boolean deposit(String accountNumber, double amount) throws RemoteException;
	public boolean withdraw(String accountNumber, double amount) throws RemoteException;
	public boolean transfer(String sourceAccountNumber,String destinationAccountNumber, double amount) throws RemoteException;
}
