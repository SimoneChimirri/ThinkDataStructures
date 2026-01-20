package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class MultipleQueueServer extends Server{

    private int cashierCount;
    @SuppressWarnings("unchecked")
    private final MinHeap<Customer>[] queues = new MinHeap[cashierCount];

    public MultipleQueueServer(int cashierCount) {
        this.cashierCount = cashierCount;
    }

    @Override
    public void serve(Customer customer, double time, Simulator simulator) {
        int minIndex = -1;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].size() < minSize) {
                minSize = queues[i].size();
                minIndex = i;
            }
        }
        if (minIndex != -1) {
            if (queues[minIndex].isEmpty() && cashierArray[minIndex] != null && cashierArray[minIndex].getCurrentCustomer() == null) {
                assign(customer, cashierArray[minIndex], time, simulator);
            } else {
                queues[minIndex].add(customer);
            }
        } else {
            if(cashierArray[0] == null) cashierArray[0] = new Cashier();
            assign(customer, cashierArray[0], time, simulator);
        }
    }

    @Override
    public void clear(Cashier cashier, double time, Simulator simulator) {
        cashier.setCurrentCustomer(null);
        int cashierIndex = -1;
        for(int i = 0; i < cashierArray.length; i++) {
            if(cashierArray[i] == cashier) {
                cashierIndex = i;
                break;
            }
        }
        if(cashierIndex != -1 && !(queues.length == 0) && !queues[cashierIndex].isEmpty()) {
            Customer nextCustomer = queues[cashierIndex].remove();
            //assign(nextCustomer, cashier, time, simulator);
        }
    }

    @Override
    public int printStats() {
        System.out.println("Multiple Queue Server Stats:");
        int totalCustomers = 0;
        for (int i = 0; i < queues.length; i++) {
            System.out.println("Queue " + i + ": " + queues[i].size() + " customers");
            System.out.println("Cashier: " + (cashierArray[i].getCurrentCustomer() != null ? "BUSY" : "AVAILABLE"));
            totalCustomers += queues[i].size();
        }
        System.out.println("Total customers in the queues: " + totalCustomers);
        return totalCustomers;
    }
}
