package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Random;

public class Cashier {

    private Customer currentCustomer;
    private final double efficiencyRating;

    public Cashier() {
        Random gen = new Random();
        double u = gen.nextDouble();
        double lambda = Math.max(0.1, 0.5 + gen.nextGaussian() * 0.5);
        this.efficiencyRating = - lambda * Math.log(u);
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
