package com.example.wellbeingapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void checkMeditationType() {
        Meditation meditation = new Meditation(null, null, null);
        assertEquals("meditation", meditation.getType());
    }

    @Test
    public void checkSleepType() {
        Sleep sleep = new Sleep(null, null);
        assertEquals("sleep", sleep.getType());
    }

    @Test
    public void checkExerciseType() {
        Exercise exercise = new Exercise(null, null);
        assertEquals("exercise", exercise.getType());
    }
}