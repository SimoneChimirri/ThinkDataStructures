package AConciseIntroductionToDataStructuresUsingJava.Tree;

public abstract class Server {

    Cashier[] cashierArray;

    public void assign(Customer customer, Cashier cashier, double time){
        cashierArray[0] = cashier;
        cashier.setCurrentCustomer(customer);
    }

    public abstract void serve(Customer customer);
    public abstract void clear(Cashier cashier,double time);
    public abstract void printStats();
}
