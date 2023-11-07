package org.example.model;



import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @ToString.Include
    private String name;
    @ToString.Include
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
