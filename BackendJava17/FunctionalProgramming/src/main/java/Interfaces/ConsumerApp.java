package Interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerApp {

    public static void main(String[] args) {
        Consumer<String> fx1 = x -> System.out.println(x);
        fx1.accept("Hello");

        ConsumerApp app = new ConsumerApp();
        app.method1();

    }

    public static void test(){
        System.out.println("Hola");
    }

    public static void method1(){

        List<Integer> list = List.of(1,2,3,4,5);

        Consumer<Integer> consumer = x -> {
            x++;
            System.out.println(x);
        };
        listAll(list, consumer);
    }

    private static void listAll(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(consumer);
    }
}
