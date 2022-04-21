import java.util.Vector;

public class Turnstile {

    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    public static final int COIN = 0;
    public static final int PASS = 1;

    private int state = LOCKED;

    private TurnstileController turnstileController;
    private Vector<Transition> transitions = new Vector<Transition>();

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

    public Turnstile(TurnstileController action) {
        turnstileController = action;
        addTransition(LOCKED, COIN, UNLOCKED, unlock());
        addTransition(LOCKED, PASS, LOCKED, alarm());
        addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
        addTransition(UNLOCKED, PASS, LOCKED, lock());
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

    private Action thankyou() {
        return new Action() {
            @Override
            public void execute() {
                doThankyou();
            }
        };
    }

    private Action alarm() {
        return new Action() {
            @Override
            public void execute() {
                doAlarm();
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
        turnstileController.unlock();
    }

    private void doLock() {
        turnstileController.lock();
    }

    private void doAlarm() {
        turnstileController.alarm();
    }

    private void doThankyou() {
        turnstileController.thankyou();
    }

    public void event(int event) {
        for (int i = 0; i < transitions.size(); i++) {
            Transition transition = transitions.elementAt(i);
            if (state == transition.currentState &&
                event == transition.event) {
                state = transition.newState;
                transition.action.execute();
            }
        }
    }
}
