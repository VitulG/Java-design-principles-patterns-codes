package DecoratorDesignPattern.PizzaAssignment;

public class Farmhouse extends Pizza {
    public Farmhouse() {
        pizzaName = "Farmhouse Pizza";
    }

    public int getCost() {
        return 150;
    }

    public String getDescription() {
        return "Farmhouse";
    }
}
