package AConciseIntroductionToDataStructuresUsingJava.Stack;

public class LinkedQueue implements Queue2{

    public static void main(String[] args) {
        Queue2 q1 = new ArrayQueue();
        Queue2 q2 = new LinkedQueue();
        Queue2 q = new LinkedQueue();
        Queue2 q3 = new LinkedQueue();
        q1.enqueue(19);
        int result = q2.dequeue();

        q2.enqueue(5);
        q2.enqueue(8);
        System.out.println(q2.peek());
        q2.enqueue(3);
        System.out.println(q2.dequeue());
        q2.enqueue(10);
        System.out.println(q2.size());
        q2.enqueue(3);
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());

        q.enqueue(1);
        System.out.println(q.dequeue());
        q.enqueue(2);
        System.out.println(q.dequeue());
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.enqueue(4);
        System.out.println(q.peek());
        System.out.println(q.dequeue());

        q3.enqueue(10);
        q3.enqueue(20);
        q3.enqueue(30);
        q3.enqueue(40);
        System.out.println(q.peek());
        q.enqueue(50);
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    @Override
    public void enqueue(int n) {

    }

    @Override
    public int dequeue() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean size() {
        return false;
    }


}
