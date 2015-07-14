package com.pb.sawdust.util;

import com.pb.sawdust.util.test.TestBase;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author crf <br/>
 *         Started: Sep 5, 2008 11:20:20 AM
 */
public class ThreadTimerTest extends TestBase {

    public static void main(String ... args) {
        TestBase.main();
    }

    @Test(expected= IllegalStateException.class)
    public void testStartTimerFailure() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.startTimer();
    }

    @Test(expected= IllegalStateException.class)
    public void testEndTimerFailure() {
        ThreadTimer timer = new ThreadTimer();
        timer.endTimer();
    }

    @Test(expected= IllegalStateException.class)
    public void testResetTimerFailure() {
        ThreadTimer timer = new ThreadTimer();
        timer.resetTimer();
    }

    @Test(expected= IllegalStateException.class)
    public void testPollTimerFailure() {
        ThreadTimer timer = new ThreadTimer();
        timer.pollTimer();
    }

    @Test
    public void testStartTimer() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        assertTrue(timer.isRunning());
    }

    @Test
    public void testPollTimer() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.pollTimer();
        assertTrue(timer.isRunning());
    }

    @Test
    public void testEndTimer() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.endTimer();
        assertFalse(timer.isRunning());
    }

    @Test
    public void testResetTimer() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.resetTimer();
        assertTrue(timer.isRunning());
    }

    @Test
    public void testPollTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        assertTrue(timer.pollTimer() >= 0);
    }

    @Test
    public void test2PollTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        long t1 = timer.pollTimer();
        long t2 = timer.pollTimer();
        assertTrue(t2 > t1);
    }

    @Test
    public void testEndTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        assertTrue(timer.endTimer() >= 0);
    }

    @Test
    public void testPollEndTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        long t1 = timer.pollTimer();
        long t2 = timer.endTimer();
        assertTrue(t2 > t1);
    }

    @Test
    public void testResetTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        assertTrue(timer.resetTimer() >= 0);
    }

    @Test
    public void testPollResetTimerDuration() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        long t1 = timer.pollTimer();
        long t2 = timer.resetTimer();
        assertTrue(t2 > t1);
    }

    @Test
    public void testResetTimerTiming() {
        //hacky
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t1 = timer.resetTimer();
        long t2 = timer.endTimer();
        assertTrue(t2 < t1);
    }

    @Test
    public void testTimerThreadIndependence() {
        final ThreadTimer timer = new ThreadTimer();
        Thread t = new Thread(
            new Runnable() {
                public void run() {
                    timer.startTimer();
                    assertTrue(timer.isRunning());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        t.start();
        assertFalse(timer.isRunning());
        try {
            t.join();                                     
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPauseTimer() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.pauseTimer();
        assertTrue(timer.isPaused());
    }

    @Test
    public void testPauseTimerTimerStopped() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.pauseTimer();
        assertFalse(timer.isRunning());
    }

    @Test(expected=IllegalStateException.class)
    public void testPauseTimerAlreadyPaused() {
        ThreadTimer timer = new ThreadTimer();
        timer.startTimer();
        timer.pauseTimer();
        timer.pauseTimer();
    }

    @Test(expected=IllegalStateException.class)
    public void testPauseTimerNotStarted() {
        ThreadTimer timer = new ThreadTimer();
        timer.pauseTimer();
    }
}