package AConciseIntroductionToDataStructuresUsingJava.Tree;

import AConciseIntroductionToDataStructuresUsingJava.List.LinkedList;

public abstract class Linked1<E> {
    protected static class Node<T> {

        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T item){
            this.data = item;
            this.next = null;
            this.prev = null;
        }

        public Node() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }
    }
    protected Node<E> head = new Node<>();
}
