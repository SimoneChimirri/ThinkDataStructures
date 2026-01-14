package AConciseIntroductionToDataStructuresUsingJava.Queue;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Collection;

public interface Queue1<E> extends Collection<E> {

    public void enqueue(E e);

    public E dequeue();

    public int size();

    public E peek();

    public boolean isEmpty();
    
    public int size = 0;
    
    public int capacity = 10;
}
