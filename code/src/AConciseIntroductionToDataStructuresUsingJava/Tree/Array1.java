package AConciseIntroductionToDataStructuresUsingJava.Tree;

public abstract class Array1<E> {
    E[] data;
    static final int DEFAULT_CAPACITY = 10;

    public Array1(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Array1(int capacity){
        this.data = (E[]) new Object[capacity];
    }

    private void resize(int newCapacity){

    }

}
