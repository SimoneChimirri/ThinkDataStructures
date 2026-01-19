package AConciseIntroductionToDataStructuresUsingJava.Tree;

public abstract class Server {

    protected Cashier[] cashierArray = new Cashier[10];

    public void assign(Customer customer, Cashier cashier, double time){
        cashier.setCurrentCustomer(customer);
        double serviceTime = customer.getServiceTime();
        double departureTime = System.currentTimeMillis() + serviceTime;
        Event departureEvent = new Departure(departureTime, cashier, this);
    }

    public abstract void serve(Customer customer);
    public abstract void clear(Cashier cashier, double time);
    public abstract void printStats();
}
