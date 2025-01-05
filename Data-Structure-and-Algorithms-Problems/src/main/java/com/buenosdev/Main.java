package com.buenosdev;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
Como usuário do relatório de gastos, eu gostaria de poder adicionar um gasto de _alimentação_ chamado
Lunch com um _limite de 3000_.
* */
public class Main {
    public static void main(String[] args) {
        ExpenseReport report = new ExpenseReport();
        ArrayList<Expense> expenses = new ArrayList<>();

        Expense breakfast = new Expense();
        breakfast.amount = 500;
        breakfast.type = ExpenseType.BREAKFAST;
        expenses.add(breakfast);

        Expense dinner = new Expense();
        dinner.amount = 6000;
        dinner.type = ExpenseType.DINNER;
        expenses.add(dinner);

        // LUNCH
        Expense lunch = new Expense();
        lunch.amount = 3001;
        lunch.type = ExpenseType.LUNCH;
        expenses.add(lunch);

        Expense carRental = new Expense();
        carRental.amount = 10000;
        carRental.type = ExpenseType.CAR_RENTAL;

        expenses.add(carRental);


        report.printReport(expenses);
    }
}


enum ExpenseType {
    DINNER("Dinner", true, 5000),
    BREAKFAST("Breakfast", true, 1000),
    CAR_RENTAL("Car Rental", false, -1),
    LUNCH("Lunch", true, 3000);

    private final String name;

    private final boolean isMeal;

    private final int limit;

    ExpenseType(String name, boolean isMeal, int limit) {
        this.name = name;
        this.isMeal = isMeal;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public boolean isTypeMeal() {
        return isMeal;
    }

    public int getLimit() {
        return limit;
    }
}


class Expense {
    ExpenseType type;
    int amount;
}


class ExpenseReport {
    public void printReport(List<Expense> expenses) throws RuntimeException {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + new Date());

        for (Expense expense : expenses) {
            if (expense.type.isTypeMeal()) {
                mealExpenses += expense.amount;
            }

            String expenseName = extractName(expense);

            displayTransactionOverlimit(expense, expenseName);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

    @NotNull
    private static String extractName(Expense expense) {
        return expense.type.getName();
    }

    private static void displayTransactionOverlimit(Expense expense, String expenseName) {
        // Validação de limite
        String mealOverExpensesMarker = expense.type.getLimit() >= 0 && expense.amount > expense.type.getLimit() ? "X" : " ";

        System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);
    }
}
