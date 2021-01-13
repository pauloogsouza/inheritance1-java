package model.entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double getValue = getAnnualIncome() < 20000.00 ? getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;
        return healthExpenditures != 0.0 ? getValue - healthExpenditures * 0.5 : getValue;
    }
}
