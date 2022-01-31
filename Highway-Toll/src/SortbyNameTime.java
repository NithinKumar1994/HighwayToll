package hw6;

import java.util.Comparator;

/**
 * This class will implement Comparable interface to compare the Toll Records on basis of name first then time if the names are same.
 */
public class SortbyNameTime implements Comparator<String> {
    /**
     * Compare method to compare Strings of the TollRecords
     * @param o1 String of TollRecord_1
     * @param o2 String of TollRecord_2
     * @return result of comparison
     */
    @Override
    public int compare(String o1, String o2) {
        String name1=o1.substring(1,12).trim();
        String name2=o2.substring(1,12).trim();
        if (name1.compareTo(name2) >0)
            return 1;
        else if (name1.compareTo(name2) < 0)
            return -1;
        else {
            int timeIndexo1 = o1.indexOf("time");
            int timeendIndexo1 = o1.indexOf(';');
            String timeo1 = o1.substring(timeIndexo1 + 4, timeendIndexo1).trim();

            int timeIndexo2 = o2.indexOf("time");
            int timeendIndexo2 = o2.indexOf(';');
            String timeo2 = o2.substring(timeIndexo2 + 4, timeendIndexo2).trim();

            return Integer.compare(Integer.parseInt(timeo1), Integer.parseInt(timeo2));
        }
    }
}
