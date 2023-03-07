package nl.tudelft.jpacman.game;

public class StopWatch {
    private long startTime;
    private long stopTime;
    private boolean running;

    public void startWatch() {
        startTime = System.nanoTime();
        running = true;
    }

    public void stopWatch() {
        stopTime = System.nanoTime();
        running = false;
    }

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
