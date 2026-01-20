package AConciseIntroductionToDataStructuresUsingJava.Tree;


import java.util.Random;

public class Customer implements Comparable<Customer> {
    private double arriveTime;
    private double serviceTime;
    private final int CUSTOMER_CODE;
    private static int nextCode = 0;

    public Customer() {
        setServiceTime();
        this.CUSTOMER_CODE = nextCode++;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;

    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime() {
        Random gen = new Random();
        double u = gen.nextDouble();
        double lambda = Math.max(0.1, 0.5 + gen.nextGaussian() * 0.5);
        this.serviceTime = - lambda * Math.log(u);
    }

    public int getCUSTOMER_CODE() {
        return CUSTOMER_CODE;
    }

    @Override
    public int compareTo(Customer o) {
        return Double.compare(this.serviceTime, o.serviceTime);
    }
}
