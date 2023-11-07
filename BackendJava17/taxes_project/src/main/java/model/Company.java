package model;

import lombok.Data;
import lombok.Getter;

@Getter
public class Company extends TaxPayer{

    private Integer numberOfEmployees;

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTaxes() {
        return getNumberOfEmployees() > 10 ?
                getAnualIncome() *0.14 :
                getAnualIncome() * 0.16;
    }
}
