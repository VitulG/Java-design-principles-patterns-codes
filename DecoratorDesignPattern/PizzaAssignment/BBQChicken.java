package DecoratorDesignPattern.PizzaAssignment;

public class BBQChicken extends Pizza {
    public BBQChicken() {
        pizzaName = "BBQ Chicken Pizza";
    }

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "BBQ Chicken";
    }
}
