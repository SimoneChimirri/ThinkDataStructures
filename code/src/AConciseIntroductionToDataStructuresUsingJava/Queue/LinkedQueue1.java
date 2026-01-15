package AConciseIntroductionToDataStructuresUsingJava.Queue;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Linked1;

import java.util.NoSuchElementException;

public class LinkedQueue1<E> extends Linked1<E> implements Queue1<E>{

    private int size = 0;
    private Node<E> front = head;
    private Node<E> rear = new Node<>();



    @Override
    public void enqueue(E e) { // O(1) - no loops
        Node<E> add = new Node<>(e);
        if(isEmpty()){
            front = add;
            rear = add;
        }else {
            rear.next = add;
        }
        size ++;
        rear = add;
    }

    @Override
    public E dequeue() { // O(1) - no loops
        if(isEmpty()) throw new NoSuchElementException();
        size --;
        E frontValue = front.data;
        Node<E> temp = front.next;
        front.next = null;
        front = temp;
        return frontValue;
    }

    @Override
    public int size() { // O(1) - no loops
        return this.size;
    }

    @Override
    public E peek() { // O(1) - no loops
        if(isEmpty()) throw new NoSuchElementException();
        return front.data;
    }

    @Override
    public boolean isEmpty() { // O(1) - no loops
        return size == 0;
    }

    public static void main(String[] args){
        Queue1<Integer> intLinkedQueue = new LinkedQueue1<>();
        Queue1<Integer> intLinkedQueue1 = new LinkedQueue1<>();
        Queue1<Double> doubleLinkedQueue = new LinkedQueue1<>();
        Queue1<String> stringLinkedQueue = new LinkedQueue1<>();
        intLinkedQueue.enqueue(5);
        intLinkedQueue.enqueue(8);
        System.out.println(intLinkedQueue.peek());
        intLinkedQueue.enqueue(3);
        System.out.println(intLinkedQueue.dequeue());
        intLinkedQueue.enqueue(10);
        System.out.println(intLinkedQueue.size());
        intLinkedQueue.enqueue(3);
        System.out.println(intLinkedQueue.dequeue());
        System.out.println(intLinkedQueue.dequeue());

        intLinkedQueue1.enqueue(1);
        System.out.println(intLinkedQueue1.dequeue());
        intLinkedQueue1.enqueue(2);
        System.out.println(intLinkedQueue1.dequeue());
        intLinkedQueue1.enqueue(3);
        System.out.println(intLinkedQueue1.dequeue());
        System.out.println(intLinkedQueue1.size());
        intLinkedQueue1.enqueue(4);
        System.out.println(intLinkedQueue1.peek());
        System.out.println(intLinkedQueue1.dequeue());

        doubleLinkedQueue.enqueue(1.0);
        doubleLinkedQueue.enqueue(2.0);
        doubleLinkedQueue.enqueue(3.0);
        doubleLinkedQueue.enqueue(4.0);
        System.out.println(doubleLinkedQueue.peek());
        doubleLinkedQueue.enqueue(5.0);
        System.out.println(doubleLinkedQueue.dequeue());
        System.out.println(doubleLinkedQueue.size());
        System.out.println(doubleLinkedQueue.dequeue());
        System.out.println(doubleLinkedQueue.dequeue());

        stringLinkedQueue.enqueue("Java");
        System.out.println(stringLinkedQueue.dequeue());
        stringLinkedQueue.enqueue("SQL");
        System.out.println(stringLinkedQueue.dequeue());
        stringLinkedQueue.enqueue("Oracle");
        System.out.println(stringLinkedQueue.dequeue());
        System.out.println(stringLinkedQueue.size());
        stringLinkedQueue.enqueue("Javascript");
        System.out.println(stringLinkedQueue.peek());
        System.out.println(stringLinkedQueue.dequeue());
    }







}
