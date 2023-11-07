package Interfaces;

import model.Product;

import java.util.function.Predicate;

public class PredicateApp {


    public static void main(String[] args) {
        PredicateApp app = new PredicateApp();
        app.validation();

        app.between();

        Predicate<Product> f1 = x -> x.getName().length() >= 3;
        app.method3(new Product(1, "TVS"), f1);
    }

    private void validation() {
        Predicate<Integer> checkAge = x -> x >= 18;
        boolean result = checkAge.test(20);
        System.out.println(result);

        Predicate<String> checkLength = x -> x.length() < 10;

        boolean result1 = checkLength.test("Hello World");
        System.out.println(result1);
    }

    private void between() {
        Predicate<Integer> greatherThan = x -> x > 10;
        Predicate<Integer> lowerThan = x -> x < 20;
        System.out.println(greatherThan.and(lowerThan).test(22));
    }

    private void method3(Product product, Predicate<Product> fx){
        System.out.println(fx.test(product));
    }

}
