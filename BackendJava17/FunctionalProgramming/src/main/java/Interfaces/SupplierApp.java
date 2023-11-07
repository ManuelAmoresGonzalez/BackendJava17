package Interfaces;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierApp {


    public static void main(String[] args) {
        SupplierApp app = new SupplierApp();
        app.method1();
    }
    public void method1(){
        Supplier<LocalDate> fx = () -> LocalDate.now().minusDays(2);
        Supplier<String> makePassword = () -> UUID.randomUUID().toString();
        System.out.println(fx.get());
        System.out.println(makePassword.get());
    }
}


