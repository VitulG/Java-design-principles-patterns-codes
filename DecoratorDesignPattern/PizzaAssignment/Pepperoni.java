package DecoratorDesignPattern.PizzaAssignment;

public class Pepperoni extends Pizza {
    public Pepperoni() {
        pizzaName = "Pepperoni Pizza";
    }

    @Override
    public int getCost() {
        return 180;
    }

    @Override
    public String getDescription() {
        return "Pepperoni";
    }
}
