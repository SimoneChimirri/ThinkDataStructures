package AConciseIntroductionToDataStructuresUsingJava.Stack;

import java.util.EmptyStackException;

//Listing 3.2
public class IntArrayStack implements IntStack {
   private int size = 0;
   private int[] data;
   private static final int DEFAULT_CAPACITY = 10;
   
   public IntArrayStack() {
      this(DEFAULT_CAPACITY);
   }

   public IntArrayStack(int capacity){
      data = new int[capacity];
   }
   
   @Override
   public void push(int item) {
      if (size == data.length) resize(2 * data.length);
      size = size + 1;
      data[size - 1] = item;
   }
   
   @Override
   public int pop() {
      if (isEmpty()) throw new EmptyStackException();
      if(size() <= data.length/4 && data.length >= 20) resize(data.length / 2);
      size = size -1;
      return data[size];
   }
   
   private void resize(int newCapacity) {
      int[] newData = new int[newCapacity];
      for (int i = 0; i < size; i++) {
         newData[i] = data[i];
      }
      System.out.println("The array has been resized to capacity: " + newCapacity);
      data = newData;
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   @Override
   public int peek() {
      if(isEmpty()) throw new EmptyStackException();
      return data[size - 1];
   }

   @Override
   public int size() {
      return size;
   }
   
   public static void main(String[] args) {
      IntStack s = new IntArrayStack();
      s.push(5);
      s.push(8);
      System.out.println(s.peek());
      s.push(3);
      System.out.println(s.pop());
      s.push(10);
      System.out.println(s.size());
      s.push(4);
      System.out.println(s.pop());
      System.out.println(s.pop());
      System.out.println(s.isEmpty());
      IntStack s1 = new IntArrayStack();
      s1.push(1);
      System.out.println(s1.pop());
      s1.push(2);
      System.out.println(s1.peek());
      System.out.println(s1.pop());
      s1.push(3);
      System.out.println(s1.size());
      System.out.println(s1.pop());
      s1.push(4);
      System.out.println(s1.pop());
      System.out.println(s1.isEmpty());
      IntStack s2 = new IntArrayStack();
      s2.push(10);
      s2.push(20);
      s2.push(30);
      System.out.println(s2.peek());
      s2.push(40);
      s2.push(50);
      System.out.println(s2.size());
      System.out.println(s2.pop());
      System.out.println(s2.pop());
      System.out.println(s2.pop());
      System.out.println(s2.isEmpty());

      for (int i = 0; i < 5; i++) {
         s.push(i);
      }
      IntStack s3 = new IntLinkedStack();
      IntStack t = new IntArrayStack();

      while(!s.isEmpty()) {
         s.pop();
      }
      s.push(100);
      System.out.println(s.pop());
      //System.out.println(s.peek()); EmptyStackException
      while(!s.isEmpty()) {
         System.out.println(s.pop());
      }
      System.out.println(s.size());
      for (int i = 10; i < 50; i+=10) {
         s.push(i);
      }

      IntStack operands = new IntArrayStack();
      operands.isEmpty();
      operands.push(17);
      operands.push(0);
      operands.push(-12);
      operands.push(101);

      for(int i=50; i < 360; i+=10){
         s.push(i);
      }
      System.out.println(s.size());
      System.out.println(s.isEmpty());

      for(int i=10; i < 360; i+=10){
         s.pop();
      }
      System.out.println(s.size());
      System.out.println(s.isEmpty());
   }
}