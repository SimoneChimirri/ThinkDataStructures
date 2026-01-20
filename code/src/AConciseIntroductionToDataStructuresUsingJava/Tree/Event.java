package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Random;

public abstract class Event implements Comparable<Event> {

    double time;
    Customer customer;

    public Event(){
        this(0);
    }

    public Event(double time) {
        this.time = time;
    }

    @Override
    public int compareTo(Event o) {
        if(o == null) throw new NullPointerException();
        return (Double.compare(this.time, o.time));
    }

    public abstract void process(Server server, Simulator simulator);


}
