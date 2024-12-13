package run;

import java.util.Comparator;

public class WorkerComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        int date1 = (int) (o1.bYear * 365.25 + o1.bMonth * 30.5 + o1.bDay);
        int date2 = (int) (o2.bYear * 365.25 + o2.bMonth * 30.5 + o2.bDay);
        return date1 - date2;
    }
}
