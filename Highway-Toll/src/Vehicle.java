package hw6;

public class Vehicle {


    private String name;
    private boolean onRoadstatus=false;
    private int entry;
    private int trips=0;
    Vehicle(String name,int entry)
    {
        this.name = name;
        this.entry= entry;
    }
    public boolean equals(Vehicle vh1)
    {
        return this.name.equals(vh1.name);
    }
    public String getName() {
        return name;
    }
    public boolean isOnRoadstatus() {
        return onRoadstatus;
    }

    public int getEntry() {
        return entry;
    }

    public int getTrips() {
        return trips;
    }
    public void setOnRoadstatus(boolean onRoadstatus) {
        this.onRoadstatus = onRoadstatus;

    }
    public void setTrips(int trips) {
        this.trips = trips;
    }

}
