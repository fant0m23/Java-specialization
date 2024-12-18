package run;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class Employee extends Customer {
    private Gender gender;

    public Employee(String name, int age, long phone, Gender gender) {
        super(name, age, phone);
        this.gender = gender;
    }
}
