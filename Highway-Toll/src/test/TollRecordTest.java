package hw6.test;
import hw6.TollRecord;
import static hw6.test.Tests.*;

/**
 * Testing class for Toll Record
 * This class will check if the toll record is created for a given name, Point of Entry and Time of Entry
 */
public class TollRecordTest {
    /**
     * Testing method for the constructor
     */
    public static void testTollRecordConstructor()
    {
        TollRecord tr1= new TollRecord("Prathamesh",25,10);
        assertEquals("Prathamesh",tr1.getName());
        assertEquals(25,tr1.getEntry());
        assertEquals(10,tr1.getEntryTime());
    }

    /**
     * Main method of Testing class
     * @param args
     */
    public static void main(String[] args) {
        runAllTests(TollRecordTest.class);
    }
}
