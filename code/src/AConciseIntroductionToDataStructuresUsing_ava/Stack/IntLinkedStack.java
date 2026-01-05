import java.util.EmptyStackException;

//Listing 3.4
public class IntLinkedStack implements IntStack {
   private Node top;
   private int size = 0;
   
   @Override
   public void push(int item) {
      top = new Node(item, top);
      size ++;
   }
   
   @Override
   public int pop() {
      if(isEmpty()) throw new EmptyStackException();
      size --;
      int result = top.data;
      top = top.next;
      return result;
   }
   
   private static class Node {
      private int data;
      private Node next;
      
      private Node(int data, Node next) {
         this.data = data;
         this.next = next;
      }
   }

   @Override
   public boolean isEmpty() {
      return top == null;
   }

   @Override
   public int peek() {
      if(isEmpty()) throw new EmptyStackException();
      return top.data;
   }

   @Override
   public int size() {
      return this.size;
   }

   public static void main(String[] args) {
      IntStack s = new IntLinkedStack();
      s.push(5);
      s.push(10);
      s.push(4);
      s.push(8);

      Node head = new Node(1, null);
      head = new Node(2, head);
      head = new Node(3, head);

      Node listNode = new Node(7, null);
      listNode = new Node(4, listNode);
      listNode = new Node(18, listNode);

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
      IntStack s1 = new IntLinkedStack();
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
      IntStack s2 = new IntLinkedStack();
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

      IntStack operands = new IntLinkedStack();
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