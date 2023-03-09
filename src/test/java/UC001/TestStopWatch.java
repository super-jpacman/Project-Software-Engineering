package UC001;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TestStopWatch {
    StopWatchForTest stopWatchForTest = new StopWatchForTest();
    @DisplayName("Test Start stop watch")
    @Test
    public void test1() throws InterruptedException {
        stopWatchForTest.startWatch();
        long start = stopWatchForTest.getElapsedTime();
        Thread.sleep(10);
        stopWatchForTest.stopWatch();
        long stop = stopWatchForTest.getElapsedTime();
        assertNotSame(stop,start);
    }
}
