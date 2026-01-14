package AConciseIntroductionToDataStructuresUsingJava.List;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Collection;

public interface List1<E> extends Iterable<E>, Collection<E> {

    public void add(E item);
    public void add(int index, E item);
    public E removeAt(int index);
    public E get(int index);
    public E set(int index, E item);
    public int indexOf(E item);
    public int size();
    public boolean isEmpty();
    public int size = 0;
}
