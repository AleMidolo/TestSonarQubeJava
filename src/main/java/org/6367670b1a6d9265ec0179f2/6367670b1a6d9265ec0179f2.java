import java.util.Map;

public class MyMap<K, V> implements Map<K, V> {
    // Assuming this class has a backing data structure like a HashMap
    private final Map<K, V> internalMap;

    public MyMap() {
        this.internalMap = new java.util.HashMap<>();
    }

    @Override
    public boolean containsKey(final Object key) {
        return internalMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented as well
    // For example:
    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        return internalMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return internalMap.remove(key);
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public void clear() {
        internalMap.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        internalMap.putAll(m);
    }

    @Override
    public java.util.Set<K> keySet() {
        return internalMap.keySet();
    }

    @Override
    public java.util.Collection<V> values() {
        return internalMap.values();
    }

    @Override
    public java.util.Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }
}