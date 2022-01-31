import java.io.FileNotFoundException;
import java.util.*;

import static hw6.FileHandler.open;
import static java.lang.StrictMath.abs;
/**
 * A class that reads a file and creates all the reports
 */
public class TollRoadDatabase implements TollsRUs {
    private List<String> Database = new ArrayList<>();
    private List<String> SpeedReport = new ArrayList<>();
    private SortedMap<String, String> OnRoadDatabaseht = new TreeMap<String, String>();
    private double TotalDayBill = 0.0;
    /**
     * The constructor of the class that reads the file entered by the user and populating all the data structures.
     * @param FileName The name of the filename that needs to be iterated through.
     */
    public TollRoadDatabase(String FileName) {
        for (String line : open(FileName)) {
            TollRecord newVeh = this.produceVehicle(line);
            int flag = 0;
            for (TollRecord i : this.getVhs())
                if (newVeh.equals(i)) {
                    flag = 1;
                    break;
                }
            if (flag == 1) {
                for (int i = 0; i < this.getVhs().size(); i++)
                    if (this.getVhs().get(i).equals(newVeh) && this.getVhs().get(i).getOnRoadStatus()) {
                        this.getVhs().get(i).setOnRoadstatus(false);
                        this.getVhs().get(i).setTrips(this.getVhs().get(i).getTrips() + 1);
                        this.setTotTrips(this.getTotTrips() + 1);
                        String bill1 = String.format(DOLLAR_FORMAT, ExitInfo.getToll(this.getVhs().get(i).getEntry(), newVeh.getEntry()));
                        this.setTotalDayBill(this.getTotalDayBill() + Double.parseDouble(bill1.substring(1)));
                        this.addBill(String.format(COMPLETE_TOLL_RECORD_FORMAT, this.getVhs().get(i).getName(), this.getVhs().get(i).getEntry(), this.getVhs().get(i).getEntryTime(), newVeh.getEntry(), newVeh.getEntryTime()) + ": " + String.format(DOLLAR_FORMAT, (ExitInfo.getToll(this.getVhs().get(i).getEntry(), newVeh.getEntry()))));
                        //Speeder Report
                        double distance = ExitInfo.getMileMarker(this.getVhs().get(i).getEntry()) - ExitInfo.getMileMarker(newVeh.getEntry());
                        double speed = this.computeSpeed(abs(distance), this.getVhs().get(i).getEntryTime(), newVeh.getEntryTime());
                        if (speed > SPEED_LIMIT) {
                            String line11 = "Vehicle " + newVeh.getName() + ", starting at time " + this.getVhs().get(i).getEntryTime() + "\n"
                                    + "\tfrom " + ExitInfo.getName(this.getVhs().get(i).getEntry()) + "\n"
                                    + "\tto " + ExitInfo.getName(newVeh.getEntry()) + "\n"
                                    + "\t" + String.format(SPEED_FORMAT, speed);
                            this.addSpeedToll(line11);
                        }
                        break;
                    } else {
                        if (this.getVhs().get(i).equals(newVeh)) {
                            this.getVhs().get(i).setOnRoadstatus(true);
                            this.getVhs().get(i).setEntryTime(newVeh.getEntryTime());
                            this.getVhs().get(i).setEntry(newVeh.getEntry());
                            break;
                        }
                    }
            } else {
                newVeh.setOnRoadstatus(true);
                this.getVhs().add(newVeh);
            }

        }
    }
    /**
     *  Getter of TollRecord
     * @return List of TollRecord Object
     */
    public List<TollRecord> getVhs() {
        return vhs;
    }

    private List<TollRecord> vhs = new ArrayList<TollRecord>();
    /**
     * Method used to populate the SpeedToll List.
     * @param line Passing String that represents the speed toll.
     */

    public void addSpeedToll(String line) {
        SpeedReport.add(line);
    }
    /**
     * Method used to populate the Bill List.
     * @param line Passing String that represents the bill.
     */
    public void addBill(String line) {
        Database.add(line);
    }
    /**
     *
     * @return The total Bill of all the cars.
     */
    public double getTotalDayBill() {
        return TotalDayBill;
    }
    /**
     * Setter method for total Bill
     * @param totalDayBill Passing the total
     */
    public void setTotalDayBill(double totalDayBill) {
        TotalDayBill = totalDayBill;
    }
    /**
     * Getter method for total Trips
     * *
     */
    public double getTotTrips() {
        return TotTrips;
    }
    /**
     * Setter method for total Trips.
     * @param totTrips Passing the total trips and setting it.
     */
    public void setTotTrips(double totTrips) {
        TotTrips = totTrips;
    }

    private static double TotTrips = 0;
    /**
     *  Method to Create Toll record Objects.
     * @param line A Line from the file
     * @return None
     */
    public TollRecord produceVehicle(String line) {
        String[] arr = line.split(",");
        return new TollRecord(arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[0]));
    }
    /**
     * Method that generates the BillInformation
     */
    public void genOnRoadReportht() {
        System.out.println(Math.round(TotTrips) + " completed trips \n");
        System.out.println("On-Road Report\n" + "==============");
        for (TollRecord i : this.vhs) {
            if (i.getOnRoadStatus()) {
                String line = String.format(INCOMPLE_TOLL_RECORD_FORMAT, i.getName(), i.getEntry(), i.getEntryTime());
                OnRoadDatabaseht.put(i.getName(), line);
            }
        }
        for (Map.Entry i : OnRoadDatabaseht.entrySet())
            System.out.println(i.getValue());
    }
    /**
     *Method that prints the Bill Information
     */
    public void genBillInfo() {
        System.out.println("BILLING INFORMATION\n" + "===================");
        //Sort using time then name
        Collections.sort(this.getDatabase(), new SortbyNameTime());
        //Collections.sort(this.getDatabase());
        for (String i : this.getDatabase())
            System.out.println(i);
        System.out.println("Total:  " + String.format(DOLLAR_FORMAT, this.getTotalDayBill()));
    }
    /**
     * Calculating the speed of the vehicle
     * @param distance distance travelled by the vehicle
     * @param entryTime Entry time of the vehicle
     * @param exitTime Exit time of the vehicle
     * @return Speed of the Vehicle
     */
    public double computeSpeed(double distance, int entryTime, int exitTime) {
        distance = Math.round((distance * 100.0)) / 100.0;
        return (distance * MINUTES_PER_HOUR) / (exitTime - entryTime);
    }
    /**
     * Method that prints the generate Speed Report
     */
    public void genSpeederReport() {
        System.out.println("\nSPEEDER REPORT" + "\n" + "==============");
        Collections.sort(this.getSpeedReport());
        for (String i : this.getSpeedReport())
            System.out.println(i);
    }
    /**
     * Method that returns the List of Strings scanned from the file.
     * @return Database
     */
    public List<String> getDatabase() {
        return Database;
    }
    /**
     *
     * @return List of Strings that consists SpeedReport
     */
    public List<String> getSpeedReport() {
        return SpeedReport;
    }
    /**
     *
     * @return TreeMap that consists of onRoadDatabase
     */
    public SortedMap<String, String> getOnRoadDatabaseht() {
        return OnRoadDatabaseht;
    }

}
