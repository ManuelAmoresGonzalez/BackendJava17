package com.manuelamores.record;

import java.time.LocalDate;

public record ClientRecord(
        int id,
        String name,
        LocalDate birthDate,
        boolean status
) implements Repository {

    public static final String DEFAULT_NAME = "DUKE";

    public ClientRecord(LocalDate birthDate) {
        this(0, null, birthDate, false);
    }

    @Override
    public void test() {
        System.out.println("Estoy en test");
    }
}
