package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class YouTube {
    private List<YouTubeSubscriber> subscribers;

    public YouTube() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(YouTubeSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(YouTubeSubscriber subscriber) {
            subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for(YouTubeSubscriber subscriber : subscribers) {
            subscriber.notifySubscriber();
        }
    }
}
