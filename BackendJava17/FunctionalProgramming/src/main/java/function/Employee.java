package function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    private int idEmployee;
    private String name;
    private String job;
    private LocalDate birthDate;
    private double salary;
    private String department;


}
