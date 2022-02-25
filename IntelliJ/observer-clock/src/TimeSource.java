import java.util.Iterator;
import java.util.Vector;

public class TimeSource {

    private Vector observers = new Vector();

    protected void notify(int hours, int minutes, int seconds) {
        Iterator i = observers.iterator();
        while (i.hasNext()) {
            ClockObserver observer = (ClockObserver)i.next();
            observer.update(hours, minutes, seconds);
        }
    }

    public void registerObserver(ClockObserver observer) {
        observers.add(observer);
    }
}
