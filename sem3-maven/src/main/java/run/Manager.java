package run;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor

public class Manager extends Worker {
    public Manager(String name, int bDay, int bMonth, int bYear, int salary) {
        super(name, bDay, bMonth, bYear, salary);
    }

    public static void payIncreaser(List<Worker> workers, Double percent) {
        for (Worker w : workers) {
            if (!(w instanceof Manager)) w.salaryIncrease(percent);
        }
    }
}
