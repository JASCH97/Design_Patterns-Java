/*
The adapter design pattern is one of the structural design patterns and is used so that two unrelated 
interfaces can work together. The object that joins these unrelated interfaces is called an adapter.
*/



// Adaptee
class LegacyRectangle {
    public void display(int x1, int y1, int x2, int y2) {
        System.out.println("LegacyRectangle: draw(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
    }
}

// Target interface
interface Shape {
    void draw(int x, int y, int width, int height);
}

// Adapter
class RectangleAdapter implements Shape {
    private LegacyRectangle adaptee;

    public RectangleAdapter(LegacyRectangle adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        adaptee.display(x, y, x + width, y + height);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 30, 40);
    }
}

// ************************* LegacyAudioPlayer Example: *************************

// Legacy Third-Party Library (Adaptee)
class LegacyAudioPlayer {
    void playFile(String fileName) {
        System.out.println("Playing audio file: " + fileName);
    }
}

// Target Interface
interface AudioPlayer {
    void play(String audioType, String fileName);
}

// Adapter
class AudioPlayerAdapter implements AudioPlayer {
    private LegacyAudioPlayer legacyAudioPlayer;

    public AudioPlayerAdapter(LegacyAudioPlayer legacyAudioPlayer) {
        this.legacyAudioPlayer = legacyAudioPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            legacyAudioPlayer.playFile(fileName);
        } else {
            System.out.println("Unsupported audio type: " + audioType);
        }
    }
}

// New Audio Player (Target)
class NewAudioPlayer implements AudioPlayer {
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing new audio file: " + fileName);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        LegacyAudioPlayer legacyAudioPlayer = new LegacyAudioPlayer();
        AudioPlayer adapter = new AudioPlayerAdapter(legacyAudioPlayer);

        adapter.play("mp3", "song.mp3");
        adapter.play("mp4", "video.mp4");

        AudioPlayer newAudioPlayer = new NewAudioPlayer();
        newAudioPlayer.play("wav", "sound.wav");
    }
}