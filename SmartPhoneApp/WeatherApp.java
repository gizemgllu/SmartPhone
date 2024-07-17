
public class WeatherApp implements Trackable {

    private String city;
    private WeatherEnum currentForecast;
    private WeatherEnum tomorrowsForecast;

    public WeatherApp(String city, WeatherEnum currentForecast, WeatherEnum tomorrowsForecast) {
        this.city = city;
        this.currentForecast = currentForecast;
        this.tomorrowsForecast = tomorrowsForecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherEnum getCurrentForecast() {
        return currentForecast;
    }

    public void setCurrentForecast(WeatherEnum currentForecast) {
        this.currentForecast = currentForecast;
    }

    public WeatherEnum getTomorrowsForecast() {
        return tomorrowsForecast;
    }

    public void setTomorrowsForecast(WeatherEnum tomorrowsForecast) {
        this.tomorrowsForecast = tomorrowsForecast;
    }

    @Override
    public void getCoordinates()
    {
        System.out.println("Weather for the coordinates of city " + getCity() + ":");
        System.out.println("Current weather forecast is: " + getCurrentForecast());
        System.out.println("Weather forecast for tomorrow is: " + getTomorrowsForecast());
        System.out.println("---------------------------------------------");
    }
}