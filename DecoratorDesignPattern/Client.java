package DecoratorDesignPattern;

public class Client {
    public static void main(String[] args) {
        ChristmasTree tree = new Star(
                new Ornament(
                        new Ribbon(
                                new Bulb(
                                        new Tree()
                                )
                        )
                )
        );

        System.out.println("total cost of the tree: " + tree.getCost());
        System.out.println("description: " + tree.getDescription());
    }
}
