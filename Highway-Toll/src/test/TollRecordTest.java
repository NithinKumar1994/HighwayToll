package test;
import TollRecord;
import static test.Tests.*;

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
        TollRecord tr1= new TollRecord("Nithin",25,10);
        assertEquals("Nithin",tr1.getName());
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
