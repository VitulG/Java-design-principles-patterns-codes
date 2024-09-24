package DecoratorDesignPattern.PizzaAssignment;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new Paneer(
                new Cheese(
                        new Tomato(
                                new BBQChicken()
                        )
                )
        );

        System.out.println("Pizza name: "+ pizza.pizzaName);
        System.out.println("Total Cost: "+ pizza.getCost());
        System.out.println("Description: "+ pizza.getDescription());
    }
}
