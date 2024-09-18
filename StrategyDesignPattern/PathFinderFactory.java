package StrategyDesignPattern;

public class PathFinderFactory {
    public static PathFinder getPathFinder(ModeType type) {
        return switch (type) {
            case CAR -> new CarPathFinder();
            case BIKE -> new BikePathFinder();
            case WALK -> new WalkPathFinder();
            default -> null;
        };
    }
}
