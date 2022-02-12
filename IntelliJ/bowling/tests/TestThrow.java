import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestThrow {

    @Test
    public void testScoreNoThrows() {
        Frame f = new Frame();
        f.add(5);

        Assertions.assertEquals(5, f.getScore());
    }
}
