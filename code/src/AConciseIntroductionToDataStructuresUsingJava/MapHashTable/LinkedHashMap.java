package AConciseIntroductionToDataStructuresUsingJava.MapHashTable;

import AConciseIntroductionToDataStructuresUsingJava.Stack.Node;

import java.util.Arrays;

public class LinkedHashMap<K,V> implements Map<K,V> {
    private LinkedMap<K,V>[] table;
    private static final int M = 2048;
    private int dimension;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public LinkedHashMap() {
        this(M);
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap(int m) {
        table = (LinkedMap<K, V>[]) new LinkedMap[m];
        dimension = m;
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

    public V put(K key,V value){
        V oldValue = null;
        if(table[hash(key)] == null) table[hash(key)] = new LinkedMap<>();
        LinkedMap<K,V> hashMap = table[hash(key)];
        if(hashMap != null && hashMap.containsKey(key)) oldValue = hashMap.get(key);
        if (hashMap != null) {
            hashMap.put(key,value);
            size++;
        }
        return oldValue;
    }

    @Override
    public boolean containsKey(K key) {
        if(table[hash(key)] == null) return false;
        else{
            LinkedMap<K,V> hashMap = table[hash(key)];
            return hashMap.containsKey(key);
        }
    }

    public V get(K key){
        LinkedMap<K,V> hashMap = table[hash(key)];
        if(hashMap != null && hashMap.containsKey(key)) return hashMap.get(key);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public V remove(K key){ //O(1+lambda, with lambda = size/dimension)
        V oldValue = null;
        if(table[hash(key)] == null) return null;
        LinkedMap<K,V> hashMap = table[hash(key)];
        if(hashMap != null && hashMap.containsKey(key)) oldValue = hashMap.get(key);
        hashMap.remove(key);
        size--;
        return oldValue;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int hash(K key){
        if(key.getClass().equals(Integer.class)) return (int)key%dimension;
        else return key.hashCode();
    }

    @Override
    public String toString() {
        return "LinkedHashMap{" +
                "table=" + Arrays.toString(table) +
                ", dimension=" + dimension +
                '}';
    }

    public static void main(String[] args){
        LinkedHashMap<Integer,Integer> m1 = new LinkedHashMap<>(11);
        LinkedHashMap<Integer,Integer> m2 = new LinkedHashMap<>(13);

        System.out.println(m1.put(59,59));
        System.out.println(m1.put(35,35));
        System.out.println(m1.put(73,73));
        System.out.println(m1.put(10,10));
        System.out.println(m1.put(39,39));
        System.out.println(m1.put(83,83));
        System.out.println(m1.put(46,46));
        System.out.println(m1.put(72,72));
        System.out.println(m1.put(34,34));
        System.out.println(m1.put(54,54));
        System.out.println(m1);
        m1.remove(59);
        m1.remove(35);
        m1.remove(73);
        m1.remove(10);
        m1.remove(39);
        m1.remove(83);
        m1.remove(46);
        m1.remove(72);
        m1.remove(34);
        m1.remove(54);

        System.out.println(m1.put(70,70));
        System.out.println(m1.put(8,8));
        System.out.println(m1.put(52,52));
        System.out.println(m1.put(95,95));
        System.out.println(m1.put(33,33));
        System.out.println(m1.put(99,99));
        System.out.println(m1.put(96,96));
        System.out.println(m1.put(44,44));
        System.out.println(m1.put(20,20));
        System.out.println(m1.put(18,18));
        System.out.println(m1);
        m1.remove(70);
        m1.remove(8);
        m1.remove(52);
        m1.remove(95);
        m1.remove(33);
        m1.remove(99);
        m1.remove(96);
        m1.remove(44);
        m1.remove(20);
        m1.remove(18);

        System.out.println(m1.put(28,28));
        System.out.println(m1.put(32,32));
        System.out.println(m1.put(13,13));
        System.out.println(m1.put(78,78));
        System.out.println(m1.put(86,86));
        System.out.println(m1.put(98,98));
        System.out.println(m1.put(20,20));
        System.out.println(m1.put(57,57));
        System.out.println(m1.put(68,68));
        System.out.println(m1.put(83,83));
        System.out.println(m1);
        m1.remove(28);
        m1.remove(32);
        m1.remove(13);
        m1.remove(78);
        m1.remove(86);
        m1.remove(98);
        m1.remove(20);
        m1.remove(57);
        m1.remove(68);
        m1.remove(83);

        System.out.println(m1.put(47,47));
        System.out.println(m1.put(69,69));
        System.out.println(m1.put(67,67));
        System.out.println(m1.put(13,13));
        System.out.println(m1.put(20,20));
        System.out.println(m1.put(26,26));
        System.out.println(m1.put(34,34));
        System.out.println(m1.put(41,41));
        System.out.println(m1.put(56,56));
        System.out.println(m1.put(63,63));
        System.out.println(m1);


        System.out.println(m2.put(59,59));
        System.out.println(m2.put(35,35));
        System.out.println(m2.put(73,73));
        System.out.println(m2.put(10,10));
        System.out.println(m2.put(39,39));
        System.out.println(m2.put(83,83));
        System.out.println(m2.put(46,46));
        System.out.println(m2.put(72,72));
        System.out.println(m2.put(34,34));
        System.out.println(m2.put(54,54));
        System.out.println(m2);
        m2.remove(59);
        m2.remove(35);
        m2.remove(73);
        m2.remove(10);
        m2.remove(39);
        m2.remove(83);
        m2.remove(46);
        m2.remove(72);
        m2.remove(34);
        m2.remove(54);

        System.out.println(m2.put(70,70));
        System.out.println(m2.put(8,8));
        System.out.println(m2.put(52,52));
        System.out.println(m2.put(95,95));
        System.out.println(m2.put(33,33));
        System.out.println(m2.put(99,99));
        System.out.println(m2.put(96,96));
        System.out.println(m2.put(44,44));
        System.out.println(m2.put(20,20));
        System.out.println(m2.put(18,18));
        System.out.println(m2);
        m2.remove(70);
        m2.remove(8);
        m2.remove(52);
        m2.remove(95);
        m2.remove(33);
        m2.remove(99);
        m2.remove(96);
        m2.remove(44);
        m2.remove(20);
        m2.remove(18);

        System.out.println(m2.put(28,28));
        System.out.println(m2.put(32,32));
        System.out.println(m2.put(13,13));
        System.out.println(m2.put(78,78));
        System.out.println(m2.put(86,86));
        System.out.println(m2.put(98,98));
        System.out.println(m2.put(20,20));
        System.out.println(m2.put(57,57));
        System.out.println(m2.put(68,68));
        System.out.println(m2.put(83,83));
        System.out.println(m2);
        m2.remove(28);
        m2.remove(32);
        m2.remove(13);
        m2.remove(78);
        m2.remove(86);
        m2.remove(98);
        m2.remove(20);
        m2.remove(57);
        m2.remove(68);
        m2.remove(83);

        System.out.println(m2.put(47,47));
        System.out.println(m2.put(69,69));
        System.out.println(m2.put(67,67));
        System.out.println(m2.put(13,13));
        System.out.println(m2.put(20,20));
        System.out.println(m2.put(26,26));
        System.out.println(m2.put(34,34));
        System.out.println(m2.put(41,41));
        System.out.println(m2.put(56,56));
        System.out.println(m2.put(63,63));
        System.out.println(m2);
        System.out.println(m2.get(69));
        System.out.println(m2.get(26));
        System.out.println(m2.get(0));
        System.out.println(m2.get(17));




    }
}
