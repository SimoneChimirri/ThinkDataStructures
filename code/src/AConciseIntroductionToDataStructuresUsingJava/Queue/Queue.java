public interface Queue<E> {

    public void enqueue(E e);

    public E dequeue();
}
