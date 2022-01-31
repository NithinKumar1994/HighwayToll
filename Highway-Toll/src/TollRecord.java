/**
 * The TollRecord class to create all the tolls
 */
public class TollRecord implements TollsRUs {

    private String name;
    private boolean onRoadstatus=false;
    private int entryTime;
    private int entry;
    private int trips=0;

    /**
     * The TollRecord Constructor will store the name of the driver, Exit, Time of Entry
     * @param name Name of the Driver
     * @param entryPort Exit Point
     * @param entryTime Time of Entry/Exit
     */
    public TollRecord(String name,int entryPort,int entryTime)
    {
        this.name = name;
        this.entry= entryPort;
        this.entryTime=entryTime;
    }

    /**
     * Compares the TollRecord
     * @param vh1 Toll Record
     * @return value of comparison
     */
    public boolean equals(TollRecord vh1)
    {
        return this.name.equals(vh1.name);
    }

    /**
     * Getter for getting name
     * @return Name of the driver
     */
    public String getName() {
        return name;
    }

    /**
     * Setting entry or exit point of vehicle
     * @param entry Exit Number
     */
    public void setEntry(int entry) {
        this.entry = entry;
    }

    /**
     * Getting Entry or exit point of vehicle
     * @return Exit Number
     */
    public int getEntry() {
        return entry;
    }

    /**
     * Getter for trips
     * @return trips
     */
    public int getTrips() {
        return trips;
    }

    /**
     * Setter for Setting on Road Status
     * @param onRoadstatus given status
     */
    public void setOnRoadstatus(boolean onRoadstatus) {
        this.onRoadstatus = onRoadstatus;

    }

    /**
     * Getter for getting OnRoad Status of Vehicle
     * @return OnRoadStatus
     */
    public boolean getOnRoadStatus()
    {
        return this.onRoadstatus;
    }

    /**
     * Getter for getting entry/exit time of the Vehicle
     * @return entry/exit time of vehicle
     */
    public int getEntryTime() {
        return entryTime;
    }

    /**
     * Setter for setting entry/exit time of the vehicle
     * @param entryTime entry/exit time of the vehicle
     */
    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * Setter for setting trips
     * @param trips Given trips
     */
    public void setTrips(int trips) {
        this.trips = trips;
    }


}
