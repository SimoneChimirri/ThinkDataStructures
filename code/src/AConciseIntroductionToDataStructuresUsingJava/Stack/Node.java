package AConciseIntroductionToDataStructuresUsingJava.Stack;// Listing 3.3
/*public class Node {
   private int data;
   private Node next;
   
   public Node(int data, Node next) {
      this.data = data;
      this.next = next;
   }
}*/


//Generic version for Listing 4.1

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
    }

   public static void main(String[] args) {
      Node<Integer> p = new Node<>(34, null);
      Node<String> q = new Node<>("Java", null);
      Node<Double> doubles = new Node<>(3.14, null);
      Node<Double> moreDoubles = new Node<>(2.72, doubles);
      Node<Double> evenMoreDoubles = new Node<>(0.58, moreDoubles);
      
   }
}