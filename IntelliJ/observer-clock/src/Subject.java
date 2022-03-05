import java.util.Iterator;
import java.util.Vector;

public class Subject {

    private Vector<Observer> observers = new Vector<>();

    protected void notifyObservers() {
        Iterator<Observer> i = observers.iterator();
        while (i.hasNext()) {
            Observer observer = i.next();
            observer.update();
        }
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
