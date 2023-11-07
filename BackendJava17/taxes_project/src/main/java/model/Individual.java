package model;

import lombok.Getter;

@Getter
public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double calculateTaxes() {
        double basicTax = 0;
        if(getAnualIncome() < 20000){
            basicTax = getAnualIncome() * 0.15;
        }else{
            basicTax = getAnualIncome() * 0.25;
        }
        if(getHealthExpenditures() > 0){
            basicTax -= getHealthExpenditures() * 0.5;
        }
        return  basicTax;
    }
}
