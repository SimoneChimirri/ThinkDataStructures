package AConciseIntroductionToDataStructuresUsingJava.Queue;

public interface Queue1<E> {

    public void enqueue(E e);

    public E dequeue();

    public int size();

    public E peek();

    public boolean isEmpty();
}
