package DecoratorDesignPattern;

public class Bulb implements ChristmasTree {
    private final ChristmasTree christmasTree;

    public Bulb(ChristmasTree christmasTree ) {
        this.christmasTree = christmasTree;
    }


    @Override
    public double getCost() {
        return this.christmasTree.getCost() + 20.0d;
    }

    @Override
    public String getDescription() {
        return this.christmasTree.getDescription()+" added bulb to the christmas tree";
    }
}
