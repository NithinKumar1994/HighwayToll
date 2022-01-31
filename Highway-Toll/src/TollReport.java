package hw6;
import static hw6.FileHandler.*;

import java.util.ArrayList;
import java.util.List;

public class TollReport {

    List<Vehicle> vhs= new ArrayList<Vehicle>();
    List<String> TollList= new ArrayList<>();
    public static void main(String[] args) {
        TollReport tp1 = new TollReport();
        for( String line:open("hw6/small.txt"))
        {
            Vehicle newVeh= tp1.produceVehicle(line);
            int flag=0;
            for(Vehicle i: tp1.vhs)
                if(newVeh.equals(i))
                {
                    flag=1;
                    break;
                }
            if(flag==1)
             {
                 for (int i=0;i<tp1.vhs.size();i++)
                     if(tp1.vhs.get(i).equals(newVeh))
                     {
                         tp1.vhs.get(i).setOnRoadstatus(false);
                         tp1.vhs.get(i).setTrips(tp1.vhs.get(i).getTrips()+1);
                         double ll=10.20;
                         System.out.printf("$%.2f\n",(ExitInfo.getToll(tp1.vhs.get(i).getEntry(),newVeh.getEntry())));
                         break;
                     }
             }
            else{
                newVeh.setOnRoadstatus(true);
                tp1.vhs.add(newVeh);
             }

        }
        for (Vehicle i:tp1.vhs)
        {
            System.out.println(i.getName());
        }
    }
    public Vehicle produceVehicle(String line)
    {
        String[] arr = line.split(",");
        return new Vehicle(arr[1],Integer.parseInt(arr[2]));
    }
    public void genBillInfo()
    {
        System.out.println("BILLING INFORMATION\n"+"===================");

    }

}