import java.util.EmptyStackException;

public class IntArrayStack implements IntStack {
   private int top = -1;
   private int[] data;
   private static final int DEFAULT_CAPACITY = 10;
   
   public IntArrayStack() {
      data = new int[DEFAULT_CAPACITY];
   }
   
   public void push(int item) {
      if (top == data.length - 1) resize(2 * data.length);
      data[++top] = item;
   }
   
   public int pop() {
      if (isEmpty()) throw new EmptyStackException();
      return data[top--];
   }
   
   private void resize(int newCapacity) {
      int[] newData = new int[newCapacity];
      for (int i = 0; i <= top; i++) {
         newData[i] = data[i];
      }
      data = newData;
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
      System.out.println(s.peek());
      while(!s.isEmpty()) {
         System.out.println(s.pop());
      }
   }

   @Override
   public boolean isEmpty() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
   }

   @Override
   public int peek() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'peek'");
   }

   @Override
   public int size() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'size'");
   }
}