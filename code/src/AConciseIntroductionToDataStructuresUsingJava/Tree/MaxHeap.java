package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<E extends Comparable<? super E>> implements PriorityQueue<E>{

    private E[] data;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity){
        data = (E[]) new Comparable[capacity];
    }

    @Override
    public void add(E item) {

    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return data[0];
    }

    @Override
    public int size() {
        return PriorityQueue.size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity){
        E[] newData = (E[]) new Comparable[newCapacity];
        System.arraycopy(data, 0, newData, 0, newCapacity);
        System.out.println("The array has been resized to capacity: " + newCapacity);
        data = newData;
    }

    private E parent(E item){
        return item;
    }

    private E left(E item){
        return item;
    }

    private E right(E item){
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args){
        MaxHeap<Integer> pqa = new MaxHeap<>();
        pqa.add(5);
        pqa.add(8);
        pqa.peek();
        pqa.add(3);
        pqa.remove();
        pqa.add(10);
        pqa.size();
        pqa.add(4);
        pqa.remove();
        pqa.remove();

        MaxHeap<Integer> pqb = new MaxHeap<>();
        pqb.add(10);
        pqb.add(20);
        pqb.add(30);
        pqb.add(40);
        pqb.peek();
        pqb.add(50);
        pqb.remove();
        pqb.size();
        pqb.remove();
        pqb.remove();
    }
}
