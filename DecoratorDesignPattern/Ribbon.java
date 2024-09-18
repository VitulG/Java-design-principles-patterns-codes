package DecoratorDesignPattern;

public class Ribbon implements ChristmasTree {
    private final ChristmasTree christmasTree;

    public Ribbon(ChristmasTree christmasTree ) {
        this.christmasTree = christmasTree;
    }

    @Override
    public double getCost() {
        return christmasTree.getCost() + 10.0d;
    }

    @Override
    public String getDescription() {
        return christmasTree.getDescription() +" added a ribbon to the Christmas Tree";
    }
}
