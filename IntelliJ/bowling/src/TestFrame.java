public class TestFrame { // Game

    public void testScoreNoThrows() {
        Frame f = new Frame();

        Util.assertEquals(0, f.getScore());
    }

    public void testAddOneThrow() {
        Frame f = new Frame();
        f.add(5);
        Util.assertEquals(5, f.getScore());
    }
}
