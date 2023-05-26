package SBRmiPackage;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {

	public static void main(String[] args) throws Exception {
		Bank obj = (Bank) new BankImpl();
		Registry registry = LocateRegistry.createRegistry(1099);
		Naming.bind("BankImplObject",obj);
		System.out.println("Server State is <Ready>  ....");
	}

}
