package Helpers;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Intervals> {
    @Override
    public int compare(Intervals o1, Intervals o2) {
        return o1.getStart() - o2.getStart();
    }
}
