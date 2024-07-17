
import java.io.Serializable;
import java.util.Scanner;

public class MusicPlayer implements Playable, Serializable
{
    private String artist;
    private String album;
    private String song;
    private double songDuration;
    private int volumeLevel;

    public MusicPlayer(String artist, String album, String song, double songDuration, int volumeLevel) {
        this.artist = artist;
        this.album = album;
        this.song = song;
        this.songDuration = songDuration;
        this.volumeLevel = volumeLevel;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    @Override
    public void start()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Playing " + getSong() + " from the album " + getAlbum() + " of " + getArtist() + ".");
        System.out.println("If you want to stop playing this song, press 1.");
        System.out.println("If you want to get to next song, press 2.");
        System.out.println("If you want to get to previous song, press 3.");

        int selection = 0;

        boolean loopCondition = true;
        do {
            try {
                selection = Integer.parseInt(input.nextLine());
                loopCondition = false;
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
                System.err.println("Try to give integer input.");
            }
        } while (loopCondition);

        if (selection == 1)
        {
            stop();
        }
        else if (selection == 2)
        {
            next();
        }
        else if (selection == 3)
        {
            prev();
        }
        else
        {
            System.out.println("Wrong selection. Please select between 1 and 3.");
        }

    }

    @Override
    public void stop() {
        System.out.println("Stopped playing this song.");
    }

    @Override
    public void next() {
        System.out.println("Started playing next song.");
    }

    @Override
    public void prev() {
        System.out.println("Started playing previous song.");
    }

}