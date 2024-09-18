package ObserverDesignPattern;

public class Admin implements YouTubeSubscriber {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    @Override
    public void notifySubscriber() {
        System.out.println(this.name + " received notification about a new video.");
    }
}
