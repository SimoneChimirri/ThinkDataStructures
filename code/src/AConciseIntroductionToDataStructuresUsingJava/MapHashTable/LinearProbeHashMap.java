package AConciseIntroductionToDataStructuresUsingJava.MapHashTable;

import java.util.Arrays;

public class LinearProbeHashMap<K,V> implements Map<K,V>{
    private LinkedMap<K,V>[] table;
    private static final int M = 2048;
    private int dimension;
    private int size = 0;

    public LinearProbeHashMap() {
        this(M);
    }

    @SuppressWarnings("unchecked")
    public LinearProbeHashMap(int dimension) {
        this.table = (LinkedMap<K, V>[]) new LinkedMap[dimension];
        this.dimension = dimension;
    }

    public V probe(K key, V value){
        if(key == null) return null;
        int i = hash(key);
        int counter = dimension;
        while(table[i] != null && !table[i].containsKey(key) && counter >= 0){
            i = (i+1)%dimension;
            counter--;
        }
        V oldValue = null;
        if(counter >= 0 || i == hash(key)){
            if(table[i] == null) table[i] = new LinkedMap<>();
            oldValue = table[i].put(key, value);
            if(oldValue==null) size++;
        }
        return oldValue;
    }

    public V delete(K key){
        if(key==null) return null;
        int index = hash(key);
        int counter = dimension;
        while((table[index] == null || !table[index].containsKey(key)) && counter >= 0){
            index = (index+1)%dimension;
            counter--;
        }
        V oldValue = null;
        if(counter >= 0){
            oldValue = table[index].remove(key);
            table[index] = null;
            size--;
        }
        return oldValue;
    }


    @Override
    public boolean containsKey(K key) {
        if(key == null) return false;
        int index = hash(key);
        int counter = dimension;
        while((table[index] == null || !table[index].containsKey(key)) && counter >= 0){
            if(table[index] == null) table[index] = new LinkedMap<>();
            index = (index+1)%dimension;
            counter--;
        }
        return table[index].containsKey(key);
    }

    @Override
    public V get(K key) {
        if(key == null) return null;
        int index = hash(key);
        if(containsKey(key)){
            while((table[index] == null || !table[index].containsKey(key))){
                index = (index+1)%dimension;
            }
            if(table[index].containsKey(key)) return table[index].get(key);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public V put(K key, V value) {
        return probe(key,value);
    }

    @Override
    public V remove(K key) {
        return delete(key);
    }

    @Override
    public int size() {
        return this.size;
    }


    private int hash(K key){
        if(key.getClass().equals(Integer.class)) return (int)key%dimension;
        else return key.hashCode();
    }

    private int h(K key){
        return 1 + ((int)key%(dimension-1));
    }

    @Override
    public String toString() {
        return "LinearProbeHashMap{" +
                "table=" + Arrays.toString(table) +
                ", dimension=" + dimension +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args){
        LinearProbeHashMap<Integer,Integer> m1 = new LinearProbeHashMap<>(11);
        LinearProbeHashMap<Integer,Integer> m2 = new LinearProbeHashMap<>(13);

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
        System.out.println(m1.get(69));
        System.out.println(m1.get(26));
        System.out.println(m1.get(17));
        System.out.println(m1.get(0));

        //crescita del cluster in esplorazione lineare
        System.out.println(m1.hash(77));//0
        System.out.println(m1.hash(66));//0 -> 1
        System.out.println(m1.hash(54));//10
        System.out.println(m1.hash(14));//3
        System.out.println(m1.hash(32));//10 -> 0 -> 1 -> 2
     }

}
