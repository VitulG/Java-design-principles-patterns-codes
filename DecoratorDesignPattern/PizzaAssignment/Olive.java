package DecoratorDesignPattern.PizzaAssignment;

public class Olive extends Pizza {
    private Pizza pizza;

    public Olive(Pizza pizza) {
        pizzaName = "Pizza with olive";
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return this.pizza.getCost()+20;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription()+" + Olive";
    }
}
