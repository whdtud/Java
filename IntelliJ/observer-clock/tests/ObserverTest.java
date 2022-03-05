import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    private MockTimeSource source;
    private MockTimeSink sink;

    @BeforeAll
    public void setUp() {
        source = new MockTimeSource();
        sink = new MockTimeSink();
        source.registerObserver(sink);
    }

    private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds) {
        Assertions.assertEquals(hours, sink.getHours());
        Assertions.assertEquals(minutes, sink.getMinutes());
        Assertions.assertEquals(seconds, sink.getSeconds());
    }

    public void testTimeChange() {
        source.setTime(3, 4, 5);
        assertSinkEquals(sink, 3, 4, 5);

        source.setTime(7, 8, 9);
        assertSinkEquals(sink, 7, 8,9);
    }

    @Test
    public void testMultipleSinks() {
        MockTimeSink sink2 = new MockTimeSink();
        source.registerObserver(sink2);

        source.setTime(12, 13, 14);
        assertSinkEquals(sink, 12, 13, 14);
        assertSinkEquals(sink2, 12, 13, 14);
    }
}
