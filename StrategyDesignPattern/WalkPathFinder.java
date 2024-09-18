package StrategyDesignPattern;

public class WalkPathFinder implements PathFinder {
    @Override
    public void findPath(String src, String dst) {
        System.out.println("finding the path for the walk from " + src + " to " + dst);
    }
}
