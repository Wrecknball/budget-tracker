import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BudgetApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // BudgetCategory groceries = new BudgetCategory("Groceries", 500, 401);
        // System.out.println(groceries.toString());
        List<BudgetCategory> budgetList = new ArrayList<>();

        while(scan.hasNextLine()) {
            String category = scan.nextLine();

            double limit = scan.nextDouble();
            double spent = scan.nextDouble();

            // Consume \n after spent input 
            if(scan.hasNextLine()) scan.nextLine();

            String limitString = String.format("$%.2f", limit);
            String spentString = String.format("$%.2f", spent);
            BudgetCategory budget = new BudgetCategory(category, limit, spent);
            budgetList.add(budget);
        }
        System.out.println("No sorting: " + budgetList);
        Collections.sort(budgetList);
        System.out.println("");
        System.out.println("Sorted from least overspent to most: " + budgetList);
        Collections.sort(budgetList, Comparator.reverseOrder());
        System.out.println("");
        System.out.println("Sorted from most overspent to least: " + budgetList);
        System.out.println("");
        System.out.println("The total above/below budget you are is: $" + budgetDifference(budgetList));
        System.out.println("");
        budgetChart(budgetList);
    }

    /**
     * Returns overall how much over/under budget a person is given a list of their
     * categories.
     * 
     * This should be the sum of how much over/under budget each individual category is.
     * 
     * If the person is under budget, the result will be negative. If they are over budget, the
     * result will be positive.
     * 
     * @param categories the budget categories with the spend
     * @return the total amount over/under budget
     */
    public static double budgetDifference(List<BudgetCategory> categories) {
        // TODO: You will implement this method in Wave 4
        // Note that this method SHOULD NOT have a print statement.
        // It should instead return the value.
        double total = 0;
        for (BudgetCategory budget : categories) {
            total += budget.getSpent() - budget.getLimit();
        }
        return total;
    }

    public static void budgetChart(List<BudgetCategory> categories) {
        System.out.println("-----Budget-----");
        System.out.println("Each * = $100, | = budget limit");
        System.out.println("");

        for (BudgetCategory category : categories) {
            System.out.printf("%-10s: ", category.getCategory());

            double limit = category.getLimit();
            double spent = category.getSpent();

            int limitStars = (int) (limit / 10);
            int spentStars = (int) (spent / 10);

            for (int i = 0; i < Math.min(spentStars, limitStars); i++) {
                System.out.print("*");
            }

            for (int i = spentStars; i < limitStars; i++) {
                System.out.print(" ");
            }

            System.out.print("|");

            for (int i = limitStars; i < spentStars; i++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
