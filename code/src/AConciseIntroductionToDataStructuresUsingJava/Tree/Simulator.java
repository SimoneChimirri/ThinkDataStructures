package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Random;
import java.util.PriorityQueue;

public class Simulator {

    private final Server server;
    private int totalCustomersServed;
    private int totalCustomersArrived;
    private int totalCustomersQueued;
    private double totalServiceTime;
    private final PriorityQueue<Event> eventQueue;

    public Simulator(Server server) {
        this.server = server;
        this.totalCustomersArrived = 0;
        this.totalServiceTime = 0;
        this.eventQueue = new PriorityQueue<>();
    }

    public void simulateCustomers(int numCustomers) {

        double interArrivalTime = 0;
        for(int i = 0; i < numCustomers; i++) {
            Customer customer = new Customer();
            Random gen = new Random();
            double u = gen.nextDouble();
            double lambda = Math.max(0.1, 0.5 + gen.nextGaussian() * 0.5);
            interArrivalTime = - lambda * Math.log(u);

            Arrival arrivalEvent = new Arrival(interArrivalTime, server, customer);
            eventQueue.add(arrivalEvent);
        }

        while(!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            event.process(server, this);
            if(event.customer!=null) event.customer.setServiceTime();
            totalServiceTime += event.customer != null ? event.customer.getServiceTime() : 0;
        }

        totalCustomersArrived = numCustomers;
    }

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public void printStats() {
        System.out.println("Total customers arrived: " + totalCustomersArrived);
        System.out.println("Total service time: " + String.format("%.2f", totalServiceTime) + " seconds");
        totalCustomersQueued = server.printStats();
        totalCustomersServed = totalCustomersArrived - totalCustomersQueued;
        System.out.println("Total customers served: " + totalCustomersServed);
        if(totalCustomersServed > 0) {
            System.out.println("Average service time: " + String.format("%.2f", totalServiceTime / totalCustomersServed) + " seconds");
        }
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

        System.out.println();
        System.out.println("Single Queue Server:");
        singleQueueServer.printStats();
        System.out.println("Multiple Queues Server (" + numCashiers + " cashiers)");
        multipleQueueServer.printStats();
        System.out.println();
    }
}
