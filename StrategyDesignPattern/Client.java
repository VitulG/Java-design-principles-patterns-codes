package StrategyDesignPattern;

public class Client {
    public static void main(String[] args) {
        GoogleMap googleMap = new GoogleMap();
        googleMap.findPath("Delhi", "Chandigarh", ModeType.WALK);
    }
}
