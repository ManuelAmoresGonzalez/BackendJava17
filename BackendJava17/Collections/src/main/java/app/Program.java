package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.shuffle(list);
        System.out.println(list);

        list.forEach(e -> System.out.println(e.);

    }

}
