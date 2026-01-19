package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Arrival extends Event{

    public Arrival(double time, Server server, Customer customer) {
        super(time);
        this.customer = customer;
        process(server);
    }

    @Override
    public void process(Server server) {
        customer.setArriveTime();
        server.serve(customer);
    }
}
