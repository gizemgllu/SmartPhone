
public class GPSApp implements Trackable
{
    private float x;
    private float y;
    private int hour;
    private int min;

    public GPSApp(float x, float y, int hour, int min) {
        this.x = x;
        this.y = y;
        this.hour = hour;
        this.min = min;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void getCoordinates()
    {
        System.out.println("X coordinate: " + getX());
        System.out.println("Y coordinate: " + getY());
        System.out.println("Hour coordinate: " + getHour());
        System.out.println("Minute coordinate: " + getMin());
        System.out.println("-------------------------");
    }
}