package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Queue;

public class MultipleQueueServer extends Server{

    private int cashierCount;
    @SuppressWarnings("unchecked")
    private final MinHeap<Customer>[] queues = new MinHeap[cashierCount];

    public MultipleQueueServer(int cashierCount) {
        this.cashierCount = cashierCount;
    }

    @Override
    public void serve(Customer customer) {
        int minIndex = -1;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].size() < minSize && !(queues[i].isEmpty())) {
                minSize = queues[i].size();
                minIndex = i;
            }
        }
        if (minIndex != -1) {
            if (queues[minIndex].isEmpty() && cashierArray[minIndex].getCurrentCustomer() == null)
            {
                assign(customer, cashierArray[minIndex], customer.getArriveTime());
            } else{
                queues[minIndex].add(customer);
            }
        }else {
            cashierArray[0] = new Cashier();
            assign(customer, cashierArray[0], customer.getArriveTime());
        }
    }

    @Override
    public void clear(Cashier cashier, double time) {
        cashier.setCurrentCustomer(null);
        int cashierIndex = -1;
        for(int i = 0; i < cashierArray.length; i++) {
            if(cashierArray[i] == cashier) {
                cashierIndex = i;
                break;
            }
        }
        if(!(queues.length == 0) && !queues[cashierIndex].isEmpty()) {
            Customer nextCustomer = queues[cashierIndex].remove();
            assign(nextCustomer, cashier, time);
        }
    }

    @Override
    public void printStats() {
        System.out.println("Multiple Queue Server Stats:");
        int totalCustomers = 0;
        for (int i = 0; i < queues.length; i++) {
            System.out.println("Queue " + i + ": " + queues[i].size() + " customers");
            System.out.println("Cashier: " + (cashierArray[i].getCurrentCustomer() != null ? "BUSY" : "AVAILABLE"));
            totalCustomers += queues[i].size();
        }
        System.out.println("Total customers in the queues: " + totalCustomers);
    }
}
