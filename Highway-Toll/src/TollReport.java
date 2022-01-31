package hw6;
import java.util.Map;
import java.util.Scanner;

/**
 * The main class that is used for accepting user input for bill for license , exit activity and q for quit.
 */
public class TollReport implements  TollsRUs {
    /**
     * The main method to call all the functions for Generating Report
     * @param args FileName
     */
    public static void main(String[] args) {
        TollRoadDatabase trb1 = new TollRoadDatabase(args[0]);
        System.out.println();
        trb1.genOnRoadReportht();
        System.out.println();
        trb1.genSpeederReport();
        System.out.println();
        trb1.genBillInfo();
        while(true)
        {
            System.out.println("\n'b <string>' to see bill for license tag\n" +
                    "'e <number>' to see activity at exit\n" +
                    "'q' to quit");
            Scanner sc = new Scanner(System.in);
            String line=sc.nextLine();
            char c = line.charAt(0);
            switch (c) {
                case 'b': {
                    double dueTotal=0.0;
                    for (String i : trb1.getDatabase()) {
                        if (i.substring(1,12).trim().equals(line.substring(2).toUpperCase()))
                        {
                            System.out.println(i);
                            int index1= i.indexOf("$");
                            dueTotal+=Double.parseDouble(i.substring(index1+1,index1+6));
                        }

                    }
                    System.out.println("\nVehicle total due: "+String.format(DOLLAR_FORMAT,dueTotal)+"\n");
                    break;
                }
                case 'e': {
                    System.out.println("EXIT "+line.substring(2)+" REPORT\n==============");
                    for (String i : trb1.getDatabase()) {
                        if (i.contains("#" + line.substring(2)))
                            System.out.println(i.substring(0,i.length()-8));
                    }
                    for (Map.Entry i : trb1.getOnRoadDatabaseht().entrySet()) {
                        if (i.getValue().toString().contains("#" + line.substring(2)))
                            System.out.println(i.getValue());
                    }
                    break;
                }
                case 'q':System.exit(0);break;
                default:
                    System.out.println("Illegal command. Try again");

            }
        }
        }
}
    










































