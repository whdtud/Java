import java.util.Vector;

public class Turnstile {

    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    public static final int COIN = 0;
    public static final int PASS = 1;

    private int state = LOCKED;

    private Vector transitions = new Vector();

    private interface Action {
        void execute();
    }

    private class Transition {
        private int currentState;
        private int event;
        private int newState;
        Action action;

        public Transition(int currentState, int event, int newState, Action action) {
            this.currentState = currentState;
            this.event = event;
            this.newState = newState;
            this.action = action;
        }
    }

    public Turnstile() {

        addTransition(LOCKED, COIN, UNLOCKED, unlock());
    }

    private void addTransition(int currentState, int event, int newState, Action action) {
        transitions.add(new Transition(currentState, event, newState, action));
    }

    private Action lock() {
        return new Action() {
            @Override
            public void execute() {
                doLock();
            }
        };
    }

    private Action unlock() {
        return new Action() {
            @Override
            public void execute() {
                doUnlock();
            }
        };
    }

    private void doUnlock() {

    }

    private void doLock() {

    }
}
