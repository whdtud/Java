public class Game {

    private int ball;
    private int firstThrow;
    private int secondThrow;

    private int score = 0;
    private int[] throwArr = new int[21];
    private int currentThrow = 0;
    private int currentFrame = 1;
    private boolean firstThrowInFrame = true;

    public int getScore() {
        return getScoreForFrame(getCurrentFrame() - 1);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void add(int pins) {
        throwArr[currentThrow++] = pins;
        score += pins;

        adjustCurrentFame(pins);
    }

    private void adjustCurrentFame(int pins) {
        if (firstThrowInFrame == true) {
            if (pins == 10)
                currentFrame++;
            else
                firstThrowInFrame = false;
        } else {
            firstThrowInFrame = true;
            currentFrame++;
        }
        currentFrame = Math.min(11, currentFrame);
    }

    public int getScoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;

        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            firstThrow = throwArr[ball];
            if (strike()) {
                ball++;
                score += 10 + nextTwoBalls();
            } else {
                score += handleSecondThrow();
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
        secondThrow = throwArr[ball + 1];

        int frameScore = firstThrow + secondThrow;
        if (spare()) {
            ball += 2;
            score += 10 + nextBall();
        }
        else {
            ball += 2;
            score += twoBallsInFrame();
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
