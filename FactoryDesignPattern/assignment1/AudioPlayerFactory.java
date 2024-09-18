package FactoryDesignPattern.assignment1;

public class AudioPlayerFactory {
    public static Audio getAudioPlayer(MediaFormat format, int volume, double playbackRate) {
        return switch (format) {
            case MP3 -> new MP3Player(volume, playbackRate);
            case WAV -> new WAVPlayer(volume, playbackRate);
            case FLAC -> new FLACPlayer(volume, playbackRate);
        };
    }
}
