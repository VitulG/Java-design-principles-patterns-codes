package StrategyDesignPattern;

public class BikePathFinder implements PathFinder {

    @Override
    public void findPath(String src, String dst) {
        System.out.println("finding the path for the bike from source "+src+" to destination "+dst);
    }
}
