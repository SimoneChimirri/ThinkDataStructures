public class LinkedQueue implements Queue{

    public static void main(String[] args) {
        Queue q1 = new ArrayQueue();
        Queue q2 = new LinkedQueue();
        q1.enqueue(19);
        int result = q2.dequeue();
    }

    @Override
    public void enqueue(int n) {

    }

    @Override
    public int dequeue() {
        return 0;
    }


}
