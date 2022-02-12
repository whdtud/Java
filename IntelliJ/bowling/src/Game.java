public class Game {

    private int score = 0;
    private int currentThrow = 0;
    private int currentFrame = 1;
    private boolean firstThrow = true;
    private int[] throwArr = new int[21];

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
        if (firstThrow == true) {
            if (pins == 10)
                currentFrame++;
            else
                firstThrow = false;
        } else {
            firstThrow = true;
            currentFrame++;
        }
        currentFrame = Math.min(11, currentFrame);
    }

    public int getScoreForFrame(int frame) {
        int score = 0;
        int ball = 0;

        for (int i = 0; i < frame; i++) {
            int firstThrow = throwArr[ball++];
            if (firstThrow == 10) {
                score += 10 + throwArr[ball] + throwArr[ball + 1];
            } else {
                int secondThrow = throwArr[ball++];

                int frameScore = firstThrow + secondThrow;
                if (frameScore == 10)
                    score += frameScore + throwArr[ball];
                else
                    score += frameScore;
            }
        }

        return score;
    }
}
