package FactoryDesignPattern.assignment1;

public abstract class Audio {
    private int volume;
    private double playbackRate;

    public Audio(int volume, double playbackRate) {
        this.volume = volume;
        this.playbackRate = playbackRate;
    }

    public abstract MediaFormat supportsType();
    public abstract void play();
    public abstract void stop();
    public abstract void pause();
}
