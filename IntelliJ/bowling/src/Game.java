public class Game {

    private int score = 0;
    private int currentThrow;
    private int currentFrame = 0;
    private boolean firstThrow = true;
    private int[] throwArr = new int[21];

    public int getScore() {
        return score;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void add(int pins) {
        throwArr[currentThrow++] = pins;
        score += pins;

        if (firstThrow == true) {
            firstThrow = false;
            currentFrame++;
        } else {
            firstThrow = true;
        }
    }

    public int getScoreForFrame(int frame) {
        int score = 0;
        int ball = 0;

        for (int i = 0; i < frame; i++) {
            int firstThrow = throwArr[ball++];
            int secondThrow = throwArr[ball++];

            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10)
                score += frameScore + throwArr[ball];
            else
                score += frameScore;
        }

        return score;
    }
}
