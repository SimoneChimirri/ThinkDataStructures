package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SingleQueueServer extends Server{

    public MinHeap<Customer> queue = new MinHeap<>(100);

    @Override
    public void serve(Customer customer, double time, Simulator simulator) {
        if(queue.isEmpty() && cashierArray[0] != null && cashierArray[0].getCurrentCustomer() == null) {
            assign(customer, cashierArray[0], time, simulator);
        } else {
            queue.add(customer);
        }
    }

    @Override
    public void clear(Cashier cashier, double time, Simulator simulator) {
        cashier.setCurrentCustomer(null);
        if(!queue.isEmpty()){
            Customer nextCustomer = queue.remove();
            //assign(nextCustomer, cashier, time, simulator);
        }
    }

    @Override
    public int printStats() {
        System.out.println("Single Queue Server Stats:");
        System.out.println("Customers currently in queue: " + (!queue.isEmpty() ? queue.size() : 0));
        if(cashierArray[0] != null && cashierArray[0].getCurrentCustomer() != null) {
            System.out.println("Cashier status: BUSY");
        } else {
            System.out.println("Cashier status: AVAILABLE");
        }
        return !queue.isEmpty() ? queue.size() : 0;
    }
}
