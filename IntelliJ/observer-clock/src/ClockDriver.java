public class ClockDriver implements ClockObserver {

    private TimeSink sink;

    public ClockDriver(TimeSource source, TimeSink sink) {
        source.registerObserver(this);
        this.sink = sink;
    }

    @Override
    public void update(int hours, int minutes, int seconds) {
        sink.setTime(hours, minutes, seconds);
    }
}
