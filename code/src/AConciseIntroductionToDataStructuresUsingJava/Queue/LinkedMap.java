package AConciseIntroductionToDataStructuresUsingJava.Queue;

public class LinkedMap<K,V> implements Map<K, V> {

    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        Map<String,Integer> m = new LinkedMap<>();
    }

}
