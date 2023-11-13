package org.example;

import java.util.Scanner;

public class ExpensesApp {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();
        while(true) {
            System.out.println("1. Display expenses");
            System.out.println("2. View expenses for the month");
            System.out.println("3. Add expense");
            System.out.println("4. Finish applications");
            System.out.print("Select options: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> expenseManager.displayAllDispenses();
                case 2 -> expenseManager.displayMonthlyExpenses(scanner);
                case 3 -> expenseManager.addExpense(scanner);
                case 4 -> {
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}
