package AConciseIntroductionToDataStructuresUsingJava.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue1<E> implements Queue1<E> {

    protected int size = 0;
    protected int capacity;
    protected E[] data;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue1() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue1(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) { // complexity-time constant - O(1)
        //if (size() == capacity) resize(capacity * 2);
        data[size()] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        System.out.println("The array has been resized to capacity: " + newCapacity);
        capacity = newCapacity;
        data = newData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() { // complexity-time linear - O(n)
        if(isEmpty()){
            data = null;
            throw new NoSuchElementException();
        } else{
            E[] newData = (E[]) new Object[capacity];
            for(int i=0; i < size(); i++){
                int j = (i + 1) % capacity;
                newData[i] = data[j];
            }
            E first = data[0];
            data = newData;
            size--;
            return first;
        }
    }

    @Override
    public int size() { // complexity-time constant - O(1)
        return this.size;
    }

    @Override
    public E peek() { // complexity-time constant - O(1)
        if(isEmpty()) throw new NoSuchElementException();
        return data[0];
    }

    @Override
    public boolean isEmpty() { // complexity-time constant - O(1)
        return size() == 0;
    }

    public static void main(String[] args) {
        Queue1<Integer> i = new ArrayQueue1<>();
        Queue1<Double> d = new ArrayQueue1<>();
        Queue1<String> s = new ArrayQueue1<>();
        i.enqueue(5);
        i.enqueue(8);
        System.out.println(i.peek());
        i.enqueue(3);
        System.out.println(i.dequeue());
        i.enqueue(10);
        System.out.println(i.size());
        i.enqueue(3);
        System.out.println(i.dequeue());
        System.out.println(i.dequeue());

        d.enqueue(1.0);
        d.enqueue(2.0);
        d.enqueue(3.0);
        d.enqueue(4.0);
        System.out.println(d.peek());
        d.enqueue(5.0);
        System.out.println(d.dequeue());
        System.out.println(d.size());
        System.out.println(d.dequeue());
        System.out.println(d.dequeue());

        s.enqueue("Java");
        System.out.println(s.dequeue());
        s.enqueue("SQL");
        System.out.println(s.dequeue());
        s.enqueue("Oracle");
        System.out.println(s.dequeue());
        System.out.println(s.size());
        s.enqueue("Javascript");
        System.out.println(s.peek());
        System.out.println(s.dequeue());
    }
    
}
