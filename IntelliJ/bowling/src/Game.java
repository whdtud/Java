public class Game {

    private int ball;
    private int[] throwArr = new int[21];
    private int currentThrow = 0;
    private int currentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer scorer = new Scorer();

    public int getScore() {
        return getScoreForFrame(getCurrentFrame() - 1);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void add(int pins) {
        scorer.addThrow(pins);
        adjustCurrentFame(pins);
    }

    private void adjustCurrentFame(int pins) {
        if (firstThrowInFrame == true) {
            if (adjustFrameForStrike(pins) == false)
                firstThrowInFrame = false;
        } else {
            firstThrowInFrame = true;
            advanceFrame();
        }
    }

    private boolean adjustFrameForStrike(int pins) {
        if (pins == 10) {
            advanceFrame();
            return true;
        }
        return false;
    }

    private void advanceFrame() {
        currentFrame = Math.min(11, currentFrame + 1);
    }

    public int getScoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;

        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (strike()) {
                ball++;
                score += 10 + nextTwoBalls();
            } else if (spare()) {
                ball += 2;
                score += 10 + nextBall();
            } else {
                score += twoBallsInFrame();
                ball += 2;
            }
        }

        return score;
    }

    private boolean strike() {
        return throwArr[ball] == 10;
    }

    private int nextTwoBalls() {
        return throwArr[ball] + throwArr[ball + 1];
    }

    private int handleSecondThrow() {
        int score = 0;

        if (spare()) {
            ball += 2;
            score += 10 + nextBall();
        }
        else {
            score += twoBallsInFrame();
            ball += 2;
        }

        return score;
    }

    private int twoBallsInFrame() {
        return throwArr[ball] + throwArr[ball + 1];
    }

    private boolean spare() {
        return (throwArr[ball] + throwArr[ball + 1]) == 10;
    }

    private int nextBall() {
        return throwArr[ball + 1];
    }
}
