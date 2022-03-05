public class MockTimeSink implements Observer {

    private int hours;
    private int minutes;
    private int seconds;
    private TimeSource source;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void update() {
        this.hours = source.getHours();
        this.minutes = source.getMinutes();
        this.seconds = source.getSeconds();
    }
}
