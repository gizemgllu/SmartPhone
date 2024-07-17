
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class SmartphoneApp {

    private static ObjectOutputStream outputStream;
    private static ObjectInputStream inputStream;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int selection = 0;

        Phone phone = new Phone();
        Radio radio = new Radio("Radio 1", "Good Morning Folks", 10);
        Radio radio2 = new Radio("Radio 2", "Morning Shining", 20);

        try
        {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("radios.ser")));
            outputStream.writeObject(radio);
            outputStream.writeObject(radio2);
            System.out.println("All Radio objects are serialized and written into a file.");
        }
        catch (IOException ioe)
        {
            System.err.println("Error creating file.");
            ioe.printStackTrace();
        }

        // phone.setRadio(radio);

        MusicPlayer player = new MusicPlayer("Metallica", "Master of Puppets", "Orion", 8.27, 10);
        MusicPlayer player2 = new MusicPlayer("Metallica", "Black Album", "Seek & Destroy", 10.20, 20);

        try
        {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("musicPlayers.ser")));
            outputStream.writeObject(player);
            outputStream.writeObject(player2);
            System.out.println("All MusicPlayer objects are serialized and written into a file.");
        }
        catch (IOException ioe)
        {
            System.err.println("Error creating file.");
            ioe.printStackTrace();
        }

        // phone.setPlayer(player);

        GPSApp gps = new GPSApp(38.96f, 35.24f, 10, 35);
        phone.setGps(gps);
        WeatherApp weather = new WeatherApp("İzmir", WeatherEnum.SUNNY, WeatherEnum.WINDY);
        phone.setWeather(weather);

        displayMenu();

        while(true) {
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

            if (selection == 0) {
                System.out.println("Your phone is shutting down. Goodbye!");
                try
                {
                    if(outputStream != null)
                        outputStream.close();

                    if (inputStream != null)
                        inputStream.close();
                }
                catch (IOException e)
                {
                    System.err.println("Streams can not be closed.");
                    e.printStackTrace();
                }
                break;

            } else if (selection == 1) {
                System.out.println("Welcome to Radio. A radio channel will be played shortly.");
                ArrayList<Radio> radioArrayList = new ArrayList<>();

                try
                {
                    inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("radios.ser")));

                    while (true)
                    {
                        Radio serializedRadio = (Radio) inputStream.readObject();
                        radioArrayList.add(serializedRadio);
                    }

                } catch (EOFException eofe)
                {
                    System.out.println("All serialized Radio objects are read. No more objects to read.");
                    // eofe.printStackTrace();
                }
                catch (IOException | ClassNotFoundException e)
                {
                    e.printStackTrace();
                }

                System.out.print("SELECTING A RANDOM RADIO CHANNEL: ");
                phone.setRadio(radioArrayList.get(new Random().nextInt(radioArrayList.size())));
                phone.getRadio().start();

            } else if (selection == 2) {
                System.out.println("Welcome to Music Player. A song will be played shortly.");
                ArrayList<MusicPlayer> playerArrayList = new ArrayList<>();

                try
                {
                    inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("musicPlayers.ser")));

                    while (true)
                    {
                        MusicPlayer serializedPlayer = (MusicPlayer) inputStream.readObject();
                        playerArrayList.add(serializedPlayer);
                    }

                } catch (EOFException eofe)
                {
                    System.out.println("All serialized MusicPlayer objects are read. No more objects to read.");
                    // eofe.printStackTrace();
                }
                catch (IOException | ClassNotFoundException e)
                {
                    e.printStackTrace();
                }

                System.out.print("SELECTING A RANDOM SONG: ");
                phone.setPlayer(playerArrayList.get(new Random().nextInt(playerArrayList.size())));
                phone.getPlayer().start();

            } else if (selection == 3) {
                System.out.println("Welcome to GPS. Your coordinates are: ");
                phone.getGps().getCoordinates();
            } else if (selection == 4) {
                System.out.println("Welcome to Weather Forecast. The weather conditions for you is: ");
                phone.getWeather().getCoordinates();
            } else {
                System.out.println("Wrong selection. Please select from 1 to 4.");
            }

            displayMenuSelection();
        }
    }

    public static void displayMenu()
    {
        System.out.println("Welcome to your smartphone.");
        System.out.println("-----------------------------");
        System.out.println("|                           |");
        System.out.println("|                           |");
        System.out.println("|    Connecting people...   |");
        System.out.println("|                           |");
        System.out.println("|                           |");
        System.out.println("-----------------------------");

        displayMenuSelection();

    }

    private static void displayMenuSelection()
    {
        System.out.println("Which app do you want to use?");
        System.out.println("Select (1) for Radio.\nSelect (2) for Music Player." +
                "\nSelect (3) for GPS.\nSelect (4) for Weather Forecast.");
        System.out.println("Select (0) for shutting down your phone.");
    }
}