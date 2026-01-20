package AConciseIntroductionToDataStructuresUsingJava.MapHashTable;

public class LinkedMap<K,V> implements Map<K, V> {

    private Node<Entry<K,V>> head;
    private int size = 0;

    public LinkedMap() {
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private Node(T item){
            this.data = item;
            this.next = null;
        }

        private Node() {
        }
    }

    private static class Entry<T,U>{
        private T key;
        private U value;

        public Entry(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    @Override
    public V put(K key, V value) { // O(n)
        if(isEmpty()){
            head = new Node<>(new Entry<>(key,value));
            size++;
        }
        else if(!containsKey(key)){
            head.next = new Node<>(new Entry<>(key,value),head.next);
            size++;
        } else{
            Node<Entry<K,V>> current = head;
            while(current != null){
                if(current.data.key.equals(key)){
                    V oldValue = current.data.value;
                    current.data.value = value;
                    return oldValue;
                }
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        if(isEmpty()) return null;
        if(!containsKey(key)) return null;
        if(head.data.key.equals(key)){
            V oldValue = head.data.value;
            head = head.next;
            size--;
            return oldValue;
        }
        Node<Entry<K,V>> current = head;
        while(current.next != null){
            if(current.next.data.key.equals(key)){
                V oldValue = current.next.data.value;
                current.next = current.next.next;
                current.next.next = null;
                size--;
                return oldValue;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() { // O(1)
        return this.size;
    }

    @Override
    public boolean containsKey(K key) { // O(n)
        Node<Entry<K,V>> current = head;
        while(current != null){
            if(current.data.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public V get(K key) { // O(n)
        if(isEmpty()) return null;
        if(!containsKey(key)) return null;
        Node<Entry<K,V>> current = head;
        while(current != null){
            if(current.data.key.equals(key)){
                return current.data.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() { // O(1)
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Node<Entry<K,V>> current = head;
        while(current != null){
            sb.append(current.data.key).append("=").append(current.data.value);
            if(current.next != null){
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Integer,String> m = new LinkedMap<>();
        Map<Integer,String> m1 = new LinkedMap<>();

        System.out.println(m.put(5,"five"));
        System.out.println(m.put(3, "three"));
        System.out.println(m.containsKey(2));
        System.out.println(m.put(5,"FIVE"));
        System.out.println(m.put(2,"two"));
        System.out.println(m.get(5));
        System.out.println(m.put(1,"one"));
        System.out.println(m.size());
        System.out.println(m);

        System.out.println(m1.put(1,"one"));
        System.out.println(m1.put(2,"two"));
        System.out.println(m1.put(2,"Two"));
        System.out.println(m1.put(2,"TWO"));
        System.out.println(m1.containsKey(2));
        System.out.println(m1.put(3,"three"));
        System.out.println(m1.get(2));
        System.out.println(m1.size());
        System.out.println(m1);

        System.out.println("Java".hashCode());
        System.out.println("table".hashCode());
        System.out.println("data".hashCode());
        System.out.println("Data".hashCode());

        int studentId = 2087;
        String departmentName = "Economy";
        int courseNumber = 76;
        int hashCode6 = studentId * 19;
        for(int i=departmentName.length() - 1; i >= 0; i--){
            hashCode6 += (int) (departmentName.charAt(i) * Math.pow(31,i));
        }
        hashCode6 += courseNumber * 37;
        System.out.println(hashCode6);

        int day = 29;
        int month = 11;
        int year = 2009;
        int hashCode7 = day * 31 + month * 87 + year * (int) Math.pow(31,2);
        System.out.println(hashCode7);

        System.out.println(hashCode6 & Integer.MAX_VALUE);
        System.out.println(hashCode7 & Integer.MAX_VALUE);
        System.out.println(-1786546 & Integer.MAX_VALUE);
        System.out.println(Math.abs(hashCode6));
        System.out.println(Math.abs(hashCode7));
        System.out.println(Math.abs(-1786546));
        System.out.println(Math.abs(Integer.MAX_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE));//this value does not have a correspondent positive value
                                                        //in the Integer range of values, so it returns a negative value,
                                                        //itself.
        System.out.println(Math.abs(Integer.MIN_VALUE+1));
    }

}
