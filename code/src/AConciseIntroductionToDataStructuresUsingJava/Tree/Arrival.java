package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Arrival extends Event{

    public Arrival(double time, Server server, Customer customer) {
        super(time);
        this.customer = customer;
    }

    @Override
    public void process(Server server, Simulator simulator) {
        customer.setArriveTime(this.time);
        server.serve(customer, this.time, simulator);
    }
}
