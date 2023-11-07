package com.manuelamores.record;

import java.time.LocalDate;
import java.util.Objects;

public class Client {

    private final int id;
    private final String name;
    private final LocalDate birthDate;
    private final boolean status;

    public Client(int id, String name, LocalDate birthDate, boolean status) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && status == client.status && Objects.equals(name, client.name) && Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, status);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", status=" + status +
                '}';
    }
}
