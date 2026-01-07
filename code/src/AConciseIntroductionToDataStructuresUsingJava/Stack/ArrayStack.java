package AConciseIntroductionToDataStructuresUsingJava.Stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
   private E[] data;
   private int size;
   private static final int DEFAULT_CAPACITY = 10;
    
   public ArrayStack() {
      this(DEFAULT_CAPACITY);
   }

   @SuppressWarnings("unchecked")
  public ArrayStack(int capacity) {
      data = (E[]) new Object[capacity];
   }
   
   @Override
   public E pop() {
    if (isEmpty()) throw new EmptyStackException();
    if (data.length >= 20 && size <= data.length / 4) resize(data.length / 2);
    size = size - 1;
    return data[size];
   }

   @Override
    public boolean isEmpty() {
      return size == 0;
    }

    @Override
    public E peek() {
      return data[size - 1];
    }

    @Override
    public void push(E item) {
      if (size == data.length) resize(2 * data.length);
      size = size + 1;
      data[size - 1] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
      E[] newData = (E[]) new Object[newCapacity];
      System.arraycopy(data, 0, newData, 0, size);
      System.out.println("The array has been resized to capacity: " + newCapacity);
      data = newData;
    }

    public static void main(String[] args) {
        
        Stack<String> operators = new ArrayStack<>();
        Stack<Integer> operands = new ArrayStack<>();
        Stack<Integer> s = new ArrayStack<>();
        for (int i = 0; i < 9; i++) {
            s.push(i);
        }
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        Stack<Double> d = new ArrayStack<>();
        for (int i = 0; i < 25; i++) {
            d.push((double) i);
        }
        System.out.println(d.size());
        System.out.println(d.pop());
        System.out.println(d.size());
        System.out.println(d.peek());
        for (int i = 0; i < 22; i++) {
            operators.push("Java"+i);
        }
        System.out.println(operators.size());
        System.out.println(operators.pop());
        System.out.println(operators.size());
        System.out.println(operators.peek());

    }

}