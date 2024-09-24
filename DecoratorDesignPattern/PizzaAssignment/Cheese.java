package DecoratorDesignPattern.PizzaAssignment;

public class Cheese extends Pizza {
    private Pizza pizza;

    public Cheese(Pizza pizza) {
        pizzaName = "Pizza with cheese";
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }
}
