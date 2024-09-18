package ObserverDesignPattern;

public class Client {
    public static void main(String[] args) {
        YouTube youTube = new YouTube();

        YouTubeSubscriber subscriber1 = new User("Vitul");
        YouTubeSubscriber subscriber2 = new Admin("Sujal");

        youTube.addSubscriber(subscriber1);
        youTube.addSubscriber(subscriber2);
        youTube.notifySubscribers();

        System.out.println();

        youTube.removeSubscriber(subscriber2);
        youTube.notifySubscribers();
    }
}
