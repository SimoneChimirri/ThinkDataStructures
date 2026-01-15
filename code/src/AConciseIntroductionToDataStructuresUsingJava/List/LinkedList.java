package AConciseIntroductionToDataStructuresUsingJava.List;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Linked1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends Linked1<E> implements List1<E>{
    //private Node<E> next = new Node<>(null, null, head);
    private int size = 0;

    @Override
    public void add(E item) { // complexity-time is linear - O(n)
        add(size(), item);
    }

    @Override
    public void add(int index, E item) { // complexity-time is linear - O(n)
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Node<E> prev = getNode(index-1);
        Node<E> p = new Node<>(item, null, prev);
        if(p.prev.next != null) p.next = prev.next;
        if(size() == 0 || index == 0) head.next = p;
        size++;
    }

    @Override
    public E removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<E> p = getNode(index);
        E result = p.data;
        if (p.next != null){
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
        size--;
        return result;
    }

    @Override
    public E get(int index) { // complexity-time is linear - O(n)
        if(index <0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> p = head;
        for (int i = -1; i < index; i++) {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public E set(int index, E item) { // complexity-time is linear - O(n)
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> p = head;
        for(int i = -1; i < index; i++){
            p = p.next;
        }
        E oldValue = p.data;
        p.data = item;
        return oldValue;
    }

    @Override
    public int indexOf(E item) { // complexity-time is linear - O(n)
        Node<E> p = head;
        for(int i=-1; i < size(); i++){
            if(p.data != null && p.data.equals(item)) return i;
            p = p.next;
        }
        return -1;
    }

    @Override
    public int size() { // complexity-time is constant - O(1)
        return this.size;
    }

    @Override
    public boolean isEmpty() { // complexity-time is constant - O(1)
        return size() == 0;
    }

    private Node<E> getNode(int index) {
        // assumes -1 <= index < size.  -1 is dummy.
        Node<E> p = head;
        for (int i = -1; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator<>();
    }

    // For LinkedList class, Listing 6.3
    @SuppressWarnings("unchecked")
    private class LinkedListIterator<P> implements Iterator<P> {
        private Node<P> next = (Node<P>) head.next;// skip dummy

        public boolean hasNext() {
            return next != null;
        }

        public P next() {
            if (!hasNext()) throw new NoSuchElementException();
            P result = next.data;
            next = next.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public P removeAt(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException();
            Node<P> p = getNode(index);
            P result = p.data;
            p.prev.next = next;
            if (next != null) p.next.prev = p.prev;
            size--;
            return result;
        }

        private Node<P> getNode(int index) {
            // assumes -1 <= index < size.  -1 is dummy.
            Node<P> p = (Node<P>) head;
            for (int i = -1; i < index; i++) {
                p = p.next;
            }
            return p;
        }

        public static void main(String[] args) {
            //for(Node<T> p = head; p != null; p = p.next)
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Node<E> p = head.next; p != null; p = p.next){
            builder.append(p.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args){
        LinkedList<Integer> integerLinked = new LinkedList<>();
        LinkedList<Double> doubleLinked = new LinkedList<>();
        LinkedList<String> stringLinked = new LinkedList<>();

        integerLinked.add(5);
        integerLinked.add(0,7);
        System.out.println(integerLinked.get(0));
        System.out.println(integerLinked.get(1));
        System.out.println(integerLinked.set(0, 9));
        System.out.println(integerLinked.set(1,8));
        System.out.println(integerLinked.size());
        System.out.println(integerLinked.removeAt(0));
        System.out.println(integerLinked.indexOf(9));
        System.out.println(integerLinked.indexOf(8));
        System.out.println(integerLinked.isEmpty());
        System.out.println("The Integer list is:");
        System.out.println(integerLinked);

        doubleLinked.add(5.0);
        doubleLinked.add(0,7.0);
        System.out.println(doubleLinked.get(0));
        System.out.println(doubleLinked.get(1));
        System.out.println(doubleLinked.set(0, 9.0));
        System.out.println(doubleLinked.set(1,8.0));
        System.out.println(doubleLinked.size());
        System.out.println(doubleLinked.removeAt(0));
        System.out.println(doubleLinked.indexOf(9.0));
        System.out.println(doubleLinked.indexOf(8.0));
        System.out.println(doubleLinked.isEmpty());
        System.out.println("The Double list is:");
        System.out.println(doubleLinked);

        stringLinked.add("s");
        stringLinked.add(0,"b");
        System.out.println(stringLinked.get(0));
        System.out.println(stringLinked.get(1));
        System.out.println(stringLinked.set(0, "c"));
        System.out.println(stringLinked.set(1,"u"));
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.removeAt(0));
        System.out.println(stringLinked.indexOf("c"));
        System.out.println(stringLinked.indexOf("u"));
        System.out.println(stringLinked.isEmpty());
        System.out.println("The String list is:");
        System.out.println(stringLinked);

        LinkedList<Integer> items = new LinkedList<>();
        Iterator<Integer> it = items.iterator();
        while(it.hasNext()) System.out.println(it.next());
        for (Integer item : items) System.out.println(item);

        Iterator<String> str = stringLinked.iterator();
        while(str.hasNext()) System.out.println(str.next());
        for (String s : stringLinked) System.out.println(s);
    }
}
