package AConciseIntroductionToDataStructuresUsingJava.Tree;

public interface PriorityQueue<E> extends Collection<E> {
    public final int DEFAULT_CAPACITY = 10;
    public void add(E item);
    public E remove();
    public E peek();
}
