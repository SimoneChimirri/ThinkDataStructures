package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Queue;

public class MultipleQueueServer extends Server{

    @SuppressWarnings("unchecked")
    private Queue<Customer>[] queues = (Queue<Customer>[]) new Queue[100];

    @Override
    public void serve(Customer customer) {

    }

    @Override
    public void clear(Cashier cashier, double time) {

    }

    @Override
    public void printStats() {

    }
}
