package StrategyDesignPattern;

public class GoogleMap {

    public void findPath(String src, String dst, ModeType modeType) {
        PathFinder pathFinder = PathFinderFactory.getPathFinder(modeType);
        if(pathFinder !=null){
            pathFinder.findPath(src, dst);
        }
    }
}
