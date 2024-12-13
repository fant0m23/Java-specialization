package run;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Worker implements Comparable<Worker> {
    protected String name;
    protected int bDay;
    protected int bMonth;
    protected int bYear;
    protected int salary;

    public int compare(int bYear, int bMonth, int bDay) {
        int date1 = (int) (this.bYear * 365.25 + this.bMonth * 30.5 + this.bDay);
        int date2 = (int) (bYear * 365.25 + bMonth * 30.5 + bDay);
        return date1 - date2;
    }

    @Override
    public int compareTo(Worker o) {
        Date date1 = Date.valueOf(this.bYear + "-" + this.bMonth + "-" + this.bDay);
        Date date2 = Date.valueOf(o.getBYear() + "-" + o.getBMonth() + "-" + o.getBDay());
        return date1.compareTo(date2);
    }

    public void salaryIncrease(){
        this.salary *= 1.08;
    }
}
