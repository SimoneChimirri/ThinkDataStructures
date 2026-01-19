package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Random;

public abstract class Event implements Comparable<Event> {

    double time;
    Customer customer;

    public Event(){
        this(0);
    }

    public Event(double time) {
        Random gen = new Random();
        double u = gen.nextDouble();
        double lambda = Math.max(0.1, 0.5 + gen.nextGaussian() * 0.5);
        this.time = time - lambda * Math.log(u);
        this.customer = new Customer();
    }

    @Override
    public int compareTo(Event o) {
        if(o == null) throw new NullPointerException();
        return (Double.compare(this.time, o.time));
    }

    public abstract void process(Server server);


}
