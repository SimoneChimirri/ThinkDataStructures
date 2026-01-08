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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static void main(String[] args) {
        Queue1<String> q = new ArrayQueue1<>();
    }
    
}
