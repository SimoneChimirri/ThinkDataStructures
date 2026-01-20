package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Departure extends Event{

    Cashier cashier;

    public Departure(double time, Cashier cashier) {
        super(time);
        this.cashier = cashier;
    }

    @Override
    public void process(Server server, Simulator simulator) {
        server.clear(cashier, this.time, simulator);
    }
}
