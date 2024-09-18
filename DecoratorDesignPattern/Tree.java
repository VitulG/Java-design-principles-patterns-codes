package DecoratorDesignPattern;

public class Tree implements ChristmasTree {
    //private ChristmasTree christmasTree;

//    public Tree(ChristmasTree christmasTree) {
//        this.christmasTree = christmasTree;
//    }

    public Tree() {}

    @Override
    public double getCost() {
//        if(this.christmasTree == null) {
//            return 0.0d;
//        }
        return 100.d;
    }

    @Override
    public String getDescription() {
//        if(this.christmasTree == null) {
//            return "";
//        }
        return "christmas tree is here";
    }
}
