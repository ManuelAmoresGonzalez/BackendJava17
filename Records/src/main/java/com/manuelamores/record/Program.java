package com.manuelamores.record;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Client c1 = new Client(1,"Manuel", LocalDate.of(1989,10,30), true);
        ClientRecord cr1 = new ClientRecord(1,"Manuel", LocalDate.of(1989,10,30), true);
        System.out.println(c1.toString());
        System.out.println(cr1.name());
        cr1.test();
    }
}
