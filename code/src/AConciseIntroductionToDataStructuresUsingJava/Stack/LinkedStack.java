package AConciseIntroductionToDataStructuresUsingJava.Stack;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Linked1;

import java.util.EmptyStackException;

public class LinkedStack<E> extends Linked1<E> implements Stack<E> {
   private Node<E> top;
   private int size = 0;

   // use E here
   
   private static class Node<T> {
      private T data;
      private Node<T> next;

      private Node(T data, Node<T> next) {
         this.data = data;
         this.next = next;
      }
   }

   @Override
   public boolean isEmpty() {
      return top == null;
   }

   @Override
   public E peek() {
      if (isEmpty()) throw new EmptyStackException();
      return top.data;
   }

   @Override
   public E pop() {
      if (isEmpty()) throw new EmptyStackException();
      size --;
      E item = top.data;
      top = top.next;
      return item;
   }

   @Override
   public void push(E item) {
      top = new Node<>(item, top);
      size++;
   }

   @Override
   public int size() {
      return size;
   }

   public static void main(String[] args) {
      Stack<String> s = new LinkedStack<>();
      s.push("Java");
      s.push("Python");
      s.push("C++");
      System.out.println(s.pop());
      System.out.println(s.peek());
      System.out.println(s.size());
      Stack<Double> ds = new LinkedStack<>();
      ds.push(3.14);
      ds.push(2.72);
      System.out.println(ds.pop());
      System.out.println(ds.peek());
      System.out.println(ds.size());
      Stack<Integer> js = new LinkedStack<>();
      js.push(34);
      js.push(56);
      System.out.println(js.pop());
      System.out.println(js.peek());
      System.out.println(js.size());
   }
   
}