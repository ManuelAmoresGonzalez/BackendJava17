package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int idProduct;
    private String name;

    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
