package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Random;

public class Simulator {

    private final Server server;
    private final Random random;
    private int totalCustomersServed;
    private double totalServiceTime;

    public Simulator(Server server) {
        this.server = server;
        this.random = new Random();
        this.totalCustomersServed = 0;
        this.totalServiceTime = 0;
    }

    public void simulateCustomers(int numCustomers) {

        for(int i = 0; i < numCustomers; i++) {
            Customer customer = new Customer();
            Arrival arrivalEvent = new Arrival(System.currentTimeMillis(), server, customer);

            totalServiceTime += customer.getServiceTime();

        }

        totalCustomersServed = numCustomers;
    }

    public void printStats() {
        System.out.println("Total customers served: " + totalCustomersServed);
        System.out.println("Total service time: " + String.format("%.2f", totalServiceTime) + " seconds");
        if(totalCustomersServed > 0) {
            System.out.println("Average service time: " + String.format("%.2f", totalServiceTime / totalCustomersServed) + " seconds");
        }
        server.printStats();
    }
    public static void main(String[] args) {
        int numCustomers = 20;

        System.out.println("Single queue server simulation with " + numCustomers + " customers");

        SingleQueueServer singleQueueServer = new SingleQueueServer();
        singleQueueServer.cashierArray[0] = new Cashier();

        Simulator sim1 = new Simulator(singleQueueServer);
        sim1.simulateCustomers(numCustomers);
        sim1.printStats();
        System.out.println("\n\n");

        System.out.println("Multiple queue server simulation with " + numCustomers + " customers");

        int numCashiers = 10;
        MultipleQueueServer multipleQueueServer = new MultipleQueueServer(numCashiers);
        for(int i = 0; i < numCashiers; i++) {
            multipleQueueServer.cashierArray[i] = new Cashier();
        }

        Simulator sim2 = new Simulator(multipleQueueServer);
        sim2.simulateCustomers(numCustomers);
        sim2.printStats();

        System.out.println("Single Queue Server:");
        singleQueueServer.printStats();
        System.out.println("Multiple Queues Server (" + numCashiers + " cashiers)");
        multipleQueueServer.printStats();
        System.out.println();
    }
}
