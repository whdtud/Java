public class TestGame {

    private Game g;

    public void setUp() {
        g = new Game();
    }

    public void testOneThrow() {
        Game g = new Game();
        g.add(5);
        Util.assertEquals(9, g.getScore());
        Util.assertEquals(1, g.getCurrentFrame());
    }

    public void testFourThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);

        Util.assertEquals(18, g.getScore());
        Util.assertEquals(9, g.getScoreForFrame(1));
        Util.assertEquals(18, g.getScoreForFrame(2));
        Util.assertEquals(2, g.getCurrentFrame());
    }

    public void testSimpleSpare() {
        setUp();

        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);

        Util.assertEquals(13, g.getScoreForFrame(1));
        Util.assertEquals(18, g.getScoreForFrame(2));
    }
}
