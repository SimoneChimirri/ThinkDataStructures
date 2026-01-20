package AConciseIntroductionToDataStructuresUsingJava.Tree;

public abstract class Server {

    protected Cashier[] cashierArray = new Cashier[10];

    public void assign(Customer customer, Cashier cashier, double time, Simulator simulator){
        cashier.setCurrentCustomer(customer);
        double serviceTime = customer.getServiceTime();
        double departureTime = time + serviceTime;
        Event departureEvent = new Departure(departureTime, cashier);
        simulator.addEvent(departureEvent);
    }

    public abstract void serve(Customer customer, double time, Simulator simulator);
    public abstract void clear(Cashier cashier, double time, Simulator simulator);
    public abstract int printStats();
}
