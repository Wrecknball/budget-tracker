public class BudgetCategory {
    private String name;
    private double limit;
    private double spent;
    
    public BudgetCategory (String name, double limit, double spent) {
        this.name = name;
        this.limit = limit;
        this.spent = spent;
    }

    public String getName() {
            return name;
        }
    public void setName(String name) {
        this.name = name;
    }
    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public double getSpent() {
        return spent;
    }
    public void setSpent(double spent) {
        this.spent = spent;
    }
    @Override
    public String toString() {
        return name + ", " + limit + ", " + spent;
    }
}