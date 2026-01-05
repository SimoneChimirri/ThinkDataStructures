public class ArrayQueue<E> implements Queue<E> {

    @Override
    public void enqueue(E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E dequeue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        Queue<String> q = new ArrayQueue<>();
    }
    
}
