package AConciseIntroductionToDataStructuresUsingJava.MapHashTable;

import java.util.Arrays;

public class LinkedHashMap<K,V> {
    private LinkedMap<K,V>[] table;
    private static final int M = 2048;
    private int dimension;

    @SuppressWarnings("unchecked")
    public LinkedHashMap() {
        this(M);
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap(int m) {
        table = (LinkedMap<K, V>[]) new LinkedMap[m];
        dimension = m;
    }

    public V put(K key,V value){
        V oldValue = null;
        LinkedMap<K,V> hashMap = table[(int)key%dimension];
        if(hashMap.containsKey(key)) oldValue = hashMap.get(key);
        table[(int)key%dimension].put(key,value);
        return oldValue;
    }

    public V get(K key){
        LinkedMap<K,V> hashMap = table[(int)key%dimension];
        if(hashMap.containsKey(key)) return hashMap.get(key);
        return null;
    }

    public V remove(K key){
        V oldValue = null;
        LinkedMap<K,V> hashMap = table[(int)key%dimension];
        if(hashMap.containsKey(key)) oldValue = hashMap.get(key);
        hashMap.remove(key);
        return oldValue;
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

        System.out.println(m1);
        System.out.println(m2);

    }
}
