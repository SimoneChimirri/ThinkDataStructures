package AConciseIntroductionToDataStructuresUsingJava.Tree;

public class Departure extends Event{

    public Departure(double time) {
        super(time);
    }

    @Override
    public void process(Server server) {
        server.clear(server.cashierArray[0],time);
    }
}
