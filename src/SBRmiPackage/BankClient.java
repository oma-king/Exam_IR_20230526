package SBRmiPackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class BankClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Bank obj = (Bank) Naming.lookup("rmi://localhost:1099/BankImplObject");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insérer le numéro du 1er compte : ");
		String accountNumberInput1 =  scanner.nextLine();
		
		System.out.println("Insérer le nom du 1er propriètaire : ");
		String accountHolderInput1 =  scanner.nextLine();
		
		System.out.println("Insérer le solde inital du 1er compte: ");
		double initialBalanceInput1 =  scanner.nextDouble();
		
		obj.createAccount(accountNumberInput1, accountHolderInput1, initialBalanceInput1);
		
		System.out.println("Insérer le numéro du 2eme compte : ");
		String accountNumberInput2 =  scanner.nextLine();
		
		System.out.println("Insérer le nom du 2eme propriètaire : ");
		String accountHolderInput2 =  scanner.nextLine();
		
		System.out.println("Insérer le solde inital du 2eme compte: ");
		double initialBalanceInput2 =  scanner.nextDouble();
		
		obj.createAccount(accountNumberInput2, accountHolderInput2, initialBalanceInput2);
		
		System.out.println("Insérer le numéro du compte pour consulter son solde : ");
		String accountNumberInput =  scanner.nextLine();

		System.out.print("Le solde du compte  :"  +  accountNumberInput + " est " + obj.getBlance(accountNumberInput));
		
		System.out.println("Insérer le numéro du compte pour faire un versement : ");
		String accountNumberInput3 =  scanner.nextLine();
		System.out.println("Insérer le montant a versé : ");
		double amountInput1 =  scanner.nextDouble();
		obj.deposit(accountNumberInput3,amountInput1);
		
		System.out.print("Le nouveau solde du compte  :"  +  accountNumberInput3 + " aprés versement est " + obj.getBlance(accountNumberInput3));
		
		System.out.println("Insérer le numéro du compte pour faire un retait : ");
		String accountNumberInput4 =  scanner.nextLine();
		System.out.println("Insérer le montant a retiré : ");
		double amountInput2 =  scanner.nextDouble();
		obj.withdraw(accountNumberInput4,amountInput2);
		
		System.out.print("Le nouveau solde du compte  :"  +  accountNumberInput3 + " aprés retrait est " + obj.getBlance(accountNumberInput3));
		
		
		System.out.println("Insérer le numéro du compte pour faire le transfer : ");
		String accountNumberInput5 =  scanner.nextLine();
		System.out.println("Insérer le montant du transfer : ");
		double amountInput3 =  scanner.nextDouble();
		obj.transfer(accountNumberInput1,accountNumberInput5,amountInput3);
		
		System.out.print("Le nouveau solde du 1er compte  :"  +  accountNumberInput1 + " aprés tranfer est " + obj.getBlance(accountNumberInput1));
		System.out.print("Le nouveau solde du compte fournit  :"  +  accountNumberInput5 + " aprés tranfer est " + obj.getBlance(accountNumberInput5));
	}

}
