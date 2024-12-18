package run;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private int age;
    private long phone;



    public enum Gender{
        MALE,
        FEMALE;
    }
}
