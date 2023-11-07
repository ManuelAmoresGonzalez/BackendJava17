package streams;

import function.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

public class AppStream {

final Logger log = Logger.getLogger("AppStream");

    public static void main(String[] args) {

        AppStream app = new AppStream();

        Employee e1 = new Employee(11,"mito","teacher", LocalDate.of(1991,1,12), 999.99,"TI");
        Employee e2 = new Employee(20,"manuel","dev", LocalDate.of(1989,1,12), 501.92,"TE");
        Employee e3 = new Employee(3,"amores","mid", LocalDate.of(2002,1,12), 695.23,"TA");
        Employee e11 = new Employee(18,"amores","mid", LocalDate.of(1991,1,12), 1123.06,"TA");

        Employee e4 = new Employee(11,"mito","teacher", LocalDate.of(2022,1,12), 123.654,"TI");
        Employee e5 = new Employee(25,"manuel","dev", LocalDate.of(1991,1,12), 1234.06,"TE");
        Employee e6 = new Employee(13,"amores","mid", LocalDate.of(1999,1,12), 12.21,"TA");
        Employee e7 = new Employee(15,"mito","teacher", LocalDate.of(2023,1,12), 800.01,"TI");
        Employee e8 = new Employee(29,"manuel","dev", LocalDate.of(2001,1,12), 995.95,"TE");
        Employee e9 = new Employee(18,"amores","mid", LocalDate.of(1991,1,12), 1123.06,"TA");
        Employee e10 = new Employee(18,"amores","mid", LocalDate.of(1991,1,12), 1123.06,"TA");


        List<Employee> list = List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11);

        //app.m1GetDevelopers(list, "dev" );
        //app.m2getInverse(list);
        //app.m3getAdults(list);
        //app.m4getOldestAdult(list);
        //app.m5getMaxMinSalary(list);
        //app.m6getAverageSalary(list);
        //app.m7getSummary(list);
        //app.m8getDistinct(list);
        //app.m9getCount(list);
        //app.m10skipLimit(list);
        //app.m11getAnyYounger(list);
        //app.m12map(list);
        //app.m13flatMap(list);
        //app.m14peek(list);
        //app.m15GroupBy(list);
        //app.m16ToSet(list);
        app.m17Order(list);


    }

    private void m17Order(List<Employee> list) {
        list.stream()
                .sorted(comparingInt(Employee::getIdEmployee).reversed())
                .forEach(System.out::println);
    }

    private void m16ToSet(List<Employee> list) {

        Set<Employee> setStructure = new HashSet<>(list);
    }

    private void m15GroupBy(List<Employee> list) {
       Map<String, List<Employee>> byDeparment = list.stream()
               .collect(groupingBy(Employee::getDepartment));

        Map<String, Map<String, List<Employee>>> byDeparmentAndJob = list.stream()
                .collect(groupingBy(Employee::getDepartment, groupingBy(Employee::getJob)));

        byDeparmentAndJob.forEach((department, jobMap) -> {
            System.out.println("Departamento: " + department);
            jobMap.forEach((job, employees) -> {
                System.out.println("  Puesto: " + job);
                employees.forEach(employee -> {
                    System.out.println("    Empleado: " + employee.getName());
                });
            });
        });
    }

    private void m14peek(List<Employee> list) {

        list.stream()
                .filter(employee -> employee.getSalary() < 3000)
                .peek(e -> log.info("First block "+e.toString()))
                .collect(Collectors.toList());
    }

    private void m13flatMap(List<Employee> list) {

        list.stream().flatMap(employee -> {
            employee.setSalary(employee.getSalary() + 1.10);
            return Stream.of(employee.getSalary(), employee.getName(), "Manuel");
        })
                .forEach(System.out::println);
    }

    private void m12map(List<Employee> list) {

        list.stream()
                .map(employee -> {
                    employee.setSalary(employee.getSalary() * 1.10);
                    return employee;
                })
                .forEach(System.out::println);
    }

    private void m11getAnyYounger(List<Employee> list) {

        Predicate<Employee> isYounger = employee -> Period.between(employee.getBirthDate(), LocalDate.now()).getYears() < 18;
        boolean rpta = list.stream()
                .anyMatch(isYounger);

        System.out.println("Is any younger in this data ? "+rpta);
    }

    private void m10skipLimit(List<Employee> list) {
        list.stream()
                .skip(4)
                .limit(4)
                .forEach(System.out::println);

        /*list.stream()
                .limit(4)
                .forEach(System.out::println);*/
    }

    private void m9getCount(List<Employee> list) {
        System.out.println();
    }

    private void m8getDistinct(List<Employee> list) {
        list.stream().distinct().forEach(System.out::println);
    }

    private void m7getSummary(List<Employee> list) {

        DoubleSummaryStatistics statics =  list.stream().mapToDouble(Employee::getSalary)
                .summaryStatistics();

        System.out.println(statics);


    }

    private void m6getAverageSalary(List<Employee> list) {

        Double averageSalary = list.stream().mapToDouble(Employee::getSalary)
                .average().orElse(0);
        System.out.println(averageSalary);
    }

    private void m5getMaxMinSalary(List<Employee> list) {

        Double max = list.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        Double min = list.stream().mapToDouble(Employee::getSalary).min().orElse(0);
        Employee employee = list.stream().max(comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println(max);
        System.out.println(min);
        System.out.println(employee);
    }

    private void m4getOldestAdult(List<Employee> list) {
        list.stream().sorted(comparing(Employee::getBirthDate)).limit(1).forEach(System.out::println);
    }

    private void m3getAdults(List<Employee> list) {
        Predicate<Employee> isAdult = e -> e.getIdEmployee()>= 18;
        list.stream().filter(isAdult).sorted(comparing(Employee::getIdEmployee)).forEach(System.out::println);
    }

    private void m2getInverse(List<Employee> list) {
        list.stream()
                .sorted(comparing(Employee::getName).reversed());
        list.forEach(System.out::println);
    }

    private void m1GetDevelopers(List<Employee> list, String searchText) {

        Predicate<Employee> validateName = e -> e.getJob().toLowerCase().contains(searchText);

        /*List<String> names = list.stream()
                .filter(validateName)
                .map(Employee::getName)
                .toList();
        System.out.println(names);*/

        list.stream().filter(validateName).forEach(System.out::println);
    }
}
