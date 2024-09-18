package StrategyDesignPattern;

public class CarPathFinder implements PathFinder {
    @Override
    public void findPath(String src, String dst) {
        System.out.println("finding the path for the Car from "+src+" to "+dst);
    }
}
