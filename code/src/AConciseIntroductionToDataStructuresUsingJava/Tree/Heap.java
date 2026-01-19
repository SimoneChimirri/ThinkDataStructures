package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Arrays;
import java.util.NoSuchElementException;

public abstract class Heap<E extends Comparable<? super E>> implements PriorityQueue<E> {

    protected E[] data;
    protected int size = 0;
    protected int capacity = 10;


    @Override
    public void add(E item) { // O(log n) - O(1) if the heap is empty

    }

    @Override
    public E remove() { // O(log n)
        return null;
    }

    @Override
    public E peek() { // O(1)
        if(isEmpty()) throw new NoSuchElementException();
        return data[0];
    }

    @Override
    public int size() { // O(1)
        return this.size;
    }

    @SuppressWarnings("unchecked")
    protected void resize(int newCapacity){
        E[] newData = (E[]) new Comparable[newCapacity];
        System.arraycopy(data, 0, newData, 0, newCapacity);
        System.out.println("The array has been resized to capacity: " + newCapacity);
        data = newData;
    }

    protected int parent(int index){
        if(isValid((index-1)/2)) return (index-1)/2;
        return -1;
    }

    protected int left(int index){
        if(isValid(index*2+1)) return index*2+1;
        return -1;
    }

    protected int right(int index){
        if(isValid(index*2+2)) return index*2+2;
        return -1;
    }

    protected int lastNodeParent(){
        return parent(size()-1);
    }

    protected void swap(int i, int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    protected boolean isValid(int i){
        return i >=0 && i < size();
    }

    protected boolean isHigher(int i,int j){
        return true;
    }

    @Override
    public boolean isEmpty() { // O(1)
        return size == 0;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                '}';
    }


}
