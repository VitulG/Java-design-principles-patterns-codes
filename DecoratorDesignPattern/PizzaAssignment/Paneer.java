package DecoratorDesignPattern.PizzaAssignment;

public class Paneer extends Pizza {
    private Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizzaName = "Pizza with Paneer";
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 60;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Paneer";
    }
}
