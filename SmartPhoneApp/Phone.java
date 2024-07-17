
public class Phone
{
    private String model;
    private int year;
    private MusicPlayer player;
    private Radio radio;
    private GPSApp gps;
    private WeatherApp weather;

    public Phone() {
    }

    public Phone(String model, int year, MusicPlayer player, Radio radio, GPSApp gps, WeatherApp weather) {
        this.model = model;
        this.year = year;
        this.player = player;
        this.radio = radio;
        this.gps = gps;
        this.weather = weather;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MusicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MusicPlayer player) {
        this.player = player;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public GPSApp getGps() {
        return gps;
    }

    public void setGps(GPSApp gps) {
        this.gps = gps;
    }

    public WeatherApp getWeather() {
        return weather;
    }

    public void setWeather(WeatherApp weather) {
        this.weather = weather;
    }
}
