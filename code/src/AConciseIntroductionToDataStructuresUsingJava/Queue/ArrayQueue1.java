package AConciseIntroductionToDataStructuresUsingJava.Queue;

public class ArrayQueue1<E> implements Queue1<E> {

    @Override
    public void enqueue(E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E dequeue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void main(String[] args) {
        Queue1<String> q = new ArrayQueue1<>();
    }
    
}
