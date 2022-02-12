import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestGame {

    private static Game g;

    @BeforeAll
    public static void setUp() {
        g = new Game();
    }

    @Test
    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        Assertions.assertEquals(9, g.getScore());
        Assertions.assertEquals(2, g.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        Assertions.assertEquals(18, g.getScore());
        Assertions.assertEquals(9, g.getScoreForFrame(1));
        Assertions.assertEquals(18, g.getScoreForFrame(2));
    }

    @Test
    public void testSimpleSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        Assertions.assertEquals(13, g.getScoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        Assertions.assertEquals(13, g.getScoreForFrame(1));
        Assertions.assertEquals(18, g.getScoreForFrame(2));
        Assertions.assertEquals(18, g.getScore());
        Assertions.assertEquals(3, g.getCurrentFrame());
    }

    @Test
    public void testSimpleStrike() {
        g.add(10);
        g.add(3);
        g.add(6);
        Assertions.assertEquals(19, g.getScoreForFrame(1));
        Assertions.assertEquals(28, g.getScore());
        Assertions.assertEquals(3, g.getCurrentFrame());
    }

    @Test
    public void testPerfectGame() {
        for (int i = 0; i < 12; i++) {
            g.add(10);
        }

        Assertions.assertEquals(300, g.getScore());
        Assertions.assertEquals(11, g.getCurrentFrame());
    }

    @Test
    public void testEndOfArray() {
        for (int i = 0; i < 9; i++) {
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);
        Assertions.assertEquals(20, g.getScore());
    }

    @Test
    public void testSampleGame() {
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        Assertions.assertEquals(133, g.getScore());
    }

    @Test
    public void testHeartBreak() {
        for (int i = 0; i < 11; i++) {
            g.add(10);
        }
        g.add(9);
        Assertions.assertEquals(299, g.getScore());
    }

    @Test
    public void testTenthFrameSpare() {
        for (int i = 0; i < 9; i++) {
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);
        Assertions.assertEquals(270, g.getScore());
    }
}