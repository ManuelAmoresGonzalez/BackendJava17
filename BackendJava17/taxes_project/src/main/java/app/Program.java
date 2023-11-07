package app;

import model.Company;
import model.Individual;
import model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of tax payers");
        int numberOfTaxPayers = scanner.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();
        for (int i = 0; i < numberOfTaxPayers; i++) {
            System.out.println("TaxPayer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = scanner.next().charAt(0);
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Anual Income: ");
            Double anualIncome = scanner.nextDouble();
            if (type == 'i') {
                System.out.print("Health Expenditures: ");
                Double healthExpenditures = scanner.nextDouble();
                Individual ind = new Individual(name, anualIncome, healthExpenditures);
                taxPayers.add(ind);
            } else {
                System.out.println("Number of employees: ");
                Integer numberOfEmployees = scanner.nextInt();
                Company company = new Company(name, anualIncome, numberOfEmployees);
                taxPayers.add(company);
            }
        }

        System.out.println("===================");
        System.out.println("TAXES PAID");
        taxPayers.forEach(tax -> {

            System.out.println(tax.getName() + ": $ " + String.format("%.2f", tax.calculateTaxes()));
        });

    }
}
