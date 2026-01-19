package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Arrival extends Event{

    public Arrival(double time) {
        super(time);
    }

    @Override
    public void process(Server server) {
        server.serve(customer);
    }
}
