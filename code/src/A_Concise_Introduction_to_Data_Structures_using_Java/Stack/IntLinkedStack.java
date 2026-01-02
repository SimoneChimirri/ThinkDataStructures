public class IntLinkedStack implements IntStack {
   private Node top;
   
   public void push(int item) {
      top = new Node(item, top);
   }
   
   public int pop() {
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