package tcom.sadir.test;

import com.sadir.test.SpeakingClock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeakingClockTest {
    private SpeakingClock clock;
    @Before
    public void setUp() {
        clock = new SpeakingClock();
    }

    @Test
    public void testMidnight() {
        String actual = clock.speakTimeInWords("00:00");
        Assert.assertEquals("It's midnight", actual);

        actual = clock.speakTimeInWords("24:00");
        Assert.assertEquals("It's midnight", actual);
    }

    @Test
    public void testMidday() {
        String actual = clock.speakTimeInWords("12:00");
        Assert.assertEquals("It's midday", actual);
    }

    @Test
    public void testEightThirty() {
        String actual = clock.speakTimeInWords("08:30");
        Assert.assertEquals("It's eight thirty", actual);
    }

    @Test
    public void testNineThirty() {
        String actual = clock.speakTimeInWords("21:09");
        Assert.assertEquals("It's nine nine", actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTime1() {
       clock.speakTimeInWords("25:30");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTime2() {
        clock.speakTimeInWords("AA:30");
    }
}
