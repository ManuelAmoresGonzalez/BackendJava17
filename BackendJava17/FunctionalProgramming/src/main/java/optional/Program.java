package optional;

import function.Employee;

import java.time.LocalDate;
import java.util.Optional;

public class Program {

    public static void main(String[] args) {
        Program app = new Program();
        app.mOptional();

    }

    private void mOptional() {
        Optional<Employee> optional = Optional.of(new Employee(1,"mito","teacher", LocalDate.now(), 999.99,"TI"));
        Optional<Employee> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());
        System.out.println(optional.get());

        //emptyOptional.ifPresent(obj -> System.out.println(obj.getName()));

        System.out.println(emptyOptional.orElse(new Employee()));
        System.out.println(emptyOptional.orElseGet(Employee::new)); //() -> new Employee()
    }
}
