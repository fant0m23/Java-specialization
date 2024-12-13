package run;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Employee extends Worker {
    public Employee(String name, int bDay, int bMonth, int bYear, int salary) {
        super(name, bDay, bMonth, bYear, salary);
    }
}
