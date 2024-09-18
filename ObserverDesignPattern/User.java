package ObserverDesignPattern;

public class User implements YouTubeSubscriber{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifySubscriber() {
        System.out.println(this.name + " received notification about a new video.");
    }
}
