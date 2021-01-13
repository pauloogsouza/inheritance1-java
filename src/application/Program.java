package application;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer " + i + "# data:");
            System.out.print("Individual or company(i/c)? ");
            char answer = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (answer == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                list.add(new Company(name, annualIncome, numberEmployees));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer t : list) {
            System.out.println(t);
            sum += t.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", sum);

        sc.close();
    }
}
