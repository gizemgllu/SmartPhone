
import java.io.Serializable;
import java.util.Scanner;

public class Radio implements Playable, Serializable
{
    private String channelName;
    private String programName;
    private int volumeLevel;

    public Radio(String channelName, String programName, int volumeLevel) {
        this.channelName = channelName;
        this.programName = programName;
        this.volumeLevel = volumeLevel;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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

        System.out.println("Playing " + getChannelName() + " radio channel.");
        System.out.println("If you want to stop playing this channel, press 1.");
        System.out.println("If you want to get to next channel, press 2.");
        System.out.println("If you want to get to previous channel, press 3.");

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
    public void stop()
    {
        System.out.println("Radio stopped playing.");
    }

    @Override
    public void next()
    {
        System.out.println("Started playing next channel.");
    }

    @Override
    public void prev()
    {
        System.out.println("Started playing previous channel.");
    }
}
