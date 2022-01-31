package hw6.test;
import hw6.SortbyNameTime;
import static hw6.test.Tests.*;

/**
 * Testing class for SortbyNameTime class
 * This will check if the strings are properly compared based on Name first then time if name is equal.
 */
public class SortbyNameTimeTest {
    /**
     * Testing method for compare
     */
    public static void testcompare()
    {
        SortbyNameTime sbnt = new SortbyNameTime();
        assertEquals(-1,sbnt.compare("[     DR_WHO] on #45, time    10;","[   JOE_NOTO] on #12, time    39;"));
        assertEquals(-1,sbnt.compare("[     DR_WHO] on #45, time    10;","[     DR_WHO] on #47, time    11;"));
        assertEquals(1,sbnt.compare("[   JOE_NOTO] on #12, time    39;","[     DR_WHO] on #45, time    10;"));
    }

    /**
     * Main method of Test class
     * @param args
     */
    public static void main(String[] args) {
        runAllTests(SortbyNameTimeTest.class);
    }
}
