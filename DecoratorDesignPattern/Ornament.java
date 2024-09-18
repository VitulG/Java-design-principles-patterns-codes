package DecoratorDesignPattern;

public class Ornament implements ChristmasTree {
    private final ChristmasTree tree;

    public Ornament(ChristmasTree christmasTree) {
        this.tree = christmasTree;
    }


    @Override
    public double getCost() {
        return this.tree.getCost() + 30.0d;
    }

    @Override
    public String getDescription() {
        return this.tree.getDescription()+" added ornaments to the christmas tree";
    }
}
