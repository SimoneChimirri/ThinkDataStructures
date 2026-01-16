package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Arrays;

public class MinHeap<E extends Comparable<? super E>> extends Heap<E>{

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity){
        data = (E[]) new Comparable[capacity];
    }

    @Override
    protected boolean isHigher(int i,int j){
        return isSmaller(i,j);
    }

    private boolean isSmaller(int i, int j){
        return data[i].compareTo(data[j]) < 0;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args){
        MinHeap<Integer> pqa = new MinHeap<>();
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

        MinHeap<Integer> pqb = new MinHeap<>();
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
