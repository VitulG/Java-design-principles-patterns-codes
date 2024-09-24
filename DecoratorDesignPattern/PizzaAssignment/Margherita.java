package DecoratorDesignPattern.PizzaAssignment;

public class Margherita extends Pizza {
    public Margherita() {
        pizzaName = "Margherita";
    }

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Margherita";
    }
}
