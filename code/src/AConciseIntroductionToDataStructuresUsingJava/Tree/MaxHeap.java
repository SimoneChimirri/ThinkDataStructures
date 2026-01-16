package AConciseIntroductionToDataStructuresUsingJava.Tree;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<E extends Comparable<? super E>> extends Heap<E>{

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity){
        data = (E[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    @Override
    public void add(E item) {
        if(size == capacity) resize(capacity*2);
        data[size] = item;
        size++;
        heapifyUpIterative(size() -1);
    }

    private void heapifyUp(int index) { //O(n)
        if(!isValid(index) || !isValid(parent(index))) return;
        if(isHigher(index,parent(index))){
            swap(index,parent(index));
            heapifyUp(parent(index));
        }
    }

    private void heapifyUpIterative(int index){ //O(n)
        if(!isValid(index) || !isValid(parent(index))) return;
        while(isHigher(index,parent(index))){
            swap(index,parent(index));
            index = parent(index);
            if(!isValid(parent(index))) return;
        }
    }

    @Override
    public E remove() {
        if(isEmpty()) throw new NoSuchElementException();
        swap(0,size()-1);
        E itemRemoved = data[size()-1];
        data[size()-1] = null;
        size--;
        if(size <= capacity/4 && capacity >= 20) resize(capacity/2);
        heapifyDown(0);
        return itemRemoved;
    }

    private void heapifyDown(int index){ //O(log n)
        if(!isValid(index) || (!isValid(left(index)) && !isValid(right(index)))) return;
        if (isValid(left(index)) && isValid(right(index))) {
            if (isHigher(left(index), right(index))){
                if(isHigher(left(index), index)) {
                    swap(index, left(index));
                    index = left(index);
                    heapifyDown(index);
                }
            }else {
                if (isHigher(right(index), index)) {
                    swap(index, right(index));
                    index = right(index);
                    heapifyDown(index);
                }
            }
        } else if (isValid(left(index)) && isHigher(left(index), index)) {
            swap(index, left(index));
            index = left(index);
            heapifyDown(index);
        } else if (isValid(right(index)) && isHigher(right(index), index)) {
            swap(index, right(index));
            index = right(index);
            heapifyDown(index);
        }
    }

    private void heapifyDownIterative(int index){
        if(!isValid(index) || (!isValid(left(index)) && !isValid(right(index)))) return;
        boolean swap = true;
        while(swap) {
            if (isValid(left(index)) && isValid(right(index))) {
                if (isHigher(left(index), right(index))){
                    if(isHigher(left(index), index)) {
                        swap(index, left(index));
                        index = left(index);
                    }else swap = false;
                }else {
                    if (isHigher(right(index), index)) {
                        swap(index, right(index));
                        index = right(index);
                    } else swap = false;
                }
            } else if (isValid(left(index)) && isHigher(left(index), index)) {
                swap(index, left(index));
                index = left(index);
                if (!isValid(index)) break;
            } else if (isValid(right(index)) && isHigher(right(index), index)) {
                swap(index, right(index));
                index = right(index);
                if (!isValid(index)) break;
            } else break;
        }
    }

    @Override
    protected boolean isHigher(int i, int j) {
        return isLarger(i, j);
    }

    private boolean isLarger(int i, int j){
        return data[i].compareTo(data[j]) > 0;
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
        System.out.println(pqa.peek());
        pqa.add(3);
        System.out.println(pqa.remove());
        pqa.add(10);
        System.out.println(pqa.size());
        pqa.add(4);
        System.out.println(pqa.remove());
        System.out.println(pqa.remove());

        MaxHeap<Integer> pqb = new MaxHeap<>();
        pqb.add(10);
        pqb.add(20);
        pqb.add(30);
        pqb.add(40);
        System.out.println(pqb.peek());
        pqb.add(50);
        System.out.println(pqb.remove());
        System.out.println(pqb.size());
        System.out.println(pqb.remove());
        System.out.println(pqb.remove());
        
        MaxHeap<Integer> pqc = new MaxHeap<>(20);
        pqc.add(37);
        pqc.add(17);
        pqc.add(81);
        pqc.add(74);
        pqc.add(95);
        pqc.add(52);
        pqc.add(8);
        pqc.add(83);
        pqc.add(41);
        System.out.println(pqc);

        MaxHeap<Integer> pqd = new MaxHeap<>(20);
        pqd.add(62);
        pqd.add(13);
        pqd.add(66);
        pqd.add(36);
        pqd.add(69);
        pqd.add(70);
        pqd.add(39);
        pqd.add(95);
        pqd.add(51);
        System.out.println(pqd.remove());
        System.out.println(pqd.remove());
        System.out.println(pqd.remove());
        System.out.println(pqd);

        MaxHeap<Integer> pqe = new MaxHeap<>(20);
        pqe.add(46);
        pqe.add(78);
        pqe.add(96);
        pqe.add(74);
        pqe.add(60);
        pqe.add(99);
        pqe.add(23);
        pqe.add(29);
        pqe.add(5);
        System.out.println(pqe.remove());
        System.out.println(pqe.remove());
        System.out.println(pqe.remove());
        System.out.println(pqe);

        MaxHeap<Integer> pqf = new MaxHeap<>(20);
        pqf.add(40);
        pqf.add(60);
        pqf.add(57);
        pqf.add(82);
        pqf.add(55);
        pqf.add(4);
        pqf.add(6);
        pqf.add(97);
        pqf.add(59);
        System.out.println(pqf.remove());
        System.out.println(pqf.remove());
        System.out.println(pqf.remove());
        System.out.println(pqf);
        while(!pqf.isEmpty()) System.out.println(pqf.remove());
        System.out.println(pqf);

    }
}
