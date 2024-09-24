package DecoratorDesignPattern.PizzaAssignment;

public class Tomato extends Pizza {
    private Pizza pizza;

    public Tomato(Pizza pizza) {
        pizzaName = "Pizza with Tomatoes";
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Tomato";
    }
}
