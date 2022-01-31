package test;
import static test.Tests.*;
import TollRecord;
import TollRoadDatabase;

/**
 * Testing class for TollRoadDatabase
 * The TollRoadDatabase will consists of all the Toll Records, Billing Information and OnRoad Vehicles Report
 */
public class TollRoadDatabaseTest
{
    private static TollRoadDatabase trb1;

    /**
     * Testing method for constructor
     * This will check if the TOLL Database is created for a given file
     */
    public static void testTollRoadDatabaseConstructor()
    {
        trb1= new TollRoadDatabase("/input/5guys.txt");
    }

    /**
     * This method is used for computing speed given Distance between exits, entry time and exit Time
     */
    public static void testComputeSpeed()
    {
        double actual=trb1.computeSpeed(100,10,20);
        assertEquals(600.0,actual);

    }

    /**
     * This method tests the Parsing of vehicle name, entry time and exit number
     */
    public static void testProduceVehicle()
    {
        TollRecord tr1= trb1.produceVehicle("52,THX_1138,19");
        assertEquals("THX_1138",tr1.getName());
        assertEquals(52,tr1.getEntryTime());
        assertEquals(19,tr1.getEntry());
    }

    /**
     * This method will check the working of Speeder Report
     */
    public static void testgenSpeederReport()
    {
        trb1.genSpeederReport();
    }
    /**
     * This method will check the working of OnRoad vehicles Report
     */
    public static void testOnRoadReport()
    {
        trb1.genOnRoadReportht();
    }
    /**
     * This method will check the working of Billing Information
     */
    public static void testgenBillInfo()
    {
        trb1.genBillInfo();
    }

    /**
     * Main method of testing class
     * @param args
     */
    public static void main(String[] args) {
        testTollRoadDatabaseConstructor();
        runAllTests(TollRoadDatabaseTest.class);

    }
}
