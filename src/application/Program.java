package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(name, anualIncome, gastoSaude));
			}
			else {
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				list.add(new PessoaJuridica(name, anualIncome, employeeNumber));				
			}			
		}		
		System.out.println();
		System.out.println("TAXES PAID");
		double totalTaxa = 0;
		for (Contribuinte contrib : list) {
			System.out.println(contrib.getName() + ": $ " + String.format("%.2f",contrib.taxa()));
			totalTaxa += contrib.taxa();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ " +  String.format("%.2f", totalTaxa));
		
		sc.close();
	}

}
