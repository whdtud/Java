public class Scorer {

    private int ball;
    private int currentThrow;
    private int[] throwsArr = new int[21];

    public void addThrow(int pins) {
        throwsArr[currentThrow++] = pins;
    }

    public int scoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;

        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (strike()) {
                ball++;
                score += 10 + nextTwoBallsForStrike();
            } else if (spare()) {
                ball += 2;
                score += 10 + nextBallForSpare();
            } else {
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private boolean strike() {
        return throwsArr[ball] == 10;
    }

    private boolean spare() {
        return (throwsArr[ball] + throwsArr[ball + 1]) == 10;
    }

    private int nextTwoBallsForStrike() {
        return throwsArr[ball + 1] + throwsArr[ball + 2];
    }

    private int nextBallForSpare() {
        return throwsArr[ball + 2];
    }

    private int twoBallsInFrame() {
        return throwsArr[ball] + throwsArr[ball + 1];
    }
}
