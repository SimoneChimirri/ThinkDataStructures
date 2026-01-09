package AConciseIntroductionToDataStructuresUsingJava.List;

public interface List1<E> {

    public void add(E item);
    public void add(int index, E item);
    public E removeAt(int index);
    public E get(int index);
    public E set(int index, E item);
    public int indexOf(E item);
    public int size();
}
