package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Departure extends Event{

    Cashier cashier;

    public Departure(double time, Cashier cashier, Server server) {
        this.time = time;
        this.cashier = cashier;
        process(server);
    }

    @Override
    public void process(Server server) {
        server.clear(cashier,time);
    }
}
