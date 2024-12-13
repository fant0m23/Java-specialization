package run;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Manager extends Worker {
    public Manager(String name, int bDay, int bMonth, int bYear, int salary) {
        super(name, bDay, bMonth, bYear, salary);
    }
}
