package DecoratorDesignPattern;

public class Star implements ChristmasTree {
    private ChristmasTree christmasTree;

    public Star(ChristmasTree christmasTree) {
        this.christmasTree = christmasTree;
    }

    @Override
    public double getCost() {
        return this.christmasTree.getCost() + 50.0d;
    }

    @Override
    public String getDescription() {
        return this.christmasTree.getDescription()+" added a star over the tree";
    }
}
