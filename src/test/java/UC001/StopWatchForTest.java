package UC001;

import nl.tudelft.jpacman.game.StopWatch;

public class StopWatchForTest extends StopWatch{
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private long startTime;
    private long stopTime;
    private boolean running;
    @Override
    public void startWatch() {
        startTime = System.nanoTime();
        running = true;
    }

    @Override
    public void stopWatch() {
        stopTime = System.nanoTime();
        running = false;
    }

    @Override
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.nanoTime() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }
}
