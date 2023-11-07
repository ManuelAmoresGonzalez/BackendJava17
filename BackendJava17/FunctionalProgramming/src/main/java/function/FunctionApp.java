package function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionApp {

    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();
       app.m1Apply();
        app.m2AndThem();
        app.m3ACompose();
        app.m4Identity();
        app.m5Identity();
        app.m6Identity();
    }

    private void m1Apply() {
        Function<String, ?> fx = Integer::parseInt;
        Function<List<String>, Integer> fx1 = x -> {
            StringBuilder finalValue = new StringBuilder();
            x.forEach(
                    finalValue::append
            );
            return finalValue.length();
        };

        System.out.println(fx.apply("2"));
        System.out.println(fx1.apply(List.of("Luis","Manuel")));

    }

    private void m2AndThem(){
        Function<Integer, Integer> fx1 = x -> x*2;
        Function<Integer, Integer> fx2 = x -> x+10;

        System.out.println(fx1.andThen(fx2).apply(5));
    }

    private void m3ACompose(){
        Function<Integer, Integer> fx1 = x -> x*2;
        Function<Integer, Integer> fx2 = x -> x+10;

        System.out.println(fx1.compose(fx2).apply(5));
    }

    private void m4Identity(){
        Function<Employee, Employee> fx1 = Function.identity();
        Function<Integer, Integer> fx2 = Function.identity();
        System.out.println(fx1.apply(new Employee()));
        System.out.println(fx2.apply(5));
    }

    public void m5Identity(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"mito","teacher", LocalDate.now(), 999.99,"TI"));
        list.add(new Employee(2,"manuel","dev", LocalDate.now(), 799.99,"TE"));
        list.add(new Employee(3,"amores","mid", LocalDate.now(), 899.99,"TA"));

        Map<Integer, Employee > map = list.stream()
                .collect(Collectors.toMap(Employee::getIdEmployee, Function.identity()));

        System.out.println(map);
    }

    public void m6Identity(){
        Function<Integer, Integer> f1 = Function.identity();
        Function<Integer, Integer> f2 = Function.identity();
        Function<Integer, Integer> f3 = Function.identity();

        Function<Integer, Integer> f4 = t -> t;
        Function<Integer, Integer> f5 = t -> t;
        Function<Integer, Integer> f6 = t -> t;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println("----------------------");
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);

    }
}
